package com.tianmu;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tianmu.ad.activity.AdDetailActivity;
import com.tianmu.ad.activity.AdDownloadDetailActivity;
import com.tianmu.ad.activity.AppPermissionsActivity;
import com.tianmu.ad.activity.DownloadListActivity;
import com.tianmu.ad.activity.FullScreenVodActivity;
import com.tianmu.ad.activity.InterstitialActivity;
import com.tianmu.ad.activity.LandscapeAdDetailActivity;
import com.tianmu.ad.activity.LandscapeAdDownloadDetailActivity;
import com.tianmu.ad.activity.LandscapeFullScreenVodActivity;
import com.tianmu.ad.activity.LandscapeInterstitialActivity;
import com.tianmu.ad.activity.RewardVodActivity;
import com.tianmu.ad.activity.WebViewActivity;
import com.tianmu.ad.error.TianmuError;
import com.tianmu.biz.utils.i0;
import com.tianmu.biz.widget.l.a;
import com.tianmu.c.n.g;
import com.tianmu.c.n.i;
import com.tianmu.c.n.n;
import com.tianmu.config.TianmuErrorConfig;
import com.tianmu.config.TianmuImageLoader;
import com.tianmu.config.TianmuInitConfig;
import com.tianmu.listener.TianmuInitListener;
import com.tianmu.utils.TianmuLogUtil;
import com.tianmu.utils.TianmuPackageUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class TianmuSDK {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile TianmuSDK f10534i = null;
    public static boolean isCanUseLocation = true;
    public static boolean isCanUsePhoneState = true;
    public static boolean isCanUseWifiState = true;
    private static boolean j = true;
    public static final long serialVersionUID = 534161597067125251L;
    public static boolean setCanUseLocation = false;
    public static boolean setCanUsePhoneState = false;
    public static boolean setCanUseWifiState = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f10536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f10537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TianmuInitConfig f10538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private TianmuInitListener f10539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f10540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f10541g = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<String> f10542h;

    public static TianmuSDK getInstance() {
        if (f10534i == null) {
            synchronized (TianmuSDK.class) {
                if (f10534i == null) {
                    f10534i = new TianmuSDK();
                }
            }
        }
        return f10534i;
    }

    public static boolean isPersonalizedAds() {
        return j;
    }

    public static void setCanUseLocation(boolean z) {
        setCanUseLocation = true;
        isCanUseLocation = z;
    }

    public static void setCanUsePhoneState(boolean z) {
        setCanUsePhoneState = true;
        if (z) {
            g.I().v();
            g.I().w();
            g.I().x();
        }
        isCanUsePhoneState = z;
    }

    public static void setCanUseWifiState(boolean z) {
        setCanUseWifiState = true;
        if (z) {
            g.I().A();
            g.I().y();
        }
        isCanUseWifiState = z;
    }

    public static void setPersonalizedAds(boolean z) {
        j = z;
    }

    public String getAppId() {
        TianmuInitConfig tianmuInitConfig = this.f10538d;
        if (tianmuInitConfig == null) {
            return null;
        }
        return tianmuInitConfig.getAppId();
    }

    public TianmuInitConfig getConfig() {
        return this.f10538d;
    }

    public Context getContext() {
        return this.f10535a;
    }

    public TianmuImageLoader getImageLoader() {
        TianmuInitConfig tianmuInitConfig = this.f10538d;
        if (tianmuInitConfig == null) {
            return null;
        }
        return tianmuInitConfig.getTianmuImageLoader();
    }

    public float getInitiallyDensity() {
        return this.f10536b;
    }

    public int getInitiallyDensityDpi() {
        return this.f10537c;
    }

    public List<String> getNoticeBlockList() {
        if (this.f10542h == null) {
            this.f10542h = new ArrayList();
        }
        this.f10542h.add(AdDetailActivity.class.getName());
        this.f10542h.add(AdDownloadDetailActivity.class.getName());
        this.f10542h.add(AppPermissionsActivity.class.getName());
        this.f10542h.add(DownloadListActivity.class.getName());
        this.f10542h.add(FullScreenVodActivity.class.getName());
        this.f10542h.add(InterstitialActivity.class.getName());
        this.f10542h.add(LandscapeAdDetailActivity.class.getName());
        this.f10542h.add(LandscapeAdDownloadDetailActivity.class.getName());
        this.f10542h.add(LandscapeFullScreenVodActivity.class.getName());
        this.f10542h.add(LandscapeInterstitialActivity.class.getName());
        this.f10542h.add(RewardVodActivity.class.getName());
        this.f10542h.add(WebViewActivity.class.getName());
        return this.f10542h;
    }

    public String getSdkVersion() {
        return "2.2.0.1";
    }

    public TianmuInitListener getTianmuInitListener() {
        return this.f10539e;
    }

    public void init(@NonNull Context context, @NonNull TianmuInitConfig tianmuInitConfig, @NonNull TianmuInitListener tianmuInitListener) {
        this.f10539e = tianmuInitListener;
        init(context, tianmuInitConfig);
    }

    public boolean isCheckCacheApk() {
        if (i0.a().a(a.f11065g)) {
            return false;
        }
        return this.f10541g;
    }

    public boolean isDebug() {
        TianmuInitConfig tianmuInitConfig = this.f10538d;
        return tianmuInitConfig != null && tianmuInitConfig.isDebug();
    }

    public boolean isFlutter() {
        return this.f10540f;
    }

    public boolean isGoogle() {
        TianmuInitConfig tianmuInitConfig = this.f10538d;
        if (tianmuInitConfig != null) {
            return tianmuInitConfig.isGoogle();
        }
        return false;
    }

    public void setCheckCacheApk(boolean z) {
        this.f10541g = z;
    }

    @Deprecated
    public void setFlutter() {
        TianmuLogUtil.d("is flutter project");
        this.f10540f = true;
    }

    public void setNoticeBlockList(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.f10542h = arrayList;
        arrayList.addAll(Arrays.asList(strArr));
    }

    public void init(@NonNull Context context, @NonNull TianmuInitConfig tianmuInitConfig) {
        if (this.f10538d == null) {
            tianmuInitConfig.check();
            this.f10535a = context.getApplicationContext();
            this.f10538d = tianmuInitConfig;
            this.f10536b = context.getResources().getDisplayMetrics().density;
            this.f10537c = context.getResources().getDisplayMetrics().densityDpi;
            i.b().a();
            if (!tianmuInitConfig.isMultiprocess()) {
                if (TianmuPackageUtil.isMainProcess(context)) {
                    n.D().l();
                    return;
                } else {
                    n.D().a(new TianmuError(TianmuErrorConfig.INIT_NOT_IN_MAIN_PROCESS, TianmuErrorConfig.MSG_INIT_NOT_IN_MAIN_PROCESS));
                    return;
                }
            }
            n.D().l();
        }
    }
}
