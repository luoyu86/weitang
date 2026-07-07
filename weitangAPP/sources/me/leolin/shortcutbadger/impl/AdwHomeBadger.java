package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import e.a.a.a;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AdwHomeBadger {
    public void executeBadge(Context context, ComponentName componentName, int i2) throws a {
        Intent intent = new Intent("org.adw.launcher.counter.SEND");
        intent.putExtra("PNAME", componentName.getPackageName());
        intent.putExtra("CNAME", componentName.getClassName());
        intent.putExtra("COUNT", i2);
        e.a.a.b.a.sendIntentExplicitly(context, intent);
    }

    public List<String> getSupportLaunchers() {
        return Arrays.asList("org.adw.launcher", "org.adwfreak.launcher");
    }
}
