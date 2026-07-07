package com.tianmu.c.n;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tianmu.TianmuSDK;
import com.tianmu.utils.TianmuClassUtil;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IWXAPI f11919b;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final s f11920a = new s();
    }

    public static s d() {
        return b.f11920a;
    }

    public boolean a() {
        return this.f11918a;
    }

    public boolean b() {
        Context context = TianmuSDK.getInstance().getContext();
        String strK = n.D().k();
        if (context == null || TextUtils.isEmpty(strK) || !c() || a()) {
            return false;
        }
        try {
            if (this.f11919b == null) {
                this.f11919b = WXAPIFactory.createWXAPI(context, strK);
            }
            return this.f11919b.isWXAppInstalled();
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean c() {
        return TianmuClassUtil.isImportWXOpenApiDependencies();
    }

    private s() {
        this.f11918a = false;
    }

    public boolean a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || !c() || a()) {
            return false;
        }
        try {
            if (this.f11919b == null) {
                Context context = TianmuSDK.getInstance().getContext();
                String strK = n.D().k();
                if (context != null && !TextUtils.isEmpty(strK)) {
                    this.f11919b = WXAPIFactory.createWXAPI(context, strK);
                }
            }
            IWXAPI iwxapi = this.f11919b;
            if (iwxapi == null || !iwxapi.isWXAppInstalled()) {
                return false;
            }
            WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
            req.userName = str;
            if (!TextUtils.isEmpty(str2)) {
                req.path = str2;
            }
            this.f11919b.sendReq(req);
            com.tianmu.c.i.c cVarB = m.b().b(str3);
            if (cVarB != null && !cVarB.P()) {
                j.b().a(cVarB.E(), false);
                cVarB.e(true);
            }
            return true;
        } catch (Throwable unused) {
            this.f11918a = true;
            return false;
        }
    }
}
