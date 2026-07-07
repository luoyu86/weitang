package com.chinavisionary.microtang.buycart.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.order.vo.KeyValueVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MerchantsBean extends BaseVo {
    private List<KeyValueVo> attachFees;
    private List<BuyCartProductVo> commodities;
    private String merchantKey;
    private ResourceVo merchantLogo;
    private String merchantName;
    private String remark;
    private BigDecimal totalPrice;

    public List<KeyValueVo> getAttachFees() {
        return this.attachFees;
    }

    public List<BuyCartProductVo> getCommodities() {
        return this.commodities;
    }

    public String getMerchantKey() {
        return this.merchantKey;
    }

    public ResourceVo getMerchantLogo() {
        return this.merchantLogo;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public String getRemark() {
        return this.remark;
    }

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setAttachFees(List<KeyValueVo> list) {
        this.attachFees = list;
    }

    public void setCommodities(List<BuyCartProductVo> list) {
        this.commodities = list;
    }

    public void setMerchantKey(String str) {
        this.merchantKey = str;
    }

    public void setMerchantLogo(ResourceVo resourceVo) {
        this.merchantLogo = resourceVo;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setTotalPrice(BigDecimal bigDecimal) {
        this.totalPrice = bigDecimal;
    }
}
