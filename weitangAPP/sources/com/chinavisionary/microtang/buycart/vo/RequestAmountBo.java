package com.chinavisionary.microtang.buycart.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class RequestAmountBo extends BaseVo {
    private List<String> couponsKey;
    private List<String> discountKey;
    private String toBePurchasedCommoditiesKey;

    public List<String> getCouponsKey() {
        return this.couponsKey;
    }

    public List<String> getDiscountKey() {
        return this.discountKey;
    }

    public String getToBePurchasedCommoditiesKey() {
        return this.toBePurchasedCommoditiesKey;
    }

    public void setCouponsKey(List<String> list) {
        this.couponsKey = list;
    }

    public void setDiscountKey(List<String> list) {
        this.discountKey = list;
    }

    public void setToBePurchasedCommoditiesKey(String str) {
        this.toBePurchasedCommoditiesKey = str;
    }
}
