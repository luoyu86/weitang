package cn.admobiletop.adsuyi.oaid.a;

import adsuyi.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
import android.os.IBinder;
import cn.admobiletop.adsuyi.oaid.a.u;

/* JADX INFO: loaded from: classes.dex */
public class l implements u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f4319a;

    public l(m mVar) {
        this.f4319a = mVar;
    }

    @Override // cn.admobiletop.adsuyi.oaid.a.u.a
    public String a(IBinder iBinder) {
        OpenDeviceIdentifierService openDeviceIdentifierServiceAsInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
        if (openDeviceIdentifierServiceAsInterface.isOaidTrackLimited()) {
            throw new cn.admobiletop.adsuyi.oaid.c("User has disabled advertising identifier");
        }
        return openDeviceIdentifierServiceAsInterface.getOaid();
    }
}
