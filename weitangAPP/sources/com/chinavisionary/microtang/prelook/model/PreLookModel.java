package com.chinavisionary.microtang.prelook.model;

import androidx.lifecycle.MutableLiveData;
import c.e.c.d0.a.a;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.prelook.vo.PreLookCommentVo;
import com.chinavisionary.microtang.prelook.vo.PreLookVo;

/* JADX INFO: loaded from: classes2.dex */
public class PreLookModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<ResponseRowsVo<PreLookVo>> f8208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f8209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f8210c;

    public PreLookModel() {
        super(null);
        this.f8208a = new MutableLiveData<>();
        this.f8209b = new MutableLiveData<>();
        this.f8210c = (a) create(a.class);
    }

    public void cancelPreLook(String str) {
        this.f8210c.cancelPreLook(str).enqueue(enqueueResponse(this.f8209b));
    }

    public void getPreLookRecordList(PageBo pageBo) {
        this.f8210c.getPreLookRecordList(getQueryMap(pageBo)).enqueue(enqueueResponse(this.f8208a));
    }

    public MutableLiveData<ResponseRowsVo<PreLookVo>> getRecordListLiveData() {
        return this.f8208a;
    }

    public MutableLiveData<ResponseStateVo> getResultLiveData() {
        return this.f8209b;
    }

    public void postComment(PreLookCommentVo preLookCommentVo) {
        this.f8210c.postComment(preLookCommentVo).enqueue(enqueueResponse(this.f8209b));
    }
}
