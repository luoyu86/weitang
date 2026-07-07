package com.chinavisionary.microtang.order.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OrderDetailsVo extends BaseVo {
    private List<DetailItemsBean> detailItems;
    private String key;
    private String message;
    private int orderStatus;
    private String orderStatusName;
    private List<KeyValueVo> others;
    private boolean success;
    private BigDecimal totalPayAmount;
    private int type;

    public List<DetailItemsBean> getDetailItems() {
        return this.detailItems;
    }

    public String getKey() {
        return this.key;
    }

    public String getMessage() {
        return this.message;
    }

    public int getOrderStatus() {
        return this.orderStatus;
    }

    public String getOrderStatusName() {
        return this.orderStatusName;
    }

    public List<KeyValueVo> getOthers() {
        return this.others;
    }

    public BigDecimal getTotalPayAmount() {
        return this.totalPayAmount;
    }

    public int getType() {
        return this.type;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setDetailItems(List<DetailItemsBean> list) {
        this.detailItems = list;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setOrderStatus(int i2) {
        this.orderStatus = i2;
    }

    public void setOrderStatusName(String str) {
        this.orderStatusName = str;
    }

    public void setOthers(List<KeyValueVo> list) {
        this.others = list;
    }

    public void setSuccess(boolean z) {
        this.success = z;
    }

    public void setTotalPayAmount(BigDecimal bigDecimal) {
        this.totalPayAmount = bigDecimal;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
