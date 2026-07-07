package g.a.a.z3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.n1;
import g.a.a.q;
import g.a.a.t;
import g.a.a.v;
import g.a.a.w;
import g.a.g.a.e;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class d extends t implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.g.a.e f13574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f13575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v f13576c;

    public d(i iVar, BigInteger bigInteger, BigInteger bigInteger2, d0 d0Var) {
        int iIntValueExact;
        int iIntValueExact2;
        int i2;
        g.a.g.a.e c0261e;
        this.f13576c = null;
        v identifier = iVar.getIdentifier();
        this.f13576c = identifier;
        if (identifier.equals((a0) k.W3)) {
            c0261e = new e.f(((q) iVar.getParameters()).getValue(), new BigInteger(1, w.getInstance(d0Var.getObjectAt(0)).getOctets()), new BigInteger(1, w.getInstance(d0Var.getObjectAt(1)).getOctets()), bigInteger, bigInteger2);
        } else {
            if (!this.f13576c.equals((a0) k.X3)) {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            d0 d0Var2 = d0.getInstance(iVar.getParameters());
            int iIntValueExact3 = ((q) d0Var2.getObjectAt(0)).intValueExact();
            v vVar = (v) d0Var2.getObjectAt(1);
            if (vVar.equals((a0) k.Z3)) {
                iIntValueExact2 = q.getInstance(d0Var2.getObjectAt(2)).intValueExact();
                i2 = 0;
                iIntValueExact = 0;
            } else {
                if (!vVar.equals((a0) k.a4)) {
                    throw new IllegalArgumentException("This type of EC basis is not implemented");
                }
                d0 d0Var3 = d0.getInstance(d0Var2.getObjectAt(2));
                int iIntValueExact4 = q.getInstance(d0Var3.getObjectAt(0)).intValueExact();
                int iIntValueExact5 = q.getInstance(d0Var3.getObjectAt(1)).intValueExact();
                iIntValueExact = q.getInstance(d0Var3.getObjectAt(2)).intValueExact();
                iIntValueExact2 = iIntValueExact4;
                i2 = iIntValueExact5;
            }
            c0261e = new e.C0261e(iIntValueExact3, iIntValueExact2, i2, iIntValueExact, new BigInteger(1, w.getInstance(d0Var.getObjectAt(0)).getOctets()), new BigInteger(1, w.getInstance(d0Var.getObjectAt(1)).getOctets()), bigInteger, bigInteger2);
        }
        this.f13574a = c0261e;
        if (d0Var.size() == 3) {
            this.f13575b = ((n1) d0Var.getObjectAt(2)).getBytes();
        }
    }

    public d(g.a.g.a.e eVar) {
        this(eVar, null);
    }

    public d(g.a.g.a.e eVar, byte[] bArr) {
        this.f13576c = null;
        this.f13574a = eVar;
        this.f13575b = g.a.j.a.clone(bArr);
        a();
    }

    public final void a() {
        v vVar;
        if (g.a.g.a.c.isFpCurve(this.f13574a)) {
            vVar = k.W3;
        } else {
            if (!g.a.g.a.c.isF2mCurve(this.f13574a)) {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            vVar = k.X3;
        }
        this.f13576c = vVar;
    }

    public g.a.g.a.e getCurve() {
        return this.f13574a;
    }

    public byte[] getSeed() {
        return g.a.j.a.clone(this.f13575b);
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(3);
        if (this.f13576c.equals((a0) k.W3) || this.f13576c.equals((a0) k.X3)) {
            hVar.add(new h(this.f13574a.getA()).toASN1Primitive());
            h hVar2 = new h(this.f13574a.getB());
            hVar.add(hVar2.toASN1Primitive());
        }
        if (this.f13575b != null) {
            hVar.add(new n1(this.f13575b));
        }
        return new b2(hVar);
    }
}
