package com.chinavisionary.core.app.net.base.model;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import c.e.a.a.b;
import c.e.a.a.g.a;
import c.e.a.d.a0;
import c.e.a.d.b0;
import c.e.a.d.j;
import c.e.a.d.n;
import c.e.a.d.o;
import c.e.a.d.q;
import c.e.a.d.v;
import c.e.a.d.w;
import c.e.a.d.x;
import com.alibaba.fastjson.JSON;
import com.alipay.sdk.m.p.e;
import com.chinavisionary.core.R;
import com.chinavisionary.core.app.config.bo.UserInfoVo;
import com.chinavisionary.core.app.event.EventUpdateToken;
import com.chinavisionary.core.app.net.base.IHttpConstant;
import com.chinavisionary.core.app.net.base.dto.NewBaseVo;
import com.chinavisionary.core.app.net.base.dto.NewResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.PageBo;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;
import com.chinavisionary.core.app.net.base.dto.ResponseStateVo;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgListVo;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadImgVo;
import com.chinavisionary.core.app.net.base.dto.ResponseUploadVo;
import com.chinavisionary.core.app.net.base.dto.TokenInvalidBo;
import com.chinavisionary.core.app.net.base.dto.UploadDto;
import com.chinavisionary.core.app.net.base.dto.UploadResponseDto;
import com.chinavisionary.framework.mobile.common.vo.ResponseContent;
import com.chinavisionary.framework.mobile.login.dto.UserSimpleDto;
import com.chinavisionary.microtang.login.bo.NewLoginBo;
import com.taobao.accs.utl.BaseMonitor;
import g.b.a.c;
import h.d;
import h.l;
import h.m;
import h.p.b.k;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class BaseModel extends ViewModel {
    private static final String CURRENT_PAGE_KEY = "currentPage";
    private static final String DATA_KEY = "dataKey";
    private static final String KEY = "key";
    private static final int LOGIN_INVALID_CODE = 666;
    private static final int LOGIN_KICK_OUT_CODE = 661;
    private static final int LOGIN_OTHER_LOGIN_CODE = 662;
    private static final int LOGIN_REPEAT_REQUEST_CODE = 663;
    private static final String MODULE_KEY = "moduleKey";
    private static final int NO_AUTH_CODE = 403;
    private static final int NO_PAGE_CODE = 404;
    private static final String PAGESIZE_KEY = "pageSize";
    private static final String PAGE_KEY = "ppage";
    private static final String PAGE_NUMBER_KEY = "pnumber";
    public static final String PIC_SCALE_APPEND_NAME = "wt6_6";
    public static final String USER_NOT_EXITS = "用户不存在";
    private String mBaseUrl;
    private m mRetrofit;
    public MutableLiveData<RequestErrDto> mErrRequestLiveData = new MutableLiveData<>();
    private final MutableLiveData<UploadResponseDto> mUploadResponseDtoMutableLive = new MutableLiveData<>();

    public BaseModel(String str) {
        initRetrofit(str);
    }

    private String getCode(int i2) {
        return x.getString(R.string.placeholder_tip_auth_invalid, AgooConstants.ACK_REMOVE_PACKAGE + i2);
    }

    private String getFragmentPath(List<String> list) {
        if (!o.isNotEmpty(list)) {
            return null;
        }
        StringBuilder sb = new StringBuilder(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("/");
        }
        return sb.toString();
    }

    private boolean getNetworkStatus() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b.getInstance().getContext().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private UserInfoVo getUserDetailsInfo() {
        String string = w.getInstance().getString("userDetailsInfoKey", null);
        if (x.isNotNull(string)) {
            return (UserInfoVo) JSON.parseObject(string, UserInfoVo.class);
        }
        return null;
    }

    private void handleLoginErr(h.b bVar, int i2, String str) {
        handleResponseCodeErr(bVar, getFragmentPath(bVar.request().url().pathSegments()), i2, str);
    }

    private void handleRequestServerErr(String str, String str2, String str3) {
        try {
            b0.getInstance().handleRequestServerErr(str, str2, str3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleResponseCodeErr(h.b bVar, String str, int i2, String str2) {
        if (i2 == 403) {
            if (!x.isNotNull(str2)) {
                str2 = x.getString(R.string.tip_no_auth);
            }
            handlerResponseErr(bVar, str2);
            return;
        }
        if (i2 == 404) {
            handlerResponseErr(bVar, x.getString(R.string.core_lib_tip_no_page));
            return;
        }
        if (i2 == LOGIN_KICK_OUT_CODE) {
            if (!x.isNotNull(str2)) {
                str2 = x.getString(R.string.tip_force_offline);
            }
            handlerResponseErr(bVar, str2);
            openLogin(LOGIN_KICK_OUT_CODE, str);
            return;
        }
        if (i2 == LOGIN_OTHER_LOGIN_CODE) {
            if (!x.isNotNull(str2)) {
                str2 = getCode(LOGIN_OTHER_LOGIN_CODE);
            }
            handlerResponseErr(bVar, str2);
            openLogin(LOGIN_OTHER_LOGIN_CODE, str);
            return;
        }
        if (i2 != 666) {
            handlerResponseErr(bVar, str2, i2);
            return;
        }
        if (!isLoginState()) {
            sendUpdateToken();
            return;
        }
        if (!x.isNotNull(str2)) {
            str2 = getCode(666);
        }
        handlerResponseErr(bVar, str2);
        openLogin(666, str);
    }

    private boolean isLoginState() {
        return getUserDetailsInfo() != null;
    }

    private boolean isOpenLogin() {
        Activity activityCurrentActivity = a.getAppManager().currentActivity();
        if (activityCurrentActivity != null) {
            return true ^ activityCurrentActivity.getClass().getSimpleName().equals("LoginActivity");
        }
        return true;
    }

    private synchronized void openLogin(int i2, String str) {
        boolean zIsRepeatedlyAction = v.getInstance().isRepeatedlyAction("/login/login");
        q.d(getClass().getSimpleName(), "openLogin path:" + str);
        if (!zIsRepeatedlyAction && isOpenLogin()) {
            String token = b.getInstance().getToken();
            TokenInvalidBo tokenInvalidBo = new TokenInvalidBo();
            tokenInvalidBo.setCreateTime(System.currentTimeMillis());
            tokenInvalidBo.setToken(token);
            tokenInvalidBo.setInterfaceUrl(str);
            tokenInvalidBo.setErrMsg(getCode(i2));
            tokenInvalidBo.setErrCode(i2);
            a0.showToast(b.getInstance().getContext(), getCode(666));
            w.getInstance().clear();
            c.getDefault().post(new UserSimpleDto());
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.chinavisionary.microtang", "com.chinavisionary.microtang.login.LoginActivity"));
            intent.putExtra("ErrCode", JSON.toJSONString(tokenInvalidBo));
            intent.setFlags(268435456);
            b.getInstance().getContext().startActivity(intent);
        }
    }

    private List<File> scaleImage(List<File> list) {
        ArrayList arrayList = new ArrayList();
        for (File file : list) {
            if (file.exists()) {
                arrayList.add(new File(n.getBitmapWithScale(file.getAbsolutePath(), 1080, 1920)));
            }
        }
        return arrayList;
    }

    private void sendUpdateToken() {
        c.getDefault().post(new EventUpdateToken());
    }

    private void uploadFile(UploadDto uploadDto) {
        c.e.a.a.h.c.getInstance().uploadFile(uploadDto);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<ResponseUploadImgVo> uploadSort(List<ResponseUploadImgVo> list, List<File> list2) {
        ArrayList arrayList = new ArrayList();
        Iterator<File> it = list2.iterator();
        while (it.hasNext()) {
            String name = it.next().getName();
            q.d(getClass().getSimpleName(), "fileName :" + name);
            for (ResponseUploadImgVo responseUploadImgVo : list) {
                if (responseUploadImgVo != null) {
                    String originalName = responseUploadImgVo.getOriginalName();
                    if (name.equals(responseUploadImgVo.getOriginalName()) || originalName.contains(name)) {
                        q.d(getClass().getSimpleName(), "equals :" + responseUploadImgVo.getOriginalName());
                        arrayList.add(responseUploadImgVo);
                    }
                }
            }
        }
        return arrayList;
    }

    public final boolean checkObjectParamIsValid(Object obj) {
        boolean z = obj != null;
        if (!z) {
            handlerResponseErr(null, x.getString(R.string.core_lib_tip_request_param_is_empty));
        }
        return z;
    }

    public final boolean checkParamIsInvalid(String str) {
        boolean zIsNotNull = x.isNotNull(str);
        if (!zIsNotNull) {
            handlerResponseErr(null, x.getString(R.string.core_lib_tip_request_param_is_empty));
        }
        return zIsNotNull;
    }

    public final <T> T create(Class<T> cls) {
        return (T) this.mRetrofit.create(cls);
    }

    public final String encrypt(Object obj) throws Exception {
        return c.e.a.d.d0.c.encryptByPublicKey(JSON.toJSONString(obj), w.getInstance().getString(e.o, ""));
    }

    public final String encryptString(String str, String str2) throws Exception {
        return c.e.a.d.d0.c.encryptByPublicKey(str, str2);
    }

    public final <V extends NewBaseVo> d<V> enqueueBaseVoResponse(final MutableLiveData<V> mutableLiveData) {
        return (d<V>) new d<V>() { // from class: com.chinavisionary.core.app.net.base.model.BaseModel.2
            @Override // h.d
            public void onFailure(h.b<V> bVar, Throwable th) {
                BaseModel.this.handlerResponseErr(bVar, th.getMessage());
            }

            @Override // h.d
            public void onResponse(h.b<V> bVar, l<V> lVar) {
                BaseModel.this.handlerBaseVoResponse(lVar, bVar, mutableLiveData);
            }
        };
    }

    public final <T> d<ResponseContent<T>> enqueueResponse(final MutableLiveData<T> mutableLiveData) {
        return new d<ResponseContent<T>>() { // from class: com.chinavisionary.core.app.net.base.model.BaseModel.1
            @Override // h.d
            public void onFailure(h.b<ResponseContent<T>> bVar, Throwable th) {
                BaseModel.this.handlerResponseErr(bVar, th.getMessage());
            }

            @Override // h.d
            public void onResponse(h.b<ResponseContent<T>> bVar, l<ResponseContent<T>> lVar) {
                BaseModel.this.handlerResponse(lVar, bVar, mutableLiveData);
            }
        };
    }

    public final MutableLiveData<RequestErrDto> getErrRequestLiveData() {
        return this.mErrRequestLiveData;
    }

    public String getPhone() {
        return w.getInstance().getString(NewLoginBo.SMS_LOGIN_NAME, "");
    }

    public final Map<String, String> getQueryMap(PageBo pageBo) {
        HashMap map = new HashMap();
        if (pageBo != null) {
            map.put(PAGE_KEY, String.valueOf(pageBo.getPage()));
            map.put(PAGE_NUMBER_KEY, String.valueOf(pageBo.getPageNumber()));
            if (x.isNotNull(pageBo.getKey())) {
                map.put(KEY, pageBo.getKey());
            }
            if (x.isNotNull(pageBo.getModuleKey())) {
                map.put(MODULE_KEY, pageBo.getModuleKey());
            }
            if (x.isNotNull(pageBo.getDataKey())) {
                map.put(DATA_KEY, pageBo.getDataKey());
            }
        }
        return map;
    }

    public final String getToken() {
        String token = b.getInstance().getToken();
        if (token == null) {
            token = w.getInstance().getString("Token", "");
        }
        return token == null ? "" : token;
    }

    public MutableLiveData<UploadResponseDto> getUploadResponseDtoMutableLive() {
        return this.mUploadResponseDtoMutableLive;
    }

    public final void handleResponseState(NewResponseStateVo newResponseStateVo, MutableLiveData<ResponseStateVo> mutableLiveData) {
        if (newResponseStateVo == null) {
            handlerResponseErr(null, "Response is empty");
            return;
        }
        ResponseStateVo responseStateVo = new ResponseStateVo();
        responseStateVo.setSuccess(newResponseStateVo.isSuccess());
        responseStateVo.setMessage(newResponseStateVo.getMessage());
        mutableLiveData.postValue(responseStateVo);
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0195  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x01c1 -> B:74:0x01cf). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final <V extends com.chinavisionary.core.app.net.base.dto.NewBaseVo> void handlerBaseVoResponse(h.l<V> r7, h.b<V> r8, androidx.lifecycle.MutableLiveData<V> r9) {
        /*
            Method dump skipped, instruction units count: 464
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chinavisionary.core.app.net.base.model.BaseModel.handlerBaseVoResponse(h.l, h.b, androidx.lifecycle.MutableLiveData):void");
    }

    public final <T> void handlerResponse(l<ResponseContent<T>> lVar, h.b<ResponseContent<T>> bVar, MutableLiveData<T> mutableLiveData) {
        String strString;
        String str = "";
        if (lVar == null) {
            handlerResponseErr(bVar, "");
            return;
        }
        if (lVar.isSuccessful() && lVar.code() < 300) {
            ResponseContent<T> responseContentBody = lVar.body();
            if (responseContentBody == null) {
                handlerResponseErr(bVar, "", lVar.code());
                return;
            }
            if (responseContentBody.isSuccess() && mutableLiveData != null) {
                if (responseContentBody.getData() == null) {
                    mutableLiveData.postValue(null);
                    return;
                } else {
                    mutableLiveData.postValue(responseContentBody.getData());
                    return;
                }
            }
            int i2 = -1;
            String code = responseContentBody.getCode();
            if (x.isNotNull(code) && x.isNumeric(code)) {
                i2 = Integer.parseInt(code);
            }
            handleLoginErr(bVar, i2, responseContentBody.getMessage());
            return;
        }
        if (lVar.code() == 666) {
            if (!isLoginState()) {
                sendUpdateToken();
                handlerResponseErr(bVar, "");
                return;
            } else {
                String fragmentPath = getFragmentPath(bVar.request().url().pathSegments());
                handlerResponseErr(bVar, getCode(666));
                openLogin(666, fragmentPath);
                return;
            }
        }
        if (lVar.code() == LOGIN_KICK_OUT_CODE) {
            String fragmentPath2 = getFragmentPath(bVar.request().url().pathSegments());
            handlerResponseErr(bVar, x.getString(R.string.tip_force_offline));
            openLogin(LOGIN_KICK_OUT_CODE, fragmentPath2);
            return;
        }
        if (lVar.code() == LOGIN_OTHER_LOGIN_CODE) {
            String fragmentPath3 = getFragmentPath(bVar.request().url().pathSegments());
            handlerResponseErr(bVar, getCode(LOGIN_OTHER_LOGIN_CODE));
            openLogin(LOGIN_OTHER_LOGIN_CODE, fragmentPath3);
            return;
        }
        if (lVar.code() == 403) {
            handlerResponseErr(bVar, x.getString(R.string.tip_no_auth));
            return;
        }
        if (lVar.code() == 404) {
            handlerResponseErr(bVar, x.getString(R.string.core_lib_tip_no_page));
            return;
        }
        if (lVar.code() == LOGIN_REPEAT_REQUEST_CODE) {
            handlerResponseErr(bVar, x.getNotNullStr(lVar.message(), x.getString(R.string.tip_repeat_request)));
            return;
        }
        try {
            String fragmentPath4 = getFragmentPath(bVar.request().url().pathSegments());
            strString = lVar.errorBody() != null ? lVar.errorBody().string() : "";
            try {
                handleRequestServerErr(fragmentPath4, lVar.code() + "", strString);
            } catch (Exception e2) {
                e = e2;
                str = strString;
                try {
                    e.printStackTrace();
                    strString = str;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    handlerResponseErr(bVar, e3.getMessage());
                    return;
                }
            }
        } catch (Exception e4) {
            e = e4;
        }
        if (lVar.code() < 500 || lVar.code() > 505) {
            handlerResponseErr(bVar, strString, lVar.code());
            return;
        }
        String string = x.getString(R.string.title_server_err_tip);
        try {
            ResponseContent<T> responseContentBody2 = lVar.body();
            String jSONString = JSON.toJSONString(responseContentBody2);
            q.d(getClass().getSimpleName(), "json = " + jSONString);
            if (responseContentBody2 != null) {
                q.d(getClass().getSimpleName(), "ResponseContent json = " + responseContentBody2.getMessage());
                string = responseContentBody2.getMessage();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        handlerResponseErr(bVar, string, lVar.code());
    }

    public final void handlerResponseErr(h.b bVar, String str) {
        handlerResponseErr(bVar, str, RequestErrDto.RESPONSE_ERR_CODE);
    }

    public void initRetrofit(String str) {
        this.mBaseUrl = str;
        m.b bVar = new m.b();
        if (TextUtils.isEmpty(str)) {
            str = j.getInstance().getBaseUrl();
        }
        this.mRetrofit = bVar.baseUrl(str).addConverterFactory(k.create()).addConverterFactory(h.p.a.a.create()).client(c.e.a.a.h.c.getInstance().getOkHttpClient()).build();
    }

    public final void newUploadFile(String str) {
        final String str2 = IHttpConstant.H5_BASE_URL + IHttpConstant.NEW_UPLOAD_FILE_URL;
        UploadDto uploadDto = new UploadDto();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new File(str));
        uploadDto.setUploadFile(arrayList);
        uploadDto.setRequestUrl(str2);
        uploadDto.setIUploadCallback(new c.e.a.a.h.e.c() { // from class: com.chinavisionary.core.app.net.base.model.BaseModel.7
            @Override // c.e.a.a.h.e.c
            public void onFailure(RequestErrDto requestErrDto) {
                if (requestErrDto == null) {
                    requestErrDto = new RequestErrDto();
                }
                BaseModel.this.handleResponseCodeErr(null, str2, requestErrDto.getCode(), requestErrDto.getErrMsg());
            }

            @Override // c.e.a.a.h.e.c
            public void onSuccess(ResponseUploadVo responseUploadVo) {
                UploadResponseDto uploadResponseDto = new UploadResponseDto();
                if (responseUploadVo == null || !responseUploadVo.isSuccess()) {
                    uploadResponseDto.setUploadFailedList(new ArrayList());
                } else {
                    ResponseUploadImgListVo data = responseUploadVo.getData();
                    if (data != null) {
                        uploadResponseDto.setUploadSuccessList(data.getRows());
                    }
                }
                BaseModel.this.mUploadResponseDtoMutableLive.postValue(uploadResponseDto);
            }
        });
        uploadFile(uploadDto);
    }

    public final void newUploadFileList(List<File> list, final boolean z) {
        final String str = IHttpConstant.H5_BASE_URL + IHttpConstant.NEW_UPLOAD_FILE_URL;
        final UploadDto uploadDto = new UploadDto();
        uploadDto.setUploadFile(scaleImage(list));
        uploadDto.setRequestUrl(str);
        uploadDto.setIUploadCallback(new c.e.a.a.h.e.c() { // from class: com.chinavisionary.core.app.net.base.model.BaseModel.5
            @Override // c.e.a.a.h.e.c
            public void onFailure(RequestErrDto requestErrDto) {
                if (requestErrDto == null) {
                    requestErrDto = new RequestErrDto();
                }
                BaseModel.this.handleResponseCodeErr(null, str, requestErrDto.getCode(), requestErrDto.getErrMsg());
            }

            @Override // c.e.a.a.h.e.c
            public void onSuccess(ResponseUploadVo responseUploadVo) {
                UploadResponseDto uploadResponseDto = new UploadResponseDto();
                if (responseUploadVo == null || !responseUploadVo.isSuccess()) {
                    uploadResponseDto.setUploadFailedList(new ArrayList());
                } else {
                    ResponseUploadImgListVo data = responseUploadVo.getData();
                    if (data != null) {
                        uploadResponseDto.setUploadSuccessList(BaseModel.this.uploadSort(data.getRows(), uploadDto.getUploadFile()));
                    }
                }
                BaseModel.this.mUploadResponseDtoMutableLive.postValue(uploadResponseDto);
            }
        });
        uploadFile(uploadDto);
    }

    public final void savePublicKey(String str) {
        j.getInstance().setPublicKey(str);
        w.getInstance().putString(e.o, str);
    }

    public final void saveToken(String str) {
        b.getInstance().setToken(str);
        w.getInstance().putString("Token", str);
    }

    public final void uploadFileList(List<File> list, final boolean z) {
        final UploadDto uploadDto = new UploadDto();
        if (z) {
            uploadDto.setUploadFile(list);
        } else {
            uploadDto.setUploadFile(scaleImage(list));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.isEmpty(this.mBaseUrl) ? IHttpConstant.BASE_URL : this.mBaseUrl);
        sb.append(IHttpConstant.UPLOAD_FILE_URL);
        final String string = sb.toString();
        uploadDto.setRequestUrl(string);
        uploadDto.setIUploadCallback(new c.e.a.a.h.e.c() { // from class: com.chinavisionary.core.app.net.base.model.BaseModel.4
            @Override // c.e.a.a.h.e.c
            public void onFailure(RequestErrDto requestErrDto) {
                if (requestErrDto == null) {
                    requestErrDto = new RequestErrDto();
                }
                BaseModel.this.handleResponseCodeErr(null, string, requestErrDto.getCode(), requestErrDto.getErrMsg());
            }

            @Override // c.e.a.a.h.e.c
            public void onSuccess(ResponseUploadVo responseUploadVo) {
                UploadResponseDto uploadResponseDto = new UploadResponseDto();
                if (responseUploadVo == null || !responseUploadVo.isSuccess()) {
                    uploadResponseDto.setUploadFailedList(new ArrayList());
                } else {
                    ResponseUploadImgListVo data = responseUploadVo.getData();
                    if (data != null) {
                        uploadResponseDto.setUploadSuccessList(BaseModel.this.uploadSort(data.getRows(), uploadDto.getUploadFile()));
                    }
                }
                BaseModel.this.mUploadResponseDtoMutableLive.postValue(uploadResponseDto);
            }
        });
        uploadFile(uploadDto);
    }

    public final <V extends NewBaseVo> d<V> enqueueBaseVoResponse(final MutableLiveData<V> mutableLiveData, final String str) {
        return (d<V>) new d<V>() { // from class: com.chinavisionary.core.app.net.base.model.BaseModel.3
            @Override // h.d
            public void onFailure(h.b<V> bVar, Throwable th) {
                BaseModel.this.handlerResponseErr(bVar, th.getMessage());
            }

            @Override // h.d
            public void onResponse(h.b<V> bVar, l<V> lVar) {
                NewBaseVo newBaseVo;
                if (lVar != null && (newBaseVo = (NewBaseVo) lVar.body()) != null) {
                    newBaseVo.setRequestParamBaseKey(str);
                }
                BaseModel.this.handlerBaseVoResponse(lVar, bVar, mutableLiveData);
            }
        };
    }

    public final void handlerResponseErr(h.b bVar, String str, int i2) {
        RequestErrDto requestErrDto = new RequestErrDto();
        requestErrDto.setCode(i2);
        requestErrDto.setSrcErr(str);
        if (bVar != null) {
            requestErrDto.setUrl(bVar.request().url().toString());
        }
        if (!TextUtils.isEmpty(str)) {
            requestErrDto.setErrMsg(str);
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (!TextUtils.isEmpty(str) && (str.contains(BaseMonitor.ALARM_POINT_CONNECT) || str.contains("html") || str.contains("No address associated with hostname"))) {
            requestErrDto.setErrMsg(x.getString(R.string.title_network_err));
        }
        if (!getNetworkStatus()) {
            requestErrDto.setErrMsg(x.getString(R.string.no_network_view_hint));
        }
        if (!TextUtils.isEmpty(str) && str.contains("Unable to resolve host")) {
            requestErrDto.setErrMsg(x.getString(R.string.no_network_view_hint));
        }
        q.d(getClass().getCanonicalName(), "handlerResponseErr :" + str);
        this.mErrRequestLiveData.postValue(requestErrDto);
        if (str == null) {
            try {
                str = requestErrDto.getErrMsg();
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (bVar != null) {
            if (x.isNotNull(str) && str.contains(x.getString(R.string.tip_auth_invalid))) {
                return;
            }
            if (x.isNotNull(str) && USER_NOT_EXITS.equals(str)) {
                openLogin(666, requestErrDto.getUrl());
            }
            b0.getInstance().handleRequestServerErr(requestErrDto.getUrl(), "" + requestErrDto.getCode(), str);
        }
    }

    public final void uploadFile(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.isEmpty(this.mBaseUrl) ? IHttpConstant.BASE_URL : this.mBaseUrl);
        sb.append(IHttpConstant.UPLOAD_FILE_URL);
        final String string = sb.toString();
        UploadDto uploadDto = new UploadDto();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new File(str));
        uploadDto.setUploadFile(arrayList);
        uploadDto.setRequestUrl(string);
        uploadDto.setIUploadCallback(new c.e.a.a.h.e.c() { // from class: com.chinavisionary.core.app.net.base.model.BaseModel.6
            @Override // c.e.a.a.h.e.c
            public void onFailure(RequestErrDto requestErrDto) {
                if (requestErrDto == null) {
                    requestErrDto = new RequestErrDto();
                }
                BaseModel.this.handleResponseCodeErr(null, string, requestErrDto.getCode(), requestErrDto.getErrMsg());
            }

            @Override // c.e.a.a.h.e.c
            public void onSuccess(ResponseUploadVo responseUploadVo) {
                UploadResponseDto uploadResponseDto = new UploadResponseDto();
                if (responseUploadVo == null || !responseUploadVo.isSuccess()) {
                    uploadResponseDto.setUploadFailedList(new ArrayList());
                } else {
                    ResponseUploadImgListVo data = responseUploadVo.getData();
                    if (data != null) {
                        uploadResponseDto.setUploadSuccessList(data.getRows());
                    }
                }
                BaseModel.this.mUploadResponseDtoMutableLive.postValue(uploadResponseDto);
            }
        });
        uploadFile(uploadDto);
    }
}
