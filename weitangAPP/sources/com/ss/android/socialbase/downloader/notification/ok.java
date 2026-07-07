package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f10148a;
    private long bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f10149h;
    private int kf = 0;
    private String n;
    public Notification ok;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f10150q;
    private long s;

    public ok(int i2, String str) {
        this.f10148a = i2;
        this.n = str;
    }

    public long a() {
        return this.bl;
    }

    public long bl() {
        return this.s;
    }

    public synchronized void h() {
        this.p++;
    }

    public long kf() {
        if (this.f10149h == 0) {
            this.f10149h = System.currentTimeMillis();
        }
        return this.f10149h;
    }

    public int n() {
        return this.kf;
    }

    public abstract void ok(BaseException baseException, boolean z);

    public void ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f10148a = downloadInfo.getId();
        this.n = downloadInfo.getTitle();
    }

    public boolean p() {
        return this.f10150q;
    }

    public String s() {
        return this.n;
    }

    public void a(long j) {
        this.s = j;
    }

    public int ok() {
        return this.f10148a;
    }

    public void ok(long j) {
        this.bl = j;
    }

    public void ok(int i2, BaseException baseException, boolean z) {
        ok(i2, baseException, z, false);
    }

    public void ok(int i2, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.kf != i2) {
            this.kf = i2;
            ok(baseException, z);
        }
    }

    public void ok(long j, long j2) {
        this.bl = j;
        this.s = j2;
        this.kf = 4;
        ok((BaseException) null, false);
    }

    public void ok(Notification notification) {
        if (this.f10148a == 0 || notification == null) {
            return;
        }
        a.ok().ok(this.f10148a, this.kf, notification);
    }
}
