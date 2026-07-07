package d.g0;

import com.alibaba.mtl.appmonitor.AppMonitorDelegate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class r0 extends q0 {
    public static final <K, V> Map<K, V> emptyMap() {
        e0 e0Var = e0.INSTANCE;
        Objects.requireNonNull(e0Var, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
        return e0Var;
    }

    public static final <K, V> Map<K, V> filter(Map<? extends K, ? extends V> map, d.k0.c.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$filter");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> filterKeys(Map<? extends K, ? extends V> map, d.k0.c.l<? super K, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$filterKeys");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry.getKey()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> filterNot(Map<? extends K, ? extends V> map, d.k0.c.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$filterNot");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!lVar.invoke(entry).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M filterNotTo(Map<? extends K, ? extends V> map, M m, d.k0.c.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$filterNotTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (!lVar.invoke(entry).booleanValue()) {
                m.put(entry.getKey(), entry.getValue());
            }
        }
        return m;
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M filterTo(Map<? extends K, ? extends V> map, M m, d.k0.c.l<? super Map.Entry<? extends K, ? extends V>, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$filterTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry).booleanValue()) {
                m.put(entry.getKey(), entry.getValue());
            }
        }
        return m;
    }

    public static final <K, V> Map<K, V> filterValues(Map<? extends K, ? extends V> map, d.k0.c.l<? super V, Boolean> lVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$filterValues");
        d.k0.d.t.checkNotNullParameter(lVar, "predicate");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            if (lVar.invoke(entry.getValue()).booleanValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public static final <K, V> V getOrElseNullable(Map<K, ? extends V> map, K k, d.k0.c.a<? extends V> aVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$getOrElseNullable");
        d.k0.d.t.checkNotNullParameter(aVar, AppMonitorDelegate.DEFAULT_VALUE);
        V v = map.get(k);
        return (v != null || map.containsKey(k)) ? v : aVar.invoke();
    }

    public static final <K, V> V getOrPut(Map<K, V> map, K k, d.k0.c.a<? extends V> aVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$getOrPut");
        d.k0.d.t.checkNotNullParameter(aVar, AppMonitorDelegate.DEFAULT_VALUE);
        V v = map.get(k);
        if (v != null) {
            return v;
        }
        V vInvoke = aVar.invoke();
        map.put(k, vInvoke);
        return vInvoke;
    }

    public static final <K, V> V getValue(Map<K, ? extends V> map, K k) {
        d.k0.d.t.checkNotNullParameter(map, "$this$getValue");
        return (V) p0.getOrImplicitDefaultNullable(map, k);
    }

    public static final <K, V> HashMap<K, V> hashMapOf(d.m<? extends K, ? extends V>... mVarArr) {
        d.k0.d.t.checkNotNullParameter(mVarArr, "pairs");
        HashMap<K, V> map = new HashMap<>(q0.mapCapacity(mVarArr.length));
        putAll(map, mVarArr);
        return map;
    }

    public static final <K, V> LinkedHashMap<K, V> linkedMapOf(d.m<? extends K, ? extends V>... mVarArr) {
        d.k0.d.t.checkNotNullParameter(mVarArr, "pairs");
        return (LinkedHashMap) toMap(mVarArr, new LinkedHashMap(q0.mapCapacity(mVarArr.length)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R> Map<R, V> mapKeys(Map<? extends K, ? extends V> map, d.k0.c.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$mapKeys");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(q0.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(lVar.invoke(entry), entry.getValue());
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R, M extends Map<? super R, ? super V>> M mapKeysTo(Map<? extends K, ? extends V> map, M m, d.k0.c.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$mapKeysTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            m.put(lVar.invoke(entry), entry.getValue());
        }
        return m;
    }

    public static final <K, V> Map<K, V> mapOf(d.m<? extends K, ? extends V>... mVarArr) {
        d.k0.d.t.checkNotNullParameter(mVarArr, "pairs");
        return mVarArr.length > 0 ? toMap(mVarArr, new LinkedHashMap(q0.mapCapacity(mVarArr.length))) : emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R> Map<K, R> mapValues(Map<? extends K, ? extends V> map, d.k0.c.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$mapValues");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        LinkedHashMap linkedHashMap = new LinkedHashMap(q0.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            linkedHashMap.put(entry.getKey(), lVar.invoke(entry));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V, R, M extends Map<? super K, ? super R>> M mapValuesTo(Map<? extends K, ? extends V> map, M m, d.k0.c.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> lVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$mapValuesTo");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Object) it.next();
            m.put(entry.getKey(), lVar.invoke(entry));
        }
        return m;
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, K k) {
        d.k0.d.t.checkNotNullParameter(map, "$this$minus");
        Map mutableMap = toMutableMap(map);
        mutableMap.remove(k);
        return optimizeReadOnlyMap(mutableMap);
    }

    public static final <K, V> Map<K, V> mutableMapOf(d.m<? extends K, ? extends V>... mVarArr) {
        d.k0.d.t.checkNotNullParameter(mVarArr, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(q0.mapCapacity(mVarArr.length));
        putAll(linkedHashMap, mVarArr);
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> optimizeReadOnlyMap(Map<K, ? extends V> map) {
        d.k0.d.t.checkNotNullParameter(map, "$this$optimizeReadOnlyMap");
        int size = map.size();
        return size != 0 ? size != 1 ? map : q0.toSingletonMap(map) : emptyMap();
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, d.m<? extends K, ? extends V> mVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$plus");
        d.k0.d.t.checkNotNullParameter(mVar, "pair");
        if (map.isEmpty()) {
            return q0.mapOf(mVar);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put(mVar.getFirst(), mVar.getSecond());
        return linkedHashMap;
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, d.m<? extends K, ? extends V>[] mVarArr) {
        d.k0.d.t.checkNotNullParameter(map, "$this$putAll");
        d.k0.d.t.checkNotNullParameter(mVarArr, "pairs");
        for (d.m<? extends K, ? extends V> mVar : mVarArr) {
            map.put(mVar.component1(), mVar.component2());
        }
    }

    public static final <K, V> Map<K, V> toMap(Iterable<? extends d.m<? extends K, ? extends V>> iterable) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$toMap");
        if (!(iterable instanceof Collection)) {
            return optimizeReadOnlyMap(toMap(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return emptyMap();
        }
        if (size != 1) {
            return toMap(iterable, new LinkedHashMap(q0.mapCapacity(collection.size())));
        }
        return q0.mapOf(iterable instanceof List ? (d.m<? extends K, ? extends V>) ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static final <K, V> Map<K, V> toMutableMap(Map<? extends K, ? extends V> map) {
        d.k0.d.t.checkNotNullParameter(map, "$this$toMutableMap");
        return new LinkedHashMap(map);
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, Iterable<? extends K> iterable) {
        d.k0.d.t.checkNotNullParameter(map, "$this$minus");
        d.k0.d.t.checkNotNullParameter(iterable, "keys");
        Map mutableMap = toMutableMap(map);
        x.removeAll(mutableMap.keySet(), iterable);
        return optimizeReadOnlyMap(mutableMap);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Iterable<? extends d.m<? extends K, ? extends V>> iterable) {
        d.k0.d.t.checkNotNullParameter(map, "$this$plus");
        d.k0.d.t.checkNotNullParameter(iterable, "pairs");
        if (map.isEmpty()) {
            return toMap(iterable);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        putAll(linkedHashMap, iterable);
        return linkedHashMap;
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, K[] kArr) {
        d.k0.d.t.checkNotNullParameter(map, "$this$minus");
        d.k0.d.t.checkNotNullParameter(kArr, "keys");
        Map mutableMap = toMutableMap(map);
        x.removeAll(mutableMap.keySet(), kArr);
        return optimizeReadOnlyMap(mutableMap);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, d.m<? extends K, ? extends V>[] mVarArr) {
        d.k0.d.t.checkNotNullParameter(map, "$this$plus");
        d.k0.d.t.checkNotNullParameter(mVarArr, "pairs");
        if (map.isEmpty()) {
            return toMap(mVarArr);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        putAll(linkedHashMap, mVarArr);
        return linkedHashMap;
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, Iterable<? extends d.m<? extends K, ? extends V>> iterable) {
        d.k0.d.t.checkNotNullParameter(map, "$this$putAll");
        d.k0.d.t.checkNotNullParameter(iterable, "pairs");
        for (d.m<? extends K, ? extends V> mVar : iterable) {
            map.put(mVar.component1(), mVar.component2());
        }
    }

    public static final <K, V> Map<K, V> minus(Map<? extends K, ? extends V> map, d.o0.m<? extends K> mVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$minus");
        d.k0.d.t.checkNotNullParameter(mVar, "keys");
        Map mutableMap = toMutableMap(map);
        x.removeAll(mutableMap.keySet(), mVar);
        return optimizeReadOnlyMap(mutableMap);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, d.o0.m<? extends d.m<? extends K, ? extends V>> mVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$plus");
        d.k0.d.t.checkNotNullParameter(mVar, "pairs");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        putAll(linkedHashMap, mVar);
        return optimizeReadOnlyMap(linkedHashMap);
    }

    public static final <K, V> Map<K, V> plus(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        d.k0.d.t.checkNotNullParameter(map, "$this$plus");
        d.k0.d.t.checkNotNullParameter(map2, "map");
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return linkedHashMap;
    }

    public static final <K, V> void putAll(Map<? super K, ? super V> map, d.o0.m<? extends d.m<? extends K, ? extends V>> mVar) {
        d.k0.d.t.checkNotNullParameter(map, "$this$putAll");
        d.k0.d.t.checkNotNullParameter(mVar, "pairs");
        for (d.m<? extends K, ? extends V> mVar2 : mVar) {
            map.put(mVar2.component1(), mVar2.component2());
        }
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Iterable<? extends d.m<? extends K, ? extends V>> iterable, M m) {
        d.k0.d.t.checkNotNullParameter(iterable, "$this$toMap");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        putAll(m, iterable);
        return m;
    }

    public static final <K, V> Map<K, V> toMap(d.m<? extends K, ? extends V>[] mVarArr) {
        d.k0.d.t.checkNotNullParameter(mVarArr, "$this$toMap");
        int length = mVarArr.length;
        if (length == 0) {
            return emptyMap();
        }
        if (length != 1) {
            return toMap(mVarArr, new LinkedHashMap(q0.mapCapacity(mVarArr.length)));
        }
        return q0.mapOf(mVarArr[0]);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(d.m<? extends K, ? extends V>[] mVarArr, M m) {
        d.k0.d.t.checkNotNullParameter(mVarArr, "$this$toMap");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        putAll(m, mVarArr);
        return m;
    }

    public static final <K, V> Map<K, V> toMap(d.o0.m<? extends d.m<? extends K, ? extends V>> mVar) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$toMap");
        return optimizeReadOnlyMap(toMap(mVar, new LinkedHashMap()));
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(d.o0.m<? extends d.m<? extends K, ? extends V>> mVar, M m) {
        d.k0.d.t.checkNotNullParameter(mVar, "$this$toMap");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        putAll(m, mVar);
        return m;
    }

    public static final <K, V> Map<K, V> toMap(Map<? extends K, ? extends V> map) {
        d.k0.d.t.checkNotNullParameter(map, "$this$toMap");
        int size = map.size();
        if (size == 0) {
            return emptyMap();
        }
        if (size != 1) {
            return toMutableMap(map);
        }
        return q0.toSingletonMap(map);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> M toMap(Map<? extends K, ? extends V> map, M m) {
        d.k0.d.t.checkNotNullParameter(map, "$this$toMap");
        d.k0.d.t.checkNotNullParameter(m, "destination");
        m.putAll(map);
        return m;
    }
}
