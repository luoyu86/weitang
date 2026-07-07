package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseConfirmContactVo extends BaseVo {
    private String address;
    private String contractKey;
    private BigDecimal depositFee;
    private String key;
    private BigDecimal managementFee;
    private String message;
    private String orderKey;
    private BigDecimal payFee;
    private String paymentMethod;
    private BigDecimal rentFee;
    private String rentKey;
    private String rentPeriod;
    private BigDecimal rentTotalFee;
    private boolean success;

    public String getAddress() {
        return this.address;
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public BigDecimal getDepositFee() {
        return this.depositFee;
    }

    public String getKey() {
        return this.key;
    }

    public BigDecimal getManagementFee() {
        return this.managementFee;
    }

    public String getMessage() {
        return this.message;
    }

    public String getOrderKey() {
        return this.orderKey;
    }

    public BigDecimal getPayFee() {
        return this.payFee;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public BigDecimal getRentFee() {
        return this.rentFee;
    }

    public String getRentKey() {
        return this.rentKey;
    }

    public String getRentPeriod() {
        return this.rentPeriod;
    }

    public BigDecimal getRentTotalFee() {
        return this.rentTotalFee;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setDepositFee(BigDecimal bigDecimal) {
        this.depositFee = bigDecimal;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setManagementFee(BigDecimal bigDecimal) {
        this.managementFee = bigDecimal;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setOrderKey(String str) {
        this.orderKey = str;
    }

    public void setPayFee(BigDecimal bigDecimal) {
        this.payFee = bigDecimal;
    }

    public void setPaymentMethod(String str) {
        this.paymentMethod = str;
    }

    public void setRentFee(BigDecimal bigDecimal) {
        this.rentFee = bigDecimal;
    }

    public void setRentKey(String str) {
        this.rentKey = str;
    }

    public void setRentPeriod(String str) {
        this.rentPeriod = str;
    }

    public void setRentTotalFee(BigDecimal bigDecimal) {
        this.rentTotalFee = bigDecimal;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
