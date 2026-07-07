package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class PayChannelVo extends BaseVo {
    private int drawableId;
    private boolean isAddClickListener = true;
    private boolean isCheck;
    private int payType;
    private BigDecimal surplus;
    private String title;

    public int getDrawableId() {
        return this.drawableId;
    }

    public int getPayType() {
        return this.payType;
    }

    public BigDecimal getSurplus() {
        return this.surplus;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isAddClickListener() {
        return this.isAddClickListener;
    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public void setAddClickListener(boolean z) {
        this.isAddClickListener = z;
    }

    public void setCheck(boolean z) {
        this.isCheck = z;
    }

    public void setDrawableId(int i2) {
        this.drawableId = i2;
    }

    public void setPayType(int i2) {
        this.payType = i2;
    }

    public void setSurplus(BigDecimal bigDecimal) {
        this.surplus = bigDecimal;
    }

    public void setTitle(String str) {
        this.title = str;
    }
}
