package com.chinavisionary.microtang.room.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityListBean extends BaseVo {
    private int activityType;
    private String activityTypeName;
    private String activityUrl;
    private String coverUrl;
    private String endTime;
    private String primaryKey;
    private String startTime;
    private String title;

    public int getActivityType() {
        return this.activityType;
    }

    public String getActivityTypeName() {
        return this.activityTypeName;
    }

    public String getActivityUrl() {
        return this.activityUrl;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getTitle() {
        return this.title;
    }

    public void setActivityType(int i2) {
        this.activityType = i2;
    }

    public void setActivityTypeName(String str) {
        this.activityTypeName = str;
    }

    public void setActivityUrl(String str) {
        this.activityUrl = str;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setEndTime(String str) {
        this.endTime = str;
    }

    public void setPrimaryKey(String str) {
        this.primaryKey = str;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
