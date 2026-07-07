package d.m0;

import d.k0.d.t;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends d.m0.a implements g<Character> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f12686f = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f12685e = new c((char) 1, (char) 0);

    public static final class a {
        public a() {
        }

        public final c getEMPTY() {
            return c.f12685e;
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public c(char c2, char c3) {
        super(c2, c3, 1);
    }

    @Override // d.m0.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Character) comparable).charValue());
    }

    @Override // d.m0.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (getFirst() != cVar.getFirst() || getLast() != cVar.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // d.m0.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // d.m0.a, d.m0.g
    public boolean isEmpty() {
        return t.compare((int) getFirst(), (int) getLast()) > 0;
    }

    @Override // d.m0.a
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    public boolean contains(char c2) {
        return t.compare((int) getFirst(), (int) c2) <= 0 && t.compare((int) c2, (int) getLast()) <= 0;
    }

    @Override // d.m0.g
    public Character getEndInclusive() {
        return Character.valueOf(getLast());
    }

    @Override // d.m0.g
    public Character getStart() {
        return Character.valueOf(getFirst());
    }
}
