package org.android.spdy;

/* JADX INFO: loaded from: classes2.dex */
public class SpdyErrorException extends RuntimeException {
    private static final long serialVersionUID = 4422888579699220045L;
    private int error;

    public SpdyErrorException(int i2) {
        this.error = 0;
        this.error = i2;
    }

    public int SpdyErrorGetCode() {
        return this.error;
    }

    public SpdyErrorException(String str, int i2) {
        super(str);
        this.error = 0;
        this.error = i2;
    }

    public SpdyErrorException(String str, Throwable th, int i2) {
        super(str, th);
        this.error = 0;
        this.error = i2;
    }

    public SpdyErrorException(Throwable th, int i2) {
        super(th);
        this.error = 0;
        this.error = i2;
    }
}
