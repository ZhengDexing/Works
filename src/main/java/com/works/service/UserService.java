package com.works.service;

import com.works.entity.W_User;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface UserService {
    public Map<String, Object> addUserRegister(W_User user);    //用户注册

    public Map<String, Object> findUserLogin(HttpServletResponse res, String user_email, String password); //用户登陆
}