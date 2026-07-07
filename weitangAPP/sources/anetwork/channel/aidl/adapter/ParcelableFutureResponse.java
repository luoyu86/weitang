package anetwork.channel.aidl.adapter;

import a.a.l;
import android.os.RemoteException;
import anet.channel.util.ALog;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.NetworkResponse;
import anetwork.channel.aidl.ParcelableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ParcelableFutureResponse extends ParcelableFuture.Stub {
    private static final String TAG = "anet.ParcelableFutureResponse";
    public Future<l> future;
    public NetworkResponse response;

    public ParcelableFutureResponse(Future<l> future) {
        this.future = future;
    }

    @Override // anetwork.channel.aidl.ParcelableFuture
    public boolean cancel(boolean z) throws RemoteException {
        Future<l> future = this.future;
        if (future == null) {
            return true;
        }
        return future.cancel(z);
    }

    @Override // anetwork.channel.aidl.ParcelableFuture
    public NetworkResponse get(long j) throws RemoteException {
        Future<l> future = this.future;
        if (future == null) {
            NetworkResponse networkResponse = this.response;
            return networkResponse != null ? networkResponse : new NetworkResponse(ErrorConstant.ERROR_REQUEST_FAIL);
        }
        try {
            return (NetworkResponse) future.get(j, TimeUnit.MILLISECONDS);
        } catch (Exception e2) {
            if ("NO SUPPORT".equalsIgnoreCase(e2.getMessage())) {
                ALog.e(TAG, "[get]有listener将不支持future.get()方法，如有需要请listener传入null", null, e2, new Object[0]);
            }
            return new NetworkResponse(ErrorConstant.ERROR_REQUEST_FAIL);
        }
    }

    @Override // anetwork.channel.aidl.ParcelableFuture
    public boolean isCancelled() throws RemoteException {
        Future<l> future = this.future;
        if (future == null) {
            return true;
        }
        return future.isCancelled();
    }

    @Override // anetwork.channel.aidl.ParcelableFuture
    public boolean isDone() throws RemoteException {
        Future<l> future = this.future;
        if (future == null) {
            return true;
        }
        return future.isDone();
    }
}
