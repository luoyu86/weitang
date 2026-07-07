package com.bytedance.pangle.dex;

import android.os.Build;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class DirectDex {
    static {
        System.loadLibrary("zeus_direct_dex");
        native_init(Build.VERSION.SDK_INT);
    }

    private static native boolean native_init(int i2);

    public static native Object native_load_direct_dex(String str);
}
