package com.example.user.common;

/**
 * Created by @author wangzunhui on 2018/3/15.
 */
public enum ResultType {
    OK("OK"),
    USER_LOGIN_FAILED("010001"),
    USER_ADD_FAILED("010002"),
    USER_REF_ROLE_FAILED("010003"),

    ROLE_REF_MENU_FAILED(""),
    MENU_ADD_FAILED("010101");

    private String code;

    public String getCode() {
        return code;
    }

    ResultType(String code){
        this.code = code;
    }
}
