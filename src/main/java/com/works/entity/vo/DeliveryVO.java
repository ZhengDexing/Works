package com.works.entity.vo;

public class DeliveryVO {
    private String company_id; //企业id
    private String company_name; //企业名称
    private String address; //企业地址
    private String phone;   //手机号
    private String corporation; //法人
    private int num; //点击量
    private int city_id;//所在城市
    private String user_id; //用户id
    private String post_id;
    private String salary;
    private String message;
    private String post_name;
    private String trade_id;
    private String delivery_id;
    private int status;

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

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPost_name() {
        return post_name;
    }

    public void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    public String getTrade_id() {
        return trade_id;
    }

    public void setTrade_id(String trade_id) {
        this.trade_id = trade_id;
    }

    public String getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(String delivery_id) {
        this.delivery_id = delivery_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DeliveryVO{" +
                "company_id='" + company_id + '\'' +
                ", company_name='" + company_name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", corporation='" + corporation + '\'' +
                ", num=" + num +
                ", city_id=" + city_id +
                ", user_id='" + user_id + '\'' +
                ", post_id='" + post_id + '\'' +
                ", salary='" + salary + '\'' +
                ", message='" + message + '\'' +
                ", post_name='" + post_name + '\'' +
                ", trade_id='" + trade_id + '\'' +
                ", delivery_id='" + delivery_id + '\'' +
                ", status=" + status +
                '}';
    }
}
