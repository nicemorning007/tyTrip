/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: Tklist.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.config.third.pojo;

import java.util.Date;

/**
 * description
 * <p>
 * author: nicemorning
 * version: 1.0
 * date: 2018/10/10
 */
public class Tklist {

    private Date date;
    private String st;
    private String rtime;
    private String enm;
    private boolean isSatisfyCoup;
    private int haveTKPrice;
    private String oid;
    private String sttm;
    private String Mobile;
    private String vcode;
    private String apdsev;
    private boolean isHavePnoCoup;
    private String rtype;
    private String print;
    private String travelt;
    private int tkstatus;
    private String LineTypeName;
    private String ClassTypeName;
    private String child;
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getDate() {
        return date;
    }

    public void setSt(String st) {
        this.st = st;
    }
    public String getSt() {
        return st;
    }

    public void setRtime(String rtime) {
        this.rtime = rtime;
    }
    public String getRtime() {
        return rtime;
    }

    public void setEnm(String enm) {
        this.enm = enm;
    }
    public String getEnm() {
        return enm;
    }

    public void setIsSatisfyCoup(boolean isSatisfyCoup) {
        this.isSatisfyCoup = isSatisfyCoup;
    }
    public boolean getIsSatisfyCoup() {
        return isSatisfyCoup;
    }

    public void setHaveTKPrice(int haveTKPrice) {
        this.haveTKPrice = haveTKPrice;
    }
    public int getHaveTKPrice() {
        return haveTKPrice;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }
    public String getOid() {
        return oid;
    }

    public void setSttm(String sttm) {
        this.sttm = sttm;
    }
    public String getSttm() {
        return sttm;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }
    public String getMobile() {
        return Mobile;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }
    public String getVcode() {
        return vcode;
    }

    public void setApdsev(String apdsev) {
        this.apdsev = apdsev;
    }
    public String getApdsev() {
        return apdsev;
    }

    public void setIsHavePnoCoup(boolean isHavePnoCoup) {
        this.isHavePnoCoup = isHavePnoCoup;
    }
    public boolean getIsHavePnoCoup() {
        return isHavePnoCoup;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }
    public String getRtype() {
        return rtype;
    }

    public void setPrint(String print) {
        this.print = print;
    }
    public String getPrint() {
        return print;
    }

    public void setTravelt(String travelt) {
        this.travelt = travelt;
    }
    public String getTravelt() {
        return travelt;
    }

    public void setTkstatus(int tkstatus) {
        this.tkstatus = tkstatus;
    }
    public int getTkstatus() {
        return tkstatus;
    }

    public void setLineTypeName(String LineTypeName) {
        this.LineTypeName = LineTypeName;
    }
    public String getLineTypeName() {
        return LineTypeName;
    }

    public void setClassTypeName(String ClassTypeName) {
        this.ClassTypeName = ClassTypeName;
    }
    public String getClassTypeName() {
        return ClassTypeName;
    }

    public void setChild(String child) {
        this.child = child;
    }
    public String getChild() {
        return child;
    }
}
