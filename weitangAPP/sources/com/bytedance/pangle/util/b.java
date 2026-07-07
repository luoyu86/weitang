package com.bytedance.pangle.util;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f6261a;

    public static String a(Context context) {
        if (f6261a == null) {
            String[] strArrA = c.a(new File(context.getApplicationInfo().sourceDir));
            String str = strArrA[0];
            f6261a = str;
            if (TextUtils.isEmpty(str)) {
                ZeusLogger.w(ZeusLogger.TAG_INIT, "getHostIdentity failed. Reason: " + strArrA[2]);
            }
        }
        return f6261a;
    }

    public static boolean a() {
        try {
            return (Zeus.getAppApplication().getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
            return false;
        }
    }
}
