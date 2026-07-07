package com.chinavisionary.microtang.repair.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class RepairOrderVo extends BaseVo {
    public static final int CANCEL_STATE = 2;
    public static final int DOWN_HANDLER_STATE = 5;
    public static final int WAIT_COMMENT_STATE = 4;
    public static final int WAIT_HANDLER_STATE = 3;
    public static final int WAIT_STATE = 1;
    private String address;
    private String content;
    private Long endTime;
    private String key;
    private String personName;
    private String personPhone;
    private Long startTime;
    private int state;
    private String stateName;

    public String getAddress() {
        return this.address;
    }

    public String getContent() {
        return this.content;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public String getKey() {
        return this.key;
    }

    public String getPersonName() {
        return this.personName;
    }

    public String getPersonPhone() {
        return this.personPhone;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public int getState() {
        return this.state;
    }

    public String getStateName() {
        return this.stateName;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setEndTime(Long l) {
        this.endTime = l;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setPersonName(String str) {
        this.personName = str;
    }

    public void setPersonPhone(String str) {
        this.personPhone = str;
    }

    public void setStartTime(Long l) {
        this.startTime = l;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setStateName(String str) {
        this.stateName = str;
    }
}
