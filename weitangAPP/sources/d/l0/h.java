package d.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f12671e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12672f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12673g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f12674h;

    public h(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f12669c = i2;
        this.f12670d = i3;
        this.f12671e = i4;
        this.f12672f = i5;
        this.f12673g = i6;
        this.f12674h = i7;
        int i8 = i2 | i3 | i4 | i5 | i6;
        if (!(i8 != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i9 = 0; i9 < 64; i9++) {
            nextInt();
        }
    }

    @Override // d.l0.f
    public int nextBits(int i2) {
        return g.takeUpperBits(nextInt(), i2);
    }

    @Override // d.l0.f
    public int nextInt() {
        int i2 = this.f12669c;
        int i3 = i2 ^ (i2 >>> 2);
        this.f12669c = this.f12670d;
        this.f12670d = this.f12671e;
        this.f12671e = this.f12672f;
        int i4 = this.f12673g;
        this.f12672f = i4;
        int i5 = ((i3 ^ (i3 << 1)) ^ i4) ^ (i4 << 4);
        this.f12673g = i5;
        int i6 = this.f12674h + 362437;
        this.f12674h = i6;
        return i5 + i6;
    }

    public h(int i2, int i3) {
        this(i2, i3, 0, 0, ~i2, (i2 << 10) ^ (i3 >>> 4));
    }
}
