package com.bumptech.glide.request.target;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.bumptech.glide.request.animation.GlideAnimation;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class NotificationTarget extends SimpleTarget<Bitmap> {
    private final Context context;
    private final Notification notification;
    private final int notificationId;
    private final RemoteViews remoteViews;
    private final int viewId;

    public NotificationTarget(Context context, RemoteViews remoteViews, int i2, Notification notification, int i3) {
        this(context, remoteViews, i2, Integer.MIN_VALUE, Integer.MIN_VALUE, notification, i3);
    }

    private void update() {
        ((NotificationManager) this.context.getSystemService("notification")).notify(this.notificationId, this.notification);
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        onResourceReady((Bitmap) obj, (GlideAnimation<? super Bitmap>) glideAnimation);
    }

    public NotificationTarget(Context context, RemoteViews remoteViews, int i2, int i3, int i4, Notification notification, int i5) {
        super(i3, i4);
        Objects.requireNonNull(context, "Context must not be null!");
        Objects.requireNonNull(notification, "Notification object can not be null!");
        Objects.requireNonNull(remoteViews, "RemoteViews object can not be null!");
        this.context = context;
        this.viewId = i2;
        this.notification = notification;
        this.notificationId = i5;
        this.remoteViews = remoteViews;
    }

    public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }
}
