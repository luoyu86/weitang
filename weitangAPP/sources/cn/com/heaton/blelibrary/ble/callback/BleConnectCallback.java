package cn.com.heaton.blelibrary.ble.callback;

/* JADX INFO: loaded from: classes.dex */
public abstract class BleConnectCallback<T> {
    public void onConnectException(T t, int i2) {
    }

    public void onConnectTimeOut(T t) {
    }

    public abstract void onConnectionChanged(T t);
}
