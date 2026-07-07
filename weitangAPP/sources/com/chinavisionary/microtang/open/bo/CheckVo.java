package com.chinavisionary.microtang.open.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class CheckVo extends BaseVo {
    private boolean isOk;
    private String key;
    private String name;
    private String url;

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isOk() {
        return this.isOk;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOk(boolean z) {
        this.isOk = z;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
