package com.chinavisionary.microtang.buycart.model;

import androidx.lifecycle.MutableLiveData;
import c.e.c.k.a.b;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.buycart.bo.RequestCreateOrderBo;
import com.chinavisionary.microtang.buycart.vo.RequestAmountBo;
import com.chinavisionary.microtang.buycart.vo.RequestCreateBuyCartOrderVo;
import com.chinavisionary.microtang.buycart.vo.RequestInitBuyCartOrderVo;
import com.chinavisionary.microtang.buycart.vo.ResponseAmountVo;
import com.chinavisionary.microtang.buycart.vo.ResponseWaitBuyListVo;

/* JADX INFO: loaded from: classes.dex */
public class BuyCartSubmitModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f6914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<String> f6915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f6916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f6917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MutableLiveData<ResponseWaitBuyListVo> f6918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableLiveData<ResponseAmountVo> f6919f;

    public BuyCartSubmitModel() {
        super(null);
        this.f6915b = new MutableLiveData<>();
        this.f6916c = new MutableLiveData<>();
        this.f6917d = new MutableLiveData<>();
        this.f6918e = new MutableLiveData<>();
        this.f6919f = new MutableLiveData<>();
        this.f6914a = (b) create(b.class);
    }

    public void createBuyCartOrder(RequestCreateOrderBo requestCreateOrderBo) {
        if (checkObjectParamIsValid(requestCreateOrderBo)) {
            this.f6914a.createOrder(requestCreateOrderBo).enqueue(enqueueResponse(this.f6917d));
        }
    }

    public void createInitOrder(RequestInitBuyCartOrderVo requestInitBuyCartOrderVo) {
        if (checkObjectParamIsValid(requestInitBuyCartOrderVo)) {
            this.f6914a.createBuyCartInitOrder(requestInitBuyCartOrderVo).enqueue(enqueueResponse(this.f6916c));
        }
    }

    public void createWaitBuyList(RequestCreateBuyCartOrderVo requestCreateBuyCartOrderVo) {
        if (checkObjectParamIsValid(requestCreateBuyCartOrderVo)) {
            this.f6914a.createWaitBuyList(requestCreateBuyCartOrderVo).enqueue(enqueueResponse(this.f6915b));
        }
    }

    public MutableLiveData<ResponseAmountVo> getAmountResult() {
        return this.f6919f;
    }

    public MutableLiveData<ResponseStateVo> getCreateResult() {
        return this.f6917d;
    }

    public MutableLiveData<String> getCreateWaitBuyListResult() {
        return this.f6915b;
    }

    public MutableLiveData<ResponseStateVo> getInitResult() {
        return this.f6916c;
    }

    public void getWaitBuyListAmount(RequestAmountBo requestAmountBo) {
        if (checkObjectParamIsValid(requestAmountBo)) {
            this.f6914a.getWaitBuyAmount(requestAmountBo).enqueue(enqueueResponse(this.f6919f));
        }
    }

    public MutableLiveData<ResponseWaitBuyListVo> getWaitBuyListResult() {
        return this.f6918e;
    }

    public void getWaitBuyListToKey(String str) {
        if (checkParamIsInvalid(str)) {
            this.f6914a.getWaitBuyList(str).enqueue(enqueueResponse(this.f6918e));
        }
    }
}
