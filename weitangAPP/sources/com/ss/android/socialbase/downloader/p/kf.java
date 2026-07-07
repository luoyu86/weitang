package com.ss.android.socialbase.downloader.p;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.q;

/* JADX INFO: loaded from: classes2.dex */
public interface kf {
    void a(BaseException baseException);

    boolean a(long j) throws BaseException;

    void bl(BaseException baseException);

    com.ss.android.socialbase.downloader.exception.p ok(BaseException baseException, long j);

    com.ss.android.socialbase.downloader.exception.p ok(com.ss.android.socialbase.downloader.model.a aVar, BaseException baseException, long j);

    com.ss.android.socialbase.downloader.model.a ok(int i2);

    void ok(long j) throws BaseException;

    void ok(BaseException baseException, boolean z);

    void ok(com.ss.android.socialbase.downloader.network.h hVar);

    void ok(a aVar);

    void ok(String str, com.ss.android.socialbase.downloader.network.h hVar, long j) throws q, BaseException;

    boolean ok(BaseException baseException);
}
