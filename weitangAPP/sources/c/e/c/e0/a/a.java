package c.e.c.e0.a;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.alibaba.fastjson.JSON;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.chinavisionary.microtang.R;
import com.chinavisionary.microtang.msg.vo.MsgVo;
import com.chinavisionary.microtang.push.PushMsgActivity;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f1428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NotificationManager f1429b;

    public static a getInstance() {
        if (f1428a == null) {
            synchronized (a.class) {
                if (f1428a == null) {
                    f1428a = new a();
                }
            }
        }
        return f1428a;
    }

    public void recycler() {
        NotificationManager notificationManager = this.f1429b;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
    }

    public void requestNotification(Context context) {
        if (requestNotificationEnabled(context)) {
            return;
        }
        Intent intent = new Intent();
        if (Build.VERSION.SDK_INT >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
        } else {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts(AbsServerManager.PACKAGE_QUERY_BINDER, context.getPackageName(), null));
        }
        context.startActivity(intent);
    }

    public boolean requestNotificationEnabled(Context context) {
        return NotificationManagerCompat.from(context).areNotificationsEnabled();
    }

    public void startNotification(Context context, MsgVo msgVo) {
        NotificationCompat.Builder builder;
        if (this.f1429b == null) {
            this.f1429b = (NotificationManager) context.getSystemService("notification");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (this.f1429b.getNotificationChannel("default_channel_id") == null) {
                NotificationChannel notificationChannel = new NotificationChannel("default_channel_id", "Default Channel", 4);
                notificationChannel.setLightColor(-16711936);
                notificationChannel.enableVibration(true);
                this.f1429b.createNotificationChannel(notificationChannel);
            }
            builder = new NotificationCompat.Builder(context, "default_channel_id");
        } else {
            builder = new NotificationCompat.Builder(context);
        }
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);
        builder.setDefaults(-1);
        builder.setContentText(msgVo.getContent());
        builder.setContentTitle(msgVo.getTitle());
        Intent intent = new Intent(context, (Class<?>) PushMsgActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("key", JSON.toJSONString(msgVo));
        intent.putExtras(bundle);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.notifition_layout);
        remoteViews.setTextViewText(R.id.tv_title, msgVo.getTitle());
        remoteViews.setTextViewText(R.id.tv_content, msgVo.getContent());
        builder.setCustomBigContentView(remoteViews);
        builder.setContentIntent(activity);
        this.f1429b.notify(0, builder.build());
    }
}
