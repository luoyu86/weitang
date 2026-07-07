package cn.admobiletop.adsuyi.oaid.a;

import adsuyi.com.hihonor.cloudservice.oaid.b;
import android.os.IBinder;
import android.os.IInterface;
import cn.admobiletop.adsuyi.oaid.a.u;

/* JADX INFO: loaded from: classes.dex */
public class j implements u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k f4316a;

    public j(k kVar) {
        this.f4316a = kVar;
    }

    @Override // cn.admobiletop.adsuyi.oaid.a.u.a
    public String a(IBinder iBinder) {
        adsuyi.com.hihonor.cloudservice.oaid.b internalStub;
        if (iBinder == null) {
            internalStub = null;
        } else {
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.hihonor.cloudservice.oaid.IOAIDService");
                internalStub = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof adsuyi.com.hihonor.cloudservice.oaid.b)) ? new b.Stub.InternalStub(iBinder) : (adsuyi.com.hihonor.cloudservice.oaid.b) iInterfaceQueryLocalInterface;
            } catch (Exception e2) {
                cn.admobiletop.adsuyi.oaid.d.a("onServiceConnected error:" + e2.getMessage());
            }
        }
        internalStub.b(new i(this));
        return this.f4316a.f4318b;
    }
}
