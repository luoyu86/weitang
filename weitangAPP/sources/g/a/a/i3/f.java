package g.a.a.i3;

import g.a.a.a0;
import g.a.a.d0;
import g.a.a.d1;
import g.a.a.h1;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class f extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.v f13127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.y3.a f13128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.a.a.w f13129c;

    public f(d0 d0Var) {
        if (d0Var.size() < 2) {
            throw new IllegalArgumentException("Truncated Sequence Found");
        }
        this.f13127a = (g.a.a.v) d0Var.getObjectAt(0);
        this.f13128b = g.a.a.y3.a.getInstance(d0Var.getObjectAt(1));
        if (d0Var.size() > 2) {
            this.f13129c = g.a.a.w.getInstance((l0) d0Var.getObjectAt(2), false);
        }
    }

    public f(g.a.a.v vVar, g.a.a.y3.a aVar, g.a.a.w wVar) {
        this.f13127a = vVar;
        this.f13128b = aVar;
        this.f13129c = wVar;
    }

    public static f getInstance(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.y3.a getContentEncryptionAlgorithm() {
        return this.f13128b;
    }

    public g.a.a.v getContentType() {
        return this.f13127a;
    }

    public g.a.a.w getEncryptedContent() {
        return this.f13129c;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(3);
        hVar.add(this.f13127a);
        hVar.add(this.f13128b);
        g.a.a.w wVar = this.f13129c;
        if (wVar != null) {
            hVar.add(new h1(false, 0, (g.a.a.g) wVar));
        }
        return new d1(hVar);
    }
}
