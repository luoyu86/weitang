package g.a.a.i3;

import g.a.a.a0;
import g.a.a.d0;
import g.a.a.d1;
import g.a.a.e2;
import g.a.a.f0;
import g.a.a.l0;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes2.dex */
public class g extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.q f13130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f13131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f0 f13132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f f13133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public f0 f13134e;

    public g(d0 d0Var) {
        this.f13130a = (g.a.a.q) d0Var.getObjectAt(0);
        g.a.a.g objectAt = d0Var.getObjectAt(1);
        int i2 = 2;
        if (objectAt instanceof l0) {
            this.f13131b = p.getInstance((l0) objectAt, false);
            objectAt = d0Var.getObjectAt(2);
            i2 = 3;
        }
        this.f13132c = f0.getInstance(objectAt);
        int i3 = i2 + 1;
        this.f13133d = f.getInstance(d0Var.getObjectAt(i2));
        if (d0Var.size() > i3) {
            this.f13134e = f0.getInstance((l0) d0Var.getObjectAt(i3), false);
        }
    }

    public g(p pVar, f0 f0Var, f fVar, f0 f0Var2) {
        this.f13130a = new g.a.a.q(calculateVersion(pVar, f0Var, f0Var2));
        this.f13131b = pVar;
        this.f13132c = f0Var;
        this.f13133d = fVar;
        this.f13134e = f0Var2;
    }

    public g(p pVar, f0 f0Var, f fVar, c cVar) {
        this.f13130a = new g.a.a.q(calculateVersion(pVar, f0Var, f0.getInstance(cVar)));
        this.f13131b = pVar;
        this.f13132c = f0Var;
        this.f13133d = fVar;
        this.f13134e = f0.getInstance(cVar);
    }

    public static int calculateVersion(p pVar, f0 f0Var, f0 f0Var2) {
        if (pVar != null || f0Var2 != null) {
            return 2;
        }
        Enumeration objects = f0Var.getObjects();
        while (objects.hasMoreElements()) {
            if (!w.getInstance(objects.nextElement()).getVersion().hasValue(0)) {
                return 2;
            }
        }
        return 0;
    }

    public static g getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static g getInstance(Object obj) {
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj != null) {
            return new g(d0.getInstance(obj));
        }
        return null;
    }

    public f getEncryptedContentInfo() {
        return this.f13133d;
    }

    public p getOriginatorInfo() {
        return this.f13131b;
    }

    public f0 getRecipientInfos() {
        return this.f13132c;
    }

    public f0 getUnprotectedAttrs() {
        return this.f13134e;
    }

    public g.a.a.q getVersion() {
        return this.f13130a;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(5);
        hVar.add(this.f13130a);
        p pVar = this.f13131b;
        if (pVar != null) {
            hVar.add(new e2(false, 0, (g.a.a.g) pVar));
        }
        hVar.add(this.f13132c);
        hVar.add(this.f13133d);
        f0 f0Var = this.f13134e;
        if (f0Var != null) {
            hVar.add(new e2(false, 1, (g.a.a.g) f0Var));
        }
        return new d1(hVar);
    }
}
