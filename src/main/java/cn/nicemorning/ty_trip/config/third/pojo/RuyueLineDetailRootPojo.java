/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueLineDetailRootPojo.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.config.third.pojo;

/**
 * description
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/10/14
 */
public class RuyueLineDetailRootPojo {

    private boolean success;
    private int code;
    private String msg;
    private RuyueLineDetailDataPojo data;
    private int count;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setData(RuyueLineDetailDataPojo data) {
        this.data = data;
    }

    public RuyueLineDetailDataPojo getData() {
        return data;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

}
