package com.chinavisionary.microtang.open.bo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class RequestLockParamBo extends BaseVo {
    private String assetInstanceKey;
    private String contractKey;

    public String getAssetInstanceKey() {
        return this.assetInstanceKey;
    }

    public String getContractKey() {
        return this.contractKey;
    }

    public void setAssetInstanceKey(String str) {
        this.assetInstanceKey = str;
    }

    public void setContractKey(String str) {
        this.contractKey = str;
    }
}
