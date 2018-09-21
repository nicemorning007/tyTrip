/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: HttpMethod.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.utils.http;

import okhttp3.Request;

/**
 * HTTP基本方法接口
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/20
 */
public interface HttpMethod {
    void post(Request request);

    void get(Request request);
}
