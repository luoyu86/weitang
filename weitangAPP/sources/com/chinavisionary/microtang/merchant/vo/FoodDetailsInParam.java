package com.chinavisionary.microtang.merchant.vo;

import c.e.c.y.e.b;
import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class FoodDetailsInParam extends BaseVo {
    private b iBuyCartView;
    private boolean isOpenMerchant;
    private String merchantKey;
    private String merchantName;
    private String merchantPhone;
    private String productKey;

    public String getMerchantKey() {
        return this.merchantKey;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getMerchantPhone() {
        return this.merchantPhone;
    }

    public String getProductKey() {
        return this.productKey;
    }

    public b getiBuyCartView() {
        return this.iBuyCartView;
    }

    public boolean isOpenMerchant() {
        return this.isOpenMerchant;
    }

    public void setMerchantKey(String str) {
        this.merchantKey = str;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public void setMerchantPhone(String str) {
        this.merchantPhone = str;
    }

    public void setOpenMerchant(boolean z) {
        this.isOpenMerchant = z;
    }

    public void setProductKey(String str) {
        this.productKey = str;
    }

    public void setiBuyCartView(b bVar) {
        this.iBuyCartView = bVar;
    }
}
