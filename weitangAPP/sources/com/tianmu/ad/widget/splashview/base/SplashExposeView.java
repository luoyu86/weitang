package com.tianmu.ad.widget.splashview.base;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tianmu.TianmuSDK;
import com.tianmu.ad.SplashAd;
import com.tianmu.ad.base.BaseView;
import com.tianmu.ad.bean.SplashAdInfo;
import com.tianmu.c.j.a;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.utils.TianmuDisplayUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SplashExposeView extends BaseView<SplashAd, SplashAdInfo> {
    private a o;

    public SplashExposeView(@NonNull SplashAd splashAd, @NonNull SplashAdInfo splashAdInfo) {
        super(splashAd);
        setAdInfo(splashAdInfo);
    }

    @Override // com.tianmu.ad.base.BaseView
    public View getClickView() {
        return this;
    }

    public abstract void onExposureError(int i2, String str);

    @Override // com.tianmu.ad.base.BaseView, com.tianmu.c.j.b
    public void onViewExpose() {
        int height = ((ViewGroup) getParent()).getHeight();
        int screenHeight = TianmuDisplayUtil.getScreenHeight();
        if (((double) height) / ((double) screenHeight) < 0.75d) {
            onExposureError(TianmuErrorConfig.SPLASH_AD_HEIGHT_ERROR, String.format(TianmuErrorConfig.MSG_SPLASH_AD_HEIGHT_ERROR, Integer.valueOf(height), Integer.valueOf(screenHeight)));
        } else {
            super.onViewExpose();
        }
    }

    @Override // com.tianmu.ad.base.BaseView
    public void release() {
        super.release();
        releaseExposeChecker();
    }

    @Override // com.tianmu.ad.base.BaseView
    public void releaseExposeChecker() {
        a aVar = this.o;
        if (aVar != null) {
            aVar.c();
            this.o = null;
        }
    }

    public void render() {
        releaseExposeChecker();
        if (TianmuSDK.getInstance().isFlutter()) {
            this.o = new a(false, this);
        } else {
            this.o = new a(this);
        }
        startExposeChecker();
    }

    @Override // com.tianmu.ad.base.BaseView
    public void startExposeChecker() {
        a aVar = this.o;
        if (aVar != null) {
            aVar.a(this);
        }
    }
}
