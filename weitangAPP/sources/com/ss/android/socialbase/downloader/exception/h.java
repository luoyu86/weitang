package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: loaded from: classes2.dex */
public class h extends BaseException {
    public h(int i2, String str) {
        super(i2, str);
    }

    public h ok(String str) {
        setExtraInfo(str);
        return this;
    }

    public String ok() {
        return getExtraInfo();
    }
}
