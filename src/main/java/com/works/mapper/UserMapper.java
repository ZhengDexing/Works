package com.works.mapper;

import com.works.entity.Post;
import com.works.entity.UserMessage;
import com.works.entity.W_User;
import com.works.entity.vo.PostVO;
import com.works.entity.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper {
    public int addUserRegister(UserVO user);    //用户注册

    public W_User findUserLogin(Map<String, String> map); //用户登陆

    public W_User findUser2email(String email); //根据邮箱查找用户

    public UserVO findUserMessage(String user_id);//查询用户信息

    public int addUserMessage(UserVO userMessage);//插入用户信息

    public int updateUserMessage(UserMessage userMessage);//修改用户信息

    public UserVO findUserAndMessage(String user_id); //查询用户所有信息

    public int addDelivery (Map<String,Object> map); //投递岗位
}
