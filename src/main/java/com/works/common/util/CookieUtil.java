package com.works.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

    /**
     * 创建Cookie
     * @param resp  响应
     * @param name  Cookie的key
     * @param value Cookie的value
     */
    public static void addCookie(HttpServletResponse resp, String name, String value) {
        Cookie cookie = new Cookie(name, value);    //创建cookieh
        cookie.setMaxAge(3 * 60 * 60);    //设置时间为3小时
        cookie.setPath("/");   //设置作用域
        resp.addCookie(cookie);    //将Cookie添加到response的cookie数组中返回给客户端
    }

    /**
     * 根据name获取cookie
     * @param req 客户端的请求
     * @param name 需要获取cookie的name
     * @return 返回name对应的值
     */
    public static String getCookie(HttpServletRequest req, String name) {
        Cookie[] cookies = req.getCookies();    //从请求中获取cookie
        if (null != cookies) {
            //迭代，如果name相同，返回value
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }

    /**
     * 清除Cookie
     * @param resp 响应请求
     * @param name cookie的key
     * @param value cookie的值
     */
    public static void cleanCookie(HttpServletResponse resp, String name, String value){
        Cookie cookie = new Cookie(name,value);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        resp.addCookie(cookie);
    }

}
