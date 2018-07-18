package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.Result;
import com.example.demo.enums.ResultEnum;
import com.example.demo.exception.DemoException;
import com.example.demo.handle.ExceptionHandle;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    Logger logger = LoggerFactory.getLogger(getClass());
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

    @Override
    @Transactional
    public Result<Map<String, Object>> get2(Integer customerId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        if (customerId == null) {
            throw new DemoException(ResultEnum.PRIMARY_SCHOOL);
        }
        String s = userDao.getById(customerId);
        map.put("phone", s);
        return ResultUtil.success(map);
    }
}
