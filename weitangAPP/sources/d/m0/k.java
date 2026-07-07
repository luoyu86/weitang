package d.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends i implements g<Integer> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f12702f = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final k f12701e = new k(1, 0);

    public static final class a {
        public a() {
        }

        public final k getEMPTY() {
            return k.f12701e;
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public k(int i2, int i3) {
        super(i2, i3, 1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.m0.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).intValue());
    }

    @Override // d.m0.i
    public boolean equals(Object obj) {
        if (obj instanceof k) {
            if (!isEmpty() || !((k) obj).isEmpty()) {
                k kVar = (k) obj;
                if (getFirst() != kVar.getFirst() || getLast() != kVar.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // d.m0.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // d.m0.i, d.m0.g
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // d.m0.i
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    public boolean contains(int i2) {
        return getFirst() <= i2 && i2 <= getLast();
    }

    @Override // d.m0.g
    public Integer getEndInclusive() {
        return Integer.valueOf(getLast());
    }

    @Override // d.m0.g
    public Integer getStart() {
        return Integer.valueOf(getFirst());
    }
}
