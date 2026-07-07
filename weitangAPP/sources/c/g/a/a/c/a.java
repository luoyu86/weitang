package c.g.a.a.c;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes2.dex */
public class a<T> implements b<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class<? extends T> f2525a;

    public a(@NonNull Class<? extends T> cls) {
        this.f2525a = cls;
    }

    @Override // c.g.a.a.c.b
    public T make() throws IllegalAccessException, InstantiationException {
        return this.f2525a.newInstance();
    }
}
