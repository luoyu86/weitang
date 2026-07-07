package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class H5BillPayTypeItemBo extends BaseVo {
    private String desc;
    private String name;
    private int type;
    private BigDecimal value;

    public String getDesc() {
        return this.desc;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public BigDecimal getValue() {
        return this.value;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setValue(BigDecimal bigDecimal) {
        this.value = bigDecimal;
    }
}
