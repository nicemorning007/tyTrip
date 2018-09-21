/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: WechatRequest.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.v1.wechatRequest;

import cn.nicemorning.ty_trip.config.URLBean;
import cn.nicemorning.ty_trip.json.WxLoginBean;
import cn.nicemorning.ty_trip.utils.https.HttpsRequest;
import com.google.gson.Gson;

/**
 * description
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/20
 */
public class WechatRequest {
    private static WxLoginBean getUserInfo(String code) {
        String userInfoJson = HttpsRequest.httpsRequest(URLBean.getGetCodeUrl(code), "GET");
        Gson gson = new Gson();
        return gson.fromJson(userInfoJson, WxLoginBean.class);
    }

    public static String getOpenId(String code) {
        return getUserInfo(code).getOpenid();
    }

    public static String getSessionKey(String code) {
        return getUserInfo(code).getSession_key();
    }

    public static String getUnionId(String code){
        return getUserInfo(code).getUnionid();
    }
}
