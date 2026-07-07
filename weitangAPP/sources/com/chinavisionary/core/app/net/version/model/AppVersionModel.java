package com.chinavisionary.core.app.net.version.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.a.h.f.a.a;
import c.e.a.d.j;
import com.chinavisionary.core.app.config.bo.AppUpdateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;

/* JADX INFO: loaded from: classes.dex */
public class AppVersionModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<AppUpdateVo> f6511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f6512b;

    public AppVersionModel() {
        super(j.getInstance().getH5ApiBaseUrl());
        this.f6511a = new MutableLiveData<>();
        this.f6512b = (a) create(a.class);
    }

    public void getAppVersion() {
        this.f6512b.getAppVersion("1").enqueue(enqueueResponse(this.f6511a));
    }

    public MutableLiveData<AppUpdateVo> getUpdateVoMutableLiveData() {
        return this.f6511a;
    }
}
