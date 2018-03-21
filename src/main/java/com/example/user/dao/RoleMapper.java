package com.example.user.dao;

import com.example.user.po.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by @author wangzunhui on 2018/3/15.
 */
@Mapper
public interface RoleMapper {
    /**
     * insert role.
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
    public int addRoleMenus(@Param("role_id")int id, @Param("menus")List<Integer> menus);
}
