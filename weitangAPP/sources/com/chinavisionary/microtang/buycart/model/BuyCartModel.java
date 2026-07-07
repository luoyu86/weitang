package com.chinavisionary.microtang.buycart.model;

import androidx.lifecycle.MutableLiveData;
import c.e.c.k.a.a;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.buycart.vo.BuyCartVo;
import com.chinavisionary.microtang.buycart.vo.RequestAddBuyCartBo;
import com.chinavisionary.microtang.buycart.vo.RequestDelBuyCartBo;
import com.chinavisionary.microtang.buycart.vo.RequestUpdateBuyCartBo;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BuyCartModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f6908a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<BuyCartVo>> f6909b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<BuyCartVo>> f6910c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f6911d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f6912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f6913f;

    public BuyCartModel() {
        super(null);
        this.f6909b = new MutableLiveData<>();
        this.f6910c = new MutableLiveData<>();
        this.f6911d = new MutableLiveData<>();
        this.f6912e = new MutableLiveData<>();
        this.f6913f = new MutableLiveData<>();
        this.f6908a = (a) create(a.class);
    }

    public void addBuyCart(RequestAddBuyCartBo requestAddBuyCartBo) {
        if (checkObjectParamIsValid(requestAddBuyCartBo)) {
            this.f6908a.postBuyCart(requestAddBuyCartBo).enqueue(enqueueResponse(this.f6913f));
        }
    }

    public void delBuyCart(RequestDelBuyCartBo requestDelBuyCartBo) {
        if (checkObjectParamIsValid(requestDelBuyCartBo)) {
            this.f6908a.deleteBuyCart(requestDelBuyCartBo).enqueue(enqueueResponse(this.f6911d));
        }
    }

    public MutableLiveData<ResponseStateVo> getAddResult() {
        return this.f6913f;
    }

    public void getAllBuyCartList(PageBo pageBo) {
        if (checkObjectParamIsValid(pageBo)) {
            this.f6908a.getAllBuyCartList(getQueryMap(pageBo)).enqueue(enqueueResponse(this.f6909b));
        }
    }

    public MutableLiveData<ResponseRowsVo<BuyCartVo>> getBuyCartResult() {
        return this.f6909b;
    }

    public MutableLiveData<ResponseStateVo> getDelResult() {
        return this.f6911d;
    }

    public void getMerchantBuyCartList(PageBo pageBo, String str) {
        if (checkParamIsInvalid(str)) {
            Map<String, String> queryMap = getQueryMap(pageBo);
            queryMap.put("merchantKey", str);
            this.f6908a.getBuyCartList(queryMap).enqueue(enqueueResponse(this.f6910c));
        }
    }

    public MutableLiveData<ResponseRowsVo<BuyCartVo>> getMerchantBuyCartResult() {
        return this.f6910c;
    }

    public MutableLiveData<ResponseStateVo> getUpdateResult() {
        return this.f6912e;
    }

    public void updateBuyCart(RequestUpdateBuyCartBo requestUpdateBuyCartBo) {
        if (checkObjectParamIsValid(requestUpdateBuyCartBo)) {
            this.f6908a.patchBuyCart(requestUpdateBuyCartBo).enqueue(enqueueResponse(this.f6912e));
        }
    }
}
