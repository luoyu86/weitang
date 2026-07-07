package com.tianmu.ad.widget.banneradview.base;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tianmu.ad.BannerAd;
import com.tianmu.ad.base.BaseView;
import com.tianmu.ad.bean.BannerAdInfo;
import com.tianmu.ad.entity.TianmuAdSize;
import com.tianmu.c.j.a;
import com.tianmu.utils.TianmuLogUtil;
import com.tianmu.utils.TianmuViewUtil;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseBannerViewContainer extends BaseView<BannerAd, BannerAdInfo> {
    public View bannerView;
    public a exposeChecker;
    private final long o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f10692q;
    public boolean r;
    private TianmuAdSize s;
    private Rect t;
    private Handler u;
    private Runnable v;

    public BaseBannerViewContainer(BannerAd bannerAd, long j, TianmuAdSize tianmuAdSize) {
        super(bannerAd);
        this.t = new Rect();
        this.u = new Handler(Looper.getMainLooper());
        this.v = new Runnable() { // from class: com.tianmu.ad.widget.banneradview.base.BaseBannerViewContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (BaseBannerViewContainer.this.c()) {
                    BaseBannerViewContainer.this.onRefresh();
                } else {
                    BaseBannerViewContainer.this.startRefreshDelayed();
                }
            }
        };
        this.o = j;
        if (tianmuAdSize == null) {
            tianmuAdSize = new TianmuAdSize(640, 100);
        } else if (tianmuAdSize.getWidth() <= 0 || tianmuAdSize.getHeight() <= 0) {
            tianmuAdSize.setWidth(640);
            tianmuAdSize.setHeight(100);
        }
        this.s = tianmuAdSize;
    }

    public boolean c() {
        int i2;
        int i3;
        int i4;
        if (getVisibility() != 0) {
            TianmuLogUtil.iD("广告控件不可见");
        } else if (hasWindowFocus()) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (measuredWidth > 50 && measuredHeight > 50) {
                this.t.set(0, 0, 0, 0);
                getLocalVisibleRect(this.t);
                Rect rect = this.t;
                int i5 = rect.left;
                return i5 >= 0 && (i2 = rect.right) <= measuredWidth && (i3 = rect.top) >= 0 && (i4 = rect.bottom) <= measuredHeight && i2 - i5 >= measuredWidth / 2 && i4 - i3 >= measuredHeight / 2;
            }
            TianmuLogUtil.d("广告控件宽高小于最小宽高");
        } else {
            TianmuLogUtil.iD("广告控件没有WindowFocus");
        }
        return false;
    }

    public abstract void d();

    public int getContainerHeight() {
        return this.f10692q;
    }

    public int getContainerWidth() {
        return this.p;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(RelativeLayout.getDefaultSize(0, i2), RelativeLayout.getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        int height = (this.s.getHeight() * measuredWidth) / this.s.getWidth();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, WXVideoFileObject.FILE_SIZE_LIMIT);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(height, WXVideoFileObject.FILE_SIZE_LIMIT);
        if (!this.r && measuredWidth > 0 && height > 0) {
            this.r = true;
            this.p = measuredWidth;
            this.f10692q = height;
            d();
        }
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec2);
    }

    public abstract void onRefresh();

    public void refreshView(View view, a aVar) {
        releaseExposeChecker();
        this.exposeChecker = aVar;
        this.bannerView = view;
        if (view != null) {
            startExposeChecker();
            TianmuViewUtil.removeSelfFromParent(view);
            addView(view, 0, new RelativeLayout.LayoutParams(-1, -1));
            startRefreshDelayed();
        }
    }

    @Override // com.tianmu.ad.base.BaseView
    public void release() {
        releaseExposeChecker();
        removeHandler();
        this.u = null;
    }

    @Override // com.tianmu.ad.base.BaseView
    public void releaseExposeChecker() {
        a aVar = this.exposeChecker;
        if (aVar != null) {
            aVar.c();
            this.exposeChecker = null;
        }
    }

    public void removeHandler() {
        Handler handler = this.u;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.tianmu.ad.base.BaseView
    public void startExposeChecker() {
        a aVar = this.exposeChecker;
        if (aVar != null) {
            aVar.a(this.bannerView);
        }
    }

    public void startRefreshDelayed() {
        Handler handler;
        removeHandler();
        long j = this.o;
        if (j <= 0 || (handler = this.u) == null) {
            return;
        }
        handler.postDelayed(this.v, j);
    }
}
