package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import e.a.a.a;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NovaHomeBadger {
    public void executeBadge(Context context, ComponentName componentName, int i2) throws a {
        ContentValues contentValues = new ContentValues();
        contentValues.put("tag", componentName.getPackageName() + "/" + componentName.getClassName());
        contentValues.put("count", Integer.valueOf(i2));
        context.getContentResolver().insert(Uri.parse("content://com.teslacoilsw.notifier/unread_count"), contentValues);
    }

    public List<String> getSupportLaunchers() {
        return Arrays.asList("com.teslacoilsw.launcher");
    }
}
