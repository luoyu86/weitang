package g.a.a.k3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.g;
import g.a.a.h;
import g.a.a.l0;
import g.a.a.t;
import g.a.a.w;
import g.a.a.x1;

/* JADX INFO: loaded from: classes2.dex */
public class d extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f13218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f13219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f13220c;

    public d(d0 d0Var) {
        if (d0Var.size() == 2) {
            this.f13218a = g.a.j.a.clone(w.getInstance(d0Var.getObjectAt(0)).getOctets());
            this.f13220c = g.a.j.a.clone(w.getInstance(d0Var.getObjectAt(1)).getOctets());
            this.f13219b = null;
        } else if (d0Var.size() == 3) {
            this.f13218a = g.a.j.a.clone(w.getInstance(d0Var.getObjectAt(0)).getOctets());
            this.f13219b = g.a.j.a.clone(w.getInstance(l0.getInstance(d0Var.getObjectAt(1)), false).getOctets());
            this.f13220c = g.a.j.a.clone(w.getInstance(d0Var.getObjectAt(2)).getOctets());
        } else {
            throw new IllegalArgumentException("unknown sequence length: " + d0Var.size());
        }
    }

    public d(byte[] bArr, byte[] bArr2) {
        this(bArr, null, bArr2);
    }

    public d(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f13218a = g.a.j.a.clone(bArr);
        this.f13219b = g.a.j.a.clone(bArr2);
        this.f13220c = g.a.j.a.clone(bArr3);
    }

    public static d getInstance(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj != null) {
            return new d(d0.getInstance(obj));
        }
        return null;
    }

    public byte[] getEncryptedKey() {
        return g.a.j.a.clone(this.f13218a);
    }

    public byte[] getMacKey() {
        return g.a.j.a.clone(this.f13220c);
    }

    public byte[] getMaskKey() {
        return g.a.j.a.clone(this.f13219b);
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        h hVar = new h(3);
        hVar.add(new x1(this.f13218a));
        if (this.f13219b != null) {
            hVar.add(new e2(false, 0, (g) new x1(this.f13218a)));
        }
        hVar.add(new x1(this.f13220c));
        return new b2(hVar);
    }
}
