package com.chinavisionary.microtang.me.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.c.x.a.a;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.me.bo.RequestClickStatisticBo;
import com.chinavisionary.microtang.me.bo.RequestFundNewsParamBo;
import com.chinavisionary.microtang.me.vo.FundNewsVo;

/* JADX INFO: loaded from: classes.dex */
public class FundModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f7758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<NewResponseRowsVo<FundNewsVo>> f7759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<NewResponseStateVo> f7760c;

    public FundModel() {
        super(j.getInstance().getH5ApiBaseUrl());
        this.f7759b = new MutableLiveData<>();
        this.f7760c = new MutableLiveData<>();
        this.f7758a = (a) create(a.class);
    }

    public void doClickStatistic(RequestClickStatisticBo requestClickStatisticBo) {
        if (checkObjectParamIsValid(requestClickStatisticBo)) {
            this.f7758a.doClickStatistic(requestClickStatisticBo).enqueue(enqueueBaseVoResponse(this.f7760c));
        }
    }

    public void getFundNews(RequestFundNewsParamBo requestFundNewsParamBo) {
        this.f7758a.getFundNews(requestFundNewsParamBo).enqueue(enqueueBaseVoResponse(this.f7759b));
    }

    public MutableLiveData<NewResponseRowsVo<FundNewsVo>> getFundNewsResult() {
        return this.f7759b;
    }
}
