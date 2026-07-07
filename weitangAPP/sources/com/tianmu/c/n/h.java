package com.tianmu.c.n;

import android.text.TextUtils;
import com.tianmu.ad.InterstitialAd;
import com.tianmu.ad.bean.InterstitialAdInfo;
import com.tianmu.ad.listener.InterstitialAdListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static h f11866d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, InterstitialAdListener> f11867a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, InterstitialAd> f11868b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, InterstitialAdInfo> f11869c = new HashMap();

    public static h a() {
        if (f11866d == null) {
            synchronized (h.class) {
                if (f11866d == null) {
                    f11866d = new h();
                }
            }
        }
        return f11866d;
    }

    public InterstitialAdInfo b(String str) {
        Map<String, InterstitialAdInfo> map = this.f11869c;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public InterstitialAdListener c(String str) {
        Map<String, InterstitialAdListener> map = this.f11867a;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public void d(String str) {
        if (str != null) {
            Map<String, InterstitialAdListener> map = this.f11867a;
            if (map != null) {
                map.remove(str);
            }
            Map<String, InterstitialAd> map2 = this.f11868b;
            if (map2 != null) {
                map2.remove(str);
            }
            Map<String, InterstitialAdInfo> map3 = this.f11869c;
            if (map3 != null) {
                map3.remove(str);
            }
        }
    }

    public void a(String str, InterstitialAdListener interstitialAdListener, InterstitialAd interstitialAd, InterstitialAdInfo interstitialAdInfo) {
        if (this.f11867a == null) {
            this.f11867a = new HashMap();
        }
        if (this.f11868b == null) {
            this.f11868b = new HashMap();
        }
        if (this.f11869c == null) {
            this.f11869c = new HashMap();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (interstitialAdListener != null) {
            this.f11867a.put(str, interstitialAdListener);
        }
        if (interstitialAd != null) {
            this.f11868b.put(str, interstitialAd);
        }
        if (interstitialAdInfo != null) {
            this.f11869c.put(str, interstitialAdInfo);
        }
    }

    public InterstitialAd a(String str) {
        Map<String, InterstitialAd> map = this.f11868b;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
