package com.chinavisionary.microtang.contract.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class ContractListVo extends BaseVo {
    public static final int CONTRACT_STATE_OVERDUE = 18;
    public static final int CONTRACT_STATE_RESCISSION = 15;
    public static final int CONTRACT_STATE_UNRESCISSIONING = 17;
    public static final int CONTRACT_STATE_WAIT_CONFIRM = 10;
    public static final int PAY_STATE_CANCEL = 12;
    public static final int PAY_STATE_OVER = 16;
    public static final int PAY_STATE_TIME_OUT = 14;
    public static final int PAY_STATE_WAIT = 11;
    public static final int PAY_STATE_WAIT_SIGN = 13;
    private String address;
    private String assetKey;
    private boolean changeRentFlag;
    private String contractCode;
    private String contractKey;
    private int contractStatus;
    private String contractStatusName;
    private Long expireDate;
    private BigDecimal firstPayAmount;
    private boolean renewalFlag;
    private boolean rentBackFlag;
    private boolean rentBackInfoFlag;
    private BigDecimal rentFee;
    private String rentTerm;
    private Long rentTermFrom;
    private Long rentTermTo;
    private String surplusTime;

    public String getAddress() {
        return this.address;
    }

    public String getAssetKey() {
        return this.assetKey;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public int getContractStatus() {
        return this.contractStatus;
    }

    public String getContractStatusName() {
        return this.contractStatusName;
    }

    public Long getExpireDate() {
        return this.expireDate;
    }

    public BigDecimal getFirstPayAmount() {
        return this.firstPayAmount;
    }

    public BigDecimal getRentFee() {
        return this.rentFee;
    }

    public String getRentTerm() {
        return this.rentTerm;
    }

    public Long getRentTermFrom() {
        return this.rentTermFrom;
    }

    public Long getRentTermTo() {
        return this.rentTermTo;
    }

    public String getSurplusTime() {
        return this.surplusTime;
    }

    public boolean isChangeRentFlag() {
        return this.changeRentFlag;
    }

    public boolean isRenewalFlag() {
        return this.renewalFlag;
    }

    public boolean isRentBackFlag() {
        return this.rentBackFlag;
    }

    public boolean isRentBackInfoFlag() {
        return this.rentBackInfoFlag;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAssetKey(String str) {
        this.assetKey = str;
    }

    public void setChangeRentFlag(boolean z) {
        this.changeRentFlag = z;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setContractStatus(int i2) {
        this.contractStatus = i2;
    }

    public void setContractStatusName(String str) {
        this.contractStatusName = str;
    }

    public void setExpireDate(Long l) {
        this.expireDate = l;
    }

    public void setFirstPayAmount(BigDecimal bigDecimal) {
        this.firstPayAmount = bigDecimal;
    }

    public void setRenewalFlag(boolean z) {
        this.renewalFlag = z;
    }

    public void setRentBackFlag(boolean z) {
        this.rentBackFlag = z;
    }

    public void setRentBackInfoFlag(boolean z) {
        this.rentBackInfoFlag = z;
    }

    public void setRentFee(BigDecimal bigDecimal) {
        this.rentFee = bigDecimal;
    }

    public void setRentTerm(String str) {
        this.rentTerm = str;
    }

    public void setRentTermFrom(Long l) {
        this.rentTermFrom = l;
    }

    public void setRentTermTo(Long l) {
        this.rentTermTo = l;
    }

    public void setSurplusTime(String str) {
        this.surplusTime = str;
    }
}
