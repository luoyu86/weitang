package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes2.dex */
public class MinusResultVo extends BaseVo {
    private boolean isCanMinus;
    private String payCostTypeName;

    public String getPayCostTypeName() {
        return this.payCostTypeName;
    }

    public boolean isCanMinus() {
        return this.isCanMinus;
    }

    public void setCanMinus(boolean z) {
        this.isCanMinus = z;
    }

    public void setPayCostTypeName(String str) {
        this.payCostTypeName = str;
    }
}
