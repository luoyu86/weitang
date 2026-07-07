package com.tianmu.i.a.g;

import android.annotation.SuppressLint;
import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public class q implements com.tianmu.i.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class<?> f12236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f12237c;

    @SuppressLint({"PrivateApi"})
    public q(Context context) {
        this.f12235a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f12236b = cls;
            this.f12237c = cls.newInstance();
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
        }
    }

    private String b() {
        return (String) this.f12236b.getMethod("getOAID", Context.class).invoke(this.f12237c, this.f12235a);
    }

    @Override // com.tianmu.i.a.c
    public boolean a() {
        return this.f12237c != null;
    }

    @Override // com.tianmu.i.a.c
    public void a(com.tianmu.i.a.b bVar) {
        if (this.f12235a == null || bVar == null) {
            return;
        }
        if (this.f12236b == null || this.f12237c == null) {
            bVar.a(new com.tianmu.i.a.d("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String strB = b();
            if (strB == null || strB.length() == 0) {
                throw new com.tianmu.i.a.d("OAID query failed");
            }
            com.tianmu.i.a.e.a("OAID query success: " + strB);
            bVar.a(strB);
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
            bVar.a(e2);
        }
    }
}
