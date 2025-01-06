package com.squirtle.test.main.commons.config.realm;

import com.squirtle.test.main.entity.SysPermission;
import com.squirtle.test.main.entity.SysRole;
import com.squirtle.test.main.entity.SysUser;
import com.squirtle.test.main.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe shiro域
 * @date 2024/12/07
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {
    @Autowired
    private ISysUserService sysUserService;

    /**
     * @param principalCollection 权限集合
     * @return {@link AuthorizationInfo }
     * @Description: 获取授权信息
     * @see PrincipalCollection
     * @see AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        List<SysRole> roles = sysUserService.findRolesByUserId(user.getId());
        for (SysRole role : roles) {
            authorizationInfo.addRole(role.getName());
            List<SysPermission> permissions = sysUserService.findPermissionsByRoleId(role.getId());
            for (SysPermission permission : permissions) {
                authorizationInfo.addStringPermission(permission.getName());
            }
        }
        return authorizationInfo;
    }

    /**
     * @param authenticationToken 认证令牌
     * @return {@link AuthenticationInfo }
     * @throws AuthenticationException 身份验证异常
     * @Description: 获取身份验证信息
     * @see AuthenticationToken
     * @see AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        log.info("MyShiroRealm.doGetAuthenticationInfo:{}",token);
        //1. 判断用户名，token中的用户信息是登录时带入进来的
        String username = token.getUsername();
        char[] password = token.getPassword();
        log.info("username:{},password:{}",username,new String(password));
        //通过账号查找用户信息
        SysUser user = sysUserService.findByUsername(token.getUsername());
        if (user == null) {
            log.error("用户不存在");
            throw new UnknownAccountException("用户不存在");
        }
        if("0".equals(user.getStatus())){
            throw new LockedAccountException("用户已被禁用，请联系管理员");
        }

        //2. 验证用户名和密码
        String userName = user.getUserName();
        String credentials = user.getPassword();
        String realName = getName();
        return new SimpleAuthenticationInfo(userName, credentials, realName);
    }
}
