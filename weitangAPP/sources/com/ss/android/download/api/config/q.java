package com.ss.android.download.api.config;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public interface q {
    void ok(@NonNull Activity activity, int i2, @NonNull String[] strArr, @NonNull int[] iArr);

    void ok(@NonNull Activity activity, @NonNull String[] strArr, u uVar);

    boolean ok(@NonNull Context context, @NonNull String str);
}
