package d.m0;

import d.k0.d.t;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Iterable<Character>, d.k0.d.n0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0240a f12677a = new C0240a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char f12678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final char f12679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12680d;

    /* JADX INFO: renamed from: d.m0.a$a, reason: collision with other inner class name */
    public static final class C0240a {
        public C0240a() {
        }

        public final a fromClosedRange(char c2, char c3, int i2) {
            return new a(c2, c3, i2);
        }

        public /* synthetic */ C0240a(d.k0.d.p pVar) {
            this();
        }
    }

    public a(char c2, char c3, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i2 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f12678b = c2;
        this.f12679c = (char) d.j0.c.getProgressionLastElement((int) c2, (int) c3, i2);
        this.f12680d = i2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f12678b != aVar.f12678b || this.f12679c != aVar.f12679c || this.f12680d != aVar.f12680d) {
                }
            }
            return true;
        }
        return false;
    }

    public final char getFirst() {
        return this.f12678b;
    }

    public final char getLast() {
        return this.f12679c;
    }

    public final int getStep() {
        return this.f12680d;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f12678b * 31) + this.f12679c) * 31) + this.f12680d;
    }

    public boolean isEmpty() {
        if (this.f12680d > 0) {
            if (t.compare((int) this.f12678b, (int) this.f12679c) > 0) {
                return true;
            }
        } else if (t.compare((int) this.f12678b, (int) this.f12679c) < 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f12680d > 0) {
            sb = new StringBuilder();
            sb.append(this.f12678b);
            sb.append("..");
            sb.append(this.f12679c);
            sb.append(" step ");
            i2 = this.f12680d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f12678b);
            sb.append(" downTo ");
            sb.append(this.f12679c);
            sb.append(" step ");
            i2 = -this.f12680d;
        }
        sb.append(i2);
        return sb.toString();
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Character> iterator2() {
        return new b(this.f12678b, this.f12679c, this.f12680d);
    }
}
