package com.example.user.dao;

import com.example.user.po.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

    /**
     * get user by id.
     *
     * @param id
     * @return
     */
    User get(@Param("id")int id);

    /**
     * get user by login name.
     *
     * @param name login name
     * @return user
     */
    User getUserByName(@Param("name") String name);

    /**
     * set user del_flag to true 'T'.
     *
     * @param id
     * @return
     */
    int delete(@Param("id")int id);

    /**
     * change user password by id.
     *
     * @param id
     * @param password
     * @return
     */
    int changeLoginPwd(@Param("id")int id, @Param("password")String password);

    /**
     * get user all permissions by id.
     *
     * @param id user id.
     * @return
     */
    List<Map<String, Object>> permissions(@Param("id") int id);

    /**
     * add user roles.
     *
     * @param id
     * @param roles
     * @return
     */
    int addRoles(@Param("user_id") int id, @Param("roles") List<Integer> roles);

    /**
     * paging query user.
     *
     * @return
     */
    Page<User> findByPage();
}
