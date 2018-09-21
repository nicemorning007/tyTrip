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

    public UserBean(String openId) {
        this.openId = openId;
    }

    public UserBean(String openId, String ruyuePhone, String ruyuePW) {
        this.openId = openId;
        this.ruyuePhone = ruyuePhone;
        this.ruyuePW = ruyuePW;
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
}
