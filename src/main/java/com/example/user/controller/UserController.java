package com.example.user.controller;

import com.example.user.po.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * Created by wangzunhui on 2018/3/12.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello_world")
    public User sayHelloWorld() {
        User user = new User();
        user.setName("wangzh");
        user.setOrgID(0);
        user.setCreateBy(1);
        user.setCreateTime(new Date());
        user.setDeleteFlag("D");
        user.setEmail("wzh404@hotmail.com");
        user.setJobNumber("2008");
        user.setLogin("wzh");
        user.setPassword("123456");
        user.setMobile("13911709225");
        user.setPhoto("");

        userService.insert(user);
        return user;
    }
}
