package com.chinavisionary.microtang.pre.model;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import c.e.c.c0.a.a;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.bill.vo.PayBillResultVo;
import com.chinavisionary.microtang.contract.vo.ContractClauseVo;
import com.chinavisionary.microtang.pre.vo.RequestReserveInfoVo;
import com.chinavisionary.microtang.pre.vo.ReserveCancelResultVo;
import com.chinavisionary.microtang.pre.vo.ReserveClauseRequestVo;
import com.chinavisionary.microtang.pre.vo.ReserveDetailsVo;
import com.chinavisionary.microtang.pre.vo.ReserveFddContractVo;
import com.chinavisionary.microtang.pre.vo.ReserveItemVo;
import com.chinavisionary.microtang.pre.vo.ReserveRoomInfoVo;

/* JADX INFO: loaded from: classes2.dex */
public class ReserveModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<ReserveDetailsVo> f8181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<ReserveRoomInfoVo> f8182b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<ReserveItemVo>> f8183c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<ContractClauseVo>> f8184d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MutableLiveData<PayBillResultVo> f8185e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableLiveData<ReserveFddContractVo> f8186f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MutableLiveData<ReserveCancelResultVo> f8187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f8188h;

    public ReserveModel() {
        super(null);
        this.f8181a = new MutableLiveData<>();
        this.f8182b = new MutableLiveData<>();
        this.f8183c = new MutableLiveData<>();
        this.f8184d = new MutableLiveData<>();
        this.f8185e = new MutableLiveData<>();
        this.f8186f = new MutableLiveData<>();
        this.f8187g = new MutableLiveData<>();
        this.f8188h = (a) create(a.class);
    }

    public void cancelReservePay(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8188h.cancelReserve(str).enqueue(enqueueResponse(this.f8187g));
        }
    }

    public MutableLiveData<ReserveCancelResultVo> getCancelResultVoLiveData() {
        return this.f8187g;
    }

    public MutableLiveData<ResponseRowsVo<ContractClauseVo>> getContractClauseVoLiveData() {
        return this.f8184d;
    }

    public MutableLiveData<PayBillResultVo> getPayBillResultVoLiveData() {
        return this.f8185e;
    }

    public void getReserveContractClause(@NonNull ReserveClauseRequestVo reserveClauseRequestVo) {
        this.f8188h.getReserveClauseList(reserveClauseRequestVo).enqueue(enqueueResponse(this.f8184d));
    }

    public void getReserveDetails(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8188h.getReserveDetails(str).enqueue(enqueueResponse(this.f8181a));
        }
    }

    public MutableLiveData<ReserveDetailsVo> getReserveDetailsVoLiveData() {
        return this.f8181a;
    }

    public void getReserveFddContract(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8188h.getReserveFdd(str).enqueue(enqueueResponse(this.f8186f));
        }
    }

    public MutableLiveData<ResponseRowsVo<ReserveItemVo>> getReserveItemVoLiveData() {
        return this.f8183c;
    }

    public void getReserveList() {
        this.f8188h.getReserveList().enqueue(enqueueResponse(this.f8183c));
    }

    public void getReserveRoomInfoToKey(@NonNull String str) {
        if (checkParamIsInvalid(str)) {
            this.f8188h.getReserveRoomInfoToKey(str).enqueue(enqueueResponse(this.f8182b));
        }
    }

    public MutableLiveData<ReserveFddContractVo> getResponseFddVoLiveData() {
        return this.f8186f;
    }

    public MutableLiveData<ReserveRoomInfoVo> getRoomInfoVoLiveData() {
        return this.f8182b;
    }

    public void postReserve(@NonNull RequestReserveInfoVo requestReserveInfoVo) {
        this.f8188h.postReserve(requestReserveInfoVo).enqueue(enqueueResponse(this.f8185e));
    }
}
