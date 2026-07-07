package com.chinavisionary.core.app.ad.manager;

import android.app.Activity;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.admobiletop.adsuyi.ad.data.ADSuyiInterstitialAdInfo;
import cn.admobiletop.adsuyi.util.ADSuyiDisplayUtil;
import com.chinavisionary.core.R;
import com.chinavisionary.core.app.ad.utils.ADSuyiViewFindUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiInterstitialManager {
    public static String PLATFORM_ADMOBILE = "admobile";
    public static String PLATFORM_GDT = "gdt";
    public static String PLATFORM_KUAISHOU = "ksad";
    public static String PLATFORM_TOUTIAO = "toutiao";
    private static ADSuyiInterstitialManager instance = null;
    public static int jumpTime = 6;
    private Activity adInterstitialActivity;
    private ADSuyiInterstitialAdInfo interstitialAdInfo;
    private boolean isDialog;
    private TextView jumpView;
    private List<View> views = new ArrayList();
    public CountDownTimer countDownTimer = new CountDownTimer(jumpTime * 1000, 1000) { // from class: com.chinavisionary.core.app.ad.manager.ADSuyiInterstitialManager.1
        @Override // android.os.CountDownTimer
        public void onFinish() {
            ADSuyiInterstitialManager.this.release();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            if (ADSuyiInterstitialManager.this.jumpView != null) {
                ADSuyiInterstitialManager.this.jumpView.setText(((int) (j / 1000)) + "s｜跳过");
            }
        }
    };

    private void gdtAddJumpButton() {
        setActivityViews();
        for (View view : this.views) {
            if (view.getClass().getName().contains("com.qq.e.comm.plugin.") && (view instanceof ViewGroup)) {
                ViewGroup viewGroup = (ViewGroup) view;
                TextView jumpView = getJumpView(viewGroup);
                this.jumpView = jumpView;
                viewGroup.addView(jumpView);
                startCountDown();
                return;
            }
        }
    }

    public static ADSuyiInterstitialManager getInstance() {
        if (instance == null) {
            synchronized (ADSuyiInterstitialManager.class) {
                if (instance == null) {
                    instance = new ADSuyiInterstitialManager();
                }
            }
        }
        return instance;
    }

    private void setActivityViews() {
        View viewTryGetTheFrontView = ADSuyiViewFindUtils.tryGetTheFrontView(this.adInterstitialActivity);
        if (viewTryGetTheFrontView != null) {
            traverse(viewTryGetTheFrontView);
        }
    }

    private void traverse(View view) {
        if (view.getAlpha() == 0.0f || view.getVisibility() != 0) {
            return;
        }
        this.views.add(view);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                traverse(viewGroup.getChildAt(i2));
            }
        }
    }

    public void addJumpView(ADSuyiInterstitialAdInfo aDSuyiInterstitialAdInfo, Activity activity) {
        this.interstitialAdInfo = aDSuyiInterstitialAdInfo;
        this.views.clear();
        if (activity == null || activity.isFinishing() || TextUtils.isEmpty(aDSuyiInterstitialAdInfo.getPlatform())) {
            return;
        }
        if (aDSuyiInterstitialAdInfo.getPlatform().equals(PLATFORM_GDT)) {
            this.adInterstitialActivity = activity;
            this.isDialog = true;
            gdtAddJumpButton();
        } else if (aDSuyiInterstitialAdInfo.getPlatform().equals(PLATFORM_TOUTIAO)) {
            this.isDialog = false;
            toutiaoAddJumpButton();
        } else if (aDSuyiInterstitialAdInfo.getPlatform().equals(PLATFORM_KUAISHOU)) {
            this.adInterstitialActivity = activity;
            this.isDialog = true;
        }
    }

    public TextView getJumpView(ViewGroup viewGroup) {
        TextView textView = new TextView(viewGroup.getContext());
        textView.setText(jumpTime + "s｜跳过");
        textView.setTextColor(-1);
        textView.setPadding(ADSuyiDisplayUtil.dp2px(10), ADSuyiDisplayUtil.dp2px(5), ADSuyiDisplayUtil.dp2px(10), ADSuyiDisplayUtil.dp2px(5));
        textView.setBackgroundResource(R.drawable.shape_black_000000_radius15);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = ADSuyiDisplayUtil.dp2px(10);
        layoutParams.leftMargin = ADSuyiDisplayUtil.dp2px(10);
        textView.setLayoutParams(layoutParams);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.chinavisionary.core.app.ad.manager.ADSuyiInterstitialManager.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ADSuyiInterstitialManager.this.release();
            }
        });
        return textView;
    }

    public void release() {
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        if (this.isDialog) {
            ADSuyiInterstitialAdInfo aDSuyiInterstitialAdInfo = this.interstitialAdInfo;
            if (aDSuyiInterstitialAdInfo != null) {
                aDSuyiInterstitialAdInfo.release();
                this.interstitialAdInfo = null;
                return;
            }
            return;
        }
        Activity activity = this.adInterstitialActivity;
        if (activity != null) {
            activity.finish();
            this.adInterstitialActivity = null;
        }
    }

    public void setAdInterstitialActivity(Activity activity) {
        this.adInterstitialActivity = activity;
    }

    public void startCountDown() {
        this.countDownTimer.cancel();
        this.countDownTimer.start();
    }

    public void toutiaoAddJumpButton() {
        ViewGroup viewGroup = (ViewGroup) this.adInterstitialActivity.findViewById(android.R.id.content);
        if (viewGroup == null || viewGroup.getChildCount() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt != null && (childAt instanceof FrameLayout)) {
                ViewGroup viewGroup2 = (ViewGroup) childAt;
                TextView jumpView = getJumpView(viewGroup2);
                this.jumpView = jumpView;
                viewGroup2.addView(jumpView);
                startCountDown();
                return;
            }
        }
    }
}
