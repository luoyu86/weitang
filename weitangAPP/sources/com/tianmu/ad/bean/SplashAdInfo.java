package com.tianmu.ad.bean;

import android.view.View;
import com.tianmu.ad.base.BaseAdInfo;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.biz.widget.j;
import com.tianmu.c.c.e;
import com.tianmu.c.i.l;
import com.tianmu.c.m.f;
import com.tianmu.config.TianmuErrorConfig;

/* JADX INFO: loaded from: classes2.dex */
public class SplashAdInfo extends BaseAdInfo {
    private j t;
    private boolean u;

    public SplashAdInfo(l lVar, f fVar) {
        super(fVar);
        a(lVar);
    }

    public View getSplashAdView() {
        if (this.u) {
            return this.t;
        }
        j jVar = this.t;
        if (jVar != null) {
            jVar.init();
            this.u = true;
        }
        return this.t;
    }

    @Override // com.tianmu.ad.base.BaseAdInfo
    public void release() {
        super.release();
        j jVar = this.t;
        if (jVar != null) {
            jVar.release();
            this.t = null;
        }
    }

    public void render() {
        if (hasShow()) {
            a(TianmuErrorConfig.AD_ALREADY_SHOW_ERROR, TianmuErrorConfig.MSG_AD_ALREADY_SHOW_ERROR);
            return;
        }
        if (isAvailable()) {
            if (this.t.getParent() == null) {
                e eVar = this.f10632a;
                if (eVar != null) {
                    eVar.onAdFailed(new TianmuError(TianmuErrorConfig.SPLASH_AD_VIEW_NO_PARENT_GROUP, TianmuErrorConfig.MSG_SPLASH_AD_VIEW_NO_PARENT_GROUP));
                    return;
                }
                return;
            }
            j jVar = this.t;
            if (jVar != null) {
                jVar.render();
            }
            setHasShow(true);
        }
    }

    public void setSplashAdView(j jVar) {
        this.t = jVar;
    }
}
