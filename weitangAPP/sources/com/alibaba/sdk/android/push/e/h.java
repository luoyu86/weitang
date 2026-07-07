package com.alibaba.sdk.android.push.e;

import android.content.Context;
import android.util.Log;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.error.ErrorCode;
import com.alibaba.sdk.android.push.CommonCallback;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class h extends com.alibaba.sdk.android.push.common.util.a.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AmsLogger f4993c = AmsLogger.getLogger("MPS:VipRequestTask");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CommonCallback f4994d;

    public h(Context context, String str, CommonCallback commonCallback) {
        super(context, str);
        this.f4994d = commonCallback;
    }

    private void a(int i2, com.alibaba.sdk.android.push.common.util.a.b bVar, CommonCallback commonCallback) {
        ErrorCode errorCodeBuild;
        String code;
        if (commonCallback == null) {
            return;
        }
        f4993c.d("requestType: " + i2 + ", errorCode:" + bVar.f4889c + ", httpcode: " + bVar.f4888b + ", content:" + bVar.f4887a);
        if (!bVar.f4889c.getCode().equals(com.alibaba.sdk.android.push.common.global.c.f4875a.getCode())) {
            commonCallback.onFailed(bVar.f4889c.getCode(), bVar.f4889c.getMsg());
            return;
        }
        try {
            commonCallback.onSuccess(i.a(i2, bVar.f4888b, bVar.f4887a));
        } catch (com.alibaba.sdk.android.push.a.f e2) {
            f4993c.e("Vip call failed", e2);
            code = e2.a().getCode();
            errorCodeBuild = e2.a();
            commonCallback.onFailed(code, errorCodeBuild.getMsg());
        } catch (Throwable th) {
            f4993c.e("Vip call failed.", th);
            errorCodeBuild = com.alibaba.sdk.android.push.common.global.c.k.copy().msg(th.getMessage()).detail(Log.getStackTraceString(th)).build();
            code = errorCodeBuild.getCode();
            commonCallback.onFailed(code, errorCodeBuild.getMsg());
        }
    }

    @Override // com.alibaba.sdk.android.push.common.util.a.c
    public Map<String, String> a(Context context, Map<String, String> map) {
        return com.alibaba.sdk.android.ams.common.util.c.a(map);
    }

    @Override // com.alibaba.sdk.android.push.common.util.a.c, android.os.AsyncTask
    /* JADX INFO: renamed from: a */
    public void onPostExecute(com.alibaba.sdk.android.push.common.util.a.b bVar) {
        super.onPostExecute(bVar);
        a(a(), bVar, this.f4994d);
    }
}
