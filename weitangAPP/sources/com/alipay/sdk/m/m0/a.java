package com.alipay.sdk.m.m0;

import android.content.Context;
import android.content.SharedPreferences;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alipay.sdk.m.l0.f;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences f5510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public SharedPreferences.Editor f5511c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Context f5512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f5513e;

    public a(Context context, String str, String str2, boolean z, boolean z2) {
        this.f5509a = "";
        this.f5510b = null;
        this.f5512d = null;
        this.f5513e = false;
        this.f5513e = z2;
        this.f5509a = str2;
        this.f5512d = context;
        if (context != null) {
            this.f5510b = context.getSharedPreferences(str2, 0);
        }
    }

    private void b() {
        SharedPreferences sharedPreferences;
        if (this.f5511c != null || (sharedPreferences = this.f5510b) == null) {
            return;
        }
        this.f5511c = sharedPreferences.edit();
    }

    public void a(String str, String str2) {
        if (f.m66a(str) || str.equals(DispatchConstants.TIMESTAMP)) {
            return;
        }
        b();
        SharedPreferences.Editor editor = this.f5511c;
        if (editor != null) {
            editor.putString(str, str2);
        }
    }

    public void b(String str) {
        if (f.m66a(str) || str.equals(DispatchConstants.TIMESTAMP)) {
            return;
        }
        b();
        SharedPreferences.Editor editor = this.f5511c;
        if (editor != null) {
            editor.remove(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a() {
        /*
            r5 = this;
            long r0 = java.lang.System.currentTimeMillis()
            android.content.SharedPreferences$Editor r2 = r5.f5511c
            r3 = 0
            if (r2 == 0) goto L20
            boolean r4 = r5.f5513e
            if (r4 != 0) goto L16
            android.content.SharedPreferences r4 = r5.f5510b
            if (r4 == 0) goto L16
            java.lang.String r4 = "t"
            r2.putLong(r4, r0)
        L16:
            android.content.SharedPreferences$Editor r0 = r5.f5511c
            boolean r0 = r0.commit()
            if (r0 != 0) goto L20
            r0 = 0
            goto L21
        L20:
            r0 = 1
        L21:
            android.content.SharedPreferences r1 = r5.f5510b
            if (r1 == 0) goto L31
            android.content.Context r1 = r5.f5512d
            if (r1 == 0) goto L31
            java.lang.String r2 = r5.f5509a
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            r5.f5510b = r1
        L31:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.m0.a.a():boolean");
    }

    public String a(String str) {
        SharedPreferences sharedPreferences = this.f5510b;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!f.m66a(string)) {
                return string;
            }
        }
        return "";
    }
}
