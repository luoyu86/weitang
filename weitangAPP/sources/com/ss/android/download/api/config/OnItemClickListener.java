package com.ss.android.download.api.config;

import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;

/* JADX INFO: loaded from: classes2.dex */
public interface OnItemClickListener {
    void onItemClick(DownloadModel downloadModel, DownloadEventConfig downloadEventConfig, DownloadController downloadController);
}
