package com.chinavisionary.microtang.room.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class RoomDeviceListItemVo extends BaseVo {
    public static final int CONTENT_TYPE = 3;
    public static final int CONTENT_WEB_TYPE = 39;
    private String coverUrl;
    private int itemType = 3;
    private String name;

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getName() {
        return this.name;
    }

    public void setCoverUrl(String str) {
        this.coverUrl = str;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setName(String str) {
        this.name = str;
    }
}
