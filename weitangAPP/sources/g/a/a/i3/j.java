package g.a.a.i3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.l0;
import g.a.a.x1;

/* JADX INFO: loaded from: classes2.dex */
public class j extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.w f13139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.m f13140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f13141c;

    public j(d0 d0Var) {
        g.a.a.g objectAt;
        this.f13139a = (g.a.a.w) d0Var.getObjectAt(0);
        int size = d0Var.size();
        if (size != 1) {
            if (size == 2) {
                boolean z = d0Var.getObjectAt(1) instanceof g.a.a.m;
                objectAt = d0Var.getObjectAt(1);
                if (z) {
                    this.f13140b = (g.a.a.m) objectAt;
                    return;
                }
            } else {
                if (size != 3) {
                    throw new IllegalArgumentException("Invalid KEKIdentifier");
                }
                this.f13140b = (g.a.a.m) d0Var.getObjectAt(1);
                objectAt = d0Var.getObjectAt(2);
            }
            this.f13141c = r.getInstance(objectAt);
        }
    }

    public j(byte[] bArr, g.a.a.m mVar, r rVar) {
        this.f13139a = new x1(bArr);
        this.f13140b = mVar;
        this.f13141c = rVar;
    }

    public static j getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static j getInstance(Object obj) {
        if (obj == null || (obj instanceof j)) {
            return (j) obj;
        }
        if (obj instanceof d0) {
            return new j((d0) obj);
        }
        throw new IllegalArgumentException("Invalid KEKIdentifier: " + obj.getClass().getName());
    }

    public g.a.a.m getDate() {
        return this.f13140b;
    }

    public g.a.a.w getKeyIdentifier() {
        return this.f13139a;
    }

    public r getOther() {
        return this.f13141c;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(3);
        hVar.add(this.f13139a);
        g.a.a.m mVar = this.f13140b;
        if (mVar != null) {
            hVar.add(mVar);
        }
        r rVar = this.f13141c;
        if (rVar != null) {
            hVar.add(rVar);
        }
        return new b2(hVar);
    }
}
