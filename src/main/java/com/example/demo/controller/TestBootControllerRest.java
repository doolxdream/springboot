package com.example.demo.controller;

/**
 * Created by liuxiang on 2018/7/16.
 */

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/testboot")
public class TestBootControllerRest {
    @Autowired
    private UserService userService;

    Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private User user;


    /**
     * restful风格
     *
     * @param customerId
     * @return
     */
    @GetMapping("/test/{customerId}")
    public Map<String, Object> getUser(@PathVariable("customerId") Integer customerId) {
        Map<String, Object> map = userService.get(customerId);
        logger.info(user.getUserName()+","+user.getUserAge());
        return map;
    }
}
