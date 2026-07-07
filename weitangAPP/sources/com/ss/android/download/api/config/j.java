package com.ss.android.download.api.config;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadModel;

/* JADX INFO: loaded from: classes2.dex */
public interface j {
    Dialog a(@NonNull com.ss.android.download.api.model.a aVar);

    void ok(int i2, @Nullable Context context, @Nullable DownloadModel downloadModel, String str, Drawable drawable, int i3);
}
