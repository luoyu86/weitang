package com.chinavisionary.microtang.merchant.vo;

import c.e.a.d.o;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommodityVo extends BaseVo {
    private int buyNumber;
    private String commodityKey;
    private List<ResourceVo> cover;
    private String description;
    private String detailArticleKey;
    private List<EditBannerView.BannerDto> mBannerDtos;
    private SpecificationsVo mSelectCommoditySpec;
    private int maxLimit;
    private BigDecimal packPrice;
    private BigDecimal price;
    private int sellAmount;
    private List<SpecificationTagsVo> specificationTags;
    private List<SpecificationsVo> specifications;
    private int stock;
    private String title;

    public List<EditBannerView.BannerDto> getBannerDtos() {
        if (this.mBannerDtos == null && this.cover != null) {
            this.mBannerDtos = new ArrayList();
            for (ResourceVo resourceVo : this.cover) {
                EditBannerView.BannerDto bannerDto = new EditBannerView.BannerDto();
                bannerDto.setCover(resourceVo);
                this.mBannerDtos.add(bannerDto);
            }
        }
        return this.mBannerDtos;
    }

    public int getBuyNumber() {
        return this.buyNumber;
    }

    public String getCommodityKey() {
        return this.commodityKey;
    }

    public List<ResourceVo> getCover() {
        return this.cover;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDetailArticleKey() {
        return this.detailArticleKey;
    }

    public int getMaxLimit() {
        SpecificationsVo specificationsVo = (SpecificationsVo) o.getFirstElement(this.specifications);
        if (specificationsVo != null) {
            this.maxLimit = specificationsVo.getStock();
        }
        return this.maxLimit;
    }

    public BigDecimal getPackPrice() {
        return this.packPrice;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public SpecificationsVo getSelectCommoditySpec() {
        return this.mSelectCommoditySpec;
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

    public int getStock() {
        return this.stock;
    }

    public String getTitle() {
        return this.title;
    }

    public void setBannerDtos(List<EditBannerView.BannerDto> list) {
        this.mBannerDtos = list;
    }

    public void setBuyNumber(int i2) {
        this.buyNumber = i2;
    }

    public void setCommodityKey(String str) {
        this.commodityKey = str;
    }

    public void setCover(List<ResourceVo> list) {
        this.cover = list;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setDetailArticleKey(String str) {
        this.detailArticleKey = str;
    }

    public void setMaxLimit(int i2) {
        this.maxLimit = i2;
    }

    public void setPackPrice(BigDecimal bigDecimal) {
        this.packPrice = bigDecimal;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }

    public void setSelectCommoditySpec(SpecificationsVo specificationsVo) {
        this.mSelectCommoditySpec = specificationsVo;
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

    public void setStock(int i2) {
        this.stock = i2;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
