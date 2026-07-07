package com.chinavisionary.microtang.order.model;

import androidx.lifecycle.MutableLiveData;
import c.e.c.b0.a.c.a;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.order.vo.CleanOrderCommentDetailsVo;
import com.chinavisionary.microtang.order.vo.CleanOrderItemDetailsVo;
import com.chinavisionary.microtang.repair.vo.CreateRepairOrderCommentVo;
import com.chinavisionary.microtang.repair.vo.RepairOrderCommentScoreVo;

/* JADX INFO: loaded from: classes.dex */
public class CleanOrderModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f8113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<CleanOrderItemDetailsVo> f8114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f8115c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<RepairOrderCommentScoreVo> f8116d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MutableLiveData<CleanOrderCommentDetailsVo> f8117e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f8118f;

    public CleanOrderModel() {
        super(null);
        this.f8113a = new MutableLiveData<>();
        this.f8114b = new MutableLiveData<>();
        this.f8115c = new MutableLiveData<>();
        this.f8116d = new MutableLiveData<>();
        this.f8117e = new MutableLiveData<>();
        this.f8118f = (a) create(a.class);
    }

    public void createCleanOrderComment(CreateRepairOrderCommentVo createRepairOrderCommentVo) {
        if (checkObjectParamIsValid(createRepairOrderCommentVo)) {
            this.f8118f.createCleanOrderComment(createRepairOrderCommentVo).enqueue(enqueueResponse(this.f8115c));
        }
    }

    public MutableLiveData<ResponseStateVo> getCancelResultVo() {
        return this.f8113a;
    }

    public void getCleanOrderDetails(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8118f.getCleanOrderDetails(str).enqueue(enqueueResponse(this.f8114b));
        }
    }

    public MutableLiveData<CleanOrderItemDetailsVo> getOrderDetails() {
        return this.f8114b;
    }

    public MutableLiveData<CleanOrderCommentDetailsVo> getRepairOrderCommentDetails() {
        return this.f8117e;
    }

    public MutableLiveData<RepairOrderCommentScoreVo> getRepairOrderCommentScore() {
        return this.f8116d;
    }

    public MutableLiveData<ResponseStateVo> getResultLiveData() {
        return this.f8115c;
    }

    public void postCancelOrder(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8118f.cancelCleanOrder(str).enqueue(enqueueResponse(this.f8113a));
        }
    }

    public void getRepairOrderCommentDetails(String str) {
        this.f8118f.getCleanOrderCommentDetails(str).enqueue(enqueueResponse(this.f8117e));
    }

    public void getRepairOrderCommentScore(int i2) {
        this.f8118f.getCleanOrderCommentScore(i2).enqueue(enqueueResponse(this.f8116d));
    }
}
