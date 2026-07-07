package com.tianmu.ad.widget.interstitialview.base;

import android.view.View;
import androidx.annotation.NonNull;
import com.tianmu.ad.InterstitialAd;
import com.tianmu.ad.base.BaseView;
import com.tianmu.ad.bean.InterstitialAdInfo;
import com.tianmu.c.j.a;

/* JADX INFO: loaded from: classes2.dex */
public class InterstitialExposeView extends BaseView<InterstitialAd, InterstitialAdInfo> {
    private a o;

    public InterstitialExposeView(@NonNull InterstitialAd interstitialAd) {
        super(interstitialAd);
    }

    @Override // com.tianmu.ad.base.BaseView
    public View getClickView() {
        return this;
    }

    @Override // com.tianmu.ad.base.BaseView
    public void onAdExpose() {
        E e2 = this.n;
        if (e2 != 0 && ((InterstitialAdInfo) e2).getAdInfoStatus() != null) {
            ((InterstitialAdInfo) this.n).getAdInfoStatus().c(true);
        }
        super.onAdExpose();
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
        startExposeChecker();
    }

    @Override // com.tianmu.ad.base.BaseView
    public void startExposeChecker() {
        a aVar = new a(this);
        this.o = aVar;
        aVar.a(this);
    }
}
