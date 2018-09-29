/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueService.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.v1.service;

import cn.nicemorning.ty_trip.config.third.pojo.RuyueLinesPojo;
import cn.nicemorning.ty_trip.config.third.pojo.RuyueLinesRootPojo;
import cn.nicemorning.ty_trip.config.third.pojo.SimpleRuyueLinesPojo;
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

    public List<SimpleRuyueLinesPojo> getAllLines(int count, int pageIndex) {
        List<SimpleRuyueLinesPojo> simpleRuyueLinesPojos = new ArrayList<>();
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
        for (RuyueLinesPojo ruyueLinesPojo : ruyueLinesRootPojo.getData().getItems()) {
            SimpleRuyueLinesPojo simpleRuyueLinesPojo = new SimpleRuyueLinesPojo();
            simpleRuyueLinesPojo.setId(ruyueLinesPojo.getRouteid());
            simpleRuyueLinesPojo.setLineDec(ruyueLinesPojo.getRoutedec());
            simpleRuyueLinesPojo.setLineRoute(ruyueLinesPojo.getRoutenm());
            List<String> times = new ArrayList<>();
            for (String time : ruyueLinesPojo.getProtimes().split(",")) {
                times.add(time);
            }
            simpleRuyueLinesPojo.setTimes(times);
            simpleRuyueLinesPojo.setPrice(ruyueLinesPojo.getProprice().get(0).getMon());
            simpleRuyueLinesPojos.add(simpleRuyueLinesPojo);
        }
        return simpleRuyueLinesPojos;
    }

}
