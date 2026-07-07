package d.g0;

import com.taobao.accs.AccsClientConfig;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class o0<K, V> implements n0<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, V> f12545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d.k0.c.l<K, V> f12546b;

    /* JADX WARN: Multi-variable type inference failed */
    public o0(Map<K, ? extends V> map, d.k0.c.l<? super K, ? extends V> lVar) {
        d.k0.d.t.checkNotNullParameter(map, "map");
        d.k0.d.t.checkNotNullParameter(lVar, AccsClientConfig.DEFAULT_CONFIG_TAG);
        this.f12545a = map;
        this.f12546b = lVar;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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

    @Override // d.g0.n0
    public Map<K, V> getMap() {
        return this.f12545a;
    }

    @Override // d.g0.n0
    public V getOrImplicitDefault(K k) {
        Map<K, V> map = getMap();
        V v = map.get(k);
        return (v != null || map.containsKey(k)) ? v : this.f12546b.invoke(k);
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
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
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
