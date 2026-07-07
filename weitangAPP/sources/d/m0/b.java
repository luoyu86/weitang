package d.m0;

import d.g0.q;
import d.k0.d.t;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12684d;

    public b(char c2, char c3, int i2) {
        this.f12684d = i2;
        this.f12681a = c3;
        boolean z = true;
        if (i2 <= 0 ? t.compare((int) c2, (int) c3) < 0 : t.compare((int) c2, (int) c3) > 0) {
            z = false;
        }
        this.f12682b = z;
        this.f12683c = z ? c2 : c3;
    }

    public final int getStep() {
        return this.f12684d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12682b;
    }

    @Override // d.g0.q
    public char nextChar() {
        int i2 = this.f12683c;
        if (i2 != this.f12681a) {
            this.f12683c = this.f12684d + i2;
        } else {
            if (!this.f12682b) {
                throw new NoSuchElementException();
            }
            this.f12682b = false;
        }
        return (char) i2;
    }
}
