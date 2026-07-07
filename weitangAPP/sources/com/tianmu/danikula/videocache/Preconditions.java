package com.tianmu.danikula.videocache;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class Preconditions {
    public static void checkAllNotNull(Object... objArr) {
        for (Object obj : objArr) {
            Objects.requireNonNull(obj);
        }
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    public static void checkArgument(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static <T> T checkNotNull(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }
}
