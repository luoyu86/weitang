package com.tianmu.i.a;

import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f12209a = false;

    public static void a(Object obj) {
        if (f12209a) {
            if (obj == null) {
                obj = "<null>";
            }
            Log.d("OAID", obj.toString());
        }
    }
}
