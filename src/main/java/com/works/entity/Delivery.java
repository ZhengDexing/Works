package com.works.entity;

public class Delivery {
    private String delivery_id;
    private String post_id;
    private String user_id;
    private int status;

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

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "delivery_id='" + delivery_id + '\'' +
                ", post_id='" + post_id + '\'' +
                ", user_id='" + user_id + '\'' +
                ", status=" + status +
                '}';
    }
}
