package com.squirtle.test.main.dao;

import com.squirtle.test.main.entity.SysRole;
import com.squirtle.test.main.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 系统角色dao
 * @date 2024/12/07
 */
@Repository
public class SysRoleDao {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    public List<SysRole> selectRoleByUserId(String userId) {
        return sysRoleMapper.selectRoleByUserId(userId);
    }
}
