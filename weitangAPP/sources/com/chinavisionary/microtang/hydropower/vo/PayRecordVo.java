package com.chinavisionary.microtang.hydropower.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class PayRecordVo extends BaseVo {
    private BigDecimal amount;
    private long createTime;
    private String key;
    private int state;
    private String stateName;
    private String tradeNo;
    private String typeName;

    public BigDecimal getAmount() {
        return this.amount;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getKey() {
        return this.key;
    }

    public int getState() {
        return this.state;
    }

    public String getStateName() {
        return this.stateName;
    }

    public String getTradeNo() {
        return this.tradeNo;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setStateName(String str) {
        this.stateName = str;
    }

    public void setTradeNo(String str) {
        this.tradeNo = str;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }
}
