package com.squirtle.test.main.commons.voMapper;

import com.squirtle.test.main.commons.response.UserInfo;
import com.squirtle.test.main.entity.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe sys用户映射器
 * @date 2024/12/07
 */
@Mapper
public interface SysUserMapper {
    SysUserMapper INSTANCE = Mappers.getMapper(SysUserMapper.class);

    @Mappings({
            @Mapping(source = "status",target = "status", qualifiedByName = "stringToBoolean"),
            @Mapping(target = "createTime",dateFormat = "yyyy-MM-dd HH:mm:ss"),
            @Mapping(target = "age",numberFormat = "#,##0.00"),
            @Mapping(target = "password",ignore = true),
            @Mapping(target = "userName",expression = "java(sysUser.getUserName()+\"用户\")"),
            @Mapping(target = "phone",constant = "123456789")
    })
    UserInfo sysUserToSysUserInfo(SysUser sysUser);

    @Named("stringToBoolean")
    default boolean stringToBoolean(String value) {
        return "1".equals(value);
    }
}
