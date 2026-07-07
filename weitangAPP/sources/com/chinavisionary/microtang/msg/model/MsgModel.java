package com.chinavisionary.microtang.msg.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.c.z.a.a;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.msg.vo.BadgeCountVo;
import com.chinavisionary.microtang.msg.vo.MsgVo;
import com.chinavisionary.microtang.msg.vo.RequestReadBadgeBo;
import com.chinavisionary.microtang.repair.vo.ResponseVo;

/* JADX INFO: loaded from: classes.dex */
public class MsgModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<ResponseVo<MsgVo>> f7958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<BadgeCountVo> f7959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f7960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f7961d;

    public MsgModel() {
        super(j.getInstance().getH5ApiBaseUrl());
        this.f7958a = new MutableLiveData<>();
        this.f7959b = new MutableLiveData<>();
        this.f7960c = (a) create(a.class);
    }

    public void getMsgCount() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f7961d > 2000) {
            this.f7961d = jCurrentTimeMillis;
            this.f7960c.getMsgCountList(getToken(), new BaseVo()).enqueue(enqueueBaseVoResponse(this.f7959b));
        }
    }

    public MutableLiveData<BadgeCountVo> getMsgCountLiveData() {
        return this.f7959b;
    }

    public MutableLiveData<ResponseVo<MsgVo>> getMsgList() {
        return this.f7958a;
    }

    public void postReadBadge(RequestReadBadgeBo requestReadBadgeBo) {
        if (checkObjectParamIsValid(requestReadBadgeBo)) {
            this.f7960c.postReadMsgList(requestReadBadgeBo).enqueue(enqueueResponse(this.f7959b));
        }
    }

    public void getMsgList(PageBo pageBo) {
        if (checkObjectParamIsValid(pageBo)) {
            this.f7960c.getMsgList(getQueryMap(pageBo)).enqueue(enqueueResponse(this.f7958a));
        }
    }
}
