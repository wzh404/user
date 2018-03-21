package com.example.user.controller;

import com.example.user.common.ResultType;
import com.example.user.common.UserStatus;
import com.example.user.util.CryptoUtil;
import com.example.user.common.ResultObject;
import com.example.user.po.User;
import com.example.user.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by @author wangzunhui on 2018/3/12.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * add new user.
     *
     * @param user
     * @return
     */
    @RequestMapping(value="/new", method= RequestMethod.POST)
    public ResultObject add(@RequestBody User user) {
        logger.info(user.getName());
        user.setCreateBy(1);
        user.setCreateTime(new Date());
        user.setDeleteFlag("F");
        user.setRemarks("");
        user.setUtype("0");
        user.setPassword(CryptoUtil.signature("123456"));
        user.setStatus(UserStatus.NORMAL.getCode());

        int rows = userService.insert(user);
        return rows == 1 ? ResultObject.ok() : ResultObject.fail(ResultType.USER_ADD_FAILED);
    }

    /**
     * User login.
     *
     * @param loginName login name.
     * @param password user password.
     * @return
     */
    @RequestMapping(value="/login", method= {RequestMethod.POST,RequestMethod.GET})
    public ResultObject login(@RequestParam("name") String loginName,
                              @RequestParam("pwd") String password){
        User user = userService.getUserByName(loginName);
        if (user == null){
            return ResultObject.fail(ResultType.USER_LOGIN_FAILED);
        }

        if (user.deleted()){
            return ResultObject.fail(ResultType.USER_LOGIN_FAILED);
        }

        if (!user.normal()){
            return ResultObject.fail(ResultType.USER_LOGIN_FAILED);
        }

        String pwd = CryptoUtil.signature(password);
        if (!pwd.equalsIgnoreCase(user.getPassword())){
            return ResultObject.fail(ResultType.USER_LOGIN_FAILED);
        }

        return ResultObject.ok();
    }

    /**
     * add user's roles by user id.
     *
     * @param uid
     * @param roles
     * @return
     */
    @RequestMapping(value="/roles/{uid}", method= {RequestMethod.POST,RequestMethod.GET})
    public ResultObject login(@PathVariable Integer uid,
                              @RequestBody List<Integer> roles){
        int rows = userService.addRoles(uid, roles);
        return rows > 0 ? ResultObject.ok() : ResultObject.fail(ResultType.USER_REF_ROLE_FAILED);
    }

    /**
     * find user by page.
     *
     * @return
     */
    @RequestMapping(value="/users", method= {RequestMethod.GET})
    public ResultObject list(){
        Page<User> users = userService.findByPage(1, 3);
        logger.info("pages is {}", users.getTotal());
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return ResultObject.ok(pageInfo);
    }
}
