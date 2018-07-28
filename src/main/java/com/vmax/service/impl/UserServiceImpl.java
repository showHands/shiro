package com.vmax.service.impl;

import com.vmax.entity.TUser;
import com.vmax.entity.Tbuser;
import com.vmax.mapper.TUserMapper;
import com.vmax.mapper.TbuserMapper;
import com.vmax.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.util.List;

/**
 * Created by wangxiaotao on 2018/6/28.
 */
@Service("userService")
public class UserServiceImpl implements IUserService{

    @Resource
    TbuserMapper tbuserMapper ;


    @Override
    public int deleteByPrimaryKey(Long lid) {
        return tbuserMapper.deleteByPrimaryKey(lid);
    }

    @Override
    public int insert(Tbuser record) {
        return tbuserMapper.insert(record);
    }

    @Override
    public Tbuser selectByPrimaryKey(Long lid) {
        return tbuserMapper.selectByPrimaryKey(lid);
    }

    @Override
    public List<Tbuser> selectAll() {
        return tbuserMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Tbuser record) {
        return tbuserMapper.updateByPrimaryKey(record);
    }

    @Override
    public Tbuser createUser(Tbuser tbuser) {
        // 加密密码

        return null;
    }

    @Override
    public Tbuser findUserByName(String strUserName) {
        return tbuserMapper.findUserByName(strUserName) ;
    }

    @Override
    public Tbuser findUsrByPhone(String strPhone) {
        return tbuserMapper.findUsrByPhone(strPhone);
    }

}
