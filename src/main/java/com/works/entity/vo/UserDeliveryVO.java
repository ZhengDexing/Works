package com.works.entity.vo;

public class UserDeliveryVO {
    private String user_id;
    private String realname;    //真实姓名
    private int age;            //年龄
    private String idcard;      //身份证号码
    private String phone;       //手机号码
    private String address;     //地址
    private String school;      //毕业学校
    private String graduation;  //毕业时间
    private String trade_id;    //目标行业
    private String education;   //学历
    private String city_id;     //所在城市
    private String delivery_id;
    private String post_id;
    private int status;


    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(String trade_id) {
        this.trade_id = trade_id;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(String delivery_id) {
        this.delivery_id = delivery_id;
    }

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UserDeliveryVO{" +
                "user_id='" + user_id + '\'' +
                ", realname='" + realname + '\'' +
                ", age=" + age +
                ", idcard='" + idcard + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", school='" + school + '\'' +
                ", graduation='" + graduation + '\'' +
                ", trade_id='" + trade_id + '\'' +
                ", education='" + education + '\'' +
                ", city_id='" + city_id + '\'' +
                ", delivery_id='" + delivery_id + '\'' +
                ", post_id='" + post_id + '\'' +
                ", status=" + status +
                '}';
    }
}
