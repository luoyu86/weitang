package com.chinavisionary.microtang.pre.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ReserveDetailsVo extends BaseVo {
    private String address;
    private String assetKey;
    private String cardNo;
    private int cardType;
    private String cardTypeName;
    private Long createTime;
    private String createUser;
    private Long expireTime;
    private List<FeesBean> fees;
    private String key;
    private String message;
    private String name;
    private String paymentKey;
    private String primaryKey;
    private String remark;
    private String reserveCode;
    private BigDecimal reserveDeposit;
    private Long reserveExpireTime;
    private Long reserveSignDate;
    private String reserveUseKey;
    private String reserveViewUrl;
    private int status;
    private String statusName;
    private boolean success;
    private String surplusTime;

    public static class FeesBean extends BaseVo {
        private BigDecimal amount;
        private int feeType;
        private String feeTypeName;
        private String primaryKey;
        private String remark;
        private String reserveKey;

        public BigDecimal getAmount() {
            return this.amount;
        }

        public int getFeeType() {
            return this.feeType;
        }

        public String getFeeTypeName() {
            return this.feeTypeName;
        }

        public String getPrimaryKey() {
            return this.primaryKey;
        }

        public String getRemark() {
            return this.remark;
        }

        public String getReserveKey() {
            return this.reserveKey;
        }

        public void setAmount(BigDecimal bigDecimal) {
            this.amount = bigDecimal;
        }

        public void setFeeType(int i2) {
            this.feeType = i2;
        }

        public void setFeeTypeName(String str) {
            this.feeTypeName = str;
        }

        public void setPrimaryKey(String str) {
            this.primaryKey = str;
        }

        public void setRemark(String str) {
            this.remark = str;
        }

        public void setReserveKey(String str) {
            this.reserveKey = str;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public String getAssetKey() {
        return this.assetKey;
    }

    public String getCardNo() {
        return this.cardNo;
    }

    public int getCardType() {
        return this.cardType;
    }

    public String getCardTypeName() {
        return this.cardTypeName;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public String getCreateUser() {
        return this.createUser;
    }

    public Long getExpireTime() {
        return this.expireTime;
    }

    public List<FeesBean> getFees() {
        return this.fees;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public String getName() {
        return this.name;
    }

    public String getPaymentKey() {
        return this.paymentKey;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getReserveCode() {
        return this.reserveCode;
    }

    public BigDecimal getReserveDeposit() {
        return this.reserveDeposit;
    }

    public Long getReserveExpireTime() {
        return this.reserveExpireTime;
    }

    public Long getReserveSignDate() {
        return this.reserveSignDate;
    }

    public String getReserveUseKey() {
        return this.reserveUseKey;
    }

    public String getReserveViewUrl() {
        return this.reserveViewUrl;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public String getSurplusTime() {
        return this.surplusTime;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAssetKey(String str) {
        this.assetKey = str;
    }

    public void setCardNo(String str) {
        this.cardNo = str;
    }

    public void setCardType(int i2) {
        this.cardType = i2;
    }

    public void setCardTypeName(String str) {
        this.cardTypeName = str;
    }

    public void setCreateTime(Long l) {
        this.createTime = l;
    }

    public void setCreateUser(String str) {
        this.createUser = str;
    }

    public void setExpireTime(Long l) {
        this.expireTime = l;
    }

    public void setFees(List<FeesBean> list) {
        this.fees = list;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPaymentKey(String str) {
        this.paymentKey = str;
    }

    public void setPrimaryKey(String str) {
        this.primaryKey = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setReserveCode(String str) {
        this.reserveCode = str;
    }

    public void setReserveDeposit(BigDecimal bigDecimal) {
        this.reserveDeposit = bigDecimal;
    }

    public void setReserveExpireTime(Long l) {
        this.reserveExpireTime = l;
    }

    public void setReserveSignDate(Long l) {
        this.reserveSignDate = l;
    }

    public void setReserveUseKey(String str) {
        this.reserveUseKey = str;
    }

    public void setReserveViewUrl(String str) {
        this.reserveViewUrl = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setStatusName(String str) {
        this.statusName = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setSurplusTime(String str) {
        this.surplusTime = str;
    }
}
