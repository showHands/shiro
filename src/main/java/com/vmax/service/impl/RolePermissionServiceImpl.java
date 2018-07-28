package com.vmax.service.impl;

import com.vmax.entity.Tbrolepermission;
import com.vmax.mapper.TbrolepermissionMapper;
import com.vmax.service.IRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@Service("rolePermissionService")
public class RolePermissionServiceImpl implements IRolePermissionService {

    @Resource
    TbrolepermissionMapper tbrolepermissionMapper ;

    @Override
    public int deleteByPrimaryKey(Long lid) {
        return tbrolepermissionMapper.deleteByPrimaryKey(lid);
    }

    @Override
    public int insert(Tbrolepermission record) {
        return tbrolepermissionMapper.insert(record);
    }

    @Override
    public Tbrolepermission selectByPrimaryKey(Long lid) {
        return tbrolepermissionMapper.selectByPrimaryKey(lid);
    }

    @Override
    public List<Tbrolepermission> selectAll() {
        return tbrolepermissionMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Tbrolepermission record) {
        return tbrolepermissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public Set<String> findPermissionsByUserName(String strUserName) {
        return tbrolepermissionMapper.findPermissionsByUserName(strUserName) ;
    }
}
