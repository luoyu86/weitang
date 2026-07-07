package cn.admobiletop.adsuyi.a.j;

import cn.admobiletop.adsuyi.a.b.w;
import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.ADSuyiBannerAd;
import cn.admobiletop.adsuyi.ad.ADSuyiContentAllianceAd;
import cn.admobiletop.adsuyi.ad.ADSuyiDrawVodAd;
import cn.admobiletop.adsuyi.ad.ADSuyiFullScreenVodAd;
import cn.admobiletop.adsuyi.ad.ADSuyiInnerNoticeAd;
import cn.admobiletop.adsuyi.ad.ADSuyiInterstitialAd;
import cn.admobiletop.adsuyi.ad.ADSuyiNativeAd;
import cn.admobiletop.adsuyi.ad.ADSuyiRewardVodAd;
import cn.admobiletop.adsuyi.ad.ADSuyiSplashAd;

/* JADX INFO: loaded from: classes.dex */
public class g {
    public static <E extends ADSuyiAd> w a(E e2) {
        if (e2 instanceof ADSuyiSplashAd) {
            return new j((ADSuyiSplashAd) e2);
        }
        if (e2 instanceof ADSuyiBannerAd) {
            return new a((ADSuyiBannerAd) e2);
        }
        if (e2 instanceof ADSuyiNativeAd) {
            return new h((ADSuyiNativeAd) e2);
        }
        if (e2 instanceof ADSuyiRewardVodAd) {
            return new i((ADSuyiRewardVodAd) e2);
        }
        if (e2 instanceof ADSuyiFullScreenVodAd) {
            return new d((ADSuyiFullScreenVodAd) e2);
        }
        if (e2 instanceof ADSuyiDrawVodAd) {
            return new c((ADSuyiDrawVodAd) e2);
        }
        if (e2 instanceof ADSuyiInterstitialAd) {
            return new f((ADSuyiInterstitialAd) e2);
        }
        if (e2 instanceof ADSuyiInnerNoticeAd) {
            return new e((ADSuyiInnerNoticeAd) e2);
        }
        if (e2 instanceof ADSuyiContentAllianceAd) {
            return new b((ADSuyiContentAllianceAd) e2);
        }
        return null;
    }
}
