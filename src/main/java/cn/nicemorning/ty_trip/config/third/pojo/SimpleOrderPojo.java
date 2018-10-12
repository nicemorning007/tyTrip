/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: SimpleOrderPojo.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.config.third.pojo;

/**
 * description
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/10/10
 */
public class SimpleOrderPojo {
    private String oid;
    private String pid;
    private String time;
    private String lineRoute;
    private String count;
    private String price;
    private int tkstatus;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLineRoute() {
        return lineRoute;
    }

    public void setLineRoute(String lineRoute) {
        this.lineRoute = lineRoute;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getTkstatus() {
        return tkstatus;
    }

    public void setTkstatus(int tkstatus) {
        this.tkstatus = tkstatus;
    }
}
