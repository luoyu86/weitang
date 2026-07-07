package com.bykv.vk.openvk.api.proto;

import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface ValueSet {

    public interface ValueGetter<T> {
        T get();
    }

    <T> T[] arrayValue(int i2, Class<T> cls);

    boolean booleanValue(int i2);

    boolean booleanValue(int i2, boolean z);

    boolean containsKey(int i2);

    double doubleValue(int i2);

    float floatValue(int i2);

    float floatValue(int i2, float f2);

    int intValue(int i2);

    int intValue(int i2, int i3);

    boolean isEmpty();

    Set<Integer> keys();

    long longValue(int i2);

    long longValue(int i2, long j);

    <T> T objectValue(int i2, Class<T> cls);

    int size();

    String stringValue(int i2);

    String stringValue(int i2, String str);
}
