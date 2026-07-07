package com.chinavisionary.microtang.room.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class ProductSpecVo extends BaseVo {
    private String name;
    private String priceSection;
    private BigDecimal specPrice;
    private ResourceVo url;

    public String getName() {
        return this.name;
    }

    public String getPriceSection() {
        return this.priceSection;
    }

    public BigDecimal getSpecPrice() {
        return this.specPrice;
    }

    public ResourceVo getUrl() {
        return this.url;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPriceSection(String str) {
        this.priceSection = str;
    }

    public void setSpecPrice(BigDecimal bigDecimal) {
        this.specPrice = bigDecimal;
    }

    public void setUrl(ResourceVo resourceVo) {
        this.url = resourceVo;
    }
}
