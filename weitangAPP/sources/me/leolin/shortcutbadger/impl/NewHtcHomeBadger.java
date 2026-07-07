package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import e.a.a.a;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NewHtcHomeBadger {
    public void executeBadge(Context context, ComponentName componentName, int i2) throws a {
        boolean z;
        Intent intent = new Intent("com.htc.launcher.action.SET_NOTIFICATION");
        intent.putExtra("com.htc.launcher.extra.COMPONENT", componentName.flattenToShortString());
        intent.putExtra("com.htc.launcher.extra.COUNT", i2);
        Intent intent2 = new Intent("com.htc.launcher.action.UPDATE_SHORTCUT");
        intent2.putExtra("packagename", componentName.getPackageName());
        intent2.putExtra("count", i2);
        boolean z2 = false;
        try {
            e.a.a.b.a.sendIntentExplicitly(context, intent);
            z = true;
        } catch (a unused) {
            z = false;
        }
        try {
            e.a.a.b.a.sendIntentExplicitly(context, intent2);
            z2 = true;
        } catch (a unused2) {
        }
        if (z || z2) {
            return;
        }
        throw new a("unable to resolve intent: " + intent2.toString());
    }

    public List<String> getSupportLaunchers() {
        return Collections.singletonList("com.htc.launcher");
    }
}
