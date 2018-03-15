package com.example.user.common;

/**
 * Created by @author wangzunhui on 2018/3/15.
 */
public enum UserStatus {
    NORMAL("NORMAL");

    private String code;

    public String getCode() {
        return code;
    }

    private UserStatus(String code){
        this.code = code;
    }
}
