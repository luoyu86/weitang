package com.alibaba.sdk.android.push.notification;

import android.R;
import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.ams.common.logger.AmsLogger;
import com.alibaba.sdk.android.push.util.DownloadUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CustomNotificationBuilder {
    public static final String NOTIFICATION_ICON_RES_TYPE = "drawable";
    public static final String NOTIFICATION_LARGE_ICON_FILE = "alicloud_notification_largeicon";
    public static final String NOTIFICATION_SMALL_ICON_FILE = "alicloud_notification_smallicon";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AmsLogger f4995a = AmsLogger.getLogger("MPS:CustomNotificationBuilder");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static CustomNotificationBuilder f4996c = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, Object> f4997b;

    private CustomNotificationBuilder() {
        this.f4997b = null;
        if (0 == 0) {
            this.f4997b = new HashMap();
        }
    }

    private int a(Context context, b bVar) {
        int iF = bVar.f();
        if (iF != 0) {
            return iF;
        }
        int iC = com.alibaba.sdk.android.push.common.global.b.c() != 0 ? com.alibaba.sdk.android.push.common.global.b.c() : context.getResources().getIdentifier(NOTIFICATION_SMALL_ICON_FILE, NOTIFICATION_ICON_RES_TYPE, context.getPackageName());
        int i2 = R.drawable.stat_notify_chat;
        try {
            i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e2) {
            f4995a.e("Get system icon error, package name not found, ", e2);
        }
        return iC == 0 ? i2 : iC;
    }

    private Bitmap a(Drawable drawable) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x019b  */
    /* JADX WARN: Type inference failed for: r0v18, types: [androidx.core.app.NotificationCompat$Style] */
    /* JADX WARN: Type inference failed for: r0v20, types: [androidx.core.app.NotificationCompat$BigTextStyle] */
    /* JADX WARN: Type inference failed for: r0v25, types: [android.app.Notification$BigPictureStyle] */
    /* JADX WARN: Type inference failed for: r0v31, types: [android.app.Notification$Style] */
    /* JADX WARN: Type inference failed for: r0v33, types: [android.app.Notification$BigTextStyle] */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.core.app.NotificationCompat$BigPictureStyle] */
    /* JADX WARN: Type inference failed for: r23v0, types: [com.alibaba.sdk.android.push.notification.NotificationConfigure] */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.core.app.NotificationCompat$Builder] */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.app.Notification$Builder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.app.Notification b(android.content.Context r20, com.alibaba.sdk.android.push.notification.b r21, com.alibaba.sdk.android.push.notification.PushData r22, com.alibaba.sdk.android.push.notification.NotificationConfigure r23) {
        /*
            Method dump skipped, instruction units count: 824
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.push.notification.CustomNotificationBuilder.b(android.content.Context, com.alibaba.sdk.android.push.notification.b, com.alibaba.sdk.android.push.notification.PushData, com.alibaba.sdk.android.push.notification.NotificationConfigure):android.app.Notification");
    }

    private Bitmap b(Context context, b bVar) {
        Bitmap bitmapDownloadImage = !TextUtils.isEmpty(bVar.r()) ? DownloadUtil.downloadImage(context, bVar.r(), "image") : null;
        if (bitmapDownloadImage != null) {
            return bitmapDownloadImage;
        }
        if (com.alibaba.sdk.android.push.common.global.b.b() != null) {
            return com.alibaba.sdk.android.push.common.global.b.b();
        }
        int identifier = context.getResources().getIdentifier(NOTIFICATION_LARGE_ICON_FILE, NOTIFICATION_ICON_RES_TYPE, context.getPackageName());
        return identifier != 0 ? a(context.getResources().getDrawable(identifier)) : bitmapDownloadImage;
    }

    private Notification c(Context context, b bVar, PushData pushData, NotificationConfigure notificationConfigure) {
        int iK;
        int iN;
        StringBuilder sb;
        Uri uri;
        StringBuilder sb2;
        Uri uri2;
        String strA = bVar.a();
        f4995a.d("building advanced custom notification");
        if (bVar.j() == 0) {
            return null;
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), bVar.j());
        remoteViews.setTextViewText(bVar.l(), bVar.b());
        remoteViews.setTextViewText(bVar.m(), bVar.c());
        if (bVar.n() != 0) {
            iK = bVar.k();
            iN = bVar.n();
        } else {
            iK = bVar.k();
            iN = R.drawable.stat_notify_chat;
        }
        remoteViews.setImageViewResource(iK, iN);
        String strX = bVar.x();
        String strY = bVar.y();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 16) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setContent(remoteViews).setPriority(bVar.p()).setSmallIcon(a(context, bVar)).setTicker("").setShowWhen(true).setWhen(System.currentTimeMillis());
            if (!TextUtils.isEmpty(bVar.z())) {
                String strZ = bVar.z();
                for (Field field : Notification.class.getDeclaredFields()) {
                    if (field.getName().equals(strZ)) {
                        try {
                            builder.setCategory((String) field.get(null));
                        } catch (IllegalAccessException unused) {
                            f4995a.e("set category error: " + strZ);
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(strX)) {
                builder.setGroup(strX);
            } else if (!TextUtils.isEmpty(strY)) {
                builder.setGroup(strY);
            }
            if (!TextUtils.isEmpty(strA)) {
                if (strA.startsWith("android.resource://")) {
                    uri = Uri.parse(strA);
                } else {
                    if (strA.startsWith("/raw/")) {
                        sb = new StringBuilder();
                        sb.append("android.resource://");
                        sb.append(context.getPackageName());
                    } else {
                        sb = new StringBuilder();
                        sb.append("android.resource://");
                        sb.append(context.getPackageName());
                        sb.append("/raw/");
                    }
                    sb.append(strA);
                    uri = Uri.parse(sb.toString());
                }
                builder.setSound(uri);
            }
            if (notificationConfigure != null) {
                notificationConfigure.configBuilder(builder, pushData);
            }
            return builder.build();
        }
        Notification.Builder builder2 = new Notification.Builder(context);
        builder2.setContent(remoteViews).setPriority(bVar.p()).setSmallIcon(a(context, bVar)).setTicker("").setWhen(System.currentTimeMillis());
        if (i2 >= 20) {
            if (!TextUtils.isEmpty(strX)) {
                builder2.setGroup(strX);
            } else if (!TextUtils.isEmpty(strY)) {
                builder2.setGroup(strY);
            }
        }
        if (i2 >= 17) {
            builder2.setShowWhen(true);
        }
        if (i2 >= 26 && !TextUtils.isEmpty(bVar.q())) {
            builder2.setChannelId(bVar.q());
        }
        if (!TextUtils.isEmpty(strA)) {
            if (strA.startsWith("android.resource://")) {
                uri2 = Uri.parse(strA);
            } else {
                if (strA.startsWith("/raw/")) {
                    sb2 = new StringBuilder();
                    sb2.append("android.resource://");
                    sb2.append(context.getPackageName());
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("android.resource://");
                    sb2.append(context.getPackageName());
                    sb2.append("/raw/");
                }
                sb2.append(strA);
                uri2 = Uri.parse(sb2.toString());
            }
            builder2.setSound(uri2);
        }
        if (notificationConfigure != null) {
            notificationConfigure.configBuilder(builder2, pushData);
        }
        if (i2 >= 21 && !TextUtils.isEmpty(bVar.z())) {
            String strZ2 = bVar.z();
            for (Field field2 : Notification.class.getDeclaredFields()) {
                if (field2.getName().equals(strZ2)) {
                    try {
                        builder2.setCategory((String) field2.get(null));
                    } catch (IllegalAccessException unused2) {
                        f4995a.e("set category error: " + strZ2);
                    }
                }
            }
        }
        return builder2.build();
    }

    public static CustomNotificationBuilder getInstance() {
        if (f4996c == null) {
            f4996c = new CustomNotificationBuilder();
        }
        return f4996c;
    }

    public Notification a(Context context, b bVar, PushData pushData, NotificationConfigure notificationConfigure) {
        if (2 == bVar.g()) {
            return b(context, bVar, pushData, notificationConfigure);
        }
        if (3 == bVar.g()) {
            return c(context, bVar, pushData, notificationConfigure);
        }
        return null;
    }

    public BasicCustomPushNotification a(int i2) {
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        BasicCustomPushNotification basicCustomPushNotification;
        if (this.f4997b.containsKey(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i2)) {
            f4995a.d("find custom notification from cache");
            return (BasicCustomPushNotification) this.f4997b.get(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i2);
        }
        f4995a.d("do not find custom notification from cache, find it from SharedPreferences");
        BasicCustomPushNotification basicCustomPushNotification2 = null;
        String string = com.alibaba.sdk.android.ams.common.a.a.h().getString(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i2, null);
        try {
            if (string == null) {
                f4995a.e("no corresponding custom notificaiton");
                return null;
            }
            try {
                byteArrayInputStream = new ByteArrayInputStream(URLDecoder.decode(string, "UTF-8").getBytes("ISO-8859-1"));
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                basicCustomPushNotification = (BasicCustomPushNotification) objectInputStream.readObject();
            } catch (OptionalDataException e2) {
                e = e2;
            } catch (StreamCorruptedException e3) {
                e = e3;
            } catch (UnsupportedEncodingException e4) {
                e = e4;
            } catch (IOException e5) {
                e = e5;
            } catch (ClassNotFoundException e6) {
                e = e6;
            }
            try {
                objectInputStream.close();
                byteArrayInputStream.close();
                f4995a.d(basicCustomPushNotification.toString());
                this.f4997b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i2, basicCustomPushNotification);
                return basicCustomPushNotification;
            } catch (OptionalDataException e7) {
                e = e7;
                basicCustomPushNotification2 = basicCustomPushNotification;
                f4995a.e("get custom notification failed", e);
                f4995a.d(basicCustomPushNotification2.toString());
                this.f4997b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i2, basicCustomPushNotification2);
                return basicCustomPushNotification2;
            } catch (StreamCorruptedException e8) {
                e = e8;
                basicCustomPushNotification2 = basicCustomPushNotification;
                f4995a.e("get custom notification failed", e);
                f4995a.d(basicCustomPushNotification2.toString());
                this.f4997b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i2, basicCustomPushNotification2);
                return basicCustomPushNotification2;
            } catch (UnsupportedEncodingException e9) {
                e = e9;
                basicCustomPushNotification2 = basicCustomPushNotification;
                f4995a.e("get custom notification failed", e);
                f4995a.d(basicCustomPushNotification2.toString());
                this.f4997b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i2, basicCustomPushNotification2);
                return basicCustomPushNotification2;
            } catch (IOException e10) {
                e = e10;
                basicCustomPushNotification2 = basicCustomPushNotification;
                f4995a.e("get custom notification failed", e);
                f4995a.d(basicCustomPushNotification2.toString());
                this.f4997b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i2, basicCustomPushNotification2);
                return basicCustomPushNotification2;
            } catch (ClassNotFoundException e11) {
                e = e11;
                basicCustomPushNotification2 = basicCustomPushNotification;
                f4995a.e("get custom notification failed", e);
                f4995a.d(basicCustomPushNotification2.toString());
                this.f4997b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i2, basicCustomPushNotification2);
                return basicCustomPushNotification2;
            } catch (Throwable unused) {
                basicCustomPushNotification2 = basicCustomPushNotification;
                f4995a.d(basicCustomPushNotification2.toString());
                this.f4997b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i2, basicCustomPushNotification2);
                return basicCustomPushNotification2;
            }
        } catch (Throwable unused2) {
        }
    }

    public boolean setCustomNotification(int i2, BasicCustomPushNotification basicCustomPushNotification) {
        AmsLogger amsLogger;
        String str;
        boolean z = false;
        if (com.alibaba.sdk.android.ams.common.a.a.a() == null) {
            amsLogger = f4995a;
            str = "need init push first";
        } else if (i2 <= 0) {
            amsLogger = f4995a;
            str = "custom notification id must be an integer greater than 0";
        } else {
            if (basicCustomPushNotification != null) {
                SharedPreferences sharedPreferencesH = com.alibaba.sdk.android.ams.common.a.a.h();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(basicCustomPushNotification);
                    String strEncode = URLEncoder.encode(byteArrayOutputStream.toString("ISO-8859-1"), "UTF-8");
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                    SharedPreferences.Editor editorEdit = sharedPreferencesH.edit();
                    editorEdit.putString(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i2, strEncode);
                    editorEdit.commit();
                    z = true;
                } catch (IOException e2) {
                    f4995a.e("get custom notification failed", e2);
                }
                if (z) {
                    if (this.f4997b.containsKey(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i2)) {
                        this.f4997b.remove(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i2);
                    }
                    f4995a.d("save the notification to cache");
                    this.f4997b.put(BasicCustomPushNotification.CUSTOM_NOTIFICATION_TAG + i2, basicCustomPushNotification);
                }
                return z;
            }
            amsLogger = f4995a;
            str = "notification cannot be null";
        }
        amsLogger.e(str);
        return false;
    }
}
