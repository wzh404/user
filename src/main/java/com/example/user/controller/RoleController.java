package com.example.user.controller;

import com.example.user.common.ResultObject;
import com.example.user.common.ResultType;
import com.example.user.po.Menu;
import com.example.user.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by @author wangzunhui on 2018/3/16.
 */
public class RoleController {
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @RequestMapping(value="/menu", method= RequestMethod.POST)
    public ResultObject addMenu(@RequestBody Menu menu) {
        logger.info("insert menu");
        int rows = roleService.insert(menu);
        return rows == 1 ? ResultObject.ok() : ResultObject.fail(ResultType.MENU_ADD_FAILED);
    }

    @RequestMapping(value="/role/menus/{uid}", method= RequestMethod.POST)
    public ResultObject addRoleMenus(@PathVariable Integer uid,
                                     @RequestBody List<Integer> menus) {
        int rows = roleService.addRoleMenus(uid, menus);
        return rows > 0 ? ResultObject.ok() : ResultObject.fail(ResultType.ROLE_REF_MENU_FAILED);
    }
}
