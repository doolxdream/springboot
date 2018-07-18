package com.example.demo.service;

import com.example.demo.entity.Result;

import java.util.Map;

/**
 * Created by liuxiang on 2018/7/16.
 */
public interface UserService {
    Map<String, Object> get(Integer customerId);

    Result<Map<String, Object>> get2(Integer customerId) throws Exception;
}
