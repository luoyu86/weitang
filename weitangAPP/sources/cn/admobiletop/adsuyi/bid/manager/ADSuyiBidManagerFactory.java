package cn.admobiletop.adsuyi.bid.manager;

import cn.admobiletop.adsuyi.a.b.k;
import cn.admobiletop.adsuyi.a.g.e;
import cn.admobiletop.adsuyi.a.l.h;
import cn.admobiletop.adsuyi.a.m.b;
import cn.admobiletop.adsuyi.ad.ADSuyiAd;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterParams;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatform;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPosId;
import cn.admobiletop.adsuyi.ad.listener.ADSuyiAdListener;
import cn.admobiletop.adsuyi.bid.ADSuyiBidParams;
import cn.admobiletop.adsuyi.bid.ADSuyiBidType;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiBidManagerFactory {
    public static final String SUYI_BID_ADAPTER_NAME = "cn.admobiletop.adsuyi.bid";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f4103a = {"gdt", "tianmu", "ksad", MediationConstant.ADN_BAIDU, "vivoadsdk"};

    public static class SingletonInstance {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ADSuyiBidManagerFactory f4104a = new ADSuyiBidManagerFactory();
    }

    public static ADSuyiBidManagerFactory getInstance() {
        return SingletonInstance.f4104a;
    }

    public static <T> T reflexIniterClass(String str) {
        return (T) b.b("cn.admobiletop.adsuyi.bid." + str + ".ADSuyiBidManagerIniter");
    }

    public final boolean a(ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        return Arrays.asList(f4103a).contains(aDSuyiPlatformPosId.getPlatform());
    }

    public ADSuyiBidManager getBidManager(ADSuyiPlatformPosId aDSuyiPlatformPosId, String str, ADSuyiAd aDSuyiAd, ADSuyiAdListener aDSuyiAdListener, ADSuyiPosId aDSuyiPosId) {
        ADSuyiAdapterLoader suyiAdapterLoader;
        ADSuyiBidManager aDSuyiBidManager;
        try {
            ADSuyiAdapterIniter aDSuyiAdapterIniterB = h.l().b(aDSuyiPlatformPosId.getPlatform());
            int bidType = aDSuyiAdapterIniterB instanceof ADSuyiBidType ? ((ADSuyiBidType) aDSuyiAdapterIniterB).getBidType() : -1;
            boolean z = true;
            if (a(aDSuyiPlatformPosId) || bidType == 1) {
                ADSuyiPlatform aDSuyiPlatformC = h.l().c(aDSuyiPlatformPosId.getPlatform());
                if (aDSuyiAdapterIniterB != null && aDSuyiPlatformC != null && (suyiAdapterLoader = aDSuyiAdapterIniterB.getSuyiAdapterLoader(str)) != null && aDSuyiAd != null && aDSuyiAdListener != null && aDSuyiPosId != null && (suyiAdapterLoader instanceof ADSuyiBidManager) && (aDSuyiAdListener instanceof k)) {
                    ((k) aDSuyiAdListener).a(suyiAdapterLoader);
                    ADSuyiPreLoaderCacheManager.getInstance().addTheLatestPreAdapterLoader((k) aDSuyiAdListener, aDSuyiPlatformPosId.getPlatformPosId(), suyiAdapterLoader);
                    ADSuyiBidParams aDSuyiBidParams = new ADSuyiBidParams();
                    aDSuyiBidParams.setSuyiAd(aDSuyiAd);
                    aDSuyiBidParams.setListener(aDSuyiAdListener);
                    int iB = aDSuyiPosId instanceof e ? ((e) aDSuyiPosId).b() : 0;
                    int compelRefresh = aDSuyiPosId.getCompelRefresh();
                    boolean z2 = iB == 1;
                    String posId = aDSuyiPosId.getPosId();
                    if (compelRefresh != 1) {
                        z = false;
                    }
                    aDSuyiBidParams.setAdapterParams(new ADSuyiAdapterParams(aDSuyiPlatformPosId, aDSuyiPlatformC, z2, 1, posId, z));
                    ADSuyiBidManager aDSuyiBidManager2 = (ADSuyiBidManager) suyiAdapterLoader;
                    aDSuyiBidManager2.init(aDSuyiPlatformPosId, str, aDSuyiBidParams);
                    return aDSuyiBidManager2;
                }
            } else if ((bidType == 2 || bidType == -1) && (aDSuyiBidManager = (ADSuyiBidManager) reflexIniterClass(aDSuyiPlatformPosId.getPlatform())) != null) {
                aDSuyiBidManager.init(aDSuyiPlatformPosId, str, new ADSuyiBidParams());
                return aDSuyiBidManager;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public boolean isC2SBidType(ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        return aDSuyiPlatformPosId != null && aDSuyiPlatformPosId.isBidType() && Arrays.asList(f4103a).contains(aDSuyiPlatformPosId.getPlatform());
    }

    public ADSuyiBidManagerFactory() {
    }
}
