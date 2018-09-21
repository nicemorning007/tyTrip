/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: KeyConfigurator.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.config.codec;

import cn.nicemorning.ty_trip.config.URLBean;

/**
 * AES加密配置类
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/20
 */
class KeyConfigurator {
    static final String KEY = URLBean.APPID + "tyTrip";
    static final String IV = "ABW82JAVCJ1IDF78";
    static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    static final String ALGORITHM = "AES";
    static final String CHARSET = "utf-8";
}
