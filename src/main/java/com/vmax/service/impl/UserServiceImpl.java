package com.vmax.service.impl;

import com.vmax.entity.TUser;
import com.vmax.mapper.TUserMapper;
import com.vmax.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

/**
 * Created by wangxiaotao on 2018/6/28.
 */
@Service("userService")
public class UserServiceImpl implements IUserService{

    @Resource
    TUserMapper tUserMapper ;

    @Override
    public TUser findByUsername(String userName) {
        return tUserMapper.selectByUserName(userName) ;
    }

    @Override
    public TUser findById(Integer id) {
        return tUserMapper.selectByPrimaryKey(id);
    }


}
