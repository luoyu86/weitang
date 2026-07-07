package d.m0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class l implements Iterable<Long>, d.k0.d.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12703a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f12706d;

    public static final class a {
        public a() {
        }

        public final l fromClosedRange(long j, long j2, long j3) {
            return new l(j, j2, j3);
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public l(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f12704b = j;
        this.f12705c = d.j0.c.getProgressionLastElement(j, j2, j3);
        this.f12706d = j3;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            if (!isEmpty() || !((l) obj).isEmpty()) {
                l lVar = (l) obj;
                if (this.f12704b != lVar.f12704b || this.f12705c != lVar.f12705c || this.f12706d != lVar.f12706d) {
                }
            }
            return true;
        }
        return false;
    }

    public final long getFirst() {
        return this.f12704b;
    }

    public final long getLast() {
        return this.f12705c;
    }

    public final long getStep() {
        return this.f12706d;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j = 31;
        long j2 = this.f12704b;
        long j3 = this.f12705c;
        long j4 = j * (((j2 ^ (j2 >>> 32)) * j) + (j3 ^ (j3 >>> 32)));
        long j5 = this.f12706d;
        return (int) (j4 + (j5 ^ (j5 >>> 32)));
    }

    public boolean isEmpty() {
        long j = this.f12706d;
        long j2 = this.f12704b;
        long j3 = this.f12705c;
        if (j > 0) {
            if (j2 > j3) {
                return true;
            }
        } else if (j2 < j3) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        long j;
        if (this.f12706d > 0) {
            sb = new StringBuilder();
            sb.append(this.f12704b);
            sb.append("..");
            sb.append(this.f12705c);
            sb.append(" step ");
            j = this.f12706d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f12704b);
            sb.append(" downTo ");
            sb.append(this.f12705c);
            sb.append(" step ");
            j = -this.f12706d;
        }
        sb.append(j);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Long> iterator2() {
        return new m(this.f12704b, this.f12705c, this.f12706d);
    }
}
