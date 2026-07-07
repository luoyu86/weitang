package com.chinavisionary.microtang.main.event;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class EventBadgeMsgVo extends BaseVo {
    private int badgeNumber;
    private boolean isShow;
    private boolean isShowPaint;

    public int getBadgeNumber() {
        return this.badgeNumber;
    }

    public boolean isShow() {
        return this.isShow;
    }

    public boolean isShowPaint() {
        return this.isShowPaint;
    }

    public void setBadgeNumber(int i2) {
        this.badgeNumber = i2;
    }

    public void setShow(boolean z) {
        this.isShow = z;
    }

    public void setShowPaint(boolean z) {
        this.isShowPaint = z;
    }
}
