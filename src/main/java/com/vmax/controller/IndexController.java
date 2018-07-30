package com.vmax.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangxiaotao on 2018/7/28.
 */
@Controller
public class IndexController extends BaseController{

    private Logger logger = LoggerFactory.getLogger(IndexController.class) ;

    @RequestMapping(value = {"admin", "admin/index"})
    public String index(){
        logger.info("跳转首页");
        return "admin/index";
    }
}
