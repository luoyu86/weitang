package com.tianmu.ad.bean;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tianmu.ad.NativeAd;
import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.listener.NativeVideoAdListener;
import com.tianmu.ad.listener.VideoAdListener;
import com.tianmu.ad.model.ITianmuNativeVideoAd;
import com.tianmu.c.i.h;
import com.tianmu.c.i.l;
import com.tianmu.c.j.a;
import com.tianmu.c.j.b;
import com.tianmu.c.m.c;
import com.tianmu.utils.TianmuViewUtil;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NativeAdInfo extends BaseAdInfo implements b {
    private NativeAd t;
    private ViewGroup u;
    private a v;

    public NativeAdInfo(@NonNull NativeAd nativeAd, @NonNull Context context, c cVar) {
        super(cVar);
        this.t = nativeAd;
    }

    public String getAdTarget() {
        return getAdData() == null ? "" : getAdData().e();
    }

    public String getDesc() {
        return getAdData() == null ? "" : getAdData().getDesc();
    }

    public String getImageUrl() {
        return getAdData() == null ? "" : getAdData().getImageUrl();
    }

    public List<String> getImageUrls() {
        if (getAdData() == null) {
            return null;
        }
        return getAdData().getImageUrlList();
    }

    public View getMediaView(ViewGroup viewGroup) {
        TianmuViewUtil.releaseClickTouchListener(viewGroup, new View[0]);
        if (isVideo()) {
            return ((h) getAdData()).getAdView(viewGroup.getContext(), this.f10638g, this.f10639h);
        }
        return null;
    }

    public String getTitle() {
        return getAdData() == null ? "" : getAdData().getTitle();
    }

    public boolean isVideo() {
        return getAdData() != null && (getAdData() instanceof ITianmuNativeVideoAd) && getAdData().isVideo();
    }

    public void onAdContainerClick(List<View> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.get(i2).setOnClickListener(new com.tianmu.c.l.a() { // from class: com.tianmu.ad.bean.NativeAdInfo.2
                @Override // com.tianmu.c.l.a
                public void onSingleClick(View view) {
                    if (NativeAdInfo.this.t != null) {
                        NativeAdInfo.this.t.onAdClick(view, NativeAdInfo.this, 0);
                    }
                }
            });
        }
    }

    @Override // com.tianmu.c.j.b
    public void onViewExpose() {
        NativeAd nativeAd = this.t;
        if (nativeAd != null) {
            nativeAd.onAdExpose(this);
        }
    }

    @Override // com.tianmu.ad.base.BaseAdInfo
    public void pause() {
        if (isVideo() && getAdData() != null && (getAdData() instanceof h)) {
            ((h) getAdData()).g0();
        }
    }

    public void registerCloseView(View view) {
        view.setOnClickListener(new com.tianmu.c.l.a() { // from class: com.tianmu.ad.bean.NativeAdInfo.1
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view2) {
                if (NativeAdInfo.this.t != null) {
                    NativeAdInfo.this.t.onAdClose(NativeAdInfo.this);
                }
            }
        });
    }

    public void registerView(@NonNull ViewGroup viewGroup, View... viewArr) {
        this.u = viewGroup;
        if (getAdData() != null) {
            getAdData().readyTouch(this.u);
        }
        render();
        List<View> listAsList = null;
        if (viewArr != null && viewArr.length > 0) {
            listAsList = Arrays.asList(viewArr);
        }
        onAdContainerClick(listAsList);
    }

    @Override // com.tianmu.ad.base.BaseAdInfo
    public void release() {
        super.release();
    }

    public void render() {
        if (isAvailable()) {
            if (this.u != null) {
                a aVar = new a(this);
                this.v = aVar;
                aVar.a(this.u);
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

    public void setVideoListener(final NativeVideoAdListener nativeVideoAdListener) {
        if (!isVideo() || getAdData() == null || !(getAdData() instanceof h) || nativeVideoAdListener == null) {
            return;
        }
        ((h) getAdData()).registerVideoListener(new VideoAdListener(this) { // from class: com.tianmu.ad.bean.NativeAdInfo.3
            @Override // com.tianmu.ad.listener.VideoAdListener
            public void onVideoCache(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
            }

            @Override // com.tianmu.ad.listener.VideoAdListener
            public void onVideoCoverLoadError() {
            }

            @Override // com.tianmu.ad.listener.VideoAdListener
            public void onVideoCoverLoadSuccess() {
            }

            @Override // com.tianmu.ad.listener.VideoAdListener
            public void onVideoError(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
                NativeVideoAdListener nativeVideoAdListener2 = nativeVideoAdListener;
                if (nativeVideoAdListener2 != null) {
                    nativeVideoAdListener2.onVideoError(iTianmuNativeVideoAd);
                }
            }

            @Override // com.tianmu.ad.listener.VideoAdListener
            public void onVideoFinish(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
                NativeVideoAdListener nativeVideoAdListener2 = nativeVideoAdListener;
                if (nativeVideoAdListener2 != null) {
                    nativeVideoAdListener2.onVideoFinish(iTianmuNativeVideoAd);
                }
            }

            @Override // com.tianmu.ad.listener.VideoAdListener
            public void onVideoPause(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
                NativeVideoAdListener nativeVideoAdListener2 = nativeVideoAdListener;
                if (nativeVideoAdListener2 != null) {
                    nativeVideoAdListener2.onVideoPause(iTianmuNativeVideoAd);
                }
            }

            @Override // com.tianmu.ad.listener.VideoAdListener
            public void onVideoResume(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
                NativeVideoAdListener nativeVideoAdListener2 = nativeVideoAdListener;
                if (nativeVideoAdListener2 != null) {
                    nativeVideoAdListener2.onVideoStart(iTianmuNativeVideoAd);
                }
            }

            @Override // com.tianmu.ad.listener.VideoAdListener
            public void onVideoStart(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
                NativeVideoAdListener nativeVideoAdListener2 = nativeVideoAdListener;
                if (nativeVideoAdListener2 != null) {
                    nativeVideoAdListener2.onVideoStart(iTianmuNativeVideoAd);
                }
            }
        });
    }

    public NativeAdInfo(l lVar, @NonNull NativeAd nativeAd, @NonNull Context context, boolean z, int i2, c cVar) {
        super(cVar);
        a(lVar);
        this.t = nativeAd;
        this.f10637f = z;
        this.f10638g = new com.tianmu.j.a.c.a(z);
        this.f10639h = i2;
    }
}
