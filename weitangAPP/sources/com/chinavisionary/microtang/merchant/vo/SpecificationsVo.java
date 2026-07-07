package com.chinavisionary.microtang.merchant.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SpecificationsVo extends BaseVo {
    private int buyNumber;
    private BigDecimal price;
    private String specificationKey;
    private String specificationTitle;
    private int stock;
    private List<String> tagKeys;

    public int getBuyNumber() {
        return this.buyNumber;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getSpecificationKey() {
        return this.specificationKey;
    }

    public String getSpecificationTitle() {
        return this.specificationTitle;
    }

    public int getStock() {
        return this.stock;
    }

    public List<String> getTagKeys() {
        return this.tagKeys;
    }

    public void setBuyNumber(int i2) {
        this.buyNumber = i2;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }

    public void setSpecificationKey(String str) {
        this.specificationKey = str;
    }

    public void setSpecificationTitle(String str) {
        this.specificationTitle = str;
    }

    public void setStock(int i2) {
        this.stock = i2;
    }

    public void setTagKeys(List<String> list) {
        this.tagKeys = list;
    }
}
