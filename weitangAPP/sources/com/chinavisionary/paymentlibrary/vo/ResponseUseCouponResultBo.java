package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseUseCouponResultBo extends NewBaseVo {
    private String appid;
    private String billId;
    private String calculationFormula;
    private String enterpriseid;
    private BigDecimal finalAmount;
    private String key;
    private List<ResponseUserCouponResultItemVo> list;
    private String orderId;
    private BigDecimal originalAmount;

    public String getAppid() {
        return this.appid;
    }

    public String getBillId() {
        return this.billId;
    }

    public String getCalculationFormula() {
        return this.calculationFormula;
    }

    public String getEnterpriseid() {
        return this.enterpriseid;
    }

    public BigDecimal getFinalAmount() {
        return this.finalAmount;
    }

    public String getKey() {
        return this.key;
    }

    public List<ResponseUserCouponResultItemVo> getList() {
        return this.list;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public BigDecimal getOriginalAmount() {
        return this.originalAmount;
    }

    public void setAppid(String str) {
        this.appid = str;
    }

    public void setBillId(String str) {
        this.billId = str;
    }

    public void setCalculationFormula(String str) {
        this.calculationFormula = str;
    }

    public void setEnterpriseid(String str) {
        this.enterpriseid = str;
    }

    public void setFinalAmount(BigDecimal bigDecimal) {
        this.finalAmount = bigDecimal;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setList(List<ResponseUserCouponResultItemVo> list) {
        this.list = list;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOriginalAmount(BigDecimal bigDecimal) {
        this.originalAmount = bigDecimal;
    }
}
