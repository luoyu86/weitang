package d;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements Comparable<e> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12424c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12425d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12426e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f12427f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12423b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12422a = f.get();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public e(int i2, int i3, int i4) {
        this.f12425d = i2;
        this.f12426e = i3;
        this.f12427f = i4;
        this.f12424c = a(i2, i3, i4);
    }

    public final int a(int i2, int i3, int i4) {
        if (i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3 && i4 >= 0 && 255 >= i4) {
            return (i2 << 16) + (i3 << 8) + i4;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i2 + '.' + i3 + '.' + i4).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            obj = null;
        }
        e eVar = (e) obj;
        return eVar != null && this.f12424c == eVar.f12424c;
    }

    public final int getMajor() {
        return this.f12425d;
    }

    public final int getMinor() {
        return this.f12426e;
    }

    public final int getPatch() {
        return this.f12427f;
    }

    public int hashCode() {
        return this.f12424c;
    }

    public final boolean isAtLeast(int i2, int i3) {
        int i4 = this.f12425d;
        return i4 > i2 || (i4 == i2 && this.f12426e >= i3);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f12425d);
        sb.append('.');
        sb.append(this.f12426e);
        sb.append('.');
        sb.append(this.f12427f);
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(e eVar) {
        d.k0.d.t.checkNotNullParameter(eVar, "other");
        return this.f12424c - eVar.f12424c;
    }

    public final boolean isAtLeast(int i2, int i3, int i4) {
        int i5;
        int i6 = this.f12425d;
        return i6 > i2 || (i6 == i2 && ((i5 = this.f12426e) > i3 || (i5 == i3 && this.f12427f >= i4)));
    }

    public e(int i2, int i3) {
        this(i2, i3, 0);
    }
}
