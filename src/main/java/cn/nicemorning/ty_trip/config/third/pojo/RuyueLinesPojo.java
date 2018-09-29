/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: RuyueLinesPojo.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.config.third.pojo;

import java.util.List;

/**
 * 如约线路封装实体类
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/9/29
 */
public class RuyueLinesPojo {

    private String minmaxpricesjson;
    private String Routeid;
    private String Routenm;
    private String Routecd;
    private String Routeput;
    private String Routespd;
    private String Routedec;
    private String rbname;
    private List<Proitems> proitems;
    private List<Procouop> procouop;
    private List<Proprice> proprice;
    private String protimes;
    private String protimesbyrid;
    private String minprc;
    private String maxprc;
    private String prolist;
    private List<Productcouplist> productcouplist;

    public void setMinmaxpricesjson(String minmaxpricesjson) {
        this.minmaxpricesjson = minmaxpricesjson;
    }

    public String getMinmaxpricesjson() {
        return minmaxpricesjson;
    }

    public void setRouteid(String Routeid) {
        this.Routeid = Routeid;
    }

    public String getRouteid() {
        return Routeid;
    }

    public void setRoutenm(String Routenm) {
        this.Routenm = Routenm;
    }

    public String getRoutenm() {
        return Routenm;
    }

    public void setRoutecd(String Routecd) {
        this.Routecd = Routecd;
    }

    public String getRoutecd() {
        return Routecd;
    }

    public void setRouteput(String Routeput) {
        this.Routeput = Routeput;
    }

    public String getRouteput() {
        return Routeput;
    }

    public void setRoutespd(String Routespd) {
        this.Routespd = Routespd;
    }

    public String getRoutespd() {
        return Routespd;
    }

    public void setRoutedec(String Routedec) {
        this.Routedec = Routedec;
    }

    public String getRoutedec() {
        return Routedec;
    }

    public void setRbname(String rbname) {
        this.rbname = rbname;
    }

    public String getRbname() {
        return rbname;
    }

    public void setProitems(List<Proitems> proitems) {
        this.proitems = proitems;
    }

    public List<Proitems> getProitems() {
        return proitems;
    }

    public void setProcouop(List<Procouop> procouop) {
        this.procouop = procouop;
    }

    public List<Procouop> getProcouop() {
        return procouop;
    }

    public void setProprice(List<Proprice> proprice) {
        this.proprice = proprice;
    }

    public List<Proprice> getProprice() {
        return proprice;
    }

    public void setProtimes(String protimes) {
        this.protimes = protimes;
    }

    public String getProtimes() {
        return protimes;
    }

    public void setProtimesbyrid(String protimesbyrid) {
        this.protimesbyrid = protimesbyrid;
    }

    public String getProtimesbyrid() {
        return protimesbyrid;
    }

    public void setMinprc(String minprc) {
        this.minprc = minprc;
    }

    public String getMinprc() {
        return minprc;
    }

    public void setMaxprc(String maxprc) {
        this.maxprc = maxprc;
    }

    public String getMaxprc() {
        return maxprc;
    }

    public void setProlist(String prolist) {
        this.prolist = prolist;
    }

    public String getProlist() {
        return prolist;
    }

    public void setProductcouplist(List<Productcouplist> productcouplist) {
        this.productcouplist = productcouplist;
    }

    public List<Productcouplist> getProductcouplist() {
        return productcouplist;
    }

}