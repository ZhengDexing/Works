package com.works.entity;

public class Post {
    private String post_id;
    private String company_id;
    private String salary;
    private int num;
    private String message;
    private String post_name;
    private String trade_id;

    public String getPost_id() {
        return post_id;
    }

    public void setPost_id(String post_id) {
        this.post_id = post_id;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    @Override
    public String toString() {
        return "Post{" +
                "post_id='" + post_id + '\'' +
                ", company_id='" + company_id + '\'' +
                ", salary='" + salary + '\'' +
                ", num=" + num +
                ", message='" + message + '\'' +
                ", post_name='" + post_name + '\'' +
                ", trade_id='" + trade_id + '\'' +
                '}';
    }
}
