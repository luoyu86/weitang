package com.tianmu.ad.base;

import android.view.View;
import com.tianmu.ad.base.BaseAd;
import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.listener.VideoAdListener;
import com.tianmu.ad.model.ITianmuNativeVideoAd;
import com.tianmu.c.j.b;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.listener.a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseView<T extends BaseAd, E extends BaseAdInfo> extends BaseAdTouchView implements b, VideoAdListener {
    public a imageLoaderCallback;
    private T m;
    public E n;

    public BaseView(T t) {
        super(t.getContext());
        this.imageLoaderCallback = new a() { // from class: com.tianmu.ad.base.BaseView.1
            @Override // com.tianmu.listener.a, com.tianmu.g.e
            public void onError() {
                super.onError();
                E e2 = BaseView.this.n;
                if (e2 != null) {
                    e2.a(TianmuErrorConfig.AD_GIVE_POLISH_IMAGE_ERROR, TianmuErrorConfig.MSG_AD_GIVE_POLISH_IMAGE_ERROR);
                }
            }

            @Override // com.tianmu.listener.a, com.tianmu.g.e
            public void onSuccess() {
                super.onSuccess();
                E e2 = BaseView.this.n;
                if (e2 != null && e2.getAdInfoStatus() != null) {
                    BaseView.this.n.getAdInfoStatus().c(true);
                }
                BaseView.this.onAdExpose();
            }
        };
        this.m = t;
    }

    public void clickHidView() {
    }

    public T getAd() {
        return this.m;
    }

    public E getAdInfo() {
        return this.n;
    }

    public abstract View getClickView();

    public boolean isExpose() {
        E e2 = this.n;
        if (e2 != null) {
            return e2.isExpose(e2.getUseKey());
        }
        return false;
    }

    public void onAdExpose() {
        T t = this.m;
        if (t == null || t.getListener() == null || this.n == null || !isExpose() || getClickView() == null) {
            return;
        }
        this.m.onAdExpose(getAdInfo());
    }

    @Override // com.tianmu.ad.listener.VideoAdListener
    public void onVideoCache(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
    }

    @Override // com.tianmu.ad.listener.VideoAdListener
    public void onVideoCoverLoadError() {
    }

    @Override // com.tianmu.ad.listener.VideoAdListener
    public void onVideoCoverLoadSuccess() {
        E e2 = this.n;
        if (e2 != null && e2.getAdInfoStatus() != null) {
            this.n.getAdInfoStatus().c(true);
        }
        onAdExpose();
    }

    @Override // com.tianmu.ad.listener.VideoAdListener
    public void onVideoError(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
        if (this.n.a() != null) {
            this.n.a().onVideoError(iTianmuNativeVideoAd);
        }
    }

    @Override // com.tianmu.ad.listener.VideoAdListener
    public void onVideoFinish(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
        if (this.n.a() != null) {
            this.n.a().onVideoFinish(iTianmuNativeVideoAd);
        }
    }

    @Override // com.tianmu.ad.listener.VideoAdListener
    public void onVideoPause(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
        if (this.n.a() != null) {
            this.n.a().onVideoPause(iTianmuNativeVideoAd);
        }
    }

    @Override // com.tianmu.ad.listener.VideoAdListener
    public void onVideoResume(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
    }

    @Override // com.tianmu.ad.listener.VideoAdListener
    public void onVideoStart(ITianmuNativeVideoAd iTianmuNativeVideoAd) {
        E e2 = this.n;
        if (e2 != null && e2.getAdInfoStatus() != null) {
            this.n.getAdInfoStatus().d(true);
        }
        onAdExpose();
        if (this.n.a() != null) {
            this.n.a().onVideoStart(iTianmuNativeVideoAd);
        }
    }

    @Override // com.tianmu.c.j.b
    public void onViewExpose() {
        E e2 = this.n;
        if (e2 != null && e2.getAdInfoStatus() != null) {
            this.n.getAdInfoStatus().e(true);
        }
        onAdExpose();
    }

    public void release() {
    }

    public abstract void releaseExposeChecker();

    public void setAdInfo(E e2) {
        this.n = e2;
        if (e2.getAdData() != null) {
            this.n.getAdData().readyTouch(this);
            if (this.n.getAdData().isVideo()) {
                ((ITianmuNativeVideoAd) e2.getAdData()).registerVideoListener(this);
            }
        }
    }

    public abstract void startExposeChecker();
}
