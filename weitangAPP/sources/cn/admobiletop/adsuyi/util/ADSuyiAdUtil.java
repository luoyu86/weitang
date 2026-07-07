package cn.admobiletop.adsuyi.util;

import android.app.Activity;
import cn.admobiletop.adsuyi.ADSuyiSdk;
import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.data.ADSuyiAdInfo;
import cn.admobiletop.adsuyi.ad.data.ADSuyiBaseAdInfo;
import cn.admobiletop.adsuyi.ad.data.ADSuyiFullScreenVodAdInfo;
import cn.admobiletop.adsuyi.ad.data.ADSuyiInnerNoticeAdInfo;
import cn.admobiletop.adsuyi.ad.data.ADSuyiInterstitialAdInfo;
import cn.admobiletop.adsuyi.ad.data.ADSuyiOnceShowAdInfo;
import cn.admobiletop.adsuyi.ad.data.ADSuyiRewardVodAdInfo;
import cn.admobiletop.adsuyi.ad.data.IBaseRelease;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiAdUtil {
    public static boolean a(ADSuyiOnceShowAdInfo aDSuyiOnceShowAdInfo, boolean z) {
        if (aDSuyiOnceShowAdInfo == null) {
            if (z) {
                ADSuyiToastUtil.show(ADSuyiSdk.getInstance().getContext(), "广告为空");
            }
            return false;
        }
        if (adInfoIsRelease(aDSuyiOnceShowAdInfo)) {
            if (z) {
                ADSuyiToastUtil.show(ADSuyiSdk.getInstance().getContext(), "广告已被释放");
            }
            return false;
        }
        if (!aDSuyiOnceShowAdInfo.isReady()) {
            if (z) {
                ADSuyiToastUtil.show(ADSuyiSdk.getInstance().getContext(), "广告还未准备好");
            }
            return false;
        }
        if (aDSuyiOnceShowAdInfo.hasShown()) {
            if (z) {
                ADSuyiToastUtil.show(ADSuyiSdk.getInstance().getContext(), "广告已观看过");
            }
            return false;
        }
        if (!aDSuyiOnceShowAdInfo.hasExpired()) {
            return true;
        }
        if (z) {
            ADSuyiToastUtil.show(ADSuyiSdk.getInstance().getContext(), "广告已过期");
        }
        return false;
    }

    public static boolean adInfoIsRelease(ADSuyiAdInfo aDSuyiAdInfo) {
        return aDSuyiAdInfo == null || aDSuyiAdInfo.isReleased();
    }

    public static boolean canCallBack(ADSuyiAd aDSuyiAd) {
        return (isReleased(aDSuyiAd) || aDSuyiAd.getListener() == null) ? false : true;
    }

    public static <T extends ADSuyiAdInfo> T getAdInfoWithAdapterAdInfo(List<T> list, Object obj) {
        if (obj == null || list == null || list.size() <= 0) {
            return null;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            T t = list.get(i2);
            if (t != null && (t instanceof ADSuyiBaseAdInfo) && ((ADSuyiBaseAdInfo) t).getAdapterAdInfo() == obj) {
                return t;
            }
        }
        return null;
    }

    public static boolean isReleased(ADSuyiAd aDSuyiAd) {
        return aDSuyiAd == null || aDSuyiAd.isReleased();
    }

    public static <T extends IBaseRelease> void releaseList(List<T> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            T t = list.get(i2);
            if (t != null) {
                t.release();
            }
        }
        list.clear();
    }

    public static void showFullScreenAdConvenient(Activity activity, ADSuyiFullScreenVodAdInfo aDSuyiFullScreenVodAdInfo) {
        showFullScreenAdConvenient(activity, aDSuyiFullScreenVodAdInfo, true);
    }

    public static void showInnerNoticeAdConvenient(Activity activity, ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo) {
        showInnerNoticeAdConvenient(activity, aDSuyiInnerNoticeAdInfo, true);
    }

    public static void showInterstitialAdConvenient(Activity activity, ADSuyiInterstitialAdInfo aDSuyiInterstitialAdInfo) {
        showInterstitialAdConvenient(activity, aDSuyiInterstitialAdInfo, true);
    }

    public static void showRewardVodAdConvenient(Activity activity, ADSuyiRewardVodAdInfo aDSuyiRewardVodAdInfo) {
        showRewardVodAdConvenient(activity, aDSuyiRewardVodAdInfo, true);
    }

    public static void showFullScreenAdConvenient(Activity activity, ADSuyiFullScreenVodAdInfo aDSuyiFullScreenVodAdInfo, boolean z) {
        if (a(aDSuyiFullScreenVodAdInfo, z)) {
            aDSuyiFullScreenVodAdInfo.showFullScreenVod(activity);
        }
    }

    public static void showInnerNoticeAdConvenient(Activity activity, ADSuyiInnerNoticeAdInfo aDSuyiInnerNoticeAdInfo, boolean z) {
        if (a(aDSuyiInnerNoticeAdInfo, z)) {
            aDSuyiInnerNoticeAdInfo.showInnerNoticeAd(activity);
        }
    }

    public static void showInterstitialAdConvenient(Activity activity, ADSuyiInterstitialAdInfo aDSuyiInterstitialAdInfo, boolean z) {
        if (a(aDSuyiInterstitialAdInfo, z)) {
            aDSuyiInterstitialAdInfo.showInterstitial(activity);
        }
    }

    public static void showRewardVodAdConvenient(Activity activity, ADSuyiRewardVodAdInfo aDSuyiRewardVodAdInfo, boolean z) {
        if (a(aDSuyiRewardVodAdInfo, z)) {
            aDSuyiRewardVodAdInfo.showRewardVod(activity);
        }
    }
}
