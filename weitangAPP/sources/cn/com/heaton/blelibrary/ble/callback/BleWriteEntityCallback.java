package cn.com.heaton.blelibrary.ble.callback;

/* JADX INFO: loaded from: classes.dex */
public abstract class BleWriteEntityCallback<T> {
    public void onWriteCancel() {
    }

    public abstract void onWriteFailed();

    public void onWriteProgress(double d2) {
    }

    public abstract void onWriteSuccess();
}
