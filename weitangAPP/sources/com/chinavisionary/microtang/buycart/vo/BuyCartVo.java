package com.chinavisionary.microtang.buycart.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import com.chinavisionary.microtang.order.vo.KeyValueVo;
import com.chinavisionary.microtang.room.vo.ExpressVo;
import com.chinavisionary.microtang.room.vo.SaleVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BuyCartVo extends BaseVo implements Cloneable {
    private List<BuyCartProductVo> commodities;
    private ResourceVo cover;
    private List<KeyValueVo> feesBeans;
    private boolean hiedBottomLine;
    private boolean isBill;
    private boolean isSelect;
    private int itemType;
    private String key;
    private String merchantKey;
    private ResourceVo merchantLogo;
    private String merchantName;
    private String name;
    private String orderRemark;
    private int orderState;
    private String orderStateName;
    private int orderStatus;
    private SaleVo sale;
    private ExpressVo selfAddress;
    private int specCount;
    private BigDecimal totalAmount;

    public List<BuyCartProductVo> getCommodities() {
        return this.commodities;
    }

    public ResourceVo getCover() {
        return this.cover;
    }

    public List<KeyValueVo> getFeesBeans() {
        return this.feesBeans;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getKey() {
        return this.key;
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

    public String getName() {
        return this.name;
    }

    public String getOrderRemark() {
        return this.orderRemark;
    }

    public int getOrderState() {
        return this.orderState;
    }

    public String getOrderStateName() {
        return this.orderStateName;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public SaleVo getSale() {
        return this.sale;
    }

    public ExpressVo getSelfAddress() {
        return this.selfAddress;
    }

    public int getSpecCount() {
        return this.specCount;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public boolean isBill() {
        return this.isBill;
    }

    public boolean isHiedBottomLine() {
        return this.hiedBottomLine;
    }

    public boolean isSelect() {
        return this.isSelect;
    }

    public void setBill(boolean z) {
        this.isBill = z;
    }

    public void setCommodities(List<BuyCartProductVo> list) {
        this.commodities = list;
    }

    public void setCover(ResourceVo resourceVo) {
        this.cover = resourceVo;
    }

    public void setFeesBeans(List<KeyValueVo> list) {
        this.feesBeans = list;
    }

    public void setHiedBottomLine(boolean z) {
        this.hiedBottomLine = z;
    }

    public void setItemType(int i2) {
        this.itemType = i2;
    }

    public void setKey(String str) {
        this.key = str;
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

    public void setName(String str) {
        this.name = str;
    }

    public void setOrderRemark(String str) {
        this.orderRemark = str;
    }

    public void setOrderState(int i2) {
        this.orderState = i2;
    }

    public void setOrderStateName(String str) {
        this.orderStateName = str;
    }

    public void setOrderStatus(int i2) {
        this.orderStatus = i2;
    }

    public void setSale(SaleVo saleVo) {
        this.sale = saleVo;
    }

    public void setSelect(boolean z) {
        this.isSelect = z;
    }

    public void setSelfAddress(ExpressVo expressVo) {
        this.selfAddress = expressVo;
    }

    public void setSpecCount(int i2) {
        this.specCount = i2;
    }

    public void setTotalAmount(BigDecimal bigDecimal) {
        this.totalAmount = bigDecimal;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BuyCartVo m70clone() {
        try {
            return (BuyCartVo) super.clone();
        } catch (CloneNotSupportedException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
