package com.ss.android.socialbase.downloader.impls;

/* JADX INFO: loaded from: classes2.dex */
public class a implements com.ss.android.socialbase.downloader.downloader.h {
    @Override // com.ss.android.socialbase.downloader.downloader.h
    public int ok(int i2, com.ss.android.socialbase.downloader.network.j jVar) {
        if (jVar.ordinal() <= com.ss.android.socialbase.downloader.network.j.MODERATE.ordinal()) {
            return 1;
        }
        return jVar == com.ss.android.socialbase.downloader.network.j.GOOD ? i2 - 1 : i2;
    }
}
