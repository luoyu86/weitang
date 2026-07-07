package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseFoodVo extends NewBaseVo {
    private BigDecimal amount;
    private String key;
    private List<CommoditiesBean> rows;
    private String title;
    private int type;
    private String typeName;

    public static class CommoditiesBean extends BaseVo {
        private ResourceVo commodityCover;
        private String commodityKey;
        private String commodityName;
        private BigDecimal price;
        private int quantity;

        public ResourceVo getCommodityCover() {
            return this.commodityCover;
        }

        public String getCommodityKey() {
            return this.commodityKey;
        }

        public String getCommodityName() {
            return this.commodityName;
        }

        public BigDecimal getPrice() {
            return this.price;
        }

        public int getQuantity() {
            return this.quantity;
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

        public void setPrice(BigDecimal bigDecimal) {
            this.price = bigDecimal;
        }

        public void setQuantity(int i2) {
            this.quantity = i2;
        }
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getKey() {
        return this.key;
    }

    public List<CommoditiesBean> getRows() {
        return this.rows;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void setAmount(BigDecimal bigDecimal) {
        this.amount = bigDecimal;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setRows(List<CommoditiesBean> list) {
        this.rows = list;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }
}
