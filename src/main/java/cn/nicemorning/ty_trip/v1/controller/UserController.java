/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: UserController.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.v1.controller;

import cn.nicemorning.ty_trip.config.codec.AESUtil;
import cn.nicemorning.ty_trip.json.Result;
import cn.nicemorning.ty_trip.json.ResultCode;
import cn.nicemorning.ty_trip.v1.bean.UserBean;
import cn.nicemorning.ty_trip.v1.service.UserService;
import cn.nicemorning.ty_trip.v1.wechatRequest.WechatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关操作响应类
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/20
 */
@RestController
@RequestMapping("/v1")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Result getOpenId(String code) {
        if (code != null && !(code.trim().isEmpty())) {
            return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),
                    userService.getUserByOpenId(AESUtil.encrypt(WechatRequest.getOpenId(code))));
        }
        return new Result(ResultCode.PARAMETER_ERROR.getCode(),
                ResultCode.PARAMETER_ERROR.getMsg(), null);
    }

    @RequestMapping(value = "/bindRuyue", method = RequestMethod.POST)
    public Result bindRuyue(String openId, String ryPhone, String ryPw) {
        if (openId != null && !(openId.trim().isEmpty())) {
            if (ryPhone != null && !(ryPhone.trim().isEmpty())) {
                if (ryPw != null && !(ryPw.trim().isEmpty())) {
                    return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),
                            userService.addOrUpdateUser(new UserBean(openId, ryPhone, ryPw)));
                }
            }
        }
        return new Result(ResultCode.PARAMETER_ERROR.getCode(),
                ResultCode.PARAMETER_ERROR.getMsg(), null);
    }
}