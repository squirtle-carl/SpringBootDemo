package com.squirtle.test.main.service.impl;

import com.squirtle.test.main.commons.response.UserInfo;
import com.squirtle.test.main.commons.voMapper.SysUserMapper;
import com.squirtle.test.main.dao.SysPermissionDao;
import com.squirtle.test.main.dao.SysRoleDao;
import com.squirtle.test.main.dao.SysUserDao;
import com.squirtle.test.main.entity.SysPermission;
import com.squirtle.test.main.entity.SysRole;
import com.squirtle.test.main.entity.SysUser;
import com.squirtle.test.main.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 系统用户服务层实现类
 * @date 2024/07/15
 */
@Slf4j
@Service
public class SysUserServiceImpl implements ISysUserService {
    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysRoleDao sysRoleDao;

    @Autowired
    private SysPermissionDao sysPermissionDao;

    @Override
    public UserInfo selectUserById(String id) {
        log.info("SysUserServiceImpl.selectUserById:{}",id);
        SysUser sysUser = sysUserDao.selectUserById(id);
        return SysUserMapper.INSTANCE.sysUserToSysUserInfo(sysUser);
    }

    @Override
    public List<SysRole> findRolesByUserId(String userId) {
        return sysRoleDao.selectRoleByUserId(userId);
    }

    @Override
    public List<SysPermission> findPermissionsByRoleId(String roleId) {
        return sysPermissionDao.findPermissionsByRoleId(roleId);
    }

    @Override
    public SysUser findByUsername(String username) {
        return sysUserDao.findByUsername(username);
    }
}
