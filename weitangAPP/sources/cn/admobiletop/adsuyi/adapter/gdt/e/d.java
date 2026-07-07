package cn.admobiletop.adsuyi.adapter.gdt.e;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static SharedPreferences a(@NonNull Context context) {
        return context.getSharedPreferences(context.getPackageName(), 0);
    }

    public static String a(Context context, String str, String str2) {
        return a(context).getString(str, str2);
    }
}
