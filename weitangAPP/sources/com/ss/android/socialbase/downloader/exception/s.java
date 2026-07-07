package com.ss.android.socialbase.downloader.exception;

/* JADX INFO: loaded from: classes2.dex */
public class s extends BaseException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f10042a;
    private final long ok;

    public s(long j, long j2) {
        super(1006, String.format("space is not enough required space is : %s but available space is :%s", String.valueOf(j2), String.valueOf(j)));
        this.ok = j;
        this.f10042a = j2;
    }

    public long a() {
        return this.f10042a;
    }

    public long ok() {
        return this.ok;
    }
}
