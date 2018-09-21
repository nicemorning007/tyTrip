/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: WxLoginBean.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.json;

/**
 * 微信login接口回传实体类
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/20
 */
public class WxLoginBean {
    private String openid;
    private String session_key;
    private String unionid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }
}
