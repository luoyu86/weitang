package com.bumptech.glide.request.target;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.bumptech.glide.request.animation.GlideAnimation;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class AppWidgetTarget extends SimpleTarget<Bitmap> {
    private final ComponentName componentName;
    private final Context context;
    private final RemoteViews remoteViews;
    private final int viewId;
    private final int[] widgetIds;

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i2, int i3, int i4, int... iArr) {
        super(i3, i4);
        Objects.requireNonNull(context, "Context can not be null!");
        Objects.requireNonNull(iArr, "WidgetIds can not be null!");
        if (iArr.length == 0) {
            throw new IllegalArgumentException("WidgetIds must have length > 0");
        }
        Objects.requireNonNull(remoteViews, "RemoteViews object can not be null!");
        this.context = context;
        this.remoteViews = remoteViews;
        this.viewId = i2;
        this.widgetIds = iArr;
        this.componentName = null;
    }

    private void update() {
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.context);
        ComponentName componentName = this.componentName;
        if (componentName != null) {
            appWidgetManager.updateAppWidget(componentName, this.remoteViews);
        } else {
            appWidgetManager.updateAppWidget(this.widgetIds, this.remoteViews);
        }
    }

    @Override // com.bumptech.glide.request.target.Target
    public /* bridge */ /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        onResourceReady((Bitmap) obj, (GlideAnimation<? super Bitmap>) glideAnimation);
    }

    public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
        this.remoteViews.setImageViewBitmap(this.viewId, bitmap);
        update();
    }

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i2, int... iArr) {
        this(context, remoteViews, i2, Integer.MIN_VALUE, Integer.MIN_VALUE, iArr);
    }

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i2, int i3, int i4, ComponentName componentName) {
        super(i3, i4);
        Objects.requireNonNull(context, "Context can not be null!");
        Objects.requireNonNull(componentName, "ComponentName can not be null!");
        Objects.requireNonNull(remoteViews, "RemoteViews object can not be null!");
        this.context = context;
        this.remoteViews = remoteViews;
        this.viewId = i2;
        this.componentName = componentName;
        this.widgetIds = null;
    }

    public AppWidgetTarget(Context context, RemoteViews remoteViews, int i2, ComponentName componentName) {
        this(context, remoteViews, i2, Integer.MIN_VALUE, Integer.MIN_VALUE, componentName);
    }
}
