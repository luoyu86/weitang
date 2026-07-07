package g.a.a.y3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class a extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.v f13449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.g f13450b;

    public a(d0 d0Var) {
        if (d0Var.size() >= 1 && d0Var.size() <= 2) {
            this.f13449a = g.a.a.v.getInstance(d0Var.getObjectAt(0));
            this.f13450b = d0Var.size() == 2 ? d0Var.getObjectAt(1) : null;
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + d0Var.size());
        }
    }

    public a(g.a.a.v vVar) {
        this.f13449a = vVar;
    }

    public a(g.a.a.v vVar, g.a.a.g gVar) {
        this.f13449a = vVar;
        this.f13450b = gVar;
    }

    public static a getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
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

    public g.a.a.v getAlgorithm() {
        return this.f13449a;
    }

    public g.a.a.g getParameters() {
        return this.f13450b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(2);
        hVar.add(this.f13449a);
        g.a.a.g gVar = this.f13450b;
        if (gVar != null) {
            hVar.add(gVar);
        }
        return new b2(hVar);
    }
}
