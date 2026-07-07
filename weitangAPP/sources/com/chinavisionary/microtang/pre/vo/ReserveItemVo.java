package com.chinavisionary.microtang.pre.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class ReserveItemVo extends BaseVo {
    public static final int CANCEL_STATE = 4;
    public static final int RESERVE_STATE = 3;
    public static final int ROOM_STATE_SIGN = 6;
    public static final int ROOM_STATE_SIGNING = 8;
    public static final int ROOM_STATE_SIGN_OVER = 7;
    public static final int WAIT_PAY_STATE = 1;
    public static final int WAIT_SIGN_RESERVE_PROTOCOL_STATE = 2;
    public static final int WAIT_SIGN_STATE = 5;
    private String address;
    private String assetKey;
    private Long expireTime;
    private String paymentKey;
    private String primaryKey;
    private BigDecimal rentFee;
    private String reserveCode;
    private BigDecimal reserveDeposit;
    private Long reserveExpireTime;
    private Long reserveSignDate;
    private String reserveUseName;
    private int status = -1;
    private String statusName;
    private String surplusTime;
    private int type;

    public String getAddress() {
        return this.address;
    }

    public String getAssetKey() {
        return this.assetKey;
    }

    public Long getExpireTime() {
        return this.expireTime;
    }

    public String getPaymentKey() {
        return this.paymentKey;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public BigDecimal getRentFee() {
        return this.rentFee;
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

    public String getReserveUseName() {
        return this.reserveUseName;
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

    public int getType() {
        return this.type;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAssetKey(String str) {
        this.assetKey = str;
    }

    public void setExpireTime(Long l) {
        this.expireTime = l;
    }

    public void setPaymentKey(String str) {
        this.paymentKey = str;
    }

    public void setPrimaryKey(String str) {
        this.primaryKey = str;
    }

    public void setRentFee(BigDecimal bigDecimal) {
        this.rentFee = bigDecimal;
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

    public void setReserveUseName(String str) {
        this.reserveUseName = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setStatusName(String str) {
        this.statusName = str;
    }

    public void setSurplusTime(String str) {
        this.surplusTime = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
