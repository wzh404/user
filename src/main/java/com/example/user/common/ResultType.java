package com.example.user.common;

/**
 * Created by wangzunhui on 2018/3/15.
 */
public enum ResultType {
    OK("OK"),
    USER_LOGIN_FAILED("010001");

    private String code;

    public String getCode() {
        return code;
    }

    private ResultType(String code){
        this.code = code;
    }
}
