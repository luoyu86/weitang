package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes2.dex */
public class PayTypeVo extends BaseVo {
    private String couponKey;
    private String extJson;
    private boolean hasRentBill;
    private boolean initBJPay;
    private boolean isBill;
    private boolean isOpenOrderList;
    private boolean isRetryPay;
    private int lateDay;
    private BigDecimal lateFee;
    private String payCode;
    private String price;
    private String primaryKey;
    private int resStrId;
    private String responseH5BillDetailsVoJson;
    private boolean srcToH5;
    private String title;
    private int type;

    public String getCouponKey() {
        return this.couponKey;
    }

    public String getExtJson() {
        return this.extJson;
    }

    public int getLateDay() {
        return this.lateDay;
    }

    public BigDecimal getLateFee() {
        return this.lateFee;
    }

    public String getPayCode() {
        return this.payCode;
    }

    public String getPrice() {
        return this.price;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public int getResStrId() {
        return this.resStrId;
    }

    public String getResponseH5BillDetailsVoJson() {
        return this.responseH5BillDetailsVoJson;
    }

    public String getTitle() {
        return this.title;
    }

    public int getType() {
        return this.type;
    }

    public boolean isBill() {
        return this.isBill;
    }

    public boolean isHasRentBill() {
        return this.hasRentBill;
    }

    public boolean isInitBJPay() {
        return this.initBJPay;
    }

    public boolean isOpenOrderList() {
        return this.isOpenOrderList;
    }

    public boolean isRetryPay() {
        return this.isRetryPay;
    }

    public boolean isSrcToH5() {
        return this.srcToH5;
    }

    public void setBill(boolean z) {
        this.isBill = z;
    }

    public void setCouponKey(String str) {
        this.couponKey = str;
    }

    public void setExtJson(String str) {
        this.extJson = str;
    }

    public void setHasRentBill(boolean z) {
        this.hasRentBill = z;
    }

    public void setInitBJPay(boolean z) {
        this.initBJPay = z;
    }

    public void setLateDay(int i2) {
        this.lateDay = i2;
    }

    public void setLateFee(BigDecimal bigDecimal) {
        this.lateFee = bigDecimal;
    }

    public void setOpenOrderList(boolean z) {
        this.isOpenOrderList = z;
    }

    public void setPayCode(String str) {
        this.payCode = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setPrimaryKey(String str) {
        this.primaryKey = str;
    }

    public void setResStrId(int i2) {
        this.resStrId = i2;
    }

    public void setResponseH5BillDetailsVoJson(String str) {
        this.responseH5BillDetailsVoJson = str;
    }

    public void setRetryPay(boolean z) {
        this.isRetryPay = z;
    }

    public void setSrcToH5(boolean z) {
        this.srcToH5 = z;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
