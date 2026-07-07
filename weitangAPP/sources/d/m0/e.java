package d.m0;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements f<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f12689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f12690b;

    public e(float f2, float f3) {
        this.f12689a = f2;
        this.f12690b = f3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.m0.f, d.m0.g
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return contains(((Number) comparable).floatValue());
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            if (!isEmpty() || !((e) obj).isEmpty()) {
                e eVar = (e) obj;
                if (this.f12689a != eVar.f12689a || this.f12690b != eVar.f12690b) {
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
        return (Float.valueOf(this.f12689a).hashCode() * 31) + Float.valueOf(this.f12690b).hashCode();
    }

    @Override // d.m0.f, d.m0.g
    public boolean isEmpty() {
        return this.f12689a > this.f12690b;
    }

    public boolean lessThanOrEquals(float f2, float f3) {
        return f2 <= f3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d.m0.f
    public /* bridge */ /* synthetic */ boolean lessThanOrEquals(Comparable comparable, Comparable comparable2) {
        return lessThanOrEquals(((Number) comparable).floatValue(), ((Number) comparable2).floatValue());
    }

    public String toString() {
        return this.f12689a + ".." + this.f12690b;
    }

    public boolean contains(float f2) {
        return f2 >= this.f12689a && f2 <= this.f12690b;
    }

    @Override // d.m0.f, d.m0.g
    public Float getEndInclusive() {
        return Float.valueOf(this.f12690b);
    }

    @Override // d.m0.f, d.m0.g
    public Float getStart() {
        return Float.valueOf(this.f12689a);
    }
}
