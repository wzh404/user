package com.example.user.po;

import com.example.user.common.MenuType;
import lombok.Data;

/**
 * Created by @author wangzunhui on 2018/3/15.
 */
@Data
public class Menu extends Create{
    private Integer id;
    private String name;
    private Integer pid;
    private String url;
    private String icon;
    private String mtype;
    private String code;

    public MenuType type(){
        return MenuType.valueOf(this.mtype);
    }
}
