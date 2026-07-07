package com.chinavisionary.microtang.main.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.a.d.q;
import c.e.c.v.a.b;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.main.bo.ProjectVo;
import com.chinavisionary.microtang.main.bo.RequestGroupItemDetailsBo;
import com.chinavisionary.microtang.main.bo.RequestGroupItemDetailsRoomListBo;
import com.chinavisionary.microtang.main.bo.RequestGroupListParamBo;
import com.chinavisionary.microtang.main.bo.RequestProjectParamBo;
import com.chinavisionary.microtang.main.bo.RequestSwitchProjectBo;
import com.chinavisionary.microtang.main.bo.ResponseAliYunOssBo;
import com.chinavisionary.microtang.main.vo.CityItemVo;
import com.chinavisionary.microtang.main.vo.ResponseGroupItemDetailsRoomVo;
import com.chinavisionary.microtang.main.vo.ResponseGroupItemDetailsVo;
import com.chinavisionary.microtang.main.vo.ResponseGroupResultVo;

/* JADX INFO: loaded from: classes.dex */
public class NewRoomModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f7491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<CityItemVo>> f7492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<ProjectVo>> f7493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<NewResponseStateVo> f7494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<ResponseAliYunOssBo> f7495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<ResponseGroupResultVo>> f7496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<ResponseGroupItemDetailsRoomVo>> f7497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<ResponseGroupItemDetailsVo> f7498h;

    public NewRoomModel() {
        super(j.getInstance().getH5ApiBaseUrl());
        this.f7492b = new MutableLiveData<>();
        this.f7493c = new MutableLiveData<>();
        this.f7494d = new MutableLiveData<>();
        this.f7495e = new MutableLiveData<>();
        this.f7496f = new MutableLiveData<>();
        this.f7497g = new MutableLiveData<>();
        this.f7498h = new MutableLiveData<>();
        this.f7491a = (b) create(b.class);
    }

    public void getAliYunOssAuth() {
        this.f7491a.getAliYunOssAuth(getToken(), new BaseVo()).enqueue(enqueueBaseVoResponse(this.f7495e));
    }

    public MutableLiveData<ResponseAliYunOssBo> getAliYunOssAuthResult() {
        return this.f7495e;
    }

    public void getCityList() {
        this.f7491a.getCityList(getToken(), new BaseVo()).enqueue(enqueueBaseVoResponse(this.f7492b));
    }

    public MutableLiveData<NewResponseRowsVo<CityItemVo>> getCityResult() {
        return this.f7492b;
    }

    public MutableLiveData<ResponseGroupItemDetailsVo> getGroupDetailsResult() {
        return this.f7498h;
    }

    public void getGroupItemDetails(String str) {
        if (checkParamIsInvalid(str)) {
            RequestGroupItemDetailsBo requestGroupItemDetailsBo = new RequestGroupItemDetailsBo();
            requestGroupItemDetailsBo.setGroupKey(str);
            this.f7491a.getGroupItemDetails(getToken(), requestGroupItemDetailsBo).enqueue(enqueueBaseVoResponse(this.f7498h));
        }
    }

    public void getGroupItemDetailsRoomList(RequestGroupItemDetailsRoomListBo requestGroupItemDetailsRoomListBo) {
        if (checkObjectParamIsValid(requestGroupItemDetailsRoomListBo)) {
            this.f7491a.getGroupItemDetailsRoomList(getToken(), requestGroupItemDetailsRoomListBo).enqueue(enqueueBaseVoResponse(this.f7497g));
        }
    }

    public void getGroupList(String str, String str2) {
        if (checkParamIsInvalid(str)) {
            q.d("NewRoomModel", "getGroupList projectKey = " + str + ",methode = " + str2);
            RequestGroupListParamBo requestGroupListParamBo = new RequestGroupListParamBo();
            requestGroupListParamBo.setProjectKey(str);
            this.f7491a.getGroupList(getToken(), requestGroupListParamBo).enqueue(enqueueBaseVoResponse(this.f7496f));
        }
    }

    public MutableLiveData<NewResponseRowsVo<ResponseGroupResultVo>> getGroupResult() {
        return this.f7496f;
    }

    public MutableLiveData<NewResponseRowsVo<ResponseGroupItemDetailsRoomVo>> getGroupRoomListResult() {
        return this.f7497g;
    }

    public void getProjectList(String str) {
        RequestProjectParamBo requestProjectParamBo = new RequestProjectParamBo();
        requestProjectParamBo.setCityKey(str);
        this.f7491a.getProjectList(getToken(), requestProjectParamBo).enqueue(enqueueBaseVoResponse(this.f7493c));
    }

    public MutableLiveData<NewResponseRowsVo<ProjectVo>> getProjectResult() {
        return this.f7493c;
    }

    public MutableLiveData<NewResponseStateVo> getSwitchProjectResult() {
        return this.f7494d;
    }

    public void postSwitchProject(String str) {
        if (checkParamIsInvalid(str)) {
            RequestSwitchProjectBo requestSwitchProjectBo = new RequestSwitchProjectBo();
            requestSwitchProjectBo.setProjectId(str);
            this.f7491a.switchProject(getToken(), requestSwitchProjectBo).enqueue(enqueueBaseVoResponse(this.f7494d));
        }
    }
}
