package com.chinavisionary.paymentlibrary.vo;

import c.e.a.d.x;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseUserCouponResultItemVo extends BaseVo {
    private String billItemId;
    private String calculationFormula;
    private List<CouponListBean> couponList;
    private BigDecimal finalAmount;
    private BigDecimal originalAmount;
    private BigDecimal saleAmount;
    private String type;
    private String typeName;
    private String typeStr;

    public String getBillItemId() {
        return this.billItemId;
    }

    public String getCalculationFormula() {
        return this.calculationFormula;
    }

    public List<CouponListBean> getCouponList() {
        return this.couponList;
    }

    public BigDecimal getFinalAmount() {
        return this.finalAmount;
    }

    public BigDecimal getOriginalAmount() {
        return this.originalAmount;
    }

    public BigDecimal getSaleAmount() {
        String strBigDecimalSubtract = x.bigDecimalSubtract(this.originalAmount, this.finalAmount);
        if (x.isNotNull(strBigDecimalSubtract)) {
            this.saleAmount = new BigDecimal(strBigDecimalSubtract);
        }
        return this.saleAmount;
    }

    public String getType() {
        String str = this.typeStr;
        return str != null ? str : this.type;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public String getTypeStr() {
        return this.typeStr;
    }

    public void setBillItemId(String str) {
        this.billItemId = str;
    }

    public void setCalculationFormula(String str) {
        this.calculationFormula = str;
    }

    public void setCouponList(List<CouponListBean> list) {
        this.couponList = list;
    }

    public void setFinalAmount(BigDecimal bigDecimal) {
        this.finalAmount = bigDecimal;
    }

    public void setOriginalAmount(BigDecimal bigDecimal) {
        this.originalAmount = bigDecimal;
    }

    public void setSaleAmount(BigDecimal bigDecimal) {
        this.saleAmount = bigDecimal;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setTypeName(String str) {
        this.typeName = str;
    }

    public void setTypeStr(String str) {
        this.typeStr = str;
    }
}
