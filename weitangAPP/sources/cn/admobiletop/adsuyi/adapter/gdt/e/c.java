package cn.admobiletop.adsuyi.adapter.gdt.e;

import android.content.Context;
import android.util.TypedValue;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public static int a(Context context, int i2) {
        return (int) TypedValue.applyDimension(1, i2, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    public static int b(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int a(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }
}
