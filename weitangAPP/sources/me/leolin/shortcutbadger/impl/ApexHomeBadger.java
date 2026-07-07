package me.leolin.shortcutbadger.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.bytedance.pangle.servermanager.AbsServerManager;
import e.a.a.a;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ApexHomeBadger {
    public void executeBadge(Context context, ComponentName componentName, int i2) throws a {
        Intent intent = new Intent("com.anddoes.launcher.COUNTER_CHANGED");
        intent.putExtra(AbsServerManager.PACKAGE_QUERY_BINDER, componentName.getPackageName());
        intent.putExtra("count", i2);
        intent.putExtra("class", componentName.getClassName());
        e.a.a.b.a.sendIntentExplicitly(context, intent);
    }

    public List<String> getSupportLaunchers() {
        return Arrays.asList("com.anddoes.launcher");
    }
}
