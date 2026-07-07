package g.a.i.b.i;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14498d;

    public static abstract class a<T extends a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14499a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f14500b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f14501c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f14502d = 0;

        public a(int i2) {
            this.f14499a = i2;
        }

        public abstract T e();

        public T f(int i2) {
            this.f14502d = i2;
            return (T) e();
        }

        public T g(int i2) {
            this.f14500b = i2;
            return (T) e();
        }

        public T h(long j) {
            this.f14501c = j;
            return (T) e();
        }
    }

    public o(a aVar) {
        this.f14495a = aVar.f14500b;
        this.f14496b = aVar.f14501c;
        this.f14497c = aVar.f14499a;
        this.f14498d = aVar.f14502d;
    }

    public final int a() {
        return this.f14495a;
    }

    public final long b() {
        return this.f14496b;
    }

    public byte[] c() {
        byte[] bArr = new byte[32];
        g.a.j.k.intToBigEndian(this.f14495a, bArr, 0);
        g.a.j.k.longToBigEndian(this.f14496b, bArr, 4);
        g.a.j.k.intToBigEndian(this.f14497c, bArr, 12);
        g.a.j.k.intToBigEndian(this.f14498d, bArr, 28);
        return bArr;
    }

    public final int getKeyAndMask() {
        return this.f14498d;
    }

    public final int getType() {
        return this.f14497c;
    }
}
