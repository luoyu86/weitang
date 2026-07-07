package com.chinavisionary.microtang.doorpwd.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.c.q.a.a;
import c.e.c.q.d.c;
import c.e.c.q.d.d;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.doorpwd.vo.ResponseDoorPasswordBleCommandBo;

/* JADX INFO: loaded from: classes.dex */
public class DoorPasswordModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f7214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<ResponseDoorPasswordBleCommandBo> f7215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<NewResponseStateVo> f7216c;

    public DoorPasswordModel() {
        super(j.getInstance().getH5ApiBaseUrl());
        this.f7215b = new MutableLiveData<>();
        this.f7216c = new MutableLiveData<>();
        this.f7214a = (a) create(a.class);
    }

    public void getDoorPassword(c cVar) {
        this.f7214a.getDoorPasswordBleCommand(cVar).enqueue(enqueueBaseVoResponse(this.f7215b));
    }

    public MutableLiveData<NewResponseStateVo> getDoorPasswordCommandResult() {
        return this.f7216c;
    }

    public MutableLiveData<ResponseDoorPasswordBleCommandBo> getDoorPasswordResult() {
        return this.f7215b;
    }

    public void postDoorPasswordResult(d dVar) {
        this.f7214a.postDoorPasswordBleCommandResult(dVar).enqueue(enqueueBaseVoResponse(this.f7216c));
    }
}
