package com.vmax.service;

import com.vmax.entity.Tbrolepermission;
import com.vmax.entity.Tbuser;
import com.vmax.service.impl.RolePermissionServiceImpl;
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
public class RolePermissionServiceTest {

    @Resource
    RolePermissionServiceImpl rolePermissionService ;

    @Test
    public void insertTest(){
        Tbrolepermission tbrolepermission = new Tbrolepermission(1l, 1l, "user:query", 1, new Date(), new Date()) ;
        rolePermissionService.insert(tbrolepermission);
    }


    @Test
    public void findPermissionsByUserNameTest(){
        Set<String> permissions = rolePermissionService.findPermissionsByUserName("王晓涛") ;
        if(null == permissions){
            System.out.println("查询结果为空");
        }
        for(String permissionIndex : permissions){
            System.out.println(permissionIndex);
        }
    }

}
