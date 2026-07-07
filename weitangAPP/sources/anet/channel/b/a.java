package anet.channel.b;

import a.a.n.a;
import anet.channel.util.ALog;
import anet.channel.util.StringUtils;
import com.taobao.alivfssdk.cache.AVFSCache;
import com.taobao.alivfssdk.cache.AVFSCacheConfig;
import com.taobao.alivfssdk.cache.AVFSCacheManager;
import com.taobao.alivfssdk.cache.IAVFSCache;

/* JADX INFO: loaded from: classes.dex */
public class a implements a.a.n.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f377a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object f378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Object f379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Object f380d;

    static {
        try {
            Class.forName("com.taobao.alivfssdk.cache.AVFSCacheManager");
            f378b = new b();
            f379c = new c();
            f380d = new d();
        } catch (ClassNotFoundException unused) {
            f377a = false;
            ALog.w("anet.AVFSCacheImpl", "no alivfs sdk!", null, new Object[0]);
        }
    }

    private IAVFSCache b() {
        AVFSCache aVFSCacheCacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache");
        if (aVFSCacheCacheForModule != null) {
            return aVFSCacheCacheForModule.getFileCache();
        }
        return null;
    }

    public void a() {
        AVFSCache aVFSCacheCacheForModule;
        if (f377a && (aVFSCacheCacheForModule = AVFSCacheManager.getInstance().cacheForModule("networksdk.httpcache")) != null) {
            AVFSCacheConfig aVFSCacheConfig = new AVFSCacheConfig();
            aVFSCacheConfig.limitSize = 5242880L;
            aVFSCacheConfig.fileMemMaxSize = 1048576L;
            aVFSCacheCacheForModule.moduleConfig(aVFSCacheConfig);
        }
    }

    @Override // a.a.n.a
    public void clear() {
        if (f377a) {
            try {
                IAVFSCache iAVFSCacheB = b();
                if (iAVFSCacheB != null) {
                    iAVFSCacheB.removeAllObject((IAVFSCache.OnAllObjectRemoveCallback) f380d);
                }
            } catch (Exception e2) {
                ALog.e("anet.AVFSCacheImpl", "clear cache failed", null, e2, new Object[0]);
            }
        }
    }

    @Override // a.a.n.a
    public a.C0000a get(String str) {
        if (!f377a) {
            return null;
        }
        try {
            IAVFSCache iAVFSCacheB = b();
            if (iAVFSCacheB != null) {
                return (a.C0000a) iAVFSCacheB.objectForKey(StringUtils.md5ToHex(str));
            }
        } catch (Exception e2) {
            ALog.e("anet.AVFSCacheImpl", "get cache failed", null, e2, new Object[0]);
        }
        return null;
    }

    @Override // a.a.n.a
    public void put(String str, a.C0000a c0000a) {
        if (f377a) {
            try {
                IAVFSCache iAVFSCacheB = b();
                if (iAVFSCacheB != null) {
                    iAVFSCacheB.setObjectForKey(StringUtils.md5ToHex(str), c0000a, (IAVFSCache.OnObjectSetCallback) f378b);
                }
            } catch (Exception e2) {
                ALog.e("anet.AVFSCacheImpl", "put cache failed", null, e2, new Object[0]);
            }
        }
    }

    @Override // a.a.n.a
    public void remove(String str) {
        if (f377a) {
            try {
                IAVFSCache iAVFSCacheB = b();
                if (iAVFSCacheB != null) {
                    iAVFSCacheB.removeObjectForKey(StringUtils.md5ToHex(str), (IAVFSCache.OnObjectRemoveCallback) f379c);
                }
            } catch (Exception e2) {
                ALog.e("anet.AVFSCacheImpl", "remove cache failed", null, e2, new Object[0]);
            }
        }
    }
}
