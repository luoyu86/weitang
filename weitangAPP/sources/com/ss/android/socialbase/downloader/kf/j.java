package com.ss.android.socialbase.downloader.kf;

import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class j implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.model.n f10083a;
    private final n bl;
    private final q ok;

    public j(DownloadInfo downloadInfo, a aVar, q qVar) throws BaseException {
        this.ok = qVar;
        this.f10083a = ok(downloadInfo, qVar);
        this.bl = new p(aVar, this);
    }

    @Override // com.ss.android.socialbase.downloader.kf.n
    public void a(@NonNull ok okVar) throws IOException {
        this.f10083a.ok(okVar.ok, 0, okVar.bl);
        this.ok.a(okVar.bl);
    }

    public void bl() throws IOException {
        this.f10083a.bl();
    }

    public q n() {
        return this.ok;
    }

    public n ok() {
        return this.bl;
    }

    public void s() {
        com.ss.android.socialbase.downloader.q.kf.ok(this.f10083a);
    }

    private com.ss.android.socialbase.downloader.model.n ok(DownloadInfo downloadInfo, q qVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.n nVarOk = com.ss.android.socialbase.downloader.q.kf.ok(downloadInfo, downloadInfo.getTempPath(), downloadInfo.getTempName(), com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("flush_buffer_size_byte", -1));
        try {
            nVarOk.ok(qVar.n());
            return nVarOk;
        } catch (IOException e2) {
            throw new BaseException(1054, e2);
        }
    }

    public void a() throws IOException {
        this.f10083a.a();
    }
}
