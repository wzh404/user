package com.example.user.service.impl;

import com.example.user.dao.UserMapper;
import com.example.user.po.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by @author wangzunhui on 2018/3/13.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    @Override
    public User get(Integer id) {
        return userMapper.get(id);
    }

    @Override
    public User getUserByName(String login) {
        return userMapper.getUserByName(login);
    }

    @Override
    public int changeLoginPwd(Integer id, String newPwd, String oldPwd) {
        User user = get(id);
        if (user == null) {
            return -1;
        }

        if (!oldPwd.equalsIgnoreCase(user.getPassword())){
            return -2;
        }

        return userMapper.changeLoginPwd(id, newPwd);
    }
}
