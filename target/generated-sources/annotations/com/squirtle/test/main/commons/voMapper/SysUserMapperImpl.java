package com.squirtle.test.main.commons.voMapper;

import com.squirtle.test.main.commons.response.UserInfo;
import com.squirtle.test.main.entity.SysUser;
import java.text.SimpleDateFormat;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-07T17:29:51+0800",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class SysUserMapperImpl implements SysUserMapper {

    @Override
    public UserInfo sysUserToSysUserInfo(SysUser sysUser) {
        if ( sysUser == null ) {
            return null;
        }

        UserInfo userInfo = new UserInfo();

        userInfo.setStatus( stringToBoolean( sysUser.getStatus() ) );
        if ( sysUser.getCreateTime() != null ) {
            userInfo.setCreateTime( new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" ).format( sysUser.getCreateTime() ) );
        }
        userInfo.setAge( sysUser.getAge() );
        userInfo.setId( sysUser.getId() );
        userInfo.setAccount( sysUser.getAccount() );

        userInfo.setUserName( sysUser.getUserName()+"用户" );
        userInfo.setPhone( "123456789" );

        return userInfo;
    }
}
