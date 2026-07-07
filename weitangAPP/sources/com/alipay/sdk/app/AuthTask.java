package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.s.b;
import com.alipay.sdk.m.u.h;
import com.alipay.sdk.m.u.l;
import com.alipay.sdk.m.u.n;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class AuthTask {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f5191c = h.class;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f5192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.alipay.sdk.m.x.a f5193b;

    public class a implements h.g {
        public a() {
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void a() {
            AuthTask.this.a();
        }

        @Override // com.alipay.sdk.m.u.h.g
        public void b() {
        }
    }

    public AuthTask(Activity activity) {
        this.f5192a = activity;
        b.d().a(this.f5192a);
        this.f5193b = new com.alipay.sdk.m.x.a(activity, com.alipay.sdk.m.x.a.k);
    }

    private h.g b() {
        return new a();
    }

    private void c() {
        com.alipay.sdk.m.x.a aVar = this.f5193b;
        if (aVar != null) {
            aVar.d();
        }
    }

    public synchronized String auth(String str, boolean z) {
        return innerAuth(new com.alipay.sdk.m.s.a(this.f5192a, str, "auth"), str, z);
    }

    public synchronized Map<String, String> authV2(String str, boolean z) {
        com.alipay.sdk.m.s.a aVar;
        aVar = new com.alipay.sdk.m.s.a(this.f5192a, str, "authV2");
        return l.a(aVar, innerAuth(aVar, str, z));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00c1 A[Catch: all -> 0x0137, DONT_GENERATE, PHI: r9
  0x00c1: PHI (r9v11 java.lang.String) = (r9v2 java.lang.String), (r9v13 java.lang.String) binds: [B:16:0x00bf, B:9:0x006b] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {, blocks: (B:4:0x0003, B:5:0x0006, B:8:0x0020, B:18:0x00ca, B:17:0x00c1, B:21:0x00d6, B:23:0x0123, B:24:0x012c, B:25:0x0136, B:15:0x0074, B:7:0x001a, B:14:0x0071), top: B:31:0x0003, inners: #0, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String innerAuth(com.alipay.sdk.m.s.a r7, java.lang.String r8, boolean r9) {
        /*
            Method dump skipped, instruction units count: 314
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.innerAuth(com.alipay.sdk.m.s.a, java.lang.String, boolean):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.alipay.sdk.m.x.a aVar = this.f5193b;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String b(android.app.Activity r4, java.lang.String r5, com.alipay.sdk.m.s.a r6) {
        /*
            r3 = this;
            r3.c()
            r0 = 0
            com.alipay.sdk.m.q.a r1 = new com.alipay.sdk.m.q.a     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r1.<init>()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.m.p.b r4 = r1.a(r6, r4, r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            org.json.JSONObject r4 = r4.c()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.lang.String r5 = "form"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.lang.String r5 = "onload"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.util.List r4 = com.alipay.sdk.m.r.b.a(r4)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r3.a()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r5 = 0
        L25:
            int r1 = r4.size()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            if (r5 >= r1) goto L4a
            java.lang.Object r1 = r4.get(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.m.r.b r1 = (com.alipay.sdk.m.r.b) r1     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.m.r.a r1 = r1.a()     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.m.r.a r2 = com.alipay.sdk.m.r.a.WapPay     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            if (r1 != r2) goto L47
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            com.alipay.sdk.m.r.b r4 = (com.alipay.sdk.m.r.b) r4     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            java.lang.String r4 = r3.a(r6, r4)     // Catch: java.lang.Throwable -> L4e java.io.IOException -> L57
            r3.a()
            return r4
        L47:
            int r5 = r5 + 1
            goto L25
        L4a:
            r3.a()
            goto L6b
        L4e:
            r4 = move-exception
            java.lang.String r5 = "biz"
            java.lang.String r1 = "H5AuthDataAnalysisError"
            com.alipay.sdk.m.k.a.a(r6, r5, r1, r4)     // Catch: java.lang.Throwable -> L86
            goto L68
        L57:
            r4 = move-exception
            com.alipay.sdk.m.j.c r5 = com.alipay.sdk.m.j.c.NETWORK_ERROR     // Catch: java.lang.Throwable -> L86
            int r5 = r5.b()     // Catch: java.lang.Throwable -> L86
            com.alipay.sdk.m.j.c r5 = com.alipay.sdk.m.j.c.b(r5)     // Catch: java.lang.Throwable -> L86
            java.lang.String r0 = "net"
            com.alipay.sdk.m.k.a.a(r6, r0, r4)     // Catch: java.lang.Throwable -> L86
            r0 = r5
        L68:
            r3.a()
        L6b:
            if (r0 != 0) goto L77
            com.alipay.sdk.m.j.c r4 = com.alipay.sdk.m.j.c.FAILED
            int r4 = r4.b()
            com.alipay.sdk.m.j.c r0 = com.alipay.sdk.m.j.c.b(r4)
        L77:
            int r4 = r0.b()
            java.lang.String r5 = r0.a()
            java.lang.String r6 = ""
            java.lang.String r4 = com.alipay.sdk.m.j.b.a(r4, r5, r6)
            return r4
        L86:
            r4 = move-exception
            r3.a()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.b(android.app.Activity, java.lang.String, com.alipay.sdk.m.s.a):java.lang.String");
    }

    private String a(Activity activity, String str, com.alipay.sdk.m.s.a aVar) {
        String strA = aVar.a(str);
        List<a.b> listL = com.alipay.sdk.m.m.a.D().l();
        if (!com.alipay.sdk.m.m.a.D().f5491h || listL == null) {
            listL = com.alipay.sdk.m.j.a.f5387d;
        }
        if (n.a(aVar, (Context) this.f5192a, listL, true)) {
            h hVar = new h(activity, aVar, b());
            String strA2 = hVar.a(strA, false);
            hVar.a();
            if (!TextUtils.equals(strA2, h.j) && !TextUtils.equals(strA2, h.k)) {
                return TextUtils.isEmpty(strA2) ? com.alipay.sdk.m.j.b.a() : strA2;
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.i0);
            return b(activity, strA, aVar);
        }
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.j0);
        return b(activity, strA, aVar);
    }

    private String a(com.alipay.sdk.m.s.a aVar, com.alipay.sdk.m.r.b bVar) {
        String[] strArrC = bVar.c();
        Bundle bundle = new Bundle();
        bundle.putString(AgooConstants.OPEN_URL, strArrC[0]);
        Intent intent = new Intent(this.f5192a, (Class<?>) H5AuthActivity.class);
        intent.putExtras(bundle);
        a.C0089a.a(aVar, intent);
        this.f5192a.startActivity(intent);
        Object obj = f5191c;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException unused) {
                return com.alipay.sdk.m.j.b.a();
            }
        }
        String strD = com.alipay.sdk.m.j.b.d();
        return TextUtils.isEmpty(strD) ? com.alipay.sdk.m.j.b.a() : strD;
    }
}
