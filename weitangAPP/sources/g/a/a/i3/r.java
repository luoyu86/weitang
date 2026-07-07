package g.a.a.i3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;

/* JADX INFO: loaded from: classes2.dex */
public class r extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.v f13162a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.g f13163b;

    public r(d0 d0Var) {
        this.f13162a = (g.a.a.v) d0Var.getObjectAt(0);
        this.f13163b = d0Var.getObjectAt(1);
    }

    public r(g.a.a.v vVar, g.a.a.g gVar) {
        this.f13162a = vVar;
        this.f13163b = gVar;
    }

    public static r getInstance(Object obj) {
        if (obj instanceof r) {
            return (r) obj;
        }
        if (obj != null) {
            return new r(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.g getKeyAttr() {
        return this.f13163b;
    }

    public g.a.a.v getKeyAttrId() {
        return this.f13162a;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(2);
        hVar.add(this.f13162a);
        hVar.add(this.f13163b);
        return new b2(hVar);
    }
}
