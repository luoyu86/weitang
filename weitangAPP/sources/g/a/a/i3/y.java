package g.a.a.i3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class y extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g.a.a.y3.a f13177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BigInteger f13178b;

    public y(d0 d0Var) {
        if (d0Var.size() != 2) {
            throw new IllegalArgumentException("ASN.1 SEQUENCE should be of length 2");
        }
        this.f13177a = g.a.a.y3.a.getInstance(d0Var.getObjectAt(0));
        this.f13178b = g.a.a.q.getInstance(d0Var.getObjectAt(1)).getValue();
    }

    public y(g.a.a.y3.a aVar, int i2) {
        this.f13177a = aVar;
        this.f13178b = BigInteger.valueOf(i2);
    }

    public static y getInstance(Object obj) {
        if (obj instanceof y) {
            return (y) obj;
        }
        if (obj != null) {
            return new y(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.y3.a getKeyDerivationFunction() {
        return this.f13177a;
    }

    public BigInteger getKeyLength() {
        return this.f13178b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(2);
        hVar.add(this.f13177a);
        hVar.add(new g.a.a.q(this.f13178b));
        return new b2(hVar);
    }
}
