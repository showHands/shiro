package com.vmax.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

public class LoginLogoutTest {

    @Test
    public void testHelloWorld(){
        //1、获取SecurityManager工厂，此处使用ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini") ;

        //2、得到安全管理器，并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance() ;
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token(即用户身份/凭证)
        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhang", "123") ;

        //4、登陆
        try{
            subject.login(usernamePasswordToken);
        }catch (AuthenticationException authenticationException ){
            //5、身份验证失败e
        }

        Assert.assertEquals(true, subject.isAuthenticated());   //断言用户是否已经登陆
        System.out.println(subject.isAuthenticated());

        //6、退出
        subject.logout();
        System.out.println(subject.isAuthenticated());
    }

    @Test
    public void testCustomRealm(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini") ;
        SecurityManager securityManager = factory.getInstance() ;
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject() ;
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("wangxiaotao", "123") ;
        subject.login(usernamePasswordToken);
        System.out.println(subject.isAuthenticated());
        subject.logout();
        System.out.println(subject.isAuthenticated());
    }
}
