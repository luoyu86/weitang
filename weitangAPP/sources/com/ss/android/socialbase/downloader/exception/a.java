package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: loaded from: classes2.dex */
public class a extends BaseException {
    private final int ok;

    public a(int i2, int i3, String str) {
        super(i2, str);
        this.ok = i3;
    }

    public int ok() {
        return this.ok;
    }
}
