package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CreatePayChannelVo extends BaseVo {
    private Integer aliPayType;
    private BigDecimal bigDecimal;
    private Integer gjjAliPayType;
    private int payChannel;
    private List<Integer> payIndexMap;
    private String payPrice;
    private int payType;
    private Integer wtPayType;
    private Integer wxPayType;

    public Integer getAliPayType() {
        return this.aliPayType;
    }

    public BigDecimal getBigDecimal() {
        return this.bigDecimal;
    }

    public Integer getGjjAliPayType() {
        return this.gjjAliPayType;
    }

    public int getPayChannel() {
        return this.payChannel;
    }

    public List<Integer> getPayIndexMap() {
        return this.payIndexMap;
    }

    public String getPayPrice() {
        return this.payPrice;
    }

    public int getPayType() {
        return this.payType;
    }

    public Integer getWtPayType() {
        return this.wtPayType;
    }

    public Integer getWxPayType() {
        return this.wxPayType;
    }

    public void setAliPayType(Integer num) {
        this.aliPayType = num;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public void setGjjAliPayType(Integer num) {
        this.gjjAliPayType = num;
    }

    public void setPayChannel(int i2) {
        this.payChannel = i2;
    }

    public void setPayIndexMap(List<Integer> list) {
        this.payIndexMap = list;
    }

    public void setPayPrice(String str) {
        this.payPrice = str;
    }

    public void setPayType(int i2) {
        this.payType = i2;
    }

    public void setWtPayType(Integer num) {
        this.wtPayType = num;
    }

    public void setWxPayType(Integer num) {
        this.wxPayType = num;
    }
}
