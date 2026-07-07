package com.chinavisionary.microtang.merchant.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MerchantCommodityVo extends BaseVo {
    private String commodityKey;
    private ResourceVo cover;
    private String description;
    private BigDecimal price;
    private int sellAmount;
    private List<SpecificationTagsVo> specificationTags;
    private List<SpecificationsVo> specifications;
    private String title;

    public String getCommodityKey() {
        return this.commodityKey;
    }

    public ResourceVo getCover() {
        return this.cover;
    }

    public String getDescription() {
        return this.description;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public int getSellAmount() {
        return this.sellAmount;
    }

    public List<SpecificationTagsVo> getSpecificationTags() {
        return this.specificationTags;
    }

    public List<SpecificationsVo> getSpecifications() {
        return this.specifications;
    }

    public String getTitle() {
        return this.title;
    }

    public void setCommodityKey(String str) {
        this.commodityKey = str;
    }

    public void setCover(ResourceVo resourceVo) {
        this.cover = resourceVo;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }

    public void setSellAmount(int i2) {
        this.sellAmount = i2;
    }

    public void setSpecificationTags(List<SpecificationTagsVo> list) {
        this.specificationTags = list;
    }

    public void setSpecifications(List<SpecificationsVo> list) {
        this.specifications = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
