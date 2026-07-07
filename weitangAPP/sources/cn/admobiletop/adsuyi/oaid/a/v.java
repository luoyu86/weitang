package cn.admobiletop.adsuyi.oaid.a;

import android.os.IBinder;
import android.os.RemoteException;
import cn.admobiletop.adsuyi.oaid.a.u;

/* JADX INFO: loaded from: classes.dex */
public class v implements u.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f4332a;

    public v(w wVar) {
        this.f4332a = wVar;
    }

    @Override // cn.admobiletop.adsuyi.oaid.a.u.a
    public String a(IBinder iBinder) throws RemoteException {
        try {
            return this.f4332a.a(iBinder);
        } catch (RemoteException e2) {
            throw e2;
        } catch (cn.admobiletop.adsuyi.oaid.c e3) {
            throw e3;
        } catch (Exception e4) {
            throw new cn.admobiletop.adsuyi.oaid.c(e4);
        }
    }
}
