package com.vmax.controller;

import com.vmax.entity.TUser;
import com.vmax.mapper.TUserMapper;
import com.vmax.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangxiaotao on 2018/6/28.
 */
@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserServiceImpl userService ;

   /* @RequestMapping("login")
    @ResponseBody
    public String index(){
        TUser user = userService.findById(1) ;
        if(null == user){
            return "用户查询为空";
        }
        return user.toString();
    }*/




}