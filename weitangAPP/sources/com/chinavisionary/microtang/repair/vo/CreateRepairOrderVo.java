package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CreateRepairOrderVo extends BaseVo {
    private String address;
    private String assetCategoryKey;
    private List<String> assetInstanceKey;
    private List<String> breakdownResource;
    private String customerName;
    private Long fromTime;
    private boolean isAuthOpen;
    private Long openFromTime;
    private Long openToTime;
    private String phone;
    private String reason;
    private List<String> reasonCode;
    private String remark;
    private Long toTime;

    public String getAddress() {
        return this.address;
    }

    public String getAssetCategoryKey() {
        return this.assetCategoryKey;
    }

    public List<String> getAssetInstanceKey() {
        return this.assetInstanceKey;
    }

    public boolean getAuthOpen() {
        return this.isAuthOpen;
    }

    public List<String> getBreakdownResource() {
        return this.breakdownResource;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public Long getFromTime() {
        return this.fromTime;
    }

    public Long getOpenFromTime() {
        return this.openFromTime;
    }

    public Long getOpenToTime() {
        return this.openToTime;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getReason() {
        return this.reason;
    }

    public List<String> getReasonCode() {
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

    public void setAssetCategoryKey(String str) {
        this.assetCategoryKey = str;
    }

    public void setAssetInstanceKey(List<String> list) {
        this.assetInstanceKey = list;
    }

    public void setAuthOpen(boolean z) {
        this.isAuthOpen = z;
    }

    public void setBreakdownResource(List<String> list) {
        this.breakdownResource = list;
    }

    public void setCustomerName(String str) {
        this.customerName = str;
    }

    public void setFromTime(Long l) {
        this.fromTime = l;
    }

    public void setOpenFromTime(Long l) {
        this.openFromTime = l;
    }

    public void setOpenToTime(Long l) {
        this.openToTime = l;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public void setReasonCode(List<String> list) {
        this.reasonCode = list;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setToTime(Long l) {
        this.toTime = l;
    }
}
