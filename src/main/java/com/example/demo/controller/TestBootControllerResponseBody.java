package com.example.demo.controller;

/**
 * Created by liuxiang on 2018/7/16.
 */

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/testbootResponse")
public class TestBootControllerResponseBody {
    @Autowired
    private UserService userService;

    /**
     * @param customerId
     * @return
     */
    @GetMapping("/test/{customerId}")
    @ResponseBody
    public Map<String, Object> getUser(@PathVariable("customerId") Integer customerId) {
        Map<String, Object> map = userService.get(customerId);
        return map;
    }


    /**
     * @param customerId
     * @return
     */
    @GetMapping("/test2/{customerId}")
    public String getUser2(@PathVariable("customerId") Integer customerId) {
        Map<String, Object> map = userService.get(customerId);
        return "/test";
    }
}
