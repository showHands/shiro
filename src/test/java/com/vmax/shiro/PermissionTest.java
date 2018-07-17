package com.vmax.shiro;

import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.junit.Test;

import java.util.Arrays;

public class PermissionTest extends BaseTest {

    @Test
    public void testIsRole(){
        login("classpath:shiro-permission.ini", "wang", "123");
        boolean ifHasRole = subject().hasRole("role1") ;
        System.out.println(ifHasRole);
        boolean ifHasAllRole = subject().hasAllRoles(Arrays.asList("role1", "role2")) ;
        System.out.println(ifHasAllRole);
        boolean[] boolArrays = subject().hasRoles(Arrays.asList("role1", "role2", "role3")) ;
        for(boolean index : boolArrays){
            System.out.println(index);
        }
    }

    @Test
    public void testIsPermitted(){
        login("classpath:shiro-permission.ini", "zhang", "123");
        System.out.println(subject().isPermitted("user:create") );
        System.out.println(subject().isPermitted("user:view")) ;
        boolean[] isPermitteds = subject().isPermitted("user:create", "user:update");
        for(boolean index : isPermitteds){
            System.out.println(index);
        }
    }
}
