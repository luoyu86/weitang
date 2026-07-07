package com.chinavisionary.twlib.open.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.e.a.s.d;
import c.e.e.a.s.e;
import c.e.e.a.s.i;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;

/* JADX INFO: loaded from: classes2.dex */
public class NewOpenDoorModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f8788a = "NewOpenDoorModel";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<ResponseStateVo> f8789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<ResponseRowsVo<e>> f8790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<d>> f8791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<d>> f8792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<ResponseRowsVo<d>> f8793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<NewResponseStateVo> f8794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<ResponseStateVo> f8795h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c.e.e.a.q.a f8796i;

    public class a extends MutableLiveData<NewResponseRowsVo<d>> {
        public a() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(NewResponseRowsVo<d> newResponseRowsVo) {
            super.setValue(newResponseRowsVo);
            if (newResponseRowsVo == null) {
                NewOpenDoorModel.this.handlerResponseErr(null, "Response msg is empty");
                return;
            }
            if (!newResponseRowsVo.isSuccess()) {
                NewOpenDoorModel.this.handlerResponseErr(null, newResponseRowsVo.getMessage());
                return;
            }
            ResponseRowsVo responseRowsVo = new ResponseRowsVo();
            responseRowsVo.setMessage(newResponseRowsVo.getMessage());
            responseRowsVo.setSuccess(newResponseRowsVo.isSuccess());
            responseRowsVo.setTotal(newResponseRowsVo.getTotal());
            responseRowsVo.setRows(newResponseRowsVo.getRows());
            NewOpenDoorModel.this.f8793f.postValue(responseRowsVo);
        }
    }

    public class b extends MutableLiveData<NewResponseStateVo> {
        public b() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(NewResponseStateVo newResponseStateVo) {
            super.setValue(newResponseStateVo);
            NewOpenDoorModel newOpenDoorModel = NewOpenDoorModel.this;
            newOpenDoorModel.handleResponseState(newResponseStateVo, newOpenDoorModel.f8795h);
        }
    }

    public NewOpenDoorModel() {
        super(j.getInstance().getH5ApiBaseUrl());
        this.f8789b = new MutableLiveData<>();
        this.f8790c = new MutableLiveData<>();
        this.f8791d = new MutableLiveData<>();
        this.f8792e = new a();
        this.f8793f = new MutableLiveData<>();
        this.f8794g = new b();
        this.f8795h = new MutableLiveData<>();
        this.f8796i = (c.e.e.a.q.a) create(c.e.e.a.q.a.class);
    }

    public void getLockList() {
        this.f8796i.getLockList(getToken(), new BaseVo()).enqueue(enqueueResponse(this.f8790c));
    }

    public MutableLiveData<ResponseRowsVo<e>> getLockListLiveData() {
        return this.f8790c;
    }

    public MutableLiveData<ResponseStateVo> getResultLiveData() {
        return this.f8789b;
    }

    public MutableLiveData<NewResponseRowsVo<d>> getRoomList() {
        return this.f8791d;
    }

    public MutableLiveData<ResponseStateVo> getRoomSelectLiveData() {
        return this.f8795h;
    }

    public void getSignLockList(String str) {
        q.d(f8788a, "getSignLockList method = " + str);
        this.f8796i.getSignRoomList(getToken(), new BaseVo()).enqueue(enqueueBaseVoResponse(this.f8792e));
    }

    public MutableLiveData<ResponseRowsVo<d>> getSignLockListLiveData() {
        return this.f8793f;
    }

    public void postSelectRoom(e eVar) {
        if (eVar != null && x.isNotNull(eVar.getContractKey()) && x.isNotNull(eVar.getAssetInstanceKey())) {
            if (eVar.getAssetInstanceKey().equals(w.getInstance().getString("room_key", ""))) {
                NewResponseStateVo newResponseStateVo = new NewResponseStateVo();
                newResponseStateVo.setSuccess(true);
                newResponseStateVo.setMessage("切换成功");
                this.f8794g.postValue(newResponseStateVo);
                return;
            }
            String contractKey = eVar.getContractKey();
            i iVar = new i();
            iVar.setAssetKey(eVar.getAssetInstanceKey());
            if (x.isNotNull(contractKey)) {
                iVar.setContractKey(contractKey);
                w.getInstance().putString("current_contract_key", contractKey);
            }
            this.f8796i.postRoomKey(getToken(), iVar).enqueue(enqueueBaseVoResponse(this.f8794g));
        }
    }

    public void getRoomList(String str) {
        q.d(f8788a, "getRoomList method = " + str);
        this.f8796i.getRoomList(getToken(), new BaseVo()).enqueue(enqueueBaseVoResponse(this.f8791d));
    }
}
