package com.bumptech.glide.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LruCache<T, Y> {
    private final LinkedHashMap<T, Y> cache = new LinkedHashMap<>(100, 0.75f, true);
    private int currentSize = 0;
    private final int initialMaxSize;
    private int maxSize;

    public LruCache(int i2) {
        this.initialMaxSize = i2;
        this.maxSize = i2;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public void clearMemory() {
        trimToSize(0);
    }

    public boolean contains(T t) {
        return this.cache.containsKey(t);
    }

    public Y get(T t) {
        return this.cache.get(t);
    }

    public int getCurrentSize() {
        return this.currentSize;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public int getSize(Y y) {
        return 1;
    }

    public void onItemEvicted(T t, Y y) {
    }

    public Y put(T t, Y y) {
        if (getSize(y) >= this.maxSize) {
            onItemEvicted(t, y);
            return null;
        }
        Y yPut = this.cache.put(t, y);
        if (y != null) {
            this.currentSize += getSize(y);
        }
        if (yPut != null) {
            this.currentSize -= getSize(yPut);
        }
        evict();
        return yPut;
    }

    public Y remove(T t) {
        Y yRemove = this.cache.remove(t);
        if (yRemove != null) {
            this.currentSize -= getSize(yRemove);
        }
        return yRemove;
    }

    public void setSizeMultiplier(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
        this.maxSize = Math.round(this.initialMaxSize * f2);
        evict();
    }

    public void trimToSize(int i2) {
        while (this.currentSize > i2) {
            Map.Entry<T, Y> next = this.cache.entrySet().iterator().next();
            Y value = next.getValue();
            this.currentSize -= getSize(value);
            T key = next.getKey();
            this.cache.remove(key);
            onItemEvicted(key, value);
        }
    }
}
