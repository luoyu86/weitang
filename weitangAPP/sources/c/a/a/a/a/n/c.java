package c.a.a.a.a.n;

import android.R;
import android.app.Notification;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.RingtoneManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.aliyun.ams.emas.push.AgooMessageReceiver;
import com.taobao.accs.utl.ALog;
import java.util.Random;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes.dex */
public class c extends e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Random f830f;

    public static String g(String str) {
        try {
            Class<?>[] clsArr = {String.class};
            Object[] objArr = {str};
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", clsArr).invoke(cls, objArr);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean h() {
        try {
            String strG = g("ro.vivo.os.build.display.id");
            if (!Build.MANUFACTURER.equalsIgnoreCase(AgooConstants.MESSAGE_SYSTEM_SOURCE_VIVO) && !strG.startsWith("Funtouch")) {
                String strG2 = g("ro.iqoo.os.build.display.id");
                if (strG2 == null) {
                    return false;
                }
                if (TextUtils.isEmpty(strG2.trim())) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // c.a.a.a.a.n.e
    public Notification a(Context context) {
        int i2;
        try {
            i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.icon;
        } catch (PackageManager.NameNotFoundException e2) {
            ALog.e("BasicNotificationBuilder", "Get system icon error, package name not found, ", e2, new Object[0]);
            i2 = R.drawable.stat_notify_chat;
        }
        Bitmap bitmapF = f(context.getResources().getDrawable(i2));
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 16) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            builder.setContentTitle(a()).setContentText(b()).setSmallIcon(i2).setVibrate(new long[]{100, 250, 100, 250, 100, 250}).setSound(RingtoneManager.getDefaultUri(2)).setAutoCancel(true).setPriority(c()).setLargeIcon(bitmapF).setTicker("").setWhen(System.currentTimeMillis()).setShowWhen(true);
            if (!TextUtils.isEmpty(e())) {
                builder.setGroup(e());
            }
            return builder.build();
        }
        Notification.Builder builder2 = new Notification.Builder(context);
        builder2.setContentTitle(a()).setContentText(b()).setSmallIcon(i2).setVibrate(new long[]{100, 250, 100, 250, 100, 250}).setSound(RingtoneManager.getDefaultUri(2)).setPriority(c()).setAutoCancel(true).setLargeIcon(bitmapF).setWhen(System.currentTimeMillis()).setTicker("");
        if (i3 >= 20 && !TextUtils.isEmpty(e())) {
            builder2.setGroup(e());
        }
        if (i3 >= 17) {
            builder2.setShowWhen(true);
        }
        if (i3 >= 26 && !TextUtils.isEmpty(d())) {
            builder2.setChannelId(d());
        }
        if (i3 >= 20) {
            if (h()) {
                builder2.setGroupSummary(true);
                if (f830f == null) {
                    f830f = new Random(System.currentTimeMillis());
                }
                builder2.setGroup(AgooMessageReceiver.NOTIFICATION_GROUP + f830f.nextInt());
            } else {
                builder2.setGroupSummary(false);
                builder2.setGroup(AgooMessageReceiver.NOTIFICATION_GROUP);
            }
        }
        return builder2.build();
    }

    public final Bitmap f(Drawable drawable) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }
}
