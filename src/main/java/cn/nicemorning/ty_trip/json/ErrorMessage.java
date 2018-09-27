/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: ErrorMessage.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.json;

/**
 * description
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/25
 */
public class ErrorMessage {
    private Integer code;
    private String message;

    public ErrorMessage(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
