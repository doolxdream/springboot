package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuxiang on 2018/7/16.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    @Transactional
    public Map<String, Object> get(Integer customerId) {
        Map<String, Object> map = new HashMap<>();
        String s = userDao.getById(customerId);
        map.put("data", s);
        map.put("respCode", "000");
        map.put("respDesc", "调用成功");
        return map;
    }
}
