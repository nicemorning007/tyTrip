/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueService.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.v1.service;

import cn.nicemorning.ty_trip.config.third.pojo.*;
import cn.nicemorning.ty_trip.v1.router.RuyueRouter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 如约数据业务类
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/20
 */
@Service
public class RuyueService {

    private RuyueRouter ruyueRouter;

    @Autowired
    public void setRuyueRouter(RuyueRouter ruyueRouter) {
        this.ruyueRouter = ruyueRouter;
    }

    private List<SimpleRuyueLinesPojo> packageLines(List<RuyueLinesPojo> ruyueLinesPojos) {
        List<SimpleRuyueLinesPojo> simpleRuyueLinesPojos = new ArrayList<>();
        for (RuyueLinesPojo ruyueLinesPojo : ruyueLinesPojos) {
            SimpleRuyueLinesPojo simpleRuyueLinesPojo = new SimpleRuyueLinesPojo();
            simpleRuyueLinesPojo.setId(ruyueLinesPojo.getRouteid());
            simpleRuyueLinesPojo.setLineDec(ruyueLinesPojo.getRoutedec());
            simpleRuyueLinesPojo.setLineRoute(ruyueLinesPojo.getRoutenm());
//            List<String> times = new ArrayList<>();
//            for (String time : ruyueLinesPojo.getProtimes().split(",")) {
//                times.add(time);
//            }
//            simpleRuyueLinesPojo.setTimes(times);
            simpleRuyueLinesPojo.setTimes(ruyueLinesPojo.getProtimes());
            simpleRuyueLinesPojo.setPrice(ruyueLinesPojo.getProprice().get(0).getMon());
            simpleRuyueLinesPojos.add(simpleRuyueLinesPojo);
        }
        return simpleRuyueLinesPojos;
    }

    private List<SimpleOrderPojo> packageOrders(List<RuyueOrderPojo> ruyueOrderRootPojos) {
        List<SimpleOrderPojo> simpleOrderPojos = new ArrayList<>();
        for (RuyueOrderPojo ruyueOrderPojo : ruyueOrderRootPojos) {
            SimpleOrderPojo simpleOrderPojo = new SimpleOrderPojo();
            simpleOrderPojo.setCount(ruyueOrderPojo.getTkc());
            simpleOrderPojo.setLineRoute(ruyueOrderPojo.getPnm());
            simpleOrderPojo.setOid(ruyueOrderPojo.getTklist().get(0).getOid());
            simpleOrderPojo.setPid(ruyueOrderPojo.getPid());
            simpleOrderPojo.setPrice(ruyueOrderPojo.getPrc());
            simpleOrderPojo.setTime(ruyueOrderPojo.getTktime());
            simpleOrderPojo.setTkstatus(ruyueOrderPojo.getTklist().get(0).getTkstatus());
            simpleOrderPojos.add(simpleOrderPojo);
        }
        return simpleOrderPojos;
    }

    public List<SimpleRuyueLinesPojo> getAllLines(int count, int pageIndex) {
        String json = "";
        try {
            json = ruyueRouter.getAllList(count, pageIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        json = json.replace('/', '-');
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.setLenient(true);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        RuyueLinesRootPojo ruyueLinesRootPojo = gson.fromJson(reader, new TypeToken<RuyueLinesRootPojo>() {
        }.getType());
        return packageLines(ruyueLinesRootPojo.getData().getItems());
    }

    public List<SimpleRuyueLinesPojo> findStation(String station, String userId) {
        String json = "";
        try {
            json = ruyueRouter.findStation(station, userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        json = json.replace('/', '-');
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.setLenient(true);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        RuyueLinesRootPojo ruyueLinesRootPojo = gson.fromJson(reader, new TypeToken<RuyueLinesRootPojo>() {
        }.getType());
        return packageLines(ruyueLinesRootPojo.getData().getItems());
    }

    public List<SimpleOrderPojo> getOrderInfoList(String userId, String phone, int index) {
        String json = "";
        try {
            json = ruyueRouter.getOrderInfoList(userId, phone, index);
        } catch (IOException e) {
            e.printStackTrace();
        }
        json = json.replace('/', '-');
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.setLenient(true);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        RuyueOrderRootPojo ruyueOrderRootPojo = gson.fromJson(reader, new TypeToken<RuyueOrderRootPojo>() {
        }.getType());
        return packageOrders(ruyueOrderRootPojo.getResult());
    }

    public TicketDetailPojo getTicketDetail(String oid) {
        String json = "";
        try {
            json = ruyueRouter.getTicketDetail(oid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        json = json.replace('/', '-');
        JsonReader reader = new JsonReader(new StringReader(json));
        reader.setLenient(true);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
        TicketDetailRootPojo ticketDetailRootPojo = gson.fromJson(reader, new TypeToken<TicketDetailRootPojo>() {
        }.getType());
        return ticketDetailRootPojo.getData();
    }

}
