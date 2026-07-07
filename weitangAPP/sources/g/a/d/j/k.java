package g.a.d.j;

import javax.mail.UIDFolder;

/* JADX INFO: loaded from: classes2.dex */
public class k extends c {
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f13774q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public long w;
    public long x;

    public k(int i2) {
        if (i2 >= 512) {
            throw new IllegalArgumentException("bitLength cannot be >= 512");
        }
        if (i2 % 8 != 0) {
            throw new IllegalArgumentException("bitLength needs to be a multiple of 8");
        }
        if (i2 == 384) {
            throw new IllegalArgumentException("bitLength cannot be 384 use SHA384 instead");
        }
        int i3 = i2 / 8;
        this.p = i3;
        r(i3 * 8);
        reset();
    }

    public k(k kVar) {
        super(kVar);
        this.p = kVar.p;
        reset(kVar);
    }

    public k(byte[] bArr) {
        this(q(bArr));
        n(bArr);
    }

    public static void o(int i2, byte[] bArr, int i3, int i4) {
        int iMin = Math.min(4, i4);
        while (true) {
            iMin--;
            if (iMin < 0) {
                return;
            } else {
                bArr[i3 + iMin] = (byte) (i2 >>> ((3 - iMin) * 8));
            }
        }
    }

    public static void p(long j, byte[] bArr, int i2, int i3) {
        if (i3 > 0) {
            o((int) (j >>> 32), bArr, i2, i3);
            if (i3 > 4) {
                o((int) (j & UIDFolder.MAXUID), bArr, i2 + 4, i3 - 4);
            }
        }
    }

    public static int q(byte[] bArr) {
        return g.a.j.k.bigEndianToInt(bArr, bArr.length - 4);
    }

    @Override // g.a.d.j.c, g.a.j.h
    public g.a.j.h copy() {
        return new k(this);
    }

    @Override // g.a.d.j.c, g.a.d.e
    public int doFinal(byte[] bArr, int i2) {
        finish();
        p(this.f13746f, bArr, i2, this.p);
        p(this.f13747g, bArr, i2 + 8, this.p - 8);
        p(this.f13748h, bArr, i2 + 16, this.p - 16);
        p(this.f13749i, bArr, i2 + 24, this.p - 24);
        p(this.j, bArr, i2 + 32, this.p - 32);
        p(this.k, bArr, i2 + 40, this.p - 40);
        p(this.l, bArr, i2 + 48, this.p - 48);
        p(this.m, bArr, i2 + 56, this.p - 56);
        reset();
        return this.p;
    }

    @Override // g.a.d.j.c, g.a.d.e
    public String getAlgorithmName() {
        return "SHA-512/" + Integer.toString(this.p * 8);
    }

    @Override // g.a.d.j.c, g.a.d.e
    public int getDigestSize() {
        return this.p;
    }

    @Override // g.a.d.j.c
    public byte[] getEncodedState() {
        int i2 = i();
        byte[] bArr = new byte[i2 + 4];
        j(bArr);
        g.a.j.k.intToBigEndian(this.p * 8, bArr, i2);
        return bArr;
    }

    public final void r(int i2) {
        this.f13746f = -3482333909917012819L;
        this.f13747g = 2216346199247487646L;
        this.f13748h = -7364697282686394994L;
        this.f13749i = 65953792586715988L;
        this.j = -816286391624063116L;
        this.k = 4512832404995164602L;
        this.l = -5033199132376557362L;
        this.m = -124578254951840548L;
        update((byte) 83);
        update((byte) 72);
        update((byte) 65);
        update((byte) 45);
        update((byte) 53);
        update((byte) 49);
        update((byte) 50);
        update((byte) 47);
        if (i2 <= 100) {
            if (i2 > 10) {
            }
            update((byte) (i2 + 48));
            finish();
            this.f13774q = this.f13746f;
            this.r = this.f13747g;
            this.s = this.f13748h;
            this.t = this.f13749i;
            this.u = this.j;
            this.v = this.k;
            this.w = this.l;
            this.x = this.m;
        }
        update((byte) ((i2 / 100) + 48));
        i2 %= 100;
        update((byte) ((i2 / 10) + 48));
        i2 %= 10;
        update((byte) (i2 + 48));
        finish();
        this.f13774q = this.f13746f;
        this.r = this.f13747g;
        this.s = this.f13748h;
        this.t = this.f13749i;
        this.u = this.j;
        this.v = this.k;
        this.w = this.l;
        this.x = this.m;
    }

    @Override // g.a.d.j.c, g.a.d.e
    public void reset() {
        super.reset();
        this.f13746f = this.f13774q;
        this.f13747g = this.r;
        this.f13748h = this.s;
        this.f13749i = this.t;
        this.j = this.u;
        this.k = this.v;
        this.l = this.w;
        this.m = this.x;
    }

    @Override // g.a.d.j.c, g.a.j.h
    public void reset(g.a.j.h hVar) {
        k kVar = (k) hVar;
        if (this.p != kVar.p) {
            throw new g.a.j.i("digestLength inappropriate in other");
        }
        super.h(kVar);
        this.f13774q = kVar.f13774q;
        this.r = kVar.r;
        this.s = kVar.s;
        this.t = kVar.t;
        this.u = kVar.u;
        this.v = kVar.v;
        this.w = kVar.w;
        this.x = kVar.x;
    }
}
