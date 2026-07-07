package d.m0;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class i implements Iterable<Integer>, d.k0.d.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12693a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12696d;

    public static final class a {
        public a() {
        }

        public final i fromClosedRange(int i2, int i3, int i4) {
            return new i(i2, i3, i4);
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public i(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f12694b = i2;
        this.f12695c = d.j0.c.getProgressionLastElement(i2, i3, i4);
        this.f12696d = i4;
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            if (!isEmpty() || !((i) obj).isEmpty()) {
                i iVar = (i) obj;
                if (this.f12694b != iVar.f12694b || this.f12695c != iVar.f12695c || this.f12696d != iVar.f12696d) {
                }
            }
            return true;
        }
        return false;
    }

    public final int getFirst() {
        return this.f12694b;
    }

    public final int getLast() {
        return this.f12695c;
    }

    public final int getStep() {
        return this.f12696d;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f12694b * 31) + this.f12695c) * 31) + this.f12696d;
    }

    public boolean isEmpty() {
        if (this.f12696d > 0) {
            if (this.f12694b > this.f12695c) {
                return true;
            }
        } else if (this.f12694b < this.f12695c) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f12696d > 0) {
            sb = new StringBuilder();
            sb.append(this.f12694b);
            sb.append("..");
            sb.append(this.f12695c);
            sb.append(" step ");
            i2 = this.f12696d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f12694b);
            sb.append(" downTo ");
            sb.append(this.f12695c);
            sb.append(" step ");
            i2 = -this.f12696d;
        }
        sb.append(i2);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Integer> iterator2() {
        return new j(this.f12694b, this.f12695c, this.f12696d);
    }
}
