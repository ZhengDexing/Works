package com.works.common.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    /**
     * 生成uuid
     * uuid中的 “-” 影响数据库性能，所以去掉
     *
     * @return uuid
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 判断邮箱地址是否合法
     *
     * @param email 邮箱地址
     * @return 是否合法
     */
    public static boolean isEmail(String email) {
        final String check = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        /*
         * Pattern 为字符串的正则表达式必须首先被编译为此类的实例。
         * 然后，可将得到的模式用于创建 Matcher 对象，依照正则表达式，该对象可以与任意字符序列匹配。
         * 执行匹配所涉及的所有状态都驻留在匹配器中，所以多个匹配器可以共享同一模式。
         */
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        return matcher.matches();
    }

    /**
     * 判断手机号码是否正确
     *
     * @param phone 手机号码
     * @return 是否合法
     */
    public static boolean isPhone(String phone) {
        final String check = "^1[345789]\\d{9}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(phone);
        return matcher.matches();
    }
}
