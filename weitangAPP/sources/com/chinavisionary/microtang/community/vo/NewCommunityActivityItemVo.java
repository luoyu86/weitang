package com.chinavisionary.microtang.community.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class NewCommunityActivityItemVo extends BaseVo {
    public static final int CAN_JOIN_STATE = 1;
    public static final int COMMUNITY_ACTIVITY_ITEM = 122;
    public static final int COMPLETE_STATE = 3;
    public static final int PROGRESS_STATE = 2;
    private static final int SHOW_JOIN_BTN = 1;
    private static final int SHOW_SIGN_BTN = 2;
    private static final int TRUE = 1;
    public Object Longitude;
    public String activityLab;
    public String address;
    public Object applyAvatarList;
    public Long applyEndTime;
    public boolean applyFlag;
    public int applyNum;
    public Long applyStartTime;
    public String coverUrl;
    public Long createTime;
    public String distance;
    public Long endTime;
    public boolean finishFlag;
    public String h5Url;
    private Boolean isComment;
    private int isScore;
    public int maxNumber;
    public boolean onFlag;
    public String primaryKey;
    public String showAppAddress;
    private int showScoreBtn;
    public Long startTime;
    public String title;
    public String type;
    private int viewType = 122;

    public String getActivityLab() {
        return this.activityLab;
    }

    public String getAddress() {
        return this.address;
    }

    public Object getApplyAvatarList() {
        return this.applyAvatarList;
    }

    public Long getApplyEndTime() {
        return this.applyEndTime;
    }

    public int getApplyNum() {
        return this.applyNum;
    }

    public Long getApplyStartTime() {
        return this.applyStartTime;
    }

    public Boolean getComment() {
        if (this.isScore == 1) {
            this.isComment = Boolean.TRUE;
        } else if (this.showScoreBtn == 1) {
            this.isComment = Boolean.FALSE;
        }
        return this.isComment;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public String getDistance() {
        return this.distance;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public String getH5Url() {
        return this.h5Url;
    }

    public Object getLongitude() {
        return this.Longitude;
    }

    public int getMaxNumber() {
        return this.maxNumber;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public String getShowAppAddress() {
        return this.showAppAddress;
    }

    public int getShowScoreBtn() {
        return this.showScoreBtn;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public String getTitle() {
        return this.title;
    }

    public String getType() {
        return this.type;
    }

    public int getViewType() {
        return this.viewType;
    }

    public boolean isApplyFlag() {
        return this.applyFlag;
    }

    public boolean isFinishFlag() {
        return this.finishFlag;
    }

    public boolean isOnFlag() {
        return this.onFlag;
    }

    public int isScore() {
        return this.isScore;
    }

    public void setActivityLab(String str) {
        this.activityLab = str;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setApplyAvatarList(Object obj) {
        this.applyAvatarList = obj;
    }

    public void setApplyEndTime(Long l) {
        this.applyEndTime = l;
    }

    public void setApplyFlag(boolean z) {
        this.applyFlag = z;
    }

    public void setApplyNum(int i2) {
        this.applyNum = i2;
    }

    public void setApplyStartTime(Long l) {
        this.applyStartTime = l;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setCreateTime(Long l) {
        this.createTime = l;
    }

    public void setDistance(String str) {
        this.distance = str;
    }

    public void setEndTime(Long l) {
        this.endTime = l;
    }

    public void setFinishFlag(boolean z) {
        this.finishFlag = z;
    }

    public void setH5Url(String str) {
        this.h5Url = str;
    }

    public void setLongitude(Object obj) {
        this.Longitude = obj;
    }

    public void setMaxNumber(int i2) {
        this.maxNumber = i2;
    }

    public void setOnFlag(boolean z) {
        this.onFlag = z;
    }

    public void setPrimaryKey(String str) {
        this.primaryKey = str;
    }

    public void setScore(int i2) {
        this.isScore = i2;
    }

    public void setShowAppAddress(String str) {
        this.showAppAddress = str;
    }

    public void setShowScoreBtn(int i2) {
        this.showScoreBtn = i2;
    }

    public void setStartTime(Long l) {
        this.startTime = l;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setViewType(int i2) {
        this.viewType = i2;
    }
}
