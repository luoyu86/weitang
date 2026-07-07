package com.chinavisionary.microtang.order.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OderSpecificationsVo extends BaseVo {
    private String commodityKey;
    private String commodityName;
    private BigDecimal price;
    private ResourceVo specificationsCover;
    private String specificationsKey;
    private int specificationsNumber;
    private List<String> specificationsTagName;

    public String getCommodityKey() {
        return this.commodityKey;
    }

    public String getCommodityName() {
        return this.commodityName;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public ResourceVo getSpecificationsCover() {
        return this.specificationsCover;
    }

    public String getSpecificationsKey() {
        return this.specificationsKey;
    }

    public int getSpecificationsNumber() {
        return this.specificationsNumber;
    }

    public List<String> getSpecificationsTagName() {
        return this.specificationsTagName;
    }

    public void setCommodityKey(String str) {
        this.commodityKey = str;
    }

    public void setCommodityName(String str) {
        this.commodityName = str;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }

    public void setSpecificationsCover(ResourceVo resourceVo) {
        this.specificationsCover = resourceVo;
    }

    public void setSpecificationsKey(String str) {
        this.specificationsKey = str;
    }

    public void setSpecificationsNumber(int i2) {
        this.specificationsNumber = i2;
    }

    public void setSpecificationsTagName(List<String> list) {
        this.specificationsTagName = list;
    }
}
