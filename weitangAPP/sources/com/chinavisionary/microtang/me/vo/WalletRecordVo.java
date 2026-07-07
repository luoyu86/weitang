package com.chinavisionary.microtang.me.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes.dex */
public class WalletRecordVo extends BaseVo {
    public static final int RECORD_TYPE_IN = 2;
    public static final int RECORD_TYPE_OUT = 1;
    private String body;
    private String paymentAccountRecordKey;
    private String paymentKey;
    private BigDecimal recordAmount;
    private int recordStatus;
    private String recordStatusName;
    private Long recordTime;
    private int recordType;
    private String recordTypeName;
    private int type;

    public String getBody() {
        return this.body;
    }

    public String getPaymentAccountRecordKey() {
        return this.paymentAccountRecordKey;
    }

    public String getPaymentKey() {
        return this.paymentKey;
    }

    public BigDecimal getRecordAmount() {
        return this.recordAmount;
    }

    public int getRecordStatus() {
        return this.recordStatus;
    }

    public String getRecordStatusName() {
        return this.recordStatusName;
    }

    public Long getRecordTime() {
        return this.recordTime;
    }

    public int getRecordType() {
        return this.recordType;
    }

    public String getRecordTypeName() {
        return this.recordTypeName;
    }

    public int getType() {
        return this.type;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public void setPaymentAccountRecordKey(String str) {
        this.paymentAccountRecordKey = str;
    }

    public void setPaymentKey(String str) {
        this.paymentKey = str;
    }

    public void setRecordAmount(BigDecimal bigDecimal) {
        this.recordAmount = bigDecimal;
    }

    public void setRecordStatus(int i2) {
        this.recordStatus = i2;
    }

    public void setRecordStatusName(String str) {
        this.recordStatusName = str;
    }

    public void setRecordTime(Long l) {
        this.recordTime = l;
    }

    public void setRecordType(int i2) {
        this.recordType = i2;
    }

    public void setRecordTypeName(String str) {
        this.recordTypeName = str;
    }

    public void setType(int i2) {
        this.type = i2;
    }
}
