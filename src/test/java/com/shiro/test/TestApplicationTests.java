package com.shiro.test;

import com.shiro.test.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
class TestApplicationTests {

    @Autowired
    UserService userService;


    @Test
    void contextLoads() {
        String username = "admin";
        Set<String> permissionsList = userService.getPermissionListByName(username);
        Set<String> roleList = userService.getRoleListByName(username);

        System.out.println(permissionsList);
        System.out.println(roleList);
    }

}
