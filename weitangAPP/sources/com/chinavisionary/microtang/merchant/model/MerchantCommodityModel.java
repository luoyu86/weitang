package com.chinavisionary.microtang.merchant.model;

import androidx.lifecycle.MutableLiveData;
import c.e.c.y.a.b;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.merchant.vo.CommodityVo;

/* JADX INFO: loaded from: classes.dex */
public class MerchantCommodityModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f7926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<CommodityVo> f7927b;

    public MerchantCommodityModel() {
        super(null);
        this.f7927b = new MutableLiveData<>();
        this.f7926a = (b) create(b.class);
    }

    public void getCommodityDetails(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7926a.getCommodityDetails(str).enqueue(enqueueResponse(this.f7927b));
        }
    }

    public MutableLiveData<CommodityVo> getCommodityResult() {
        return this.f7927b;
    }
}
