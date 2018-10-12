/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: IndexController.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

/**
 * description
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/30
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(WebRequest webRequest) {
        return "index";
    }
}
