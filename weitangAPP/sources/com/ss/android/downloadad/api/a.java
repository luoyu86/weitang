package com.ss.android.downloadad.api;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    Dialog ok(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2);

    Dialog ok(Context context, String str, boolean z, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, DownloadStatusChangeListener downloadStatusChangeListener, int i2, IDownloadButtonClickListener iDownloadButtonClickListener);

    boolean ok(long j);

    boolean ok(long j, int i2);

    boolean ok(Context context, long j, String str, DownloadStatusChangeListener downloadStatusChangeListener, int i2);

    boolean ok(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController);

    boolean ok(Context context, Uri uri, DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController, IDownloadButtonClickListener iDownloadButtonClickListener);
}
