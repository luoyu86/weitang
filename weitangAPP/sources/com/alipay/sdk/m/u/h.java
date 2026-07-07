package com.alipay.sdk.m.u;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.APayEntranceActivity;
import com.alipay.sdk.app.AlipayResultActivity;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.s.a;
import com.alipay.sdk.m.u.n;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static final String j = "failed";
    public static final String k = "scheme_failed";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f5676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile IAlixPay f5677b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f5679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f5680e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.alipay.sdk.m.s.a f5681f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5678c = IAlixPay.class;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5682g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f5683h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f5684i = null;

    public class a implements AlipayResultActivity.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f5685a;

        public a(CountDownLatch countDownLatch) {
            this.f5685a = countDownLatch;
        }

        @Override // com.alipay.sdk.app.AlipayResultActivity.a
        public void a(int i2, String str, String str2) {
            h.this.f5683h = com.alipay.sdk.m.j.b.a(i2, str, str2);
            this.f5685a.countDown();
        }
    }

    public class b implements APayEntranceActivity.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f5687a;

        public b(Object obj) {
            this.f5687a = obj;
        }

        @Override // com.alipay.sdk.app.APayEntranceActivity.a
        public void a(String str) {
            h.this.f5684i = str;
            synchronized (this.f5687a) {
                try {
                    this.f5687a.notify();
                } finally {
                }
            }
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ APayEntranceActivity.a f5689a;

        public c(APayEntranceActivity.a aVar) {
            this.f5689a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.this.f5681f == null || h.this.f5681f.d()) {
                return;
            }
            com.alipay.sdk.m.k.a.b(h.this.f5681f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.e0, "");
            if (com.alipay.sdk.m.m.a.D().w()) {
                h.this.f5681f.b(true);
                this.f5689a.a(com.alipay.sdk.m.j.b.a());
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f5691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f5692b;

        public d(Intent intent, Object obj) {
            this.f5691a = intent;
            this.f5692b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (h.this.f5676a != null) {
                    h.this.f5676a.startActivity(this.f5691a);
                } else {
                    com.alipay.sdk.m.k.a.b(h.this.f5681f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.c0, "");
                    Context contextA = h.this.f5681f.a();
                    if (contextA != null) {
                        contextA.startActivity(this.f5691a);
                    }
                }
            } finally {
            }
        }
    }

    public class e extends IRemoteServiceCallback.Stub {
        public e() {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public int getVersion() throws RemoteException {
            return 4;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public boolean isHideLoadingScreen() throws RemoteException {
            return false;
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void payEnd(boolean z, String str) throws RemoteException {
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void r03(String str, String str2, Map map) throws RemoteException {
            com.alipay.sdk.m.k.a.a(h.this.f5681f, com.alipay.sdk.m.k.b.p, str, str2);
            if (TextUtils.equals(str2, "ActivityStartSuccess")) {
                if (h.this.f5680e != null) {
                    h.this.f5680e.a();
                }
                if (h.this.f5681f != null) {
                    h.this.f5681f.c(true);
                }
            }
        }

        @Override // com.alipay.android.app.IRemoteServiceCallback
        public void startActivity(String str, String str2, int i2, Bundle bundle) throws RemoteException {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                bundle.putInt("CallingPid", i2);
                intent.putExtras(bundle);
            } catch (Exception e2) {
                com.alipay.sdk.m.k.a.a(h.this.f5681f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.Z, e2);
            }
            intent.setClassName(str, str2);
            try {
                if (Build.VERSION.SDK_INT >= 16) {
                    ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
                    ActivityManager.getMyMemoryState(runningAppProcessInfo);
                    com.alipay.sdk.m.k.a.a(h.this.f5681f, com.alipay.sdk.m.k.b.l, "isFg", runningAppProcessInfo.processName + "|" + runningAppProcessInfo.importance + "|");
                }
            } catch (Throwable unused) {
            }
            try {
                if (h.this.f5676a == null) {
                    com.alipay.sdk.m.k.a.b(h.this.f5681f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.a0, "");
                    Context contextA = h.this.f5681f.a();
                    if (contextA != null) {
                        contextA.startActivity(intent);
                        return;
                    }
                    return;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                h.this.f5676a.startActivity(intent);
                com.alipay.sdk.m.k.a.a(h.this.f5681f, com.alipay.sdk.m.k.b.l, "stAct2", "" + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(h.this.f5681f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.b0, th);
                throw th;
            }
        }

        public /* synthetic */ e(h hVar, a aVar) {
            this();
        }
    }

    public class f implements ServiceConnection {
        public f() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.alipay.sdk.m.k.a.a(h.this.f5681f, com.alipay.sdk.m.k.b.l, "srvCon");
            synchronized (h.this.f5678c) {
                h.this.f5677b = IAlixPay.Stub.asInterface(iBinder);
                h.this.f5678c.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.alipay.sdk.m.k.a.a(h.this.f5681f, com.alipay.sdk.m.k.b.l, "srvDis");
            h.this.f5677b = null;
        }

        public /* synthetic */ f(h hVar, a aVar) {
            this();
        }
    }

    public interface g {
        void a();

        void b();
    }

    public h(Activity activity, com.alipay.sdk.m.s.a aVar, g gVar) {
        this.f5676a = activity;
        this.f5681f = aVar;
        this.f5680e = gVar;
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.A, "alipaySdk");
    }

    private String b(String str, String str2) {
        JSONObject jSONObject;
        Object obj = new Object();
        String strA = n.a(32);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, "BSAStart", strA + "|" + jElapsedRealtime);
        a.C0089a.a(this.f5681f, strA);
        b bVar = new b(obj);
        APayEntranceActivity.f5186h.put(strA, bVar);
        try {
            HashMap<String, String> mapA = com.alipay.sdk.m.s.a.a(this.f5681f);
            mapA.put("ts_intent", String.valueOf(jElapsedRealtime));
            jSONObject = new JSONObject(mapA);
        } catch (Throwable th) {
            try {
                com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, "BSALocEx", th);
                jSONObject = null;
            } catch (InterruptedException e2) {
                com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, "BSAWaiting", e2);
                com.alipay.sdk.m.j.c cVar = com.alipay.sdk.m.j.c.PAY_WAITTING;
                return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
            } catch (Throwable th2) {
                com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, "BSAEx", th2);
                n.a("alipaySdk", com.alipay.sdk.m.l.b.f5455q, this.f5676a, this.f5681f);
                return k;
            }
        }
        Intent intent = new Intent(this.f5676a, (Class<?>) APayEntranceActivity.class);
        intent.putExtra(APayEntranceActivity.f5182d, str);
        intent.putExtra(APayEntranceActivity.f5183e, str2);
        intent.putExtra(APayEntranceActivity.f5184f, strA);
        if (jSONObject != null) {
            intent.putExtra(APayEntranceActivity.f5185g, jSONObject.toString());
        }
        new Handler(Looper.getMainLooper()).postDelayed(new c(bVar), com.alipay.sdk.m.m.a.D().k());
        Activity activity = this.f5676a;
        com.alipay.sdk.m.s.a aVar = this.f5681f;
        com.alipay.sdk.m.k.a.a(activity, aVar, str, aVar.f5636d);
        if (com.alipay.sdk.m.m.a.D().z()) {
            new Handler(Looper.getMainLooper()).post(new d(intent, obj));
        } else {
            try {
                Activity activity2 = this.f5676a;
                if (activity2 != null) {
                    activity2.startActivity(intent);
                } else {
                    com.alipay.sdk.m.k.a.b(this.f5681f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.a0, "");
                    Context contextA = this.f5681f.a();
                    if (contextA != null) {
                        contextA.startActivity(intent);
                    }
                }
            } catch (Throwable th3) {
                com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.b0, th3);
                throw th3;
            }
        }
        synchronized (obj) {
            obj.wait();
        }
        String str3 = this.f5684i;
        String str4 = "unknown";
        try {
            String str5 = l.a(this.f5681f, str3).get(l.f5707a);
            str4 = str5 == null ? "null" : str5;
        } catch (Throwable th4) {
            com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, "BSAStatEx", th4);
        }
        com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, "BSADone-" + str4);
        if (!TextUtils.isEmpty(str3)) {
            return str3;
        }
        com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, "BSAEmpty");
        return k;
    }

    public String a(String str, boolean z) {
        n.c cVarA;
        String strB = "";
        try {
            List<a.b> listL = com.alipay.sdk.m.m.a.D().l();
            if (!com.alipay.sdk.m.m.a.D().f5491h || listL == null) {
                listL = com.alipay.sdk.m.j.a.f5387d;
            }
            cVarA = n.a(this.f5681f, this.f5676a, listL);
        } catch (Throwable th) {
            th = th;
            cVarA = null;
        }
        if (cVarA != null) {
            try {
                if (cVarA.a(this.f5681f) || cVarA.a() || n.a(cVarA.f5723a)) {
                    return j;
                }
                PackageInfo packageInfo = cVarA.f5723a;
                if (packageInfo != null && !n.f5712b.equals(packageInfo.packageName)) {
                    strB = cVarA.f5723a.packageName;
                } else {
                    strB = n.b();
                }
                PackageInfo packageInfo2 = cVarA.f5723a;
                packageInfo = packageInfo2 != null ? packageInfo2 : null;
                String strC = com.alipay.sdk.m.m.a.D().c();
                if (strC != null) {
                    if (strC.length() > 0) {
                        try {
                            JSONObject jSONObjectOptJSONObject = new JSONObject(strC).optJSONObject(strB);
                            if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                                while (itKeys.hasNext()) {
                                    String next = itKeys.next();
                                    int i2 = Integer.parseInt(next);
                                    if (packageInfo != null && packageInfo.versionCode >= i2) {
                                        try {
                                            boolean zA = com.alipay.sdk.m.m.a.D().a(this.f5676a, Integer.parseInt(jSONObjectOptJSONObject.getString(next)));
                                            this.f5682g = zA;
                                            if (zA) {
                                                break;
                                            }
                                        } catch (Exception unused) {
                                            continue;
                                        }
                                    }
                                }
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.N, th);
            }
            boolean zB = n.b(this.f5681f);
            if ((z || this.f5682g) && !zB && b(strB, this.f5676a, this.f5681f)) {
                return a(str, strB, packageInfo);
            }
            return a(str, strB, packageInfo, cVarA);
        }
        return j;
    }

    private void a(n.c cVar) throws InterruptedException {
        PackageInfo packageInfo;
        if (cVar == null || (packageInfo = cVar.f5723a) == null) {
            return;
        }
        String str = packageInfo.packageName;
        Intent intent = new Intent();
        intent.setClassName(str, "com.alipay.android.app.TransProcessPayActivity");
        try {
            this.f5676a.startActivity(intent);
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.g0, th);
        }
        Thread.sleep(200L);
    }

    private String a(String str, String str2, PackageInfo packageInfo) {
        String str3 = packageInfo != null ? packageInfo.versionName : "";
        com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.A, "pay payInvokeAct");
        com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.X, str2 + "|" + str3);
        Activity activity = this.f5676a;
        com.alipay.sdk.m.s.a aVar = this.f5681f;
        com.alipay.sdk.m.k.a.a(activity, aVar, str, aVar.f5636d);
        return b(str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0189 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a(java.lang.String r9, java.lang.String r10, android.content.pm.PackageInfo r11, com.alipay.sdk.m.u.n.c r12) {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.m.u.h.a(java.lang.String, java.lang.String, android.content.pm.PackageInfo, com.alipay.sdk.m.u.n$c):java.lang.String");
    }

    public static boolean b(String str, Context context, com.alipay.sdk.m.s.a aVar) {
        try {
            Intent intent = new Intent();
            intent.setClassName(str, "com.alipay.android.app.flybird.ui.window.FlyBirdWindowActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSADetectFail");
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSADetectFail", th);
            return false;
        }
    }

    private String a(String str, String str2) {
        String str3;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        String strA = n.a(32);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, "BSPStart", strA + "|" + jElapsedRealtime);
        a.C0089a.a(this.f5681f, strA);
        AlipayResultActivity.f5190a.put(strA, new a(countDownLatch));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sourcePid", Binder.getCallingPid());
            jSONObject.put(com.alipay.sdk.m.l.b.f5449d, str);
            jSONObject.put("pkgName", this.f5676a.getPackageName());
            jSONObject.put("session", strA);
            String strEncodeToString = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 2);
            Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", "20000125");
            builderAppendQueryParameter.appendQueryParameter("mqpSchemePay", strEncodeToString);
            try {
                HashMap<String, String> mapA = com.alipay.sdk.m.s.a.a(this.f5681f);
                mapA.put("ts_scheme", String.valueOf(jElapsedRealtime));
                builderAppendQueryParameter.appendQueryParameter("mqpLoc", new JSONObject(mapA).toString());
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, "BSPLocEx", th);
            }
            String string = builderAppendQueryParameter.build().toString();
            Intent intent = new Intent();
            intent.setPackage(str2);
            intent.addFlags(268435456);
            intent.setData(Uri.parse(string));
            Activity activity = this.f5676a;
            com.alipay.sdk.m.s.a aVar = this.f5681f;
            com.alipay.sdk.m.k.a.a(activity, aVar, str, aVar.f5636d);
            this.f5676a.startActivity(intent);
            com.alipay.sdk.m.u.e.d(com.alipay.sdk.m.l.a.A, "pay scheme waiting " + string);
            countDownLatch.await();
            String str4 = this.f5683h;
            try {
                str3 = l.a(this.f5681f, str4).get(l.f5707a);
                if (str3 == null) {
                    str3 = "null";
                }
            } catch (Throwable th2) {
                com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, "BSPStatEx", th2);
                str3 = "unknown";
            }
            com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, "BSPDone-" + str3);
            if (!TextUtils.isEmpty(str4)) {
                return str4;
            }
            com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, "BSPEmpty");
            return k;
        } catch (InterruptedException e2) {
            com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, "BSPWaiting", e2);
            com.alipay.sdk.m.j.c cVar = com.alipay.sdk.m.j.c.PAY_WAITTING;
            return com.alipay.sdk.m.j.b.a(cVar.b(), cVar.a(), "");
        } catch (Throwable th3) {
            com.alipay.sdk.m.k.a.a(this.f5681f, com.alipay.sdk.m.k.b.l, "BSPEx", th3);
            return k;
        }
    }

    public static boolean a(String str, Context context, com.alipay.sdk.m.s.a aVar) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.setClassName(str, "com.alipay.android.msp.ui.views.MspContainerActivity");
            if (intent.resolveActivityInfo(context.getPackageManager(), 0) != null) {
                return true;
            }
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSPDetectFail");
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "BSPDetectFail", th);
            return false;
        }
    }

    private Pair<String, Boolean> a(String str, String str2, com.alipay.sdk.m.s.a aVar) {
        int i2;
        f fVar;
        IRemoteServiceCallback eVar;
        Activity activity;
        int version;
        String strA;
        Activity activity2;
        Activity activity3;
        String strPay;
        Activity activity4;
        Intent intent = new Intent();
        intent.setPackage(str2);
        intent.setAction(n.c(str2));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(jElapsedRealtime);
        sb.append("|");
        sb.append(str != null ? str.length() : 0);
        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.R, sb.toString());
        com.alipay.sdk.m.k.a.a(this.f5676a, aVar, str, aVar.f5636d);
        try {
            try {
                if (!com.alipay.sdk.m.m.a.D().f()) {
                    ComponentName componentNameStartService = this.f5676a.getApplication().startService(intent);
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "stSrv", componentNameStartService != null ? componentNameStartService.getPackageName() : "null");
                } else {
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "stSrv", "skipped");
                }
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.K, th);
            }
            if (com.alipay.sdk.m.m.a.D().b()) {
                i2 = 65;
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, "bindFlg", "imp");
            } else {
                i2 = 1;
            }
            a aVar2 = null;
            f fVar2 = new f(this, aVar2);
            if (this.f5676a.getApplicationContext().bindService(intent, fVar2, i2)) {
                synchronized (this.f5678c) {
                    if (this.f5677b == null) {
                        try {
                            this.f5678c.wait(com.alipay.sdk.m.m.a.D().k());
                        } catch (InterruptedException e2) {
                            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.L, e2);
                        }
                    }
                }
                IAlixPay iAlixPay = this.f5677b;
                try {
                    if (iAlixPay == null) {
                        com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.E, "");
                        n.a("alipaySdk", com.alipay.sdk.m.l.b.o, this.f5676a, this.f5681f);
                        Pair<String, Boolean> pair = new Pair<>(j, Boolean.TRUE);
                        try {
                            this.f5676a.getApplicationContext().unbindService(fVar2);
                        } catch (Throwable th2) {
                            com.alipay.sdk.m.u.e.a(th2);
                        }
                        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
                        com.alipay.sdk.m.k.a.a(this.f5676a, aVar, str, aVar.f5636d);
                        this.f5677b = null;
                        if (this.f5679d && (activity4 = this.f5676a) != null) {
                            activity4.setRequestedOrientation(0);
                            this.f5679d = false;
                        }
                        return pair;
                    }
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.S, "" + jElapsedRealtime2);
                    g gVar = this.f5680e;
                    if (gVar != null) {
                        gVar.b();
                    }
                    if (this.f5676a.getRequestedOrientation() == 0) {
                        this.f5676a.setRequestedOrientation(1);
                        this.f5679d = true;
                    }
                    try {
                        version = iAlixPay.getVersion();
                    } catch (Throwable th3) {
                        com.alipay.sdk.m.u.e.a(th3);
                        version = 0;
                    }
                    eVar = new e(this, aVar2);
                    try {
                        if (version >= 3) {
                            iAlixPay.registerCallback03(eVar, str, null);
                        } else {
                            iAlixPay.registerCallback(eVar);
                        }
                        long jElapsedRealtime3 = SystemClock.elapsedRealtime();
                        StringBuilder sb2 = new StringBuilder();
                        try {
                            sb2.append("");
                            sb2.append(jElapsedRealtime3);
                            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.U, sb2.toString());
                            if (version >= 3) {
                                iAlixPay.r03(com.alipay.sdk.m.k.b.l, "bind_pay", null);
                            }
                            try {
                                if (version >= 2) {
                                    Map mapA = com.alipay.sdk.m.s.a.a(aVar);
                                    mapA.put("ts_bind", String.valueOf(jElapsedRealtime));
                                    mapA.put("ts_bend", String.valueOf(jElapsedRealtime2));
                                    mapA.put("ts_pay", String.valueOf(jElapsedRealtime3));
                                    strPay = iAlixPay.pay02(str, mapA);
                                } else {
                                    strPay = iAlixPay.Pay(str);
                                }
                                strA = strPay;
                                fVar = fVar2;
                            } catch (Throwable th4) {
                                com.alipay.sdk.m.s.a aVar3 = this.f5681f;
                                if (aVar3 != null && !aVar3.f()) {
                                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.H, th4);
                                    n.a("alipaySdk", com.alipay.sdk.m.l.b.p, this.f5676a, this.f5681f);
                                    if (com.alipay.sdk.m.m.a.D().u()) {
                                        Pair<String, Boolean> pair2 = new Pair<>(j, Boolean.FALSE);
                                        try {
                                            iAlixPay.unregisterCallback(eVar);
                                        } catch (Throwable th5) {
                                            com.alipay.sdk.m.u.e.a(th5);
                                        }
                                        try {
                                            this.f5676a.getApplicationContext().unbindService(fVar2);
                                        } catch (Throwable th6) {
                                            com.alipay.sdk.m.u.e.a(th6);
                                        }
                                        com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
                                        com.alipay.sdk.m.k.a.a(this.f5676a, aVar, str, aVar.f5636d);
                                        this.f5677b = null;
                                        if (this.f5679d && (activity2 = this.f5676a) != null) {
                                            activity2.setRequestedOrientation(0);
                                            this.f5679d = false;
                                        }
                                        return pair2;
                                    }
                                }
                                fVar = fVar2;
                                try {
                                    strA = com.alipay.sdk.m.j.b.a();
                                } catch (Throwable th7) {
                                    th = th7;
                                }
                            }
                            try {
                                iAlixPay.unregisterCallback(eVar);
                            } catch (Throwable th8) {
                                com.alipay.sdk.m.u.e.a(th8);
                            }
                            try {
                                this.f5676a.getApplicationContext().unbindService(fVar);
                            } catch (Throwable th9) {
                                com.alipay.sdk.m.u.e.a(th9);
                            }
                            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
                            com.alipay.sdk.m.k.a.a(this.f5676a, aVar, str, aVar.f5636d);
                            this.f5677b = null;
                            if (this.f5679d && (activity3 = this.f5676a) != null) {
                                activity3.setRequestedOrientation(0);
                                this.f5679d = false;
                            }
                            return new Pair<>(strA, Boolean.FALSE);
                        } catch (Throwable th10) {
                            th = th10;
                            fVar = fVar2;
                        }
                    } catch (Throwable th11) {
                        th = th11;
                        fVar = fVar2;
                    }
                } catch (Throwable th12) {
                    th = th12;
                    fVar = fVar2;
                    eVar = null;
                }
                try {
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.E, th, "in_bind");
                    Pair<String, Boolean> pair3 = new Pair<>(j, Boolean.TRUE);
                    if (eVar != null) {
                        try {
                            iAlixPay.unregisterCallback(eVar);
                        } catch (Throwable th13) {
                            com.alipay.sdk.m.u.e.a(th13);
                        }
                    }
                    try {
                        this.f5676a.getApplicationContext().unbindService(fVar);
                    } catch (Throwable th14) {
                        com.alipay.sdk.m.u.e.a(th14);
                    }
                    com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.T, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.m.k.a.a(this.f5676a, aVar, str, aVar.f5636d);
                    this.f5677b = null;
                    if (this.f5679d && (activity = this.f5676a) != null) {
                        activity.setRequestedOrientation(0);
                        this.f5679d = false;
                    }
                    return pair3;
                } finally {
                }
            } else {
                throw new Throwable("bindService fail");
            }
        } catch (Throwable th15) {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.J, th15);
            n.a("alipaySdk", com.alipay.sdk.m.l.b.n, this.f5676a, this.f5681f);
            return new Pair<>(j, Boolean.TRUE);
        }
    }

    public void a() {
        this.f5676a = null;
        this.f5680e = null;
    }
}
