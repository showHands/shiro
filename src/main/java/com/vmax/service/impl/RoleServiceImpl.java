package com.vmax.service.impl;

import com.vmax.entity.Tbrole;
import com.vmax.mapper.TbroleMapper;
import com.vmax.service.IRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {

    @Resource
    TbroleMapper tbroleMapper ;

    @Override
    public int deleteByPrimaryKey(Long lid) {
        return tbroleMapper.deleteByPrimaryKey(lid);
    }

    @Override
    public int insert(Tbrole record) {
        return tbroleMapper.insert(record);
    }

    @Override
    public Tbrole selectByPrimaryKey(Long lid) {
        return tbroleMapper.selectByPrimaryKey(lid);
    }

    @Override
    public List<Tbrole> selectAll() {
        return tbroleMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Tbrole record) {
        return tbroleMapper.updateByPrimaryKey(record);
    }




}
