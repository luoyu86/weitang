package c.e.c.m0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    public static boolean isNetworkAvailabe(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }
}
