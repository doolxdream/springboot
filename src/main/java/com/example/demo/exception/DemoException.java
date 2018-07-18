package com.example.demo.exception;

import com.example.demo.enums.ResultEnum;

/**
 * Created by liuxiang on 2018/7/18.
 */
public class DemoException extends RuntimeException {

    private Integer code;

    public DemoException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
