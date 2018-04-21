package com.works.web.controller.user;

import com.works.common.util.CookieUtil;
import com.works.common.util.Util;
import com.works.entity.UserMessage;
import com.works.entity.vo.UserVO;
import com.works.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService = null;

    /**
     * 修改用户信息
     *
     * @param req         获取cookie中的TOKEN
     * @param userMessage 用户详细信息
     * @return 状态
     */
    @RequestMapping(value = "/updateUsermessage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateUserMessage(HttpServletRequest req, @RequestBody UserMessage userMessage) {
        Map<String, Object> result = new HashMap<String, Object>();
        String user_id = CookieUtil.getCookie(req, "TOKEN");
        if ("".equals(user_id)) {
            result.put("code", -100);
            result.put("errMsg", "参数不合法!");
            result.put("data", "");
            return result;
        }
        userMessage.setUser_id(user_id);
        result = userService.updataUserMessage(userMessage);
        return result;
    }

    /**
     * 获取所有岗位信息
     *
     * @return json
     */
    @RequestMapping(value = "/getAllPost", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllPost() {
        return userService.getAllPost();
    }

    /**
     * 获取某一岗位信息
     * @param post_id
     * @return
     */
    @RequestMapping(value = "/getOnePost",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getOnePost(String post_id){
        return userService.getOnePost(post_id);
    }

    /**
     * 投递简历
     * @param request 获取cookie
     * @param post_id 岗位id
     * @return json
     */
    @RequestMapping(value = "/addDelivery",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addDelivery(HttpServletRequest request,String post_id){
        return userService.addDelivery(request,post_id);
    }

    /**
     * 查询用户信息
     * @param request 获取cookie
     * @return json
     */
    @RequestMapping(value = "/findUserMessage",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> findUserMessage(HttpServletRequest request){
        return userService.findUserMessage(request);
    }

    /**
     * 查询用户已投递的岗位
     * @param request 获取cookie
     * @return json
     */
    @RequestMapping(value = "/finddelivery2User",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> finddelivery2User(HttpServletRequest request){
        return userService.finddelivery2User(request);
    }

    /**
     * 查询企业下的所有岗位
     * @param company_id
     * @return
     */
    @RequestMapping(value = "/findPostByCompany",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> findPostByCompany(String company_id){
        return userService.findPostByCompany(company_id);
    }

}
