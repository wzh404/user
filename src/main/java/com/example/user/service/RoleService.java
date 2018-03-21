package com.example.user.service;

import com.example.user.po.Menu;
import com.example.user.po.Role;

import java.util.List;

/**
 * Created by wangzunhui on 2018/3/16.
 */
public interface RoleService {
    /**
     * add menu.
     *
     * @param menu
     * @return
     */
    public int insert(Menu menu);

    /**
     * add role.
     *
     * @param role
     * @return
     */
    public int insert(Role role);


    /**
     * add role reference menu.
     *
     * @param id  role id.
     * @param menus menu ids.
     * @return
     */
    public int addRoleMenus(int id, List<Integer> menus);
}
