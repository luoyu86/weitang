package g.a.a.i3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class s extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.v f13164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.g f13165b;

    public s(d0 d0Var) {
        this.f13164a = g.a.a.v.getInstance(d0Var.getObjectAt(0));
        this.f13165b = d0Var.getObjectAt(1);
    }

    public s(g.a.a.v vVar, g.a.a.g gVar) {
        this.f13164a = vVar;
        this.f13165b = gVar;
    }

    public static s getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static s getInstance(Object obj) {
        if (obj instanceof s) {
            return (s) obj;
        }
        if (obj != null) {
            return new s(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.v getType() {
        return this.f13164a;
    }

    public g.a.a.g getValue() {
        return this.f13165b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(2);
        hVar.add(this.f13164a);
        hVar.add(this.f13165b);
        return new b2(hVar);
    }
}
