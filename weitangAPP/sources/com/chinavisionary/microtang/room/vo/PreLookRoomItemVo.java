package com.chinavisionary.microtang.room.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class PreLookRoomItemVo extends BaseVo {
    private String date;
    private boolean hasSelect;
    private Long time;
    private String week;

    public String getDate() {
        return this.date;
    }

    public Long getTime() {
        return this.time;
    }

    public String getWeek() {
        return this.week;
    }

    public boolean isHasSelect() {
        return this.hasSelect;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setHasSelect(boolean z) {
        this.hasSelect = z;
    }

    public void setTime(Long l) {
        this.time = l;
    }

    public void setWeek(String str) {
        this.week = str;
    }
}
