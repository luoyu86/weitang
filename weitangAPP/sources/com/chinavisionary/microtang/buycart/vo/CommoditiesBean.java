package com.chinavisionary.microtang.buycart.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class CommoditiesBean extends BaseVo {
    private ResourceVo commodityCover;
    private String commodityName;
    private String commoditySpecificationKey;
    private String commoditySpecificationName;
    private BigDecimal price;
    private int quantity;

    public ResourceVo getCommodityCover() {
        return this.commodityCover;
    }

    public String getCommodityName() {
        return this.commodityName;
    }

    public String getCommoditySpecificationKey() {
        return this.commoditySpecificationKey;
    }

    public String getCommoditySpecificationName() {
        return this.commoditySpecificationName;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setCommodityCover(ResourceVo resourceVo) {
        this.commodityCover = resourceVo;
    }

    public void setCommodityName(String str) {
        this.commodityName = str;
    }

    public void setCommoditySpecificationKey(String str) {
        this.commoditySpecificationKey = str;
    }

    public void setCommoditySpecificationName(String str) {
        this.commoditySpecificationName = str;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }

    public void setQuantity(int i2) {
        this.quantity = i2;
    }
}
