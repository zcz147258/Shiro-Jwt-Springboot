package com.shiro.test.service.impl;

import com.shiro.test.entity.Permission;
import com.shiro.test.entity.Role;
import com.shiro.test.entity.User;
import com.shiro.test.mapper.UserMapper;
import com.shiro.test.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.junit.Test;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mikasa
 * @since 2020-11-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public Set<String> getRoleListByName(String username) {
        Set<String> roleList = baseMapper.getRoleListByName(username);
        return roleList;
    }

    @Override
    public Set<String> getPermissionListByName(String username) {
        Set<String> PermissionList = baseMapper.getPermissionListByName(username);
        return PermissionList;
    }
}
