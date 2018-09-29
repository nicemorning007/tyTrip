/*
 * Copyright (c) 2018. All Rights Reserved.
 * FileName: Proprice.java
 * Author: NiceMorning
 */

package cn.nicemorning.ty_trip.config.third.pojo;

import java.util.Date;

public class Proprice {

    private String cpo;
    private int sun;
    private int mon;
    private int tue;
    private int wed;
    private int thur;
    private int fri;
    private int sat;
    private int kct;
    private Date uti;

    public void setCpo(String cpo) {
        this.cpo = cpo;
    }

    public String getCpo() {
        return cpo;
    }

    public void setSun(int sun) {
        this.sun = sun;
    }

    public int getSun() {
        return sun;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }

    public int getMon() {
        return mon;
    }

    public void setTue(int tue) {
        this.tue = tue;
    }

    public int getTue() {
        return tue;
    }

    public void setWed(int wed) {
        this.wed = wed;
    }

    public int getWed() {
        return wed;
    }

    public void setThur(int thur) {
        this.thur = thur;
    }

    public int getThur() {
        return thur;
    }

    public void setFri(int fri) {
        this.fri = fri;
    }

    public int getFri() {
        return fri;
    }

    public void setSat(int sat) {
        this.sat = sat;
    }

    public int getSat() {
        return sat;
    }

    public void setKct(int kct) {
        this.kct = kct;
    }

    public int getKct() {
        return kct;
    }

    public void setUti(Date uti) {
        this.uti = uti;
    }

    public Date getUti() {
        return uti;
    }

}