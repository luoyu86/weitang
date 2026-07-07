package com.chinavisionary.microtang.login.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class InterestItemVo extends BaseVo {
    private boolean isSelect;
    private String tagKey;
    private String tagName;

    public String getTagKey() {
        return this.tagKey;
    }

    public String getTagName() {
        return this.tagName;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public void setTagKey(String str) {
        this.tagKey = str;
    }

    public void setTagName(String str) {
        this.tagName = str;
    }
}
