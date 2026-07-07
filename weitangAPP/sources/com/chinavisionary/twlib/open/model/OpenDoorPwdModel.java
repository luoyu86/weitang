package com.chinavisionary.twlib.open.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.a.d.q;
import c.e.e.a.q.c;
import c.e.e.a.s.f;
import c.e.e.a.s.g;
import c.e.e.a.s.h;
import c.e.e.a.x.k;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import com.chinavisionary.twlib.open.bo.ResponseOpenDoorVo;
import com.chinavisionary.twlib.open.bo.TwLibCheckCreateCommentBo;
import h.d;
import h.l;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class OpenDoorPwdModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f8806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<ResponseOpenDoorVo> f8807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<String> f8808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<NewResponseStateVo> f8809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<TwLibCheckCreateCommentBo> f8810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<TwLibCheckCreateCommentBo> f8811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MutableLiveData<NewResponseRowsVo<AlertMessageVo>> f8812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MutableLiveData<NewResponseRowsVo<AlertMessageVo>> f8813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MutableLiveData<Integer> f8814i;

    public class a implements d<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f8815a;

        public a(f fVar) {
            this.f8815a = fVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void b(f fVar) {
            c.e.e.a.t.b.getInstance().insertOpenLog(fVar, OpenDoorPwdModel.this.getPhone());
        }

        @Override // h.d
        public void onFailure(h.b<String> bVar, Throwable th) {
            final f fVar = this.f8815a;
            new Thread(new Runnable() { // from class: c.e.e.a.v.a
                @Override // java.lang.Runnable
                public final void run() {
                    this.f2479a.b(fVar);
                }
            }).start();
        }

        @Override // h.d
        public void onResponse(h.b<String> bVar, l<String> lVar) {
            OpenDoorPwdModel.this.f8808c.postValue(lVar.body());
        }
    }

    public class b implements d<String> {
        public b() {
        }

        @Override // h.d
        public void onFailure(h.b<String> bVar, Throwable th) {
        }

        @Override // h.d
        public void onResponse(h.b<String> bVar, l<String> lVar) {
            OpenDoorPwdModel.this.f8808c.postValue(lVar.body());
            new Thread(new Runnable() { // from class: c.e.e.a.v.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.e.e.a.t.b.getInstance().clearTableData();
                }
            }).start();
        }
    }

    public OpenDoorPwdModel() {
        super(j.getInstance().getH5ApiBaseUrl());
        this.f8807b = new MutableLiveData<>();
        this.f8808c = new MutableLiveData<>();
        this.f8809d = new MutableLiveData<>();
        this.f8810e = new MutableLiveData<>();
        this.f8811f = new MutableLiveData<>();
        this.f8812g = new MutableLiveData<>();
        this.f8813h = new MutableLiveData<>();
        this.f8814i = new MutableLiveData<>();
        this.f8806a = (c) create(c.class);
    }

    public void doorlockAfter() {
        this.f8806a.getDoorlockAfter(getToken(), new c.e.e.a.s.j()).enqueue(enqueueBaseVoResponse(this.f8813h));
    }

    public void doorlockBefore() {
        this.f8806a.getDoorlockBefore(getToken(), new c.e.e.a.s.j()).enqueue(enqueueBaseVoResponse(this.f8812g));
    }

    public MutableLiveData<NewResponseRowsVo<AlertMessageVo>> getAfterAlertMessageVo() {
        return this.f8813h;
    }

    public MutableLiveData<TwLibCheckCreateCommentBo> getCheckCommentLive() {
        return this.f8811f;
    }

    public void getCheckCreateComment(String str) {
        g gVar = new g();
        gVar.setContractKey(str);
        this.f8806a.getCheckCreateComment(getToken(), gVar).enqueue(enqueueBaseVoResponse(this.f8811f));
    }

    public void getCheckSignComment() {
        this.f8806a.getCheckSignComment(getToken(), new HashMap<>()).enqueue(enqueueBaseVoResponse(this.f8810e));
    }

    public MutableLiveData<TwLibCheckCreateCommentBo> getCheckSignCommentLive() {
        return this.f8810e;
    }

    public void getDoorPwd(String str, String str2) {
        if (checkParamIsInvalid(str)) {
            q.d(getClass().getSimpleName(), "getDoorPwd assetKey = " + str + ", method = " + str2);
            this.f8806a.getDoorPwdToKey(getToken(), str).enqueue(enqueueBaseVoResponse(this.f8807b));
        }
    }

    public void getDoorPwdToCache(String str, String str2) {
        if (checkParamIsInvalid(str)) {
            q.d(getClass().getSimpleName(), "getDoorPwdToCache assetKey = " + str + ", method = " + str2);
            this.f8806a.getDoorPwdToKey(getToken(), str).enqueue(enqueueBaseVoResponse(this.f8807b, str));
        }
    }

    public MutableLiveData<ResponseOpenDoorVo> getDoorVoMutableLiveData() {
        return this.f8807b;
    }

    public MutableLiveData<Integer> getError() {
        return this.f8814i;
    }

    public MutableLiveData<String> getOpenDoorResult() {
        return this.f8808c;
    }

    public MutableLiveData<NewResponseRowsVo<AlertMessageVo>> getmAlertMessageVoMutableLiveData() {
        return this.f8812g;
    }

    public MutableLiveData<NewResponseStateVo> getmNetworkOpenDoorResult() {
        return this.f8809d;
    }

    public void postBatchDoorPwdRecordLog(c.e.e.a.s.b bVar) {
        if (checkObjectParamIsValid(bVar)) {
            this.f8806a.postBatchDoorOpenDoorRecord(bVar).enqueue(new b());
        }
    }

    public void postDoorPwdRecordLog(f fVar) {
        if (checkObjectParamIsValid(fVar)) {
            String failReason = fVar.getFailReason();
            String remark = fVar.getRemark();
            if (k.isNotNull(failReason)) {
                fVar.setFailReason(c.e.e.a.x.l.getInstance().getFailedMessage(failReason));
                if (remark != null) {
                    fVar.setRemark(remark + "," + failReason);
                } else {
                    fVar.setRemark(failReason);
                }
            } else if (!remark.equals("远程开门")) {
                fVar.setFailReason(c.e.e.a.x.l.getInstance().getFailedMessage(remark));
            }
            this.f8806a.postDoorOpenDoorRecord(getToken(), fVar).enqueue(new a(fVar));
        }
    }

    public void postNetworkOpenDoor(h hVar, String str) {
        if (checkObjectParamIsValid(hVar)) {
            q.d(getClass().getSimpleName(), "getDoorPwd assetKey = " + hVar.getAssetKey() + ", method = " + str);
            this.f8806a.postNetworkOpenDoor(getToken(), hVar).enqueue(enqueueBaseVoResponse(this.f8809d));
        }
    }
}
