/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: Result.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.json;

/**
 * 统一返回数据格式
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/21
 */
public class Result {
    /*返回码*/
    private Integer success;
    /*返回信息提示*/
    private String message;
    /*返回的数据*/
    private Object data;

    public Result() {
    }

    public Result(Integer code, String message, Object data) {
        this.success = code;
        this.message = message;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result [success=" + success + ", message=" + message + ", data=" + data + "]";
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
