package com.example.demo.dao;

import org.apache.ibatis.annotations.Param;

/**
 * Created by liuxiang on 2018/7/16.
 */
public interface UserDao {


    String getById(int i);

    void save(@Param("caiId") int i, @Param("caiAvail") String a);
}
