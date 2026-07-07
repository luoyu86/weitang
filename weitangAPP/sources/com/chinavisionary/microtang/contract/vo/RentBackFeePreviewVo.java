package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class RentBackFeePreviewVo extends BaseVo {
    private BigDecimal amount;
    private BigDecimal damagesFees;
    private BigDecimal depositFees;
    private String feeTypeName;
    private String key;
    private String message;
    private BigDecimal networkFees;
    private BigDecimal otherFees;
    private BigDecimal rentFees;
    private BigDecimal serviceFees;
    private boolean success;
    private BigDecimal totalFees;

    public BigDecimal getAmount() {
        return this.amount;
    }

    public BigDecimal getDamagesFees() {
        return this.damagesFees;
    }

    public BigDecimal getDepositFees() {
        return this.depositFees;
    }

    public String getFeeTypeName() {
        return this.feeTypeName;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public BigDecimal getNetworkFees() {
        return this.networkFees;
    }

    public BigDecimal getOtherFees() {
        return this.otherFees;
    }

    public BigDecimal getRentFees() {
        return this.rentFees;
    }

    public BigDecimal getServiceFees() {
        return this.serviceFees;
    }

    public BigDecimal getTotalFees() {
        return this.totalFees;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    public void setDamagesFees(BigDecimal bigDecimal) {
        this.damagesFees = bigDecimal;
    }

    public void setDepositFees(BigDecimal bigDecimal) {
        this.depositFees = bigDecimal;
    }

    public void setFeeTypeName(String str) {
        this.feeTypeName = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setNetworkFees(BigDecimal bigDecimal) {
        this.networkFees = bigDecimal;
    }

    public void setOtherFees(BigDecimal bigDecimal) {
        this.otherFees = bigDecimal;
    }

    public void setRentFees(BigDecimal bigDecimal) {
        this.rentFees = bigDecimal;
    }

    public void setServiceFees(BigDecimal bigDecimal) {
        this.serviceFees = bigDecimal;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setTotalFees(BigDecimal bigDecimal) {
        this.totalFees = bigDecimal;
    }
}
