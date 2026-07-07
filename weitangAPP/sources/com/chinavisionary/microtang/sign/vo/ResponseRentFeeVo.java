package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseRentFeeVo extends BaseVo {
    private BigDecimal depositFee;
    private BigDecimal electricityFee;
    private Boolean hasUnpaidContract;
    private BigDecimal managementFee;
    private BigDecimal rentFee;
    private BigDecimal waterFee;

    public BigDecimal getDepositFee() {
        return this.depositFee;
    }

    public BigDecimal getElectricityFee() {
        return this.electricityFee;
    }

    public Boolean getHasUnpaidContract() {
        return this.hasUnpaidContract;
    }

    public BigDecimal getManagementFee() {
        return this.managementFee;
    }

    public BigDecimal getRentFee() {
        return this.rentFee;
    }

    public BigDecimal getWaterFee() {
        return this.waterFee;
    }

    public void setDepositFee(BigDecimal bigDecimal) {
        this.depositFee = bigDecimal;
    }

    public void setElectricityFee(BigDecimal bigDecimal) {
        this.electricityFee = bigDecimal;
    }

    public void setHasUnpaidContract(Boolean bool) {
        this.hasUnpaidContract = bool;
    }

    public void setManagementFee(BigDecimal bigDecimal) {
        this.managementFee = bigDecimal;
    }

    public void setRentFee(BigDecimal bigDecimal) {
        this.rentFee = bigDecimal;
    }

    public void setWaterFee(BigDecimal bigDecimal) {
        this.waterFee = bigDecimal;
    }
}
