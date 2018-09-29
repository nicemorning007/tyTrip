/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: SimpleRuyueLinesPojo.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.config.third.pojo;

import java.util.List;

/**
 * description
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/29
 */
public class SimpleRuyueLinesPojo {
    private String id;
    private String lineRoute;
    private String lineDec;
    private int price;
    private List<String> times;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLineRoute() {
        return lineRoute;
    }

    public void setLineRoute(String lineRoute) {
        this.lineRoute = lineRoute;
    }

    public String getLineDec() {
        return lineDec;
    }

    public void setLineDec(String lineDec) {
        this.lineDec = lineDec;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }
}
