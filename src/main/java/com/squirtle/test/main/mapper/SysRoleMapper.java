package com.squirtle.test.main.mapper;

import com.squirtle.test.main.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 系统角色映射器
 * @date 2024/12/07
 */
@Mapper
public interface SysRoleMapper {
    List<SysRole> selectRoleByUserId(String userId);
}
