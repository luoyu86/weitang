package cn.admobiletop.adsuyi.oaid.a;

import android.annotation.SuppressLint;
import android.content.Context;
import cn.admobiletop.adsuyi.oaid.IGetter;

/* JADX INFO: loaded from: classes.dex */
public class A implements cn.admobiletop.adsuyi.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Class<?> f4305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f4306c;

    @SuppressLint({"PrivateApi"})
    public A(Context context) {
        this.f4304a = context;
        try {
            Class<?> cls = Class.forName("com.android.id.impl.IdProviderImpl");
            this.f4305b = cls;
            this.f4306c = cls.newInstance();
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
        }
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public boolean a() {
        return this.f4306c != null;
    }

    public final String b() {
        return (String) this.f4305b.getMethod("getOAID", Context.class).invoke(this.f4306c, this.f4304a);
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public void a(IGetter iGetter) {
        if (this.f4304a == null || iGetter == null) {
            return;
        }
        if (this.f4305b == null || this.f4306c == null) {
            iGetter.onOAIDGetError(new cn.admobiletop.adsuyi.oaid.c("Xiaomi IdProvider not exists"));
            return;
        }
        try {
            String strB = b();
            if (strB == null || strB.length() == 0) {
                throw new cn.admobiletop.adsuyi.oaid.c("OAID query failed");
            }
            StringBuilder sb = new StringBuilder();
            sb.append("OAID query success: ");
            sb.append(strB);
            cn.admobiletop.adsuyi.oaid.d.a(sb.toString());
            iGetter.onOAIDGetComplete(strB);
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
            iGetter.onOAIDGetError(e2);
        }
    }
}
