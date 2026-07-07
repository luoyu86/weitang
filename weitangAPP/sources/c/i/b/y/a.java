package c.i.b.y;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static <T> T checkNotNull(T t) {
        Objects.requireNonNull(t);
        return t;
    }
}
