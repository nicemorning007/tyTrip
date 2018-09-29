/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueLinesDataPojo.java
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
public class RuyueLinesDataPojo {

    private int index;
    private int count;
    private int limit;
    private List<RuyueLinesPojo> items;
    private String minprc;
    private String shifttimes;

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setItems(List<RuyueLinesPojo> items) {
        this.items = items;
    }

    public List<RuyueLinesPojo> getItems() {
        return items;
    }

    public void setMinprc(String minprc) {
        this.minprc = minprc;
    }

    public String getMinprc() {
        return minprc;
    }

    public void setShifttimes(String shifttimes) {
        this.shifttimes = shifttimes;
    }

    public String getShifttimes() {
        return shifttimes;
    }

}