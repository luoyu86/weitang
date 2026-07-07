package cn.admobiletop.adsuyi.ad.inner;

import android.app.Activity;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.a.f.c;
import cn.admobiletop.adsuyi.a.l.h;
import cn.admobiletop.adsuyi.a.l.s;
import cn.admobiletop.adsuyi.a.m.e;
import cn.admobiletop.adsuyi.ad.ADSuyiInnerNoticeAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiInnerNoticeAdInfo;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import cn.admobiletop.adsuyi.ad.error.ADSuyiError;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener;
import cn.admobiletop.adsuyi.config.ADSuyiInitConfig;
import cn.admobiletop.adsuyi.util.ADSuyiAdUtil;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiInnerNoticeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ADSuyiInnerNoticeManager f3534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ADSuyiPosId f3535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ADSuyiPlatformPosId f3536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f3539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ADSuyiInnerNoticeAdInfo f3540g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ADSuyiInnerNoticeAd f3541h;

    public static ADSuyiInnerNoticeManager getInstance() {
        if (f3534a == null) {
            synchronized (ADSuyiInnerNoticeManager.class) {
                if (f3534a == null) {
                    f3534a = new ADSuyiInnerNoticeManager();
                }
            }
        }
        return f3534a;
    }

    public final ADSuyiPlatformPosId b() {
        List<ADSuyiPlatformPosId> platformPosIdList;
        try {
            ADSuyiPosId aDSuyiPosId = this.f3535b;
            if (aDSuyiPosId == null || (platformPosIdList = aDSuyiPosId.getPlatformPosIdList()) == null || platformPosIdList.size() <= 0) {
                return null;
            }
            return platformPosIdList.get(0);
        } catch (Exception unused) {
            return null;
        }
    }

    public final void c(Activity activity, ADSuyiInnerNoticeListener aDSuyiInnerNoticeListener) {
        if (ADSuyiAdUtil.adInfoIsRelease(this.f3540g) || ADSuyiAdUtil.isReleased(this.f3541h) || activity == null || activity.isFinishing()) {
            if (aDSuyiInnerNoticeListener != null) {
                aDSuyiInnerNoticeListener.onAdFailed("InnerNoticeAd 渲染失败");
                return;
            }
            return;
        }
        try {
            ADSuyiAdUtil.showInnerNoticeAdConvenient(activity, this.f3540g, false);
            if (aDSuyiInnerNoticeListener != null) {
                aDSuyiInnerNoticeListener.onAdSuccess();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            if (aDSuyiInnerNoticeListener != null) {
                aDSuyiInnerNoticeListener.onAdFailed("InnerNoticeAd 渲染失败");
            }
        }
    }

    public final long f() {
        long jI = i();
        return jI > 0 ? jI : e.b();
    }

    public final void g(final Activity activity, final ADSuyiInnerNoticeListener aDSuyiInnerNoticeListener) {
        if (this.f3535b != null) {
            if (this.f3541h == null) {
                ADSuyiInnerNoticeAd aDSuyiInnerNoticeAd = new ADSuyiInnerNoticeAd(ADSuyiSdk.getInstance().getContext());
                this.f3541h = aDSuyiInnerNoticeAd;
                aDSuyiInnerNoticeAd.setListener(new ADSuyiInnerNoticeAdListener() { // from class: cn.admobiletop.adsuyi.ad.inner.ADSuyiInnerNoticeManager.3
                    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
                    public void onAdClick(ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo) {
                    }

                    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
                    public void onAdClose(ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo) {
                    }

                    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
                    public void onAdExpose(ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo) {
                    }

                    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener
                    public void onAdFailed(ADSuyiError aDSuyiError) {
                        if (aDSuyiError != null) {
                            aDSuyiInnerNoticeListener.onAdFailed(aDSuyiError.getError());
                        } else {
                            aDSuyiInnerNoticeListener.onAdFailed("InnerNoticeAd 广告请求失败");
                        }
                    }

                    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiInnerNoticeAdListener
                    public void onAdReady(ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo) {
                        ADSuyiInnerNoticeManager.this.n();
                        ADSuyiInnerNoticeManager.this.f3540g = aDSuyiInnerNoticeAdInfo;
                        ADSuyiInnerNoticeManager.this.c(activity, aDSuyiInnerNoticeListener);
                    }

                    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoListener
                    public void onAdReceive(ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo) {
                    }

                    @Override // cn.admobiletop.adsuyi.ad.listener.ADSuyiAdInfoSkipListener
                    public void onAdSkip(ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo) {
                        ADSuyiLogUtil.d("InnerNoticeAd onAdSkip...");
                    }
                });
            }
            ADSuyiLogUtil.d("InnerNoticeAd loading " + this.f3538e);
            this.f3541h.loadAd(this.f3535b.getPosId());
        }
    }

    public final long i() {
        return s.a().b("innerNoticeAd", "InnerNoticeAdPreExposeTime");
    }

    public void init() {
        ADSuyiPlatformPosId aDSuyiPlatformPosId;
        try {
            if (this.f3537d) {
                return;
            }
            ADSuyiLogUtil.d("ADSuyiInnerNoticeManager init...");
            this.f3537d = true;
            ADSuyiPlatformPosId aDSuyiPlatformPosId2 = this.f3536c;
            if (aDSuyiPlatformPosId2 != null) {
                this.f3539f = Math.max(120L, aDSuyiPlatformPosId2.getIntervalShowTime());
            }
            this.f3535b = h.l().k();
            this.f3536c = b();
            ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
            if (config != null && config.isOpenFloatingAd()) {
                ADSuyiLogUtil.d("InnerNoticeAd 已经开启后台定时展示功能，自定义展示功能停止初始化....");
            }
            if (config == null || this.f3535b == null || (aDSuyiPlatformPosId = this.f3536c) == null) {
                release();
                return;
            }
            this.f3539f = Math.max(120L, aDSuyiPlatformPosId.getIntervalShowTime());
            if (c.b().a(this.f3535b)) {
                c.b().a(this.f3535b, new c.a() { // from class: cn.admobiletop.adsuyi.ad.inner.ADSuyiInnerNoticeManager.1
                    @Override // cn.admobiletop.adsuyi.a.f.c.a
                    public void onFinish() {
                    }
                });
            }
        } catch (Exception unused) {
        }
    }

    public final void j(Activity activity, ADSuyiInnerNoticeListener aDSuyiInnerNoticeListener) {
        boolean zL = l();
        if (this.f3538e < 0 || this.f3535b == null || this.f3536c == null || zL) {
            if (this.f3536c != null && zL && aDSuyiInnerNoticeListener != null) {
                aDSuyiInnerNoticeListener.onAdFailed("InnerNoticeAd 已达到展示上限");
            }
            release();
            return;
        }
        long jF = f();
        long jB = e.b();
        if (jF > 0 && jF < jB) {
            int iMax = (int) Math.max(0L, this.f3539f - (jB - jF));
            if (iMax != 0) {
                if (aDSuyiInnerNoticeListener != null) {
                    aDSuyiInnerNoticeListener.onAdDelay(iMax);
                    return;
                }
                return;
            }
        }
        this.f3538e++;
        g(activity, aDSuyiInnerNoticeListener);
    }

    public final boolean k() {
        List<ADSuyiPlatformPosId> platformPosIdList;
        try {
            ADSuyiPosId aDSuyiPosId = this.f3535b;
            if (aDSuyiPosId == null || (platformPosIdList = aDSuyiPosId.getPlatformPosIdList()) == null) {
                return true;
            }
            c.b().a(this.f3535b.getPosId(), platformPosIdList);
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

    public final boolean l() {
        if (this.f3536c == null) {
            return true;
        }
        if (this.f3535b.isLoopFrequencyType()) {
            return false;
        }
        return k();
    }

    public void loadInnerNoticeAd(final Activity activity, final ADSuyiInnerNoticeListener aDSuyiInnerNoticeListener) {
        try {
            if (!this.f3537d) {
                if (aDSuyiInnerNoticeListener != null) {
                    aDSuyiInnerNoticeListener.onAdFailed("InnerNoticeAd init is not complete");
                    return;
                }
                return;
            }
            if (activity == null) {
                if (aDSuyiInnerNoticeListener != null) {
                    aDSuyiInnerNoticeListener.onAdFailed("activity not allowed to be null");
                    return;
                }
                return;
            }
            ADSuyiInitConfig config = ADSuyiSdk.getInstance().getConfig();
            if (config == null) {
                if (aDSuyiInnerNoticeListener != null) {
                    aDSuyiInnerNoticeListener.onAdFailed("SuyiSDK 获取初始化配置失败，请检查ADSuyiSdk初始化回调是否正常");
                }
            } else if (config.isOpenFloatingAd()) {
                if (aDSuyiInnerNoticeListener != null) {
                    aDSuyiInnerNoticeListener.onAdFailed("InnerNoticeAd 已配置后台自动展示，无法自定义调用");
                }
            } else if (c.b().a(this.f3535b)) {
                c.b().a(this.f3535b, new c.a() { // from class: cn.admobiletop.adsuyi.ad.inner.ADSuyiInnerNoticeManager.2
                    @Override // cn.admobiletop.adsuyi.a.f.c.a
                    public void onFinish() {
                        ADSuyiInnerNoticeManager.this.j(activity, aDSuyiInnerNoticeListener);
                    }
                });
            } else {
                j(activity, aDSuyiInnerNoticeListener);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (aDSuyiInnerNoticeListener != null) {
                aDSuyiInnerNoticeListener.onAdFailed("InnerNoticeAd 加载广告时发生未知异常");
            }
        }
    }

    public final void m() {
        ADSuyiInnerNoticeAd aDSuyiInnerNoticeAd = this.f3541h;
        if (aDSuyiInnerNoticeAd != null) {
            aDSuyiInnerNoticeAd.release();
            this.f3541h = null;
        }
    }

    public final void n() {
        ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo = this.f3540g;
        if (aDSuyiInnerNoticeAdInfo != null) {
            aDSuyiInnerNoticeAdInfo.release();
            this.f3540g = null;
        }
    }

    public void release() {
        m();
        n();
    }
}
