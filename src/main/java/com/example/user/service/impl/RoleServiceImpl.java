package com.example.user.service.impl;

import com.example.user.dao.MenuMapper;
import com.example.user.dao.RoleMapper;
import com.example.user.po.Menu;
import com.example.user.po.Role;
import com.example.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by @author wangzunhui on 2018/3/16.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int insert(Menu menu) {
        return menuMapper.insert(menu);
    }

    @Override
    public int insert(Role role) {
        return roleMapper.insert(role);
    }

    @Override
    public int addRoleMenus(int id, List<Integer> menus) {
        return roleMapper.addRoleMenus(id, menus);
    }
}
