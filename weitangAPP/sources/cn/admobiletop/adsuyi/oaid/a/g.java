package cn.admobiletop.adsuyi.oaid.a;

import adsuyi.com.android.creator.IdsSupplier;
import android.os.IBinder;
import cn.admobiletop.adsuyi.oaid.a.u;

/* JADX INFO: loaded from: classes.dex */
public class g implements u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f4313a;

    public g(h hVar) {
        this.f4313a = hVar;
    }

    @Override // cn.admobiletop.adsuyi.oaid.a.u.a
    public String a(IBinder iBinder) {
        IdsSupplier idsSupplierAsInterface = IdsSupplier.Stub.asInterface(iBinder);
        if (idsSupplierAsInterface != null) {
            return idsSupplierAsInterface.getOAID();
        }
        throw new cn.admobiletop.adsuyi.oaid.c("IdsSupplier is null");
    }
}
