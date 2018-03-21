package com.example.user.po;

import lombok.Data;

import java.util.Date;

/**
 * Created by @author wangzunhui on 2018/3/15.
 */
@Data
public class Creator {
    private Integer createBy;
    private Date createTime;
    private String deleteFlag;
    private String remarks;
}
