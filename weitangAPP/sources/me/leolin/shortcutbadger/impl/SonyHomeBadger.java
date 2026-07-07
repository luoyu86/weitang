package me.leolin.shortcutbadger.impl;

import android.content.AsyncQueryHandler;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SonyHomeBadger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f14928a = Uri.parse("content://com.sonymobile.home.resourceprovider/badge");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AsyncQueryHandler f14929b;

    public class a extends AsyncQueryHandler {
        public a(ContentResolver contentResolver) {
            super(contentResolver);
        }
    }

    public static void b(Context context, ComponentName componentName, int i2) {
        Intent intent = new Intent("com.sonyericsson.home.action.UPDATE_BADGE");
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.PACKAGE_NAME", componentName.getPackageName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.ACTIVITY_NAME", componentName.getClassName());
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.MESSAGE", String.valueOf(i2));
        intent.putExtra("com.sonyericsson.home.intent.extra.badge.SHOW_MESSAGE", i2 > 0);
        context.sendBroadcast(intent);
    }

    public static boolean f(Context context) {
        return context.getPackageManager().resolveContentProvider("com.sonymobile.home.resourceprovider", 0) != null;
    }

    public final ContentValues a(int i2, ComponentName componentName) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("badge_count", Integer.valueOf(i2));
        contentValues.put("package_name", componentName.getPackageName());
        contentValues.put("activity_name", componentName.getClassName());
        return contentValues;
    }

    public final void c(Context context, ComponentName componentName, int i2) {
        if (i2 < 0) {
            return;
        }
        ContentValues contentValuesA = a(i2, componentName);
        if (Looper.myLooper() != Looper.getMainLooper()) {
            e(context, contentValuesA);
            return;
        }
        if (this.f14929b == null) {
            this.f14929b = new a(context.getApplicationContext().getContentResolver());
        }
        d(contentValuesA);
    }

    public final void d(ContentValues contentValues) {
        this.f14929b.startInsert(0, null, this.f14928a, contentValues);
    }

    public final void e(Context context, ContentValues contentValues) {
        context.getApplicationContext().getContentResolver().insert(this.f14928a, contentValues);
    }

    public void executeBadge(Context context, ComponentName componentName, int i2) throws e.a.a.a {
        if (f(context)) {
            c(context, componentName, i2);
        } else {
            b(context, componentName, i2);
        }
    }

    public List<String> getSupportLaunchers() {
        return Arrays.asList("com.sonyericsson.home", "com.sonymobile.home");
    }
}
