/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: UserBean.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.v1.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户实体类
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/20
 */
@Entity
@Table(name = "ty_trip")
public class UserBean {
    @Id
    private String openId;
    @Column(name = "ruyue_phone")
    private String ruyuePhone;
    @Column(name = "ruyue_pw")
    private String ruyuePW;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "statu")
    private Integer statu = 0;

    public UserBean(String openId) {
        this.openId = openId;
    }

    public UserBean(String openId, String ruyuePhone, String ruyuePW,String userId,Integer statu) {
        this.openId = openId;
        this.ruyuePhone = ruyuePhone;
        this.ruyuePW = ruyuePW;
        this.userId = userId;
        this.statu = statu;
    }

    public UserBean() {
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getRuyuePhone() {
        return ruyuePhone;
    }

    public void setRuyuePhone(String ruyuePhone) {
        this.ruyuePhone = ruyuePhone;
    }

    public String getRuyuePW() {
        return ruyuePW;
    }

    public void setRuyuePW(String ruyuePW) {
        this.ruyuePW = ruyuePW;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "openId='" + openId + '\'' +
                ", ruyuePhone='" + ruyuePhone + '\'' +
                ", ruyuePW='" + ruyuePW + '\'' +
                ", userId='" + userId + '\'' +
                ", statu=" + statu +
                '}';
    }
}
