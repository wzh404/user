package com.example.user.controller;

import com.example.user.common.ResultType;
import com.example.user.common.UserStatus;
import com.example.user.util.CryptoUtil;
import com.example.user.common.ResultObject;
import com.example.user.po.User;
import com.example.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by @author wangzunhui on 2018/3/12.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value="/add", method= RequestMethod.POST)
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
        return ResultObject.ok();
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
            return ResultObject.fail(ResultType.USER_LOGIN_FAILED.getCode());
        }

        if (user.isDeleted()){
            return ResultObject.fail(ResultType.USER_LOGIN_FAILED.getCode());
        }

        if (user.status() != UserStatus.NORMAL){
            return ResultObject.fail(ResultType.USER_LOGIN_FAILED.getCode());
        }

        String pwd = CryptoUtil.signature(password);
        if (!pwd.equalsIgnoreCase(user.getPassword())){
            return ResultObject.fail(ResultType.USER_LOGIN_FAILED.getCode());
        }

        return ResultObject.ok();
    }
}
