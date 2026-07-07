package com.ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.sg;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface z {
    DownloadInfo a(String str, String str2);

    List<DownloadInfo> a(String str);

    void a(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z);

    void a(int i2, List<com.ss.android.socialbase.downloader.model.a> list);

    void a(int i2, boolean z);

    void a(DownloadInfo downloadInfo);

    void a(DownloadTask downloadTask);

    void a(List<String> list);

    boolean a();

    boolean a(int i2);

    List<DownloadInfo> bl(String str);

    void bl(int i2);

    void bl(int i2, boolean z);

    boolean bl();

    boolean bl(DownloadInfo downloadInfo);

    boolean h();

    boolean h(int i2);

    boolean i(int i2);

    boolean j(int i2);

    void k(int i2);

    int kf(int i2);

    void kf();

    long n(int i2);

    List<DownloadInfo> n(String str);

    boolean n();

    int ok(String str, String str2);

    List<DownloadInfo> ok(String str);

    void ok();

    void ok(int i2);

    void ok(int i2, int i3);

    void ok(int i2, int i3, int i4, int i5);

    void ok(int i2, int i3, int i4, long j);

    void ok(int i2, int i3, long j);

    void ok(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z);

    void ok(int i2, int i3, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z, boolean z2);

    void ok(int i2, long j);

    void ok(int i2, Notification notification);

    void ok(int i2, ep epVar);

    void ok(int i2, List<com.ss.android.socialbase.downloader.model.a> list);

    void ok(int i2, boolean z);

    void ok(sg sgVar);

    void ok(DownloadTask downloadTask);

    void ok(com.ss.android.socialbase.downloader.model.a aVar);

    void ok(List<String> list);

    void ok(boolean z, boolean z2);

    boolean ok(DownloadInfo downloadInfo);

    DownloadInfo p(int i2);

    List<com.ss.android.socialbase.downloader.model.a> q(int i2);

    void r(int i2);

    boolean rh(int i2);

    List<DownloadInfo> s();

    List<DownloadInfo> s(String str);

    void s(int i2);

    void startService();

    void t(int i2);

    v td(int i2);

    ep x(int i2);

    int z(int i2);

    IDownloadFileUriProvider zz(int i2);
}
