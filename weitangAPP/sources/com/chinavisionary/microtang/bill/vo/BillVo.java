package com.chinavisionary.microtang.bill.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class BillVo extends BaseVo {
    public static final int PAY_SUCCESS = 1;
    public static final int WAIT_PAY = 0;
    private BigDecimal amount;
    private String billKey;
    private Long billPeriodFrom;
    private Long billPeriodTo;
    private int billStatus;
    private String billStatusName;
    private String body;
    private String buyNumber;
    private String contractKey;
    private Long expiryDate;
    private BigDecimal lateFee;
    private int lateFeeDays;
    private Integer paidPeriodNumber;
    private Long payDate;
    private String paymentKey;
    private String surplusTime;
    private String unitPrice;

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getBillKey() {
        return this.billKey;
    }

    public Long getBillPeriodFrom() {
        return this.billPeriodFrom;
    }

    public Long getBillPeriodTo() {
        return this.billPeriodTo;
    }

    public int getBillStatus() {
        return this.billStatus;
    }

    public String getBillStatusName() {
        return this.billStatusName;
    }

    public String getBody() {
        return this.body;
    }

    public String getBuyNumber() {
        return this.buyNumber;
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public Long getExpiryDate() {
        return this.expiryDate;
    }

    public BigDecimal getLateFee() {
        return this.lateFee;
    }

    public int getLateFeeDays() {
        return this.lateFeeDays;
    }

    public Integer getPaidPeriodNumber() {
        return this.paidPeriodNumber;
    }

    public Long getPayDate() {
        return this.payDate;
    }

    public String getPaymentKey() {
        return this.paymentKey;
    }

    public String getSurplusTime() {
        return this.surplusTime;
    }

    public String getUnitPrice() {
        return this.unitPrice;
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    public void setBillKey(String str) {
        this.billKey = str;
    }

    public void setBillPeriodFrom(Long l) {
        this.billPeriodFrom = l;
    }

    public void setBillPeriodTo(Long l) {
        this.billPeriodTo = l;
    }

    public void setBillStatus(int i2) {
        this.billStatus = i2;
    }

    public void setBillStatusName(String str) {
        this.billStatusName = str;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setBuyNumber(String str) {
        this.buyNumber = str;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setExpiryDate(Long l) {
        this.expiryDate = l;
    }

    public void setLateFee(BigDecimal bigDecimal) {
        this.lateFee = bigDecimal;
    }

    public void setLateFeeDays(int i2) {
        this.lateFeeDays = i2;
    }

    public void setPaidPeriodNumber(Integer num) {
        this.paidPeriodNumber = num;
    }

    public void setPayDate(Long l) {
        this.payDate = l;
    }

    public void setPaymentKey(String str) {
        this.paymentKey = str;
    }

    public void setSurplusTime(String str) {
        this.surplusTime = str;
    }

    public void setUnitPrice(String str) {
        this.unitPrice = str;
    }
}
