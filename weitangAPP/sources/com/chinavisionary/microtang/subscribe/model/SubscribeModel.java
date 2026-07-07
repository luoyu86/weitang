package com.chinavisionary.microtang.subscribe.model;

import androidx.lifecycle.MutableLiveData;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.subscribe.vo.ResponseSubscribeVo;
import com.chinavisionary.microtang.subscribe.vo.SubscribeRoomBo;
import h.d;
import h.l;

/* JADX INFO: loaded from: classes2.dex */
public class SubscribeModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<ResponseSubscribeVo> f8622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<String> f8623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c.e.c.k0.d.a f8624c;

    public class a implements d<ResponseContent<ResponseSubscribeVo>> {
        public a() {
        }

        @Override // h.d
        public void onFailure(h.b<ResponseContent<ResponseSubscribeVo>> bVar, Throwable th) {
            SubscribeModel.this.handlerResponseErr(bVar, th.getMessage());
        }

        @Override // h.d
        public void onResponse(h.b<ResponseContent<ResponseSubscribeVo>> bVar, l<ResponseContent<ResponseSubscribeVo>> lVar) {
            SubscribeModel subscribeModel = SubscribeModel.this;
            subscribeModel.handlerResponse(lVar, bVar, subscribeModel.f8622a);
        }
    }

    public class b implements d<ResponseContent<String>> {
        public b() {
        }

        @Override // h.d
        public void onFailure(h.b<ResponseContent<String>> bVar, Throwable th) {
            SubscribeModel.this.handlerResponseErr(bVar, th.getMessage());
        }

        @Override // h.d
        public void onResponse(h.b<ResponseContent<String>> bVar, l<ResponseContent<String>> lVar) {
            SubscribeModel subscribeModel = SubscribeModel.this;
            subscribeModel.handlerResponse(lVar, bVar, subscribeModel.f8623b);
        }
    }

    public class c implements d<ResponseContent<String>> {
        public c() {
        }

        @Override // h.d
        public void onFailure(h.b<ResponseContent<String>> bVar, Throwable th) {
            SubscribeModel.this.handlerResponseErr(bVar, th.getMessage());
        }

        @Override // h.d
        public void onResponse(h.b<ResponseContent<String>> bVar, l<ResponseContent<String>> lVar) {
            SubscribeModel subscribeModel = SubscribeModel.this;
            subscribeModel.handlerResponse(lVar, bVar, subscribeModel.f8623b);
        }
    }

    public SubscribeModel() {
        super(null);
        this.f8622a = new MutableLiveData<>();
        this.f8623b = new MutableLiveData<>();
        this.f8624c = (c.e.c.k0.d.a) create(c.e.c.k0.d.a.class);
    }

    public void cancelSubscribe(String str) {
        this.f8624c.cancelSubscribe(str).enqueue(new b());
    }

    public void doSubscribe(String str, SubscribeRoomBo subscribeRoomBo) {
        this.f8624c.postSubscribe(str, subscribeRoomBo).enqueue(new c());
    }

    public MutableLiveData<ResponseSubscribeVo> getListMutableLiveData() {
        return this.f8622a;
    }

    public MutableLiveData<String> getResultLiveData() {
        return this.f8623b;
    }

    public void getSubscribeList(PageBo pageBo) {
        this.f8624c.getRecordList(getQueryMap(pageBo)).enqueue(new a());
    }
}
