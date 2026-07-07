package com.tianmu.config;

import android.content.Context;
import android.widget.ImageView;
import com.tianmu.listener.a;

/* JADX INFO: loaded from: classes2.dex */
public interface TianmuImageLoader {
    void loadImage(Context context, String str, ImageView imageView);

    void loadImage(Context context, String str, ImageView imageView, a aVar);

    void preloadImage(Context context, String str, ImageView imageView);
}
