package com.shiro.test.service;

import com.shiro.test.entity.Permission;
import com.shiro.test.entity.Role;
import com.shiro.test.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mikasa
 * @since 2020-11-20
 */
public interface UserService extends IService<User> {
    Set<String> getRoleListByName(String username);

    Set<String> getPermissionListByName(String username);
}
