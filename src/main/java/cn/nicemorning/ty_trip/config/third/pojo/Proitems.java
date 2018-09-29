/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: Proitems.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.config.third.pojo;

/**
 * 如约线路详细信息实体类
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/29
 */
public class Proitems {

    private Product Product;
    private String pct;

    public void setProduct(Product Product) {
        this.Product = Product;
    }

    public Product getProduct() {
        return Product;
    }

    public void setPct(String pct) {
        this.pct = pct;
    }

    public String getPct() {
        return pct;
    }

}