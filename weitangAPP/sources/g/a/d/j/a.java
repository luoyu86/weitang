package g.a.d.j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements g.a.d.e, g.a.j.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f13731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f13732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f13733c;

    public a() {
        this.f13731a = new byte[4];
        this.f13732b = 0;
    }

    public a(a aVar) {
        this.f13731a = new byte[4];
        a(aVar);
    }

    public a(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        this.f13731a = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.f13732b = g.a.j.k.bigEndianToInt(bArr, 4);
        this.f13733c = g.a.j.k.bigEndianToLong(bArr, 8);
    }

    public void a(a aVar) {
        byte[] bArr = aVar.f13731a;
        System.arraycopy(bArr, 0, this.f13731a, 0, bArr.length);
        this.f13732b = aVar.f13732b;
        this.f13733c = aVar.f13733c;
    }

    public void b(byte[] bArr) {
        System.arraycopy(this.f13731a, 0, bArr, 0, this.f13732b);
        g.a.j.k.intToBigEndian(this.f13732b, bArr, 4);
        g.a.j.k.longToBigEndian(this.f13733c, bArr, 8);
    }

    public abstract void c();

    @Override // g.a.j.h
    public abstract /* synthetic */ g.a.j.h copy();

    public abstract void d(long j);

    @Override // g.a.d.e
    public abstract /* synthetic */ int doFinal(byte[] bArr, int i2);

    public abstract void e(byte[] bArr, int i2);

    public void finish() {
        long j = this.f13733c << 3;
        byte b2 = -128;
        while (true) {
            update(b2);
            if (this.f13732b == 0) {
                d(j);
                c();
                return;
            }
            b2 = 0;
        }
    }

    @Override // g.a.d.e
    public abstract /* synthetic */ String getAlgorithmName();

    public int getByteLength() {
        return 64;
    }

    @Override // g.a.d.e
    public abstract /* synthetic */ int getDigestSize();

    @Override // g.a.d.e
    public void reset() {
        this.f13733c = 0L;
        this.f13732b = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f13731a;
            if (i2 >= bArr.length) {
                return;
            }
            bArr[i2] = 0;
            i2++;
        }
    }

    @Override // g.a.j.h
    public abstract /* synthetic */ void reset(g.a.j.h hVar);

    @Override // g.a.d.e
    public void update(byte b2) {
        byte[] bArr = this.f13731a;
        int i2 = this.f13732b;
        int i3 = i2 + 1;
        this.f13732b = i3;
        bArr[i2] = b2;
        if (i3 == bArr.length) {
            e(bArr, 0);
            this.f13732b = 0;
        }
        this.f13733c++;
    }

    @Override // g.a.d.e
    public void update(byte[] bArr, int i2, int i3) {
        int i4 = 0;
        int iMax = Math.max(0, i3);
        if (this.f13732b != 0) {
            int i5 = 0;
            while (true) {
                if (i5 >= iMax) {
                    i4 = i5;
                    break;
                }
                byte[] bArr2 = this.f13731a;
                int i6 = this.f13732b;
                int i7 = i6 + 1;
                this.f13732b = i7;
                int i8 = i5 + 1;
                bArr2[i6] = bArr[i5 + i2];
                if (i7 == 4) {
                    e(bArr2, 0);
                    this.f13732b = 0;
                    i4 = i8;
                    break;
                }
                i5 = i8;
            }
        }
        int i9 = ((iMax - i4) & (-4)) + i4;
        while (i4 < i9) {
            e(bArr, i2 + i4);
            i4 += 4;
        }
        while (i4 < iMax) {
            byte[] bArr3 = this.f13731a;
            int i10 = this.f13732b;
            this.f13732b = i10 + 1;
            bArr3[i10] = bArr[i4 + i2];
            i4++;
        }
        this.f13733c += (long) iMax;
    }
}
