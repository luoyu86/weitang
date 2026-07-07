package com.qq.e.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.qq.e.ads.LiteAbstractAD;
import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.pi.NSPVI;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class SplashAD extends LiteAbstractAD<NSPVI> implements IReward {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile ViewGroup f9632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile SplashADListener f9633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile ADRewardListener f9634i;
    public volatile LoadAdParams j;
    public volatile boolean k;
    public volatile boolean l;
    public volatile boolean m;
    public volatile int n;
    public volatile byte[] o;
    public volatile ServerSideVerificationOptions p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f9635q;

    public class ADListenerAdapter implements ADListener {
        public ADListenerAdapter() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            String str;
            if (SplashAD.this.f9633h == null) {
                GDTLogger.d("SplashADListener == null");
                return;
            }
            int type = aDEvent.getType();
            if (type == 112) {
                Long l = (Long) aDEvent.getParam(Long.class);
                if (l != null) {
                    SplashAD.this.f9633h.onADTick(l.longValue());
                }
                return;
            }
            switch (type) {
                case 100:
                    Long l2 = (Long) aDEvent.getParam(Long.class);
                    if (l2 != null) {
                        SplashAD.this.f9633h.onADLoaded(l2.longValue());
                    }
                    break;
                case 101:
                    Integer num = (Integer) aDEvent.getParam(Integer.class);
                    if (num != null) {
                        SplashAD.this.f9633h.onNoAD(AdErrorConvertor.formatErrorCode(num.intValue()));
                    }
                    break;
                case 102:
                    SplashAD.this.f9633h.onADPresent();
                    break;
                case 103:
                    SplashAD.this.f9633h.onADExposure();
                    break;
                case 104:
                    if (SplashAD.this.f9634i != null && (str = (String) aDEvent.getParam(String.class)) != null) {
                        HashMap map = new HashMap();
                        map.put("transId", str);
                        SplashAD.this.f9634i.onReward(map);
                        break;
                    }
                    break;
                case 105:
                    SplashAD.this.f9633h.onADClicked();
                    break;
                case 106:
                    SplashAD.this.f9633h.onADDismissed();
                    break;
            }
        }
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener) {
        this(context, str, splashADListener, 0);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2) {
        this.k = false;
        this.f9633h = splashADListener;
        this.f9635q = i2;
        a(context, str);
    }

    public SplashAD(Context context, String str, SplashADListener splashADListener, int i2, String str2) {
        this.k = false;
        this.f9633h = splashADListener;
        this.f9635q = i2;
        a(context, str, str2);
    }

    @Override // com.qq.e.ads.AbstractAD
    public Object a(Context context, POFactory pOFactory, String str, String str2, String str3) {
        return pOFactory.getNativeSplashAdView(context, str, str2, str3);
    }

    @Override // com.qq.e.ads.AbstractAD
    public void b(int i2) {
        if (this.f9633h != null) {
            this.f9633h.onNoAD(AdErrorConvertor.formatErrorCode(i2));
        }
    }

    public final void e(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数有误：传入container参数为空");
            a(4001);
            return;
        }
        T t = this.f9515a;
        if (t == 0) {
            this.m = z;
            this.f9632g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.fetchFullScreenAndShowIn(viewGroup);
        } else {
            nspvi.fetchAndShowIn(viewGroup);
        }
    }

    public final void f(boolean z) {
        if (a()) {
            if (!b()) {
                this.m = z;
                this.l = true;
                return;
            }
            T t = this.f9515a;
            if (t == 0) {
                a("fetchAdInner");
                return;
            }
            NSPVI nspvi = (NSPVI) t;
            if (z) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
        }
    }

    public void fetchAdOnly() {
        f(false);
    }

    public void fetchAndShowIn(ViewGroup viewGroup) {
        e(viewGroup, false);
    }

    public void fetchFullScreenAdOnly() {
        f(true);
    }

    public void fetchFullScreenAndShowIn(ViewGroup viewGroup) {
        e(viewGroup, true);
    }

    public String getAdNetWorkName() {
        T t = this.f9515a;
        if (t != 0) {
            return ((NSPVI) t).getAdNetWorkName();
        }
        a("getAdNetWorkName");
        return null;
    }

    @Deprecated
    public Bitmap getZoomOutBitmap() {
        GDTLogger.e("注意！开屏V+功能已废弃，调用不生效");
        return null;
    }

    public final void h(ViewGroup viewGroup, boolean z) {
        if (viewGroup == null) {
            GDTLogger.e("传入参数错误，container参数为空");
            a(4001);
            return;
        }
        T t = this.f9515a;
        if (t == 0) {
            this.f9632g = viewGroup;
            return;
        }
        NSPVI nspvi = (NSPVI) t;
        if (z) {
            nspvi.showFullScreenAd(viewGroup);
        } else {
            nspvi.showAd(viewGroup);
        }
    }

    public void preLoad() {
        if (a()) {
            if (!b()) {
                this.k = true;
                return;
            }
            T t = this.f9515a;
            if (t != 0) {
                ((NSPVI) t).preload();
            } else {
                a("preLoad");
            }
        }
    }

    @Deprecated
    public void setAdLogoMargin(int i2, int i3) {
    }

    public void setDeveloperLogo(int i2) {
        T t = this.f9515a;
        if (t == 0) {
            this.n = i2;
        } else {
            ((NSPVI) t).setDeveloperLogo(i2);
        }
    }

    public void setDeveloperLogo(byte[] bArr) {
        T t = this.f9515a;
        if (t == 0) {
            this.o = bArr;
        } else {
            ((NSPVI) t).setDeveloperLogo(bArr);
        }
    }

    public void setLoadAdParams(LoadAdParams loadAdParams) {
        T t = this.f9515a;
        if (t != 0) {
            ((NSPVI) t).setLoadAdParams(loadAdParams);
        } else {
            this.j = loadAdParams;
        }
    }

    @Deprecated
    public void setPreloadView(View view) {
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setRewardListener(ADRewardListener aDRewardListener) {
        this.f9634i = aDRewardListener;
    }

    @Override // com.qq.e.comm.pi.IReward
    public void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.p = serverSideVerificationOptions;
        T t = this.f9515a;
        if (t != 0) {
            ((NSPVI) t).setServerSideVerificationOptions(serverSideVerificationOptions);
        }
    }

    public void showAd(ViewGroup viewGroup) {
        h(viewGroup, false);
    }

    public void showFullScreenAd(ViewGroup viewGroup) {
        h(viewGroup, true);
    }

    @Deprecated
    public void zoomOutAnimationFinish() {
        GDTLogger.e("注意！开屏V+功能已废弃，调用不生效");
    }

    @Override // com.qq.e.ads.AbstractAD
    public void a(Object obj) {
        NSPVI nspvi = (NSPVI) obj;
        if (this.j != null) {
            nspvi.setLoadAdParams(this.j);
        }
        if (this.n != 0) {
            nspvi.setDeveloperLogo(this.n);
        }
        if (this.o != null) {
            nspvi.setDeveloperLogo(this.o);
        }
        nspvi.setFetchDelay(this.f9635q);
        nspvi.setAdListener(new ADListenerAdapter());
        nspvi.setServerSideVerificationOptions(this.p);
        if (this.f9632g != null) {
            if (this.m) {
                fetchFullScreenAndShowIn(this.f9632g);
            } else {
                fetchAndShowIn(this.f9632g);
            }
        }
        if (this.k) {
            nspvi.preload();
            this.k = false;
        }
        if (this.l) {
            if (this.m) {
                nspvi.fetchFullScreenAdOnly();
            } else {
                nspvi.fetchAdOnly();
            }
            this.l = false;
        }
    }
}
