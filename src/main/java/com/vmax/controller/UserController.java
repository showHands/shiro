package com.vmax.controller;

import com.vmax.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
        /*model.addAttribute("strUserName", "王晓涛") ;
        model.addAttribute("strPassword", "13269639602") ;*/
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            return "admin/index";
        }
        return "gologin" ;
    }

    /**
     * 跳转登陆页面
     * @return
     */
    @RequestMapping(value = "gologin", method = RequestMethod.GET)
    public String goLogin(){
       return "admin/login" ;
    }

    /**
     *
     * 提交登陆信息
     * @return
     */
    @RequestMapping(value = "admin/loginpost", method = RequestMethod.POST)
    public String loginPost(){
        logger.info(request.toString());

        String strUserName =  request.getParameter("username");
        String strPassword =  request.getParameter("password");
        if(StringUtils.isEmpty(strUserName)){
            logger.error("[loginPost:username is null]");
        }
        if(StringUtils.isEmpty(strPassword)){
            logger.error("[loginPost:password is null]");
        }
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        try{
            UsernamePasswordToken token = new UsernamePasswordToken(strUserName, strPassword);
            // 执行认证登陆
            subject.login(token);
        }catch (UnknownAccountException e1){
            logger.error("用户登陆：用户名或密码错误");
            return "admin/login" ;
        }catch (LockedAccountException e2){
            logger.error("用户登陆：账号被锁定");
            return "admin/login";
        }
        // 登陆成功
        logger.info("用户登陆成功：[username:"+strUserName+"] ");
        return "index" ;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(){
        return "admin/logout";
    }
}
