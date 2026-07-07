package com.chinavisionary.microtang.auth.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class MeAuthDetailsVo extends BaseVo {
    private String address;
    private long applyOpenDoorEnd;
    private long applyOpenDoorStart;
    private String applyReason;
    private String applyUserName;
    private String applyUserPhone;
    private String applyUserPosition;
    private int authDoorApprovalStatus;
    private String authDoorApprovalStatusName;
    private String authDoorKey;
    private String authResultReason;
    private Long authResultTime;
    private String orderKey;
    private String orderTitle;
    private String workOrderKey;

    public String getAddress() {
        return this.address;
    }

    public long getApplyOpenDoorEnd() {
        return this.applyOpenDoorEnd;
    }

    public long getApplyOpenDoorStart() {
        return this.applyOpenDoorStart;
    }

    public String getApplyReason() {
        return this.applyReason;
    }

    public String getApplyUserName() {
        return this.applyUserName;
    }

    public String getApplyUserPhone() {
        return this.applyUserPhone;
    }

    public String getApplyUserPosition() {
        return this.applyUserPosition;
    }

    public int getAuthDoorApprovalStatus() {
        return this.authDoorApprovalStatus;
    }

    public String getAuthDoorApprovalStatusName() {
        return this.authDoorApprovalStatusName;
    }

    public String getAuthDoorKey() {
        return this.authDoorKey;
    }

    public String getAuthResultReason() {
        return this.authResultReason;
    }

    public Long getAuthResultTime() {
        return this.authResultTime;
    }

    public String getOrderKey() {
        return this.orderKey;
    }

    public String getOrderTitle() {
        return this.orderTitle;
    }

    public String getWorkOrderKey() {
        return this.workOrderKey;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setApplyOpenDoorEnd(long j) {
        this.applyOpenDoorEnd = j;
    }

    public void setApplyOpenDoorStart(long j) {
        this.applyOpenDoorStart = j;
    }

    public void setApplyReason(String str) {
        this.applyReason = str;
    }

    public void setApplyUserName(String str) {
        this.applyUserName = str;
    }

    public void setApplyUserPhone(String str) {
        this.applyUserPhone = str;
    }

    public void setApplyUserPosition(String str) {
        this.applyUserPosition = str;
    }

    public void setAuthDoorApprovalStatus(int i2) {
        this.authDoorApprovalStatus = i2;
    }

    public void setAuthDoorApprovalStatusName(String str) {
        this.authDoorApprovalStatusName = str;
    }

    public void setAuthDoorKey(String str) {
        this.authDoorKey = str;
    }

    public void setAuthResultReason(String str) {
        this.authResultReason = str;
    }

    public void setAuthResultTime(Long l) {
        this.authResultTime = l;
    }

    public void setOrderKey(String str) {
        this.orderKey = str;
    }

    public void setOrderTitle(String str) {
        this.orderTitle = str;
    }

    public void setWorkOrderKey(String str) {
        this.workOrderKey = str;
    }
}
