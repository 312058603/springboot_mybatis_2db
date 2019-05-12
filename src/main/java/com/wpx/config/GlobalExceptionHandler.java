package com.wpx.config;

import javax.servlet.http.HttpServletRequest;

import com.wpx.util.redis.ConfigUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常配置
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     *
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    public Map<String, Object> allExceptionHandler(HttpServletRequest request, Exception exception) throws Exception {

        Map<String, Object> response = new HashMap<>();
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("url", request.getRequestURI());
        //获取详细异常信息
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        exception.printStackTrace(pw);
        pw.flush();
        sw.flush();
        errorMap.put("errDetailMsg", sw.toString());
        //获取基本异常信息
        errorMap.put("errMsg", exception.toString());

        response.put(ConfigUtils.CODE, "800");
        response.put(ConfigUtils.MESSAGE, "全局异常处理");
        response.put(ConfigUtils.DATA, errorMap);

        return response;
    }

}