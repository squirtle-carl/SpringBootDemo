package com.squirtle.test.main.dao;

import com.squirtle.test.main.entity.SysPermission;
import com.squirtle.test.main.mapper.SysPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SysPermissionDao {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    public List<SysPermission> findPermissionsByRoleId(String roleId) {
        return sysPermissionMapper.findPermissionsByRoleId(roleId);
    }
}
