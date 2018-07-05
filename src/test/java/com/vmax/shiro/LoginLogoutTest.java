package com.vmax.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
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
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhang", "123") ;
        subject.login(usernamePasswordToken);
        System.out.println(subject.isAuthenticated());
        subject.logout();
        System.out.println(subject.isAuthenticated());
    }

    @Test
    public void testJDBCRealm() {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory =
                new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            //4、登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5、身份验证失败
            e.printStackTrace();
        }

        //6、退出
        System.out.println(subject.isAuthenticated());
        subject.logout();
        System.out.println(subject.isAuthenticated());
    }

    /**
     * 通用化登陆逻辑
     */
    public void login(String configFile){

        Factory<SecurityManager> securityManagerFactory = new IniSecurityManagerFactory(configFile) ;
        SecurityManager securityManager = securityManagerFactory.getInstance() ;
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zhang", "123") ;
        subject.login(usernamePasswordToken);
        System.out.println(subject.isAuthenticated());
    }

    @Test
    public void testAllSuccessfulStrategyWithSuccess(){
        login("classpath:shiro-authenticator-all-success.ini");
        Subject subject = SecurityUtils.getSubject() ;

        // 得到一个身份集合，并包含了Realm验证成功的身份信息
        PrincipalCollection principalCollection = subject.getPrincipals() ;
        System.out.println(principalCollection.asList().size());
    }

    @Test(expected = UnknownAccountException.class)
    public void testAllSuccessFulStrategyWithFail(){
        login("classpath:shiro-authenticator-all-fail.ini");
        Subject subject = SecurityUtils.getSubject();

    }

    public Subject login(String configFile, String userName, String password){
        Factory<SecurityManager> securityManagerFactory = new IniSecurityManagerFactory(configFile) ;
        SecurityManager securityManager = securityManagerFactory.getInstance() ;
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        return subject ;
       /* UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userName, password) ;
        subject.login(usernamePasswordToken);
        System.out.println(subject.isAuthenticated());*/
    }


    /**
     * 角色测试
     */
    public void testHasRole(){
        login("classpath:shiro-role.ini", "zhang", "123");

    }
}
