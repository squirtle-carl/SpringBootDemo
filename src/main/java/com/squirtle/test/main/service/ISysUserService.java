package com.squirtle.test.main.service;

import com.squirtle.test.main.commons.response.UserInfo;
import com.squirtle.test.main.entity.SysPermission;
import com.squirtle.test.main.entity.SysRole;
import com.squirtle.test.main.entity.SysUser;

import java.util.List;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 系统用户服务层接口
 * @date 2024/07/15
 */
public interface ISysUserService {
    UserInfo selectUserById(String id);

    List<SysRole> findRolesByUserId(String userId);

    List<SysPermission> findPermissionsByRoleId(String roleId);

    SysUser findByUsername(String username);
}
