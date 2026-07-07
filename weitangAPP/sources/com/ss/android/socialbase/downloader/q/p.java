package com.ss.android.socialbase.downloader.q;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class p<K, T> extends LinkedHashMap<K, T> {
    private int ok;

    public p() {
        this(4, 4);
    }

    public void ok(int i2) {
        this.ok = i2;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.ok;
    }

    public p(int i2, int i3) {
        this(i2, i3, true);
    }

    public p(int i2, int i3, boolean z) {
        super(i2, 0.75f, z);
        ok(i3);
    }
}
