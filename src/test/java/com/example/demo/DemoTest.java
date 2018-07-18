package com.example.demo;

import com.example.demo.service.UserService;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * Created by liuxiang on 2018/7/18.
 *
 * 接口测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {

    @Autowired
    private UserService userService;

    public void getTest() {
        Map<String, Object> s = userService.get(73);
        //断言
        Assert.assertEquals(new Integer(13), s);
    }
}
