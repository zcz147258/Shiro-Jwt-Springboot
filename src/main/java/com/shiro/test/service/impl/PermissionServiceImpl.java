package com.shiro.test.service.impl;

import com.shiro.test.entity.Permission;
import com.shiro.test.mapper.PermissionMapper;
import com.shiro.test.service.PermissionService;
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
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}
