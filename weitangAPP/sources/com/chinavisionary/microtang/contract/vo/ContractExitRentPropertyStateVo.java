package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class ContractExitRentPropertyStateVo extends BaseVo {
    private static final int PERFECT = 6;
    private BigDecimal compensationAmount;
    private int faultType;
    private String faultTypeName;
    private String key;
    private String name;
    private boolean perfect;
    private int status;
    private String statusName;

    public BigDecimal getCompensationAmount() {
        return this.compensationAmount;
    }

    public int getFaultType() {
        return this.faultType;
    }

    public String getFaultTypeName() {
        return this.faultTypeName;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public boolean isPerfect() {
        return 6 == this.status;
    }

    public void setCompensationAmount(BigDecimal bigDecimal) {
        this.compensationAmount = bigDecimal;
    }

    public void setFaultType(int i2) {
        this.faultType = i2;
    }

    public void setFaultTypeName(String str) {
        this.faultTypeName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setStatusName(String str) {
        this.statusName = str;
    }
}
