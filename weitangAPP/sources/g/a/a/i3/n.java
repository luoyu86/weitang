package g.a.a.i3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class n extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.q f13153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f13154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.a.a.y3.a f13155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g.a.a.w f13156d;

    public n(d0 d0Var) {
        this.f13153a = (g.a.a.q) d0Var.getObjectAt(0);
        this.f13154b = v.getInstance(d0Var.getObjectAt(1));
        this.f13155c = g.a.a.y3.a.getInstance(d0Var.getObjectAt(2));
        this.f13156d = (g.a.a.w) d0Var.getObjectAt(3);
    }

    public n(v vVar, g.a.a.y3.a aVar, g.a.a.w wVar) {
        this.f13153a = vVar.toASN1Primitive() instanceof l0 ? new g.a.a.q(2L) : new g.a.a.q(0L);
        this.f13154b = vVar;
        this.f13155c = aVar;
        this.f13156d = wVar;
    }

    public static n getInstance(Object obj) {
        if (obj instanceof n) {
            return (n) obj;
        }
        if (obj != null) {
            return new n(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.w getEncryptedKey() {
        return this.f13156d;
    }

    public g.a.a.y3.a getKeyEncryptionAlgorithm() {
        return this.f13155c;
    }

    public v getRecipientIdentifier() {
        return this.f13154b;
    }

    public g.a.a.q getVersion() {
        return this.f13153a;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(4);
        hVar.add(this.f13153a);
        hVar.add(this.f13154b);
        hVar.add(this.f13155c);
        hVar.add(this.f13156d);
        return new b2(hVar);
    }
}
