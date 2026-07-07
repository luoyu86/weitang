package com.tianmu.c.n;

import android.text.TextUtils;
import com.tianmu.ad.RewardAd;
import com.tianmu.ad.bean.RewardAdInfo;
import com.tianmu.ad.listener.RewardAdListener;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static l f11883d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, RewardAdListener> f11884a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, RewardAd> f11885b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, RewardAdInfo> f11886c = new HashMap();

    public static l a() {
        if (f11883d == null) {
            synchronized (l.class) {
                if (f11883d == null) {
                    f11883d = new l();
                }
            }
        }
        return f11883d;
    }

    public RewardAdInfo b(String str) {
        Map<String, RewardAdInfo> map = this.f11886c;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public void c(String str) {
        if (str != null) {
            Map<String, RewardAdListener> map = this.f11884a;
            if (map != null) {
                map.remove(str);
            }
            Map<String, RewardAd> map2 = this.f11885b;
            if (map2 != null) {
                map2.remove(str);
            }
            Map<String, RewardAdInfo> map3 = this.f11886c;
            if (map3 != null) {
                map3.remove(str);
            }
        }
    }

    public void a(String str, RewardAdListener rewardAdListener, RewardAd rewardAd, RewardAdInfo rewardAdInfo) {
        if (this.f11884a == null) {
            this.f11884a = new HashMap();
        }
        if (this.f11885b == null) {
            this.f11885b = new HashMap();
        }
        if (this.f11886c == null) {
            this.f11886c = new HashMap();
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (rewardAdListener != null) {
            this.f11884a.put(str, rewardAdListener);
        }
        if (rewardAd != null) {
            this.f11885b.put(str, rewardAd);
        }
        if (rewardAdInfo != null) {
            this.f11886c.put(str, rewardAdInfo);
        }
    }

    public RewardAd a(String str) {
        Map<String, RewardAd> map = this.f11885b;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
