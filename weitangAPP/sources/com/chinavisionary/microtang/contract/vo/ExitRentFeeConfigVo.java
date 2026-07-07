package com.chinavisionary.microtang.contract.vo;

import c.e.c.o.b.a;
import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class ExitRentFeeConfigVo extends BaseVo {
    private long endTime;
    private long exitRentDate;
    private a iExitRentTimeCallback;
    private String key;
    private String rentAddress;
    private long startTime;

    public long getEndTime() {
        return this.endTime;
    }

    public long getExitRentDate() {
        return this.exitRentDate;
    }

    public a getExitRentTimeCallback() {
        return this.iExitRentTimeCallback;
    }

    public String getKey() {
        return this.key;
    }

    public String getRentAddress() {
        return this.rentAddress;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setExitRentDate(long j) {
        this.exitRentDate = j;
    }

    public void setExitRentTimeCallback(a aVar) {
        this.iExitRentTimeCallback = aVar;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setRentAddress(String str) {
        this.rentAddress = str;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }
}
