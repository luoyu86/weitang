package com.tianmu.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tianmu.config.TianmuImageLoader;
import com.tianmu.g.r;

/* JADX INFO: loaded from: classes2.dex */
public class a implements TianmuImageLoader {
    @Override // com.tianmu.config.TianmuImageLoader
    public void loadImage(Context context, String str, ImageView imageView) {
        if (context == null || imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            r.a(context).a(str).a(Bitmap.Config.RGB_565).a(imageView);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.tianmu.config.TianmuImageLoader
    public void preloadImage(Context context, String str, ImageView imageView) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            r.a(context).a(str).a(Bitmap.Config.RGB_565).a(imageView);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.tianmu.config.TianmuImageLoader
    public void loadImage(Context context, String str, ImageView imageView, com.tianmu.listener.a aVar) {
        if (context == null || imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            r.a(context).a(str).a(Bitmap.Config.RGB_565).a(imageView, aVar);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
