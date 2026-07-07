package com.chinavisionary.microtang.buycart.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.room.vo.SaleVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class BuyCartProductVo extends BaseVo {
    private String cartKey;
    private ResourceVo commodityCover;
    private String commodityKey;
    private String commodityName;
    private String commoditySpecificationKey;
    private String commoditySpecificationName;
    private BigDecimal commoditySpecificationPrice;
    private boolean isSelect;
    private BigDecimal price;
    private int quantity;
    private SaleVo sale;
    private int surplusNumber = 1000;
    private int limit = 1000;

    public String getCartKey() {
        return this.cartKey;
    }

    public ResourceVo getCommodityCover() {
        return this.commodityCover;
    }

    public String getCommodityKey() {
        return this.commodityKey;
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

    public BigDecimal getCommoditySpecificationPrice() {
        BigDecimal bigDecimal = this.commoditySpecificationPrice;
        return bigDecimal == null ? this.price : bigDecimal;
    }

    public int getLimit() {
        return this.limit;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public SaleVo getSale() {
        return this.sale;
    }

    public int getSurplusNumber() {
        return this.surplusNumber;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setCartKey(String str) {
        this.cartKey = str;
    }

    public void setCommodityCover(ResourceVo resourceVo) {
        this.commodityCover = resourceVo;
    }

    public void setCommodityKey(String str) {
        this.commodityKey = str;
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

    public void setCommoditySpecificationPrice(BigDecimal bigDecimal) {
        this.commoditySpecificationPrice = bigDecimal;
    }

    public void setLimit(int i2) {
        this.limit = i2;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }

    public void setQuantity(int i2) {
        this.quantity = i2;
    }

    public void setSale(SaleVo saleVo) {
        this.sale = saleVo;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public void setSurplusNumber(int i2) {
        this.surplusNumber = i2;
    }
}
