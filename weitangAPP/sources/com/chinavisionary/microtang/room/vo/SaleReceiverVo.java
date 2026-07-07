package com.chinavisionary.microtang.room.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class SaleReceiverVo extends BaseVo {
    private String cost;
    private String couponCategory;
    private boolean isCheck;
    private boolean isExpire;
    private boolean isUnavailable;
    private String key;
    private String unavailableReason;
    private String useRule;
    private Long validDate;

    public String getCost() {
        return this.cost;
    }

    public String getCouponCategory() {
        return this.couponCategory;
    }

    public String getKey() {
        return this.key;
    }

    public String getUnavailableReason() {
        return this.unavailableReason;
    }

    public String getUseRule() {
        return this.useRule;
    }

    public Long getValidDate() {
        return this.validDate;
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public boolean isExpire() {
        return this.isExpire;
    }

    public boolean isUnavailable() {
        return this.isUnavailable;
    }

    public void setCheck(boolean z) {
        this.isCheck = z;
    }

    public void setCost(String str) {
        this.cost = str;
    }

    public void setCouponCategory(String str) {
        this.couponCategory = str;
    }

    public void setExpire(boolean z) {
        this.isExpire = z;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setUnavailable(boolean z) {
        this.isUnavailable = z;
    }

    public void setUnavailableReason(String str) {
        this.unavailableReason = str;
    }

    public void setUseRule(String str) {
        this.useRule = str;
    }

    public void setValidDate(Long l) {
        this.validDate = l;
    }
}
