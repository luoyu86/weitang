package com.chinavisionary.core.app.ad.base;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import c.e.a.d.q;
import com.chinavisionary.core.R;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseAd {
    public String TAG = getClass().getSimpleName();
    public String mAdPostId;

    public BaseAd(String str) {
        this.mAdPostId = str;
    }

    public ImageView createBannerAdDefaultView(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.drawable.core_lib_ic_load_img_failed);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return imageView;
    }

    public void d(String str) {
        q.d(this.TAG, str);
    }
}
