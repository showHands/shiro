package com.vmax.service.impl;

import com.vmax.entity.Tbpermission;
import com.vmax.mapper.TbpermissionMapper;
import com.vmax.service.IPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("permissionService")
public class PermissionServiceImpl implements IPermissionService {

    @Resource
    TbpermissionMapper tbpermissionMapper ;

    @Override
    public int deleteByPrimaryKey(Long lid) {
        return tbpermissionMapper.deleteByPrimaryKey(lid);
    }

    @Override
    public int insert(Tbpermission record) {
        return tbpermissionMapper.insert(record);
    }

    @Override
    public Tbpermission selectByPrimaryKey(Long lid) {
        return null;
    }

    @Override
    public List<Tbpermission> selectAll() {
        return tbpermissionMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Tbpermission record) {
        return tbpermissionMapper.updateByPrimaryKey(record);
    }
}
