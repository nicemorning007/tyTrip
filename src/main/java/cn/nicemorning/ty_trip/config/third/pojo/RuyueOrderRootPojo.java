/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueOrderRootPojo.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.config.third.pojo;

import java.util.List;

/**
 * description
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/10/10
 */
public class RuyueOrderRootPojo {

    private String msg;
    private List<RuyueOrderPojo> result;
    private int code;
    private String status;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setResult(List<RuyueOrderPojo> result) {
        this.result = result;
    }

    public List<RuyueOrderPojo> getResult() {
        return result;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
