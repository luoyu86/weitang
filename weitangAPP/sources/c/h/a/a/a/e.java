package c.h.a.a.a;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f2542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f2543b;

    public e(f fVar) {
        this.f2542a = Integer.valueOf(Math.round(fVar.f2544a));
        this.f2543b = Integer.valueOf(Math.round(fVar.f2545b));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e.class != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f2542a.equals(eVar.f2542a)) {
            return this.f2543b.equals(eVar.f2543b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f2542a.hashCode() * 31) + this.f2543b.hashCode();
    }

    public String toAbsoluteCoordinates() {
        return this.f2542a + "," + this.f2543b;
    }

    public String toRelativeCoordinates(e eVar) {
        return new e(this.f2542a.intValue() - eVar.f2542a.intValue(), this.f2543b.intValue() - eVar.f2543b.intValue()).toString();
    }

    public String toString() {
        return toAbsoluteCoordinates();
    }

    public e(int i2, int i3) {
        this.f2542a = Integer.valueOf(i2);
        this.f2543b = Integer.valueOf(i3);
    }
}
