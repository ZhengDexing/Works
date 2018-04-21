package com.works.mapper;

import com.works.entity.Company;
import com.works.entity.Post;
import com.works.entity.vo.DeliveryVO;
import com.works.entity.vo.PostVO;
import com.works.entity.vo.UserDeliveryVO;
import com.works.entity.vo.UserVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyMapper {
    public int addCompany(UserVO company); //添加企业信息

    public int updateCompany(Company company);//修改企业表数据

    public int  addPost(Post post); //发布岗位

    public List<Post> findPost(String post_id);  //查询当前企业的岗位

    public Company findOneCompany(String user_id); //查询当初用户的企业信息

    public List<UserDeliveryVO> findDelivery(String company_id); //所有的应聘者

    public int updatePost(String post_id); //修改岗位信息

    public List<PostVO> findAllPost();  //获取所有的岗位

    public PostVO findOnePost(String post_id);    //根据岗位id查询岗位详情

    public List<DeliveryVO> getDelivery2User(String user_id); //获取用户投递的岗位

    public List<Post> findPostByCompany (String company_id);    //查询企业所有的岗位

}
