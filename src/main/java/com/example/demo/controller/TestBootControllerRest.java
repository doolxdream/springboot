package com.example.demo.controller;

/**
 * Created by liuxiang on 2018/7/16.
 */

import com.example.demo.entity.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultUtil;
import com.example.demo.vo.TestToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
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
     * @PathVariable不能省 注意和以下方法的区别
     */
    @GetMapping("/test3/{customerId}")
    public Result<Map<String, Object>> getUser(@PathVariable("customerId") Integer customerId) throws Exception {
        return userService.get2(customerId);
    }


    /**
     * 不加@PathVariable
     *
     * @return
     */
    @GetMapping("/test3/{customerId}/{token}/{age}")
    public Map<String, Object> getUser2(@Valid TestToken tt, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            logger.error("参数错误，" + bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        Map<String, Object> map = userService.get(tt.getAge());
        logger.info(user.getUserName() + "," + user.getUserAge());
        return map;
    }

    /**
     * 重载
     *
     * @return
     */
    @GetMapping("/test3/{customerId}/{token}")
    public Map<String, Object> getUser3(@Valid TestToken tt, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            logger.error("参数错误，" + bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        Map<String, Object> map = userService.get(tt.getAge());
        logger.info(user.getUserName() + "," + user.getUserAge());
        return map;
    }

    /**
     * 上传图片
     *
     * @return
     */
    @PostMapping("/test4/{customerId}")
    public Map<String, Object> getUser4(@RequestParam MultipartFile file, @PathVariable Integer customerId) {
        Map<String, Object> map = userService.get(customerId);

        logger.info("原始文件名称：" + file.getOriginalFilename());

        return map;
    }


}
