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
public class m extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f14281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f14282d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f14283e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final byte[] f14284f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f14285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f14286h;

    public m(int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this.f14279a = 0;
        this.f14280b = i2;
        this.f14281c = g.a.j.a.clone(bArr);
        this.f14282d = g.a.j.a.clone(bArr2);
        this.f14283e = g.a.j.a.clone(bArr3);
        this.f14284f = g.a.j.a.clone(bArr4);
        this.f14286h = g.a.j.a.clone(bArr5);
        this.f14285g = -1;
    }

    public m(int i2, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, int i3) {
        this.f14279a = 1;
        this.f14280b = i2;
        this.f14281c = g.a.j.a.clone(bArr);
        this.f14282d = g.a.j.a.clone(bArr2);
        this.f14283e = g.a.j.a.clone(bArr3);
        this.f14284f = g.a.j.a.clone(bArr4);
        this.f14286h = g.a.j.a.clone(bArr5);
        this.f14285g = i3;
    }

    public m(d0 d0Var) {
        int iIntValueExact;
        q qVar = q.getInstance(d0Var.getObjectAt(0));
        if (!qVar.hasValue(0) && !qVar.hasValue(1)) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f14279a = qVar.intValueExact();
        if (d0Var.size() != 2 && d0Var.size() != 3) {
            throw new IllegalArgumentException("key sequence wrong size");
        }
        d0 d0Var2 = d0.getInstance(d0Var.getObjectAt(1));
        this.f14280b = q.getInstance(d0Var2.getObjectAt(0)).intValueExact();
        this.f14281c = g.a.j.a.clone(w.getInstance(d0Var2.getObjectAt(1)).getOctets());
        this.f14282d = g.a.j.a.clone(w.getInstance(d0Var2.getObjectAt(2)).getOctets());
        this.f14283e = g.a.j.a.clone(w.getInstance(d0Var2.getObjectAt(3)).getOctets());
        this.f14284f = g.a.j.a.clone(w.getInstance(d0Var2.getObjectAt(4)).getOctets());
        if (d0Var2.size() == 6) {
            l0 l0Var = l0.getInstance(d0Var2.getObjectAt(5));
            if (l0Var.getTagNo() != 0) {
                throw new IllegalArgumentException("unknown tag in XMSSPrivateKey");
            }
            iIntValueExact = q.getInstance(l0Var, false).intValueExact();
        } else {
            if (d0Var2.size() != 5) {
                throw new IllegalArgumentException("keySeq should be 5 or 6 in length");
            }
            iIntValueExact = -1;
        }
        this.f14285g = iIntValueExact;
        if (d0Var.size() == 3) {
            this.f14286h = g.a.j.a.clone(w.getInstance(l0.getInstance(d0Var.getObjectAt(2)), true).getOctets());
        } else {
            this.f14286h = null;
        }
    }

    public static m getInstance(Object obj) {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj != null) {
            return new m(d0.getInstance(obj));
        }
        return null;
    }

    public byte[] getBdsState() {
        return g.a.j.a.clone(this.f14286h);
    }

    public int getIndex() {
        return this.f14280b;
    }

    public int getMaxIndex() {
        return this.f14285g;
    }

    public byte[] getPublicSeed() {
        return g.a.j.a.clone(this.f14283e);
    }

    public byte[] getRoot() {
        return g.a.j.a.clone(this.f14284f);
    }

    public byte[] getSecretKeyPRF() {
        return g.a.j.a.clone(this.f14282d);
    }

    public byte[] getSecretKeySeed() {
        return g.a.j.a.clone(this.f14281c);
    }

    public int getVersion() {
        return this.f14279a;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h();
        hVar.add(this.f14285g >= 0 ? new q(1L) : new q(0L));
        g.a.a.h hVar2 = new g.a.a.h();
        hVar2.add(new q(this.f14280b));
        hVar2.add(new x1(this.f14281c));
        hVar2.add(new x1(this.f14282d));
        hVar2.add(new x1(this.f14283e));
        hVar2.add(new x1(this.f14284f));
        if (this.f14285g >= 0) {
            hVar2.add(new e2(false, 0, (g.a.a.g) new q(this.f14285g)));
        }
        hVar.add(new b2(hVar2));
        hVar.add(new e2(true, 0, (g.a.a.g) new x1(this.f14286h)));
        return new b2(hVar);
    }
}
