package com.vmax.shiro.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 *  shiro框架中的域， 安全数据源
 */
public class MyRealm1 implements Realm {
    @Override
    public String getName() {
        return "MyRealm1";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        //仅支持UsernamePasswordToken类型的Token
        return authenticationToken instanceof UsernamePasswordToken;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();   // 获取身份
        String password = (String) authenticationToken.getCredentials();  //获取凭证
        if(!"zhang".equals(userName) || !"123".equals(password)){
            throw new IncorrectCredentialsException() ; // 密码错误
        }
        //如果身份认证成功，返回一个AuthenticationInfo对象
        return new SimpleAuthenticationInfo(userName, password, getName()) ;
    }
}
