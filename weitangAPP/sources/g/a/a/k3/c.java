package g.a.a.k3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.h;
import g.a.a.l0;
import g.a.a.t;
import g.a.a.v;

/* JADX INFO: loaded from: classes2.dex */
public class c extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f13215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f13216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public v f13217c;

    public c(d0 d0Var) {
        this.f13215a = (v) d0Var.getObjectAt(0);
        this.f13216b = (v) d0Var.getObjectAt(1);
        if (d0Var.size() > 2) {
            this.f13217c = (v) d0Var.getObjectAt(2);
        }
    }

    public c(v vVar, v vVar2) {
        this.f13215a = vVar;
        this.f13216b = vVar2;
        this.f13217c = null;
    }

    public c(v vVar, v vVar2, v vVar3) {
        this.f13215a = vVar;
        this.f13216b = vVar2;
        this.f13217c = vVar3;
    }

    public static c getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static c getInstance(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(d0.getInstance(obj));
        }
        return null;
    }

    public v getDigestParamSet() {
        return this.f13216b;
    }

    public v getEncryptionParamSet() {
        return this.f13217c;
    }

    public v getPublicKeyParamSet() {
        return this.f13215a;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        h hVar = new h(3);
        hVar.add(this.f13215a);
        hVar.add(this.f13216b);
        v vVar = this.f13217c;
        if (vVar != null) {
            hVar.add(vVar);
        }
        return new b2(hVar);
    }
}
