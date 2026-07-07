package com.chinavisionary.microtang.me.model;

import androidx.lifecycle.MutableLiveData;
import c.e.a.d.j;
import c.e.a.d.n;
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.a.d.x;
import c.e.a.d.y;
import com.alibaba.fastjson.JSON;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.model.BaseModel;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.framework.mobile.login.dto.UserSimpleDto;
import com.chinavisionary.framework.mobile.login.param.LoginParam;
import com.chinavisionary.framework.mobile.login.param.LoginSMSParam;
import com.chinavisionary.framework.mobile.login.param.SMSSendParam;
import com.chinavisionary.framework.mobile.user.param.UpdateAppUserInfoParam;
import com.chinavisionary.framework.mobile.user.param.UpdateUserPasswordParam;
import com.chinavisionary.framework.mobile.user.param.UpdateUserPhoneParam;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.auth.vo.RequestIDCardBo;
import com.chinavisionary.microtang.login.bo.AppRegisterVo;
import com.chinavisionary.microtang.me.bo.UpdateDeviceIdVo;
import com.chinavisionary.microtang.me.bo.UpdatePwdToPhoneCode;
import com.chinavisionary.microtang.me.vo.UserIDCardVo;
import h.l;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UserModel extends BaseModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f7792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f7793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f7794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public MutableLiveData<String> f7795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public MutableLiveData<String> f7796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableLiveData<String> f7797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public MutableLiveData<UserSimpleDto> f7798g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public MutableLiveData<UserIDCardVo> f7799h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public MutableLiveData<ResponseStateVo> f7800i;
    public c.e.c.x.a.d j;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7801a;

        public a(String str) {
            this.f7801a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (x.isNotNull(this.f7801a)) {
                n.getBitmapWithScale(this.f7801a, 1080, 1920);
                UserModel.this.newUploadFile(this.f7801a);
            } else {
                RequestErrDto requestErrDto = new RequestErrDto();
                requestErrDto.setUrl("");
                requestErrDto.setErrMsg("上传的图片路径为空");
                UserModel.this.mErrRequestLiveData.postValue(requestErrDto);
            }
        }
    }

    public class b implements h.d<ResponseContent<String>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f7804b;

        public b(String str, int i2) {
            this.f7803a = str;
            this.f7804b = i2;
        }

        @Override // h.d
        public void onFailure(h.b<ResponseContent<String>> bVar, Throwable th) {
            UserModel.this.handlerResponseErr(bVar, th.getMessage());
        }

        @Override // h.d
        public void onResponse(h.b<ResponseContent<String>> bVar, l<ResponseContent<String>> lVar) {
            String str = lVar.headers().get("Token");
            ResponseContent<String> responseContentBody = lVar.body();
            String data = responseContentBody != null ? responseContentBody.getData() : null;
            if (x.isNullStr(data)) {
                UserModel.this.handlerResponseErr(bVar, x.getString(R.string.tip_public_key_is_empty));
                return;
            }
            UserModel.this.saveToken(str);
            UserModel.this.savePublicKey(data);
            try {
                String strEncryptString = UserModel.this.encryptString(this.f7803a, data);
                q.d("requestParam:" + strEncryptString);
                int i2 = this.f7804b;
                if (i2 == 2) {
                    UserModel.this.r(strEncryptString);
                } else if (i2 == 4) {
                    UserModel.this.s(strEncryptString);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public class c implements h.d<ResponseContent<String>> {
        public c() {
        }

        @Override // h.d
        public void onFailure(h.b<ResponseContent<String>> bVar, Throwable th) {
            UserModel.this.handlerResponseErr(bVar, th.getMessage());
        }

        @Override // h.d
        public void onResponse(h.b<ResponseContent<String>> bVar, l<ResponseContent<String>> lVar) {
            UserModel userModel = UserModel.this;
            userModel.handlerResponse(lVar, bVar, userModel.f7797f);
        }
    }

    public class d implements h.d<ResponseContent<UserSimpleDto>> {
        public d() {
        }

        @Override // h.d
        public void onFailure(h.b<ResponseContent<UserSimpleDto>> bVar, Throwable th) {
            UserModel.this.handlerResponseErr(bVar, th.getMessage());
        }

        @Override // h.d
        public void onResponse(h.b<ResponseContent<UserSimpleDto>> bVar, l<ResponseContent<UserSimpleDto>> lVar) {
            UserModel userModel = UserModel.this;
            userModel.handlerResponse(lVar, bVar, userModel.f7798g);
        }
    }

    public UserModel() {
        super(j.getInstance().getPublicBaseUrl());
        this.f7792a = new MutableLiveData<>();
        this.f7793b = new MutableLiveData<>();
        this.f7794c = new MutableLiveData<>();
        this.f7795d = new MutableLiveData<>();
        this.f7796e = new MutableLiveData<>();
        this.f7797f = new MutableLiveData<>();
        this.f7798g = new MutableLiveData<>();
        this.f7799h = new MutableLiveData<>();
        this.f7800i = new MutableLiveData<>();
        this.j = (c.e.c.x.a.d) create(c.e.c.x.a.d.class);
    }

    public void delPushDeviceId(UpdateDeviceIdVo updateDeviceIdVo) {
        if (updateDeviceIdVo == null || !x.isNotNull(updateDeviceIdVo.getDeviceid())) {
            return;
        }
        this.j.delPushDeviceId(updateDeviceIdVo.getDeviceid(), updateDeviceIdVo.getSourceType()).enqueue(enqueueResponse(this.f7800i));
    }

    public void doLogin(LoginParam loginParam) {
        if (checkObjectParamIsValid(loginParam)) {
            q(JSON.toJSONString(loginParam), 2);
        }
    }

    public void doLogout(UpdateDeviceIdVo updateDeviceIdVo) {
        if (updateDeviceIdVo != null) {
            this.j.delPushDeviceId(updateDeviceIdVo.getDeviceid(), updateDeviceIdVo.getSourceType()).enqueue(enqueueResponse(this.f7800i));
        }
        this.j.doLogout().enqueue(enqueueResponse(this.f7796e));
    }

    public void doRegister(AppRegisterVo appRegisterVo) {
        try {
            if (checkObjectParamIsValid(appRegisterVo)) {
                String strEncrypt = encrypt(appRegisterVo);
                if (x.isNotNull(strEncrypt)) {
                    this.j.postRegister(strEncrypt).enqueue(p());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void doSmsLogin(LoginSMSParam loginSMSParam) {
        try {
            if (checkObjectParamIsValid(loginSMSParam)) {
                String strEncrypt = encrypt(loginSMSParam);
                if (checkParamIsInvalid(strEncrypt)) {
                    this.j.postSmsLogin(strEncrypt).enqueue(p());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public MutableLiveData<ResponseStateVo> getDeviceIdResultLiveData() {
        return this.f7800i;
    }

    public MutableLiveData<UserSimpleDto> getLoginResultLiveData() {
        return this.f7798g;
    }

    public MutableLiveData<String> getLogoutLiveData() {
        return this.f7796e;
    }

    public MutableLiveData<ResponseStateVo> getResultMutableLiveData() {
        return this.f7792a;
    }

    public void getSmsCode(SMSSendParam sMSSendParam) {
        if (checkObjectParamIsValid(sMSSendParam)) {
            q(JSON.toJSONString(sMSSendParam), 4);
        }
    }

    public MutableLiveData<String> getSmsCodeResult() {
        return this.f7797f;
    }

    public MutableLiveData<ResponseStateVo> getUpdatePwdResult() {
        return this.f7793b;
    }

    public MutableLiveData<String> getUpdateStateLiveData() {
        return this.f7795d;
    }

    public MutableLiveData<UserIDCardVo> getUserIdCard() {
        return this.f7799h;
    }

    public final h.d<ResponseContent<UserSimpleDto>> p() {
        return new d();
    }

    public void postPushDeviceId(UpdateDeviceIdVo updateDeviceIdVo) {
        if (checkObjectParamIsValid(updateDeviceIdVo)) {
            this.j.postPushDeviceId(updateDeviceIdVo).enqueue(enqueueResponse(this.f7800i));
        }
    }

    public final void q(String str, int i2) {
        w.getInstance().clear();
        this.j.getPublicKey().enqueue(new b(str, i2));
    }

    public final void r(String str) {
        this.j.postLogin(str).enqueue(p());
    }

    public final void s(String str) {
        this.j.getSmsCode(str).enqueue(new c());
    }

    public void sendSmsCode(SMSSendParam sMSSendParam) {
        try {
            if (checkObjectParamIsValid(sMSSendParam)) {
                String strEncrypt = encrypt(sMSSendParam);
                if (checkParamIsInvalid(strEncrypt)) {
                    s(strEncrypt);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updatePassword(UpdateUserPasswordParam updateUserPasswordParam) {
        try {
            if (checkObjectParamIsValid(updateUserPasswordParam)) {
                String strEncrypt = encrypt(updateUserPasswordParam);
                if (checkParamIsInvalid(strEncrypt)) {
                    this.j.updatePassword(strEncrypt).enqueue(enqueueResponse(this.f7795d));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updatePasswordToPhone(UpdatePwdToPhoneCode updatePwdToPhoneCode) {
        try {
            if (checkObjectParamIsValid(updatePwdToPhoneCode)) {
                String strEncrypt = encrypt(updatePwdToPhoneCode);
                if (checkParamIsInvalid(strEncrypt)) {
                    this.j.updatePasswordToPhone(strEncrypt).enqueue(enqueueResponse(this.f7793b));
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
                    this.j.updatePhone(strEncrypt).enqueue(enqueueResponse(this.f7795d));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void updateUserInfo(UpdateAppUserInfoParam updateAppUserInfoParam) {
        if (checkObjectParamIsValid(updateAppUserInfoParam)) {
            this.j.updateUserInfo(updateAppUserInfoParam).enqueue(enqueueResponse(this.f7792a));
        }
    }

    public void uploadMultiplePic(List<File> list) {
        uploadMultiplePic(list);
    }

    public void uploadUserIcon(String str) {
        y.get().addRunnable(new a(str));
    }

    public void userAuth(RequestIDCardBo requestIDCardBo) {
        this.j.userAuth(requestIDCardBo).enqueue(enqueueResponse(this.f7792a));
    }
}
