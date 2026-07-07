package com.tianmu.ad.widget.splashview.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tianmu.ad.SplashAd;
import com.tianmu.ad.activity.AdDetailActivity;
import com.tianmu.ad.activity.AdDownloadDetailActivity;
import com.tianmu.ad.activity.AppPermissionsActivity;
import com.tianmu.ad.activity.LandscapeAdDetailActivity;
import com.tianmu.ad.activity.LandscapeAdDownloadDetailActivity;
import com.tianmu.ad.activity.WebViewActivity;
import com.tianmu.ad.bean.SplashAdInfo;
import com.tianmu.biz.utils.e;
import com.tianmu.c.l.a;
import com.tianmu.utils.TianmuViewUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SplashSkipAdView extends BaseSplashAdViewContainer {
    private boolean A;
    private long B;
    private Application.ActivityLifecycleCallbacks C;
    private boolean u;
    private long v;
    private CountDownTimer w;
    private List<Long> x;
    private View y;
    private Application z;

    public SplashSkipAdView(@NonNull SplashAd splashAd, @NonNull SplashAdInfo splashAdInfo) {
        super(splashAd, splashAdInfo);
        this.A = false;
        this.C = new Application.ActivityLifecycleCallbacks() { // from class: com.tianmu.ad.widget.splashview.base.SplashSkipAdView.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(@NonNull Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(@NonNull Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(@NonNull Activity activity) {
                if (SplashSkipAdView.this.getContext() == activity && SplashSkipAdView.this.u) {
                    SplashSkipAdView.this.setOverTime(0L);
                    return;
                }
                if (SplashSkipAdView.this.A) {
                    if (activity.getClass().getName().equals(WebViewActivity.class.getName()) || activity.getClass().getName().equals(AppPermissionsActivity.class.getName())) {
                        return;
                    }
                    SplashSkipAdView splashSkipAdView = SplashSkipAdView.this;
                    splashSkipAdView.a(splashSkipAdView.B);
                    return;
                }
                if (!SplashSkipAdView.this.u || activity.getClass().getName().equals(AdDetailActivity.class.getName()) || activity.getClass().getName().equals(LandscapeAdDetailActivity.class.getName()) || activity.getClass().getName().equals(AdDownloadDetailActivity.class.getName()) || activity.getClass().getName().equals(LandscapeAdDownloadDetailActivity.class.getName())) {
                    return;
                }
                SplashSkipAdView.this.setOverTime(0L);
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(@NonNull Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(@NonNull Activity activity) {
            }
        };
        this.v = splashAd.getCountDownTime();
        if (getContext() == null || !(getContext() instanceof Activity) || ((Activity) getContext()).getApplication() == null || this.C == null) {
            this.z = e.b().a();
        } else {
            this.z = ((Activity) getContext()).getApplication();
        }
        Application application = this.z;
        if (application != null) {
            application.registerActivityLifecycleCallbacks(this.C);
        }
    }

    public void cancelCountDown() {
        CountDownTimer countDownTimer = this.w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.w = null;
        }
    }

    public abstract void g();

    public void refreshView(View view, View view2) {
        this.y = view2;
        a(this.v);
    }

    @Override // com.tianmu.c.c.g, com.tianmu.ad.base.IBaseRelease
    public void release() {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        super.release();
        Application application = this.z;
        if (application != null && (activityLifecycleCallbacks = this.C) != null) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
        this.z = null;
        this.C = null;
        cancelCountDown();
    }

    @Override // com.tianmu.ad.widget.splashview.base.BaseSplashAdViewContainer, com.tianmu.c.c.g
    public void render() {
        refreshView(this, i());
    }

    public void setNeedToMain() {
        this.u = true;
    }

    public void setOverTime(long j) {
        try {
            if (this.y.getVisibility() == 8) {
                this.y.setVisibility(0);
                if (((SplashAd) this.n).getCountDownTime() - j >= 1000) {
                    this.y.setAlpha(1.0f);
                    this.y.setClickable(true);
                }
            }
            if (((SplashAd) this.n).getSkipView() == null) {
                ((TextView) this.y).setText(Math.min(((SplashAd) this.n).getCountDownTime() / 1000, Math.round(j / 1000.0f)) + " | 跳过");
            }
            if (((SplashAd) this.n).getListener() != null) {
                long jMin = Math.min(((SplashAd) this.n).getCountDownTime() / 1000, Math.round(j / 1000.0f));
                if (this.x == null) {
                    this.x = new ArrayList();
                }
                if (!this.x.contains(Long.valueOf(jMin))) {
                    ((SplashAd) this.n).getListener().onAdTick(jMin);
                    this.x.add(Long.valueOf(jMin));
                }
                if (jMin == 0) {
                    cancelCountDown();
                    ((SplashAd) this.n).onAdClose(this.o);
                }
            }
        } catch (Exception unused) {
        }
    }

    private View i() {
        View defaultSkipView;
        if (f()) {
            defaultSkipView = ((SplashAd) this.n).getSkipView();
        } else {
            defaultSkipView = TianmuViewUtil.getDefaultSkipView(getContext());
            AD ad = this.n;
            addView(defaultSkipView, TianmuViewUtil.getDefaultJumpViewLayoutParams(ad != 0 ? ((SplashAd) ad).isImmersive() : true, 12, e()));
        }
        defaultSkipView.setOnClickListener(new a() { // from class: com.tianmu.ad.widget.splashview.base.SplashSkipAdView.3
            @Override // com.tianmu.c.l.a
            public void onSingleClick(View view) {
                if (SplashSkipAdView.this.n == null || SplashSkipAdView.this.o == null || ((SplashAdInfo) SplashSkipAdView.this.o).getAdInfoStatus() == null) {
                    return;
                }
                ((SplashAdInfo) SplashSkipAdView.this.o).getAdInfoStatus().b(true);
                SplashSkipAdView.this.g();
                SplashSkipAdView.this.cancelCountDown();
                if (((SplashAd) SplashSkipAdView.this.n).getListener() != null) {
                    ((SplashAd) SplashSkipAdView.this.n).onAdSkip((SplashAdInfo) SplashSkipAdView.this.o);
                }
                ((SplashAd) SplashSkipAdView.this.n).onAdClose(SplashSkipAdView.this.o);
            }
        });
        return defaultSkipView;
    }

    public void h() {
        this.A = true;
        cancelCountDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        cancelCountDown();
        CountDownTimer countDownTimer = new CountDownTimer(j, 200L) { // from class: com.tianmu.ad.widget.splashview.base.SplashSkipAdView.2
            @Override // android.os.CountDownTimer
            public void onFinish() {
                SplashSkipAdView.this.setOverTime(0L);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j2) {
                SplashSkipAdView.this.B = j2;
                SplashSkipAdView.this.setOverTime(j2);
            }
        };
        this.w = countDownTimer;
        countDownTimer.start();
    }
}
