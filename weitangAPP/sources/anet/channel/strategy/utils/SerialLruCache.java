package anet.channel.strategy.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SerialLruCache<K, V> extends LinkedHashMap<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f694a;

    public SerialLruCache(LinkedHashMap<K, V> linkedHashMap, int i2) {
        super(linkedHashMap);
        this.f694a = i2;
    }

    public boolean entryRemoved(Map.Entry<K, V> entry) {
        return true;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        if (size() > this.f694a) {
            return entryRemoved(entry);
        }
        return false;
    }

    @Deprecated
    public SerialLruCache(LinkedHashMap<K, V> linkedHashMap) {
        this(linkedHashMap, 256);
    }

    public SerialLruCache(int i2) {
        super(i2 + 1, 1.0f, true);
        this.f694a = i2;
    }
}
