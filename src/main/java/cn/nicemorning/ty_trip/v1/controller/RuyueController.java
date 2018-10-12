/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueController.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.v1.controller;

import cn.nicemorning.ty_trip.config.third.pojo.SimpleOrderPojo;
import cn.nicemorning.ty_trip.config.third.pojo.SimpleRuyueLinesPojo;
import cn.nicemorning.ty_trip.config.third.pojo.TicketDetailPojo;
import cn.nicemorning.ty_trip.json.ErrorMessage;
import cn.nicemorning.ty_trip.json.Result;
import cn.nicemorning.ty_trip.json.ResultCode;
import cn.nicemorning.ty_trip.v1.service.RuyueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    private final RuyueService ruyueService;

    @Autowired
    public RuyueController(RuyueService ruyueService) {
        this.ruyueService = ruyueService;
    }

    @RequestMapping("/getRuyueImgCode")
    public String getRuyueImgCode(String ryPhone) {

        return "";
    }

    @RequestMapping("/getAllLines")
    public Result getAllLins(String count, String pageIndex) {
        List<SimpleRuyueLinesPojo> simpleRuyueLinesPojos =
                ruyueService.getAllLines(Integer.parseInt(count), Integer.parseInt(pageIndex));
        if (simpleRuyueLinesPojos.size() > 0) {
            return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),
                    simpleRuyueLinesPojos);
        }
        return new Result(ResultCode.PARAMETER_ERROR.getCode(),
                ResultCode.PARAMETER_ERROR.getMsg(),
                new ErrorMessage(4000, "如约服务端出现未知异常"));
    }

    @RequestMapping("/searchStation")
    public Result searchStation(String station, String userId) {
        List<SimpleRuyueLinesPojo> simpleRuyueLinesPojos = ruyueService.findStation(station, userId);
        if (simpleRuyueLinesPojos.size() > 0) {
            return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),
                    simpleRuyueLinesPojos);
        }
        return new Result(ResultCode.PARAMETER_ERROR.getCode(),
                ResultCode.PARAMETER_ERROR.getMsg(),
                new ErrorMessage(4000, "如约服务端出现未知异常"));
    }

    @RequestMapping("/getTicketList")
    public Result getTicketList(String userId, String phone, int index) {
        List<SimpleOrderPojo> simpleOrderPojos = ruyueService.getOrderInfoList(userId, phone, index);
        if (simpleOrderPojos.size() > 0) {
            return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),
                    simpleOrderPojos);
        }
        return new Result(ResultCode.PARAMETER_ERROR.getCode(),
                ResultCode.PARAMETER_ERROR.getMsg(),
                new ErrorMessage(4000, "如约服务端出现未知异常"));
    }

    @RequestMapping("/getTicketDetail")
    public Result getTicketList(String oid) {
        TicketDetailPojo ticketDetailPojo = ruyueService.getTicketDetail(oid);
        if (ticketDetailPojo != null) {
            return new Result(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(),
                    ticketDetailPojo);
        }
        return new Result(ResultCode.PARAMETER_ERROR.getCode(),
                ResultCode.PARAMETER_ERROR.getMsg(),
                new ErrorMessage(4000, "如约服务端出现未知异常"));
    }
}
