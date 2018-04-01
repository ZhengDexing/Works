package com.works.service.impl;

import com.works.common.util.CookieUtil;
import com.works.entity.W_User;
import com.works.mapper.UserMapper;
import com.works.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper = null;

    /**
     * 用户注册
     */
    public Map<String, Object> addUserRegister(W_User user) {

        Map<String, Object> result = new HashMap<String, Object>();

        W_User isRegister = userMapper.findUser2email(user.getEmail());//判断这个邮箱是否已经注册

        if (null != isRegister) {
            result.put("code", -100);
            result.put("errMsg", "此邮箱已经注册过!");
            result.put("data", "");
            return result;
        }
        try {
            userMapper.addUserRegister(user);   //插入数据库
            result.put("code", 200);
            result.put("errMsg", "success");
            result.put("data", "");
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            result.put("code", -100);
            result.put("errMsg", "插入失败");
            result.put("data", "");
            return result;
        }

    }

    /**
     * 用户登陆
     */
    public Map<String, Object> findUserLogin(HttpServletResponse res, String user_email, String password) {
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, String> find  = new HashMap<String, String>();

        find.put("user_email", user_email);
        find.put("password", password);
        W_User user = userMapper.findUserLogin(find);

        if (user == null) {
            result.put("code", -100);
            result.put("errMsg", "用户名或密码错误!");
            result.put("data", "");
            return result;
        }

        CookieUtil.addCookie(res,"",user.getUser_id());

        result.put("code", 200);
        result.put("errMsg", "success");
        result.put("data", "登陆成功!");
        return result;
    }

}
