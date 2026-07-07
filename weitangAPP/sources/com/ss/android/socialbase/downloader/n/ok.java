package com.ss.android.socialbase.downloader.n;

import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.kf.i;
import com.ss.android.socialbase.downloader.q.kf;
import java.io.InputStream;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes2.dex */
public class ok implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f10120a;
    private final int bl;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.kf.ok f10121h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f10122i;
    private volatile boolean j;
    private com.ss.android.socialbase.downloader.kf.ok k;
    private com.ss.android.socialbase.downloader.kf.ok kf;
    private final InputStream ok;
    private com.ss.android.socialbase.downloader.kf.ok p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private com.ss.android.socialbase.downloader.kf.ok f10123q;
    private com.ss.android.socialbase.downloader.kf.ok r;
    private volatile Throwable rh;
    private volatile Future t;
    private volatile boolean z;
    private final Object s = new Object();
    private final Object n = new Object();
    private final Runnable x = new Runnable() { // from class: com.ss.android.socialbase.downloader.n.ok.1
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.kf.ok okVarS;
            Process.setThreadPriority(10);
            do {
                try {
                    okVarS = ok.this.s();
                    okVarS.bl = ok.this.ok.read(okVarS.ok);
                    ok.this.bl(okVarS);
                } catch (Throwable th) {
                    try {
                        ok.this.rh = th;
                        th.printStackTrace();
                        synchronized (ok.this.n) {
                            ok.this.z = true;
                            ok.this.n.notify();
                            kf.ok(ok.this.ok);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (ok.this.n) {
                            ok.this.z = true;
                            ok.this.n.notify();
                            kf.ok(ok.this.ok);
                            throw th2;
                        }
                    }
                }
            } while (okVarS.bl != -1);
            synchronized (ok.this.n) {
                ok.this.z = true;
                ok.this.n.notify();
            }
            kf.ok(ok.this.ok);
        }
    };

    public ok(InputStream inputStream, int i2, int i3) throws Throwable {
        this.ok = inputStream;
        this.f10120a = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.bl = i3;
        bl();
    }

    private void kf() throws BaseException {
        Throwable th = this.rh;
        if (th != null) {
            if (th instanceof i) {
                throw new BaseException(1068, "async reader closed!");
            }
            kf.ok(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }

    private com.ss.android.socialbase.downloader.kf.ok n() throws InterruptedException, BaseException {
        com.ss.android.socialbase.downloader.kf.ok okVar;
        com.ss.android.socialbase.downloader.kf.ok okVar2 = this.r;
        if (okVar2 != null) {
            this.r = okVar2.s;
            okVar2.s = null;
            return okVar2;
        }
        synchronized (this.n) {
            okVar = this.f10123q;
            if (okVar == null) {
                do {
                    if (this.z) {
                        kf();
                    }
                    this.n.wait();
                    okVar = this.f10123q;
                } while (okVar == null);
            }
            this.r = okVar.s;
            this.k = null;
            this.f10123q = null;
            okVar.s = null;
        }
        return okVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.kf.ok s() throws i, InterruptedException {
        int i2;
        com.ss.android.socialbase.downloader.kf.ok okVar = this.p;
        if (okVar != null) {
            if (this.j) {
                throw new i("");
            }
            this.p = okVar.s;
            okVar.s = null;
            return okVar;
        }
        synchronized (this.s) {
            if (this.j) {
                throw new i("");
            }
            com.ss.android.socialbase.downloader.kf.ok okVar2 = this.kf;
            if (okVar2 == null && (i2 = this.f10122i) < this.bl) {
                this.f10122i = i2 + 1;
                return new com.ss.android.socialbase.downloader.kf.ok(this.f10120a);
            }
            while (okVar2 == null) {
                this.s.wait();
                if (this.j) {
                    throw new i("");
                }
                okVar2 = this.kf;
            }
            this.p = okVar2.s;
            this.f10121h = null;
            this.kf = null;
            okVar2.s = null;
            return okVar2;
        }
    }

    private void bl() throws Throwable {
        this.t = com.ss.android.socialbase.downloader.downloader.bl.x().submit(this.x);
    }

    @Override // com.ss.android.socialbase.downloader.n.a
    public void a() {
        synchronized (this.s) {
            this.j = true;
            this.s.notify();
        }
        Future future = this.t;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.t = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bl(com.ss.android.socialbase.downloader.kf.ok okVar) {
        synchronized (this.n) {
            com.ss.android.socialbase.downloader.kf.ok okVar2 = this.k;
            if (okVar2 == null) {
                this.k = okVar;
                this.f10123q = okVar;
                this.n.notify();
            } else {
                okVar2.s = okVar;
                this.k = okVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.n.a
    public com.ss.android.socialbase.downloader.kf.ok ok() throws InterruptedException, BaseException {
        return n();
    }

    @Override // com.ss.android.socialbase.downloader.n.a
    public void ok(com.ss.android.socialbase.downloader.kf.ok okVar) {
        a(okVar);
    }

    private void a(com.ss.android.socialbase.downloader.kf.ok okVar) {
        synchronized (this.s) {
            com.ss.android.socialbase.downloader.kf.ok okVar2 = this.f10121h;
            if (okVar2 == null) {
                this.f10121h = okVar;
                this.kf = okVar;
                this.s.notify();
            } else {
                okVar2.s = okVar;
                this.f10121h = okVar;
            }
        }
    }
}
