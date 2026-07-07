package cn.admobiletop.adsuyi.a.l;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.a.c.a;
import cn.admobiletop.adsuyi.ad.ADSuyiInnerNoticeAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiInnerNoticeAdInfo;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class o implements a.InterfaceC0050a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f3414a = {"com.qq.e.ads.PortraitADActivity", "com.qq.e.ads.LandscapeADActivity", "com.qq.e.ads.RewardvideoPortraitADActivity", "com.qq.e.ads.RewardvideoLandscapeADActivity", "com.bytedance.sdk.openadsdk.activity.TTRewardExpressVideoActivity", "com.bytedance.sdk.openadsdk.activity.TTFullScreenExpressVideoActivity", PluginConstants.STUB_STANDARD_PORTRAIT_ACTIVITY_T, PluginConstants.STUB_STANDARD_LANDSCAPE_ACTIVITY, "com.baidu.mobads.production.rewardvideo.MobRewardVideoActivity", "com.baidu.mobads.sdk.api.MobRewardVideoActivity", "com.mintegral.msdk.reward.player.MTGRewardVideoActivity", "com.mbridge.msdk.reward.player.MBRewardVideoActivity", "com.inmobi.rendering.InMobiAdActivity", "com.kwad.sdk.fullscreen.KsFullScreenVideoActivity", "com.kwad.sdk.reward.KSRewardVideoActivity", "com.kwad.sdk.api.proxy.app.KsRewardVideoActivity", "cn.admobiletop.adsuyi.adapter.ksad.activity.ADSuyiSubAdSimpleActivity", "mobi.oneway.export.AdShowActivity", "com.ap.x.t.activity.FSVAct", "com.ap.x.t.activity.RVAct", "cn.admobiletop.adsuyi.adapter.ifly.activity.VideoAdActivity", "cn.admobiletop.adsuyi.adapter.ifly.activity.LandscapeVideoAdActivity", "com.miui.zeus.mimo.sdk.ad.reward.RewardVideoAdActivity", "admsdk.library.activity.AdmobileDownloadApkConfirmDialogActivity", "com.tianmu.ad.activity.FullScreenVodActivity", "com.tianmu.ad.activity.AdDetailActivity", "com.tianmu.ad.activity.AppPermissionsActivity", "com.tianmu.ad.activity.LandscapeFullScreenVodActivity", "com.tianmu.ad.activity.LoadingPageActivity", "com.tianmu.ad.activity.RewardVodActivity", "com.tianmu.ad.activity.WebViewActivity", "com.tianmu.ad.activity.DownloadListActivity", "com.tianmu.ad.activity.InterstitialActivity", "com.tianmu.ad.activity.LandscapeAdDetailActivity", "com.tianmu.ad.activity.LandscapeInterstitialActivity"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static o f3415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiInnerNoticeAdInfo f3416c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ADSuyiInnerNoticeAd f3417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Handler f3418e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ADSuyiPosId f3419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ADSuyiPlatformPosId f3420g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Activity f3421h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3422i;
    public boolean j;
    public int k;
    public long l;
    public long m;
    public List<String> n;
    public boolean o;
    public boolean p;

    public static o b() {
        if (f3415b == null) {
            synchronized (o.class) {
                if (f3415b == null) {
                    f3415b = new o();
                }
            }
        }
        return f3415b;
    }

    public void c() {
        if (this.f3422i) {
            return;
        }
        ADSuyiLogUtil.d("InnerNoticeAd init...");
        this.f3422i = true;
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (config != null) {
            this.n = config.getFloatingAdBlockList();
        }
        cn.admobiletop.adsuyi.a.c.a aVarD = h.l().d();
        if (aVarD != null) {
            aVarD.a(this);
        }
    }

    public final boolean c(int i2) {
        return -10012 == i2 || -20002 == i2 || -20103 == i2 || -20104 == i2 || -20105 == i2;
    }

    public void e() {
        if (this.o) {
            this.o = false;
            if (this.j) {
                n();
            }
        }
    }

    public final void l() {
        y();
        boolean zT = t();
        int i2 = this.k;
        if (i2 < 0 || this.f3419f == null || this.f3420g == null || zT) {
            if (this.f3420g != null && zT) {
                ADSuyiLogUtil.d("InnerNoticeAd 已达到展示上限");
            }
            v();
            return;
        }
        if (this.f3418e != null) {
            long jMax = this.m;
            if (i2 == 0) {
                jMax = this.l;
                long jQ = q();
                long jB = cn.admobiletop.adsuyi.a.m.e.b();
                if (jQ > 0 && jQ < jB) {
                    jMax += (long) ((int) Math.max(0L, this.m - (jB - jQ)));
                }
            }
            ADSuyiLogUtil.d("InnerNoticeAd delayTime : " + jMax);
            this.f3418e.removeCallbacksAndMessages(null);
            this.f3418e.postDelayed(new m(this), jMax * 1000);
            this.k = this.k + 1;
        }
    }

    public final void n() {
        Activity activity;
        if (this.o || ADSuyiAdUtil.adInfoIsRelease(this.f3416c) || ADSuyiAdUtil.isReleased(this.f3417d) || (activity = this.f3421h) == null || activity.isFinishing()) {
            return;
        }
        try {
            String name = this.f3421h.getClass().getName();
            if (e(name)) {
                StringBuilder sb = new StringBuilder();
                sb.append("InnerNoticeAd ");
                sb.append(name);
                sb.append(" need block!");
                ADSuyiLogUtil.d(sb.toString());
            } else {
                ADSuyiAdUtil.showInnerNoticeAdConvenient(this.f3421h, this.f3416c, false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final ADSuyiPlatformPosId o() {
        List<ADSuyiPlatformPosId> platformPosIdList;
        try {
            ADSuyiPosId aDSuyiPosId = this.f3419f;
            if (aDSuyiPosId == null || (platformPosIdList = aDSuyiPosId.getPlatformPosIdList()) == null || platformPosIdList.size() <= 0) {
                return null;
            }
            return platformPosIdList.get(0);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // cn.admobiletop.adsuyi.a.c.a.InterfaceC0050a
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // cn.admobiletop.adsuyi.a.c.a.InterfaceC0050a
    public void onActivityPaused(Activity activity) {
        this.f3421h = null;
        ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo = this.f3416c;
        if (aDSuyiInnerNoticeAdInfo == null || !aDSuyiInnerNoticeAdInfo.hasShown()) {
            return;
        }
        l();
    }

    @Override // cn.admobiletop.adsuyi.a.c.a.InterfaceC0050a
    public void onActivityResumed(Activity activity) {
        this.f3421h = activity;
        n();
    }

    public final long q() {
        long jR = r();
        return jR > 0 ? jR : cn.admobiletop.adsuyi.a.m.e.b();
    }

    public final long r() {
        return s.a().b("innerNoticeAd", "InnerNoticeAdPreExposeTime");
    }

    public final boolean s() {
        List<ADSuyiPlatformPosId> platformPosIdList;
        try {
            ADSuyiPosId aDSuyiPosId = this.f3419f;
            if (aDSuyiPosId == null || (platformPosIdList = aDSuyiPosId.getPlatformPosIdList()) == null) {
                return true;
            }
            cn.admobiletop.adsuyi.a.f.c.b().a(this.f3419f.getPosId(), platformPosIdList);
            Iterator<ADSuyiPlatformPosId> it = platformPosIdList.iterator();
            while (it.hasNext()) {
                if (!it.next().isFrequencyFinished()) {
                    return false;
                }
            }
            return true;
        } catch (Exception unused) {
            return true;
        }
    }

    public final boolean t() {
        if (this.f3420g == null) {
            return true;
        }
        if (this.f3419f.isLoopFrequencyType()) {
            return false;
        }
        return s();
    }

    public final void u() {
        if (this.f3419f != null) {
            if (this.f3417d == null) {
                ADSuyiInnerNoticeAd aDSuyiInnerNoticeAd = new ADSuyiInnerNoticeAd(ADSuyiSdk.getInstance().getContext());
                this.f3417d = aDSuyiInnerNoticeAd;
                aDSuyiInnerNoticeAd.setListener(new n(this));
            }
            ADSuyiLogUtil.d("InnerNoticeAd loadInnerNoticeAd " + this.k);
            this.f3417d.loadAd(this.f3419f.getPosId());
        }
    }

    public final void v() {
        ADSuyiLogUtil.d("InnerNoticeAd release, innerNoticeAd : " + this.f3417d);
        this.f3421h = null;
        w();
        x();
        y();
        z();
    }

    public final void w() {
        Handler handler = this.f3418e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f3418e = null;
        }
    }

    public final void x() {
        ADSuyiInnerNoticeAd aDSuyiInnerNoticeAd = this.f3417d;
        if (aDSuyiInnerNoticeAd != null) {
            aDSuyiInnerNoticeAd.release();
            this.f3417d = null;
        }
    }

    public final void y() {
        ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo = this.f3416c;
        if (aDSuyiInnerNoticeAdInfo != null) {
            aDSuyiInnerNoticeAdInfo.release();
            this.f3416c = null;
        }
    }

    public final void z() {
        cn.admobiletop.adsuyi.a.c.a aVarD = h.l().d();
        if (aVarD != null) {
            aVarD.b(this);
        }
    }

    public List<String> a() {
        try {
            return Arrays.asList(f3414a);
        } catch (Exception e2) {
            e2.printStackTrace();
            return new ArrayList();
        }
    }

    public void d() {
        ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo;
        if (this.o) {
            return;
        }
        this.o = true;
        if (this.j && (aDSuyiInnerNoticeAdInfo = this.f3416c) != null && aDSuyiInnerNoticeAdInfo.hasShown()) {
            l();
        }
    }

    public void f() {
        if (this.p) {
            ADSuyiPlatformPosId aDSuyiPlatformPosId = this.f3420g;
            if (aDSuyiPlatformPosId != null) {
                this.m = Math.max(120L, aDSuyiPlatformPosId.getIntervalShowTime());
                return;
            }
            return;
        }
        this.p = true;
        this.f3419f = h.l().k();
        this.f3420g = o();
        ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
        if (this.f3419f == null || this.f3420g == null || !this.f3422i || config == null || !config.isOpenFloatingAd()) {
            v();
            return;
        }
        this.j = true;
        this.l = Math.max(10L, this.f3420g.getFirstShowTime());
        this.m = Math.max(120L, this.f3420g.getIntervalShowTime());
        if (cn.admobiletop.adsuyi.a.f.c.b().a(this.f3419f)) {
            cn.admobiletop.adsuyi.a.f.c.b().a(this.f3419f, new l(this));
            return;
        }
        ADSuyiLogUtil.d("InnerNoticeAd start, [" + this.l + ", " + this.m + "]");
        l();
    }

    public void a(long j) {
        s.a().a("innerNoticeAd", "InnerNoticeAdPreExposeTime", j);
    }

    public final boolean e(String str) {
        List<String> list = this.n;
        return (list == null || str == null || !list.contains(str)) ? false : true;
    }
}
