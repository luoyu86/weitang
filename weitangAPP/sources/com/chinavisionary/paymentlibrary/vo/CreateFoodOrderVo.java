package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CreateFoodOrderVo extends BaseVo {
    private List<String> countKey;
    private List<String> discountKey;
    private String toBePurchasedCommoditiesKey;

    public List<String> getCountKey() {
        return this.countKey;
    }

    public List<String> getDiscountKey() {
        return this.discountKey;
    }

    public String getToBePurchasedCommoditiesKey() {
        return this.toBePurchasedCommoditiesKey;
    }

    public void setCountKey(List<String> list) {
        this.countKey = list;
    }

    public void setDiscountKey(List<String> list) {
        this.discountKey = list;
    }

    public void setToBePurchasedCommoditiesKey(String str) {
        this.toBePurchasedCommoditiesKey = str;
    }
}
