package com.it.demo5.service.Impl;

import com.it.demo5.entity.User;
import com.it.demo5.mapper.UserMapper;
import com.it.demo5.service.UserService;
import com.it.demo5.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByUsername(String username) {
        return userMapper.selectUserByUsername(username);
    }
    @Override
    public void register(String username, String password) {
        //加密
        String md5String = Md5Util.getMD5String(password);
        userMapper.insertUser(username, md5String);
    }

    @Override
    public boolean login(String username, String password) {
        //登录
        //输入用户名密码
        //是否输入
        //输入
        //判断用户名是否存在，若不存在，直接返回错误；
        // 若存在 ，判断密码是否正确
        User user = userMapper.selectUserByUsername(username);
        if (user != null) {
            String Password = Md5Util.getMD5String(password);
            return Password.equals(user.getPassword());
        }
        return false;

    }


}
