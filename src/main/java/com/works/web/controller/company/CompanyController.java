package com.works.web.controller.company;

import com.works.common.util.CookieUtil;
import com.works.entity.Company;
import com.works.entity.Post;
import com.works.entity.vo.UserVO;
import com.works.service.CompanyServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyServer companyServer;


    /**
     * 修改企业信息
     * @param company 获取json对应的参数
     * @return map
     */
    @RequestMapping(value = "/updateCompany", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateCompany(@RequestBody Company company){
        return companyServer.updateCompany(company);
    }

    /**
     * 发布岗位
     * @param post
     * @return
     */
    @RequestMapping(value = "/addPost",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addPost(@RequestBody Post post){
        return companyServer.addPost(post);
    }

    /**
     * 查询已发布的岗位
     * @param req 请求
     * @return json
     */
    @RequestMapping(value = "/findPoat",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> findPoat(HttpServletRequest req){
        return companyServer.findPost(req);
    }

    /**
     * 查询所有求职者
     * @param req
     * @return
     */
    @RequestMapping(value = "/findDelivery",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> findDelivery(HttpServletRequest req){
        return companyServer.findDelivery(req);
    }

    /**
     * 查看求职者详情
     * @param user_id 求职者id
     * @return json
     */
    @RequestMapping(value = "/findUserAllMessage",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> findUserAllMessage(String user_id){
        return companyServer.findUserAllMessage(user_id);
    }

    /**
     * 修改岗位信息
     * @param post_id 岗位id
     * @return json
     */
    @RequestMapping(value = "/updatePost",method = RequestMethod.POST)
    @ResponseBody
    public  Map<String,Object> updatePost(String post_id){
        return companyServer.updatePost(post_id);
    }
}
