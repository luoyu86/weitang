package g.a.a.t3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.g;
import g.a.a.h;
import g.a.a.l0;
import g.a.a.q;
import g.a.a.t;
import g.a.a.v1;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class d extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g.a.a.y3.a f13338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g.a.a.y3.a f13339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f13340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q f13341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g.a.a.y3.a f13342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g.a.a.y3.a f13343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public q f13344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q f13345h;

    static {
        g.a.a.y3.a aVar = new g.a.a.y3.a(g.a.a.s3.a.f13329i, v1.f13368b);
        f13338a = aVar;
        f13339b = new g.a.a.y3.a(a.z0, aVar);
        f13340c = new q(20L);
        f13341d = new q(1L);
    }

    public d() {
        this.f13342e = f13338a;
        this.f13343f = f13339b;
        this.f13344g = f13340c;
        this.f13345h = f13341d;
    }

    public d(d0 d0Var) {
        this.f13342e = f13338a;
        this.f13343f = f13339b;
        this.f13344g = f13340c;
        this.f13345h = f13341d;
        for (int i2 = 0; i2 != d0Var.size(); i2++) {
            l0 l0Var = (l0) d0Var.getObjectAt(i2);
            int tagNo = l0Var.getTagNo();
            if (tagNo == 0) {
                this.f13342e = g.a.a.y3.a.getInstance(l0Var, true);
            } else if (tagNo == 1) {
                this.f13343f = g.a.a.y3.a.getInstance(l0Var, true);
            } else if (tagNo == 2) {
                this.f13344g = q.getInstance(l0Var, true);
            } else {
                if (tagNo != 3) {
                    throw new IllegalArgumentException("unknown tag");
                }
                this.f13345h = q.getInstance(l0Var, true);
            }
        }
    }

    public d(g.a.a.y3.a aVar, g.a.a.y3.a aVar2, q qVar, q qVar2) {
        this.f13342e = aVar;
        this.f13343f = aVar2;
        this.f13344g = qVar;
        this.f13345h = qVar2;
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

    public g.a.a.y3.a getHashAlgorithm() {
        return this.f13342e;
    }

    public g.a.a.y3.a getMaskGenAlgorithm() {
        return this.f13343f;
    }

    public BigInteger getSaltLength() {
        return this.f13344g.getValue();
    }

    public BigInteger getTrailerField() {
        return this.f13345h.getValue();
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        h hVar = new h(4);
        if (!this.f13342e.equals(f13338a)) {
            hVar.add(new e2(true, 0, (g) this.f13342e));
        }
        if (!this.f13343f.equals(f13339b)) {
            hVar.add(new e2(true, 1, (g) this.f13343f));
        }
        if (!this.f13344g.equals((a0) f13340c)) {
            hVar.add(new e2(true, 2, (g) this.f13344g));
        }
        if (!this.f13345h.equals((a0) f13341d)) {
            hVar.add(new e2(true, 3, (g) this.f13345h));
        }
        return new b2(hVar);
    }
}
