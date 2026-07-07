package com.taobao.agoo;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.sdk.android.error.ErrorCode;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsErrorCode;
import com.taobao.accs.IACCSManager;
import com.taobao.accs.IAgooAppReceiver;
import com.taobao.accs.utl.ALog;
import org.android.agoo.common.Config;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends IAgooAppReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IRegister f10519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f10520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ IACCSManager f10521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f10522d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f10523e;

    public c(IRegister iRegister, Context context, IACCSManager iACCSManager, String str, String str2) {
        this.f10519a = iRegister;
        this.f10520b = context;
        this.f10521c = iACCSManager;
        this.f10522d = str;
        this.f10523e = str2;
    }

    @Override // com.taobao.accs.IAgooAppReceiver
    public String getAppkey() {
        return this.f10522d;
    }

    @Override // com.taobao.accs.IAppReceiverV2
    public void onBindApp(int i2, String str, String str2) {
        if (i2 == AccsErrorCode.SUCCESS.getCodeInt()) {
            onBindApp(i2, str2);
        } else if (this.f10519a != null) {
            ErrorCode errorCodeBuild = a.a(i2, str).detail("bindApp").build();
            this.f10519a.onFailure(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
        }
    }

    @Override // com.taobao.accs.IAppReceiverV2, com.taobao.accs.IAppReceiverV1
    public void onBindApp(int i2, String str) {
        try {
            ALog.i(TaobaoRegister.TAG, "onBindApp", "errorCode", Integer.valueOf(i2));
            if (i2 == AccsErrorCode.SUCCESS.getCodeInt()) {
                if (TaobaoRegister.mRequestListener == null) {
                    com.taobao.agoo.a.b unused = TaobaoRegister.mRequestListener = new com.taobao.agoo.a.b(this.f10520b);
                }
                this.f10521c.registerDataListener(this.f10520b, "AgooDeviceCmd", TaobaoRegister.mRequestListener);
                if (com.taobao.agoo.a.b.f10517b.b(this.f10520b.getPackageName()) && Config.getDeviceToken(this.f10520b) != null) {
                    ALog.i(TaobaoRegister.TAG, "agoo aready Registered return ", new Object[0]);
                    IRegister iRegister = this.f10519a;
                    if (iRegister != null) {
                        iRegister.onSuccess(Config.getDeviceToken(this.f10520b));
                        return;
                    }
                    return;
                }
                byte[] bArrA = com.taobao.agoo.a.a.c.a(this.f10520b, this.f10522d, this.f10523e);
                if (bArrA == null) {
                    IRegister iRegister2 = this.f10519a;
                    if (iRegister2 != null) {
                        ErrorCode errorCode = a.REGISTER_DATA_ERROR;
                        iRegister2.onFailure(errorCode.getCode(), errorCode.getMsg());
                        return;
                    }
                    return;
                }
                String strSendRequest = this.f10521c.sendRequest(this.f10520b, new ACCSManager.AccsRequest(null, "AgooDeviceCmd", bArrA, null));
                if (TextUtils.isEmpty(strSendRequest)) {
                    IRegister iRegister3 = this.f10519a;
                    if (iRegister3 != null) {
                        ErrorCode errorCode2 = a.ACCS_CHECK_ERROR;
                        iRegister3.onFailure(errorCode2.getCode(), errorCode2.getMsg());
                        return;
                    }
                    return;
                }
                if (this.f10519a != null) {
                    TaobaoRegister.mRequestListener.f10518a.put(strSendRequest, this.f10519a);
                    return;
                }
                return;
            }
            if (this.f10519a != null) {
                ErrorCode errorCodeBuild = a.a(i2, "no error msg").detail("bindApp").build();
                this.f10519a.onFailure(errorCodeBuild.getCode(), errorCodeBuild.getMsg());
            }
        } catch (Throwable th) {
            ALog.e(TaobaoRegister.TAG, "register onBindApp", th, new Object[0]);
        }
    }
}
