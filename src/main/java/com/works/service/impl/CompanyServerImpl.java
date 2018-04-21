package com.works.service.impl;

import com.works.common.util.CookieUtil;
import com.works.common.util.Util;
import com.works.entity.Company;
import com.works.entity.Post;
import com.works.entity.vo.CompanyVo;
import com.works.entity.vo.UserDeliveryVO;
import com.works.entity.vo.UserVO;
import com.works.mapper.CompanyMapper;
import com.works.mapper.UserMapper;
import com.works.service.CompanyServer;
import com.works.service.UserService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyServerImpl implements CompanyServer {
    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private UserMapper userMapper;

    /**
     * 修改企业信息
     * @param company 数据库实体映射
     * @return map
     */
    public  Map<String, Object> updateCompany(Company company) {
        Map<String, Object> result = new HashMap<String, Object>();
        int num = companyMapper.updateCompany(company);
        if (num > 0) {
            result.put("code", 200);
            result.put("errMsg", "success");
            result.put("data", "");
        } else {
            result.put("code", -100);
            result.put("errMsg", "修改失败");
            result.put("data", "");
        }
        return result;
    }

    /**
     * 查询所有发布的岗位
     * @return
     */
    public Map<String, Object> findPost(HttpServletRequest req) {
        Map<String, Object> result = new HashMap<String, Object>();
        String user_id = CookieUtil.getCookie(req, "TOKEN");
        if ("".equals(user_id)){
            result.put("code", -100);
            result.put("errMsg", "请重新登录");
            result.put("data", "");
        }
        Company company = companyMapper.findOneCompany(user_id);
        String company_id = company.getCompany_id();
        if ("".equals(company_id)){
            result.put("code", -100);
            result.put("errMsg", "没有企业信息");
            result.put("data", "");
        }
        List<Post> postlist = companyMapper.findPost(company_id);
        result.put("code", 200);
        result.put("errMsg", "success");
        result.put("data", postlist);
        return result;
    }

    /**
     * 新增岗位
     * @param post 实体
     * @return json
     */
    public Map<String, Object> addPost(Post post) {
        Map<String, Object> result = new HashMap<String, Object>();
        int num = companyMapper.addPost(post);
        post.setPost_id(Util.getUUID());
        post.setNum(0);
        if (num > 0) {
            result.put("code", 200);
            result.put("errMsg", "success");
            result.put("data", "");
        } else {
            result.put("code", -100);
            result.put("errMsg", "修改失败");
            result.put("data", "");
        }
        return result;
    }

    /**
     * 查询所有的应聘者
     * @param req
     * @return
     */
    public Map<String, Object> findDelivery(HttpServletRequest req) {
        Map<String, Object> result = new HashMap<String, Object>();
        String user_id = CookieUtil.getCookie(req, "TOKEN");
        if ("".equals(user_id)){
            result.put("code", -100);
            result.put("errMsg", "请重新登录");
            result.put("data", "");
        }
        Company company = companyMapper.findOneCompany(user_id);
        String company_id = company.getCompany_id();
        if ("".equals(company_id)){
            result.put("code", -100);
            result.put("errMsg", "没有企业信息");
            result.put("data", "");
        }
        List<UserDeliveryVO> res = companyMapper.findDelivery(company_id);
        result.put("code", 200);
        result.put("errMsg", "success");
        result.put("data", res);
        return result;
    }

    /**
     * 查询应聘者所有的信息
     * @param user_id
     * @return
     */
    public Map<String, Object> findUserAllMessage(String user_id) {
        Map<String, Object> result = new HashMap<String, Object>();
        UserVO user = userMapper.findUserAndMessage(user_id);
        result.put("code", 200);
        result.put("errMsg", "success");
        result.put("data", user);
        return result;
    }

    /**
     * 修改岗位信息
     * @param post_id 岗位id
     * @return json
     */
    public Map<String, Object> updatePost(String post_id) {
        Map<String, Object> result = new HashMap<String, Object>();
        int num = companyMapper.updatePost(post_id);
        if (num > 0) {
            result.put("code", 200);
            result.put("errMsg", "success");
            result.put("data", "");
        } else {
            result.put("code", -100);
            result.put("errMsg", "修改失败");
            result.put("data", "");
        }
        return result;
    }
}
