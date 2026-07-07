package d;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class b<T> implements g<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f12417a;

    public b(T t) {
        this.f12417a = t;
    }

    @Override // d.g
    public T getValue() {
        return this.f12417a;
    }

    @Override // d.g
    public boolean isInitialized() {
        return true;
    }

    public String toString() {
        return String.valueOf(getValue());
    }
}
