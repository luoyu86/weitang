package com.chinavisionary.microtang.pre.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class ReserveRoomInfoVo extends BaseVo {
    private String address;
    private String assetInstanceKey;
    private BigDecimal depositFee;
    private String key;
    private String message;
    private BigDecimal rentFee;
    private Long reserveSignDate;
    private String reserveUserIdCardNo;
    private String reserveUserName;
    private String reserveUserPhone;
    private boolean success;

    public String getAddress() {
        return this.address;
    }

    public String getAssetInstanceKey() {
        return this.assetInstanceKey;
    }

    public BigDecimal getDepositFee() {
        return this.depositFee;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public BigDecimal getRentFee() {
        return this.rentFee;
    }

    public Long getReserveSignDate() {
        return this.reserveSignDate;
    }

    public String getReserveUserIdCardNo() {
        return this.reserveUserIdCardNo;
    }

    public String getReserveUserName() {
        return this.reserveUserName;
    }

    public String getReserveUserPhone() {
        return this.reserveUserPhone;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAssetInstanceKey(String str) {
        this.assetInstanceKey = str;
    }

    public void setDepositFee(BigDecimal bigDecimal) {
        this.depositFee = bigDecimal;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setRentFee(BigDecimal bigDecimal) {
        this.rentFee = bigDecimal;
    }

    public void setReserveSignDate(Long l) {
        this.reserveSignDate = l;
    }

    public void setReserveUserIdCardNo(String str) {
        this.reserveUserIdCardNo = str;
    }

    public void setReserveUserName(String str) {
        this.reserveUserName = str;
    }

    public void setReserveUserPhone(String str) {
        this.reserveUserPhone = str;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }
}
