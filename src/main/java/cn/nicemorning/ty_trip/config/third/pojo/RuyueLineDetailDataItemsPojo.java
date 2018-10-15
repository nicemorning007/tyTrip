/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueLineDetailDataItemsPojo.java
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
public class RuyueLineDetailDataItemsPojo {

    private String date;
    private String priceyj;
    private List<RuyueLineDetailDataClsinfPojo> clsinf;

    public void setDate(String date) {
        this.date = date.split("T")[0];
    }

    public String getDate() {
        return date;
    }

    public void setPriceyj(String priceyj) {
        this.priceyj = priceyj;
    }

    public String getPriceyj() {
        return priceyj;
    }

    public void setClsinf(List<RuyueLineDetailDataClsinfPojo> clsinf) {
        this.clsinf = clsinf;
    }

    public List<RuyueLineDetailDataClsinfPojo> getClsinf() {
        return clsinf;
    }

}
