package com.vmax.service;

import com.vmax.entity.TUser;

/**
 * Created by wangxiaotao on 2018/6/28.
 */
public interface IUserService {

    public TUser findByUsername(String userName) ;

    public TUser findById(Integer id) ;
}
