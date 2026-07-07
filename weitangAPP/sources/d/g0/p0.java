package d.g0;

import com.alibaba.mtl.appmonitor.AppMonitorDelegate;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public class p0 {
    public static final <K, V> V getOrImplicitDefaultNullable(Map<K, ? extends V> map, K k) {
        d.k0.d.t.checkNotNullParameter(map, "$this$getOrImplicitDefault");
        if (map instanceof n0) {
            return (V) ((n0) map).getOrImplicitDefault(k);
        }
        V v = map.get(k);
        if (v != null || map.containsKey(k)) {
            return v;
        }
        throw new NoSuchElementException("Key " + k + " is missing in the map.");
    }

    public static final <K, V> Map<K, V> withDefault(Map<K, ? extends V> map, d.k0.c.l<? super K, ? extends V> lVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$withDefault");
        d.k0.d.t.checkNotNullParameter(lVar, AppMonitorDelegate.DEFAULT_VALUE);
        return map instanceof n0 ? withDefault(((n0) map).getMap(), lVar) : new o0(map, lVar);
    }

    public static final <K, V> Map<K, V> withDefaultMutable(Map<K, V> map, d.k0.c.l<? super K, ? extends V> lVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$withDefault");
        d.k0.d.t.checkNotNullParameter(lVar, AppMonitorDelegate.DEFAULT_VALUE);
        return map instanceof t0 ? withDefaultMutable(((t0) map).getMap(), lVar) : new u0(map, lVar);
    }
}
