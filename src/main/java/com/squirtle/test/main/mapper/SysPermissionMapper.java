package com.squirtle.test.main.mapper;

import com.squirtle.test.main.entity.SysPermission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe sys权限映射器
 * @date 2024/12/07
 */
@Mapper
public interface SysPermissionMapper {
    List<SysPermission> findPermissionsByRoleId(String roleId);
}
