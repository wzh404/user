package com.example.user.po;

import com.example.user.common.Tree;
import lombok.Data;

/**
 * Created by @author wangzunhui on 2018/3/30.
 */
@Data
public class Organization extends Creator implements Tree.Comparable{
    private Integer id;
    private Integer pid;
    private String name;
}
