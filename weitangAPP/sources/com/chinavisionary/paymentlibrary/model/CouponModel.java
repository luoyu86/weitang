package com.chinavisionary.paymentlibrary.model;

import androidx.lifecycle.MutableLiveData;
import c.e.d.z.a;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.paymentlibrary.vo.ResponseWalletVo;

/* JADX INFO: loaded from: classes2.dex */
public class CouponModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f8753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<ResponseWalletVo> f8754b;

    public CouponModel() {
        super(null);
        this.f8754b = new MutableLiveData<>();
        this.f8753a = (a) create(a.class);
    }

    public void getWalletBalance() {
        if (c.e.a.a.a.getInstance().isH5Model()) {
            this.f8753a.postWalletBalance(new BaseVo()).enqueue(enqueueBaseVoResponse(this.f8754b));
        } else {
            this.f8753a.getWalletBalance().enqueue(enqueueResponse(this.f8754b));
        }
    }

    public MutableLiveData<ResponseWalletVo> getWalletResult() {
        return this.f8754b;
    }
}
