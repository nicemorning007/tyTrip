/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueLinesRootPojo.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.config.third.pojo;

/**
 * 如约线路信息封装
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/29
 */
public class RuyueLinesRootPojo {

    private boolean success;
    private int code;
    private String msg;
    private RuyueLinesDataPojo data;
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

    public void setData(RuyueLinesDataPojo data) {
        this.data = data;
    }
    public RuyueLinesDataPojo getData() {
        return data;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public int getCount() {
        return count;
    }

}