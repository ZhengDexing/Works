package com.works.entity;

/**
 * 企业信息
 */
public class Company {
    private String company_id; //企业id
    private String company_name; //企业名称
    private String address; //企业地址
    private String phone;   //手机号
    private String corporation; //法人
    private int status; //状态 0是待审核 1是审核通过 99 删除
    private int num; //点击量
    private int city_id;//所在城市
    private String user_id; //用户id

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Company{" +
                "company_id='" + company_id + '\'' +
                ", company_name='" + company_name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", corporation='" + corporation + '\'' +
                ", status=" + status +
                ", num=" + num +
                ", city_id=" + city_id +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
