package com.vmax.service;

import com.vmax.entity.Tbuser;
import com.vmax.entity.Tbuserrole;
import com.vmax.service.impl.UserRoleServiceImpl;
import com.vmax.service.impl.UserServiceImpl;
import com.vmax.utils.TbUserEnum;
import com.vmax.utils.TbUserStateEmum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRoleServiceTest {

    @Resource
    UserRoleServiceImpl userRoleService ;


    @Test
    public void insertUserRoleTest(){
        Tbuserrole tbuserrole = new Tbuserrole(1l, 1l, "王晓涛-超级管理员", 1, new Date(), new Date(), "王晓涛", "adminstrator" ) ;
        userRoleService.insert(tbuserrole) ;
    }

    @Test
    public void findRolesByUserNameTest(){
       String strUserName = "王晓涛" ;
       Set<String> setRoles = userRoleService.findRolesByUserName(strUserName) ;
       if(setRoles == null){
           System.out.println("查询结果为空");
           return ;
       }
       for(String roleIndex : setRoles){
           System.out.println(roleIndex);
       }
    }

}
