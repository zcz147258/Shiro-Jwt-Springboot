package com.shiro.test.mapper;

import com.shiro.test.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mikasa
 * @since 2020-11-20
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    Set<String> getRoleListByName(String name);

    Set<String> getPermissionListByName(String name);
}
