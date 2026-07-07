package cn.com.heaton.blelibrary.ble.exception;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public class BleException extends Exception implements Serializable {
    public static final int ERROR_CODE_NOTSUPPORT = 400;
    public static final int ERROR_CODE_PERMISSION = 401;
    private static final long serialVersionUID = -3677084962477320584L;
    private Throwable ex;

    public BleException() {
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.ex;
    }

    public Throwable getException() {
        return this.ex;
    }

    public BleException(String str) {
        super(str);
    }

    public BleException(String str, Throwable th) {
        super(str, null);
        this.ex = th;
    }

    public BleException(Throwable th) {
        super(th);
    }
}
