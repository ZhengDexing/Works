package com.works.mapper;

import com.works.entity.W_User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper {
    public void addUserRegister(W_User user);    //用户注册

    public W_User findUserLogin(Map<String, String> map); //用户登陆

    public W_User findUser2email(String user_email); //根据邮箱查找用户
}
