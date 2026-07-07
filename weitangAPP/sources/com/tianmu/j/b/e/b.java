package com.tianmu.j.b.e;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.NonNull;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static int a(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
            return 0;
        }
        if (!activeNetworkInfo.isConnected()) {
            return 1;
        }
        if (activeNetworkInfo.getType() == 9) {
            return 2;
        }
        if (activeNetworkInfo.getType() == 1) {
            return 3;
        }
        if (activeNetworkInfo.getType() != 0) {
            return -1;
        }
        int subtype = activeNetworkInfo.getSubtype();
        if (subtype == 20) {
            return 4;
        }
        switch (subtype) {
        }
        return 0;
    }

    public static double b(Context context) {
        return context.getResources().getIdentifier("status_bar_height_portrait", "dimen", DispatchConstants.ANDROID) > 0 ? context.getResources().getDimensionPixelSize(r0) : 0;
    }

    public static Activity c(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @NonNull
    public static <T> List<T> a(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}
