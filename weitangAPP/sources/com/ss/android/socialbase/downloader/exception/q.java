package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: loaded from: classes2.dex */
public class q extends Throwable {
    private String ok;

    public q(String str) {
        super(str);
        this.ok = str;
    }

    public String ok() {
        return this.ok;
    }
}
