package com.chinavisionary.microtang.auth.model;

import androidx.lifecycle.MutableLiveData;
import c.e.c.h.a.a;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.auth.vo.MeAuthDetailsVo;
import com.chinavisionary.microtang.auth.vo.MeAuthHandleVo;
import com.chinavisionary.microtang.auth.vo.MeAuthVo;

/* JADX INFO: loaded from: classes.dex */
public class MeAuthModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f6846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<MeAuthVo>> f6847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<MeAuthDetailsVo> f6848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f6849d;

    public MeAuthModel() {
        super(null);
        this.f6847b = new MutableLiveData<>();
        this.f6848c = new MutableLiveData<>();
        this.f6849d = new MutableLiveData<>();
        this.f6846a = (a) create(a.class);
    }

    public void getMeAuthDetails(String str) {
        if (checkParamIsInvalid(str)) {
            this.f6846a.getMeAuthDetails(str).enqueue(enqueueResponse(this.f6848c));
        }
    }

    public MutableLiveData<MeAuthDetailsVo> getMeAuthDetailsResult() {
        return this.f6848c;
    }

    public void getMeAuthList(PageBo pageBo) {
        if (checkObjectParamIsValid(pageBo)) {
            this.f6846a.getMeAuthList(getQueryMap(pageBo)).enqueue(enqueueResponse(this.f6847b));
        }
    }

    public MutableLiveData<ResponseRowsVo<MeAuthVo>> getMeAuthListResult() {
        return this.f6847b;
    }

    public MutableLiveData<ResponseStateVo> getResponseStateResult() {
        return this.f6849d;
    }

    public void postHandleApply(MeAuthHandleVo meAuthHandleVo) {
        if (checkObjectParamIsValid(meAuthHandleVo)) {
            this.f6846a.postHandleAuth(meAuthHandleVo).enqueue(enqueueResponse(this.f6849d));
        }
    }
}
