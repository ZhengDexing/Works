package com.works.web.controller;

import com.works.entity.W_User;
import com.works.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class Login {

    @Autowired
    private UserService userService = null;

    /**
     * 注册
     *
     * @param user User的实体
     * @return 状态及数据
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> register(W_User user) {
        Map<String, Object> result = userService.addUserRegister(user);
        return result;
    }

    /**
     * 用户登陆
     *
     * @param user_email 邮箱
     * @param password   密码
     * @return 状态及数据
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(HttpServletResponse res, String user_email, String password) {
        Map<String, Object> result = userService.findUserLogin(res, user_email, password);
        return result;
    }
}
