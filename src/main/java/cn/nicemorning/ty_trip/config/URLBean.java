/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: URLBean.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.config;

/**
 * description
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/17
 */
public class URLBean {
    public static final String APPID = "wx078058ae92fa0df7";
    private static final String APPSECRET = "407e49af963b677ae9c014a8df132f91";

    public static String getGetCodeUrl(String code) {
        return "https://api.weixin.qq.com/sns/jscode2session?appid=" + APPID + "&secret=" + APPSECRET +
                "&js_code=" + code + "&grant_type=authorization_code";
    }
}
