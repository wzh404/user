package com.example.user.dao;

import com.example.user.po.Menu;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by @author wangzunhui on 2018/3/15.
 */
@Mapper
public interface MenuMapper {
    /**
     * insert menu.
     *
     * @param menu
     * @return
     */
    public int insert(Menu menu);
}
