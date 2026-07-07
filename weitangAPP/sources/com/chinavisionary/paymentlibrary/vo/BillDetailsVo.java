package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class BillDetailsVo extends BaseVo {
    public static final int CANCEL_PAY = 4;
    public static final int EXIT_PAY = 6;
    public static final int PAY_END = 3;
    public static final int PAY_FAILED = 2;
    public static final int PAY_OVER = 1;
    public static final int PAY_TIME_OUT = 5;
    public static final int WAIT_PAY = 0;
    private String address;
    private BigDecimal amount;
    private List<DetailsVo> billDetails;
    private Integer billStatus;
    private String billStatusName;
    private String body;
    private String contractCode;
    private String contractKey;
    private String key;
    private BigDecimal lateFee;
    private int lateFeeDays;
    private Integer paidPeriodNumber;
    private String payChannel;
    private Long payDate;
    private String paymentKey;
    private Integer periodNumber;
    private String unitPrice;

    public static class DetailsVo extends BaseVo {
        private String name;
        private String value;

        public String getName() {
            return this.name;
        }

        public String getValue() {
            return this.value;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setValue(String str) {
            this.value = str;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public List<DetailsVo> getBillDetails() {
        return this.billDetails;
    }

    public Integer getBillStatus() {
        return this.billStatus;
    }

    public String getBillStatusName() {
        return this.billStatusName;
    }

    public String getBody() {
        return this.body;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public String getKey() {
        return this.key;
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

    public String getPayChannel() {
        return this.payChannel;
    }

    public Long getPayDate() {
        return this.payDate;
    }

    public String getPaymentKey() {
        return this.paymentKey;
    }

    public Integer getPeriodNumber() {
        return this.periodNumber;
    }

    public String getUnitPrice() {
        return this.unitPrice;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    public void setBillDetails(List<DetailsVo> list) {
        this.billDetails = list;
    }

    public void setBillStatus(Integer num) {
        this.billStatus = num;
    }

    public void setBillStatusName(String str) {
        this.billStatusName = str;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setKey(String str) {
        this.key = str;
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

    public void setPayChannel(String str) {
        this.payChannel = str;
    }

    public void setPayDate(Long l) {
        this.payDate = l;
    }

    public void setPaymentKey(String str) {
        this.paymentKey = str;
    }

    public void setPeriodNumber(Integer num) {
        this.periodNumber = num;
    }

    public void setUnitPrice(String str) {
        this.unitPrice = str;
    }
}
