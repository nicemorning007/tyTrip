/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueLineDetailDataPojo.java
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
public class RuyueLineDetailDataPojo {

    private String pct;
    private Product Product;
    private List<RuyueLineDetailDataItemsPojo> items;

    public void setPct(String pct) {
        this.pct = pct;
    }

    public String getPct() {
        return pct;
    }

    public void setProduct(Product Product) {
        this.Product = Product;
    }

    public Product getProduct() {
        return Product;
    }

    public void setItems(List<RuyueLineDetailDataItemsPojo> items) {
        this.items = items;
    }

    public List<RuyueLineDetailDataItemsPojo> getItems() {
        return items;
    }
}
