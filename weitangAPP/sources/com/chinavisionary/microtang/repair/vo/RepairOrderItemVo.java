package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class RepairOrderItemVo extends BaseVo {
    public static final int ACCEPT = 3;
    public static final int CANCEL = 2;
    public static final int COMMENT = 4;
    public static final int DONE = 5;
    public static final int ORDER = 1;
    private String address;
    private int commentStatus;
    private Long fromTime;
    private String repairDesc;
    private String repairName;
    private String repairOrderKey;
    private String repairPhone;
    private String repairUserKey;
    private int status;
    private String statusDesc;
    private Long toTime;

    public String getAddress() {
        return this.address;
    }

    public int getCommentStatus() {
        return this.commentStatus;
    }

    public Long getFromTime() {
        return this.fromTime;
    }

    public String getRepairDesc() {
        return this.repairDesc;
    }

    public String getRepairName() {
        return this.repairName;
    }

    public String getRepairOrderKey() {
        return this.repairOrderKey;
    }

    public String getRepairPhone() {
        return this.repairPhone;
    }

    public String getRepairUserKey() {
        return this.repairUserKey;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusDesc() {
        return this.statusDesc;
    }

    public Long getToTime() {
        return this.toTime;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCommentStatus(int i2) {
        this.commentStatus = i2;
    }

    public void setFromTime(Long l) {
        this.fromTime = l;
    }

    public void setRepairDesc(String str) {
        this.repairDesc = str;
    }

    public void setRepairName(String str) {
        this.repairName = str;
    }

    public void setRepairOrderKey(String str) {
        this.repairOrderKey = str;
    }

    public void setRepairPhone(String str) {
        this.repairPhone = str;
    }

    public void setRepairUserKey(String str) {
        this.repairUserKey = str;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setStatusDesc(String str) {
        this.statusDesc = str;
    }

    public void setToTime(Long l) {
        this.toTime = l;
    }
}
