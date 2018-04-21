package com.works.service.impl;

import com.works.common.util.CookieUtil;
import com.works.common.util.Util;
import com.works.entity.Post;
import com.works.entity.UserMessage;
import com.works.entity.W_User;
import com.works.entity.vo.DeliveryVO;
import com.works.entity.vo.PostVO;
import com.works.entity.vo.UserVO;
import com.works.mapper.CompanyMapper;
import com.works.mapper.UserMapper;
import com.works.service.UserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper = null;
    @Autowired
    private CompanyMapper companyMapper;

    /**
     * 用户注册
     */
    public Map<String, Object> addUserRegister(HttpServletRequest request, UserVO user) {
        Map<String, Object> result = new HashMap<String, Object>();
        W_User isRegister = userMapper.findUser2email(user.getEmail());//判断这个邮箱是否已经注册

        if (null != isRegister) {
            result.put("code", -100);
            result.put("errMsg", "此邮箱已经注册过!");
            result.put("data", "");
            return result;
        }
        try {
            user.setUser_id(Util.getUUID());

            int a = userMapper.addUserRegister(user);   //插入用户数据库
            if (0==a){
                result.put("code", -100);
                result.put("errMsg", "插入失败！请联系管理员");
                result.put("data", "");
                return result;
            }
            int b = 0;
            switch (user.getRole()){
                case 0:
                    b = userMapper.addUserMessage(user);
                    break;
                case 1:
                    user.setCompany_id(Util.getUUID());
                    b = companyMapper.addCompany(user);
                    break;
            }

            if (b > 0) {
                result.put("code", 200);
                result.put("errMsg", "注册成功");
                result.put("data", "");
                return result;
            } else {
                result.put("code", -100);
                result.put("errMsg", "插入失败！请联系管理员");
                result.put("data", "");
                return result;
            }
        } catch (Exception e) {
            result.put("code", -100);
            result.put("errMsg", "插入失败！请联系管理员");
            result.put("data", "");
            return result;
        }

    }

    /**
     * 用户登陆
     */
    public String findUserLogin(HttpServletRequest request, HttpServletResponse res, String email, String password) {
        Map<String, Object> result = new HashMap<String, Object>();
        Map<String, Object> data = new HashMap<String, Object>();
        Map<String, String> find = new HashMap<String, String>();

        find.put("email", email);
        find.put("password", password);
        System.out.println("find = " + find.toString());
        W_User user = userMapper.findUserLogin(find);

        if (user == null) {
            request.setAttribute("error", "用户名或密码错误!");
            return "login";
        }

        CookieUtil.addCookie(res, "TOKEN", user.getUser_id());

//        ObjectMapper objectMapper = new ObjectMapper();
//        data.put("role",user.getRole());
//        data.put("nickname",user.getNickname());
//        String jsonMap =  objectMapper.writeValueAsString(data);
        String url = "";
        switch (user.getRole()) {
            case 0: //个人用户
                request.setAttribute("nickname", user.getNickname());
                url = "user";
                break;
            case 1: //企业用户
                request.setAttribute("nickname", user.getNickname());
                url = "";
                break;
            case 2: //管理员
                url = "";
                break;
        }
        return url;
    }

    /**
     * 用户填写修改用户信息
     *
     * @param userMessage 实体
     * @return 状态
     */
    public Map<String, Object> updataUserMessage(UserMessage userMessage) {
        int num = 0;
        Map<String, Object> result = new HashMap<String, Object>();
        num = userMapper.updateUserMessage(userMessage);

        if (num > 0) {
            result.put("code", 200);
            result.put("errMsg", "success");
            result.put("data", "操作成功!");
            return result;
        } else {
            result.put("code", -100);
            result.put("errMsg", "操作失败!");
            result.put("data", "");
            return result;
        }
    }

    /**
     * 获取所有岗位
     * @return
     */
    public Map<String, Object> getAllPost() {
        Map<String, Object> result = new HashMap<String, Object>();

        try{
            List<PostVO> p = companyMapper.findAllPost();
            result.put("code", 200);
            result.put("errMsg", "success");
            result.put("data", p);
        }catch (Exception e){
            System.err.println(e);
            result.put("code", -100);
            result.put("errMsg", "操作失败!");
            result.put("data", "");
        }
        return result;
    }

    /**
     * 查询 一条岗位详情
     * @param post_id 岗位id
     * @return json
     */
    public Map<String, Object> getOnePost(String post_id) {
        Map<String,Object> result = new HashMap<String, Object>();
        try{
            PostVO p = companyMapper.findOnePost(post_id);
            result.put("code", 200);
            result.put("errMsg", "success");
            result.put("data", p);
        }catch (Exception e){
            System.err.println(e);
            result.put("code", -100);
            result.put("errMsg", "操作失败!");
            result.put("data", "");
        }
        return result;
    }

    /**
     * 投递简历
     * @param request
     * @param post_id
     * @return
     */
    public Map<String, Object> addDelivery(HttpServletRequest request, String post_id) {
        Map<String,Object> result = new HashMap<String, Object>();
        Map<String,Object> map = new HashMap<String, Object>();
        String user_id = CookieUtil.getCookie(request,"TOKEN");
        if ("".equals(user_id)){
            result.put("code", -100);
            result.put("errMsg", "没获取到 Cookie");
            result.put("data", "");
            return result;
        }
        map.put("delivery_id",Util.getUUID());
        map.put("post_id",post_id);
        map.put("user_id",user_id);
        int num = userMapper.addDelivery(map);
        if (num > 0) {
            result.put("code", 200);
            result.put("errMsg", "success");
            result.put("data", "操作成功!");
            return result;
        } else {
            result.put("code", -100);
            result.put("errMsg", "操作失败!");
            result.put("data", "");
            return result;
        }

    }

    /**
     * 查询用户信息
     * @param request 获取cookie
     * @return json
     */
    public Map<String, Object> findUserMessage(HttpServletRequest request) {
        Map<String,Object> result = new HashMap<String, Object>();
        String user_id = CookieUtil.getCookie(request,"TOKEN");
        if ("".equals(user_id)){
            result.put("code", -100);
            result.put("errMsg", "没获取到 Cookie");
            result.put("data", "");
            return result;
        }
        UserVO uv = userMapper.findUserMessage(user_id);
        result.put("code", 200);
        result.put("errMsg", "success");
        result.put("data", uv);
        return result;
    }

    /**
     * 查询用户已投递的岗位
     * @param request
     * @return
     */
    public Map<String, Object> finddelivery2User(HttpServletRequest request) {
        Map<String,Object> result = new HashMap<String, Object>();
        String user_id = CookieUtil.getCookie(request,"TOKEN");
        if ("".equals(user_id)){
            result.put("code", -100);
            result.put("errMsg", "没获取到 Cookie");
            result.put("data", "");
            return result;
        }
        List<DeliveryVO> dv = companyMapper.getDelivery2User(user_id);
        result.put("code", 200);
        result.put("errMsg", "success");
        result.put("data", dv);
        return result;
    }

    /**
     * 根据企业id 查询企业发布的所有岗位
     * @param company_id
     * @return
     */
    public Map<String, Object> findPostByCompany(String company_id) {
        Map<String,Object> result = new HashMap<String, Object>();
        List<Post> postArray = companyMapper.findPostByCompany(company_id);
        result.put("code", 200);
        result.put("errMsg", "success");
        result.put("data", postArray);
        return result;
    }
}
