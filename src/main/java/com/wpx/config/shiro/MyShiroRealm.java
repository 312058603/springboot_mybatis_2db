//package com.wpx.config.shiro;
//
//
//import com.wpx.config.DebugConfig;
//import com.wpx.service.UserService;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.util.ByteSource;
//
//import javax.annotation.Resource;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class MyShiroRealm extends AuthorizingRealm {
//
//    @Resource
//    private UserService userService;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        System.out.println("授权处理");
//        //从本地session中查询用户数据
//        Session session = SecurityUtils.getSubject().getSession();
//        Map<String, Object> user = (Map<String, Object>) session.getAttribute("user");
//        //设置用户信息
//        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        //添加用户角色
//        authorizationInfo.addRoles((Collection<String>) user.get("roles"));
//        //添加用户权限
//        authorizationInfo.addStringPermissions((Collection<String>) user.get("permissions"));
//        return authorizationInfo;
//    }
//
//    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        System.out.println("认证处理");
//        //获取用户的输入的账号.
//        String useAccount = (String) token.getPrincipal();
//        //实际项目中，这里可以根据实际情况做缓存,如果不做,Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
//        Map<String, Object> param = new HashMap<>();
//        param.put("userAccount", useAccount);
//        //查询用户
//        Map<String, Object> user = userService.selectUserByUserAccount(param);
//        //查询用户角色
//        List<String> roles = userService.selectUserRole(user);
//        //查询用户权限
//        List<String> permissions = userService.selectUserPermission(user);
//
//        if (roles != null) {
//            user.put("roles", roles);
//        }
//        if (permissions != null) {
//            user.put("permissions", permissions);
//        }
//
//        //将用户数据存储在本地session中
//        Session session = SecurityUtils.getSubject().getSession();
//        session.setAttribute("user", user);
//
//        System.out.println("----->>user=" + user);
//        if (user == null) {
//            return null;
//        }
//
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
//                user, //用户名
//                user.get("userPassword"), //数据库存储的已经加密后的密码值 例如"wpx123456" 现在应该存储的是"6feeabb1f6fdaa1aa6d1e0ee6a3b4632"
//                ByteSource.Util.bytes("wpx"),//wpx
//                getName()//realm name
//        );
//        return authenticationInfo;
//    }
//
//}