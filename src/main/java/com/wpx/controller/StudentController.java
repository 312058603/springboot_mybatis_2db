package com.wpx.controller;


import com.wpx.service.IStudentService;
import com.wpx.util.redis.ConfigUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学生模块
 */
@RestController
@RequestMapping("/StudentController")
public class StudentController {

    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Resource
    private IStudentService studentService;

    @RequestMapping(method = RequestMethod.POST, value = "/insertStudent")
    private Map<String, Object> insertStudent(@RequestBody Map<String, String> student) {

        Map<String, Object> response = new HashMap<>();
        Map<String, Object> pargram = new HashMap<>();

        String studentName = student.get("studentName");
        int studentAge = Integer.parseInt(student.get("studentAge"));
        int studentHeight = Integer.parseInt(student.get("studentHeight"));
        int studentWeight = Integer.parseInt(student.get("studentWeight"));
        int studentSex = Integer.parseInt(student.get("studentSex"));
        String studentHobby = student.get("studentHobby");
        String studentAddress = student.get("studentAddress");

        pargram.put("studentName", studentName);
        pargram.put("studentAge", studentAge);
        pargram.put("studentHeight", studentHeight);
        pargram.put("studentWeight", studentWeight);
        pargram.put("studentSex", studentSex);
        pargram.put("studentHobby", studentHobby);
        pargram.put("studentAddress", studentAddress);

        int count = studentService.insertStudent(pargram);

        System.out.println(count);
        if (count > 0) {
            response.put(ConfigUtils.CODE, "200");
            response.put(ConfigUtils.MESSAGE, "成功");
            response.put(ConfigUtils.DATA, pargram.get("studentId"));
        } else {
            response.put(ConfigUtils.CODE, "400");
            response.put(ConfigUtils.MESSAGE, "失败");
            response.put(ConfigUtils.DATA, "添加数据失败");
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteStudentById")
    private Map<String, Object> deleteStudentById(int studentId) {
        Map<String, Object> response = new HashMap<>();

        Map<String, Object> pargram = new HashMap<>();
        pargram.put("studentId",studentId);

        Integer count = studentService.deleteStudentById(pargram);
        if (count > 0) {
            response.put(ConfigUtils.CODE, "200");
            response.put(ConfigUtils.MESSAGE, "成功");
            response.put(ConfigUtils.DATA, count);
        } else {
            response.put(ConfigUtils.CODE, "400");
            response.put(ConfigUtils.MESSAGE, "失败");
            response.put(ConfigUtils.DATA, "删除数据失败");
        }
        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/deleteStudentByIds")
    private Map<String, Object> deleteStudentByIds(String Ids) {
        Map<String, Object> response = new HashMap<>();
        String[] studentIds=Ids.split(",");

        Map<String, Object> pargram = new HashMap<>();
        pargram.put("studentIds",studentIds);

        int count=studentService.deleteStudentByIds(pargram);

        if (count > 0) {
            response.put(ConfigUtils.CODE, "200");
            response.put(ConfigUtils.MESSAGE, "成功");
            response.put(ConfigUtils.DATA, count);
        } else {
            response.put(ConfigUtils.CODE, "400");
            response.put(ConfigUtils.MESSAGE, "失败");
            response.put(ConfigUtils.DATA, "批量删除数据失败");
        }

        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updateStudentById")
    private Map<String, Object> updateStudentById(@RequestBody Map<String, String> student) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> pargram = new HashMap<>();

        int studentId = Integer.parseInt(student.get("studentId"));
        String studentName = student.get("studentName");
        int studentAge = Integer.parseInt(student.get("studentAge"));
        int studentHeight = Integer.parseInt(student.get("studentHeight"));
        int studentWeight = Integer.parseInt(student.get("studentWeight"));
        int studentSex = Integer.parseInt(student.get("studentSex"));
        String studentHobby = student.get("studentHobby");
        String studentAddress = student.get("studentAddress");

        pargram.put("studentId", studentId);
        pargram.put("studentName", studentName);
        pargram.put("studentAge", studentAge);
        pargram.put("studentHeight", studentHeight);
        pargram.put("studentWeight", studentWeight);
        pargram.put("studentSex", studentSex);
        pargram.put("studentHobby", studentHobby);
        pargram.put("studentAddress", studentAddress);

        int count = studentService.updateStudentById(pargram);
        if (count > 0) {
            response.put(ConfigUtils.CODE, "200");
            response.put(ConfigUtils.MESSAGE, "成功");
            response.put(ConfigUtils.DATA, count);
        } else {
            response.put(ConfigUtils.CODE, "400");
            response.put(ConfigUtils.MESSAGE, "失败");
            response.put(ConfigUtils.DATA, "更新数据失败");
        }

        return response;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/selectStudentByPageIndex")
    private Map<String, Object> selectStudentByPageIndex(int pageIndex, int pageSize,String sortName,String sortOrder,String like) {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> pargram = new HashMap<>();

        pargram.put("pageIndex", pageIndex);
        pargram.put("pageSize", pageSize);
        pargram.put("sortName", sortName);
        pargram.put("sortOrder", sortOrder);
        pargram.put("like", like);

        int count = studentService.selectStudentCount();
        List<Map<String, Object>> studentList = studentService.selectStudentByPageIndex(pargram);

        Map<String, Object> resultMap=new HashMap<>();
        resultMap.put("count",count);
        resultMap.put("studentList",studentList);

        if (studentList != null && studentList.size() > 0) {
            response.put(ConfigUtils.CODE, "200");
            response.put(ConfigUtils.MESSAGE, "成功");
            response.put(ConfigUtils.DATA, resultMap);
        } else {
            response.put(ConfigUtils.CODE, "400");
            response.put(ConfigUtils.MESSAGE, "失败");
            response.put(ConfigUtils.DATA, "获取数据失败");
        }

        return response;
    }

}
