package g.a.a.y3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.x1;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class e extends g.a.a.t {
    public g.a.a.v G;
    public boolean H;
    public g.a.a.w I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g.a.a.v f13462a = new g.a.a.v("2.5.29.9").intern();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g.a.a.v f13463b = new g.a.a.v("2.5.29.14").intern();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g.a.a.v f13464c = new g.a.a.v("2.5.29.15").intern();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g.a.a.v f13465d = new g.a.a.v("2.5.29.16").intern();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g.a.a.v f13466e = new g.a.a.v("2.5.29.17").intern();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g.a.a.v f13467f = new g.a.a.v("2.5.29.18").intern();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g.a.a.v f13468g = new g.a.a.v("2.5.29.19").intern();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g.a.a.v f13469h = new g.a.a.v("2.5.29.20").intern();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g.a.a.v f13470i = new g.a.a.v("2.5.29.21").intern();
    public static final g.a.a.v j = new g.a.a.v("2.5.29.23").intern();
    public static final g.a.a.v k = new g.a.a.v("2.5.29.24").intern();
    public static final g.a.a.v l = new g.a.a.v("2.5.29.27").intern();
    public static final g.a.a.v m = new g.a.a.v("2.5.29.28").intern();
    public static final g.a.a.v n = new g.a.a.v("2.5.29.29").intern();
    public static final g.a.a.v o = new g.a.a.v("2.5.29.30").intern();
    public static final g.a.a.v p = new g.a.a.v("2.5.29.31").intern();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final g.a.a.v f13471q = new g.a.a.v("2.5.29.32").intern();
    public static final g.a.a.v r = new g.a.a.v("2.5.29.33").intern();
    public static final g.a.a.v s = new g.a.a.v("2.5.29.35").intern();
    public static final g.a.a.v t = new g.a.a.v("2.5.29.36").intern();
    public static final g.a.a.v u = new g.a.a.v("2.5.29.37").intern();
    public static final g.a.a.v v = new g.a.a.v("2.5.29.46").intern();
    public static final g.a.a.v w = new g.a.a.v("2.5.29.54").intern();
    public static final g.a.a.v x = new g.a.a.v("1.3.6.1.5.5.7.1.1").intern();
    public static final g.a.a.v y = new g.a.a.v("1.3.6.1.5.5.7.1.11").intern();
    public static final g.a.a.v z = new g.a.a.v("1.3.6.1.5.5.7.1.12").intern();
    public static final g.a.a.v A = new g.a.a.v("1.3.6.1.5.5.7.1.2").intern();
    public static final g.a.a.v B = new g.a.a.v("1.3.6.1.5.5.7.1.3").intern();
    public static final g.a.a.v C = new g.a.a.v("1.3.6.1.5.5.7.1.4").intern();
    public static final g.a.a.v D = new g.a.a.v("2.5.29.56").intern();
    public static final g.a.a.v E = new g.a.a.v("2.5.29.55").intern();
    public static final g.a.a.v F = new g.a.a.v("2.5.29.60").intern();

    public e(d0 d0Var) {
        g.a.a.g objectAt;
        if (d0Var.size() == 2) {
            this.G = g.a.a.v.getInstance(d0Var.getObjectAt(0));
            this.H = false;
            objectAt = d0Var.getObjectAt(1);
        } else {
            if (d0Var.size() != 3) {
                throw new IllegalArgumentException("Bad sequence size: " + d0Var.size());
            }
            this.G = g.a.a.v.getInstance(d0Var.getObjectAt(0));
            this.H = g.a.a.e.getInstance(d0Var.getObjectAt(1)).isTrue();
            objectAt = d0Var.getObjectAt(2);
        }
        this.I = g.a.a.w.getInstance(objectAt);
    }

    public e(g.a.a.v vVar, g.a.a.e eVar, g.a.a.w wVar) {
        this(vVar, eVar.isTrue(), wVar);
    }

    public e(g.a.a.v vVar, boolean z2, g.a.a.w wVar) {
        this.G = vVar;
        this.H = z2;
        this.I = wVar;
    }

    public e(g.a.a.v vVar, boolean z2, byte[] bArr) {
        this(vVar, z2, new x1(bArr));
    }

    public static a0 a(e eVar) throws IllegalArgumentException {
        try {
            return a0.fromByteArray(eVar.getExtnValue().getOctets());
        } catch (IOException e2) {
            throw new IllegalArgumentException("can't convert extension: " + e2);
        }
    }

    public static e create(g.a.a.v vVar, boolean z2, g.a.a.g gVar) throws IOException {
        return new e(vVar, z2, gVar.toASN1Primitive().getEncoded());
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

    @Override // g.a.a.t
    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return eVar.getExtnId().equals((a0) getExtnId()) && eVar.getExtnValue().equals((a0) getExtnValue()) && eVar.isCritical() == isCritical();
    }

    public g.a.a.v getExtnId() {
        return this.G;
    }

    public g.a.a.w getExtnValue() {
        return this.I;
    }

    public g.a.a.g getParsedValue() {
        return a(this);
    }

    @Override // g.a.a.t
    public int hashCode() {
        return isCritical() ? getExtnValue().hashCode() ^ getExtnId().hashCode() : ~(getExtnValue().hashCode() ^ getExtnId().hashCode());
    }

    public boolean isCritical() {
        return this.H;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(3);
        hVar.add(this.G);
        if (this.H) {
            hVar.add(g.a.a.e.getInstance(true));
        }
        hVar.add(this.I);
        return new b2(hVar);
    }
}
