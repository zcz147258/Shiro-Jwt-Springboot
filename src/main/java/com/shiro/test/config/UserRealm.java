package com.shiro.test.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shiro.test.entity.User;
import com.shiro.test.service.UserService;
import com.shiro.test.shiro.JwtToken;
import com.shiro.test.utils.JWTUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    /**
     * 重写不报错
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     *
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("********************执行授权");
        //获取用户的用户名
//        String username = (String) principalCollection.iterator().next();
        String username = JWTUtil.getUsername(principalCollection.getPrimaryPrincipal().toString());
        //查询角色列表
        Set<String> roleList = userService.getRoleListByName(username);
        //查询权限列表
        Set<String> permissionsList = userService.getPermissionListByName(username);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roleList);
        info.setStringPermissions(permissionsList);
        return info;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("********************执行认证");
        String token = (String) authenticationToken.getPrincipal();
        if (token == null) {
            throw new AuthenticationException("token 无效！");
        }
        return new SimpleAuthenticationInfo(token, token, getName());
    }
}
