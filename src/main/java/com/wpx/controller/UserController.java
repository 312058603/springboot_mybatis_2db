package com.wpx.controller;

import com.wpx.entity.Reseponse;
import com.wpx.service.IUserSerivce;
import com.wpx.util.redis.ConfigUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 用户模块
 */
@RestController
@RequestMapping("/UserController")
public class UserController {

    @Resource
    private IUserSerivce userSerivce;

    /**
     * 创建验证码
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST, value = "/createVerificationCode")
    private Reseponse<String> createVerificationCode(HttpSession session) {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder(4);
        for (int i = 0; i < 4; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            code.append(ch);
        }
        Reseponse<String> reseponse = new Reseponse();
        reseponse.setCode(ConfigUtils.CODE_SUCCESS);
        reseponse.setMeassage(ConfigUtils.MESSAGE_SUCCESS);
        reseponse.setData(code.toString());
        System.out.println(reseponse);
        session.setAttribute("VerificationCode", code.toString());
        //设置session有效时间
        session.setMaxInactiveInterval(60 * 1000);
        return reseponse;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    private Map<String, Object> login(String userAccount, String userPassword, String code, HttpSession session) {
        Map<String, Object> param = new HashMap<>();
        Map<String, Object> response = new HashMap<>();
        param.put("userAccount", userAccount);
        Map<String, Object> user = userSerivce.selectUserByUserAccount(param);

        //查询用户角色
        List<String> roles = userSerivce.selectUserRole(param);
        //查询用户权限
        List<String> permissions = userSerivce.selectUserPermission(param);

        if(roles!=null){
            user.put("role",roles);
        }

        if(permissions!=null){
            user.put("permissions",permissions);
        }

        String localVerificationCode = (String) session.getAttribute("VerificationCode");
        if (user == null) {
            response.put(ConfigUtils.CODE, "400");
            response.put(ConfigUtils.MESSAGE, "账号或密码错误");
            response.put(ConfigUtils.DATA, user);
        } else if (localVerificationCode != null && !code.equals(localVerificationCode)) {
            response.put(ConfigUtils.CODE, "400");
            response.put(ConfigUtils.MESSAGE, "验证码错误");
            response.put(ConfigUtils.DATA, "未获取到数据");
        } else {
            response.put(ConfigUtils.CODE, "200");
            response.put(ConfigUtils.MESSAGE, "成功");
            response.put(ConfigUtils.DATA, user);
            //登录成功移除验证码信息
            session.removeAttribute("VerificationCode");
        }
        return response;
    }

}
