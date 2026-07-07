package com.ss.android.socialbase.appdownloader.bl;

import android.content.Context;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface s {
    void ok(int i2, int i3, String str, int i4, long j);

    void ok(int i2, int i3, String str, String str2, String str3);

    void ok(Context context, String str);

    void ok(DownloadInfo downloadInfo);

    boolean ok();

    boolean ok(int i2, boolean z);
}
