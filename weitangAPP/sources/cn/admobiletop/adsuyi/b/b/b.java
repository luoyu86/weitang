package cn.admobiletop.adsuyi.b.b;

import cn.admobiletop.adsuyi.a.b.k;
import cn.admobiletop.adsuyi.a.l.h;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterIniter;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import cn.admobiletop.adsuyi.ad.data.ADSuyiPlatformPosId;
import cn.admobiletop.adsuyi.adapter.toutiao.ADSuyiIniter;
import cn.admobiletop.adsuyi.bid.manager.ADSuyiPreLoaderCacheManager;
import cn.admobiletop.adsuyi.parallel.interf.ParallelAdLoadController;
import cn.admobiletop.adsuyi.util.ADSuyiLogUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String[] f4097a = {"gdt", ADSuyiIniter.PLATFORM, "ksad", MediationConstant.ADN_BAIDU};

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f4098a = new b();
    }

    public static b a() {
        return a.f4098a;
    }

    public b() {
    }

    public ParallelAdLoadController a(k kVar, String str, ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        ADSuyiAdapterIniter aDSuyiAdapterIniterB = h.l().b(aDSuyiPlatformPosId.getPlatform());
        if (aDSuyiAdapterIniterB == null) {
            return null;
        }
        ADSuyiLogUtil.ti("ADSuyiParallel", "新创建并发请求状态类：" + aDSuyiPlatformPosId.getPlatformPosId());
        ADSuyiAdapterLoader suyiAdapterLoader = aDSuyiAdapterIniterB.getSuyiAdapterLoader(str);
        if (!(suyiAdapterLoader instanceof ParallelAdLoadController)) {
            return null;
        }
        kVar.b(suyiAdapterLoader);
        ADSuyiPreLoaderCacheManager.getInstance().addTheLatestPreAdapterLoader(kVar, aDSuyiPlatformPosId.getPlatformPosId(), suyiAdapterLoader);
        return (ParallelAdLoadController) suyiAdapterLoader;
    }

    public boolean a(ADSuyiPlatformPosId aDSuyiPlatformPosId) {
        return aDSuyiPlatformPosId != null && Arrays.asList(f4097a).contains(aDSuyiPlatformPosId.getPlatform());
    }
}
