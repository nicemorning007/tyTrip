/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueLineMapDataPojo.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.config.third.pojo;

/**
 * description
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/10/14
 */
public class RuyueLineMapDataPojo {

    private String sid;
    private String imgs;
    private double lat;
    private double lng;

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSid() {
        return sid;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public String getImgs() {
        return imgs;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLat() {
        return lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLng() {
        return lng;
    }
}
