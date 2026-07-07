package com.chinavisionary.microtang.order.model;

import androidx.lifecycle.MutableLiveData;
import c.e.c.b0.a.a;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.order.vo.OrderDetailsVo;
import com.chinavisionary.microtang.order.vo.OrderVo;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class OrderModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<OrderVo>> f8119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<OrderDetailsVo> f8120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f8121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f8122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public a f8123e;

    public OrderModel() {
        super(null);
        this.f8119a = new MutableLiveData<>();
        this.f8120b = new MutableLiveData<>();
        this.f8121c = new MutableLiveData<>();
        this.f8122d = new MutableLiveData<>();
        this.f8123e = (a) create(a.class);
    }

    public void cancelOrder(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8123e.cancelOrder(str).enqueue(enqueueResponse(this.f8121c));
        }
    }

    public void confirmReceipt(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8123e.confirmReceipt(str).enqueue(enqueueResponse(this.f8122d));
        }
    }

    public MutableLiveData<ResponseStateVo> getCancelOrderLive() {
        return this.f8121c;
    }

    public MutableLiveData<ResponseStateVo> getConfirmOrderLive() {
        return this.f8122d;
    }

    public void getOrderDetails(String str, int i2) {
        if (checkParamIsInvalid(str)) {
            this.f8123e.getOrderDetails(i2, str).enqueue(enqueueResponse(this.f8120b));
        }
    }

    public MutableLiveData<OrderDetailsVo> getOrderDetailsLive() {
        return this.f8120b;
    }

    public void getOrderList(PageBo pageBo, int i2) {
        if (checkObjectParamIsValid(pageBo)) {
            Map<String, String> queryMap = getQueryMap(pageBo);
            if (i2 >= 0) {
                queryMap.put("orderStatus", String.valueOf(i2));
            }
            this.f8123e.getOrderList(queryMap).enqueue(enqueueResponse(this.f8119a));
        }
    }

    public MutableLiveData<ResponseRowsVo<OrderVo>> getOrderListLive() {
        return this.f8119a;
    }
}
