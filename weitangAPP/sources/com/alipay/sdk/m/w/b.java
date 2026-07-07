package com.alipay.sdk.m.w;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.ConditionVariable;
import android.text.TextUtils;
import com.alipay.apmobilesecuritysdk.face.APSecuritySdk;
import com.alipay.sdk.m.w.a;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b {

    public static class a implements a.InterfaceC0091a<Object, Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0091a
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    /* JADX INFO: renamed from: com.alipay.sdk.m.w.b$b, reason: collision with other inner class name */
    public static class CallableC0092b implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5734a;

        public CallableC0092b(Context context) {
            this.f5734a = context;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            return com.alipay.sdk.m.b.c.a(this.f5734a);
        }
    }

    public static class c implements a.InterfaceC0091a<Object, Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0091a
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof NetworkInfo) || obj == null);
        }
    }

    public static class d implements Callable<NetworkInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5735a;

        public d(Context context) {
            this.f5735a = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public NetworkInfo call() {
            return ((ConnectivityManager) this.f5735a.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        }
    }

    public static class e implements a.InterfaceC0091a<Object, Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0091a
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    public static class f implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f5736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.s.a f5737b;

        public f(Context context, com.alipay.sdk.m.s.a aVar) {
            this.f5736a = context;
            this.f5737b = aVar;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            try {
                return com.alipay.sdk.m.n0.a.c(this.f5736a);
            } catch (Throwable th) {
                com.alipay.sdk.m.k.a.b(this.f5737b, com.alipay.sdk.m.k.b.o, com.alipay.sdk.m.k.b.u, th.getClass().getName());
                return "";
            }
        }
    }

    public static class g implements a.InterfaceC0091a<Object, Boolean> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alipay.sdk.m.w.a.InterfaceC0091a
        public Boolean a(Object obj) {
            return Boolean.valueOf((obj instanceof String) || obj == null);
        }
    }

    public static class h implements Callable<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f5739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f5740c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.s.a f5741d;

        public class a implements APSecuritySdk.InitResultListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String[] f5742a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ConditionVariable f5743b;

            public a(String[] strArr, ConditionVariable conditionVariable) {
                this.f5742a = strArr;
                this.f5743b = conditionVariable;
            }

            @Override // com.alipay.apmobilesecuritysdk.face.APSecuritySdk.InitResultListener
            public void onResult(APSecuritySdk.TokenResult tokenResult) {
                if (tokenResult != null) {
                    this.f5742a[0] = tokenResult.apdidToken;
                }
                this.f5743b.open();
            }
        }

        public h(String str, String str2, Context context, com.alipay.sdk.m.s.a aVar) {
            this.f5738a = str;
            this.f5739b = str2;
            this.f5740c = context;
            this.f5741d = aVar;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            HashMap map = new HashMap();
            map.put("tid", this.f5738a);
            map.put("utdid", this.f5739b);
            String[] strArr = {""};
            try {
                APSecuritySdk aPSecuritySdk = APSecuritySdk.getInstance(this.f5740c);
                ConditionVariable conditionVariable = new ConditionVariable();
                aPSecuritySdk.initToken(0, map, new a(strArr, conditionVariable));
                conditionVariable.block(3000L);
            } catch (Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
                com.alipay.sdk.m.k.a.b(this.f5741d, com.alipay.sdk.m.k.b.o, com.alipay.sdk.m.k.b.r, th.getClass().getName());
            }
            if (TextUtils.isEmpty(strArr[0])) {
                com.alipay.sdk.m.k.a.b(this.f5741d, com.alipay.sdk.m.k.b.o, com.alipay.sdk.m.k.b.s, "missing token");
            }
            return strArr[0];
        }
    }

    public static NetworkInfo a(com.alipay.sdk.m.s.a aVar, Context context) {
        Context contextA = com.alipay.sdk.m.w.a.a(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (NetworkInfo) com.alipay.sdk.m.w.a.a(2, 10L, timeUnit, new c(), new d(contextA), false, 10L, timeUnit, aVar, false);
    }

    public static String b(com.alipay.sdk.m.s.a aVar, Context context) {
        if (!com.alipay.sdk.m.m.a.D().x()) {
            return "";
        }
        return (String) com.alipay.sdk.m.w.a.a(1, 1L, TimeUnit.DAYS, new a(), new CallableC0092b(com.alipay.sdk.m.w.a.a(context)), true, 200L, TimeUnit.MILLISECONDS, aVar, true);
    }

    public static String c(com.alipay.sdk.m.s.a aVar, Context context) {
        return (String) com.alipay.sdk.m.w.a.a(3, 1L, TimeUnit.DAYS, new e(), new f(com.alipay.sdk.m.w.a.a(context), aVar), true, 3L, TimeUnit.SECONDS, aVar, false);
    }

    public static String a(com.alipay.sdk.m.s.a aVar, Context context, String str, String str2) {
        Context contextA = com.alipay.sdk.m.w.a.a(context);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return (String) com.alipay.sdk.m.w.a.a(4, 10L, timeUnit, new g(), new h(str, str2, contextA, aVar), true, 3L, timeUnit, aVar, true);
    }
}
