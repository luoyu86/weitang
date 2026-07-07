package com.tianmu.c.n;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static m f11887d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f11889b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, com.tianmu.c.i.c> f11888a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f11890c = new Handler(Looper.getMainLooper());

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f11891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.tianmu.c.i.c f11892b;

        public a(m mVar, String str, com.tianmu.c.i.c cVar) {
            this.f11891a = str;
            this.f11892b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tianmu.c.i.c cVar;
            if (!b.a().b(this.f11891a) || (cVar = this.f11892b) == null || cVar.L()) {
                return;
            }
            j.b().a(this.f11892b.l(), false);
            this.f11892b.c(true);
        }
    }

    private m() {
    }

    public static m b() {
        if (f11887d == null) {
            synchronized (m.class) {
                if (f11887d == null) {
                    f11887d = new m();
                }
            }
        }
        return f11887d;
    }

    public void a(com.tianmu.c.i.c cVar) {
        if (cVar != null) {
            this.f11888a.put(cVar.u(), cVar);
        }
    }

    public void a(String str) {
    }

    public void c(String str) {
        this.f11889b = 0L;
        try {
            this.f11888a.remove(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean a(Context context, String str, String str2) {
        try {
            com.tianmu.c.i.c cVar = this.f11888a.get(str2);
            if (cVar != null && !cVar.M()) {
                j.b().a(cVar.k(), false);
                cVar.d(true);
            }
            Uri uri = Uri.parse(str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
            intent.setFlags(805339136);
            context.startActivity(intent);
            c();
            this.f11890c.postDelayed(new a(this, str2, cVar), 3000L);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void c() {
        this.f11889b = System.currentTimeMillis();
    }

    public com.tianmu.c.i.c b(String str) {
        return this.f11888a.get(str);
    }

    public boolean a(Context context, String str) {
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(uri);
            intent.setFlags(805339136);
            context.startActivity(intent);
            c();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean a() {
        if (System.currentTimeMillis() - this.f11889b <= 5000) {
            return false;
        }
        c();
        return true;
    }
}
