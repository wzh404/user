package com.example.user.po;

import com.example.user.common.UserStatus;
import lombok.Data;

/**
 * Created by @author wangzunhui on 2018/3/13.
 */
@Data
public class User extends Creator {
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
        return UserStatus.get(this.status);
    }

    public boolean normal(){
        return this.status() == UserStatus.NORMAL;
    }

    public boolean deleted(){
        return "T".equalsIgnoreCase(this.getDeleteFlag());
    }
}
