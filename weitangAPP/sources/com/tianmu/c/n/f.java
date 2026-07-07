package com.tianmu.c.n;

import android.content.Context;
import android.text.TextUtils;
import com.tianmu.api.iinterface.IAdmApiAd;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static f f11848f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IAdmApiAd f11849a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11852d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11850b = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.tianmu.api.iinterface.a f11853e = new a();

    public class a extends com.tianmu.a.b.b {
        public a() {
        }

        @Override // com.tianmu.api.iinterface.a
        public void a(ClassLoader classLoader) {
            try {
                Class<?> clsLoadClass = classLoader.loadClass(f.this.f11851c);
                f.this.f11849a = (IAdmApiAd) clsLoadClass.newInstance();
                f.this.f11849a.init(f.this.f11852d);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private f() {
    }

    public static f b() {
        if (f11848f == null) {
            synchronized (f.class) {
                if (f11848f == null) {
                    f11848f = new f();
                }
            }
        }
        return f11848f;
    }

    public void a(Context context, String str, String str2, boolean z) {
        if (this.f11850b || context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f11851c = str2;
        this.f11850b = true;
        this.f11852d = z;
        this.f11853e.a(context, str);
    }

    public IAdmApiAd a() {
        return this.f11849a;
    }
}
