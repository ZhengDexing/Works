package com.works.web.controller;

import com.works.entity.W_User;
import com.works.entity.vo.UserVO;
import com.works.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Login {

    @Autowired
    private UserService userService = null;


    /**
     * 个人注册
     *
     * @param user User的实体
     * @return 状态及数据
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> register(HttpServletRequest request, @RequestBody UserVO user) {
        Map<String,Object> result = new HashMap<String, Object>();
        System.out.println("user = " + user);
        if (null == user.getEmail() && "".equals(user.getEmail())) {
            result.put("code", -100);
            result.put("errMsg", "邮箱不能为空！");
            result.put("data", "");
            return result;
        }
        if ( "".equals(user.getRole())) {
            result.put("code", -100);
            result.put("errMsg", "角色不能为空！");
            result.put("data", "");
            return result;
        }

        if (null == user.getPassword() && "".equals(user.getPassword())) {
            result.put("code", -100);
            result.put("errMsg", "密码不能为空！");
            result.put("data", "");
            return result;
        }
        if (null == user.getNickname() && "".equals(user.getNickname())) {
            result.put("code", -100);
            result.put("errMsg", "昵称不能为空！");
            result.put("data", "");
            return result;
        }
        result = userService.addUserRegister(request, user);
        return result;
    }
    /**
     * 用户登陆
     *
     * @param user user 实体，主要取 email 和password
     * @return 状态及数据
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse res, W_User user) {
        System.out.println(user.toString());
        return userService.findUserLogin(request, res, user.getEmail(), user.getPassword());
    }
}
