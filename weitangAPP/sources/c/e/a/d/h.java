package c.e.a.d;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.chinavisionary.core.R;
import java.util.List;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class h {
    public static String a(Context context) {
        ComponentName componentNameB = b(context);
        return componentNameB == null ? "" : componentNameB.getClassName();
    }

    public static ComponentName b(Context context) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            return launchIntentForPackage.getComponent();
        }
        return null;
    }

    public static boolean c(int i2, Context context) {
        try {
            String strA = a(context);
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putString(AbsServerManager.PACKAGE_QUERY_BINDER, context.getPackageName());
            bundle.putString("class", strA);
            bundle.putInt("badgenumber", i2);
            context.getContentResolver().call(Uri.parse("content://com.huawei.android.launcher.settings/badge/"), "change_badge", (String) null, bundle);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Deprecated
    public static boolean d(int i2, Context context) {
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("app_badge_count", i2);
            context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", String.valueOf(i2), bundle);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Deprecated
    public static boolean e(int i2, Context context) {
        try {
            Intent intent = new Intent("com.oppo.unsettledevent");
            intent.putExtra("packageName", context.getPackageName());
            intent.putExtra("number", i2);
            intent.putExtra("upgradeNumber", i2);
            List<ResolveInfo> listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
            if (listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0) {
                context.sendBroadcast(intent);
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("app_badge_count", i2);
            context.getContentResolver().call(Uri.parse("content://com.android.badge/badge"), "setAppBadgeCount", (String) null, bundle);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean f(int i2, Context context) {
        try {
            String strA = a(context);
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
            intent.putExtra("badge_count", i2);
            intent.putExtra("badge_count_package_name", context.getPackageName());
            intent.putExtra("badge_count_class_name", strA);
            context.sendBroadcast(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"WrongConstant"})
    public static boolean g(int i2, Context context) {
        try {
            String strA = a(context);
            if (TextUtils.isEmpty(strA)) {
                return false;
            }
            q.d(h.class.getSimpleName(), "setVivoBadge :" + strA);
            Intent intent = new Intent();
            intent.setAction("launcher.action.CHANGE_APPLICATION_NOTIFICATION_NUM");
            intent.putExtra("packageName", context.getPackageName());
            intent.putExtra("className", strA);
            intent.putExtra("notificationNum", i2);
            if (Build.VERSION.SDK_INT >= 26) {
                intent.addFlags(16777216);
            }
            context.sendBroadcast(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean setCount(int i2, Context context) {
        if (i2 < 0 || context == null) {
            return false;
        }
        String str = Build.BRAND;
        Log.d("BRAND", str);
        String lowerCase = str.toLowerCase();
        lowerCase.hashCode();
        switch (lowerCase) {
            case "huawei":
            case "honor":
                return c(i2, context);
            case "lenovo":
            case "htc":
            case "sony":
                return false;
            case "xiaomi":
                return true;
            case "oppo":
                return d(i2, context) || e(i2, context);
            case "vivo":
                return g(i2, context);
            case "samsung":
                return f(i2, context);
            default:
                return setNotificationBadge(i2, context);
        }
    }

    public static boolean setNotificationBadge(int i2, Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (notificationManager == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(AgooConstants.KEY_BADGE, AgooConstants.KEY_BADGE, 3);
            notificationChannel.setShowBadge(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }
        NotificationCompat.Builder contentText = new NotificationCompat.Builder(context, AgooConstants.KEY_BADGE).setContentTitle("应用角标").setContentText("您有" + i2 + "条未读消息");
        Resources resources = context.getResources();
        int i3 = R.drawable.ic_default;
        contentText.setLargeIcon(BitmapFactory.decodeResource(resources, i3)).setSmallIcon(i3).setAutoCancel(true).setChannelId(AgooConstants.KEY_BADGE).setNumber(i2).setBadgeIconType(1).build();
        return true;
    }
}
