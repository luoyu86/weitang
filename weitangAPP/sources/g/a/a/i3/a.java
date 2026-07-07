package g.a.a.i3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.f0;

/* JADX INFO: loaded from: classes2.dex */
public class a extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.v f13121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f13122b;

    public a(d0 d0Var) {
        this.f13121a = (g.a.a.v) d0Var.getObjectAt(0);
        this.f13122b = (f0) d0Var.getObjectAt(1);
    }

    public a(g.a.a.v vVar, f0 f0Var) {
        this.f13121a = vVar;
        this.f13122b = f0Var;
    }

    public static a getInstance(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.v getAttrType() {
        return this.f13121a;
    }

    public f0 getAttrValues() {
        return this.f13122b;
    }

    public g.a.a.g[] getAttributeValues() {
        return this.f13122b.toArray();
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(2);
        hVar.add(this.f13121a);
        hVar.add(this.f13122b);
        return new b2(hVar);
    }
}
