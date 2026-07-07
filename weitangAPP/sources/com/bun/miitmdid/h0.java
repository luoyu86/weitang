package com.bun.miitmdid;

import android.content.Context;
import com.bun.lib.MsaIdInterface;

/* JADX INFO: loaded from: classes.dex */
public class h0 extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f5863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e0 f5865c;

    public class a implements f0 {
        public a() {
        }

        @Override // com.bun.miitmdid.f0
        public native void a(MsaIdInterface msaIdInterface);
    }

    public h0(Context context) {
        j0.c("ZteProvider", "ZteProvider(Context)");
        this.f5863a = context;
        this.f5864b = context.getPackageName();
        try {
            if (context.getPackageManager().getPackageInfo("com.mdid.msa", 0) == null) {
                j0.d("ZteProvider", "Constructor: getPackageInfo is null");
                throw new NullPointerException("Constructor: getPackageInfo is null");
            }
        } catch (Exception unused) {
            j0.d("ZteProvider", "Constructor: MsaService not found");
        }
        try {
            e0.a(this.f5863a, this.f5864b);
            j0.c("ZteProvider", "Constructor: MsaService start success");
        } catch (Exception e2) {
            j0.b("ZteProvider", "Constructor: MsaService start Exception: " + e2.getMessage());
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        j0.c("ZteProvider", "doStart()");
        try {
            this.f5863a = checkContext(this.f5863a);
            doAsyncCallBefore();
            e0 e0Var = new e0(this.f5863a, new a());
            this.f5865c = e0Var;
            e0Var.a(this.f5864b);
            j0.c("ZteProvider", "doStart: BindService success");
            doAsyncCallAfter();
        } catch (Exception e2) {
            j0.d("ZteProvider", "doStart: Exception: " + e2.getMessage());
            cleanCache();
            onSupportCache();
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void shutDown() {
        e0 e0Var = this.f5865c;
        if (e0Var != null) {
            e0Var.e();
        }
    }
}
