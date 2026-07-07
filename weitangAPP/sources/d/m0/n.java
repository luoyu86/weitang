package d.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends l implements g<Long> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f12712f = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final n f12711e = new n(1, 0);

    public static final class a {
        public a() {
        }

        public final n getEMPTY() {
            return n.f12711e;
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public n(long j, long j2) {
        super(j, j2, 1L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.m0.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).longValue());
    }

    @Override // d.m0.l
    public boolean equals(Object obj) {
        if (obj instanceof n) {
            if (!isEmpty() || !((n) obj).isEmpty()) {
                n nVar = (n) obj;
                if (getFirst() != nVar.getFirst() || getLast() != nVar.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // d.m0.l
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((((long) 31) * (getFirst() ^ (getFirst() >>> 32))) + (getLast() ^ (getLast() >>> 32)));
    }

    @Override // d.m0.l, d.m0.g
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // d.m0.l
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    public boolean contains(long j) {
        return getFirst() <= j && j <= getLast();
    }

    @Override // d.m0.g
    public Long getEndInclusive() {
        return Long.valueOf(getLast());
    }

    @Override // d.m0.g
    public Long getStart() {
        return Long.valueOf(getFirst());
    }
}
