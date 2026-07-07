package com.chinavisionary.microtang.repair.model;

import androidx.lifecycle.MutableLiveData;
import c.e.c.g0.a.a;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.repair.vo.CreateRepairOrderCommentVo;
import com.chinavisionary.microtang.repair.vo.CreateRepairOrderVo;
import com.chinavisionary.microtang.repair.vo.RepairCommentDetailsVo;
import com.chinavisionary.microtang.repair.vo.RepairDeviceMenuVo;
import com.chinavisionary.microtang.repair.vo.RepairDeviceVo;
import com.chinavisionary.microtang.repair.vo.RepairOrderCommentScoreVo;
import com.chinavisionary.microtang.repair.vo.RepairOrderItemDetailsVo;
import com.chinavisionary.microtang.repair.vo.RepairOrderItemVo;
import com.chinavisionary.microtang.repair.vo.RepairOrderReasonVo;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import com.chinavisionary.microtang.repair.vo.UpdateAuthOpenDoorParamBo;

/* JADX INFO: loaded from: classes2.dex */
public class RepairModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f8282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<ResponseVo<RepairDeviceVo>> f8283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<ResponseVo<RepairDeviceMenuVo>> f8284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<ResponseVo<RepairOrderItemVo>> f8285d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MutableLiveData<RepairOrderItemDetailsVo> f8286e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableLiveData<RepairOrderReasonVo> f8287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MutableLiveData<RepairOrderCommentScoreVo> f8288g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MutableLiveData<RepairCommentDetailsVo> f8289h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f8290i;

    public RepairModel() {
        super(null);
        this.f8282a = new MutableLiveData<>();
        this.f8283b = new MutableLiveData<>();
        this.f8284c = new MutableLiveData<>();
        this.f8285d = new MutableLiveData<>();
        this.f8286e = new MutableLiveData<>();
        this.f8287f = new MutableLiveData<>();
        this.f8288g = new MutableLiveData<>();
        this.f8289h = new MutableLiveData<>();
        this.f8290i = (a) create(a.class);
    }

    public void cancelRepairOrder(String str) {
        this.f8290i.cancelRepairOrder(str).enqueue(enqueueResponse(this.f8282a));
    }

    public void createRepairOrder(CreateRepairOrderVo createRepairOrderVo) {
        this.f8290i.createRepairOrder(createRepairOrderVo).enqueue(enqueueResponse(this.f8282a));
    }

    public void createRepairOrderComment(CreateRepairOrderCommentVo createRepairOrderCommentVo) {
        this.f8290i.createRepairOrderComment(createRepairOrderCommentVo).enqueue(enqueueResponse(this.f8282a));
    }

    public void getDeviceCategoryMenuList() {
        this.f8290i.getDeviceMenuList().enqueue(enqueueResponse(this.f8283b));
    }

    public MutableLiveData<ResponseVo<RepairDeviceVo>> getDeviceMenu() {
        return this.f8283b;
    }

    public MutableLiveData<ResponseVo<RepairDeviceMenuVo>> getDeviceMenuItemList() {
        return this.f8284c;
    }

    public MutableLiveData<RepairCommentDetailsVo> getRepairOrderCommentDetails() {
        return this.f8289h;
    }

    public MutableLiveData<RepairOrderCommentScoreVo> getRepairOrderCommentScore() {
        return this.f8288g;
    }

    public MutableLiveData<RepairOrderItemDetailsVo> getRepairOrderItemDetails() {
        return this.f8286e;
    }

    public MutableLiveData<ResponseVo<RepairOrderItemVo>> getRepairOrderItemList() {
        return this.f8285d;
    }

    public void getRepairOrderList(PageBo pageBo) {
        this.f8290i.getRepairOrderList(getQueryMap(pageBo)).enqueue(enqueueResponse(this.f8285d));
    }

    public MutableLiveData<RepairOrderReasonVo> getRepairOrderReason() {
        return this.f8287f;
    }

    public MutableLiveData<ResponseStateVo> getResultLiveData() {
        return this.f8282a;
    }

    public void updateAuthOpenDoorTime(UpdateAuthOpenDoorParamBo updateAuthOpenDoorParamBo) {
        this.f8290i.updateAuthOpenDoorTime(updateAuthOpenDoorParamBo.getWorkOrderKey(), updateAuthOpenDoorParamBo).enqueue(enqueueResponse(this.f8282a));
    }

    public void getRepairOrderCommentDetails(String str) {
        this.f8290i.getRepairOrderCommentDetails(str).enqueue(enqueueResponse(this.f8289h));
    }

    public void getRepairOrderCommentScore(int i2) {
        this.f8290i.getRepairOrderCommentScore(i2).enqueue(enqueueResponse(this.f8288g));
    }

    public void getRepairOrderItemDetails(String str) {
        this.f8290i.getRepairOrderItemDetails(str).enqueue(enqueueResponse(this.f8286e));
    }

    public void getRepairOrderReason(String str) {
        this.f8290i.getRepairOrderReason(str).enqueue(enqueueResponse(this.f8287f));
    }
}
