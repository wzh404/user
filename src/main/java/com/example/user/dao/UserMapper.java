package com.example.user.dao;

import com.example.user.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by wangzunhui on 2018/3/13.
 */
@Mapper
public interface UserMapper {
    /**
     * insert user info.
     *
     * @param user user bean
     * @return rows
     */
    int insert(User user);
}
