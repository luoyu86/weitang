package com.tom_roush.pdfbox.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class SmallMap<K, V> implements Map<K, V> {
    private Object[] mapArr;

    public class SmallMapEntry implements Map.Entry<K, V> {
        private final int keyIdx;

        public SmallMapEntry(int i2) {
            this.keyIdx = i2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof SmallMapEntry)) {
                return false;
            }
            SmallMapEntry smallMapEntry = (SmallMapEntry) obj;
            return getKey().equals(smallMapEntry.getKey()) && getValue().equals(smallMapEntry.getValue());
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) SmallMap.this.mapArr[this.keyIdx];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return (V) SmallMap.this.mapArr[this.keyIdx + 1];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return getKey().hashCode();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            Objects.requireNonNull(v, "Key or value must not be null.");
            V v2 = (V) getValue();
            SmallMap.this.mapArr[this.keyIdx + 1] = v;
            return v2;
        }
    }

    public SmallMap() {
    }

    private int findKey(Object obj) {
        if (!isEmpty() && obj != null) {
            int i2 = 0;
            while (true) {
                Object[] objArr = this.mapArr;
                if (i2 >= objArr.length) {
                    break;
                }
                if (obj.equals(objArr[i2])) {
                    return i2;
                }
                i2 += 2;
            }
        }
        return -1;
    }

    private int findValue(Object obj) {
        if (!isEmpty() && obj != null) {
            int i2 = 1;
            while (true) {
                Object[] objArr = this.mapArr;
                if (i2 >= objArr.length) {
                    break;
                }
                if (obj.equals(objArr[i2])) {
                    return i2;
                }
                i2 += 2;
            }
        }
        return -1;
    }

    @Override // java.util.Map
    public void clear() {
        this.mapArr = null;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return findKey(obj) >= 0;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return findValue(obj) >= 0;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i2 = 0; i2 < this.mapArr.length; i2 += 2) {
            linkedHashSet.add(new SmallMapEntry(i2));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        int iFindKey = findKey(obj);
        if (iFindKey < 0) {
            return null;
        }
        return (V) this.mapArr[iFindKey + 1];
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        Object[] objArr = this.mapArr;
        return objArr == null || objArr.length == 0;
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i2 = 0;
        while (true) {
            Object[] objArr = this.mapArr;
            if (i2 >= objArr.length) {
                return Collections.unmodifiableSet(linkedHashSet);
            }
            linkedHashSet.add(objArr[i2]);
            i2 += 2;
        }
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("Key or value must not be null.");
        }
        if (this.mapArr == null) {
            this.mapArr = new Object[]{k, v};
            return null;
        }
        int iFindKey = findKey(k);
        if (iFindKey >= 0) {
            Object[] objArr = this.mapArr;
            int i2 = iFindKey + 1;
            V v2 = (V) objArr[i2];
            objArr[i2] = v;
            return v2;
        }
        Object[] objArr2 = this.mapArr;
        int length = objArr2.length;
        Object[] objArr3 = new Object[length + 2];
        System.arraycopy(objArr2, 0, objArr3, 0, length);
        objArr3[length] = k;
        objArr3[length + 1] = v;
        this.mapArr = objArr3;
        return null;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        Object[] objArr = this.mapArr;
        int i2 = 0;
        if (objArr == null || objArr.length == 0) {
            this.mapArr = new Object[map.size() << 1];
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                if (entry.getKey() == null || entry.getValue() == null) {
                    throw new NullPointerException("Key or value must not be null.");
                }
                int i3 = i2 + 1;
                this.mapArr[i2] = entry.getKey();
                this.mapArr[i3] = entry.getValue();
                i2 = i3 + 1;
            }
            return;
        }
        int length = objArr.length;
        int size = (map.size() << 1) + length;
        Object[] objArr2 = new Object[size];
        System.arraycopy(this.mapArr, 0, objArr2, 0, length);
        for (Map.Entry<? extends K, ? extends V> entry2 : map.entrySet()) {
            if (entry2.getKey() == null || entry2.getValue() == null) {
                throw new NullPointerException("Key or value must not be null.");
            }
            int iFindKey = findKey(entry2.getKey());
            if (iFindKey >= 0) {
                objArr2[iFindKey + 1] = entry2.getValue();
            } else {
                int i4 = length + 1;
                objArr2[length] = entry2.getKey();
                length = i4 + 1;
                objArr2[i4] = entry2.getValue();
            }
        }
        if (length < size) {
            Object[] objArr3 = new Object[length];
            System.arraycopy(objArr2, 0, objArr3, 0, length);
            objArr2 = objArr3;
        }
        this.mapArr = objArr2;
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        int iFindKey = findKey(obj);
        if (iFindKey < 0) {
            return null;
        }
        Object[] objArr = this.mapArr;
        V v = (V) objArr[iFindKey + 1];
        int length = objArr.length;
        if (length == 2) {
            this.mapArr = null;
        } else {
            Object[] objArr2 = new Object[length - 2];
            System.arraycopy(objArr, 0, objArr2, 0, iFindKey);
            System.arraycopy(this.mapArr, iFindKey + 2, objArr2, iFindKey, (length - iFindKey) - 2);
            this.mapArr = objArr2;
        }
        return v;
    }

    @Override // java.util.Map
    public int size() {
        Object[] objArr = this.mapArr;
        if (objArr == null) {
            return 0;
        }
        return objArr.length >> 1;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        if (isEmpty()) {
            return Collections.emptySet();
        }
        int i2 = 1;
        ArrayList arrayList = new ArrayList(this.mapArr.length >> 1);
        while (true) {
            Object[] objArr = this.mapArr;
            if (i2 >= objArr.length) {
                return Collections.unmodifiableList(arrayList);
            }
            arrayList.add(objArr[i2]);
            i2 += 2;
        }
    }

    public SmallMap(Map<? extends K, ? extends V> map) {
        putAll(map);
    }
}
