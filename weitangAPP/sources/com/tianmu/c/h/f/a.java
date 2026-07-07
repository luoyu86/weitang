package com.tianmu.c.h.f;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tianmu.biz.utils.y;
import com.tianmu.c.f.c;
import com.tianmu.c.f.c1;
import com.tianmu.c.f.r;

/* JADX INFO: loaded from: classes2.dex */
public class a extends RemoteViews {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f11651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NotificationManager f11652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Notification f11653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f11657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f11658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f11659i;
    private long j;
    private int k;
    private boolean l;

    public a(Context context, int i2, String str, String str2, String str3, String str4, String str5) {
        super(context.getPackageName(), r.f11495a);
        this.f11651a = context;
        this.f11654d = i2;
        this.f11655e = str;
        this.f11656f = str2;
        this.f11657g = str3;
        this.f11658h = str4;
        this.f11659i = str5;
        j();
        h();
        i();
        a(str4);
        k();
        e();
    }

    private void h() {
        this.f11652b = (NotificationManager) this.f11651a.getSystemService("notification");
    }

    private Notification i() {
        if (this.f11653c == null) {
            PendingIntent pendingIntentA = com.tianmu.c.h.e.a.a(".tianmu.action.download.notice.stop.click", this.f11655e, this.f11656f, this.f11657g, this.f11654d);
            Notification.Builder contentText = new Notification.Builder(this.f11651a).setContentTitle(this.f11658h).setContentText(this.f11658h);
            int i2 = c.r;
            Notification.Builder largeIcon = contentText.setSmallIcon(i2).setDeleteIntent(pendingIntentA).setLargeIcon(BitmapFactory.decodeResource(this.f11651a.getResources(), i2));
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 24) {
                largeIcon.setContent(this);
            } else if (y.m()) {
                largeIcon.setCustomBigContentView(this);
            } else {
                largeIcon.setCustomBigContentView(this);
                largeIcon.setContent(this);
            }
            if (i3 >= 26) {
                this.f11652b.createNotificationChannel(new NotificationChannel(String.valueOf(this.f11654d), this.f11656f, 1));
                largeIcon.setChannelId(String.valueOf(this.f11654d));
            }
            this.f11653c = largeIcon.build();
        }
        return this.f11653c;
    }

    private void j() {
        setOnClickPendingIntent(r.f11498d, com.tianmu.c.h.e.a.a(".tianmu.action.download.notice.start.click", this.f11655e, this.f11656f, this.f11657g, this.f11654d));
        setOnClickPendingIntent(r.f11499e, com.tianmu.c.h.e.a.a(".tianmu.action.download.notice.pause.click", this.f11655e, this.f11656f, this.f11657g, this.f11654d));
        setOnClickPendingIntent(r.f11500f, com.tianmu.c.h.e.a.a(".tianmu.action.download.notice.stop.click", this.f11655e, this.f11656f, this.f11657g, this.f11654d));
        setOnClickPendingIntent(r.f11501g, com.tianmu.c.h.e.a.a(".tianmu.action.download.notice.click", this.f11655e, this.f11656f, this.f11657g, this.f11654d));
    }

    private void k() {
        com.tianmu.g.r.a(this.f11651a).a(this.f11659i).a(this, r.f11496b, this.f11654d, this.f11653c);
        if (TextUtils.isEmpty(this.f11659i)) {
            setImageViewResource(r.f11497c, c.f11283i);
        } else {
            setImageViewResource(r.f11497c, c.j);
        }
    }

    public boolean a(int i2) {
        boolean z = false;
        if (this.l) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ((i2 > this.k && jCurrentTimeMillis - this.j > 1000) || i2 == 100) {
            if (i2 == 100) {
                this.l = true;
            }
            this.j = jCurrentTimeMillis;
            z = true;
        }
        this.k = i2;
        return z;
    }

    public void b() {
        NotificationManager notificationManager = this.f11652b;
        if (notificationManager != null) {
            notificationManager.cancel(this.f11654d);
        }
    }

    public void c() {
        Notification notification;
        NotificationManager notificationManager = this.f11652b;
        if (notificationManager == null || (notification = this.f11653c) == null) {
            return;
        }
        notificationManager.notify(this.f11654d, notification);
    }

    public void d() {
        Notification notification;
        NotificationManager notificationManager = this.f11652b;
        if (notificationManager == null || (notification = this.f11653c) == null) {
            return;
        }
        notificationManager.notify(this.f11654d, notification);
    }

    public void e() {
        Context context = this.f11651a;
        if (context != null) {
            setTextViewText(r.k, context.getText(c1.f11298f));
        }
        setViewVisibility(r.f11498d, 8);
        setViewVisibility(r.f11499e, 0);
        if (TextUtils.isEmpty(this.f11659i)) {
            setImageViewResource(r.f11497c, c.f11281g);
        } else {
            setImageViewResource(r.f11497c, c.f11282h);
        }
    }

    public void f() {
        Context context = this.f11651a;
        if (context != null) {
            setTextViewText(r.k, context.getText(c1.f11299g));
        }
        setViewVisibility(r.f11498d, 0);
        setViewVisibility(r.f11499e, 8);
        if (TextUtils.isEmpty(this.f11659i)) {
            setImageViewResource(r.f11497c, c.f11283i);
        } else {
            setImageViewResource(r.f11497c, c.j);
        }
    }

    public void g() {
        setTextViewText(r.f11502h, this.k + "%");
        setProgressBar(r.f11503i, 100, this.k, false);
    }

    public void a(String str) {
        setTextViewText(r.j, str);
    }

    public int a() {
        return this.k;
    }
}
