package d.m0;

import d.g0.m0;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f12709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f12710d;

    public m(long j, long j2, long j3) {
        this.f12710d = j3;
        this.f12707a = j2;
        boolean z = true;
        if (j3 <= 0 ? j < j2 : j > j2) {
            z = false;
        }
        this.f12708b = z;
        this.f12709c = z ? j : j2;
    }

    public final long getStep() {
        return this.f12710d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f12708b;
    }

    @Override // d.g0.m0
    public long nextLong() {
        long j = this.f12709c;
        if (j != this.f12707a) {
            this.f12709c = this.f12710d + j;
        } else {
            if (!this.f12708b) {
                throw new NoSuchElementException();
            }
            this.f12708b = false;
        }
        return j;
    }
}
