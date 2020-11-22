package com.shiro.test.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shiro.test.entity.User;
import com.shiro.test.exception.UnAthorityException;
import com.shiro.test.service.UserService;
import com.shiro.test.utils.JWTUtil;
import com.shiro.test.utils.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.schema.Model;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mikasa
 * @since 2020-11-20
 */
@RestController
@RequestMapping("/test/user")
public class UserController {


    @Autowired
    UserService userService;

    /**
     * 根据用户token查询权限列表
     */
    @RequiresPermissions("/test/user/update")
    @PostMapping("add")
    public R add(){
        return R.ok().message("增加");
    }

    @RequiresPermissions("/test/user/update")
    @PostMapping("update")
    public R update(){
        return R.ok().message("修改");
    }

    @RequiresPermissions("/test/user/delete")
    @PostMapping("delete")
    public R delete(){
        return R.ok().message("删除");
    }

    @RequiresPermissions("/test/user/query")
    @PostMapping("query")
    public R query(){
        return R.ok().message("查询");
    }

    /**
     * 登录
     * @return
     */
    @PostMapping("login")
    public R login(String username, String password) {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return R.error().message("用户名密码不能为空");
        }
        try{
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("name", username);
            User user = userService.getOne(wrapper);

            if (user == null) {
                return R.error().message("用户名不存在");
            }

            if (password.equals(user.getMob())) {
                return R.ok().message("登录成功").data("token", JWTUtil.createToken(username));
            }else{
                return R.error().message("密码错误");
            }
        }catch (Exception e){
        }
        return R.error();
    }
}

