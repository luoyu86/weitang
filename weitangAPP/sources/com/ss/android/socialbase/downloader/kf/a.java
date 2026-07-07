package com.ss.android.socialbase.downloader.kf;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class a implements bl, n, s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10076a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ok f10077h;
    private volatile boolean k;
    private ok kf;
    private ok n;
    private final int ok;
    private ok p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private ok f10078q;
    private int r;
    private final Object bl = new Object();
    private final Object s = new Object();

    public a(int i2, int i3) {
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.ok = i2;
        this.f10076a = i3;
    }

    @Override // com.ss.android.socialbase.downloader.kf.bl
    @NonNull
    public ok a() throws i, InterruptedException {
        synchronized (this.bl) {
            if (this.k) {
                throw new i("obtain");
            }
            ok okVar = this.n;
            if (okVar == null) {
                int i2 = this.r;
                if (i2 < this.ok) {
                    this.r = i2 + 1;
                    return new ok(this.f10076a);
                }
                do {
                    this.bl.wait();
                    if (this.k) {
                        throw new i("obtain");
                    }
                    okVar = this.n;
                } while (okVar == null);
            }
            this.n = okVar.s;
            if (okVar == this.kf) {
                this.kf = null;
            }
            okVar.s = null;
            return okVar;
        }
    }

    public void bl() {
        this.k = true;
        synchronized (this.bl) {
            this.bl.notifyAll();
        }
        synchronized (this.s) {
            this.s.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.s
    @NonNull
    public ok ok() throws i, InterruptedException {
        ok okVar;
        ok okVar2 = this.f10078q;
        if (okVar2 != null) {
            this.f10078q = okVar2.s;
            okVar2.s = null;
            return okVar2;
        }
        synchronized (this.s) {
            okVar = this.f10077h;
            while (okVar == null) {
                if (this.k) {
                    throw new i("read");
                }
                this.s.wait();
                okVar = this.f10077h;
            }
            this.f10078q = okVar.s;
            this.p = null;
            this.f10077h = null;
            okVar.s = null;
        }
        return okVar;
    }

    @Override // com.ss.android.socialbase.downloader.kf.bl
    public void ok(@NonNull ok okVar) {
        synchronized (this.bl) {
            ok okVar2 = this.kf;
            if (okVar2 == null) {
                this.kf = okVar;
                this.n = okVar;
            } else {
                okVar2.s = okVar;
                this.kf = okVar;
            }
            this.bl.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.n
    public void a(@NonNull ok okVar) {
        synchronized (this.s) {
            ok okVar2 = this.p;
            if (okVar2 == null) {
                this.p = okVar;
                this.f10077h = okVar;
                this.s.notify();
            } else {
                okVar2.s = okVar;
                this.p = okVar;
            }
        }
    }
}
