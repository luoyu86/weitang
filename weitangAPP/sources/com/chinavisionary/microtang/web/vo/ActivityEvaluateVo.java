package com.chinavisionary.microtang.web.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityEvaluateVo extends BaseVo {
    private String activityName;
    private String activityPrimaryKey;
    private boolean isEvaluate;

    public String getActivityName() {
        return this.activityName;
    }

    public String getActivityPrimaryKey() {
        return this.activityPrimaryKey;
    }

    public boolean isEvaluate() {
        return this.isEvaluate;
    }

    public void setActivityName(String str) {
        this.activityName = str;
    }

    public void setActivityPrimaryKey(String str) {
        this.activityPrimaryKey = str;
    }

    public void setEvaluate(boolean z) {
        this.isEvaluate = z;
    }
}
