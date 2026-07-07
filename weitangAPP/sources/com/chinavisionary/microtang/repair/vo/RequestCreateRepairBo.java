package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RequestCreateRepairBo extends BaseVo {
    private String address;
    private String assetInstanceKey;
    private String assetKey;
    private List<String> breakdownResource;
    private String catalogKey;
    private String customerName;
    private Long fromTime;
    private boolean isAuthOpen;
    private String phone;
    private String reasonCode;
    private String remark;
    private Long toTime;

    public String getAddress() {
        return this.address;
    }

    public String getAssetInstanceKey() {
        return this.assetInstanceKey;
    }

    public String getAssetKey() {
        return this.assetKey;
    }

    public List<String> getBreakdownResource() {
        return this.breakdownResource;
    }

    public String getCatalogKey() {
        return this.catalogKey;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public Long getFromTime() {
        return this.fromTime;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getReasonCode() {
        return this.reasonCode;
    }

    public String getRemark() {
        return this.remark;
    }

    public Long getToTime() {
        return this.toTime;
    }

    public boolean isAuthOpen() {
        return this.isAuthOpen;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAssetInstanceKey(String str) {
        this.assetInstanceKey = str;
    }

    public void setAssetKey(String str) {
        this.assetKey = str;
    }

    public void setAuthOpen(boolean z) {
        this.isAuthOpen = z;
    }

    public void setBreakdownResource(List<String> list) {
        this.breakdownResource = list;
    }

    public void setCatalogKey(String str) {
        this.catalogKey = str;
    }

    public void setCustomerName(String str) {
        this.customerName = str;
    }

    public void setFromTime(Long l) {
        this.fromTime = l;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setReasonCode(String str) {
        this.reasonCode = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setToTime(Long l) {
        this.toTime = l;
    }
}
