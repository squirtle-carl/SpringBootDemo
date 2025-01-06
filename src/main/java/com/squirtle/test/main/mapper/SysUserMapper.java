package com.squirtle.test.main.mapper;

import com.squirtle.test.main.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe 系统用户表映射器
 * @date 2024/07/15
 */
@Mapper
@Repository
public interface SysUserMapper {
    SysUser selectUserById(String id);

    SysUser findByUsername(String userName);
}
