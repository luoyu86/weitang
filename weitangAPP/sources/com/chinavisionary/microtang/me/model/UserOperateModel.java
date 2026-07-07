package com.chinavisionary.microtang.me.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.a.d.q;
import c.e.a.d.v;
import c.e.a.d.x;
import c.e.c.x.a.e;
import com.chinavisionary.core.app.config.bo.AppConfigExtVo;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.ResponseRowsVo;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.microtang.comment.bo.ResponseCommentBadgeBo;
import com.chinavisionary.microtang.login.bo.InterestItemVo;
import com.chinavisionary.microtang.login.bo.InterestSelectTagBo;
import com.chinavisionary.microtang.main.bo.CancelContractParamBo;
import com.chinavisionary.microtang.main.vo.ResponseWaterElectricVo;
import com.chinavisionary.microtang.me.bo.CancelAccountBo;
import com.chinavisionary.microtang.me.bo.CreateRollOutBo;
import com.chinavisionary.microtang.me.bo.RequestServerConfigBo;
import com.chinavisionary.microtang.me.vo.FundNewsVo;
import com.chinavisionary.microtang.me.vo.ResponseRollOutVo;
import com.chinavisionary.microtang.me.vo.ResponseWalletVo;
import com.chinavisionary.microtang.me.vo.UpdateUserIdBo;
import com.chinavisionary.microtang.me.vo.WalletRecordDetailsVo;
import com.chinavisionary.microtang.me.vo.WalletRecordVo;
import com.chinavisionary.microtang.me.vo.WorkAddressVo;
import com.chinavisionary.microtang.vo.RequestUserInfoVo;
import com.chinavisionary.twlib.open.bo.AlertMessageVo;
import com.tom_roush.fontbox.ttf.OS2WindowsMetricsTable;

/* JADX INFO: loaded from: classes.dex */
public class UserOperateModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f7808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<AppConfigExtVo> f7809b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<UserInfoVo> f7810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f7811d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f7812e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableLiveData<ResponseWaterElectricVo> f7813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MutableLiveData<ResponseWalletVo> f7814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MutableLiveData<ResponseRollOutVo> f7815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MutableLiveData<String> f7816i;
    public MutableLiveData<NewResponseRowsVo<WalletRecordVo>> j;
    public MutableLiveData<WalletRecordDetailsVo> k;
    public MutableLiveData<NewResponseRowsVo<AlertMessageVo>> l;
    public MutableLiveData<NewResponseRowsVo<AlertMessageVo>> m;
    public MutableLiveData<NewResponseRowsVo<AlertMessageVo>> n;
    public MutableLiveData<NewResponseRowsVo<FundNewsVo>> o;
    public MutableLiveData<NewResponseRowsVo<FundNewsVo>> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public MutableLiveData<NewResponseRowsVo<FundNewsVo>> f7817q;
    public MutableLiveData<ResponseRowsVo<InterestItemVo>> r;
    public MutableLiveData<ResponseRowsVo<WorkAddressVo>> s;
    public MutableLiveData<ResponseStateVo> t;
    public MutableLiveData<ResponseStateVo> u;
    public MutableLiveData<NewResponseStateVo> v;
    public MutableLiveData<ResponseCommentBadgeBo> w;

    public UserOperateModel() {
        super(j.getInstance().getH5ApiBaseUrl());
        this.f7809b = new MutableLiveData<>();
        this.f7810c = new MutableLiveData<>();
        this.f7811d = new MutableLiveData<>();
        this.f7812e = new MutableLiveData<>();
        this.f7813f = new MutableLiveData<>();
        this.f7814g = new MutableLiveData<>();
        this.f7815h = new MutableLiveData<>();
        this.f7816i = new MutableLiveData<>();
        this.j = new MutableLiveData<>();
        this.k = new MutableLiveData<>();
        this.l = new MutableLiveData<>();
        this.m = new MutableLiveData<>();
        this.n = new MutableLiveData<>();
        this.o = new MutableLiveData<>();
        this.p = new MutableLiveData<>();
        this.f7817q = new MutableLiveData<>();
        this.r = new MutableLiveData<>();
        this.s = new MutableLiveData<>();
        this.t = new MutableLiveData<>();
        this.u = new MutableLiveData<>();
        this.v = new MutableLiveData<>();
        this.w = new MutableLiveData<>();
        this.f7808a = (e) create(e.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void b() {
        try {
            Thread.sleep(2000L);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        getCancelContractAlertMessageList();
    }

    public void cancelAccount(CancelAccountBo cancelAccountBo) {
        if (checkObjectParamIsValid(cancelAccountBo)) {
            this.f7808a.doCancelAccount(cancelAccountBo).enqueue(enqueueResponse(this.t));
        }
    }

    public MutableLiveData<NewResponseRowsVo<FundNewsVo>> getAboutUsConfigResult() {
        return this.p;
    }

    public void getAlertMessage(Integer num) {
        RequestUserInfoVo requestUserInfoVo = new RequestUserInfoVo();
        if (v.getInstance().isRepeatedlyAction("getAlertMessage", 5000)) {
            q.d(getClass().getSimpleName(), "getAlertMessage");
        } else {
            q.d(getClass().getSimpleName(), "getAlertMessage request");
            this.f7808a.getAlertMessageList(getToken(), requestUserInfoVo).enqueue(enqueueBaseVoResponse(this.l));
        }
        new Thread(new Runnable() { // from class: c.e.c.x.f.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f2224a.b();
            }
        }).start();
    }

    public MutableLiveData<NewResponseRowsVo<AlertMessageVo>> getAlertMessageList() {
        return this.l;
    }

    public void getAppConfig() {
        this.f7808a.getAppConfig(getToken()).enqueue(enqueueResponse(this.f7809b));
    }

    public MutableLiveData<AppConfigExtVo> getAppConfigLiveData() {
        return this.f7809b;
    }

    public void getAppPhoneConfig(String str, String str2) {
        if (x.isNullStr(str)) {
            str = "";
        }
        if (x.isNullStr(str2)) {
            str2 = "";
        }
        this.f7808a.getAppPhoneConfig(getToken(), x.isNotNull(str2) ? "" : str, str2).enqueue(enqueueResponse(this.f7811d));
    }

    public MutableLiveData<ResponseStateVo> getAppPhoneResult() {
        return this.f7811d;
    }

    public void getAppServerConfig() {
        this.f7808a.getAppServerConfig(getToken(), new RequestServerConfigBo()).enqueue(enqueueBaseVoResponse(this.o));
        this.f7808a.getMeVtConfig(getToken(), new RequestServerConfigBo()).enqueue(enqueueBaseVoResponse(this.f7817q));
        this.f7808a.getAboutUsConfig(getToken(), new RequestServerConfigBo()).enqueue(enqueueBaseVoResponse(this.p));
    }

    public void getApplyRentBadge() {
        this.f7808a.getApplyRentBadge().enqueue(enqueueBaseVoResponse(this.w));
    }

    public MutableLiveData<ResponseCommentBadgeBo> getApplyRentBadgeResult() {
        return this.w;
    }

    public MutableLiveData<NewResponseRowsVo<AlertMessageVo>> getBillAlertMessageList() {
        return this.n;
    }

    public MutableLiveData<ResponseStateVo> getCancelAccountLiveData() {
        return this.t;
    }

    public void getCancelContractAlertMessageList() {
        new RequestUserInfoVo();
        if (v.getInstance().isRepeatedlyAction("getCancelContractAlertMessageList", OS2WindowsMetricsTable.WEIGHT_CLASS_SEMI_BOLD)) {
            q.d(getClass().getSimpleName(), "getCancelContractAlertMessageList");
        } else {
            q.d(getClass().getSimpleName(), "getCancelContractAlertMessageList request");
            this.f7808a.getCancelContractAlertMessageList(getToken()).enqueue(enqueueBaseVoResponse(this.m));
        }
    }

    public MutableLiveData<NewResponseRowsVo<AlertMessageVo>> getCancelContractResult() {
        return this.m;
    }

    public MutableLiveData<ResponseRowsVo<InterestItemVo>> getInterestItemList() {
        return this.r;
    }

    public MutableLiveData<NewResponseRowsVo<FundNewsVo>> getMeVtConfigResult() {
        return this.f7817q;
    }

    public void getOnlyBillAlertMessage(Integer num) {
        RequestUserInfoVo requestUserInfoVo = new RequestUserInfoVo();
        if (v.getInstance().isRepeatedlyAction("getOnlyBillAlertMessage", 5000)) {
            q.d(getClass().getSimpleName(), "getOnlyBillAlertMessage");
        } else {
            q.d(getClass().getSimpleName(), "getOnlyBillAlertMessage request");
            this.f7808a.getAlertMessageList(getToken(), requestUserInfoVo).enqueue(enqueueBaseVoResponse(this.n));
        }
    }

    public MutableLiveData<ResponseStateVo> getResultMutableLiveData() {
        return this.f7812e;
    }

    public MutableLiveData<ResponseRollOutVo> getRollOutResult() {
        return this.f7815h;
    }

    public void getRollOutState(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7808a.getRollOutState(str).enqueue(enqueueResponse(this.f7816i));
        }
    }

    public MutableLiveData<String> getRollOutStateResult() {
        return this.f7816i;
    }

    public void getRoomBalanceFee(String str) {
        if (x.isNotNull(str)) {
            this.f7808a.getRoomBalanceFee(str).enqueue(enqueueResponse(this.f7813f));
        } else {
            this.f7808a.getRoomBalanceFee().enqueue(enqueueResponse(this.f7813f));
        }
    }

    public MutableLiveData<NewResponseRowsVo<FundNewsVo>> getServerConfigResult() {
        return this.o;
    }

    public MutableLiveData<NewResponseStateVo> getSubmitCancelResult() {
        return this.v;
    }

    public MutableLiveData<ResponseStateVo> getSubmitInterestResult() {
        return this.u;
    }

    public void getUserInfo() {
        this.f7808a.getUserInfo().enqueue(enqueueResponse(this.f7810c));
    }

    public MutableLiveData<UserInfoVo> getUserInfoVoResult() {
        return this.f7810c;
    }

    public void getUserInterestTags() {
        this.f7808a.getUserInterestTags().enqueue(enqueueResponse(this.r));
    }

    public void getWalletBalance() {
        this.f7808a.getWalletBalance().enqueue(enqueueResponse(this.f7814g));
    }

    public MutableLiveData<WalletRecordDetailsVo> getWalletRecordDetails() {
        return this.k;
    }

    public MutableLiveData<NewResponseRowsVo<WalletRecordVo>> getWalletRecordList() {
        return this.j;
    }

    public MutableLiveData<ResponseWalletVo> getWalletResult() {
        return this.f7814g;
    }

    public MutableLiveData<ResponseWaterElectricVo> getWaterElectricBalance() {
        return this.f7813f;
    }

    public MutableLiveData<ResponseRowsVo<WorkAddressVo>> getWorkAddressItemList() {
        return this.s;
    }

    public void getWorkAddressUrl() {
        this.f7808a.getWorkAddressUrl().enqueue(enqueueResponse(this.s));
    }

    public void postCancelContractAlertMessageList(CancelContractParamBo cancelContractParamBo) {
        if (checkObjectParamIsValid(cancelContractParamBo)) {
            this.f7808a.postCancelContractAlertMessageList(getToken(), cancelContractParamBo).enqueue(enqueueBaseVoResponse(this.v));
        }
    }

    public void postUserInterestTags(InterestSelectTagBo interestSelectTagBo) {
        this.f7808a.postUserInterestTags(interestSelectTagBo).enqueue(enqueueResponse(this.u));
    }

    public void rollOutBalance(CreateRollOutBo createRollOutBo) {
        if (checkObjectParamIsValid(createRollOutBo)) {
            this.f7808a.postRollOutWalletBalance(createRollOutBo).enqueue(enqueueResponse(this.f7815h));
        }
    }

    public void updateUserIdInfo(UpdateUserIdBo updateUserIdBo) {
        if (checkObjectParamIsValid(updateUserIdBo)) {
            this.f7808a.updateUserIdInfo(updateUserIdBo).enqueue(enqueueResponse(this.f7812e));
        }
    }

    public void getWalletRecordList(PageBo pageBo) {
        if (checkObjectParamIsValid(pageBo)) {
            this.f7808a.getWalletRecordList(getQueryMap(pageBo)).enqueue(enqueueBaseVoResponse(this.j));
        }
    }

    public void getWalletRecordList(String str) {
        if (checkParamIsInvalid(str)) {
            this.f7808a.getWalletRecordDetails(str).enqueue(enqueueBaseVoResponse(this.k));
        }
    }
}
