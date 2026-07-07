package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import e.a.a.a;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultBadger {
    public void executeBadge(Context context, ComponentName componentName, int i2) throws a {
        Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
        intent.putExtra("badge_count", i2);
        intent.putExtra("badge_count_package_name", componentName.getPackageName());
        intent.putExtra("badge_count_class_name", componentName.getClassName());
        e.a.a.b.a.sendDefaultIntentExplicitly(context, intent);
    }

    public List<String> getSupportLaunchers() {
        return Arrays.asList("fr.neamar.kiss", "com.quaap.launchtime", "com.quaap.launchtime_official");
    }
}
