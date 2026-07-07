package org.android.spdy;

/* JADX INFO: loaded from: classes2.dex */
public enum SslMod {
    SLIGHT_SLL_NOT_ENCRYT(0),
    SLIGHT_SSL_0_RTT(1);

    private int code;

    SslMod(int i2) {
        this.code = i2;
    }

    public int getint() {
        return this.code;
    }
}
