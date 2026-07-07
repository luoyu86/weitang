package com.ss.android.socialbase.downloader.kf;

import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class p implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f10085a;
    private final n ok;

    public p(n nVar, n nVar2) {
        this.ok = nVar;
        this.f10085a = nVar2;
    }

    @Override // com.ss.android.socialbase.downloader.kf.n
    public void a(@NonNull ok okVar) throws IOException {
        okVar.f10084a = this.f10085a;
        this.ok.a(okVar);
    }
}
