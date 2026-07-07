package com.chinavisionary.microtang.main.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.prelook.vo.TagVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MerchantInfoVo extends BaseVo {
    public static final int CLOSE = 0;
    public static final int OPEN = 1;
    private BigDecimal averagePrice;
    private ResourceVo cover;
    private String description;
    private ResourceVo logo;
    private String merchantKey;
    private String merchantName;
    private Integer merchantOpeningStatus;
    private String merchantOpeningStatusName;
    private float score;
    private int sellAmount;
    private List<TagVo> tags;

    public BigDecimal getAveragePrice() {
        return this.averagePrice;
    }

    public ResourceVo getCover() {
        return this.cover;
    }

    public String getDescription() {
        return this.description;
    }

    public ResourceVo getLogo() {
        return this.logo;
    }

    public String getMerchantKey() {
        return this.merchantKey;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public Integer getMerchantOpeningStatus() {
        return this.merchantOpeningStatus;
    }

    public String getMerchantOpeningStatusName() {
        return this.merchantOpeningStatusName;
    }

    public float getScore() {
        return this.score;
    }

    public int getSellAmount() {
        return this.sellAmount;
    }

    public List<TagVo> getTags() {
        return this.tags;
    }

    public void setAveragePrice(BigDecimal bigDecimal) {
        this.averagePrice = bigDecimal;
    }

    public void setCover(ResourceVo resourceVo) {
        this.cover = resourceVo;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setLogo(ResourceVo resourceVo) {
        this.logo = resourceVo;
    }

    public void setMerchantKey(String str) {
        this.merchantKey = str;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public void setMerchantOpeningStatus(Integer num) {
        this.merchantOpeningStatus = num;
    }

    public void setMerchantOpeningStatusName(String str) {
        this.merchantOpeningStatusName = str;
    }

    public void setScore(float f2) {
        this.score = f2;
    }

    public void setSellAmount(int i2) {
        this.sellAmount = i2;
    }

    public void setTags(List<TagVo> list) {
        this.tags = list;
    }
}
