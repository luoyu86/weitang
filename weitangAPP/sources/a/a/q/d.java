package a.a.q;

import android.os.RemoteException;
import anetwork.channel.aidl.ParcelableHeader;
import anetwork.channel.aidl.ParcelableNetworkListener;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ParcelableNetworkListener f202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ c f205d;

    public d(c cVar, ParcelableNetworkListener parcelableNetworkListener, int i2, Map map) {
        this.f205d = cVar;
        this.f202a = parcelableNetworkListener;
        this.f203b = i2;
        this.f204c = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f202a.onResponseCode(this.f203b, new ParcelableHeader(this.f203b, this.f204c));
        } catch (RemoteException unused) {
        }
    }
}
