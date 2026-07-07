package a.a.q;

import android.os.RemoteException;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import anetwork.channel.aidl.DefaultFinishEvent;
import anetwork.channel.aidl.ParcelableNetworkListener;
import anetwork.channel.aidl.adapter.ParcelableInputStreamImpl;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c implements a.a.s.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ParcelableNetworkListener f197a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f198b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ParcelableInputStreamImpl f199c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f200d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f201e;

    public c(ParcelableNetworkListener parcelableNetworkListener, g gVar) {
        this.f200d = false;
        this.f201e = null;
        this.f197a = parcelableNetworkListener;
        this.f201e = gVar;
        if (parcelableNetworkListener != null) {
            try {
                if ((parcelableNetworkListener.getListenerState() & 8) != 0) {
                    this.f200d = true;
                }
            } catch (RemoteException unused) {
            }
        }
    }

    public final void b(Runnable runnable) {
        if (this.f201e.c()) {
            runnable.run();
        } else {
            String str = this.f198b;
            a.a(str != null ? str.hashCode() : hashCode(), runnable);
        }
    }

    @Override // a.a.s.a
    public void onDataReceiveSize(int i2, int i3, ByteArray byteArray) {
        ParcelableNetworkListener parcelableNetworkListener = this.f197a;
        if (parcelableNetworkListener != null) {
            b(new e(this, i2, byteArray, i3, parcelableNetworkListener));
        }
    }

    @Override // a.a.s.a
    public void onFinish(DefaultFinishEvent defaultFinishEvent) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.Repeater", "[onFinish] ", this.f198b, new Object[0]);
        }
        ParcelableNetworkListener parcelableNetworkListener = this.f197a;
        if (parcelableNetworkListener != null) {
            f fVar = new f(this, defaultFinishEvent, parcelableNetworkListener);
            RequestStatistic requestStatistic = defaultFinishEvent.f740e;
            if (requestStatistic != null) {
                requestStatistic.rspCbDispatch = System.currentTimeMillis();
            }
            b(fVar);
        }
        this.f197a = null;
    }

    @Override // a.a.s.a
    public void onResponseCode(int i2, Map<String, List<String>> map) {
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.Repeater", "[onResponseCode]", this.f198b, new Object[0]);
        }
        ParcelableNetworkListener parcelableNetworkListener = this.f197a;
        if (parcelableNetworkListener != null) {
            b(new d(this, parcelableNetworkListener, i2, map));
        }
    }

    public void a(String str) {
        this.f198b = str;
    }
}
