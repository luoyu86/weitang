package cn.admobiletop.adsuyi.oaid.a;

import adsuyi.com.hihonor.cloudservice.oaid.a;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class i extends a.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j f4315a;

    public i(j jVar) {
        this.f4315a = jVar;
    }

    @Override // adsuyi.com.hihonor.cloudservice.oaid.a
    public void a(int i2, long j, boolean z, float f2, double d2, String str) {
    }

    @Override // adsuyi.com.hihonor.cloudservice.oaid.a
    public void a(int i2, Bundle bundle) {
        if (i2 == 0 && bundle != null) {
            this.f4315a.f4316a.f4318b = bundle.getString("oa_id_flag");
            cn.admobiletop.adsuyi.oaid.d.a("OAIDCallBack handleResult success");
        } else {
            cn.admobiletop.adsuyi.oaid.d.a("OAIDCallBack handleResult error retCode=$ " + i2);
        }
    }
}
