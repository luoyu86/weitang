package g.a.a.z3;

import g.a.a.a0;
import g.a.a.l0;
import g.a.a.r;
import g.a.a.t;
import g.a.a.v;

/* JADX INFO: loaded from: classes2.dex */
public class c extends t implements g.a.a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a0 f13573a;

    public c(a0 a0Var) {
        this.f13573a = null;
        this.f13573a = a0Var;
    }

    public c(r rVar) {
        this.f13573a = null;
        this.f13573a = rVar;
    }

    public c(v vVar) {
        this.f13573a = null;
        this.f13573a = vVar;
    }

    public c(e eVar) {
        this.f13573a = null;
        this.f13573a = eVar.toASN1Primitive();
    }

    public static c getInstance(l0 l0Var, boolean z) {
        return getInstance(l0Var.getObject());
    }

    public static c getInstance(Object obj) {
        if (obj == null || (obj instanceof c)) {
            return (c) obj;
        }
        if (obj instanceof a0) {
            return new c((a0) obj);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("unknown object in getInstance()");
        }
        try {
            return new c(a0.fromByteArray((byte[]) obj));
        } catch (Exception e2) {
            throw new IllegalArgumentException("unable to parse encoded data: " + e2.getMessage());
        }
    }

    public a0 getParameters() {
        return this.f13573a;
    }

    public boolean isImplicitlyCA() {
        return this.f13573a instanceof r;
    }

    public boolean isNamedCurve() {
        return this.f13573a instanceof v;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return this.f13573a;
    }
}
