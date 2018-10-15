/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: SimpleRuyueLineDetailPojo.java
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
public class SimpleRuyueLineDetailPojo {
    private RuyueLineDetailDataPojo ruyueLineDetailDataPojo;
    private List<RuyueLineMapDataPojo> ruyueLineMapDataPojo;

    public SimpleRuyueLineDetailPojo(RuyueLineDetailDataPojo ruyueLineDetailDataPojo, List<RuyueLineMapDataPojo> ruyueLineMapDataPojo) {
        this.ruyueLineDetailDataPojo = ruyueLineDetailDataPojo;
        this.ruyueLineMapDataPojo = ruyueLineMapDataPojo;
    }

    public RuyueLineDetailDataPojo getRuyueLineDetailDataPojo() {
        return ruyueLineDetailDataPojo;
    }

    public void setRuyueLineDetailDataPojo(RuyueLineDetailDataPojo ruyueLineDetailDataPojo) {
        this.ruyueLineDetailDataPojo = ruyueLineDetailDataPojo;
    }

    public List<RuyueLineMapDataPojo> getRuyueLineMapDataPojo() {
        return ruyueLineMapDataPojo;
    }

    public void setRuyueLineMapDataPojo(List<RuyueLineMapDataPojo> ruyueLineMapDataPojo) {
        this.ruyueLineMapDataPojo = ruyueLineMapDataPojo;
    }
}
