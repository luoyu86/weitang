package com.tianmu.ad.widget.banneradview.factory;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tianmu.TianmuSDK;
import com.tianmu.listener.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BannerBase extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f10694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f10695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f10696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f10697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f10698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f10699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f10700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f10701h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f10702i;
    public ViewGroup j;
    private a k;

    public BannerBase(Context context) {
        super(context);
        initView();
        initBannerView();
    }

    public static BannerBase init(Context context, int i2, a aVar) {
        return init(context, i2, "", aVar);
    }

    public void getADImageLoaderCallback(a aVar) {
        this.k = aVar;
    }

    public abstract View getClickView();

    public ImageView getCloseView() {
        return this.f10701h;
    }

    public abstract View getView();

    public void initBannerView() {
    }

    public abstract void initView();

    public void release() {
    }

    public void setBannerData(String str, String str2, String str3, String str4, String str5) {
        TextView textView;
        TianmuSDK.getInstance().getImageLoader().loadImage(this.f10694a.getContext(), str, this.f10694a, this.k);
        TextView textView2 = this.f10696c;
        if (textView2 != null) {
            textView2.setText(str2);
        }
        TextView textView3 = this.f10697d;
        if (textView3 != null) {
            textView3.setText(str3);
        }
        TextView textView4 = this.f10700g;
        if (textView4 != null) {
            textView4.setText(str4);
        }
        if (TextUtils.isEmpty(str5) || (textView = this.f10699f) == null) {
            return;
        }
        textView.setText(str5);
        this.f10699f.setVisibility(0);
    }

    public abstract void setConfigView(int i2, int i3);

    /* JADX WARN: Removed duplicated region for block: B:14:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tianmu.ad.widget.banneradview.factory.BannerBase init(android.content.Context r1, int r2, java.lang.String r3, com.tianmu.listener.a r4) {
        /*
            r0 = 1
            if (r2 == r0) goto L17
            r0 = 2
            if (r2 == r0) goto L11
            r3 = 4
            if (r2 == r3) goto Lb
            r1 = 0
            goto L1d
        Lb:
            com.tianmu.ad.widget.banneradview.factory.BannerAdPicView r2 = new com.tianmu.ad.widget.banneradview.factory.BannerAdPicView
            r2.<init>(r1)
            goto L1c
        L11:
            com.tianmu.ad.widget.banneradview.factory.BannerAdLeftPic150View r2 = new com.tianmu.ad.widget.banneradview.factory.BannerAdLeftPic150View
            r2.<init>(r1, r3)
            goto L1c
        L17:
            com.tianmu.ad.widget.banneradview.factory.BannerAdLeftPicView r2 = new com.tianmu.ad.widget.banneradview.factory.BannerAdLeftPicView
            r2.<init>(r1)
        L1c:
            r1 = r2
        L1d:
            if (r1 == 0) goto L22
            r1.getADImageLoaderCallback(r4)
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tianmu.ad.widget.banneradview.factory.BannerBase.init(android.content.Context, int, java.lang.String, com.tianmu.listener.a):com.tianmu.ad.widget.banneradview.factory.BannerBase");
    }

    public BannerBase(Context context, String str) {
        super(context);
        this.f10702i = str;
        initView();
        initBannerView();
    }
}
