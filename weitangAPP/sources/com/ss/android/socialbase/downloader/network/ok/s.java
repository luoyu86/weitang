package com.ss.android.socialbase.downloader.network.ok;

import com.ss.android.socialbase.downloader.network.q;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class s implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<com.ss.android.socialbase.downloader.model.bl> f10137a;
    private q bl;
    private InputStream kf;
    private long n;
    public final Object ok;
    private boolean s;

    @Override // com.ss.android.socialbase.downloader.network.h
    public int a() throws IOException {
        q qVar = this.bl;
        if (qVar != null) {
            return qVar.a();
        }
        return 0;
    }

    @Override // com.ss.android.socialbase.downloader.network.h
    public void bl() {
        q qVar = this.bl;
        if (qVar != null) {
            qVar.bl();
        }
    }

    public boolean h() {
        try {
            q qVar = this.bl;
            if (qVar != null) {
                return ok(qVar.a());
            }
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public List<com.ss.android.socialbase.downloader.model.bl> kf() {
        return this.f10137a;
    }

    public void n() throws InterruptedException {
        synchronized (this.ok) {
            if (this.s && this.bl == null) {
                this.ok.wait();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.q
    public InputStream ok() throws IOException {
        InputStream inputStream = this.kf;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    public boolean ok(int i2) {
        return i2 >= 200 && i2 < 300;
    }

    public boolean p() {
        return System.currentTimeMillis() - this.n < a.ok;
    }

    @Override // com.ss.android.socialbase.downloader.network.q
    public void s() {
        q qVar = this.bl;
        if (qVar != null) {
            qVar.s();
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.h
    public String ok(String str) {
        q qVar = this.bl;
        if (qVar != null) {
            return qVar.ok(str);
        }
        return null;
    }
}
