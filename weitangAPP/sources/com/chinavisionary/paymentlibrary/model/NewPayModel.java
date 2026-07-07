package com.chinavisionary.paymentlibrary.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.a.a;
import c.e.a.d.j;
import c.e.a.d.x;
import c.e.d.z.b;
import c.e.d.z.c;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.paymentlibrary.R;
import com.chinavisionary.paymentlibrary.vo.H5CreatePayBillBo;
import com.chinavisionary.paymentlibrary.vo.PayBillResultVo;
import com.chinavisionary.paymentlibrary.vo.PayBillVo;
import com.chinavisionary.paymentlibrary.vo.PayStateVo;
import com.chinavisionary.paymentlibrary.vo.RequestPayModelBo;
import com.chinavisionary.paymentlibrary.vo.RequestPayStateParamBo;
import com.chinavisionary.paymentlibrary.vo.ResponsePayModeBo;

/* JADX INFO: loaded from: classes2.dex */
public class NewPayModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<PayStateVo> f8765a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<PayBillResultVo> f8766b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<ResponsePayModeBo> f8767c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f8768d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f8769e;

    public NewPayModel() {
        super(j.getInstance().getH5ApiBaseUrl());
        this.f8765a = new MutableLiveData<>();
        this.f8766b = new MutableLiveData<>();
        this.f8767c = new MutableLiveData<>();
        this.f8768d = (c) create(c.class);
        this.f8769e = (b) create(b.class);
    }

    public MutableLiveData<PayBillResultVo> getPayBillResult() {
        return this.f8766b;
    }

    public void getPayMode(String str) {
        if (checkParamIsInvalid(str)) {
            RequestPayModelBo requestPayModelBo = new RequestPayModelBo();
            requestPayModelBo.setOrderId(str);
            this.f8769e.getPayMode(requestPayModelBo).enqueue(enqueueBaseVoResponse(this.f8767c));
        }
    }

    public MutableLiveData<ResponsePayModeBo> getPayModeBoResult() {
        return this.f8767c;
    }

    public void getPaySign(PayBillVo payBillVo) {
        if (checkObjectParamIsValid(payBillVo)) {
            int payChannel = payBillVo.getPayChannel();
            switch (payChannel) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                    if (a.getInstance().isH5Model()) {
                        H5CreatePayBillBo createPayBillBo = payBillVo.getCreatePayBillBo();
                        createPayBillBo.setPayType(Integer.valueOf(payChannel));
                        createPayBillBo.setPayMode(ResponsePayModeBo.getPayTypeToMode(payChannel));
                        this.f8769e.createPaySignNew(createPayBillBo).enqueue(enqueueBaseVoResponse(this.f8766b));
                    }
                    break;
                default:
                    handlerResponseErr(null, x.getString(R.string.core_lib_tip_pay_channel_is_empty));
                    break;
            }
        }
    }

    public MutableLiveData<PayStateVo> getPayStateResult() {
        return this.f8765a;
    }

    public void getPayStateToKey(String str) {
        if (checkParamIsInvalid(str) && a.getInstance().isH5Model()) {
            RequestPayStateParamBo requestPayStateParamBo = new RequestPayStateParamBo();
            requestPayStateParamBo.setPayId(str);
            requestPayStateParamBo.setPaymentId(str);
            this.f8769e.getPayState(requestPayStateParamBo).enqueue(enqueueBaseVoResponse(this.f8765a));
        }
    }
}
