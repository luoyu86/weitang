package anetwork.channel.aidl.adapter;

import a.a.c;
import a.a.d;
import a.a.f;
import a.a.q.g;
import a.a.v.a;
import android.os.Build;
import android.os.RemoteException;
import anet.channel.util.ErrorConstant;
import anetwork.channel.aidl.Connection;
import anetwork.channel.aidl.ParcelableFuture;
import anetwork.channel.aidl.ParcelableInputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionDelegate extends Connection.Stub implements c, d, f {
    private g config;
    private String desc;
    private ParcelableFuture future;
    private Map<String, List<String>> header;
    private ParcelableInputStreamImpl inputStream;
    private a statisticData;
    private int statusCode;
    private CountDownLatch statusLatch = new CountDownLatch(1);
    private CountDownLatch streamLatch = new CountDownLatch(1);

    public ConnectionDelegate(int i2) {
        this.statusCode = i2;
        this.desc = ErrorConstant.getErrMsg(i2);
    }

    private RemoteException buildRemoteException(String str) {
        return Build.VERSION.SDK_INT >= 15 ? new RemoteException(str) : new RemoteException();
    }

    private void waitCountDownLatch(CountDownLatch countDownLatch) throws RemoteException {
        try {
            if (countDownLatch.await(this.config.b() + 1000, TimeUnit.MILLISECONDS)) {
                return;
            }
            ParcelableFuture parcelableFuture = this.future;
            if (parcelableFuture != null) {
                parcelableFuture.cancel(true);
            }
            throw buildRemoteException("wait time out");
        } catch (InterruptedException unused) {
            throw buildRemoteException("thread interrupt");
        }
    }

    @Override // anetwork.channel.aidl.Connection
    public void cancel() throws RemoteException {
        ParcelableFuture parcelableFuture = this.future;
        if (parcelableFuture != null) {
            parcelableFuture.cancel(true);
        }
    }

    @Override // anetwork.channel.aidl.Connection
    public Map<String, List<String>> getConnHeadFields() throws RemoteException {
        waitCountDownLatch(this.statusLatch);
        return this.header;
    }

    @Override // anetwork.channel.aidl.Connection
    public String getDesc() throws RemoteException {
        waitCountDownLatch(this.statusLatch);
        return this.desc;
    }

    @Override // anetwork.channel.aidl.Connection
    public ParcelableInputStream getInputStream() throws RemoteException {
        waitCountDownLatch(this.streamLatch);
        return this.inputStream;
    }

    @Override // anetwork.channel.aidl.Connection
    public a getStatisticData() {
        return this.statisticData;
    }

    @Override // anetwork.channel.aidl.Connection
    public int getStatusCode() throws RemoteException {
        waitCountDownLatch(this.statusLatch);
        return this.statusCode;
    }

    @Override // a.a.c
    public void onFinished(a.a.g gVar, Object obj) {
        this.statusCode = gVar.getHttpCode();
        this.desc = gVar.getDesc() != null ? gVar.getDesc() : ErrorConstant.getErrMsg(this.statusCode);
        this.statisticData = gVar.getStatisticData();
        ParcelableInputStreamImpl parcelableInputStreamImpl = this.inputStream;
        if (parcelableInputStreamImpl != null) {
            parcelableInputStreamImpl.writeEnd();
        }
        this.streamLatch.countDown();
        this.statusLatch.countDown();
    }

    @Override // a.a.d
    public void onInputStreamGet(ParcelableInputStream parcelableInputStream, Object obj) {
        this.inputStream = (ParcelableInputStreamImpl) parcelableInputStream;
        this.streamLatch.countDown();
    }

    @Override // a.a.f
    public boolean onResponseCode(int i2, Map<String, List<String>> map, Object obj) {
        this.statusCode = i2;
        this.desc = ErrorConstant.getErrMsg(i2);
        this.header = map;
        this.statusLatch.countDown();
        return false;
    }

    public void setFuture(ParcelableFuture parcelableFuture) {
        this.future = parcelableFuture;
    }

    public ConnectionDelegate(g gVar) {
        this.config = gVar;
    }
}
