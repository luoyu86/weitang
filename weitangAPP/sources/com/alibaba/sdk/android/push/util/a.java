package com.alibaba.sdk.android.push.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.push.R;
import com.bytedance.pangle.servermanager.AbsServerManager;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static String a(Context context) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
            if (launchIntentForPackage == null || launchIntentForPackage.getComponent() == null) {
                return null;
            }
            return launchIntentForPackage.getComponent().getClassName();
        } catch (Exception unused) {
            AmsLogger.getLogger("BadgeUtils").d(context.getString(R.string.launch_activity_name_fail));
            return null;
        }
    }

    public static void a(Context context, int i2) {
        if (context == null) {
            return;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (b.a()) {
            b(context, i2);
            return;
        }
        if (b.b()) {
            c(context, i2);
        } else if (b.c()) {
            d(context, i2);
        } else {
            AmsLogger.getLogger("BadgeUtils").d(context.getString(R.string.not_support_badge_desc));
        }
    }

    private static void b(Context context, int i2) {
        String strA = a(context);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString(AbsServerManager.PACKAGE_QUERY_BINDER, context.getPackageName());
            bundle.putString("class", strA);
            bundle.putInt("badgenumber", i2);
            context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
        } catch (Exception unused) {
            AmsLogger.getLogger("BadgeUtils").d(context.getString(R.string.not_support_badge_desc));
        }
    }

    private static void c(Context context, int i2) {
        String strA = a(context);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putString(AbsServerManager.PACKAGE_QUERY_BINDER, context.getPackageName());
            bundle.putString("class", strA);
            bundle.putInt("badgenumber", i2);
            context.getContentResolver().call(Uri.parse("content://com.hihonor.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
        } catch (Exception unused) {
            AmsLogger.getLogger("BadgeUtils").d(context.getString(R.string.not_support_badge_desc));
        }
    }

    private static void d(Context context, int i2) {
        String strA = a(context);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        try {
            Intent intent = new Intent("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra("packageName", context.getPackageName());
            intent.putExtra("className", strA);
            intent.putExtra("notificationNum", i2);
            context.sendBroadcast(intent);
        } catch (Exception unused) {
            AmsLogger.getLogger("BadgeUtils").d("VIVO机型设置角标失败");
        }
    }
}
