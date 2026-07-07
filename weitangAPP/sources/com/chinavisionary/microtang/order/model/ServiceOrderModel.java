package com.chinavisionary.microtang.order.model;

import androidx.lifecycle.MutableLiveData;
import c.e.c.b0.a.b;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.order.vo.ServiceOrderVo;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ServiceOrderModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<ServiceOrderVo>> f8124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f8125b;

    public ServiceOrderModel() {
        super(null);
        this.f8124a = new MutableLiveData<>();
        this.f8125b = (b) create(b.class);
    }

    public MutableLiveData<ResponseRowsVo<ServiceOrderVo>> getOrderResultVo() {
        return this.f8124a;
    }

    public void getServiceOrderList(PageBo pageBo, Integer num) {
        Map<String, String> queryMap = getQueryMap(pageBo);
        if (num != null) {
            queryMap.put("status", num.toString());
        }
        this.f8125b.getServiceOrderList(queryMap).enqueue(enqueueResponse(this.f8124a));
    }
}
