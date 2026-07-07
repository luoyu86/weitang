package com.chinavisionary.microtang.main.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.c.v.a.a;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.community.vo.ActivityConstantVo;
import com.chinavisionary.microtang.main.bo.ClickBannerParamBo;
import com.chinavisionary.microtang.main.bo.RequestBannerParamBo;
import com.chinavisionary.microtang.main.bo.ResponseBannerItemVo;
import com.chinavisionary.microtang.main.bo.ResponseNewBannerItemVo;

/* JADX INFO: loaded from: classes.dex */
public class BannerModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<ResponseBannerItemVo>> f7487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<ResponseNewBannerItemVo>> f7488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<NewResponseStateVo> f7489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<ActivityConstantVo> f7490e;

    public BannerModel() {
        super(j.getInstance().getH5ApiBaseUrl());
        this.f7487b = new MutableLiveData<>();
        this.f7488c = new MutableLiveData<>();
        this.f7489d = new MutableLiveData<>();
        this.f7490e = new MutableLiveData<>();
        this.f7486a = (a) create(a.class);
    }

    public void getBannerList(RequestBannerParamBo requestBannerParamBo) {
        this.f7486a.getBannerList(getToken(), requestBannerParamBo).enqueue(enqueueBaseVoResponse(this.f7488c));
    }

    public MutableLiveData<NewResponseRowsVo<ResponseBannerItemVo>> getBannerResult() {
        return this.f7487b;
    }

    public void getConstantList() {
        this.f7486a.getConstantList(getToken(), "activityLabType").enqueue(enqueueBaseVoResponse(this.f7490e));
    }

    public MutableLiveData<ActivityConstantVo> getConstantResult() {
        return this.f7490e;
    }

    public MutableLiveData<NewResponseRowsVo<ResponseNewBannerItemVo>> getNewBannerResult() {
        return this.f7488c;
    }

    public MutableLiveData<NewResponseStateVo> getRecordResult() {
        return this.f7489d;
    }

    public void getRoomBannerList(RequestBannerParamBo requestBannerParamBo) {
        this.f7486a.getRoomBannerList(getToken(), requestBannerParamBo).enqueue(enqueueBaseVoResponse(this.f7487b));
    }

    public void recordBannerClick(ClickBannerParamBo clickBannerParamBo) {
        this.f7486a.postBannerClick(getToken(), clickBannerParamBo).enqueue(enqueueBaseVoResponse(this.f7489d));
    }
}
