package com.chinavisionary.paymentlibrary.model;

import androidx.lifecycle.MutableLiveData;
import c.e.d.z.c;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.paymentlibrary.vo.PayBillResultVo;
import com.chinavisionary.paymentlibrary.vo.PayStateVo;

/* JADX INFO: loaded from: classes2.dex */
public class PayModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<PayStateVo> f8770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<PayBillResultVo> f8771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f8772c;

    public PayModel() {
        super(null);
        this.f8770a = new MutableLiveData<>();
        this.f8771b = new MutableLiveData<>();
        this.f8772c = (c) create(c.class);
    }

    public MutableLiveData<PayBillResultVo> getPayBillResult() {
        return this.f8771b;
    }

    public MutableLiveData<PayStateVo> getPayStateResult() {
        return this.f8770a;
    }
}
