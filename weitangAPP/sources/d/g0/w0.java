package d.g0;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class w0<T> extends d<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<T> f12556b;

    /* JADX WARN: Multi-variable type inference failed */
    public w0(List<? extends T> list) {
        d.k0.d.t.checkNotNullParameter(list, "delegate");
        this.f12556b = list;
    }

    @Override // d.g0.d, java.util.List
    public T get(int i2) {
        return this.f12556b.get(y.f(this, i2));
    }

    @Override // d.g0.d, d.g0.a
    public int getSize() {
        return this.f12556b.size();
    }
}
