package g.a.a.i3;

import g.a.a.a0;
import g.a.a.d0;
import g.a.a.d1;
import g.a.a.h1;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class e extends g.a.a.t implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.v f13125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.g f13126b;

    public e(d0 d0Var) {
        if (d0Var.size() < 1 || d0Var.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + d0Var.size());
        }
        this.f13125a = (g.a.a.v) d0Var.getObjectAt(0);
        if (d0Var.size() > 1) {
            l0 l0Var = (l0) d0Var.getObjectAt(1);
            if (!l0Var.isExplicit() || l0Var.getTagNo() != 0) {
                throw new IllegalArgumentException("Bad tag for 'content'");
            }
            this.f13126b = l0Var.getObject();
        }
    }

    public e(g.a.a.v vVar, g.a.a.g gVar) {
        this.f13125a = vVar;
        this.f13126b = gVar;
    }

    public static e getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
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

    public g.a.a.g getContent() {
        return this.f13126b;
    }

    public g.a.a.v getContentType() {
        return this.f13125a;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(2);
        hVar.add(this.f13125a);
        g.a.a.g gVar = this.f13126b;
        if (gVar != null) {
            hVar.add(new h1(0, gVar));
        }
        return new d1(hVar);
    }
}
