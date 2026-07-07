package com.chinavisionary.core.app.event;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class EventUpdateUserInfoVo extends BaseVo {
    public static final int WHAT_UPDATE_USER = 0;
    public static final int WHAT_UPDATE_USER_INFO = 1;
    public static final int WHAT_UPDATE_USER_INFO_AND_WATER_ELE = 2;
    private int whatMsg;

    public int getWhatMsg() {
        return this.whatMsg;
    }

    public void setWhatMsg(int i2) {
        this.whatMsg = i2;
    }
}
