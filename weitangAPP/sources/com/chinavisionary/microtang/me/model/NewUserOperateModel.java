package com.chinavisionary.microtang.me.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.a.d.w;
import c.e.c.x.a.c;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.config.bo.NewUserInfoVo;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.framework.mobile.login.param.SMSSendParam;
import com.chinavisionary.microtang.login.bo.InterestItemVo;
import com.chinavisionary.microtang.login.bo.InterestSelectTagBo;
import com.chinavisionary.microtang.me.bo.CancelAccountBo;
import com.chinavisionary.microtang.me.bo.CancelAccountReasonBo;
import com.chinavisionary.microtang.me.bo.CreateRollOutBo;
import com.chinavisionary.microtang.me.bo.NewCancelAccountBo;
import com.chinavisionary.microtang.me.bo.ReportClickMessageBo;
import com.chinavisionary.microtang.me.bo.RequestClickStatisticBo;
import com.chinavisionary.microtang.me.bo.ResponseManagerQrCodeBo;
import com.chinavisionary.microtang.me.bo.RollOutResultBo;
import com.chinavisionary.microtang.me.vo.NewResponseRollOutVo;
import com.chinavisionary.microtang.me.vo.ResponseWalletVo;
import com.chinavisionary.microtang.vo.RequestUserInfoVo;

/* JADX INFO: loaded from: classes.dex */
public class NewUserOperateModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f7781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<UserInfoVo> f7782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<ResponseManagerQrCodeBo> f7783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<NewUserInfoVo> f7784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<NewResponseStateVo> f7785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<CancelAccountReasonBo> f7786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<ResponseStateVo> f7787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<ResponseWalletVo> f7788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<NewResponseStateVo> f7789i;
    public final MutableLiveData<NewResponseStateVo> j;
    public MutableLiveData<NewResponseStateVo> k;
    public MutableLiveData<NewResponseRowsVo<InterestItemVo>> l;
    public MutableLiveData<NewResponseRollOutVo> m;
    public MutableLiveData<NewResponseStateVo> n;
    public MutableLiveData<NewResponseStateVo> o;

    public class a extends MutableLiveData<NewUserInfoVo> {
        public a() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(NewUserInfoVo newUserInfoVo) {
            super.setValue(newUserInfoVo);
            UserInfoVo userInfoVo = new UserInfoVo();
            userInfoVo.setCheckIn(newUserInfoVo.isCheckIn());
            userInfoVo.setNickname(newUserInfoVo.getNickname());
            userInfoVo.setPersonName(newUserInfoVo.getPersonName());
            userInfoVo.setShowInterest(newUserInfoVo.isShowInterest());
            userInfoVo.setValidate(newUserInfoVo.isValidate());
            userInfoVo.setValidateFaDaDa(newUserInfoVo.isValidateFaDaDa());
            userInfoVo.setAvatar(newUserInfoVo.getAvatar());
            userInfoVo.setUserKey(newUserInfoVo.getUserKey());
            userInfoVo.setUserType(newUserInfoVo.getUserType());
            userInfoVo.setOperatingModel(newUserInfoVo.getOperatingModel());
            try {
                w.getInstance().putString("userDetailsInfoKey", JSON.toJSONString(userInfoVo));
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            NewUserOperateModel.this.f7782b.postValue(userInfoVo);
        }
    }

    public class b extends MutableLiveData<NewResponseStateVo> {
        public b() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(NewResponseStateVo newResponseStateVo) {
            super.setValue(newResponseStateVo);
            NewUserOperateModel newUserOperateModel = NewUserOperateModel.this;
            newUserOperateModel.handleResponseState(newResponseStateVo, newUserOperateModel.f7787g);
        }
    }

    public NewUserOperateModel() {
        super(j.getInstance().getPublicH5BaseUrl());
        this.f7782b = new MutableLiveData<>();
        this.f7783c = new MutableLiveData<>();
        this.f7784d = new a();
        this.f7785e = new b();
        this.f7786f = new MutableLiveData<>();
        this.f7787g = new MutableLiveData<>();
        this.f7788h = new MutableLiveData<>();
        this.f7789i = new MutableLiveData<>();
        this.j = new MutableLiveData<>();
        this.k = new MutableLiveData<>();
        this.l = new MutableLiveData<>();
        this.m = new MutableLiveData<>();
        this.n = new MutableLiveData<>();
        this.o = new MutableLiveData<>();
        this.f7781a = (c) create(c.class);
    }

    public void cancelAccount(CancelAccountBo cancelAccountBo) {
        if (checkObjectParamIsValid(cancelAccountBo)) {
            this.f7781a.doCancelAccount(cancelAccountBo).enqueue(enqueueBaseVoResponse(this.f7785e));
        }
    }

    public void cancelAccountNew(NewCancelAccountBo newCancelAccountBo) {
        if (checkObjectParamIsValid(newCancelAccountBo)) {
            this.f7781a.doCancelAccountNew(newCancelAccountBo).enqueue(enqueueBaseVoResponse(this.f7785e));
        }
    }

    public void doClickStatistic(RequestClickStatisticBo requestClickStatisticBo) {
        if (checkObjectParamIsValid(requestClickStatisticBo)) {
            this.f7781a.doClickStatistic(requestClickStatisticBo).enqueue(enqueueBaseVoResponse(this.j));
        }
    }

    public MutableLiveData<ResponseStateVo> getCancelAccountLiveData() {
        return this.f7787g;
    }

    public void getCancelAccountReason() {
        this.f7781a.getCancelAccountReason(new CancelAccountBo()).enqueue(enqueueBaseVoResponse(this.f7786f));
    }

    public MutableLiveData<CancelAccountReasonBo> getCancelAccountReasonData() {
        return this.f7786f;
    }

    public MutableLiveData<NewResponseRowsVo<InterestItemVo>> getInterestItemList() {
        return this.l;
    }

    public void getManagerQrCode() {
        this.f7781a.getManagerQrCode(getToken()).enqueue(enqueueBaseVoResponse(this.f7783c));
    }

    public MutableLiveData<ResponseManagerQrCodeBo> getManagerQrCodeResult() {
        return this.f7783c;
    }

    public MutableLiveData<NewResponseRollOutVo> getRollOutResult() {
        return this.m;
    }

    public void getRollOutState(String str) {
        if (checkParamIsInvalid(str)) {
            RollOutResultBo rollOutResultBo = new RollOutResultBo();
            rollOutResultBo.setWithdrawId(str);
            this.f7781a.getRollOutState(rollOutResultBo).enqueue(enqueueBaseVoResponse(this.n));
        }
    }

    public MutableLiveData<NewResponseStateVo> getRollOutStateResult() {
        return this.n;
    }

    public MutableLiveData<NewResponseStateVo> getSmsCodeResult() {
        return this.k;
    }

    public MutableLiveData<NewResponseStateVo> getSubmitInterestResult() {
        return this.f7789i;
    }

    public void getUserInfo() {
        this.f7781a.getUserInfo(getToken(), new RequestUserInfoVo()).enqueue(enqueueBaseVoResponse(this.f7784d));
        getManagerQrCode();
    }

    public MutableLiveData<UserInfoVo> getUserInfoVoResult() {
        return this.f7782b;
    }

    public void getUserInterestTags() {
        this.f7781a.getUserInterestTags(new BaseVo()).enqueue(enqueueBaseVoResponse(this.l));
    }

    public void getWalletBalance() {
        this.f7781a.getWalletBalance(getToken(), new BaseVo()).enqueue(enqueueBaseVoResponse(this.f7788h));
    }

    public MutableLiveData<ResponseWalletVo> getWalletResult() {
        return this.f7788h;
    }

    public void onlySendSmsCode(SMSSendParam sMSSendParam) {
        try {
            if (checkObjectParamIsValid(sMSSendParam)) {
                String strEncrypt = encrypt(sMSSendParam);
                if (checkParamIsInvalid(strEncrypt)) {
                    this.f7781a.getSmsCode(strEncrypt).enqueue(enqueueBaseVoResponse(this.k));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void postClickMessageReport(ReportClickMessageBo reportClickMessageBo) {
        if (checkObjectParamIsValid(reportClickMessageBo)) {
            this.f7781a.postClickMessageReport(reportClickMessageBo).enqueue(enqueueBaseVoResponse(this.o));
        }
    }

    public void postUserInterestTags(InterestSelectTagBo interestSelectTagBo) {
        this.f7781a.postUserInterestTags(interestSelectTagBo).enqueue(enqueueBaseVoResponse(this.f7789i));
    }

    public void rollOutBalance(CreateRollOutBo createRollOutBo) {
        if (checkObjectParamIsValid(createRollOutBo)) {
            this.f7781a.postRollOutWalletBalance(getToken(), createRollOutBo).enqueue(enqueueBaseVoResponse(this.m));
        }
    }

    public void sendSmsCode(SMSSendParam sMSSendParam) {
        try {
            if (checkObjectParamIsValid(sMSSendParam)) {
                this.f7781a.postOutWalletSendCode(sMSSendParam).enqueue(enqueueBaseVoResponse(this.k));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
