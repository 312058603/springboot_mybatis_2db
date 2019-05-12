//package com.wpx.controller;
//
//import com.wpx.util.redis.ConfigUtils;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.annotation.RequiresPermissions;
//import org.apache.shiro.authz.annotation.RequiresRoles;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.Subject;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by GM-KF007 on 2019/1/23.
// */
//@Controller
////如果不想返回视图,需要用@RestController
//public class ShiroController {
//
//    /**
//     * loginUrl:只要请求资源任何位置的一个未经认证的用户请求,都会被拦截并统一进入loginUrl配置的路径进行认证
//     *
//     * @return
//     */
//    @RequestMapping(value = "/login")
//    public String loginUrl() {
//        return "/login";
//    }
//
//    @RequestMapping(value = "/login")
//    public Map<String, Object> login(String userAccount,String userPassword) {
//                System.out.println("login");
//        Subject subject = SecurityUtils.getSubject();
//        //这里传递密码明文 例如测试用户: wpx 123456
//        UsernamePasswordToken token = new UsernamePasswordToken("wpx", "123456");
//        try {
//            subject.login(token);
//        } catch (AuthenticationException e) {
//            e.printStackTrace();
//        }
//        System.out.println("用户认证状态:" + subject.isAuthenticated());
//        Session session = SecurityUtils.getSubject().getSession();
//        Map<String, Object> user = (Map<String, Object>) session.getAttribute("user");
//        Map<String, Object> response = new HashMap<>();
//        if (user != null) {
//            response.put(ConfigUtils.CODE, "200");
//            response.put(ConfigUtils.MESSAGE, "成功");
//            response.put(ConfigUtils.DATA, user);
//        }
//        return response;
//    }
//
//
//    /**
//     * 测试访问static文件夹下面的静态资源
//     *
//     * @return
//     */
//    @RequestMapping(value = "/static")
//    public String testStatic() {
//        System.out.println("test Static");
//        return "redirect:/test.html";
//    }
//
//    /**
//     * 测试登出
//     *
//     * @return
//     */
//    @RequestMapping(value = "/logout")
//    public String logout() {
//        System.out.println("logout");
//        Subject subject = SecurityUtils.getSubject();
//        subject.logout();
//        System.out.println("用户当前认证状态:" + subject.isAuthenticated());
//        return "/logout";
//    }
//
//
//    /**
//     * 测试成功页面
//     * successUrl:是用户认证通过后将要跳转的请求或者资源位置,通常不用配置,认证通过以后会自动跳转进入上一次请求的路径。
//     * 比如:第一次请求路径为:localhost:8080/LZB/login.action,这时候因为用户没有认证,所以会拦截到登录页面:localhost:8080/LZB/login.jsp
//     * (也就是loginUrl配置的路径进行认证)进行登录认证，那么认证通过后会自动跳转上一次的请求路径,也就是再次请求localhost:8080/LZB/login.action
//     * 而这时候认证通过了，所以请求不会被拦截.
//     * @return
//     */
//    @RequestMapping(value = "/index")
//    public String index() {
//        System.out.println("index");
//        return "/index";
//    }
//
//    /**
//     * 测试未授权页面
//     *
//     * @return
//     */
//    @RequestMapping(value = "/403")
//    public String test403() {
//        System.out.println("403");
//        return "/403";
//    }
//
//    /**
//     * 测试权限
//     *
//     * @return
//     */
//    @RequestMapping(value = "/testInsert")
//    @ResponseBody
//    @RequiresPermissions(value = {"insert"})
//    public String testInsert() {
//        System.out.println("testInsert");
//        return "testInsert";
//    }
//
//    /**
//     * 测试权限
//     *
//     * @return
//     */
//    @RequestMapping(value = "/testQuery")
//    @ResponseBody
//    @RequiresPermissions(value = {"query"})
//    public String testQuery() {
//        System.out.println("testQuery");
//        return "testQuery";
//    }
//
//    /**
//     * 测试角色
//     *
//     * @return
//     */
//    @RequestMapping(value = "/testAdmin")
//    @ResponseBody
//    @RequiresRoles(value = {"admin"})
//    public String testAdmin() {
//        System.out.println("testAdmin");
//        return "testAdmin";
//    }
//
//    /**
//     * 测试角色
//     *
//     * @return
//     */
//    @RequestMapping(value = "/testMarketer")
//    @ResponseBody
//    @RequiresRoles(value = {"marketer"})
//    public String testMarketer() {
//        System.out.println("testMarketer");
//        return "testMarketer";
//    }
//
//    /**
//     * 测试角色
//     *
//     * @return
//     */
//    @RequestMapping(value = "/testInstaller")
//    @ResponseBody
//    @RequiresRoles(value = {"installer"})
//    public String testInstaller() {
//        System.out.println("testInstaller");
//        return "testInstaller";
//    }
//
//
//}
