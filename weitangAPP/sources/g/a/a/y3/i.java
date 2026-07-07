package g.a.a.y3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class i extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f13477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f13480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13481e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13482f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public d0 f13483g;

    public i(d0 d0Var) {
        this.f13483g = d0Var;
        for (int i2 = 0; i2 != d0Var.size(); i2++) {
            l0 l0Var = l0.getInstance(d0Var.getObjectAt(i2));
            int tagNo = l0Var.getTagNo();
            if (tagNo == 0) {
                this.f13477a = d.getInstance(l0Var, true);
            } else if (tagNo == 1) {
                this.f13478b = g.a.a.e.getInstance(l0Var, false).isTrue();
            } else if (tagNo == 2) {
                this.f13479c = g.a.a.e.getInstance(l0Var, false).isTrue();
            } else if (tagNo == 3) {
                this.f13480d = new j(g.a.a.c.getInstance(l0Var, false));
            } else if (tagNo == 4) {
                this.f13481e = g.a.a.e.getInstance(l0Var, false).isTrue();
            } else {
                if (tagNo != 5) {
                    throw new IllegalArgumentException("unknown tag in IssuingDistributionPoint");
                }
                this.f13482f = g.a.a.e.getInstance(l0Var, false).isTrue();
            }
        }
    }

    public i(d dVar, boolean z, boolean z2) {
        this(dVar, false, false, null, z, z2);
    }

    public i(d dVar, boolean z, boolean z2, j jVar, boolean z3, boolean z4) {
        this.f13477a = dVar;
        this.f13481e = z3;
        this.f13482f = z4;
        this.f13479c = z2;
        this.f13478b = z;
        this.f13480d = jVar;
        g.a.a.h hVar = new g.a.a.h(6);
        if (dVar != null) {
            hVar.add(new e2(true, 0, (g.a.a.g) dVar));
        }
        if (z) {
            hVar.add(new e2(false, 1, (g.a.a.g) g.a.a.e.getInstance(true)));
        }
        if (z2) {
            hVar.add(new e2(false, 2, (g.a.a.g) g.a.a.e.getInstance(true)));
        }
        if (jVar != null) {
            hVar.add(new e2(false, 3, (g.a.a.g) jVar));
        }
        if (z3) {
            hVar.add(new e2(false, 4, (g.a.a.g) g.a.a.e.getInstance(true)));
        }
        if (z4) {
            hVar.add(new e2(false, 5, (g.a.a.g) g.a.a.e.getInstance(true)));
        }
        this.f13483g = new b2(hVar);
    }

    public static i getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static i getInstance(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(d0.getInstance(obj));
        }
        return null;
    }

    public final void a(StringBuffer stringBuffer, String str, String str2, String str3) {
        stringBuffer.append("    ");
        stringBuffer.append(str2);
        stringBuffer.append(":");
        stringBuffer.append(str);
        stringBuffer.append("    ");
        stringBuffer.append("    ");
        stringBuffer.append(str3);
        stringBuffer.append(str);
    }

    public final String b(boolean z) {
        return z ? "true" : "false";
    }

    public d getDistributionPoint() {
        return this.f13477a;
    }

    public j getOnlySomeReasons() {
        return this.f13480d;
    }

    public boolean isIndirectCRL() {
        return this.f13481e;
    }

    public boolean onlyContainsAttributeCerts() {
        return this.f13482f;
    }

    public boolean onlyContainsCACerts() {
        return this.f13479c;
    }

    public boolean onlyContainsUserCerts() {
        return this.f13478b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return this.f13483g;
    }

    public String toString() {
        String strLineSeparator = g.a.j.q.lineSeparator();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("IssuingDistributionPoint: [");
        stringBuffer.append(strLineSeparator);
        d dVar = this.f13477a;
        if (dVar != null) {
            a(stringBuffer, strLineSeparator, "distributionPoint", dVar.toString());
        }
        boolean z = this.f13478b;
        if (z) {
            a(stringBuffer, strLineSeparator, "onlyContainsUserCerts", b(z));
        }
        boolean z2 = this.f13479c;
        if (z2) {
            a(stringBuffer, strLineSeparator, "onlyContainsCACerts", b(z2));
        }
        j jVar = this.f13480d;
        if (jVar != null) {
            a(stringBuffer, strLineSeparator, "onlySomeReasons", jVar.toString());
        }
        boolean z3 = this.f13482f;
        if (z3) {
            a(stringBuffer, strLineSeparator, "onlyContainsAttributeCerts", b(z3));
        }
        boolean z4 = this.f13481e;
        if (z4) {
            a(stringBuffer, strLineSeparator, "indirectCRL", b(z4));
        }
        stringBuffer.append("]");
        stringBuffer.append(strLineSeparator);
        return stringBuffer.toString();
    }
}
