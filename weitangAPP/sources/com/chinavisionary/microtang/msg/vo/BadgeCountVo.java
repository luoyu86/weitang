package com.chinavisionary.microtang.msg.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;

/* JADX INFO: loaded from: classes.dex */
public class BadgeCountVo extends NewBaseVo {
    public static final int TYPE_NUMBER = 1;
    public static final int TYPE_POINT = 0;
    private boolean isShowNumber;
    private boolean isShowPoint;
    private int showType;
    private int unreadCount;

    public int getShowType() {
        return this.showType;
    }

    public int getUnreadCount() {
        return this.unreadCount;
    }

    public boolean isShowNumber() {
        return this.showType == 1;
    }

    public boolean isShowPoint() {
        return this.showType == 0;
    }

    public void setShowType(int i2) {
        this.showType = i2;
    }

    public void setUnreadCount(int i2) {
        this.unreadCount = i2;
    }
}
