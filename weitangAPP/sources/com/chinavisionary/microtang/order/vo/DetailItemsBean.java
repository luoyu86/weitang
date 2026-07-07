package com.chinavisionary.microtang.order.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DetailItemsBean extends BaseVo {
    private BigDecimal additionalAmount;
    private BigDecimal deliveryAmount;
    private ResourceVo merchantCover;
    private String merchantKey;
    private String merchantName;
    private List<KeyValueVo> prices;
    private List<OderSpecificationsVo> specifications;
    private BigDecimal totalAmount;

    public BigDecimal getAdditionalAmount() {
        return this.additionalAmount;
    }

    public BigDecimal getDeliveryAmount() {
        return this.deliveryAmount;
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

    public List<KeyValueVo> getPrices() {
        return this.prices;
    }

    public List<OderSpecificationsVo> getSpecifications() {
        return this.specifications;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public void setAdditionalAmount(BigDecimal bigDecimal) {
        this.additionalAmount = bigDecimal;
    }

    public void setDeliveryAmount(BigDecimal bigDecimal) {
        this.deliveryAmount = bigDecimal;
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

    public void setPrices(List<KeyValueVo> list) {
        this.prices = list;
    }

    public void setSpecifications(List<OderSpecificationsVo> list) {
        this.specifications = list;
    }

    public void setTotalAmount(BigDecimal bigDecimal) {
        this.totalAmount = bigDecimal;
    }
}
