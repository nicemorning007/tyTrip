/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueController.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.v1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 如约响应类
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/20
 */
@RestController
@RequestMapping("/v1")
public class RuyueController {
    @RequestMapping("/getRuyueImgCode")
    public String getRuyueImgCode(String ryPhone) {

        return "";
    }
}
