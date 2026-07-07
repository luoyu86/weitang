package cn.admobiletop.adsuyi.oaid.a;

import adsuyi.com.bun.lib.MsaIdInterface;
import android.os.IBinder;
import cn.admobiletop.adsuyi.oaid.a.u;

/* JADX INFO: loaded from: classes.dex */
public class q implements u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r f4325a;

    public q(r rVar) {
        this.f4325a = rVar;
    }

    @Override // cn.admobiletop.adsuyi.oaid.a.u.a
    public String a(IBinder iBinder) {
        MsaIdInterface msaIdInterfaceAsInterface = MsaIdInterface.Stub.asInterface(iBinder);
        if (msaIdInterfaceAsInterface == null) {
            throw new cn.admobiletop.adsuyi.oaid.c("MsaIdInterface is null");
        }
        if (msaIdInterfaceAsInterface.isSupported()) {
            return msaIdInterfaceAsInterface.getOAID();
        }
        throw new cn.admobiletop.adsuyi.oaid.c("MsaIdInterface#isSupported return false");
    }
}
