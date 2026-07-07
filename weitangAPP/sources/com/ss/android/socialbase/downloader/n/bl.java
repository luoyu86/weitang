package com.ss.android.socialbase.downloader.n;

import com.ss.android.socialbase.downloader.q.kf;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class bl implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.kf.ok f10119a;
    private final InputStream ok;

    public bl(InputStream inputStream, int i2) {
        this.ok = inputStream;
        this.f10119a = new com.ss.android.socialbase.downloader.kf.ok(i2);
    }

    @Override // com.ss.android.socialbase.downloader.n.a
    public void a() {
        kf.ok(this.ok);
    }

    @Override // com.ss.android.socialbase.downloader.n.a
    public com.ss.android.socialbase.downloader.kf.ok ok() throws IOException {
        com.ss.android.socialbase.downloader.kf.ok okVar = this.f10119a;
        okVar.bl = this.ok.read(okVar.ok);
        return this.f10119a;
    }

    @Override // com.ss.android.socialbase.downloader.n.a
    public void ok(com.ss.android.socialbase.downloader.kf.ok okVar) {
    }
}
