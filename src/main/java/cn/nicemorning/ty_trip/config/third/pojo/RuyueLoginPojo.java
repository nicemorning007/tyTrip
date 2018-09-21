/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueLoginPojo.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.config.third.pojo;

/**
 * description
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/21
 */
public class RuyueLoginPojo {
    private Integer code;
    private Integer count;
    private RuyueDataPojo data;
    private String msg;
    private Boolean success;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public RuyueDataPojo getData() {
        return data;
    }

    public void setData(RuyueDataPojo data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
