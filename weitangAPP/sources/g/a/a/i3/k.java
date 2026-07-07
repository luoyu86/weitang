package g.a.a.i3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class k extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.q f13142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f13143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.a.a.y3.a f13144c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g.a.a.w f13145d;

    public k(d0 d0Var) {
        this.f13142a = (g.a.a.q) d0Var.getObjectAt(0);
        this.f13143b = j.getInstance(d0Var.getObjectAt(1));
        this.f13144c = g.a.a.y3.a.getInstance(d0Var.getObjectAt(2));
        this.f13145d = (g.a.a.w) d0Var.getObjectAt(3);
    }

    public k(j jVar, g.a.a.y3.a aVar, g.a.a.w wVar) {
        this.f13142a = new g.a.a.q(4L);
        this.f13143b = jVar;
        this.f13144c = aVar;
        this.f13145d = wVar;
    }

    public static k getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static k getInstance(Object obj) {
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj != null) {
            return new k(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.w getEncryptedKey() {
        return this.f13145d;
    }

    public j getKekid() {
        return this.f13143b;
    }

    public g.a.a.y3.a getKeyEncryptionAlgorithm() {
        return this.f13144c;
    }

    public g.a.a.q getVersion() {
        return this.f13142a;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(4);
        hVar.add(this.f13142a);
        hVar.add(this.f13143b);
        hVar.add(this.f13144c);
        hVar.add(this.f13145d);
        return new b2(hVar);
    }
}
