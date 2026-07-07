package com.chinavisionary.microtang.merchant.model;

import androidx.lifecycle.MutableLiveData;
import c.e.c.y.a.c;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.core.weight.banner.EditBannerView;
import com.chinavisionary.microtang.main.vo.MerchantInfoVo;
import com.chinavisionary.microtang.merchant.vo.MerchantDetailsVo;
import com.chinavisionary.microtang.merchant.vo.MerchantProductVo;

/* JADX INFO: loaded from: classes.dex */
public class MerchantModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f7928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<MerchantInfoVo>> f7929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<MerchantDetailsVo> f7930c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<EditBannerView.BannerDto>> f7931d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<MerchantProductVo>> f7932e;

    public MerchantModel() {
        super(null);
        this.f7929b = new MutableLiveData<>();
        this.f7930c = new MutableLiveData<>();
        this.f7931d = new MutableLiveData<>();
        this.f7932e = new MutableLiveData<>();
        this.f7928a = (c) create(c.class);
    }

    public void getMerchantBanner(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7928a.getMerchantBanner(str).enqueue(enqueueResponse(this.f7931d));
        }
    }

    public MutableLiveData<ResponseRowsVo<EditBannerView.BannerDto>> getMerchantBannerResult() {
        return this.f7931d;
    }

    public void getMerchantDetails(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7928a.getMerchantDetails(str).enqueue(enqueueResponse(this.f7930c));
        }
    }

    public MutableLiveData<MerchantDetailsVo> getMerchantDetailsResult() {
        return this.f7930c;
    }

    public void getMerchantList(PageBo pageBo) {
        if (checkObjectParamIsValid(pageBo)) {
            this.f7928a.getMerchantList(getQueryMap(pageBo)).enqueue(enqueueResponse(this.f7929b));
        }
    }

    public MutableLiveData<ResponseRowsVo<MerchantInfoVo>> getMerchantListResult() {
        return this.f7929b;
    }

    public void getMerchantProductList(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7928a.getMerchantProductList(str).enqueue(enqueueResponse(this.f7932e));
        }
    }

    public MutableLiveData<ResponseRowsVo<MerchantProductVo>> getMerchantProductResult() {
        return this.f7932e;
    }
}
