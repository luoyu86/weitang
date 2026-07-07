package com.chinavisionary.microtang.buycart.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RequestInitBuyCartOrderVo extends BaseVo {
    private String addressKey;
    private int deliveryMethod;
    private List<MerchantRemarkBean> merchantRemark;
    private String toBePurchasedCommoditiesKey;

    public static class MerchantRemarkBean extends BaseVo {
        private String merchantKey;
        private String remark;

        public String getMerchantKey() {
            return this.merchantKey;
        }

        public String getRemark() {
            return this.remark;
        }

        public void setMerchantKey(String str) {
            this.merchantKey = str;
        }

        public void setRemark(String str) {
            this.remark = str;
        }
    }

    public String getAddressKey() {
        return this.addressKey;
    }

    public int getDeliveryMethod() {
        return this.deliveryMethod;
    }

    public List<MerchantRemarkBean> getMerchantRemark() {
        return this.merchantRemark;
    }

    public String getToBePurchasedCommoditiesKey() {
        return this.toBePurchasedCommoditiesKey;
    }

    public void setAddressKey(String str) {
        this.addressKey = str;
    }

    public void setDeliveryMethod(int i2) {
        this.deliveryMethod = i2;
    }

    public void setMerchantRemark(List<MerchantRemarkBean> list) {
        this.merchantRemark = list;
    }

    public void setToBePurchasedCommoditiesKey(String str) {
        this.toBePurchasedCommoditiesKey = str;
    }
}
