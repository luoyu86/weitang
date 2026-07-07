package com.tianmu.ad.bean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tianmu.ad.NativeExpressAd;
import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.base.BaseView;
import com.tianmu.ad.listener.NativeVideoAdListener;
import com.tianmu.ad.model.ITianmuNativeVideoAd;
import com.tianmu.ad.widget.NativeExpressView;
import com.tianmu.c.i.h;
import com.tianmu.c.i.l;
import com.tianmu.c.l.a;
import com.tianmu.c.m.d;
import com.tianmu.utils.TianmuViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public class NativeExpressAdInfo extends BaseAdInfo {
    private NativeExpressAd t;
    private BaseView u;
    private Context v;
    private Integer w;

    public NativeExpressAdInfo(@NonNull NativeExpressAd nativeExpressAd, @NonNull Context context, d dVar) {
        super(dVar);
        this.t = nativeExpressAd;
        this.v = context;
    }

    public String getAction() {
        return getAdData() == null ? "" : getAdData().b();
    }

    public String getDesc() {
        return getAdData() == null ? "" : getAdData().getDesc();
    }

    public String getImageUrl() {
        return getAdData() == null ? "" : getAdData().getImageUrl();
    }

    public View getMediaView(FrameLayout frameLayout) {
        TianmuViewUtil.releaseClickTouchListener(frameLayout, new View[0]);
        if (!isVideo() || !(getAdData() instanceof h)) {
            return null;
        }
        ((h) getAdData()).a(this.w);
        return ((h) getAdData()).getAdView(frameLayout.getContext(), this.f10638g, getVideoAutoPlayType());
    }

    public View getNativeExpressAdView() {
        if (this.u == null) {
            this.u = new NativeExpressView(this.t, this, this.v);
        }
        return this.u;
    }

    public String getTitle() {
        return getAdData() == null ? "" : getAdData().getTitle();
    }

    public View getViewGroup() {
        return this.u;
    }

    public boolean isVideo() {
        return getAdData() != null && (getAdData() instanceof ITianmuNativeVideoAd) && getAdData().isVideo();
    }

    public void onAdContainerClick(RelativeLayout relativeLayout) {
        relativeLayout.setOnClickListener(new a() { // from class: com.tianmu.ad.bean.NativeExpressAdInfo.2
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view) {
                if (NativeExpressAdInfo.this.t != null) {
                    NativeExpressAdInfo.this.t.onAdClick(NativeExpressAdInfo.this.getViewGroup(), NativeExpressAdInfo.this, 0);
                    if (NativeExpressAdInfo.this.u != null) {
                        NativeExpressAdInfo.this.u.clickHidView();
                    }
                }
            }
        });
    }

    public void onAdSlideClick(ViewGroup viewGroup) {
        NativeExpressAd nativeExpressAd = this.t;
        if (nativeExpressAd != null) {
            nativeExpressAd.onAdClick(getViewGroup(), this, 2);
        }
    }

    @Override // com.tianmu.ad.base.BaseAdInfo
    public void pause() {
        if (isVideo() && getAdData() != null && (getAdData() instanceof h)) {
            ((h) getAdData()).g0();
        }
    }

    public void registerCloseView(ImageView imageView) {
        imageView.setOnClickListener(new a() { // from class: com.tianmu.ad.bean.NativeExpressAdInfo.1
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view) {
                if (NativeExpressAdInfo.this.t != null) {
                    NativeExpressAdInfo.this.t.onAdClose(NativeExpressAdInfo.this);
                }
            }
        });
    }

    @Override // com.tianmu.ad.base.BaseAdInfo
    public void release() {
        super.release();
        BaseView baseView = this.u;
        if (baseView != null) {
            TianmuViewUtil.removeSelfFromParent(baseView);
            this.u.release();
            this.u = null;
        }
    }

    public void render() {
        if (isAvailable()) {
            BaseView baseView = this.u;
            if (baseView != null) {
                baseView.startExposeChecker();
            }
            setHasShow(true);
        }
    }

    @Override // com.tianmu.ad.base.BaseAdInfo
    public void resume() {
        if (isVideo() && getAdData() != null && (getAdData() instanceof h)) {
            ((h) getAdData()).h0();
        }
    }

    public void setVideoListener(NativeVideoAdListener nativeVideoAdListener) {
        if (isVideo()) {
            this.f10640i = nativeVideoAdListener;
        }
    }

    public NativeExpressAdInfo(l lVar, @NonNull NativeExpressAd nativeExpressAd, @NonNull Context context, boolean z, int i2, d dVar, Integer num) {
        super(dVar);
        a(lVar);
        this.t = nativeExpressAd;
        this.v = context;
        this.f10637f = z;
        this.f10638g = new com.tianmu.j.a.c.a(z);
        this.w = num;
        this.f10639h = i2;
    }
}
