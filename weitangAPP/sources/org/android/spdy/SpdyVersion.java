package org.android.spdy;

/* JADX INFO: loaded from: classes2.dex */
public enum SpdyVersion {
    SPDY2(2),
    SPDY3(3),
    SPDY3DOT1(4);

    private int version;

    SpdyVersion(int i2) {
        this.version = i2;
    }

    public int getInt() {
        return this.version;
    }
}
