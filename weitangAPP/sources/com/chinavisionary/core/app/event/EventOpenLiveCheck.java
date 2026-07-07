package com.chinavisionary.core.app.event;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class EventOpenLiveCheck extends BaseVo {
    private String contractKey;
    private boolean isFirstOpenUnlock;

    public String getContractKey() {
        return this.contractKey;
    }

    public boolean isFirstOpenUnlock() {
        return this.isFirstOpenUnlock;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }

    public void setFirstOpenUnlock(boolean z) {
        this.isFirstOpenUnlock = z;
    }
}
