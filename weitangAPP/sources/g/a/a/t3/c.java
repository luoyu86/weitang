package g.a.a.t3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.g;
import g.a.a.h;
import g.a.a.q;
import g.a.a.t;
import g.a.a.w;
import g.a.a.x1;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class c extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f13336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w f13337b;

    public c(int i2, byte[] bArr) {
        this.f13336a = new q(i2);
        this.f13337b = new x1(bArr);
    }

    public c(d0 d0Var) {
        g objectAt;
        if (d0Var.size() == 1) {
            this.f13336a = null;
            objectAt = d0Var.getObjectAt(0);
        } else {
            this.f13336a = (q) d0Var.getObjectAt(0);
            objectAt = d0Var.getObjectAt(1);
        }
        this.f13337b = (w) objectAt;
    }

    public c(byte[] bArr) {
        this.f13336a = null;
        this.f13337b = new x1(bArr);
    }

    public static c getInstance(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(d0.getInstance(obj));
        }
        return null;
    }

    public byte[] getIV() {
        return this.f13337b.getOctets();
    }

    public BigInteger getRC2ParameterVersion() {
        q qVar = this.f13336a;
        if (qVar == null) {
            return null;
        }
        return qVar.getValue();
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        h hVar = new h(2);
        q qVar = this.f13336a;
        if (qVar != null) {
            hVar.add(qVar);
        }
        hVar.add(this.f13337b);
        return new b2(hVar);
    }
}
