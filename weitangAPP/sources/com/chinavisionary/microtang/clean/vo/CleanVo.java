package com.chinavisionary.microtang.clean.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;

/* JADX INFO: loaded from: classes.dex */
public class CleanVo extends BaseVo {
    public static final int STATE_INVALID = 4;
    public static final int STATE_OVER = 3;
    public static final int STATE_PAY = 2;
    public static final int STATE_WAIT_PAY = 1;
    private Long createTime;
    private Float duration;
    private String goodsKey;
    private String key;
    private String orderCode;
    private Long payDeadline;
    private String payKey;
    private Integer state;
    private String stateName;
    private Integer type;

    public Long getCreateTime() {
        return this.createTime;
    }

    public Float getDuration() {
        return this.duration;
    }

    public String getGoodsKey() {
        return this.goodsKey;
    }

    public String getKey() {
        return this.key;
    }

    public String getOrderCode() {
        return this.orderCode;
    }

    public Long getPayDeadline() {
        return this.payDeadline;
    }

    public String getPayKey() {
        return this.payKey;
    }

    public Integer getState() {
        return this.state;
    }

    public String getStateName() {
        return this.stateName;
    }

    public Integer getType() {
        return this.type;
    }

    public void setCreateTime(Long l) {
        this.createTime = l;
    }

    public void setDuration(Float f2) {
        this.duration = f2;
    }

    public void setGoodsKey(String str) {
        this.goodsKey = str;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setOrderCode(String str) {
        this.orderCode = str;
    }

    public void setPayDeadline(Long l) {
        this.payDeadline = l;
    }

    public void setPayKey(String str) {
        this.payKey = str;
    }

    public void setState(Integer num) {
        this.state = num;
    }

    public void setStateName(String str) {
        this.stateName = str;
    }

    public void setType(Integer num) {
        this.type = num;
    }
}
