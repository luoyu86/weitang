package com.chinavisionary.microtang.hydropower.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class CreateWaterElectriBo extends BaseVo {
    private float number;
    private BigDecimal price;

    public float getNumber() {
        return this.number;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setNumber(float f2) {
        this.number = f2;
    }

    public void setPrice(BigDecimal bigDecimal) {
        this.price = bigDecimal;
    }
}
