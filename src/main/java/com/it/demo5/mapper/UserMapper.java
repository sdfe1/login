package com.it.demo5.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.it.demo5.entity.User;
@Mapper
public interface UserMapper {
    //添加用户信息
    @Insert("insert into user(username,password)" + "values(#{username},#{password})")
    void insertUser(String username, String password);
    //根据用户名查询用户信息
    @Select("select * from user where username=#{username}")
    User selectUserByUsername(String username);
}
