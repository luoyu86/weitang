package com.chinavisionary.paymentlibrary.vo;

import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class PayStateVo extends NewBaseVo {
    private BigDecimal arrivalAmount;
    private String body;
    private BigDecimal cashAmount;
    private Long createTime;
    private String createUser;
    private Long expiryDate;
    private String key;
    private BigDecimal payAmount;
    private int payChannel;
    private String payCode;
    private Long payDate;
    private String payId;
    private int payStatus;
    private String payStatusName;
    private Boolean paySuccess = Boolean.FALSE;
    private int payType;
    private String payTypeName;
    private String paymentKey;
    private Integer paymentState;

    public BigDecimal getArrivalAmount() {
        return this.arrivalAmount;
    }

    public String getBody() {
        return this.body;
    }

    public BigDecimal getCashAmount() {
        return this.cashAmount;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public Long getExpiryDate() {
        return this.expiryDate;
    }

    public String getKey() {
        return this.key;
    }

    public BigDecimal getPayAmount() {
        return this.payAmount;
    }

    public int getPayChannel() {
        return this.payChannel;
    }

    public String getPayCode() {
        return this.payCode;
    }

    public Long getPayDate() {
        return this.payDate;
    }

    public String getPayId() {
        return this.payId;
    }

    public int getPayStatus() {
        if (x.isNotNull(this.payId)) {
            if (getPaySuccess().booleanValue()) {
                this.payStatus = 1;
            } else {
                this.payStatus = 0;
            }
        }
        return this.payStatus;
    }

    public String getPayStatusName() {
        return this.payStatusName;
    }

    public Boolean getPaySuccess() {
        Integer num = this.paymentState;
        if (num != null) {
            return Boolean.valueOf(num.intValue() == 1);
        }
        return this.paySuccess;
    }

    public int getPayType() {
        return this.payType;
    }

    public String getPayTypeName() {
        return this.payTypeName;
    }

    public String getPaymentKey() {
        return this.paymentKey;
    }

    public Integer getPaymentState() {
        return this.paymentState;
    }

    public void setArrivalAmount(BigDecimal bigDecimal) {
        this.arrivalAmount = bigDecimal;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setCashAmount(BigDecimal bigDecimal) {
        this.cashAmount = bigDecimal;
    }

    public void setCreateTime(Long l) {
        this.createTime = l;
    }

    public void setCreateUser(String str) {
        this.createUser = str;
    }

    public void setExpiryDate(Long l) {
        this.expiryDate = l;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPayAmount(BigDecimal bigDecimal) {
        this.payAmount = bigDecimal;
    }

    public void setPayChannel(int i2) {
        this.payChannel = i2;
    }

    public void setPayCode(String str) {
        this.payCode = str;
    }

    public void setPayDate(Long l) {
        this.payDate = l;
    }

    public void setPayId(String str) {
        this.payId = str;
    }

    public void setPayStatus(int i2) {
        this.payStatus = i2;
    }

    public void setPayStatusName(String str) {
        this.payStatusName = str;
    }

    public void setPaySuccess(Boolean bool) {
        this.paySuccess = bool;
    }

    public void setPayType(int i2) {
        this.payType = i2;
    }

    public void setPayTypeName(String str) {
        this.payTypeName = str;
    }

    public void setPaymentKey(String str) {
        this.paymentKey = str;
    }

    public void setPaymentState(Integer num) {
        this.paymentState = num;
    }
}
