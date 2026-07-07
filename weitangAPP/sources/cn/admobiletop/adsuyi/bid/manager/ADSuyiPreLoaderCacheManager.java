package cn.admobiletop.adsuyi.bid.manager;

import cn.admobiletop.adsuyi.a.b.k;
import cn.admobiletop.adsuyi.ad.adapter.ADSuyiAdapterLoader;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ADSuyiPreLoaderCacheManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Map<String, ADSuyiAdapterLoader>> f4105a;

    public static class INSTANCE {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static ADSuyiPreLoaderCacheManager f4106a = new ADSuyiPreLoaderCacheManager();
    }

    public static ADSuyiPreLoaderCacheManager getInstance() {
        return INSTANCE.f4106a;
    }

    public void addTheLatestPreAdapterLoader(k kVar, String str, ADSuyiAdapterLoader aDSuyiAdapterLoader) {
        if (kVar == null) {
            return;
        }
        Map<String, ADSuyiAdapterLoader> map = this.f4105a.get(kVar.toString());
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str, aDSuyiAdapterLoader);
        this.f4105a.put(kVar.toString(), map);
    }

    public ADSuyiAdapterLoader getTheLatestPreAdapterLoader(k kVar, String str) {
        Map<String, ADSuyiAdapterLoader> map;
        if (kVar == null || (map = this.f4105a.get(kVar.toString())) == null) {
            return null;
        }
        return map.get(str);
    }

    public void removePreAdapterLoader(k kVar, String str) {
        Map<String, ADSuyiAdapterLoader> map;
        if (kVar == null || (map = this.f4105a.get(kVar.toString())) == null) {
            return;
        }
        map.remove(str);
    }

    public ADSuyiPreLoaderCacheManager() {
        this.f4105a = new HashMap();
    }
}
