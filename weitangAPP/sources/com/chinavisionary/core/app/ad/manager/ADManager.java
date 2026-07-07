package com.chinavisionary.core.app.ad.manager;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import c.e.a.a.b;
import c.e.a.a.h.c;
import c.e.a.d.g;
import c.e.a.d.l;
import c.e.a.d.q;
import c.e.a.d.w;
import c.e.a.d.x;
import com.chinavisionary.core.R;
import com.chinavisionary.core.app.ad.BannerAd;
import com.chinavisionary.core.app.ad.InterstitialAd;
import com.chinavisionary.core.app.ad.SplashAd;
import com.chinavisionary.core.app.ad.callback.ISplashHideCallback;
import com.chinavisionary.core.app.ad.utils.IADConstant;
import com.chinavisionary.core.app.net.base.dto.RequestErrDto;

/* JADX INFO: loaded from: classes.dex */
public class ADManager {
    public static final int OAID_VERSION = 1;
    private static final String TAG = "ADManager";
    private static volatile ADManager sADManager;
    private volatile boolean isInitAd = false;
    private final SplashAd mSplashAd = new SplashAd("7b572e7ee204575ab6");
    private final InterstitialAd mInterstitialAd = new InterstitialAd("c3384e056efe641ee5");
    private final InterstitialAd mLockInterstitialAd = new InterstitialAd("c3384e056efe641ee5");
    private final BannerAd mBannerAd = new BannerAd(IADConstant.ME_BANNER_AD_POS_ID);
    private final BannerAd mMainBannerAd = new BannerAd(IADConstant.MAIN_BANNER_AD_POS_ID);
    private final BannerAd mLifeBannerAd = new BannerAd(IADConstant.LIFE_BANNER_AD_POS_ID);
    private final BannerAd mActivityBannerAd = new BannerAd(IADConstant.ACTIVITY_BANNER_AD_POS_ID);

    public static ADManager getInstance() {
        if (sADManager == null) {
            synchronized (ADManager.class) {
                if (sADManager == null) {
                    sADManager = new ADManager();
                }
            }
        }
        return sADManager;
    }

    public FrameLayout createBannerAdFrameLayout(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    public FrameLayout createBannerFrameLayout(Context context, boolean z) {
        FrameLayout frameLayout = new FrameLayout(context);
        int i2 = b.getInstance().getResources().getDisplayMetrics().widthPixels;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(i2, (int) (((double) i2) * 0.67d));
        frameLayout.setBackgroundColor(context.getResources().getColor(R.color.color_white));
        frameLayout.setPadding(frameLayout.getResources().getDimensionPixelOffset(R.dimen.dp_20), frameLayout.getResources().getDimensionPixelOffset(R.dimen.dp_70), 0, 0);
        frameLayout.setLayoutParams(layoutParams);
        return frameLayout;
    }

    public LinearLayout createBannerLinearLayout(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    public FrameLayout createBannerMeFrameLayout(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        int dimensionPixelOffset = b.getInstance().getResources().getDisplayMetrics().widthPixels - context.getResources().getDimensionPixelOffset(R.dimen.dp_32);
        int i2 = (int) (((double) dimensionPixelOffset) * 0.67d);
        q.d(TAG, "createBannerMeFrameLayout width = " + dimensionPixelOffset + ",height=" + i2);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(dimensionPixelOffset, i2);
        frameLayout.setBackgroundColor(context.getResources().getColor(R.color.color_white));
        frameLayout.setPadding(frameLayout.getResources().getDimensionPixelOffset(R.dimen.dp_26), frameLayout.getResources().getDimensionPixelOffset(R.dimen.dp_16), 0, 0);
        frameLayout.setLayoutParams(layoutParams);
        return frameLayout;
    }

    public void initAd(Context context) {
        if (this.isInitAd) {
            return;
        }
        this.isInitAd = true;
        updateOAIDPem();
    }

    public void loadActivityBannerAd(Fragment fragment, ViewGroup viewGroup) {
        if (!this.isInitAd) {
            q.d(TAG, "loadActivityBannerAd not init ad");
        } else if (g.getInstance().isHasEnableActivityBannerAd()) {
            this.mActivityBannerAd.loadBannerAd(fragment, viewGroup);
        }
    }

    public void loadInterstitialAd(Activity activity) {
        if (!this.isInitAd) {
            q.d(TAG, "loadInterstitialAd not init ad");
        } else if (g.getInstance().isEnableInterstitialAd()) {
            this.mInterstitialAd.addInterstitialAd(activity);
        }
    }

    public void loadLifeBannerAd(Fragment fragment, ViewGroup viewGroup) {
        if (!this.isInitAd) {
            q.d(TAG, "loadLifeBannerAd not init ad");
        } else if (g.getInstance().isHasEnableLifeBannerAd()) {
            this.mLifeBannerAd.loadBannerAd(fragment, viewGroup);
        }
    }

    public void loadLockInterstitialAd(Activity activity) {
        if (!this.isInitAd) {
            q.d(TAG, "loadLockInterstitialAd not init ad");
        } else if (g.getInstance().isEnableLockInterstitialAd()) {
            this.mLockInterstitialAd.addInterstitialAd(activity);
        }
    }

    public void loadMainBannerAd(Fragment fragment, ViewGroup viewGroup) {
        if (!this.isInitAd) {
            q.d(TAG, "loadMainBannerAd not init ad");
        } else if (g.getInstance().isHasEnableMainBannerAd()) {
            this.mMainBannerAd.loadBannerAd(fragment, viewGroup);
        }
    }

    public void loadMeBannerAd(Fragment fragment, ViewGroup viewGroup) {
        if (!this.isInitAd) {
            q.d(TAG, "loadBannerAd not init ad");
        } else if (g.getInstance().isHasEnableMeBannerAd()) {
            this.mBannerAd.loadBannerAd(fragment, viewGroup);
        }
    }

    public void loadSplashAd(Activity activity, ViewGroup viewGroup, ISplashHideCallback iSplashHideCallback) {
        if (!this.isInitAd) {
            q.d(TAG, "loadSplashAd not init ad");
        } else if (g.getInstance().isEnableSplashAd()) {
            this.mSplashAd.addSplashAd(activity, viewGroup, iSplashHideCallback);
        }
    }

    public void updateOAIDPem() {
        final int oaidVersion = w.getInstance().getInt("oaid_version_key", 1);
        if (g.getInstance().isUpdateOAIDPem(oaidVersion)) {
            if (g.getInstance().getAppConfigExtVo() != null) {
                oaidVersion = g.getInstance().getAppConfigExtVo().getOaidVersion();
            }
            String oAIDPemUrl = g.getInstance().getOAIDPemUrl();
            if (x.isNotNull(oAIDPemUrl)) {
                c.getInstance().downloadFile(oAIDPemUrl, l.getOAIDFilePath(), new c.e() { // from class: com.chinavisionary.core.app.ad.manager.ADManager.1
                    @Override // c.e.a.a.h.c.e
                    public void onFailed(RequestErrDto requestErrDto) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onFailed errMsg = ");
                        sb.append(requestErrDto != null ? requestErrDto.getErrMsg() : "");
                        q.d(ADManager.TAG, sb.toString());
                    }

                    @Override // c.e.a.a.h.c.e
                    public void onSuccess(String str) {
                        w.getInstance().putInt("oaid_version_key", oaidVersion);
                        q.d(ADManager.TAG, "updateOAIDPem onSuccess = " + str);
                    }
                });
            }
        }
    }
}
