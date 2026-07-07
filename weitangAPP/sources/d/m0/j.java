package d.m0;

import d.g0.l0;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12700d;

    public j(int i2, int i3, int i4) {
        this.f12700d = i4;
        this.f12697a = i3;
        boolean z = true;
        if (i4 <= 0 ? i2 < i3 : i2 > i3) {
            z = false;
        }
        this.f12698b = z;
        this.f12699c = z ? i2 : i3;
    }

    public final int getStep() {
        return this.f12700d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12698b;
    }

    @Override // d.g0.l0
    public int nextInt() {
        int i2 = this.f12699c;
        if (i2 != this.f12697a) {
            this.f12699c = this.f12700d + i2;
        } else {
            if (!this.f12698b) {
                throw new NoSuchElementException();
            }
            this.f12698b = false;
        }
        return i2;
    }
}
