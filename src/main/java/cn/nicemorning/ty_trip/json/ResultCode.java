/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: ResultCode.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.json;

/**
 * 返回数据错误列表
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/21
 */
public enum ResultCode {
    RUYUE_SERVER_EXCEPTION(1001, "如约服务出现异常"),
    RUYUE_SERVER_TIMEOUT(1002, "如约服务响应超时"),
    BUS_SERVER_EXCEPTION(1003, "实时公交服务出现异常"),
    BUS_SERVER_TIMEOUT(1004, "实时公交服务响应超时"),
    SUCCESS(2000, "响应成功"),
    PARAMETER_ERROR(2001, "参数错误"),
    DB_TIMEOUT(3001, "数据库访问超时"),
    RUYUE_DATA_EXCEPTION(4001, "如约数据出错"),
    UNKNOW_EXCEPTION(5000, "未知异常"),
    RUYUE_SERVER_UNCONNECTED(6001, "如约服务无法连接"),
    BUS_SERVER_UNCONNECTED(7001, "实时公交服务无法连接"),
    BUS_DATA_EXCEPTION(7002, "实时公交数据出错");

    private Integer code;

    private String msg;

    ResultCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
