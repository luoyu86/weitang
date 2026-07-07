package cn.admobiletop.adsuyi.oaid.a;

import adsuyi.com.asus.msa.SupplementaryDID.IDidAidlInterface;
import android.os.IBinder;
import cn.admobiletop.adsuyi.oaid.a.u;

/* JADX INFO: renamed from: cn.admobiletop.adsuyi.oaid.a.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0339a implements u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f4307a;

    public C0339a(b bVar) {
        this.f4307a = bVar;
    }

    @Override // cn.admobiletop.adsuyi.oaid.a.u.a
    public String a(IBinder iBinder) {
        IDidAidlInterface iDidAidlInterfaceAsInterface = IDidAidlInterface.Stub.asInterface(iBinder);
        if (iDidAidlInterfaceAsInterface == null) {
            throw new cn.admobiletop.adsuyi.oaid.c("IDidAidlInterface is null");
        }
        if (iDidAidlInterfaceAsInterface.isSupport()) {
            return iDidAidlInterfaceAsInterface.getOAID();
        }
        throw new cn.admobiletop.adsuyi.oaid.c("IDidAidlInterface#isSupport return false");
    }
}
