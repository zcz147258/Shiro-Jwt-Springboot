package com.shiro.test.service.impl;

import com.shiro.test.entity.UserRole;
import com.shiro.test.mapper.UserRoleMapper;
import com.shiro.test.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mikasa
 * @since 2020-11-20
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
