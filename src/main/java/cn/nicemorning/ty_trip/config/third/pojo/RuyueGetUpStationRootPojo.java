/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueGetUpStationRootPojo.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.config.third.pojo;

import java.util.List;

/**
 * description
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/10/14
 */
public class RuyueGetUpStationRootPojo {

    private boolean success;
    private int code;
    private String msg;
    private List<RuyueGetUpStationDataPojo> data;
    private int count;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<RuyueGetUpStationDataPojo> getData() {
        return data;
    }

    public void setData(List<RuyueGetUpStationDataPojo> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
