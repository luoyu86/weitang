package com.ss.android.downloadlib;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.downloadlib.addownload.r;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class h {
    private static volatile h ok;
    private long kf;
    private final List<com.ss.android.downloadlib.addownload.h> bl = new CopyOnWriteArrayList();
    private final Map<String, com.ss.android.downloadlib.addownload.h> s = new ConcurrentHashMap();
    private final CopyOnWriteArrayList<Object> n = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f9862a = new Handler(Looper.getMainLooper());

    private h() {
    }

    private synchronized void a(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (this.bl.size() <= 0) {
            bl(context, i2, downloadStatusChangeListener, downloadModel);
        } else {
            com.ss.android.downloadlib.addownload.h hVarRemove = this.bl.remove(0);
            hVarRemove.a(context).a(i2, downloadStatusChangeListener).a(downloadModel).ok();
            this.s.put(downloadModel.getDownloadUrl(), hVarRemove);
        }
    }

    private void bl(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.n nVar = new com.ss.android.downloadlib.addownload.n();
        nVar.a(context).a(i2, downloadStatusChangeListener).a(downloadModel).ok();
        this.s.put(downloadModel.getDownloadUrl(), nVar);
    }

    private void s() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (com.ss.android.downloadlib.addownload.h hVar : this.bl) {
            if (!hVar.a() && jCurrentTimeMillis - hVar.s() > 300000) {
                hVar.p();
                arrayList.add(hVar);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.bl.removeAll(arrayList);
    }

    public static h ok() {
        if (ok == null) {
            synchronized (h.class) {
                if (ok == null) {
                    ok = new h();
                }
            }
        }
        return ok;
    }

    private void bl() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.kf < 300000) {
            return;
        }
        this.kf = jCurrentTimeMillis;
        if (this.bl.isEmpty()) {
            return;
        }
        s();
    }

    public void ok(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel) {
        com.ss.android.downloadlib.addownload.h hVar;
        if (downloadModel == null || TextUtils.isEmpty(downloadModel.getDownloadUrl())) {
            return;
        }
        boolean z = r.q().optInt("filter_download_url_key", 0) == 1;
        String strOk = com.ss.android.downloadlib.addownload.kf.ok().ok(downloadModel.getDownloadUrl());
        if (z && !TextUtils.isEmpty(strOk)) {
            hVar = this.s.get(strOk);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel.getTaskKey())) {
                    adDownloadModel.setTaskKey(strOk);
                }
            }
        } else {
            hVar = this.s.get(downloadModel.getDownloadUrl());
        }
        if (hVar != null) {
            hVar.a(context).a(i2, downloadStatusChangeListener).a(downloadModel).ok();
            return;
        }
        if (this.bl.isEmpty()) {
            if (z) {
                if (!TextUtils.isEmpty(strOk)) {
                    a(context, i2, downloadStatusChangeListener, downloadModel, strOk);
                    return;
                }
                String strOk2 = com.ss.android.downloadlib.addownload.kf.ok().ok(downloadModel);
                if (TextUtils.isEmpty(strOk2)) {
                    bl(context, i2, downloadStatusChangeListener, downloadModel);
                    return;
                }
                a(context, i2, downloadStatusChangeListener, downloadModel, strOk2);
                if (downloadModel instanceof AdDownloadModel) {
                    AdDownloadModel adDownloadModel2 = (AdDownloadModel) downloadModel;
                    if (TextUtils.isEmpty(adDownloadModel2.getTaskKey())) {
                        adDownloadModel2.setTaskKey(strOk2);
                        return;
                    }
                    return;
                }
                return;
            }
            bl(context, i2, downloadStatusChangeListener, downloadModel);
            return;
        }
        if (z) {
            if (!TextUtils.isEmpty(strOk)) {
                ok(context, i2, downloadStatusChangeListener, downloadModel, strOk);
                return;
            }
            String strOk3 = com.ss.android.downloadlib.addownload.kf.ok().ok(downloadModel);
            if (TextUtils.isEmpty(strOk3)) {
                a(context, i2, downloadStatusChangeListener, downloadModel);
                return;
            }
            ok(context, i2, downloadStatusChangeListener, downloadModel, strOk3);
            if (downloadModel instanceof AdDownloadModel) {
                AdDownloadModel adDownloadModel3 = (AdDownloadModel) downloadModel;
                if (TextUtils.isEmpty(adDownloadModel3.getTaskKey())) {
                    adDownloadModel3.setTaskKey(strOk3);
                    return;
                }
                return;
            }
            return;
        }
        a(context, i2, downloadStatusChangeListener, downloadModel);
    }

    private void a(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (downloadModel == null) {
            return;
        }
        com.ss.android.downloadlib.addownload.n nVar = new com.ss.android.downloadlib.addownload.n();
        nVar.a(context).a(i2, downloadStatusChangeListener).a(downloadModel).ok(str).ok();
        this.s.put(str, nVar);
        com.ss.android.downloadlib.addownload.kf.ok().ok(str, downloadModel.getDownloadUrl());
    }

    public void a(final DownloadInfo downloadInfo, final String str) {
        this.f9862a.post(new Runnable() { // from class: com.ss.android.downloadlib.h.4
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : h.this.n) {
                    if (obj instanceof com.ss.android.download.api.download.ok.ok) {
                        ((com.ss.android.download.api.download.ok.ok) obj).a(downloadInfo, str);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ok.ok) {
                            ((com.ss.android.download.api.download.ok.ok) softReference.get()).a(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public Handler a() {
        return this.f9862a;
    }

    public com.ss.android.downloadlib.addownload.n ok(String str) {
        com.ss.android.downloadlib.addownload.h hVar;
        Map<String, com.ss.android.downloadlib.addownload.h> map = this.s;
        if (map != null && map.size() != 0 && !TextUtils.isEmpty(str)) {
            if (r.q().optInt("filter_download_url_key", 0) == 1) {
                hVar = this.s.get(com.ss.android.downloadlib.addownload.kf.ok().ok(str));
            } else {
                hVar = this.s.get(str);
            }
            if (hVar instanceof com.ss.android.downloadlib.addownload.n) {
                return (com.ss.android.downloadlib.addownload.n) hVar;
            }
        }
        return null;
    }

    private synchronized void ok(Context context, int i2, DownloadStatusChangeListener downloadStatusChangeListener, DownloadModel downloadModel, String str) {
        if (this.bl.size() <= 0) {
            a(context, i2, downloadStatusChangeListener, downloadModel, str);
        } else {
            com.ss.android.downloadlib.addownload.h hVarRemove = this.bl.remove(0);
            hVarRemove.a(context).a(i2, downloadStatusChangeListener).a(downloadModel).ok(str).ok();
            this.s.put(str, hVarRemove);
            com.ss.android.downloadlib.addownload.kf.ok().ok(str, downloadModel.getDownloadUrl());
        }
    }

    public void ok(String str, int i2) {
        com.ss.android.downloadlib.addownload.h hVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = r.q().optInt("filter_download_url_key", 0) == 1;
        String strOk = com.ss.android.downloadlib.addownload.kf.ok().ok(str);
        if (z && !TextUtils.isEmpty(strOk)) {
            hVar = this.s.get(strOk);
        } else {
            hVar = this.s.get(str);
        }
        if (hVar != null) {
            if (hVar.ok(i2)) {
                this.bl.add(hVar);
                if (z && !TextUtils.isEmpty(strOk)) {
                    this.s.remove(strOk);
                    com.ss.android.downloadlib.addownload.kf.ok().a(strOk);
                } else {
                    this.s.remove(str);
                }
            }
            bl();
        }
    }

    public void ok(String str, boolean z) {
        com.ss.android.downloadlib.addownload.h hVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z2 = r.q().optInt("filter_download_url_key", 0) == 1;
        String strOk = com.ss.android.downloadlib.addownload.kf.ok().ok(str);
        if (z2 && !TextUtils.isEmpty(strOk)) {
            hVar = this.s.get(strOk);
        } else {
            hVar = this.s.get(str);
        }
        if (hVar != null) {
            hVar.ok(z);
        }
    }

    public void ok(String str, long j, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController) {
        ok(str, j, i2, downloadEventConfig, downloadController, null, null);
    }

    public void ok(String str, long j, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener) {
        ok(str, j, i2, downloadEventConfig, downloadController, null, iDownloadButtonClickListener);
    }

    public void ok(String str, long j, int i2, DownloadEventConfig downloadEventConfig, DownloadController downloadController, OnItemClickListener onItemClickListener, IDownloadButtonClickListener iDownloadButtonClickListener) {
        com.ss.android.downloadlib.addownload.h hVar;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = r.q().optInt("filter_download_url_key", 0) == 1;
        String strOk = com.ss.android.downloadlib.addownload.kf.ok().ok(str);
        if (z && !TextUtils.isEmpty(strOk)) {
            hVar = this.s.get(strOk);
        } else {
            hVar = this.s.get(str);
        }
        if (hVar != null) {
            hVar.ok(j).a(downloadEventConfig).a(downloadController).ok(onItemClickListener).ok(iDownloadButtonClickListener).a(i2);
        }
    }

    public void ok(com.ss.android.download.api.download.ok.ok okVar) {
        if (okVar != null) {
            if (com.ss.android.socialbase.downloader.h.ok.bl().a("fix_listener_oom", false)) {
                this.n.add(new SoftReference(okVar));
            } else {
                this.n.add(okVar);
            }
        }
    }

    public void ok(final DownloadModel downloadModel, @Nullable final DownloadController downloadController, @Nullable final DownloadEventConfig downloadEventConfig) {
        this.f9862a.post(new Runnable() { // from class: com.ss.android.downloadlib.h.1
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : h.this.n) {
                    if (obj instanceof com.ss.android.download.api.download.ok.ok) {
                        ((com.ss.android.download.api.download.ok.ok) obj).ok(downloadModel, downloadController, downloadEventConfig);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ok.ok) {
                            ((com.ss.android.download.api.download.ok.ok) softReference.get()).ok(downloadModel, downloadController, downloadEventConfig);
                        }
                    }
                }
            }
        });
    }

    public void ok(final DownloadInfo downloadInfo, final BaseException baseException, final String str) {
        this.f9862a.post(new Runnable() { // from class: com.ss.android.downloadlib.h.2
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : h.this.n) {
                    if (obj instanceof com.ss.android.download.api.download.ok.ok) {
                        ((com.ss.android.download.api.download.ok.ok) obj).ok(downloadInfo, baseException, str);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ok.ok) {
                            ((com.ss.android.download.api.download.ok.ok) softReference.get()).ok(downloadInfo, baseException, str);
                        }
                    }
                }
            }
        });
    }

    public void ok(final DownloadInfo downloadInfo, final String str) {
        this.f9862a.post(new Runnable() { // from class: com.ss.android.downloadlib.h.3
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : h.this.n) {
                    if (obj instanceof com.ss.android.download.api.download.ok.ok) {
                        ((com.ss.android.download.api.download.ok.ok) obj).ok(downloadInfo, str);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ok.ok) {
                            ((com.ss.android.download.api.download.ok.ok) softReference.get()).ok(downloadInfo, str);
                        }
                    }
                }
            }
        });
    }

    public void ok(final DownloadInfo downloadInfo) {
        this.f9862a.post(new Runnable() { // from class: com.ss.android.downloadlib.h.5
            @Override // java.lang.Runnable
            public void run() {
                for (Object obj : h.this.n) {
                    if (obj instanceof com.ss.android.download.api.download.ok.ok) {
                        ((com.ss.android.download.api.download.ok.ok) obj).ok(downloadInfo);
                    } else if (obj instanceof SoftReference) {
                        SoftReference softReference = (SoftReference) obj;
                        if (softReference.get() instanceof com.ss.android.download.api.download.ok.ok) {
                            ((com.ss.android.download.api.download.ok.ok) softReference.get()).ok(downloadInfo);
                        }
                    }
                }
            }
        });
    }
}
