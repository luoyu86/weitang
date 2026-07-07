package anetwork.channel.aidl;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import anet.channel.util.ALog;
import anetwork.channel.aidl.IRemoteNetworkGetter;
import anetwork.channel.aidl.RemoteNetwork;
import anetwork.channel.degrade.DegradableNetworkDelegate;
import anetwork.channel.http.HttpNetworkDelegate;

/* JADX INFO: loaded from: classes.dex */
public class NetworkService extends Service {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RemoteNetwork.Stub f755b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RemoteNetwork.Stub f756c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IRemoteNetworkGetter.Stub f757d = new IRemoteNetworkGetter.Stub() { // from class: anetwork.channel.aidl.NetworkService.1
        @Override // anetwork.channel.aidl.IRemoteNetworkGetter
        public RemoteNetwork get(int i2) throws RemoteException {
            return i2 == 1 ? NetworkService.this.f755b : NetworkService.this.f756c;
        }
    };

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        this.f754a = getApplicationContext();
        if (ALog.isPrintLog(2)) {
            ALog.i("anet.NetworkService", "onBind:" + intent.getAction(), null, new Object[0]);
        }
        this.f755b = new DegradableNetworkDelegate(this.f754a);
        this.f756c = new HttpNetworkDelegate(this.f754a);
        if (IRemoteNetworkGetter.class.getName().equals(intent.getAction())) {
            return this.f757d;
        }
        return null;
    }

    @Override // android.app.Service
    public void onDestroy() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return 2;
    }
}
