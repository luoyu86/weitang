package cn.admobiletop.adsuyi.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import cn.admobiletop.adsuyi.c.A;
import cn.admobiletop.adsuyi.config.ADSuyiImageLoader;
import cn.admobiletop.adsuyi.listener.ADSuyiImageLoaderCallback;

/* JADX INFO: loaded from: classes.dex */
public class a implements ADSuyiImageLoader {
    @Override // cn.admobiletop.adsuyi.config.ADSuyiImageLoader
    public void loadImage(Context context, String str, ImageView imageView) {
        if (context == null || imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        try {
            A.a(context).a(str).a(imageView);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // cn.admobiletop.adsuyi.config.ADSuyiImageLoader
    public void loadImage(Context context, String str, ImageView imageView, ADSuyiImageLoaderCallback aDSuyiImageLoaderCallback) {
        if (context == null || imageView == null || TextUtils.isEmpty(str)) {
            return;
        }
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return;
        }
        try {
            A.a(context).a(str).a(imageView, aDSuyiImageLoaderCallback);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
