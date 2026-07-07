package com.chinavisionary.microtang.order.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OrderVo extends BaseVo {
    public static final int BILL_TYPE = 2;
    public static final int ORDER_TYPE = 1;
    private int commodityNumber;
    private List<OrderMerchantCommodityVo> details;
    private String key;
    private int orderStatus;
    private String orderStatusName;
    private BigDecimal totalAmount;
    private int type;

    public int getCommodityNumber() {
        return this.commodityNumber;
    }

    public List<OrderMerchantCommodityVo> getDetails() {
        return this.details;
    }

    public String getKey() {
        return this.key;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public String getOrderStatusName() {
        return this.orderStatusName;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public int getType() {
        return this.type;
    }

    public void setCommodityNumber(int i2) {
        this.commodityNumber = i2;
    }

    public void setDetails(List<OrderMerchantCommodityVo> list) {
        this.details = list;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setOrderStatus(int i2) {
        this.orderStatus = i2;
    }

    public void setOrderStatusName(String str) {
        this.orderStatusName = str;
    }

    public void setTotalAmount(BigDecimal bigDecimal) {
        this.totalAmount = bigDecimal;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
