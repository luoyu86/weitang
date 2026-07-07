package a.a.q;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anetwork.channel.aidl.DefaultProgressEvent;
import anetwork.channel.aidl.ParcelableNetworkListener;
import anetwork.channel.aidl.adapter.ParcelableInputStreamImpl;

/* JADX INFO: loaded from: classes.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ByteArray f207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ParcelableNetworkListener f209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ c f210e;

    public e(c cVar, int i2, ByteArray byteArray, int i3, ParcelableNetworkListener parcelableNetworkListener) {
        this.f210e = cVar;
        this.f206a = i2;
        this.f207b = byteArray;
        this.f208c = i3;
        this.f209d = parcelableNetworkListener;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f210e.f200d) {
                try {
                    if (this.f210e.f199c == null) {
                        this.f210e.f199c = new ParcelableInputStreamImpl();
                        this.f210e.f199c.init(this.f210e.f201e, this.f208c);
                        this.f210e.f199c.write(this.f207b);
                        this.f209d.onInputStreamGet(this.f210e.f199c);
                    } else {
                        this.f210e.f199c.write(this.f207b);
                    }
                } catch (Exception unused) {
                    if (this.f210e.f199c == null) {
                    } else {
                        this.f210e.f199c.close();
                    }
                }
            } else {
                this.f209d.onDataReceived(new DefaultProgressEvent(this.f206a, this.f207b.getDataLength(), this.f208c, this.f207b.getBuffer()));
            }
        } catch (RemoteException unused2) {
        }
    }
}
