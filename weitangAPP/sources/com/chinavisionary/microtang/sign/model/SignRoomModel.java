package com.chinavisionary.microtang.sign.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.x;
import c.e.c.j0.a.a;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.main.vo.ResponseRentConfigFeeVo;
import com.chinavisionary.microtang.sign.vo.CreateContractVo;
import com.chinavisionary.microtang.sign.vo.GetFddContactBo;
import com.chinavisionary.microtang.sign.vo.ResponseConfirmContactVo;
import com.chinavisionary.microtang.sign.vo.ResponseFddVo;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class SignRoomModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<ResponseConfirmContactVo> f8554a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<ResponseFddVo> f8555b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<ResponseRentConfigFeeVo> f8556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f8557d;

    public SignRoomModel() {
        super(null);
        this.f8554a = new MutableLiveData<>();
        this.f8555b = new MutableLiveData<>();
        this.f8556c = new MutableLiveData<>();
        this.f8557d = (a) create(a.class);
    }

    public void confirmContact(CreateContractVo createContractVo) {
        this.f8557d.confirmContact(createContractVo).enqueue(enqueueResponse(this.f8554a));
    }

    public MutableLiveData<ResponseRentConfigFeeVo> getConfigFee() {
        return this.f8556c;
    }

    public MutableLiveData<ResponseConfirmContactVo> getConfirmContactLiveData() {
        return this.f8554a;
    }

    public void getFddContact(GetFddContactBo getFddContactBo) {
        this.f8557d.getFddContact(getFddContactBo).enqueue(enqueueResponse(this.f8555b));
    }

    public MutableLiveData<ResponseFddVo> getFddContactLiveData() {
        return this.f8555b;
    }

    public void getRoomConfigFee(String str, Long l, boolean z, String str2, Boolean bool) {
        HashMap map = new HashMap();
        map.put("assetKey", str);
        if (l != null) {
            map.put("rentTermTo", String.valueOf(l));
        }
        if (z) {
            map.put("renewalFlag", String.valueOf(true));
        }
        if (x.isNotNull(str2)) {
            map.put("preContractKey", str2);
            map.put("changeRentFlag", String.valueOf(true));
        }
        if (bool != null) {
            map.put("extendOldRentFlag", String.valueOf(bool));
        }
        this.f8557d.getRoomConfigFee(map).enqueue(enqueueResponse(this.f8556c));
    }
}
