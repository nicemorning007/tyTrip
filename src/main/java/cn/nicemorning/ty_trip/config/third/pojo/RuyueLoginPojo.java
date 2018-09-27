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
    private String success;
    private Integer code;
    private String msg;
    private RuyueDataPojo data;
    private Integer count;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RuyueDataPojo getData() {
        return data;
    }

    public void setData(RuyueDataPojo data) {
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "RuyueLoginPojo{" +
                "success='" + success + '\'' +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", count=" + count +
                '}';
    }
}
