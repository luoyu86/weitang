package com.chinavisionary.microtang.merchant.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MerchantProductVo extends BaseVo {
    private List<MerchantCommodityVo> commodities;
    private String name;

    public List<MerchantCommodityVo> getCommodities() {
        return this.commodities;
    }

    public String getName() {
        return this.name;
    }

    public void setCommodities(List<MerchantCommodityVo> list) {
        this.commodities = list;
    }

    public void setName(String str) {
        this.name = str;
    }
}
