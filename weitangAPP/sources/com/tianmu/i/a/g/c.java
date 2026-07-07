package com.tianmu.i.a.g;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class c implements com.tianmu.i.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f12213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final KeyguardManager f12214b;

    public c(Context context) {
        this.f12213a = context;
        this.f12214b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.tianmu.i.a.c
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f12213a == null || (keyguardManager = this.f12214b) == null) {
            return false;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.f12214b, new Object[0]);
            Objects.requireNonNull(objInvoke);
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
            return false;
        }
    }

    @Override // com.tianmu.i.a.c
    public void a(com.tianmu.i.a.b bVar) {
        if (this.f12213a == null || bVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.f12214b;
        if (keyguardManager == null) {
            bVar.a(new com.tianmu.i.a.d("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.f12214b, new Object[0]);
            if (objInvoke != null) {
                String string = objInvoke.toString();
                com.tianmu.i.a.e.a("OAID obtain success: " + string);
                bVar.a(string);
                return;
            }
            throw new com.tianmu.i.a.d("OAID obtain failed");
        } catch (Exception e2) {
            com.tianmu.i.a.e.a(e2);
        }
    }
}
