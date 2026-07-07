package cn.admobiletop.adsuyi.a.n;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.admobiletop.adsuyi.ad.ADSuyiSplashAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;
import cn.admobiletop.adsuyi.ad.data.IBaseRelease;
import cn.admobiletop.adsuyi.ad.expose.ADSuyiExposeChecker;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiSplashAdListener;
import cn.admobiletop.adsuyi.ad.widget.ADSuyiInterceptContainer;
import cn.admobiletop.adsuyi.listener.ADSuyiSplashSkipListener;
import cn.admobiletop.adsuyi.util.ADSuyiDisplayUtil;
import cn.admobiletop.adsuyi.util.ADSuyiViewUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends ADSuyiInterceptContainer implements IBaseRelease {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f3467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CountDownTimer f3468c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ADSuyiAdInfo f3470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f3471f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3472g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List<Long> f3473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ADSuyiSplashSkipListener f3474i;
    public int j;
    public ADSuyiSplashAd k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;

    public g(Context context) {
        super(context);
        this.f3471f = 1.0f;
        this.j = 0;
    }

    private void setCustomSkipText(long j) {
        if (this.f3467b != null) {
            if (getCountDownTime() - j >= 1000) {
                this.f3467b.setAlpha(this.f3471f);
                this.f3467b.setClickable(true);
            }
            if (getSplashAdListener() != null) {
                long jMin = Math.min(getCountDownTime() / 1000, Math.round(j / 1000.0f));
                if (this.f3473h == null) {
                    this.f3473h = new ArrayList();
                }
                if (this.f3473h.contains(Long.valueOf(jMin))) {
                    return;
                }
                getSplashAdListener().onADTick(jMin);
                this.f3473h.add(Long.valueOf(jMin));
            }
        }
    }

    private void setDefaultSkipText(long j) {
        if (this.f3467b != null) {
            if (getCountDownTime() - j >= 1000) {
                this.f3467b.setAlpha(this.f3471f);
            }
            ((TextView) this.f3467b).setText(Math.min(getCountDownTime() / 1000, Math.round(j / 1000.0f)) + " 跳过");
        }
    }

    private void setSkipClickListener(boolean z) {
        View view;
        if (!z || (view = this.f3467b) == null) {
            return;
        }
        view.setOnClickListener(new d(this));
    }

    public final RelativeLayout.LayoutParams a(Context context, boolean z, int i2, int i3) {
        int i4 = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        int statusBarHeight = z ? ADSuyiDisplayUtil.getStatusBarHeight(context) + i4 : i4;
        if (i2 == 0 || i3 == 0) {
            layoutParams.topMargin = statusBarHeight;
            layoutParams.rightMargin = i4 / 3;
        } else {
            layoutParams.topMargin = i3 / 15;
            layoutParams.rightMargin = i2 / 13;
        }
        return layoutParams;
    }

    public void addActionButtonView() {
        addView(ADSuyiViewUtil.getActionButtonView(getContext(), "点击跳转至详情页或第三方应用"), ADSuyiViewUtil.getActionButtonViewLayoutParams(getContext()));
    }

    public void addSkipView() {
        g(this.l, this.m);
        setSkipText(getCountDownTime());
        this.f3467b.setAlpha(1.0f);
    }

    public final void b() {
        CountDownTimer countDownTimer = this.f3468c;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f3468c = null;
        }
    }

    public void d(ADSuyiAdInfo aDSuyiAdInfo, View view, int i2, boolean z, boolean z2, ADSuyiSplashAd aDSuyiSplashAd) {
        this.f3470e = aDSuyiAdInfo;
        this.f3467b = view;
        this.j = i2;
        this.k = aDSuyiSplashAd;
        this.l = z;
        this.m = z2;
    }

    public final void e(boolean z, boolean z2) {
        View view = this.f3467b;
        if (view != null) {
            ADSuyiViewUtil.removeSelfFromParent(view);
            addView(this.f3467b, a(getContext(), z, this.n, this.o));
            this.f3467b.setAlpha(0.0f);
            this.f3467b.setClickable(false);
            setSkipClickListener(z2);
        }
    }

    public final void f(boolean z) {
        View view = this.f3467b;
        if (view != null) {
            view.setAlpha(0.0f);
            this.f3467b.setClickable(false);
            if (z) {
                this.f3467b.setOnClickListener(new e(this));
            }
        }
    }

    public void forceAddSkipView() {
        this.j = 0;
        if (this.f3467b == null) {
            this.f3467b = ADSuyiViewUtil.getDefaultSkipView(getContext());
        }
        g(this.l, this.m);
        setSkipText(getCountDownTime());
        this.f3467b.setAlpha(1.0f);
        startCountDown();
    }

    public final void g(boolean z, boolean z2) {
        if (this.j == 1) {
            f(z2);
        } else {
            e(z, z2);
        }
    }

    public long getCountDownTime() {
        if (getCustomCountDownTime() < 3000 || getCustomCountDownTime() > 5500 || this.j != 1) {
            return 5500L;
        }
        return getCustomCountDownTime();
    }

    public abstract long getCustomCountDownTime();

    public abstract View getCustomSkipTextView();

    public abstract ADSuyiExposeChecker getExposeChecker();

    public abstract ADSuyiSplashAdListener getSplashAdListener();

    public final void i(boolean z) {
        b();
        if (this.f3469d) {
            return;
        }
        this.f3469d = true;
        if (getSplashAdListener() == null || this.f3470e == null) {
            return;
        }
        if (z) {
            getSplashAdListener().onAdSkip(this.f3470e);
            ADSuyiSplashSkipListener aDSuyiSplashSkipListener = this.f3474i;
            if (aDSuyiSplashSkipListener != null) {
                aDSuyiSplashSkipListener.onAdSkip();
            }
        }
        getSplashAdListener().onAdClose(this.f3470e);
    }

    public boolean isSetSkipView() {
        return this.k.getSplashCustomSkipSdks().contains(this.f3470e.getPlatform());
    }

    public boolean isTimeover() {
        return this.f3472g;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.n == 0) {
            this.n = getMeasuredWidth();
        }
        if (this.o == 0) {
            this.o = getMeasuredHeight();
        }
    }

    @Override // cn.admobiletop.adsuyi.ad.data.IBaseRelease
    public void release() {
        release(true);
    }

    public void removeCustomSkipView() {
        View view = this.f3467b;
        if (view == null || this.j != 1) {
            return;
        }
        view.setVisibility(8);
    }

    public void setSkipText(long j) {
        if (this.j == 1) {
            setCustomSkipText(j);
        } else {
            setDefaultSkipText(j);
        }
    }

    public void setSplashSkipListener(ADSuyiSplashSkipListener aDSuyiSplashSkipListener) {
        this.f3474i = aDSuyiSplashSkipListener;
    }

    public void startCountDown() {
        b();
        f fVar = new f(this, getCountDownTime(), 200L);
        this.f3468c = fVar;
        fVar.start();
    }

    public void release(boolean z) {
        if (z) {
            removeAllViews();
        }
        this.f3467b = null;
        this.f3470e = null;
        b();
    }
}
