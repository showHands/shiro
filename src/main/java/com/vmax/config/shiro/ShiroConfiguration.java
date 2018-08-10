package com.vmax.config.shiro;

import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangxiaotao on 2018/6/28.
 * Shiro 权限管理框架配置
 */
@Configuration
public class ShiroConfiguration {


    // 授权和身份验证
    @Bean
    public UserRealm myShiroRealm(){
        return new UserRealm() ;
    }

    // 会话监听器
    @Bean
    public MySessionListener sessionListener(){
        return new MySessionListener() ;
    }

    // 会话持久化/存储
    @Bean
    public SessionDAO sessionDAO(){
        SessionDAO sessionDAO = new EnterpriseCacheSessionDAO();
        ((EnterpriseCacheSessionDAO) sessionDAO).setSessionIdGenerator(new JavaUuidSessionIdGenerator());
        ((EnterpriseCacheSessionDAO) sessionDAO).setActiveSessionsCacheName("shiro-activeSessionCache");
        return sessionDAO;
    }


    // 会话管理器
    @Bean
    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionIdCookie(new SimpleCookie());
        List<SessionListener> sessionListenerList = new ArrayList<>();
        sessionListenerList.add(new MySessionListener());
        sessionManager.setSessionListeners(sessionListenerList);
        sessionManager.setSessionDAO(sessionDAO());
       return sessionManager;
    }




    // 缓存管理器
/*    @Bean
    public CacheManager cacheManager(){
        return new EhCacheCacheManager();
    }*/

    /**
     * 安全管理器加入到容器中，以自定义的权限认证方式初始化
     * @return
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager() ;
        securityManager.setRealm(myShiroRealm());
        securityManager.setSessionManager(sessionManager());
        return securityManager ;
    }



    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean() ;
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String,String> map = new HashMap<>() ;

        //退出登陆
       /* map.put("/logout", "logout") ;
        //对所有用户认证
        map.put("*//**", "authc");
        //登陆
        shiroFilterFactoryBean.setLoginUrl("/login");
        //首页
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //错误页面，认证不通过跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/error");*/
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     * 通知器，通过拦截实现
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor ;
    }

    /**
     * cookie对象;
     * 记住密码实现起来也是比较简单的，主要看下是如何实现的。
     * @return
     */
    @Bean
    public SimpleCookie rememberMeCookie(){
        System.out.println("ShiroConfiguration.rememberMeCookie()");
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
        simpleCookie.setMaxAge(259200);
        return simpleCookie;
    }

    /**
     * cookie管理对象;
     * @return
     */
    @Bean
    public CookieRememberMeManager rememberMeManager(){
        System.out.println("ShiroConfiguration.rememberMeManager()");
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        return cookieRememberMeManager;
    }
}
