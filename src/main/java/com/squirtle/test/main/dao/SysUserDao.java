package com.squirtle.test.main.dao;

import com.squirtle.test.main.entity.SysUser;
import com.squirtle.test.main.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 系统用户持久层
 * @date 2024/07/15
 */
@Repository
public class SysUserDao {

    @Autowired
    private SysUserMapper sysUserMapper;

    public SysUser selectUserById(String id) {
        return sysUserMapper.selectUserById(id);
    }

    public SysUser findByUsername(String username) {
        return sysUserMapper.findByUsername(username);
    }
}
