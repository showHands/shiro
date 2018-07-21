package com.vmax.service.impl;

import com.vmax.entity.Tbuserrole;
import com.vmax.mapper.TbuserroleMapper;
import com.vmax.service.IUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service("userRoleService")
public class UserRoleServiceImpl implements IUserRoleService {

    @Resource
    TbuserroleMapper tbuserroleMapper ;

    @Override
    public int deleteByPrimaryKey(Long lid) {
        return tbuserroleMapper.deleteByPrimaryKey(lid);
    }

    @Override
    public int insert(Tbuserrole record) {
        return tbuserroleMapper.insert(record);
    }

    @Override
    public Tbuserrole selectByPrimaryKey(Long lid) {
        return tbuserroleMapper.selectByPrimaryKey(lid);
    }

    @Override
    public List<Tbuserrole> selectAll() {
        return tbuserroleMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Tbuserrole record) {
        return tbuserroleMapper.updateByPrimaryKey(record);
    }

    @Override
    public Set<String> findRolesByUserName(String strUserName) {
        return  tbuserroleMapper.findRolesByUserName(strUserName.trim()) ;
    }
}
