package com.example.demo.controller;

/**
 * Created by liuxiang on 2018/7/16.
 */

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
public class TestBootController {
    @Autowired
    private UserService userService;


    @RequestMapping("getuser")
    public User getUser() {
        userService.get();

        User user = new User();
        user.setName("test");
        return user;
    }



}
