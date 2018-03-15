package com.example.user.common;

/**
 * Created by @author wangzunhui on 2018/3/15.
 */
public enum MenuType {
    PERM("PERM"),
    MENU("MENU");

    private String code;

    public String getCode() {
        return code;
    }

    private MenuType(String code){
        this.code = code;
    }
}
