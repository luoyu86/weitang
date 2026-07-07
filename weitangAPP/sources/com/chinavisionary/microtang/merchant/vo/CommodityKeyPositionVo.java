package com.chinavisionary.microtang.merchant.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CommodityKeyPositionVo extends BaseVo {
    private List<String> commodityKeys;
    private int position;

    public List<String> getCommodityKeys() {
        return this.commodityKeys;
    }

    public int getPosition() {
        return this.position;
    }

    public void setCommodityKeys(List<String> list) {
        this.commodityKeys = list;
    }

    public void setPosition(int i2) {
        this.position = i2;
    }
}
