//package com.wpx.config.shiro;
//
//import com.wpx.config.DebugConfig;
//import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
//import org.apache.shiro.mgt.SecurityManager;
//import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Properties;
//
///**
// * shiro配置
// */
//@Configuration
//public class ShiroConfig {
//
//    @Bean
//    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
//        System.out.println("ShiroConfiguration.shirFilter()");
//        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        //设置未经认证的url
//        shiroFilterFactoryBean.setLoginUrl("/login");
//        //设置登录成功url
//        shiroFilterFactoryBean.setSuccessUrl("/index");
//        //设置未授权url
//        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
//        //自定义拦截器
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
//        //设置static包下的所有资源 不用登录就可以访问
//        filterChainDefinitionMap.put("/static/**", "anon");
//        //设置退出页面 shiro已经实现
//        filterChainDefinitionMap.put("/logout", "logout");
//        //设置其他页面需要登录认证通过才能访问
//        filterChainDefinitionMap.put("/**", "authc");
//        // 设置自定义拦截器
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        return shiroFilterFactoryBean;
//    }
//
//    /**
//     * 凭证匹配器凭证管理器
//     * 由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
//     *
//     * @return
//     */
//    @Bean
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//        hashedCredentialsMatcher.setHashAlgorithmName("MD5");//散列算法:这里使用MD5算法;
//        hashedCredentialsMatcher.setHashIterations(1);//散列的次数,比如散列1次,相当于 md5("123456");
//        return hashedCredentialsMatcher;
//    }
//
//    /**
//     * 配置自定义Realm
//     *
//     * @return
//     */
//    @Bean
//    public MyShiroRealm myShiroRealm() {
//        MyShiroRealm myShiroRealm = new MyShiroRealm();
//        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        return myShiroRealm;
//
//    }
//
//    /**
//     * 配置安全管理器
//     *
//     * @return
//     */
//    @Bean
//    public SecurityManager securityManager() {
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        securityManager.setRealm(myShiroRealm());
//        return securityManager;
//
//    }
//
//    /**
//     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
//     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
//     *
//     * @return
//     */
//    @Bean
//    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
//        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
//        advisorAutoProxyCreator.setProxyTargetClass(true);
//        return advisorAutoProxyCreator;
//    }
//
//    /**
//     * 开启shiro aop注解支持.
//     * 使用代理方式;所以需要开启代码支持;
//     *
//     * @param securityManager
//     * @return
//     */
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
//        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
//        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
//        return authorizationAttributeSourceAdvisor;
//    }
//
//    /**
//     * 设置未授权url
//     *
//     * @return
//     */
//    @Bean
//    public SimpleMappingExceptionResolver resolver() {
//        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();
//        Properties properties = new Properties();
//        properties.setProperty("org.apache.shiro.authz.UnauthorizedException", "/403Url");
//        resolver.setExceptionMappings(properties);
//        return resolver;
//    }
//
//}