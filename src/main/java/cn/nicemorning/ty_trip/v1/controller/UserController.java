/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: UserController.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.v1.controller;

import cn.nicemorning.ty_trip.config.codec.AESUtil;
import cn.nicemorning.ty_trip.json.ErrorMessage;
import cn.nicemorning.ty_trip.json.Result;
import cn.nicemorning.ty_trip.json.ResultCode;
import cn.nicemorning.ty_trip.v1.bean.UserBean;
import cn.nicemorning.ty_trip.v1.router.RuyueRouter;
import cn.nicemorning.ty_trip.v1.service.UserService;
import cn.nicemorning.ty_trip.v1.wechatRequest.WechatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
                ResultCode.PARAMETER_ERROR.getMsg(),
                new ErrorMessage(5000, "服务器出现未知异常"));
    }

    @RequestMapping(value = "/bindRuyue", method = RequestMethod.POST)
    public Result bindRuyue(UserBean userBean) {
        System.out.println(userBean);
        if (userBean.getRuyuePhone() != null && !(userBean.getRuyuePhone().trim().isEmpty())) {
            if (userBean.getRuyuePW() != null && !(userBean.getRuyuePW().trim().isEmpty())) {
                RuyueRouter ruyueRouter = new RuyueRouter();
                try {
                    String userId = ruyueRouter.getUid(ruyueRouter.getWebClient(), userBean.getRuyuePhone(),
                            userBean.getRuyuePW());
                    if (!userId.equals("")) {
                        return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),
                                userService.addOrUpdateUser(new UserBean(userBean.getOpenId(),
                                        userBean.getRuyuePhone(), userBean.getRuyuePW(), userId, 1)));
                    }
                } catch (IOException | InterruptedException e) {
                    return new Result(ResultCode.PARAMETER_ERROR.getCode(),
                            ResultCode.PARAMETER_ERROR.getMsg(),
                            new ErrorMessage(4001, "用户名或密码错误"));
                }
            }
        }
        return new Result(ResultCode.PARAMETER_ERROR.getCode(),
                ResultCode.PARAMETER_ERROR.getMsg(),
                new ErrorMessage(4000, "如约服务端出现未知异常"));
    }

}