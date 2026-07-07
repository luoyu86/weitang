package cn.admobiletop.adsuyi.a.l;

import android.content.Context;
import android.text.TextUtils;
import cn.admobiletop.adsuyi.ADSuyiSdk;

/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static q f3425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f3427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f3428d;

    public static q c() {
        if (f3425a == null) {
            synchronized (q.class) {
                if (f3425a == null) {
                    f3425a = new q();
                }
            }
        }
        return f3425a;
    }

    public String a() {
        String strB = k.d().b();
        if (!TextUtils.isEmpty(strB)) {
            return strB;
        }
        if (!TextUtils.isEmpty(this.f3426b)) {
            return this.f3426b;
        }
        String strA = r.a();
        if (TextUtils.isEmpty(strA)) {
            return "";
        }
        this.f3426b = strA;
        return strA;
    }

    public String b() {
        String strC = k.d().c();
        if (!TextUtils.isEmpty(strC)) {
            return strC;
        }
        if (!TextUtils.isEmpty(this.f3427c)) {
            return this.f3427c;
        }
        String strB = r.b();
        if (TextUtils.isEmpty(strB)) {
            return "";
        }
        this.f3427c = strB;
        return strB;
    }

    public String d() {
        String strF = k.d().f();
        if (!TextUtils.isEmpty(strF)) {
            return strF;
        }
        if (!TextUtils.isEmpty(this.f3428d)) {
            return this.f3428d;
        }
        String strC = r.c();
        if (TextUtils.isEmpty(strC)) {
            return "";
        }
        this.f3428d = strC;
        return strC;
    }

    public void e() {
        f();
        g();
    }

    public final void f() {
        b.b().f();
    }

    public final void g() {
        Context context = ADSuyiSdk.getInstance().getContext();
        if (context != null) {
            k.d().d(context);
        }
    }
}
