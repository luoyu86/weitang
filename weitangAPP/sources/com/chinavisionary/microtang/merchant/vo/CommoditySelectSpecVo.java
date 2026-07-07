package com.chinavisionary.microtang.merchant.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommoditySelectSpecVo extends BaseVo {
    private int buyNumber;
    private String commodityKey;
    private String specKey;
    private List<String> tags;

    public int getBuyNumber() {
        return this.buyNumber;
    }

    public String getCommodityKey() {
        return this.commodityKey;
    }

    public String getSpecKey() {
        return this.specKey;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setBuyNumber(int i2) {
        this.buyNumber = i2;
    }

    public void setCommodityKey(String str) {
        this.commodityKey = str;
    }

    public void setSpecKey(String str) {
        this.specKey = str;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }
}
