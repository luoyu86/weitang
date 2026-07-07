package g.a.a.y3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class h extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g[] f13476a;

    public h(d0 d0Var) {
        this.f13476a = new g[d0Var.size()];
        for (int i2 = 0; i2 != d0Var.size(); i2++) {
            this.f13476a[i2] = g.getInstance(d0Var.getObjectAt(i2));
        }
    }

    public h(g gVar) {
        this.f13476a = new g[]{gVar};
    }

    public h(g[] gVarArr) {
        this.f13476a = a(gVarArr);
    }

    public static g[] a(g[] gVarArr) {
        g[] gVarArr2 = new g[gVarArr.length];
        System.arraycopy(gVarArr, 0, gVarArr2, 0, gVarArr.length);
        return gVarArr2;
    }

    public static h fromExtensions(f fVar, g.a.a.v vVar) {
        return getInstance(f.getExtensionParsedValue(fVar, vVar));
    }

    public static h getInstance(l0 l0Var, boolean z) {
        return new h(d0.getInstance(l0Var, z));
    }

    public static h getInstance(Object obj) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj != null) {
            return new h(d0.getInstance(obj));
        }
        return null;
    }

    public g[] getNames() {
        return a(this.f13476a);
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return new b2(this.f13476a);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String strLineSeparator = g.a.j.q.lineSeparator();
        stringBuffer.append("GeneralNames:");
        stringBuffer.append(strLineSeparator);
        for (int i2 = 0; i2 != this.f13476a.length; i2++) {
            stringBuffer.append("    ");
            stringBuffer.append(this.f13476a[i2]);
            stringBuffer.append(strLineSeparator);
        }
        return stringBuffer.toString();
    }
}
