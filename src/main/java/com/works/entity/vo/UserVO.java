package com.works.entity.vo;

public class UserVO {

    private String user_id;     //用户id
    private String email;       //邮箱
    private String password;    //密码
    private String nickname;    //昵称
    private String portrait;    //头像
    private int role;           //角色
    private String realname;    //真实姓名
    private int age;            //年龄
    private String idcard;      //身份证号码
    private String phone;       //手机号码
    private String address;     //地址
    private String school;      //毕业学校
    private String graduation;  //毕业时间
    private String trade_id;    //目标行业
    private String city_id;     //所在城市
    private String company_id; //企业id
    private String company_name; //企业名称
    private String corporation; //法人
    private String education;  //学历
    private int status; //状态 0是待审核 1是审核通过 99 删除
    private int num; //点击量

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "user_id='" + user_id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", portrait='" + portrait + '\'' +
                ", role=" + role +
                ", realname='" + realname + '\'' +
                ", age=" + age +
                ", idcard='" + idcard + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", school='" + school + '\'' +
                ", graduation='" + graduation + '\'' +
                ", trade_id='" + trade_id + '\'' +
                ", city_id='" + city_id + '\'' +
                ", company_id='" + company_id + '\'' +
                ", company_name='" + company_name + '\'' +
                ", corporation='" + corporation + '\'' +
                ", education='" + education + '\'' +
                ", status=" + status +
                ", num=" + num +
                '}';
    }
}
