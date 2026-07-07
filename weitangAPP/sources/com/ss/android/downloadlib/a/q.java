package com.ss.android.downloadlib.a;

import android.os.Build;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.r;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    public static boolean ok(@NonNull com.ss.android.downloadad.api.ok.ok okVar) {
        return com.ss.android.socialbase.appdownloader.kf.n.n() && Build.VERSION.SDK_INT < 29 && r.j() != null && r.j().ok() && com.ss.android.downloadlib.h.n.ok(okVar).a("invoke_app_form_background_switch") == 1 && okVar.x();
    }
}
