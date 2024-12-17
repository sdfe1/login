package com.it.demo5.service;
import com.it.demo5.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User findUserByUsername(String username);
    //注册
    void register(String username, String password);
    //登录
    boolean login(String username,String password);
}
