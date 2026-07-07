package com.chinavisionary.paymentlibrary.vo;

import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ResponseH5BillDetailsVo extends NewBaseVo {
    private BigDecimal actualAmount;
    private String address;
    private List<PayCostTypeVo> billDetails;
    private String bizId;
    private String contractCode;
    private Long endTime;
    private String key;
    private BigDecimal lateFeeAmout;
    private int lateFeeDays;
    private String name;
    private Boolean needPay;
    private String num;
    private String orderId;
    private BigDecimal originalAmount;
    private int paidPeriods;
    private long payDeadline;
    private Long payTime;
    private int periods;
    private Long recordingTime;
    private Long startTime;
    private String statusName;
    private String type;
    private String typeStr;
    private BigDecimal unitPrice;

    public BigDecimal getActualAmount() {
        return this.actualAmount;
    }

    public String getAddress() {
        return this.address;
    }

    public List<PayCostTypeVo> getBillDetails() {
        return this.billDetails;
    }

    public String getBizId() {
        return this.bizId;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public Long getEndTime() {
        return this.endTime;
    }

    public String getKey() {
        return this.key;
    }

    public BigDecimal getLateFeeAmout() {
        return this.lateFeeAmout;
    }

    public int getLateFeeDays() {
        return this.lateFeeDays;
    }

    public String getName() {
        return this.name;
    }

    public String getNum() {
        return this.num;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public BigDecimal getOriginalAmount() {
        return this.originalAmount;
    }

    public int getPaidPeriods() {
        return this.paidPeriods;
    }

    public long getPayDeadline() {
        return this.payDeadline;
    }

    public Long getPayTime() {
        return this.payTime;
    }

    public int getPeriods() {
        return this.periods;
    }

    public Long getRecordingTime() {
        return this.recordingTime;
    }

    public Long getStartTime() {
        return this.startTime;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public String getType() {
        return this.type;
    }

    public String getTypeStr() {
        return this.typeStr;
    }

    public BigDecimal getUnitPrice() {
        return this.unitPrice;
    }

    public Boolean isNeedPay() {
        return this.needPay;
    }

    public void setActualAmount(BigDecimal bigDecimal) {
        this.actualAmount = bigDecimal;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setBillDetails(List<PayCostTypeVo> list) {
        this.billDetails = list;
    }

    public void setBizId(String str) {
        this.bizId = str;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setEndTime(Long l) {
        this.endTime = l;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setLateFeeAmout(BigDecimal bigDecimal) {
        this.lateFeeAmout = bigDecimal;
    }

    public void setLateFeeDays(int i2) {
        this.lateFeeDays = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNeedPay(Boolean bool) {
        this.needPay = bool;
    }

    public void setNum(String str) {
        this.num = str;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public void setOriginalAmount(BigDecimal bigDecimal) {
        this.originalAmount = bigDecimal;
    }

    public void setPaidPeriods(int i2) {
        this.paidPeriods = i2;
    }

    public void setPayDeadline(long j) {
        this.payDeadline = j;
    }

    public void setPayTime(Long l) {
        this.payTime = l;
    }

    public void setPeriods(int i2) {
        this.periods = i2;
    }

    public void setRecordingTime(Long l) {
        this.recordingTime = l;
    }

    public void setStartTime(Long l) {
        this.startTime = l;
    }

    public void setStatusName(String str) {
        this.statusName = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setTypeStr(String str) {
        this.typeStr = str;
    }

    public void setUnitPrice(BigDecimal bigDecimal) {
        this.unitPrice = bigDecimal;
    }
}
