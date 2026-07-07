package com.chinavisionary.microtang.community.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class LatLngVo extends BaseVo {
    private String address;
    private double latitude;
    private double longitude;

    public String getAddress() {
        return this.address;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setLatitude(double d2) {
        this.latitude = d2;
    }

    public void setLongitude(double d2) {
        this.longitude = d2;
    }
}
