package d.g0;

import com.taobao.accs.AccsClientConfig;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class u0<K, V> implements t0<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, V> f12553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.k0.c.l<K, V> f12554b;

    /* JADX WARN: Multi-variable type inference failed */
    public u0(Map<K, V> map, d.k0.c.l<? super K, ? extends V> lVar) {
        d.k0.d.t.checkNotNullParameter(map, "map");
        d.k0.d.t.checkNotNullParameter(lVar, AccsClientConfig.DEFAULT_CONFIG_TAG);
        this.f12553a = map;
        this.f12554b = lVar;
    }

    @Override // java.util.Map
    public void clear() {
        getMap().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return getMap().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return getMap().containsValue(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return getMap().equals(obj);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return getMap().get(obj);
    }

    public Set<Map.Entry<K, V>> getEntries() {
        return getMap().entrySet();
    }

    public Set<K> getKeys() {
        return getMap().keySet();
    }

    @Override // d.g0.t0, d.g0.n0
    public Map<K, V> getMap() {
        return this.f12553a;
    }

    @Override // d.g0.t0, d.g0.n0
    public V getOrImplicitDefault(K k) {
        Map<K, V> map = getMap();
        V v = map.get(k);
        return (v != null || map.containsKey(k)) ? v : this.f12554b.invoke(k);
    }

    public int getSize() {
        return getMap().size();
    }

    public Collection<V> getValues() {
        return getMap().values();
    }

    @Override // java.util.Map
    public int hashCode() {
        return getMap().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        return getMap().put(k, v);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        d.k0.d.t.checkNotNullParameter(map, "from");
        getMap().putAll(map);
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        return getMap().remove(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    public String toString() {
        return getMap().toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return getValues();
    }
}
