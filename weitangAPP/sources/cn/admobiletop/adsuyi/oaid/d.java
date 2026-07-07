package cn.admobiletop.adsuyi.oaid;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f4338a = false;

    public static void a(Object obj) {
        if (f4338a) {
            if (obj == null) {
                obj = "<null>";
            }
            Log.d("OAID", obj.toString());
        }
    }
}
