package com.chinavisionary.microtang.hydropower.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class RentFeeVo extends BaseVo {
    private BigDecimal amount;
    private String key;
    private long lastPayTime;
    private String orderCode;
    private long rentEndTime;
    private long rentStartTime;

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getKey() {
        return this.key;
    }

    public long getLastPayTime() {
        return this.lastPayTime;
    }

    public String getOrderCode() {
        return this.orderCode;
    }

    public long getRentEndTime() {
        return this.rentEndTime;
    }

    public long getRentStartTime() {
        return this.rentStartTime;
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLastPayTime(long j) {
        this.lastPayTime = j;
    }

    public void setOrderCode(String str) {
        this.orderCode = str;
    }

    public void setRentEndTime(long j) {
        this.rentEndTime = j;
    }

    public void setRentStartTime(long j) {
        this.rentStartTime = j;
    }
}
