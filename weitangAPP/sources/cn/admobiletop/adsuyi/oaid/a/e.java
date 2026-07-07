package cn.admobiletop.adsuyi.oaid.a;

import android.app.KeyguardManager;
import android.content.Context;
import cn.admobiletop.adsuyi.oaid.IGetter;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class e implements cn.admobiletop.adsuyi.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KeyguardManager f4312b;

    public e(Context context) {
        this.f4311a = context;
        this.f4312b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.f4311a == null || (keyguardManager = this.f4312b) == null) {
            return false;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.f4312b, new Object[0]);
            Objects.requireNonNull(objInvoke);
            return ((Boolean) objInvoke).booleanValue();
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
            return false;
        }
    }

    @Override // cn.admobiletop.adsuyi.oaid.b
    public void a(IGetter iGetter) {
        if (this.f4311a == null || iGetter == null) {
            return;
        }
        KeyguardManager keyguardManager = this.f4312b;
        if (keyguardManager == null) {
            iGetter.onOAIDGetError(new cn.admobiletop.adsuyi.oaid.c("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.f4312b, new Object[0]);
            if (objInvoke != null) {
                String string = objInvoke.toString();
                StringBuilder sb = new StringBuilder();
                sb.append("OAID obtain success: ");
                sb.append(string);
                cn.admobiletop.adsuyi.oaid.d.a(sb.toString());
                iGetter.onOAIDGetComplete(string);
                return;
            }
            throw new cn.admobiletop.adsuyi.oaid.c("OAID obtain failed");
        } catch (Exception e2) {
            cn.admobiletop.adsuyi.oaid.d.a(e2);
        }
    }
}
