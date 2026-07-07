package cn.admobiletop.adsuyi;

import android.content.Context;
import android.location.Location;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import cn.admobiletop.adsuyi.a.l.h;
import cn.admobiletop.adsuyi.a.l.k;
import cn.admobiletop.adsuyi.a.l.o;
import cn.admobiletop.adsuyi.a.l.s;
import cn.admobiletop.adsuyi.config.ADSuyiImageLoader;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import cn.admobiletop.adsuyi.listener.ADSuyiInitListener;
import cn.admobiletop.adsuyi.util.ADSuyiPackageUtil;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiSdk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ADSuyiSdk f3157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Context f3158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiInitConfig f3159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ADSuyiInitListener f3163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f3164h;

    public static ADSuyiSdk getInstance() {
        if (f3157a == null) {
            synchronized (ADSuyiSdk.class) {
                if (f3157a == null) {
                    f3157a = new ADSuyiSdk();
                }
            }
        }
        return f3157a;
    }

    public static void setPersonalizedAdEnabled(boolean z) {
        try {
            s.a().b(h.f3386e, h.f3387f, z);
            h.l().a(z);
        } catch (Exception unused) {
        }
    }

    public String getAAID() {
        return k.d().a();
    }

    public String getAndroidId(Context context) {
        return k.d().b();
    }

    public String getAppId() {
        ADSuyiInitConfig aDSuyiInitConfig = this.f3159c;
        if (aDSuyiInitConfig == null) {
            return null;
        }
        return aDSuyiInitConfig.getAppId();
    }

    public ADSuyiInitConfig getConfig() {
        return this.f3159c;
    }

    public Context getContext() {
        return this.f3158b;
    }

    public int getDownloadTip() {
        return h.l().g();
    }

    public ADSuyiImageLoader getImageLoader() {
        ADSuyiInitConfig aDSuyiInitConfig = this.f3159c;
        if (aDSuyiInitConfig == null) {
            return null;
        }
        return aDSuyiInitConfig.getSuyiImageLoader();
    }

    public String getImei(Context context) {
        return k.d().c();
    }

    public float getInitiallyDensity() {
        return this.f3160d;
    }

    public int getInitiallyDensityDpi() {
        return this.f3161e;
    }

    public String getLat(Context context) {
        return k.d().f(context);
    }

    public String getLng(Context context) {
        return k.d().g(context);
    }

    public Location getLocation(Context context) {
        return k.d().e();
    }

    public String getMac(Context context) {
        return k.d().f();
    }

    public String getMacAddress(Context context) {
        return getMac(context);
    }

    @Nullable
    @Deprecated
    public Fragment getNovelFragment() {
        return null;
    }

    public String getOAID() {
        return k.d().h();
    }

    public boolean getPersonalizedAdEnabled() {
        return s.a().a(h.f3386e, h.f3387f, true);
    }

    public String getSdkVersion() {
        return "3.9.0.01171";
    }

    public String getVAID() {
        return k.d().j();
    }

    public void init(@NonNull Context context, @NonNull ADSuyiInitConfig aDSuyiInitConfig) {
        if (this.f3159c != null) {
            if (this.f3164h) {
                setInitListenerFailed("init already");
                return;
            } else {
                setInitListenerFailed("init config is not null");
                return;
            }
        }
        aDSuyiInitConfig.check();
        this.f3158b = context.getApplicationContext();
        this.f3159c = aDSuyiInitConfig;
        this.f3160d = context.getResources().getDisplayMetrics().density;
        this.f3161e = context.getResources().getDisplayMetrics().densityDpi;
        if (aDSuyiInitConfig.isMultiprocess()) {
            h.l().n();
        } else if (ADSuyiPackageUtil.isMainProcess(context)) {
            h.l().n();
        } else {
            setInitListenerFailed("init need to in main process");
        }
    }

    public boolean isDarkMode() {
        return this.f3162f;
    }

    public boolean isDebug() {
        ADSuyiInitConfig aDSuyiInitConfig = this.f3159c;
        return aDSuyiInitConfig != null && aDSuyiInitConfig.isDebug();
    }

    public boolean isHttp() {
        return s.a().a(h.f3384c, h.f3385d);
    }

    public boolean isInit() {
        return this.f3164h;
    }

    public boolean isShowAdLogo() {
        ADSuyiInitConfig aDSuyiInitConfig = this.f3159c;
        return aDSuyiInitConfig != null && aDSuyiInitConfig.isShowAdLogo();
    }

    @Deprecated
    public boolean openNovelActivity() {
        return false;
    }

    public void pauseFloatingAd() {
        ADSuyiInitConfig aDSuyiInitConfig = this.f3159c;
        if (aDSuyiInitConfig == null || !aDSuyiInitConfig.isOpenFloatingAd()) {
            return;
        }
        o.b().d();
    }

    public void restartFloatingAd() {
        ADSuyiInitConfig aDSuyiInitConfig = this.f3159c;
        if (aDSuyiInitConfig == null || !aDSuyiInitConfig.isOpenFloatingAd()) {
            return;
        }
        o.b().e();
    }

    public void setDarkMode(boolean z) {
        this.f3162f = z;
    }

    public void setInitListenerFailed(String str) {
        ADSuyiInitListener aDSuyiInitListener = this.f3163g;
        if (aDSuyiInitListener != null) {
            aDSuyiInitListener.onFailed(str);
        }
    }

    public void setInitListenerSuccess() {
        ADSuyiInitListener aDSuyiInitListener = this.f3163g;
        if (aDSuyiInitListener == null || this.f3164h) {
            return;
        }
        this.f3164h = true;
        aDSuyiInitListener.onSuccess();
        try {
            setPersonalizedAdEnabled(s.a().a(h.f3386e, h.f3387f, true));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void init(@NonNull Context context, @NonNull ADSuyiInitConfig aDSuyiInitConfig, @NonNull ADSuyiInitListener aDSuyiInitListener) {
        this.f3163g = aDSuyiInitListener;
        init(context, aDSuyiInitConfig);
    }
}
