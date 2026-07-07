package com.alibaba.sdk.android.push.notification;

import android.R;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import java.lang.reflect.Field;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {
    private static final AmsLogger o = AmsLogger.getLogger("MPS:BasicNotificationBuilder");

    private Bitmap a(Drawable drawable) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0203  */
    /* JADX WARN: Type inference failed for: r0v19, types: [androidx.core.app.NotificationCompat$BigPictureStyle] */
    /* JADX WARN: Type inference failed for: r0v34, types: [androidx.core.app.NotificationCompat$Style] */
    /* JADX WARN: Type inference failed for: r0v36, types: [androidx.core.app.NotificationCompat$BigTextStyle] */
    /* JADX WARN: Type inference failed for: r0v44, types: [android.app.Notification$BigPictureStyle] */
    /* JADX WARN: Type inference failed for: r0v63, types: [android.app.Notification$Style] */
    /* JADX WARN: Type inference failed for: r0v65, types: [android.app.Notification$BigTextStyle] */
    /* JADX WARN: Type inference failed for: r12v9, types: [android.app.Notification$Builder] */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.alibaba.sdk.android.push.notification.NotificationConfigure] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.core.app.NotificationCompat$Builder] */
    @Override // com.alibaba.sdk.android.push.notification.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.app.Notification a(android.content.Context r18, com.alibaba.sdk.android.push.notification.PushData r19, com.alibaba.sdk.android.push.notification.NotificationConfigure r20) {
        /*
            Method dump skipped, instruction units count: 926
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.push.notification.a.a(android.content.Context, com.alibaba.sdk.android.push.notification.PushData, com.alibaba.sdk.android.push.notification.NotificationConfigure):android.app.Notification");
    }

    @Override // com.alibaba.sdk.android.push.notification.c
    public Notification b(Context context, PushData pushData, NotificationConfigure notificationConfigure) {
        String strE = e();
        String strF = f();
        if (TextUtils.isEmpty(strE) && TextUtils.isEmpty(strF)) {
            o.d("body group and emas group all empty");
            return null;
        }
        int iC = com.alibaba.sdk.android.push.common.global.b.c() != 0 ? com.alibaba.sdk.android.push.common.global.b.c() : context.getResources().getIdentifier(CustomNotificationBuilder.NOTIFICATION_SMALL_ICON_FILE, CustomNotificationBuilder.NOTIFICATION_ICON_RES_TYPE, context.getPackageName());
        int i2 = R.drawable.stat_notify_chat;
        int i3 = 0;
        try {
            i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e2) {
            o.e("Get system icon error, package name not found, ", e2);
        }
        if (iC == 0) {
            iC = i2;
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 16) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setSmallIcon(iC);
            if (!TextUtils.isEmpty(g())) {
                String strG = g();
                for (Field field : Notification.class.getDeclaredFields()) {
                    if (field.getName().equals(strG)) {
                        try {
                            builder.setCategory((String) field.get(null));
                        } catch (IllegalAccessException unused) {
                            o.e("set category error: " + strG);
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(strE)) {
                builder.setGroup(strE);
            } else if (!TextUtils.isEmpty(strF)) {
                builder.setGroup(strF);
            }
            builder.setGroupSummary(true);
            NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
            if (!TextUtils.isEmpty(this.k)) {
                try {
                    JSONArray jSONArray = new JSONArray(this.k);
                    while (i3 < jSONArray.length()) {
                        inboxStyle.addLine(jSONArray.getString(i3));
                        i3++;
                    }
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            builder.setStyle(inboxStyle);
            return builder.build();
        }
        Notification.Builder builder2 = new Notification.Builder(context);
        builder2.setSmallIcon(iC);
        if (i4 >= 21 && !TextUtils.isEmpty(g())) {
            String strG2 = g();
            for (Field field2 : Notification.class.getDeclaredFields()) {
                if (field2.getName().equals(strG2)) {
                    try {
                        builder2.setCategory((String) field2.get(null));
                    } catch (IllegalAccessException unused2) {
                        o.e("set category error: " + strG2);
                    }
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 20) {
            if (!TextUtils.isEmpty(strE)) {
                builder2.setGroup(strE);
            } else if (!TextUtils.isEmpty(strF)) {
                builder2.setGroup(strF);
            }
            builder2.setGroupSummary(true);
        }
        Notification.InboxStyle inboxStyle2 = new Notification.InboxStyle();
        if (!TextUtils.isEmpty(this.k)) {
            try {
                JSONArray jSONArray2 = new JSONArray(this.k);
                while (i3 < jSONArray2.length()) {
                    inboxStyle2.addLine(jSONArray2.getString(i3));
                    i3++;
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        builder2.setStyle(inboxStyle2);
        if (Build.VERSION.SDK_INT >= 26 && !TextUtils.isEmpty(d())) {
            builder2.setChannelId(d());
        }
        return builder2.build();
    }
}
