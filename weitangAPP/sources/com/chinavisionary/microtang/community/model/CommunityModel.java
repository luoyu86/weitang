package com.chinavisionary.microtang.community.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.a.d.x;
import c.e.c.n.a.a;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.community.vo.LatLngVo;
import com.chinavisionary.microtang.community.vo.NewCommunityActivityItemVo;
import com.chinavisionary.microtang.community.vo.RequestActivityCommentBo;
import com.chinavisionary.microtang.community.vo.RequestActivityCommentDetailsBo;
import com.chinavisionary.microtang.community.vo.RequestGetActivityRecordParamBo;
import com.chinavisionary.microtang.community.vo.ResponseActivityCommentVo;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CommunityModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<NewCommunityActivityItemVo>> f7076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<NewCommunityActivityItemVo>> f7077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<NewResponseStateVo> f7078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<ResponseActivityCommentVo> f7079e;

    public CommunityModel() {
        super(j.getInstance().getBjApiBaseUrl());
        this.f7076b = new MutableLiveData<>();
        this.f7077c = new MutableLiveData<>();
        this.f7078d = new MutableLiveData<>();
        this.f7079e = new MutableLiveData<>();
        this.f7075a = (a) create(a.class);
    }

    public void getActivityComment(RequestActivityCommentDetailsBo requestActivityCommentDetailsBo) {
        this.f7075a.getActivityComment(requestActivityCommentDetailsBo).enqueue(enqueueBaseVoResponse(this.f7079e));
    }

    public void getActivityList(PageBo pageBo, String str, LatLngVo latLngVo, String str2) {
        Map<String, String> queryMap = getQueryMap(pageBo);
        if (x.isNotNull(str)) {
            queryMap.put("projectKey", str);
        }
        if (latLngVo != null) {
            queryMap.put("longitude", String.valueOf(latLngVo.getLongitude()));
            queryMap.put("latitude", String.valueOf(latLngVo.getLatitude()));
        }
        if (x.isNotNull(str2)) {
            queryMap.put("activityLab", str2);
        }
        this.f7075a.getActivityList(queryMap).enqueue(enqueueBaseVoResponse(this.f7076b));
    }

    public LiveData<NewResponseRowsVo<NewCommunityActivityItemVo>> getActivityResult() {
        return this.f7076b;
    }

    public MutableLiveData<ResponseActivityCommentVo> getCommentDetailsResult() {
        return this.f7079e;
    }

    public MutableLiveData<NewResponseStateVo> getCommentResult() {
        return this.f7078d;
    }

    public void getMeActivityList(PageBo pageBo, int i2) {
        RequestGetActivityRecordParamBo requestGetActivityRecordParamBo = new RequestGetActivityRecordParamBo();
        requestGetActivityRecordParamBo.setQueryType(String.valueOf(i2));
        requestGetActivityRecordParamBo.setPageSize(pageBo.getPageNumber());
        requestGetActivityRecordParamBo.setCurrentPage(pageBo.getPage());
        this.f7075a.getMyActivityList(requestGetActivityRecordParamBo).enqueue(enqueueBaseVoResponse(this.f7077c));
    }

    public MutableLiveData<NewResponseRowsVo<NewCommunityActivityItemVo>> getMeActivityResult() {
        return this.f7077c;
    }

    public void postActivityComment(RequestActivityCommentBo requestActivityCommentBo) {
        this.f7075a.postActivityComment(requestActivityCommentBo).enqueue(enqueueBaseVoResponse(this.f7078d));
    }
}
