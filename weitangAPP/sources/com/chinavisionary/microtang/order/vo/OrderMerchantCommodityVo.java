package com.chinavisionary.microtang.order.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OrderMerchantCommodityVo extends BaseVo {
    private BigDecimal additionalAmount;
    private int commodityNumber;
    private BigDecimal deliveryAmount;
    private String key;
    private ResourceVo merchantCover;
    private String merchantKey;
    private String merchantName;
    private String message;
    private List<OderSpecificationsVo> specifications;
    private boolean success;
    private BigDecimal totalAmount;

    public BigDecimal getAdditionalAmount() {
        return this.additionalAmount;
    }

    public int getCommodityNumber() {
        return this.commodityNumber;
    }

    public BigDecimal getDeliveryAmount() {
        return this.deliveryAmount;
    }

    public String getKey() {
        return this.key;
    }

    public ResourceVo getMerchantCover() {
        return this.merchantCover;
    }

    public String getMerchantKey() {
        return this.merchantKey;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getMessage() {
        return this.message;
    }

    public List<OderSpecificationsVo> getSpecifications() {
        return this.specifications;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setAdditionalAmount(BigDecimal bigDecimal) {
        this.additionalAmount = bigDecimal;
    }

    public void setCommodityNumber(int i2) {
        this.commodityNumber = i2;
    }

    public void setDeliveryAmount(BigDecimal bigDecimal) {
        this.deliveryAmount = bigDecimal;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMerchantCover(ResourceVo resourceVo) {
        this.merchantCover = resourceVo;
    }

    public void setMerchantKey(String str) {
        this.merchantKey = str;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSpecifications(List<OderSpecificationsVo> list) {
        this.specifications = list;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setTotalAmount(BigDecimal bigDecimal) {
        this.totalAmount = bigDecimal;
    }
}
