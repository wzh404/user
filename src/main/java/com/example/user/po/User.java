package com.example.user.po;

import lombok.Data;

import java.util.Date;

/**
 * Created by @Author wangzunhui on 2018/3/13.
 */
@Data
public class User {
    private Integer id;
    private Integer orgID;
    private String name;
    private String login;
    private String password;
    private String jobNumber;
    private String userType;
    private String photo;
    private String email;
    private String mobile;
    private String phone;

    private Integer createBy;
    private Date createTime;
    private String deleteFlag;
    private String remarks;
}
