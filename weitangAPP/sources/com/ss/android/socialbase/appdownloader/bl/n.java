package com.ss.android.socialbase.appdownloader.bl;

import android.content.Context;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* JADX INFO: loaded from: classes2.dex */
public interface n {
    String ok();

    void ok(int i2, String str, int i3, long j);

    void ok(int i2, String str, String str2, String str3);

    void ok(Context context, String str);

    void ok(DownloadInfo downloadInfo);

    boolean ok(boolean z);
}
