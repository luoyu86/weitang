package cn.admobiletop.adsuyi.oaid.a;

import adsuyi.com.coolpad.deviceidsupport.IDeviceIdManager;
import android.os.IBinder;
import cn.admobiletop.adsuyi.oaid.a.u;

/* JADX INFO: loaded from: classes.dex */
public class c implements u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4309a;

    public c(d dVar) {
        this.f4309a = dVar;
    }

    @Override // cn.admobiletop.adsuyi.oaid.a.u.a
    public String a(IBinder iBinder) {
        IDeviceIdManager iDeviceIdManagerAsInterface = IDeviceIdManager.Stub.asInterface(iBinder);
        if (iDeviceIdManagerAsInterface != null) {
            return iDeviceIdManagerAsInterface.getOAID(this.f4309a.f4310a.getPackageName());
        }
        throw new cn.admobiletop.adsuyi.oaid.c("IDeviceIdManager is null");
    }
}
