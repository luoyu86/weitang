package com.chinavisionary.microtang.room.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.c.h0.d.a;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.microtang.repair.vo.ResponseVo;
import com.chinavisionary.microtang.room.vo.CreateRoomPreLookVo;
import com.chinavisionary.microtang.room.vo.MoreRentRoomVo;
import com.chinavisionary.microtang.room.vo.PreRoomInfoVo;
import com.chinavisionary.microtang.room.vo.ProductDetailsVo;
import com.chinavisionary.microtang.room.vo.ResponseMoreRentCommentVo;
import com.chinavisionary.microtang.room.vo.RoomSourceDetailsVo;
import h.b;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class RoomOperationModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f8382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f8383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f8384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<ProductDetailsVo> f8385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<RoomSourceDetailsVo> f8386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableLiveData<PreRoomInfoVo> f8387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MutableLiveData<ResponseMoreRentCommentVo> f8388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MutableLiveData<ResponseVo<MoreRentRoomVo>> f8389h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f8390i;

    public RoomOperationModel() {
        super(null);
        this.f8383b = new MutableLiveData<>();
        this.f8384c = new MutableLiveData<>();
        this.f8385d = new MutableLiveData<>();
        this.f8386e = new MutableLiveData<>();
        this.f8387f = new MutableLiveData<>();
        this.f8388g = new MutableLiveData<>();
        this.f8389h = new MutableLiveData<>();
        this.f8382a = (a) create(a.class);
    }

    public MutableLiveData<ResponseStateVo> getAirQualityLiveData() {
        return this.f8383b;
    }

    public MutableLiveData<ResponseStateVo> getPreLookResultLiveData() {
        return this.f8384c;
    }

    public MutableLiveData<PreRoomInfoVo> getPreRoomInfo() {
        return this.f8387f;
    }

    public MutableLiveData<ProductDetailsVo> getProductDetails() {
        return this.f8385d;
    }

    public void getRoomAirQuality(String str) {
        this.f8382a.getAirQuality(str).enqueue(enqueueResponse(this.f8383b));
    }

    public MutableLiveData<ResponseMoreRentCommentVo> getRoomCommentList() {
        return this.f8388g;
    }

    public MutableLiveData<RoomSourceDetailsVo> getRoomDetails() {
        return this.f8386e;
    }

    public MutableLiveData<ResponseVo<MoreRentRoomVo>> getRoomIdleList() {
        return this.f8389h;
    }

    public void getRoomPreInfo() {
        this.f8382a.getRoomPreInfo(new HashMap<>()).enqueue(enqueueBaseVoResponse(this.f8387f));
    }

    public void getRoomSourceDetails(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8382a.getRoomSourceDetails(str).enqueue(enqueueBaseVoResponse(this.f8386e));
        }
    }

    public void postPreLookRoom(CreateRoomPreLookVo createRoomPreLookVo) {
        if (checkObjectParamIsValid(createRoomPreLookVo)) {
            this.f8382a.postPreLook(createRoomPreLookVo).enqueue(enqueueBaseVoResponse(this.f8384c));
        }
    }

    public void updateBaseUrl(String str) {
        initRetrofit(str);
        this.f8382a = (a) create(a.class);
    }

    public void getProductDetails(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8382a.getRoomDetails(str).enqueue(enqueueResponse(this.f8385d));
        }
    }

    public void getRoomCommentList(String str) {
        if (checkParamIsInvalid(str)) {
            this.f8382a.getRoomCommentList(str).enqueue(enqueueResponse(this.f8388g));
        }
    }

    public void getRoomIdleList(PageBo pageBo, String str, String str2, Boolean bool) {
        Map<String, String> queryMap = getQueryMap(pageBo);
        if (x.isNotNull(str2)) {
            queryMap.put("houseCode", str2);
        }
        if (x.isNotNull(str)) {
            queryMap.put("goodsKey", str);
        }
        if (bool != null) {
            queryMap.put("changeRentFlag", String.valueOf(bool));
        }
        String string = w.getInstance().getString("selectProjectKey", null);
        if (x.isNotNull(string)) {
            queryMap.put("projectKey", string);
        }
        b bVar = this.f8390i;
        if (bVar != null && bVar.isExecuted()) {
            this.f8390i.cancel();
        }
        b<ResponseContent<ResponseVo<MoreRentRoomVo>>> roomIdleList = this.f8382a.getRoomIdleList(queryMap);
        this.f8390i = roomIdleList;
        roomIdleList.enqueue(enqueueResponse(this.f8389h));
    }
}
