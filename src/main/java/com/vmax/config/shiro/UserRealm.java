package com.vmax.config.shiro;

import com.vmax.entity.Tbuser;
import com.vmax.service.impl.RolePermissionServiceImpl;
import com.vmax.service.impl.RoleServiceImpl;
import com.vmax.service.impl.UserRoleServiceImpl;
import com.vmax.service.impl.UserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class UserRealm extends AuthorizingRealm {

    @Resource
    UserServiceImpl userService ;
    @Resource
    UserRoleServiceImpl userRoleService ;
    @Resource
    RolePermissionServiceImpl rolePermissionService ;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String strUserName = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userRoleService.findRolesByUserName(strUserName));
        authorizationInfo.setStringPermissions(rolePermissionService.findPermissionsByUserName(strUserName));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String strUserName = (String) authenticationToken.getPrincipal();
        Tbuser tbuser = userService.findUserByName(strUserName) ;
        if(null == tbuser){
            throw new UnknownAccountException() ; //没有找到账号
        }
        if(Boolean.TRUE.equals(tbuser.getnLock())){
            throw new LockedAccountException() ;   //账号锁定
        }
        //交给Authenticatingrealm使用CredentialsMatcher进行密码匹配，如果觉得不好可以在此判断或自定义实现
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(tbuser.getStrusername(),
                tbuser.getStrpassword(),
                ByteSource.Util.bytes(tbuser.getCredentialsSalt()),
                getName()
        );

        return authenticationInfo;
    }
}
