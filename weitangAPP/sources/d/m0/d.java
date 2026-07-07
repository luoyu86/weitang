package d.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements f<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f12687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f12688b;

    public d(double d2, double d3) {
        this.f12687a = d2;
        this.f12688b = d3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.m0.f, d.m0.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).doubleValue());
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (this.f12687a != dVar.f12687a || this.f12688b != dVar.f12688b) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (Double.valueOf(this.f12687a).hashCode() * 31) + Double.valueOf(this.f12688b).hashCode();
    }

    @Override // d.m0.f, d.m0.g
    public boolean isEmpty() {
        return this.f12687a > this.f12688b;
    }

    public boolean lessThanOrEquals(double d2, double d3) {
        return d2 <= d3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.m0.f
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Comparable comparable, Comparable comparable2) {
        return lessThanOrEquals(((Number) comparable).doubleValue(), ((Number) comparable2).doubleValue());
    }

    public String toString() {
        return this.f12687a + ".." + this.f12688b;
    }

    public boolean contains(double d2) {
        return d2 >= this.f12687a && d2 <= this.f12688b;
    }

    @Override // d.m0.f, d.m0.g
    public Double getEndInclusive() {
        return Double.valueOf(this.f12688b);
    }

    @Override // d.m0.f, d.m0.g
    public Double getStart() {
        return Double.valueOf(this.f12687a);
    }
}
