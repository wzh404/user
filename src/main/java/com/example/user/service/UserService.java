package com.example.user.service;

import com.example.user.po.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wangzunhui on 2018/3/13.
 */
public interface UserService {
    /**
     * add user.
     *
     * @param user
     * @return 1 success, other failed.
     */
    public int insert(User user);

    /**
     * set user del_flag to 'T'
     *
     * @param id
     * @return 1 success, other failed.
     */
    public int delete(Integer id);

    /**
     * get user by id.
     *
     * @param id
     * @return
     */
    public User get(Integer id);

    /**
     * get user by login name.
     *
     * @param login login name
     * @return user
     */
    User getUserByName(@Param("login") String login);

    /**
     * change user password by id & old password.
     *
     * @param id
     * @param newPwd
     * @param oldPwd
     * @return 1 success, other failed.
     */
    public int changeLoginPwd(Integer id, String newPwd, String oldPwd);

    /**
     * get user all permissions by id.
     *
     * @param id user id.
     * @return
     */
    List<String> permissions(int id);

    /**
     * add user roles.
     *
     * @param id
     * @param roles
     * @return
     */
    int addRoles(int id,  List<Integer> roles);

    /**
     * paging query user.
     *
     * @param page
     * @param pageSize
     * @return
     */
    Page<User> findByPage(int page, int pageSize);
}
