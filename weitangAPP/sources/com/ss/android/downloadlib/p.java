package com.ss.android.downloadlib;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public class p {
    private static volatile p ok;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ss.android.download.api.ok f9896a;
    private final h bl;
    private long kf;
    private com.ss.android.downloadad.api.a n;
    private final com.ss.android.downloadad.api.ok s;

    /* JADX INFO: Access modifiers changed from: private */
    public h p() {
        return this.bl;
    }

    public void bl() {
        this.kf = System.currentTimeMillis();
    }

    public void h() {
        s.ok().n();
    }

    public String kf() {
        return r.rh();
    }

    public com.ss.android.downloadad.api.a n() {
        if (this.n == null) {
            this.n = a.ok();
        }
        return this.n;
    }

    public com.ss.android.downloadad.api.ok s() {
        return this.s;
    }

    private p(Context context) {
        this.bl = h.ok();
        this.f9896a = new n();
        this.kf = System.currentTimeMillis();
        a(context);
        this.s = ok.ok();
    }

    private void a(Context context) {
        r.ok(context);
        Downloader.getInstance(r.getContext());
        com.ss.android.downloadlib.addownload.a.kf.ok().a();
        com.ss.android.socialbase.appdownloader.s.k().ok(r.getContext(), "misc_config", new com.ss.android.downloadlib.bl.h(), new com.ss.android.downloadlib.bl.kf(context), new bl());
        com.ss.android.downloadlib.bl.s sVar = new com.ss.android.downloadlib.bl.s();
        com.ss.android.socialbase.appdownloader.s.k().ok(sVar);
        Downloader.getInstance(context).registerDownloadCacheSyncListener(sVar);
        com.ss.android.socialbase.appdownloader.s.k().ok(new j());
        com.ss.android.socialbase.downloader.downloader.bl.ok(new com.ss.android.downloadlib.bl.n());
        com.ss.android.socialbase.appdownloader.s.k().ok(com.ss.android.downloadlib.kf.bl.ok());
    }

    public static p ok(final Context context) {
        if (ok == null) {
            synchronized (p.class) {
                if (ok == null) {
                    com.ss.android.downloadlib.n.a.ok(new Runnable() { // from class: com.ss.android.downloadlib.p.1
                        @Override // java.lang.Runnable
                        public void run() {
                            p unused = p.ok = new p(context);
                        }
                    });
                }
            }
        }
        return ok;
    }

    public com.ss.android.download.api.ok ok() {
        return this.f9896a;
    }

    public com.ss.android.download.api.ok ok(String str) {
        com.ss.android.download.api.config.kf kfVarA = kf.ok().a();
        if (kfVarA != null && kfVarA.ok(str)) {
            return kfVarA.a(str);
        }
        return this.f9896a;
    }

    public long a() {
        return this.kf;
    }

    public DownloadInfo a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.ss.android.socialbase.appdownloader.s.k().ok(r.getContext(), str);
    }

    @MainThread
    public void ok(final Context context, final int i2, final DownloadStatusChangeListener downloadStatusChangeListener, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.n.a.ok(new Runnable() { // from class: com.ss.android.downloadlib.p.4
            @Override // java.lang.Runnable
            public void run() {
                p.this.p().ok(context, i2, downloadStatusChangeListener, downloadModel);
            }
        });
    }

    @MainThread
    public void ok(final String str, final long j, final int i2, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final OnItemClickListener onItemClickListener, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.n.a.ok(new Runnable() { // from class: com.ss.android.downloadlib.p.5
            @Override // java.lang.Runnable
            public void run() {
                p.this.p().ok(str, j, i2, downloadEventConfig, downloadController, onItemClickListener, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void ok(final String str, final long j, final int i2, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController) {
        com.ss.android.downloadlib.n.a.ok(new Runnable() { // from class: com.ss.android.downloadlib.p.6
            @Override // java.lang.Runnable
            public void run() {
                p.this.p().ok(str, j, i2, downloadEventConfig, downloadController);
            }
        });
    }

    @MainThread
    public void ok(final String str, final long j, final int i2, final DownloadEventConfig downloadEventConfig, final DownloadController downloadController, final IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.n.a.ok(new Runnable() { // from class: com.ss.android.downloadlib.p.7
            @Override // java.lang.Runnable
            public void run() {
                p.this.p().ok(str, j, i2, downloadEventConfig, downloadController, iDownloadButtonClickListener);
            }
        });
    }

    @MainThread
    public void ok(final String str, final int i2) {
        com.ss.android.downloadlib.n.a.ok(new Runnable() { // from class: com.ss.android.downloadlib.p.2
            @Override // java.lang.Runnable
            public void run() {
                p.this.p().ok(str, i2);
            }
        });
    }

    @MainThread
    public void ok(final String str, final boolean z) {
        com.ss.android.downloadlib.n.a.ok(new Runnable() { // from class: com.ss.android.downloadlib.p.3
            @Override // java.lang.Runnable
            public void run() {
                p.this.p().ok(str, z);
            }
        });
    }

    public void ok(com.ss.android.download.api.download.ok.ok okVar) {
        p().ok(okVar);
    }

    public DownloadInfo ok(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2) && z) {
            return a(str);
        }
        return Downloader.getInstance(r.getContext()).getDownloadInfo(str, str2);
    }
}
