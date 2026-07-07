package com.chinavisionary.microtang.order.vo;

import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.framework.mobile.common.vo.ResourceVo;
import java.math.BigDecimal;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CleanOrderDetailsVo extends BaseVo {
    private String actualProductTypeName;
    private List<ResourceVo> actualResources;
    private String address;
    private boolean authOpen;
    private String billKey;
    private int businessType;
    private String businessTypeName;
    private boolean canCancel;
    private String cleaningOrderKey;
    private String cleaningOrderNo;
    private Long createTime;
    private Long finishTime;
    private Long fromTime;
    private String handleResult;
    private String houseAssetInstanceKey;
    private boolean isAuthOpen;
    private Long openFromTime;
    private Long openToTime;
    private BigDecimal orderAmount;
    private String phone;
    private String productTypeName;
    private String projectKey;
    private String remark;
    private List<ResourceVo> resources;
    private int status;
    private String statusName;
    private Long toTime;
    private String workOrderKey;

    public String getActualProductTypeName() {
        return this.actualProductTypeName;
    }

    public List<ResourceVo> getActualResources() {
        return this.actualResources;
    }

    public String getAddress() {
        return this.address;
    }

    public String getBillKey() {
        return this.billKey;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public String getBusinessTypeName() {
        return this.businessTypeName;
    }

    public String getCleaningOrderKey() {
        return this.cleaningOrderKey;
    }

    public String getCleaningOrderNo() {
        return this.cleaningOrderNo;
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public Long getFinishTime() {
        return this.finishTime;
    }

    public Long getFromTime() {
        return this.fromTime;
    }

    public String getHandleResult() {
        return this.handleResult;
    }

    public String getHouseAssetInstanceKey() {
        return this.houseAssetInstanceKey;
    }

    public Long getOpenFromTime() {
        return this.openFromTime;
    }

    public Long getOpenToTime() {
        return this.openToTime;
    }

    public BigDecimal getOrderAmount() {
        return this.orderAmount;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getProductTypeName() {
        return this.productTypeName;
    }

    public String getProjectKey() {
        return this.projectKey;
    }

    public String getRemark() {
        return this.remark;
    }

    public List<ResourceVo> getResources() {
        return this.resources;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusName() {
        return this.statusName;
    }

    public Long getToTime() {
        return this.toTime;
    }

    public String getWorkOrderKey() {
        return this.workOrderKey;
    }

    public boolean isAuthOpen() {
        return this.authOpen;
    }

    public boolean isCanCancel() {
        return this.canCancel;
    }

    public boolean isIsAuthOpen() {
        return this.isAuthOpen;
    }

    public void setActualProductTypeName(String str) {
        this.actualProductTypeName = str;
    }

    public void setActualResources(List<ResourceVo> list) {
        this.actualResources = list;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setAuthOpen(boolean z) {
        this.authOpen = z;
    }

    public void setBillKey(String str) {
        this.billKey = str;
    }

    public void setBusinessType(int i2) {
        this.businessType = i2;
    }

    public void setBusinessTypeName(String str) {
        this.businessTypeName = str;
    }

    public void setCanCancel(boolean z) {
        this.canCancel = z;
    }

    public void setCleaningOrderKey(String str) {
        this.cleaningOrderKey = str;
    }

    public void setCleaningOrderNo(String str) {
        this.cleaningOrderNo = str;
    }

    public void setCreateTime(Long l) {
        this.createTime = l;
    }

    public void setFinishTime(Long l) {
        this.finishTime = l;
    }

    public void setFromTime(Long l) {
        this.fromTime = l;
    }

    public void setHandleResult(String str) {
        this.handleResult = str;
    }

    public void setHouseAssetInstanceKey(String str) {
        this.houseAssetInstanceKey = str;
    }

    public void setIsAuthOpen(boolean z) {
        this.isAuthOpen = z;
    }

    public void setOpenFromTime(Long l) {
        this.openFromTime = l;
    }

    public void setOpenToTime(Long l) {
        this.openToTime = l;
    }

    public void setOrderAmount(BigDecimal bigDecimal) {
        this.orderAmount = bigDecimal;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setProductTypeName(String str) {
        this.productTypeName = str;
    }

    public void setProjectKey(String str) {
        this.projectKey = str;
    }

    public void setRemark(String str) {
        this.remark = str;
    }

    public void setResources(List<ResourceVo> list) {
        this.resources = list;
    }

    public void setStatus(int i2) {
        this.status = i2;
    }

    public void setStatusName(String str) {
        this.statusName = str;
    }

    public void setToTime(Long l) {
        this.toTime = l;
    }

    public void setWorkOrderKey(String str) {
        this.workOrderKey = str;
    }
}
