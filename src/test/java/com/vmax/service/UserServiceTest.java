package com.vmax.service;

import com.vmax.entity.Tbuser;
import com.vmax.service.impl.UserServiceImpl;
import com.vmax.utils.TbUserEnum;
import com.vmax.utils.TbUserStateEmum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {

    @Resource
    UserServiceImpl userService ;

    @Test
    public void insertUserTest(){
        Tbuser tbuser = new Tbuser() ;
        tbuser.setStrusername("王晓涛");
        tbuser.setDtcreatetime(new Date());
        tbuser.setDtmodifytime(new Date());
        tbuser.setNidentity(TbUserEnum.IDENTIFIER_ADMINSTRATOR.getnIdentifier());
        tbuser.setNstate(TbUserStateEmum.STATE_AUDIT_SUCCESS.getnState());
        tbuser.setStremali("13269639602@163.com");
        tbuser.setStrphone("13269639602");
        tbuser.setStrpassword("abc123");
        tbuser.setStrsalt("admin");
        tbuser.setStrlogourl("www.baidu.com");
        userService.insert(tbuser) ;

    }

}
