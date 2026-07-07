package anetwork.channel.aidl.adapter;

import a.a.b;
import android.os.RemoteException;
import anetwork.channel.aidl.ParcelableBodyHandler;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableBodyHandlerWrapper extends ParcelableBodyHandler.Stub {
    private static final String TAG = "anet.ParcelableBodyHandlerWrapper";
    private b handler;

    public ParcelableBodyHandlerWrapper(b bVar) {
        this.handler = bVar;
    }

    @Override // anetwork.channel.aidl.ParcelableBodyHandler
    public boolean isCompleted() throws RemoteException {
        b bVar = this.handler;
        if (bVar != null) {
            return bVar.isCompleted();
        }
        return true;
    }

    @Override // anetwork.channel.aidl.ParcelableBodyHandler
    public int read(byte[] bArr) throws RemoteException {
        b bVar = this.handler;
        if (bVar != null) {
            return bVar.read(bArr);
        }
        return 0;
    }

    public String toString() {
        return super.toString() + " handle:" + this.handler;
    }
}
