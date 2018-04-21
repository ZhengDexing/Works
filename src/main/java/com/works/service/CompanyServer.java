package com.works.service;

import com.works.entity.Company;
import com.works.entity.Post;
import com.works.entity.vo.CompanyVo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface CompanyServer {

    public  Map<String, Object> updateCompany(Company company);//修改企业表数据

    public  Map<String, Object> addPost(Post post); //新增岗位

    public  Map<String, Object> findPost(HttpServletRequest req); //查询岗位

    public Map<String,Object> findDelivery(HttpServletRequest req);  //查询所有投递该公司的用户

    public Map<String,Object> findUserAllMessage(String user_id);  //查询用户详情

    public Map<String,Object> updatePost(String post_id);   //修改岗位信息


}
