package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ConfirmContactVo extends BaseVo {
    private String address;
    private String goodsKey;
    private int paymentMethod;
    private int rentPeriod;
    private List<?> roommateParamList;

    public String getAddress() {
        return this.address;
    }

    public String getGoodsKey() {
        return this.goodsKey;
    }

    public int getPaymentMethod() {
        return this.paymentMethod;
    }

    public int getRentPeriod() {
        return this.rentPeriod;
    }

    public List<?> getRoommateParamList() {
        return this.roommateParamList;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setGoodsKey(String str) {
        this.goodsKey = str;
    }

    public void setPaymentMethod(int i2) {
        this.paymentMethod = i2;
    }

    public void setRentPeriod(int i2) {
        this.rentPeriod = i2;
    }

    public void setRoommateParamList(List<?> list) {
        this.roommateParamList = list;
    }
}
