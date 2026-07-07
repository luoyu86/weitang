package com.chinavisionary.core.app.event;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class EventUpdateSelectRoom extends BaseVo {
    private boolean isShowMore;
    private String key;
    private String name;

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public boolean isShowMore() {
        return this.isShowMore;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setShowMore(boolean z) {
        this.isShowMore = z;
    }
}
