package c.e.c.m0;

import c.e.a.d.x;
import com.chinavisionary.microtang.me.vo.CleanProductDetailsVo;
import com.chinavisionary.microtang.room.vo.MoreRentRoomVo;
import com.chinavisionary.microtang.vo.AppTempCacheVo;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f1686a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f1687b = new ReentrantLock();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<String, AppTempCacheVo<List<MoreRentRoomVo>>> f1688c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<String, AppTempCacheVo<CleanProductDetailsVo>> f1689d = new ConcurrentHashMap<>();

    public static d getInstance() {
        return f1686a;
    }

    public final boolean a(Long l) {
        return l != null && System.currentTimeMillis() - l.longValue() < 90000;
    }

    public void addLifeDetails(String str, CleanProductDetailsVo cleanProductDetailsVo) {
        this.f1687b.lock();
        try {
            if (x.isNotNull(str)) {
                if (this.f1689d.containsKey(str)) {
                    this.f1689d.remove(str);
                }
                AppTempCacheVo<CleanProductDetailsVo> appTempCacheVo = new AppTempCacheVo<>();
                appTempCacheVo.setCacheDataObj(cleanProductDetailsVo);
                appTempCacheVo.setCacheKey(str);
                appTempCacheVo.setCacheCreateTime(Long.valueOf(System.currentTimeMillis()));
                this.f1689d.put(str, appTempCacheVo);
            }
        } finally {
            this.f1687b.unlock();
        }
    }

    public void addMoreRentRoom(String str, List<MoreRentRoomVo> list) {
        this.f1687b.lock();
        try {
            if (x.isNotNull(str)) {
                if (this.f1688c.containsKey(str)) {
                    this.f1688c.remove(str);
                }
                AppTempCacheVo<List<MoreRentRoomVo>> appTempCacheVo = new AppTempCacheVo<>();
                appTempCacheVo.setCacheDataObj(list);
                appTempCacheVo.setCacheKey(str);
                appTempCacheVo.setCacheCreateTime(Long.valueOf(System.currentTimeMillis()));
                this.f1688c.put(str, appTempCacheVo);
            }
        } finally {
            this.f1687b.unlock();
        }
    }

    public List<MoreRentRoomVo> getCacheMoreRentRoom(String str) {
        AppTempCacheVo<List<MoreRentRoomVo>> appTempCacheVo;
        this.f1687b.lock();
        try {
            return (x.isNotNull(str) && this.f1688c.containsKey(str) && (appTempCacheVo = this.f1688c.get(str)) != null && a(appTempCacheVo.getCacheCreateTime())) ? appTempCacheVo.getCacheDataObj() : null;
        } finally {
            this.f1687b.unlock();
        }
    }

    public CleanProductDetailsVo getCleanProductDetailsVo(String str) {
        AppTempCacheVo<CleanProductDetailsVo> appTempCacheVo;
        this.f1687b.lock();
        try {
            return (x.isNotNull(str) && this.f1689d.containsKey(str) && (appTempCacheVo = this.f1689d.get(str)) != null) ? appTempCacheVo.getCacheDataObj() : null;
        } finally {
            this.f1687b.unlock();
        }
    }
}
