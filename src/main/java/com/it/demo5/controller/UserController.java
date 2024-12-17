package com.it.demo5.controller;


import com.it.demo5.entity.User;
import com.it.demo5.service.UserService;
import com.it.demo5.utils.ApiResponse;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user") //声明该类的访问地址
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> register(@RequestBody User user) {

            //查询注册的用户名是否存在
            User user1 = userService.findUserByUsername(user.getUsername());
            //判断查询的用户是否存在，如果不存在则返回空
            if (user1 == null) {
                //该用户名可以使用
                userService.register(user.getUsername(), user.getPassword());
                //返回操作成功
                return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("注册成功"));
            } else {
                //该用户名不允许使用
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(ApiResponse.error("用户名已存在"));
            }
    }


    @PostMapping("/login")
    public ResponseEntity<ApiResponse<String>> login(@RequestBody User user){

            boolean loginSuccess = userService.login(user.getUsername(), user.getPassword());
            if (loginSuccess) {
                return ResponseEntity.ok(ApiResponse.success("登录成功"));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.error("用户名或密码错误"));
            }

    }
}
