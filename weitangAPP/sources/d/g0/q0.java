package d.g0;

import androidx.appcompat.widget.ActivityChooserView;
import com.alibaba.mtl.appmonitor.AppMonitorDelegate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes2.dex */
public class q0 extends p0 {
    public static final <K, V> Map<K, V> build(Map<K, V> map) {
        d.k0.d.t.checkNotNullParameter(map, "builder");
        return ((d.g0.i1.d) map).build();
    }

    public static final <K, V> Map<K, V> createMapBuilder() {
        return new d.g0.i1.d();
    }

    public static final <K, V> V getOrPut(ConcurrentMap<K, V> concurrentMap, K k, d.k0.c.a<? extends V> aVar) {
        d.k0.d.t.checkNotNullParameter(concurrentMap, "$this$getOrPut");
        d.k0.d.t.checkNotNullParameter(aVar, AppMonitorDelegate.DEFAULT_VALUE);
        V v = concurrentMap.get(k);
        if (v != null) {
            return v;
        }
        V vInvoke = aVar.invoke();
        V vPutIfAbsent = concurrentMap.putIfAbsent(k, vInvoke);
        return vPutIfAbsent != null ? vPutIfAbsent : vInvoke;
    }

    public static final int mapCapacity(int i2) {
        return i2 < 0 ? i2 : i2 < 3 ? i2 + 1 : i2 < 1073741824 ? (int) ((i2 / 0.75f) + 1.0f) : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public static final <K, V> Map<K, V> mapOf(d.m<? extends K, ? extends V> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "pair");
        Map<K, V> mapSingletonMap = Collections.singletonMap(mVar.getFirst(), mVar.getSecond());
        d.k0.d.t.checkNotNullExpressionValue(mapSingletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return mapSingletonMap;
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> sortedMapOf(d.m<? extends K, ? extends V>... mVarArr) {
        d.k0.d.t.checkNotNullParameter(mVarArr, "pairs");
        TreeMap treeMap = new TreeMap();
        r0.putAll(treeMap, mVarArr);
        return treeMap;
    }

    public static final <K, V> Map<K, V> toSingletonMap(Map<? extends K, ? extends V> map) {
        d.k0.d.t.checkNotNullParameter(map, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> mapSingletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        d.k0.d.t.checkNotNullExpressionValue(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }

    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map) {
        d.k0.d.t.checkNotNullParameter(map, "$this$toSortedMap");
        return new TreeMap(map);
    }

    public static final <K, V> Map<K, V> createMapBuilder(int i2) {
        return new d.g0.i1.d(i2);
    }

    public static final <K, V> SortedMap<K, V> sortedMapOf(Comparator<? super K> comparator, d.m<? extends K, ? extends V>... mVarArr) {
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        d.k0.d.t.checkNotNullParameter(mVarArr, "pairs");
        TreeMap treeMap = new TreeMap(comparator);
        r0.putAll(treeMap, mVarArr);
        return treeMap;
    }

    public static final <K, V> SortedMap<K, V> toSortedMap(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        d.k0.d.t.checkNotNullParameter(map, "$this$toSortedMap");
        d.k0.d.t.checkNotNullParameter(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
