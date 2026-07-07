package me.leolin.shortcutbadger.impl;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import e.a.a.a;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class XiaomiHomeBadger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ResolveInfo f14931a;

    @TargetApi(16)
    public final void a(Context context, int i2) throws a {
        if (this.f14931a == null) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            this.f14931a = context.getPackageManager().resolveActivity(intent, 65536);
        }
        if (this.f14931a != null) {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            Notification notificationBuild = new Notification.Builder(context).setContentTitle("").setContentText("").setSmallIcon(this.f14931a.getIconResource()).build();
            try {
                Object obj = notificationBuild.getClass().getDeclaredField("extraNotification").get(notificationBuild);
                obj.getClass().getDeclaredMethod("setMessageCount", Integer.TYPE).invoke(obj, Integer.valueOf(i2));
                notificationManager.notify(0, notificationBuild);
            } catch (Exception e2) {
                throw new a("not able to set badge", e2);
            }
        }
    }

    public void executeBadge(Context context, ComponentName componentName, int i2) throws a {
        Object objValueOf;
        try {
            Object objNewInstance = Class.forName("android.app.MiuiNotification").newInstance();
            Field declaredField = objNewInstance.getClass().getDeclaredField("messageCount");
            declaredField.setAccessible(true);
            if (i2 == 0) {
                objValueOf = "";
            } else {
                try {
                    objValueOf = Integer.valueOf(i2);
                } catch (Exception unused) {
                    declaredField.set(objNewInstance, Integer.valueOf(i2));
                }
            }
            declaredField.set(objNewInstance, String.valueOf(objValueOf));
        } catch (Exception unused2) {
            Intent intent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
            intent.putExtra("android.intent.extra.update_application_component_name", componentName.getPackageName() + "/" + componentName.getClassName());
            intent.putExtra("android.intent.extra.update_application_message_text", String.valueOf(i2 != 0 ? Integer.valueOf(i2) : ""));
            try {
                e.a.a.b.a.sendIntentExplicitly(context, intent);
            } catch (a unused3) {
            }
        }
        if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi")) {
            a(context, i2);
        }
    }

    public List<String> getSupportLaunchers() {
        return Arrays.asList("com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2", "com.i.miui.launcher");
    }
}
