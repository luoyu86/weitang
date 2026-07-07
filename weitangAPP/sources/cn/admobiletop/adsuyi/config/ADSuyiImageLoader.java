package cn.admobiletop.adsuyi.config;

import android.content.Context;
import android.widget.ImageView;
import cn.admobiletop.adsuyi.listener.ADSuyiImageLoaderCallback;

/* JADX INFO: loaded from: classes.dex */
public interface ADSuyiImageLoader {
    void loadImage(Context context, String str, ImageView imageView);

    void loadImage(Context context, String str, ImageView imageView, ADSuyiImageLoaderCallback aDSuyiImageLoaderCallback);
}
