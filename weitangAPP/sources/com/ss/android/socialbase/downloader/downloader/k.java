package com.ss.android.socialbase.downloader.downloader;

import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface k {
    DownloadInfo a(int i2);

    DownloadInfo a(int i2, long j);

    List<DownloadInfo> a();

    List<DownloadInfo> a(String str);

    void a(int i2, List<com.ss.android.socialbase.downloader.model.a> list);

    void a(DownloadInfo downloadInfo);

    void a(com.ss.android.socialbase.downloader.model.a aVar);

    DownloadInfo bl(int i2, long j);

    List<com.ss.android.socialbase.downloader.model.a> bl(int i2);

    List<DownloadInfo> bl(String str);

    void bl();

    DownloadInfo h(int i2);

    Map<Long, com.ss.android.socialbase.downloader.kf.q> j(int i2);

    DownloadInfo k(int i2);

    boolean kf(int i2);

    boolean n();

    boolean n(int i2);

    DownloadInfo ok(int i2, int i3);

    DownloadInfo ok(int i2, long j);

    DownloadInfo ok(int i2, long j, String str, String str2);

    List<DownloadInfo> ok(String str);

    void ok(int i2, int i3, int i4, int i5);

    void ok(int i2, int i3, int i4, long j);

    void ok(int i2, int i3, long j);

    void ok(int i2, List<com.ss.android.socialbase.downloader.model.a> list);

    void ok(com.ss.android.socialbase.downloader.model.a aVar);

    boolean ok(int i2, Map<Long, com.ss.android.socialbase.downloader.kf.q> map);

    boolean ok(DownloadInfo downloadInfo);

    DownloadInfo p(int i2);

    DownloadInfo q(int i2);

    List<com.ss.android.socialbase.downloader.kf.q> rh(int i2);

    DownloadInfo s(int i2, long j);

    List<DownloadInfo> s(String str);

    void s(int i2);

    boolean s();

    void z(int i2);
}
