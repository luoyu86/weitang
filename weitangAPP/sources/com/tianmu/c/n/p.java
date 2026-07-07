package com.tianmu.c.n;

import android.content.Context;
import android.text.TextUtils;
import com.tianmu.biz.dr.IUnifiedAd;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static p f11909e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IUnifiedAd f11910a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11912c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11911b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.tianmu.f.b.a f11913d = new a();

    public class a extends com.tianmu.f.c.a {
        public a() {
        }

        @Override // com.tianmu.f.b.a
        public void a(ClassLoader classLoader) {
            try {
                Class<?> clsLoadClass = classLoader.loadClass(p.this.f11912c);
                p.this.f11910a = (IUnifiedAd) clsLoadClass.newInstance();
                p.this.f11910a.init();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private p() {
    }

    public static p b() {
        if (f11909e == null) {
            synchronized (p.class) {
                if (f11909e == null) {
                    f11909e = new p();
                }
            }
        }
        return f11909e;
    }

    public void a(Context context, String str, String str2) {
        IUnifiedAd iUnifiedAd;
        if (!this.f11911b && context != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.f11912c = str2;
            this.f11911b = true;
            this.f11913d.a(context, str);
        } else {
            if (!this.f11911b || (iUnifiedAd = this.f11910a) == null) {
                return;
            }
            iUnifiedAd.init();
        }
    }

    public IUnifiedAd a() {
        return this.f11910a;
    }
}
