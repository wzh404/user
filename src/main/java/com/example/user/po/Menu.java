package com.example.user.po;

import com.example.user.common.MenuType;
import com.example.user.common.Tree;
import lombok.Data;

/**
 * Created by @author wangzunhui on 2018/3/15.
 */
@Data
public class Menu extends Creator implements Tree.Comparable{
    private Integer id;
    private Integer pid;
    private String name;
    private String url;
    private String icon;
    private String mtype;
    private String code;

    public MenuType type(){
        return MenuType.valueOf(this.mtype);
    }
}
