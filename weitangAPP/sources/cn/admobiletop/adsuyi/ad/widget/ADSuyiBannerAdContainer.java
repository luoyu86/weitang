package cn.admobiletop.adsuyi.ad.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.RelativeLayout;
import cn.admobiletop.adsuyi.ad.entity.ADSuyiAdSize;
import cn.admobiletop.adsuyi.ad.expose.ADSuyiExposeChecker;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class ADSuyiBannerAdContainer extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiAdSize f3554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Rect f3557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Handler f3558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ADSuyiExposeChecker f3559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Runnable f3560h;

    public ADSuyiBannerAdContainer(Context context, long j, ADSuyiAdSize aDSuyiAdSize) {
        super(context);
        this.f3555c = false;
        this.f3557e = new Rect();
        this.f3558f = new Handler(Looper.getMainLooper());
        this.f3560h = new Runnable() { // from class: cn.admobiletop.adsuyi.ad.widget.ADSuyiBannerAdContainer.1
            @Override // java.lang.Runnable
            public void run() {
                if (ADSuyiBannerAdContainer.this.b()) {
                    ADSuyiBannerAdContainer.this.onRefresh();
                } else {
                    ADSuyiBannerAdContainer.this.startRefreshDelayed();
                }
            }
        };
        this.f3553a = j;
        if (aDSuyiAdSize == null) {
            aDSuyiAdSize = new ADSuyiAdSize(640, 100);
        } else if (aDSuyiAdSize.getWidth() <= 0 || aDSuyiAdSize.getHeight() <= 0) {
            aDSuyiAdSize.setWidth(640);
            aDSuyiAdSize.setHeight(100);
        }
        this.f3554b = aDSuyiAdSize;
    }

    public void a(String str) {
        if (this.f3555c) {
            ADSuyiLogUtil.d(str);
        }
    }

    public boolean b() {
        int i2;
        int i3;
        int i4;
        if (getVisibility() != 0) {
            a("广告控件不可见");
        } else if (hasWindowFocus()) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (measuredWidth > 50 && measuredHeight > 50) {
                this.f3557e.set(0, 0, 0, 0);
                getLocalVisibleRect(this.f3557e);
                Rect rect = this.f3557e;
                int i5 = rect.left;
                return i5 >= 0 && (i2 = rect.right) <= measuredWidth && (i3 = rect.top) >= 0 && (i4 = rect.bottom) <= measuredHeight && i2 - i5 >= measuredWidth / 2 && i4 - i3 >= measuredHeight / 2;
            }
            a("广告控件宽高小于最小宽高");
        } else {
            a("广告控件没有WindowFocus");
        }
        return false;
    }

    public final void c() {
        ADSuyiExposeChecker aDSuyiExposeChecker = this.f3559g;
        if (aDSuyiExposeChecker != null) {
            aDSuyiExposeChecker.releaseExposeCheck();
            this.f3559g = null;
        }
    }

    public final void e() {
        Handler handler = this.f3558f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(RelativeLayout.getDefaultSize(0, i2), RelativeLayout.getDefaultSize(0, i3));
        int measuredWidth = getMeasuredWidth();
        int iMin = (Math.min(measuredWidth, this.f3556d) * this.f3554b.getHeight()) / this.f3554b.getWidth();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, WXVideoFileObject.FILE_SIZE_LIMIT);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, WXVideoFileObject.FILE_SIZE_LIMIT);
        int i4 = this.f3556d;
        if (i4 != 0) {
            measuredWidth = Math.min(measuredWidth, i4);
        }
        this.f3556d = measuredWidth;
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec2);
    }

    public abstract void onRefresh();

    public void refreshView(View view, View view2, ADSuyiExposeChecker aDSuyiExposeChecker) {
        c();
        this.f3559g = aDSuyiExposeChecker;
        if (view == null || this.f3558f == null) {
            return;
        }
        if (aDSuyiExposeChecker != null) {
            aDSuyiExposeChecker.startExposeCheck(view);
        }
        ADSuyiViewUtil.removeSelfFromParent(view);
        addView(view, 0, new RelativeLayout.LayoutParams(-1, -1));
        if (view2 != null) {
            ADSuyiViewUtil.addDefaultCloseIcon(view2, this);
        }
        startRefreshDelayed();
    }

    public void release() {
        c();
        e();
        this.f3558f = null;
    }

    public void startRefreshDelayed() {
        Handler handler;
        e();
        long j = this.f3553a;
        if (j <= 0 || (handler = this.f3558f) == null) {
            return;
        }
        handler.postDelayed(this.f3560h, j);
    }
}
