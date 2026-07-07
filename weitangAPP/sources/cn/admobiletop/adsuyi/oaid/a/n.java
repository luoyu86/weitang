package cn.admobiletop.adsuyi.oaid.a;

import adsuyi.com.zui.deviceidservice.IDeviceidInterface;
import android.os.IBinder;
import cn.admobiletop.adsuyi.oaid.a.u;

/* JADX INFO: loaded from: classes.dex */
public class n implements u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o f4322a;

    public n(o oVar) {
        this.f4322a = oVar;
    }

    @Override // cn.admobiletop.adsuyi.oaid.a.u.a
    public String a(IBinder iBinder) {
        IDeviceidInterface iDeviceidInterfaceAsInterface = IDeviceidInterface.Stub.asInterface(iBinder);
        if (iDeviceidInterfaceAsInterface == null) {
            throw new cn.admobiletop.adsuyi.oaid.c("IDeviceidInterface is null");
        }
        if (iDeviceidInterfaceAsInterface.isSupport()) {
            return iDeviceidInterfaceAsInterface.getOAID();
        }
        throw new cn.admobiletop.adsuyi.oaid.c("IDeviceidInterface#isSupport return false");
    }
}
