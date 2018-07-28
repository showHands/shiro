package com.vmax.config.shiro;

import com.vmax.entity.Tbuser;
import com.vmax.service.impl.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangxiaotao on 2018/6/28.
 * 授权认证
 */
public class WeimaiRealm extends AuthorizingRealm {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 权限认证
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        return null;
    }

    /**
     * 登陆认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        if(org.springframework.util.StringUtils.isEmpty(userName)){
            return null ;
        }

        //根据用户名查询用户信息
        Tbuser tUser = userService.findUserByName(userName);
        if(null == tUser){
            return null ;
        }
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(tUser.getStrusername(), tUser.getStrpassword(), "xxx") ;

        return authenticationInfo;
    }
}
