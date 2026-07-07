package cn.admobiletop.adsuyi.config;

import android.text.TextUtils;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.a.a;
import cn.admobiletop.adsuyi.a.l.h;
import cn.admobiletop.adsuyi.a.l.o;
import cn.admobiletop.adsuyi.a.l.s;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.exception.ADSuyiInitException;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import cn.admobiletop.adsuyi.util.ADSuyiPackageUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiInitConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4292c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4293d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f4294e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f4295f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4296g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4297h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f4298i;
    public final ADSuyiImageLoader j;
    public boolean k;
    public boolean l;
    public List<String> m;
    public int n;
    public boolean o;
    public String p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f4299q;
    public boolean r;
    public CustomDeviceInfoController s;
    public boolean t;
    public boolean u;
    public boolean v;

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ADSuyiInitConfig f4300a = new ADSuyiInitConfig();

        public Builder agreePrivacyStrategy(boolean z) {
            this.f4300a.l = z;
            return this;
        }

        public Builder appId(String str) {
            this.f4300a.f4290a = str;
            return this;
        }

        public ADSuyiInitConfig build() {
            return this.f4300a;
        }

        public Builder debug(boolean z) {
            this.f4300a.f4291b = z;
            return this;
        }

        public Builder deviceType(int i2) {
            this.f4300a.n = i2;
            return this;
        }

        public Builder filterThirdQuestion(boolean z) {
            this.f4300a.f4292c = z;
            return this;
        }

        public Builder floatingAdBlockList(boolean z, String... strArr) {
            this.f4300a.m = new ArrayList();
            if (z) {
                this.f4300a.m.addAll(o.b().a());
            }
            if (strArr != null && strArr.length > 0) {
                this.f4300a.m.addAll(Arrays.asList(strArr));
            }
            return this;
        }

        public Builder isCanAutoReleaseAd(boolean z) {
            if (!z) {
                ADSuyiLogUtil.d("注意，当前已关闭SDK内部跟随Activity生命周期进行的自动释放SuyiAd对象功能，需要您和适当的时候，对SuyiAd对象进行手动释放，防止内存泄露的风险！！！");
            }
            this.f4300a.t = z;
            return this;
        }

        public Builder isCanReadInstallList(boolean z) {
            this.f4300a.f4297h = z;
            return this;
        }

        public Builder isCanUseLocation(boolean z) {
            this.f4300a.f4293d = z;
            return this;
        }

        public Builder isCanUseOaid(boolean z) {
            this.f4300a.f4296g = z;
            return this;
        }

        public Builder isCanUsePhoneState(boolean z) {
            this.f4300a.f4294e = z;
            return this;
        }

        public Builder isCanUseReadWriteExternal(boolean z) {
            this.f4300a.f4298i = z;
            return this;
        }

        public Builder isCanUseWifiState(boolean z) {
            this.f4300a.f4295f = z;
            return this;
        }

        @Deprecated
        public Builder isSandbox(boolean z) {
            this.f4300a.o = z;
            return this;
        }

        public Builder openFloatingAd(boolean z) {
            this.f4300a.k = z;
            return this;
        }

        public Builder setCustomDeviceInfoController(CustomDeviceInfoController customDeviceInfoController) {
            this.f4300a.s = customDeviceInfoController;
            return this;
        }

        public Builder setMultiprocess(boolean z) {
            this.f4300a.r = z;
            return this;
        }

        @Deprecated
        public Builder setOaidCertPath(String str) {
            this.f4300a.p = str;
            return this;
        }

        public Builder setShowAdLogo(boolean z) {
            this.f4300a.v = true;
            this.f4300a.u = z;
            return this;
        }

        public Builder setTtUseTextureView(boolean z) {
            this.f4300a.f4299q = z;
            return this;
        }
    }

    public void check() {
        if (!isAgreePrivacyStrategy()) {
            this.f4295f = false;
            this.f4293d = false;
            this.f4294e = false;
            this.f4297h = false;
            this.f4298i = false;
        }
        if (TextUtils.isEmpty(this.f4290a)) {
            throw new ADSuyiInitException(new ADSuyiError(ADSuyiErrorConfig.APPID_EMPTY, "AppId不能为空"));
        }
        if (!ADSuyiPackageUtil.isMainThread()) {
            throw new ADSuyiInitException(new ADSuyiError(ADSuyiErrorConfig.INIT_NOT_IN_MAIN_THREAD, "SDK初始化必须在主线程"));
        }
    }

    public String getAppId() {
        return this.f4290a;
    }

    public CustomDeviceInfoController getCustomController() {
        return this.s;
    }

    public int getDeviceType() {
        return this.n;
    }

    public List<String> getFloatingAdBlockList() {
        return this.m;
    }

    public String getOaidCertPath() {
        return this.p;
    }

    public ADSuyiImageLoader getSuyiImageLoader() {
        return this.j;
    }

    public boolean isAgreePrivacyStrategy() {
        if (h.l().p()) {
            return false;
        }
        return this.l;
    }

    public boolean isCanAutoReleaseAd() {
        return this.t;
    }

    public boolean isCanReadInstallList() {
        if (h.l().p()) {
            return false;
        }
        return this.f4297h;
    }

    public boolean isCanUseLocation() {
        if (h.l().p()) {
            return false;
        }
        return this.f4293d;
    }

    public boolean isCanUseOaid() {
        if (h.l().p()) {
            return false;
        }
        return this.f4296g;
    }

    public boolean isCanUsePhoneState() {
        if (h.l().p()) {
            return false;
        }
        return this.f4294e;
    }

    public boolean isCanUseReadWriteExternal() {
        if (h.l().p()) {
            return false;
        }
        return this.f4298i;
    }

    public boolean isCanUseWifiState() {
        if (h.l().p()) {
            return false;
        }
        return this.f4295f;
    }

    public boolean isDebug() {
        if (s.a().a(h.f3384c, h.f3385d)) {
            return true;
        }
        return this.f4291b;
    }

    public boolean isFilterThirdQuestion() {
        return this.f4292c;
    }

    public boolean isMultiprocess() {
        return this.r;
    }

    public boolean isOpenFloatingAd() {
        return this.k;
    }

    public boolean isSandbox() {
        return this.o;
    }

    public boolean isShowAdLogo() {
        return this.v ? this.u : ADSuyiSdk.getInstance().isDebug();
    }

    public boolean isTtUseTextureView() {
        return this.f4299q;
    }

    public ADSuyiInitConfig() {
        this.f4291b = true;
        this.f4293d = true;
        this.f4294e = true;
        this.f4295f = true;
        this.f4296g = true;
        this.f4297h = true;
        this.f4298i = true;
        this.k = true;
        this.l = true;
        this.n = 4;
        this.o = false;
        this.t = true;
        this.u = false;
        this.v = false;
        this.j = new a();
    }
}
