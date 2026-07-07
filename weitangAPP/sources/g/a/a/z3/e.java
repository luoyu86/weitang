package g.a.a.z3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.q;
import g.a.a.t;
import g.a.a.w;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class e extends t implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BigInteger f13577a = BigInteger.valueOf(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i f13578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.a.g.a.e f13579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g f13580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BigInteger f13581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BigInteger f13582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f13583g;

    public e(d0 d0Var) {
        if (!(d0Var.getObjectAt(0) instanceof q) || !((q) d0Var.getObjectAt(0)).hasValue(1)) {
            throw new IllegalArgumentException("bad version in X9ECParameters");
        }
        this.f13581e = ((q) d0Var.getObjectAt(4)).getValue();
        if (d0Var.size() == 6) {
            this.f13582f = ((q) d0Var.getObjectAt(5)).getValue();
        }
        d dVar = new d(i.getInstance(d0Var.getObjectAt(1)), this.f13581e, this.f13582f, d0.getInstance(d0Var.getObjectAt(2)));
        this.f13579c = dVar.getCurve();
        g.a.a.g objectAt = d0Var.getObjectAt(3);
        if (objectAt instanceof g) {
            this.f13580d = (g) objectAt;
        } else {
            this.f13580d = new g(this.f13579c, (w) objectAt);
        }
        this.f13583g = dVar.getSeed();
    }

    public e(g.a.g.a.e eVar, g gVar, BigInteger bigInteger) {
        this(eVar, gVar, bigInteger, null, null);
    }

    public e(g.a.g.a.e eVar, g gVar, BigInteger bigInteger, BigInteger bigInteger2) {
        this(eVar, gVar, bigInteger, bigInteger2, null);
    }

    public e(g.a.g.a.e eVar, g gVar, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        i iVar;
        this.f13579c = eVar;
        this.f13580d = gVar;
        this.f13581e = bigInteger;
        this.f13582f = bigInteger2;
        this.f13583g = g.a.j.a.clone(bArr);
        if (g.a.g.a.c.isFpCurve(eVar)) {
            iVar = new i(eVar.getField().getCharacteristic());
        } else {
            if (!g.a.g.a.c.isF2mCurve(eVar)) {
                throw new IllegalArgumentException("'curve' is of an unsupported type");
            }
            int[] exponentsPresent = ((g.a.g.b.f) eVar.getField()).getMinimalPolynomial().getExponentsPresent();
            if (exponentsPresent.length == 3) {
                iVar = new i(exponentsPresent[2], exponentsPresent[1]);
            } else {
                if (exponentsPresent.length != 5) {
                    throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
                }
                iVar = new i(exponentsPresent[4], exponentsPresent[1], exponentsPresent[2], exponentsPresent[3]);
            }
        }
        this.f13578b = iVar;
    }

    public static e getInstance(Object obj) {
        if (obj instanceof e) {
            return (e) obj;
        }
        if (obj != null) {
            return new e(d0.getInstance(obj));
        }
        return null;
    }

    public g getBaseEntry() {
        return this.f13580d;
    }

    public g.a.g.a.e getCurve() {
        return this.f13579c;
    }

    public d getCurveEntry() {
        return new d(this.f13579c, this.f13583g);
    }

    public i getFieldIDEntry() {
        return this.f13578b;
    }

    public g.a.g.a.i getG() {
        return this.f13580d.getPoint();
    }

    public BigInteger getH() {
        return this.f13582f;
    }

    public BigInteger getN() {
        return this.f13581e;
    }

    public byte[] getSeed() {
        return g.a.j.a.clone(this.f13583g);
    }

    public boolean hasSeed() {
        return this.f13583g != null;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(6);
        hVar.add(new q(f13577a));
        hVar.add(this.f13578b);
        hVar.add(new d(this.f13579c, this.f13583g));
        hVar.add(this.f13580d);
        hVar.add(new q(this.f13581e));
        if (this.f13582f != null) {
            hVar.add(new q(this.f13582f));
        }
        return new b2(hVar);
    }
}
