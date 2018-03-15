package com.example.user.po;

import com.example.user.common.UserStatus;
import lombok.Data;

/**
 * Created by @author wangzunhui on 2018/3/13.
 */
@Data
public class User extends Create{
    private Integer id;
    private Integer orgID;
    private String name;
    private String login;
    private String password;
    private String jobNumber;
    private String utype;
    private String photo;
    private String email;
    private String mobile;
    private String phone;
    private String status;

    public UserStatus status(){
        return UserStatus.valueOf(this.status);
    }

    public boolean isDeleted(){
        return "T".equalsIgnoreCase(this.getDeleteFlag());
    }
}
