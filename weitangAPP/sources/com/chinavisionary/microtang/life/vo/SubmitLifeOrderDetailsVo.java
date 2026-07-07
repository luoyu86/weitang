package com.chinavisionary.microtang.life.vo;

import c.e.c.t.q.b;
import c.e.c.t.q.d;
import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SubmitLifeOrderDetailsVo extends NewBaseVo {
    private BigDecimal deliveryFee;
    private String deliveryFeeDesc;
    private List<b> deliveryTime;
    private List<d> question;
    private List<SubmitLifeOrderVo> tipList;

    public BigDecimal getDeliveryFee() {
        return this.deliveryFee;
    }

    public String getDeliveryFeeDesc() {
        return this.deliveryFeeDesc;
    }

    public List<b> getDeliveryTime() {
        return this.deliveryTime;
    }

    public List<d> getQuestion() {
        return this.question;
    }

    public List<SubmitLifeOrderVo> getTipList() {
        return this.tipList;
    }

    public void setDeliveryFee(BigDecimal bigDecimal) {
        this.deliveryFee = bigDecimal;
    }

    public void setDeliveryFeeDesc(String str) {
        this.deliveryFeeDesc = str;
    }

    public void setDeliveryTime(List<b> list) {
        this.deliveryTime = list;
    }

    public void setQuestion(List<d> list) {
        this.question = list;
    }

    public void setTipList(List<SubmitLifeOrderVo> list) {
        this.tipList = list;
    }
}
