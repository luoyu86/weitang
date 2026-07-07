package com.chinavisionary.microtang.open.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.a.d.x;
import c.e.c.a0.e.a;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.open.bo.RoomOpenLockRecordDetailsVo;
import com.chinavisionary.microtang.open.bo.RoomOpenLockRecordVo;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class RoomOpenLockModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<RoomOpenLockRecordVo>> f8033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<RoomOpenLockRecordDetailsVo>> f8034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f8035c;

    public RoomOpenLockModel() {
        super(j.getInstance().getRentBaseUrl());
        this.f8033a = new MutableLiveData<>();
        this.f8034b = new MutableLiveData<>();
        this.f8035c = (a) create(a.class);
    }

    public MutableLiveData<ResponseRowsVo<RoomOpenLockRecordVo>> getOpenLockRecord() {
        return this.f8033a;
    }

    public MutableLiveData<ResponseRowsVo<RoomOpenLockRecordDetailsVo>> getOpenLockRecordDetails() {
        return this.f8034b;
    }

    public void getRoomOpenLockList(PageBo pageBo, String str) {
        if (checkObjectParamIsValid(pageBo)) {
            Map<String, String> queryMap = getQueryMap(pageBo);
            if (x.isNotNull(str)) {
                queryMap.put(RequestParameters.SUBRESOURCE_LOCATION, str);
            }
            this.f8035c.getRoomOpenLockRecordList(queryMap).enqueue(enqueueResponse(this.f8033a));
        }
    }

    public void getRoomOpenLockRecordDetailsList(PageBo pageBo, String str, Long l, Long l2) {
        if (checkObjectParamIsValid(pageBo)) {
            Map<String, String> queryMap = getQueryMap(pageBo);
            if (x.isNotNull(str)) {
                queryMap.put("rentHouseKey", str);
            }
            if (l != null && l2 != null) {
                queryMap.put("startTime", l.toString());
                queryMap.put("endTime", l2.toString());
            }
            this.f8035c.getOpenLockRecordDetailsList(str, queryMap).enqueue(enqueueResponse(this.f8034b));
        }
    }
}
