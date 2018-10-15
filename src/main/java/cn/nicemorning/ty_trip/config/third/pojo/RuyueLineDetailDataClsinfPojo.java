/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueLineDetailDataClsinfPojo.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.config.third.pojo;

import java.util.List;

/**
 * description
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/10/14
 */
public class RuyueLineDetailDataClsinfPojo {
    private String clsid;
    private String clstm;
    private String ruttm;
    private String clstp;
    private String seats;
    private String week;
    private String scheid;
    private String priceyj;
    private List<RuyueLineDetailDataCarsfPojo> cars;

    public String getClsid() {
        return clsid;
    }

    public void setClsid(String clsid) {
        this.clsid = clsid;
    }

    public String getClstm() {
        return clstm;
    }

    public void setClstm(String clstm) {
        this.clstm = clstm;
    }

    public String getRuttm() {
        return ruttm;
    }

    public void setRuttm(String ruttm) {
        this.ruttm = ruttm;
    }

    public String getClstp() {
        return clstp;
    }

    public void setClstp(String clstp) {
        this.clstp = clstp;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getScheid() {
        return scheid;
    }

    public void setScheid(String scheid) {
        this.scheid = scheid;
    }

    public String getPriceyj() {
        return priceyj;
    }

    public void setPriceyj(String priceyj) {
        this.priceyj = priceyj;
    }

    public List<RuyueLineDetailDataCarsfPojo> getCars() {
        return cars;
    }

    public void setCars(List<RuyueLineDetailDataCarsfPojo> cars) {
        this.cars = cars;
    }
}
