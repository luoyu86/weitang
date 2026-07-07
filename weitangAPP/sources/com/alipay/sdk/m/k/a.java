package com.alipay.sdk.m.k;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.m.u.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: com.alipay.sdk.m.k.a$a, reason: collision with other inner class name */
    public static final class C0078a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f5414a = "RecordPref";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f5415b = "alipay_cashier_statistic_record";

        public static synchronized String a(Context context, String str, String str2) {
            com.alipay.sdk.m.u.e.b(f5414a, "stat append " + str2 + " , " + str);
            if (context != null && !TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = UUID.randomUUID().toString();
                }
                C0079a c0079aA = a(context);
                if (c0079aA.f5416a.size() > 20) {
                    c0079aA.f5416a.clear();
                }
                c0079aA.f5416a.put(str2, str);
                a(context, c0079aA);
                return str2;
            }
            return null;
        }

        public static synchronized String b(Context context) {
            com.alipay.sdk.m.u.e.b(f5414a, "stat peek");
            if (context == null) {
                return null;
            }
            C0079a c0079aA = a(context);
            if (c0079aA.f5416a.isEmpty()) {
                return null;
            }
            try {
                return c0079aA.f5416a.entrySet().iterator().next().getValue();
            } catch (Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
                return null;
            }
        }

        /* JADX INFO: renamed from: com.alipay.sdk.m.k.a$a$a, reason: collision with other inner class name */
        public static final class C0079a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final LinkedHashMap<String, String> f5416a = new LinkedHashMap<>();

            public C0079a() {
            }

            public String a() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, String> entry : this.f5416a.entrySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(entry.getKey()).put(entry.getValue());
                        jSONArray.put(jSONArray2);
                    }
                    return jSONArray.toString();
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                    return new JSONArray().toString();
                }
            }

            public C0079a(String str) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i2);
                        this.f5416a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                }
            }
        }

        public static synchronized int a(Context context, String str) {
            com.alipay.sdk.m.u.e.b(f5414a, "stat remove " + str);
            if (context != null && !TextUtils.isEmpty(str)) {
                C0079a c0079aA = a(context);
                if (c0079aA.f5416a.isEmpty()) {
                    return 0;
                }
                try {
                    ArrayList arrayList = new ArrayList();
                    for (Map.Entry<String, String> entry : c0079aA.f5416a.entrySet()) {
                        if (str.equals(entry.getValue())) {
                            arrayList.add(entry.getKey());
                        }
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        c0079aA.f5416a.remove((String) it.next());
                    }
                    a(context, c0079aA);
                    return arrayList.size();
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                    int size = c0079aA.f5416a.size();
                    a(context, new C0079a());
                    return size;
                }
            }
            return 0;
        }

        public static synchronized C0079a a(Context context) {
            try {
                String strA = j.a(null, context, f5415b, null);
                if (TextUtils.isEmpty(strA)) {
                    return new C0079a();
                }
                return new C0079a(strA);
            } catch (Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
                return new C0079a();
            }
        }

        public static synchronized void a(Context context, C0079a c0079a) {
            if (c0079a == null) {
                try {
                    c0079a = new C0079a();
                } catch (Throwable th) {
                    com.alipay.sdk.m.u.e.a(th);
                }
            }
            j.b(null, context, f5415b, c0079a.a());
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: com.alipay.sdk.m.k.a$b$a, reason: collision with other inner class name */
        public static class RunnableC0080a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f5417a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Context f5418b;

            public RunnableC0080a(String str, Context context) {
                this.f5417a = str;
                this.f5418b = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f5417a) || b.b(this.f5418b, this.f5417a)) {
                    for (int i2 = 0; i2 < 4; i2++) {
                        String strB = C0078a.b(this.f5418b);
                        if (TextUtils.isEmpty(strB) || !b.b(this.f5418b, strB)) {
                            return;
                        }
                    }
                }
            }
        }

        public static synchronized boolean b(Context context, String str) {
            com.alipay.sdk.m.u.e.b(com.alipay.sdk.m.l.a.A, "stat sub " + str);
            try {
                if ((com.alipay.sdk.m.m.a.D().e() ? new com.alipay.sdk.m.q.d() : new com.alipay.sdk.m.q.e()).a((com.alipay.sdk.m.s.a) null, context, str) == null) {
                    return false;
                }
                C0078a.a(context, str);
                return true;
            } catch (Throwable th) {
                com.alipay.sdk.m.u.e.a(th);
                return false;
            }
        }

        public static synchronized void a(Context context, com.alipay.sdk.m.k.b bVar, String str, String str2) {
            if (context == null || bVar == null || str == null) {
                return;
            }
            a(context, bVar.a(str), str2);
        }

        public static synchronized void a(Context context) {
            a(context, null, null);
        }

        public static synchronized void a(Context context, String str, String str2) {
            if (context == null) {
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                C0078a.a(context, str, str2);
            }
            new Thread(new RunnableC0080a(str, context)).start();
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f5419a = "alipay_cashier_ap_seq_v";

        public static synchronized long a(Context context) {
            return d.a(context, f5419a);
        }
    }

    public static final class d {
        public static synchronized long a(Context context, String str) {
            long j;
            String strA;
            try {
                strA = j.a(null, context, str, null);
            } catch (Throwable unused) {
            }
            j = (!TextUtils.isEmpty(strA) ? Long.parseLong(strA) : 0L) + 1;
            try {
                j.b(null, context, str, Long.toString(j));
            } catch (Throwable unused2) {
            }
            return j;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f5420a = "alipay_cashier_statistic_v";

        public static synchronized long a(Context context) {
            return d.a(context, f5420a);
        }
    }

    public static synchronized void a(Context context, com.alipay.sdk.m.s.a aVar, String str, String str2) {
        if (context == null || aVar == null) {
            return;
        }
        try {
            C0078a.a(context, aVar.l.a(str), str2);
        } catch (Throwable th) {
            com.alipay.sdk.m.u.e.a(th);
        }
    }

    public static synchronized void b(Context context, com.alipay.sdk.m.s.a aVar, String str, String str2) {
        if (context == null || aVar == null) {
            return;
        }
        b.a(context, aVar.l, str, str2);
    }

    public static void b(com.alipay.sdk.m.s.a aVar, String str, String str2, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.l.b(str, str2, str3);
    }

    public static synchronized void a(Context context) {
        b.a(context);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, Throwable th) {
        if (aVar == null || th == null || th.getClass() == null) {
            return;
        }
        aVar.l.a(str, th.getClass().getSimpleName(), th);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2, Throwable th, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2, th, str3);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2, Throwable th) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2, th);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2, str3);
    }

    public static void a(com.alipay.sdk.m.s.a aVar, String str, String str2) {
        if (aVar == null) {
            return;
        }
        aVar.l.a(str, str2);
    }
}
