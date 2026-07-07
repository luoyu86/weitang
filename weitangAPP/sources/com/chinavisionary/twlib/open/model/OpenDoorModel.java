package com.chinavisionary.twlib.open.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.e.a.q.b;
import c.e.e.a.s.d;
import c.e.e.a.s.e;
import c.e.e.a.s.i;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class OpenDoorModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<ResponseStateVo> f8799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<e>> f8800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<e>> f8801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<e>> f8802d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<ResponseRowsVo<d>> f8803e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<ResponseStateVo> f8804f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f8805g;

    public OpenDoorModel() {
        super(j.getInstance().getH5ApiBaseUrl());
        this.f8799a = new MutableLiveData<>();
        this.f8800b = new MutableLiveData<>();
        this.f8801c = new MutableLiveData<>();
        this.f8802d = new MutableLiveData<>();
        this.f8803e = new MutableLiveData<>();
        this.f8804f = new MutableLiveData<>();
        this.f8805g = (b) create(b.class);
    }

    public void getLockList() {
        this.f8805g.getLockList(getToken()).enqueue(enqueueBaseVoResponse(this.f8800b));
    }

    public MutableLiveData<NewResponseRowsVo<e>> getLockListLiveData() {
        return this.f8800b;
    }

    public void getLockPowerList(String str, String str2) {
        HashMap map = new HashMap();
        if (x.isNotNull(str)) {
            map.put("assetInstanceKey", str);
        }
        if (x.isNotNull(str2)) {
            map.put("contractKey", str2);
        }
        this.f8805g.getLockPowerList(getToken(), map).enqueue(enqueueBaseVoResponse(this.f8801c));
    }

    public MutableLiveData<NewResponseRowsVo<e>> getLockPowerListLiveData() {
        return this.f8801c;
    }

    public void getLockRoomStateList(String str, String str2) {
        HashMap map = new HashMap();
        if (x.isNotNull(str)) {
            map.put("assetInstanceKey", str);
        }
        if (x.isNotNull(str2)) {
            map.put("contractKey", str2);
        }
        this.f8805g.getLockRoomStateList(getToken(), map).enqueue(enqueueBaseVoResponse(this.f8802d));
    }

    public MutableLiveData<NewResponseRowsVo<e>> getLockStateListLiveData() {
        return this.f8802d;
    }

    public MutableLiveData<ResponseStateVo> getResultLiveData() {
        return this.f8799a;
    }

    public MutableLiveData<ResponseStateVo> getRoomSelectLiveData() {
        return this.f8804f;
    }

    public void getSignLockList() {
        this.f8805g.getSignRoomList(getToken()).enqueue(enqueueResponse(this.f8803e));
    }

    public MutableLiveData<ResponseRowsVo<d>> getSignLockListLiveData() {
        return this.f8803e;
    }

    public void postSelectRoom(e eVar) {
        String contractKey = eVar.getContractKey();
        i iVar = new i();
        iVar.setAssetKey(eVar.getAssetInstanceKey());
        if (x.isNotNull(contractKey)) {
            iVar.setContractKey(contractKey);
            w.getInstance().putString("current_contract_key", contractKey);
        }
        this.f8805g.postRoomKey(getToken(), iVar).enqueue(enqueueResponse(this.f8804f));
    }
}
