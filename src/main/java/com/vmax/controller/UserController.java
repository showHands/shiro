package com.vmax.controller;

import com.vmax.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by wangxiaotao on 2018/6/28.
 */
@Controller
@RequestMapping("/")
public class UserController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(UserController.class) ;

    @Autowired
    UserServiceImpl userService ;

    @RequestMapping(value = "welcome" , method = RequestMethod.GET)
    public String welcome(Model model){
        model.addAttribute("strUserName", "王晓涛") ;
        model.addAttribute("strPassword", "13269639602") ;
        return "welcome" ;
    }

    /**
     * 跳转登陆页面
     * @return
     */
    @RequestMapping(value = "goLogin", method = RequestMethod.GET)
    public String goLogin(){
       return "admin/login" ;
    }

    /**
     *
     * 提交登陆信息
     * @return
     */
    @RequestMapping(value = "admin/loginPost", method = RequestMethod.POST)
    public String loginPost(){
        logger.info(request.toString());

        String strUserName = (String) request.getAttribute("username");
        String strPassword = (String) request.getAttribute("password");
        if(StringUtils.isEmpty(strUserName)){
            logger.info("[loginPost:username is null]");

        }
        if(StringUtils.isEmpty(strPassword)){
            logger.info("[loginPost:password is null]");

        }

        System.out.println();
        return "admin/index" ;
    }




}
