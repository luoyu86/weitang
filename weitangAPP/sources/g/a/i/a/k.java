package g.a.i.a;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.l0;
import g.a.a.q;
import g.a.a.t;
import g.a.a.w;
import g.a.a.x1;

/* JADX INFO: loaded from: classes3.dex */
public class k extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f14272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f14273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f14274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final byte[] f14275g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f14276h;

    public k(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f14269a = 0;
        this.f14270b = j;
        this.f14272d = g.a.j.a.clone(bArr);
        this.f14273e = g.a.j.a.clone(bArr2);
        this.f14274f = g.a.j.a.clone(bArr3);
        this.f14275g = g.a.j.a.clone(bArr4);
        this.f14276h = g.a.j.a.clone(bArr5);
        this.f14271c = -1L;
    }

    public k(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, long j2) {
        this.f14269a = 1;
        this.f14270b = j;
        this.f14272d = g.a.j.a.clone(bArr);
        this.f14273e = g.a.j.a.clone(bArr2);
        this.f14274f = g.a.j.a.clone(bArr3);
        this.f14275g = g.a.j.a.clone(bArr4);
        this.f14276h = g.a.j.a.clone(bArr5);
        this.f14271c = j2;
    }

    public k(d0 d0Var) {
        long jLongValueExact;
        q qVar = q.getInstance(d0Var.getObjectAt(0));
        if (!qVar.hasValue(0) && !qVar.hasValue(1)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f14269a = qVar.intValueExact();
        if (d0Var.size() != 2 && d0Var.size() != 3) {
            throw new IllegalArgumentException("key sequence wrong size");
        }
        d0 d0Var2 = d0.getInstance(d0Var.getObjectAt(1));
        this.f14270b = q.getInstance(d0Var2.getObjectAt(0)).longValueExact();
        this.f14272d = g.a.j.a.clone(w.getInstance(d0Var2.getObjectAt(1)).getOctets());
        this.f14273e = g.a.j.a.clone(w.getInstance(d0Var2.getObjectAt(2)).getOctets());
        this.f14274f = g.a.j.a.clone(w.getInstance(d0Var2.getObjectAt(3)).getOctets());
        this.f14275g = g.a.j.a.clone(w.getInstance(d0Var2.getObjectAt(4)).getOctets());
        if (d0Var2.size() == 6) {
            l0 l0Var = l0.getInstance(d0Var2.getObjectAt(5));
            if (l0Var.getTagNo() != 0) {
                throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
            }
            jLongValueExact = q.getInstance(l0Var, false).longValueExact();
        } else {
            if (d0Var2.size() != 5) {
                throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
            }
            jLongValueExact = -1;
        }
        this.f14271c = jLongValueExact;
        if (d0Var.size() == 3) {
            this.f14276h = g.a.j.a.clone(w.getInstance(l0.getInstance(d0Var.getObjectAt(2)), true).getOctets());
        } else {
            this.f14276h = null;
        }
    }

    public static k getInstance(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(d0.getInstance(obj));
        }
        return null;
    }

    public byte[] getBdsState() {
        return g.a.j.a.clone(this.f14276h);
    }

    public long getIndex() {
        return this.f14270b;
    }

    public long getMaxIndex() {
        return this.f14271c;
    }

    public byte[] getPublicSeed() {
        return g.a.j.a.clone(this.f14274f);
    }

    public byte[] getRoot() {
        return g.a.j.a.clone(this.f14275g);
    }

    public byte[] getSecretKeyPRF() {
        return g.a.j.a.clone(this.f14273e);
    }

    public byte[] getSecretKeySeed() {
        return g.a.j.a.clone(this.f14272d);
    }

    public int getVersion() {
        return this.f14269a;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h();
        hVar.add(this.f14271c >= 0 ? new q(1L) : new q(0L));
        g.a.a.h hVar2 = new g.a.a.h();
        hVar2.add(new q(this.f14270b));
        hVar2.add(new x1(this.f14272d));
        hVar2.add(new x1(this.f14273e));
        hVar2.add(new x1(this.f14274f));
        hVar2.add(new x1(this.f14275g));
        if (this.f14271c >= 0) {
            hVar2.add(new e2(false, 0, (g.a.a.g) new q(this.f14271c)));
        }
        hVar.add(new b2(hVar2));
        hVar.add(new e2(true, 0, (g.a.a.g) new x1(this.f14276h)));
        return new b2(hVar);
    }
}
