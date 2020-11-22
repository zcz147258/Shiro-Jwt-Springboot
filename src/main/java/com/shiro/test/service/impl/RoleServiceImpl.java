package com.shiro.test.service.impl;

import com.shiro.test.entity.Role;
import com.shiro.test.mapper.RoleMapper;
import com.shiro.test.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
