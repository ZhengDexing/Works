package com.works.service;

import com.works.entity.UserMessage;
import com.works.entity.W_User;
import com.works.entity.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface UserService {
    public Map<String,Object> addUserRegister(HttpServletRequest request,UserVO user);    //用户注册

    public String findUserLogin(HttpServletRequest request,HttpServletResponse res, String email, String password); //用户登陆

    public Map<String,Object> updataUserMessage(UserMessage userMessage);//修改用户信息

    public Map<String,Object> getAllPost();//获取所有的岗位

    public Map<String,Object> getOnePost(String post_id);   //查询某个岗位

    public Map<String,Object> addDelivery(HttpServletRequest request,String post_id);//投递简历

    public Map<String,Object> findUserMessage (HttpServletRequest request); //查询用户的信息

    public Map<String,Object> finddelivery2User (HttpServletRequest request); //查询用户投递的岗位

    public Map<String,Object> findPostByCompany(String company_id); //查询企业下的所有岗位
}