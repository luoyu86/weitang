package com.chinavisionary.microtang.me.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.a.d.y;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.net.base.dto.BaseVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.framework.mobile.login.dto.UserSimpleDto;
import com.chinavisionary.framework.mobile.login.param.SMSSendParam;
import com.chinavisionary.framework.mobile.user.param.NewUpdateAppUserInfoParam;
import com.chinavisionary.framework.mobile.user.param.NewUpdateUserPasswordParam;
import com.chinavisionary.framework.mobile.user.param.NoLoginUpdateUserPhoneParam;
import com.chinavisionary.framework.mobile.user.param.UpdateUserPhoneParam;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.login.bo.LogoutBo;
import com.chinavisionary.microtang.login.bo.NewAppRegisterVo;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import com.chinavisionary.microtang.login.bo.SecretKeyBo;
import com.chinavisionary.microtang.login.vo.NewResponseLoginResultVo;
import com.chinavisionary.microtang.main.bo.RequestSwitchProjectBo;
import com.chinavisionary.microtang.me.bo.NewUpdateDeviceIdVo;
import com.chinavisionary.microtang.me.bo.NewUpdatePwdToPhoneCode;
import com.chinavisionary.microtang.me.vo.RequestEnterpriseAuthStateBo;
import com.chinavisionary.microtang.me.vo.ResponseEnterpriseAuthStateBo;
import com.chinavisionary.microtang.me.vo.ResponseEnterpriseNotifyBo;
import h.l;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class NewUserModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicInteger f7761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.e.c.x.a.b f7762b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<SecretKeyBo> f7763c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<NewResponseStateVo> f7764d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<String> f7765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MutableLiveData<NewResponseLoginResultVo> f7766f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<UserSimpleDto> f7767g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<LogoutBo> f7768h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MutableLiveData<String> f7769i;
    public final MutableLiveData<NewResponseStateVo> j;
    public final MutableLiveData<NewResponseStateVo> k;
    public final MutableLiveData<ResponseStateVo> l;
    public final MutableLiveData<NewResponseStateVo> m;
    public final MutableLiveData<ResponseStateVo> n;
    public final MutableLiveData<NewResponseStateVo> o;
    public final MutableLiveData<String> p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final MutableLiveData<NewResponseStateVo> f7770q;
    public final MutableLiveData<ResponseStateVo> r;
    public final MutableLiveData<ResponseEnterpriseNotifyBo> s;
    public final MutableLiveData<ResponseEnterpriseAuthStateBo> t;

    public class a extends MutableLiveData<NewResponseLoginResultVo> {
        public a() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(NewResponseLoginResultVo newResponseLoginResultVo) {
            super.setValue(newResponseLoginResultVo);
            if (newResponseLoginResultVo == null) {
                NewUserModel.this.handlerResponseErr(null, "Response is empty", RequestErrDto.RESPONSE_EMPTY_CODE);
                return;
            }
            NewUserModel.this.postSwitchProject();
            UserSimpleDto userSimpleDto = new UserSimpleDto();
            userSimpleDto.setNickname(newResponseLoginResultVo.getNickname());
            userSimpleDto.setPhone(newResponseLoginResultVo.getPhone());
            userSimpleDto.setAvatar(newResponseLoginResultVo.getAvatarRes());
            NewUserModel.this.f7767g.postValue(userSimpleDto);
        }
    }

    public class b extends MutableLiveData<LogoutBo> {
        public b() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(LogoutBo logoutBo) {
            super.setValue(logoutBo);
            if (logoutBo.isSuccess()) {
                NewUserModel.this.f7769i.postValue(logoutBo.getMessage());
            } else {
                NewUserModel.this.handlerResponseErr(null, "Response is empty", RequestErrDto.RESPONSE_EMPTY_CODE);
            }
        }
    }

    public class c extends MutableLiveData<NewResponseStateVo> {
        public c() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(NewResponseStateVo newResponseStateVo) {
            super.setValue(newResponseStateVo);
            if (newResponseStateVo != null && newResponseStateVo.isSuccess()) {
                NewUserModel.this.f7765e.postValue(newResponseStateVo.getMessage());
                return;
            }
            String string = x.getString(R.string.title_sms_code_is_failed);
            if (newResponseStateVo != null && x.isNotNull(newResponseStateVo.getMessage())) {
                string = newResponseStateVo.getMessage();
            }
            NewUserModel.this.handlerResponseErr(null, string, RequestErrDto.RESPONSE_EMPTY_CODE);
        }
    }

    public class d extends MutableLiveData<NewResponseStateVo> {
        public d() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(NewResponseStateVo newResponseStateVo) {
            super.setValue(newResponseStateVo);
            NewUserModel newUserModel = NewUserModel.this;
            newUserModel.handleResponseState(newResponseStateVo, newUserModel.l);
        }
    }

    public class e extends MutableLiveData<NewResponseStateVo> {
        public e() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(NewResponseStateVo newResponseStateVo) {
            super.setValue(newResponseStateVo);
            NewUserModel newUserModel = NewUserModel.this;
            newUserModel.handleResponseState(newResponseStateVo, newUserModel.n);
        }
    }

    public class f extends MutableLiveData<NewResponseStateVo> {
        public f() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(NewResponseStateVo newResponseStateVo) {
            super.setValue(newResponseStateVo);
            if (newResponseStateVo == null || !newResponseStateVo.isSuccess()) {
                NewUserModel.this.handlerResponseErr(null, "Response is empty", RequestErrDto.RESPONSE_EMPTY_CODE);
            } else {
                NewUserModel.this.p.postValue(newResponseStateVo.getMessage());
            }
        }
    }

    public class g extends MutableLiveData<NewResponseStateVo> {
        public g() {
        }

        @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
        public void setValue(NewResponseStateVo newResponseStateVo) {
            super.setValue(newResponseStateVo);
            NewUserModel newUserModel = NewUserModel.this;
            newUserModel.handleResponseState(newResponseStateVo, newUserModel.r);
        }
    }

    public class h implements h.d<SecretKeyBo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f7779b;

        public h(String str, int i2) {
            this.f7778a = str;
            this.f7779b = i2;
        }

        @Override // h.d
        public void onFailure(h.b<SecretKeyBo> bVar, Throwable th) {
            NewUserModel.this.handlerResponseErr(bVar, th.getMessage(), RequestErrDto.RESPONSE_ERR_CODE);
        }

        @Override // h.d
        public void onResponse(h.b<SecretKeyBo> bVar, l<SecretKeyBo> lVar) {
            String token;
            SecretKeyBo secretKeyBoBody = lVar.body();
            String publicSecurityCode = null;
            if (secretKeyBoBody != null) {
                token = secretKeyBoBody.getToken();
                publicSecurityCode = secretKeyBoBody.getPublicSecurityCode();
            } else {
                token = null;
            }
            if (x.isNullStr(publicSecurityCode)) {
                if (NewUserModel.this.f7761a.incrementAndGet() < 3) {
                    NewUserModel.this.z(this.f7778a, this.f7779b);
                    return;
                } else {
                    NewUserModel.this.f7761a.set(0);
                    NewUserModel.this.handlerResponseErr(bVar, x.getString(R.string.tip_uas2_public_key_is_empty), RequestErrDto.RESPONSE_EMPTY_CODE);
                    return;
                }
            }
            if (x.isNullStr(token)) {
                NewUserModel.this.handlerResponseErr(bVar, x.getString(R.string.tip_token_key_is_empty), RequestErrDto.RESPONSE_EMPTY_CODE);
                return;
            }
            NewUserModel.this.f7761a.set(0);
            NewUserModel.this.saveToken(token);
            NewUserModel.this.postSwitchProject();
            NewUserModel.this.savePublicKey(publicSecurityCode);
            try {
                NewUserModel.this.f7763c.postValue(secretKeyBoBody);
                String strEncryptString = NewUserModel.this.encryptString(this.f7778a, publicSecurityCode);
                q.d("requestParam:" + strEncryptString);
                int i2 = this.f7779b;
                if (i2 == 2) {
                    NewUserModel.this.C(strEncryptString);
                } else if (i2 == 4) {
                    NewUserModel.this.D(strEncryptString);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public NewUserModel() {
        super(j.getInstance().getPublicH5BaseUrl());
        this.f7761a = new AtomicInteger(0);
        this.f7763c = new MutableLiveData<>();
        this.f7764d = new MutableLiveData<>();
        this.f7765e = new MutableLiveData<>();
        this.f7766f = new a();
        this.f7767g = new MutableLiveData<>();
        this.f7768h = new b();
        this.f7769i = new MutableLiveData<>();
        this.j = new c();
        this.k = new d();
        this.l = new MutableLiveData<>();
        this.m = new e();
        this.n = new MutableLiveData<>();
        this.o = new f();
        this.p = new MutableLiveData<>();
        this.f7770q = new g();
        this.r = new MutableLiveData<>();
        this.s = new MutableLiveData<>();
        this.t = new MutableLiveData<>();
        this.f7762b = (c.e.c.x.a.b) create(c.e.c.x.a.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void B(NewUpdateDeviceIdVo newUpdateDeviceIdVo) {
        if (newUpdateDeviceIdVo != null) {
            delPushDeviceId(newUpdateDeviceIdVo);
        }
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        this.f7762b.doLogout(new BaseVo()).enqueue(enqueueBaseVoResponse(this.f7768h));
    }

    public final void C(String str) {
        this.f7762b.postLogin(str).enqueue(enqueueBaseVoResponse(this.f7766f));
    }

    public final void D(String str) {
        this.f7762b.getSmsCode(str).enqueue(enqueueBaseVoResponse(this.j));
    }

    public void delPushDeviceId(NewUpdateDeviceIdVo newUpdateDeviceIdVo) {
        if (newUpdateDeviceIdVo == null || !x.isNotNull(newUpdateDeviceIdVo.getDeviceid())) {
            return;
        }
        this.f7762b.delPushDeviceId(new BaseVo()).enqueue(enqueueBaseVoResponse(this.k));
    }

    public void doLogin(NewLoginBo newLoginBo) {
        if (checkObjectParamIsValid(newLoginBo)) {
            String jSONString = JSON.toJSONString(newLoginBo);
            q.d(getClass().getSimpleName(), "doLogin loginJson = " + jSONString);
            z(jSONString, 2);
        }
    }

    public void doLogout(final NewUpdateDeviceIdVo newUpdateDeviceIdVo) {
        y.get().addRunnable(new Runnable() { // from class: c.e.c.x.f.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f2222a.B(newUpdateDeviceIdVo);
            }
        });
    }

    public void doRegister(NewAppRegisterVo newAppRegisterVo) {
        try {
            if (checkObjectParamIsValid(newAppRegisterVo)) {
                String strEncrypt = encrypt(newAppRegisterVo);
                if (x.isNotNull(strEncrypt)) {
                    this.f7762b.postRegister(strEncrypt).enqueue(enqueueBaseVoResponse(this.f7766f));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void doSmsLogin(NewLoginBo newLoginBo) {
        try {
            if (checkObjectParamIsValid(newLoginBo)) {
                q.d(getClass().getSimpleName(), "doSmsLogin smsSendParam = " + JSON.toJSONString(newLoginBo));
                String strEncrypt = encrypt(newLoginBo);
                if (checkParamIsInvalid(strEncrypt)) {
                    this.f7762b.postSmsLogin(strEncrypt).enqueue(enqueueBaseVoResponse(this.f7766f));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public MutableLiveData<ResponseStateVo> getDeviceIdResultLiveData() {
        return this.l;
    }

    public void getEnterpriseAuthState(RequestEnterpriseAuthStateBo requestEnterpriseAuthStateBo) {
        this.f7762b.getEnterpriseAuthState(getToken(), requestEnterpriseAuthStateBo).enqueue(enqueueBaseVoResponse(this.t));
    }

    public MutableLiveData<ResponseEnterpriseAuthStateBo> getEnterpriseAuthStateResult() {
        return this.t;
    }

    public void getEnterpriseNotify() {
        this.f7762b.getEnterpriseNotify(getToken(), new BaseVo()).enqueue(enqueueBaseVoResponse(this.s));
    }

    public MutableLiveData<ResponseEnterpriseNotifyBo> getEnterpriseResult() {
        return this.s;
    }

    public MutableLiveData<UserSimpleDto> getLoginResultLiveData() {
        return this.f7767g;
    }

    public MutableLiveData<String> getLogoutLiveData() {
        return this.f7769i;
    }

    public void getPublicKeyAndToken() {
        z("", 5);
    }

    public MutableLiveData<ResponseStateVo> getResultMutableLiveData() {
        return this.n;
    }

    public MutableLiveData<SecretKeyBo> getSecretKeyResult() {
        return this.f7763c;
    }

    public void getSmsCode(SMSSendParam sMSSendParam) {
        if (checkObjectParamIsValid(sMSSendParam)) {
            z(JSON.toJSONString(sMSSendParam), 4);
        }
    }

    public MutableLiveData<String> getSmsCodeResult() {
        return this.f7765e;
    }

    public MutableLiveData<ResponseStateVo> getUpdatePwdResult() {
        return this.r;
    }

    public MutableLiveData<String> getUpdateStateLiveData() {
        return this.p;
    }

    public void noLoginUpdatePhone(NoLoginUpdateUserPhoneParam noLoginUpdateUserPhoneParam) {
        try {
            if (checkObjectParamIsValid(noLoginUpdateUserPhoneParam)) {
                String strEncrypt = encrypt(noLoginUpdateUserPhoneParam);
                if (checkParamIsInvalid(strEncrypt)) {
                    this.f7762b.noLoginUpdatePhone(strEncrypt).enqueue(enqueueBaseVoResponse(this.o));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void postPushDeviceId(NewUpdateDeviceIdVo newUpdateDeviceIdVo) {
        if (checkObjectParamIsValid(newUpdateDeviceIdVo)) {
            this.f7762b.postPushDeviceId(newUpdateDeviceIdVo).enqueue(enqueueBaseVoResponse(this.k));
        }
    }

    public void postSwitchProject() {
        String string = w.getInstance().getString("selectProjectKey", null);
        if (x.isNullStr(string) && x.isNotNull(c.e.a.a.b.getInstance().getProjectKey())) {
            string = c.e.a.a.b.getInstance().getProjectKey();
        }
        if (x.isNotNull(string)) {
            RequestSwitchProjectBo requestSwitchProjectBo = new RequestSwitchProjectBo();
            requestSwitchProjectBo.setProjectId(string);
            this.f7762b.switchProject(requestSwitchProjectBo).enqueue(enqueueBaseVoResponse(this.f7764d));
        }
    }

    public void sendSmsCode(SMSSendParam sMSSendParam) {
        try {
            if (checkObjectParamIsValid(sMSSendParam)) {
                String strEncrypt = encrypt(sMSSendParam);
                if (checkParamIsInvalid(strEncrypt)) {
                    D(strEncrypt);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updatePassword(NewUpdateUserPasswordParam newUpdateUserPasswordParam) {
        try {
            if (checkObjectParamIsValid(newUpdateUserPasswordParam)) {
                String strEncrypt = encrypt(newUpdateUserPasswordParam);
                if (checkParamIsInvalid(strEncrypt)) {
                    this.f7762b.updatePassword(strEncrypt).enqueue(enqueueBaseVoResponse(this.o));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updatePasswordToPhone(NewUpdatePwdToPhoneCode newUpdatePwdToPhoneCode) {
        try {
            if (checkObjectParamIsValid(newUpdatePwdToPhoneCode)) {
                String strEncrypt = encrypt(newUpdatePwdToPhoneCode);
                if (checkParamIsInvalid(strEncrypt)) {
                    this.f7762b.updatePasswordToPhone(strEncrypt).enqueue(enqueueBaseVoResponse(this.f7770q));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updatePhone(UpdateUserPhoneParam updateUserPhoneParam) {
        try {
            if (checkObjectParamIsValid(updateUserPhoneParam)) {
                String strEncrypt = encrypt(updateUserPhoneParam);
                if (checkParamIsInvalid(strEncrypt)) {
                    this.f7762b.updatePhone(strEncrypt).enqueue(enqueueBaseVoResponse(this.o));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updateUserInfo(NewUpdateAppUserInfoParam newUpdateAppUserInfoParam) {
        if (checkObjectParamIsValid(newUpdateAppUserInfoParam)) {
            this.f7762b.updateUserInfo(newUpdateAppUserInfoParam).enqueue(enqueueBaseVoResponse(this.m));
        }
    }

    public final void z(String str, int i2) {
        w.getInstance().clear();
        this.f7762b.getUasPublicKey("Q611KlggYabS2RQMGe0gLrVdjyw7Onhd0Wb6//DKAbJF2I/D9Kc4pwOT6pCFRLJbw533j7OroKiDX5qTE03KFqFs+b2pEOmScGBDZXWk6EitBgS1oneAdvLqmkEY98sX+xH6e5T9Sr7fnTatysq53kTEWX/tCsvhJGmmskk3bt6xZ4sbB0FLknnRbyZgQA6bZf5upDnvqiqVSxPGNMGKHNRYuQKP2cqp0NgO9EOiLd0=cvdata_separatorEEuGXxFbBti/U5Cnw4EViM2HT6cp6jqTmGdW8n4Kwepv5EL23XjV4tcth2gE0+E33vnA6iUuk0MIPW/g24Cwvg==", new BaseVo()).enqueue(new h(str, i2));
    }
}
