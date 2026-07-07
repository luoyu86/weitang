package com.chinavisionary.microtang.sign.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.microtang.sign.vo.ContactDetailsVo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CreateContractVo extends BaseVo {
    private String goodsKey;
    private int paymentMethod;
    private int rentPeriod;
    private List<ContactDetailsVo.RoommatesBean> roommateParamList;

    public String getGoodsKey() {
        return this.goodsKey;
    }

    public int getPaymentMethod() {
        return this.paymentMethod;
    }

    public int getRentPeriod() {
        return this.rentPeriod;
    }

    public List<ContactDetailsVo.RoommatesBean> getRoommateParamList() {
        return this.roommateParamList;
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

    public void setRoommateParamList(List<ContactDetailsVo.RoommatesBean> list) {
        this.roommateParamList = list;
    }
}
