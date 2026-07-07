package cn.admobiletop.adsuyi.oaid.a;

import adsuyi.com.samsung.android.deviceidservice.IDeviceIdService;
import android.os.IBinder;
import cn.admobiletop.adsuyi.oaid.a.u;

/* JADX INFO: loaded from: classes.dex */
public class x implements u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f4335a;

    public x(y yVar) {
        this.f4335a = yVar;
    }

    @Override // cn.admobiletop.adsuyi.oaid.a.u.a
    public String a(IBinder iBinder) {
        IDeviceIdService iDeviceIdServiceAsInterface = IDeviceIdService.Stub.asInterface(iBinder);
        if (iDeviceIdServiceAsInterface != null) {
            return iDeviceIdServiceAsInterface.getOAID();
        }
        throw new cn.admobiletop.adsuyi.oaid.c("IDeviceIdService is null");
    }
}
