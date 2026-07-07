package g.a.a.i3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.l0;
import g.a.a.x1;

/* JADX INFO: loaded from: classes2.dex */
public class x extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.w f13174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.m f13175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r f13176c;

    public x(d0 d0Var) {
        this.f13174a = g.a.a.w.getInstance(d0Var.getObjectAt(0));
        int size = d0Var.size();
        if (size != 1) {
            if (size != 2) {
                if (size != 3) {
                    throw new IllegalArgumentException("Invalid RecipientKeyIdentifier");
                }
                this.f13175b = g.a.a.m.getInstance(d0Var.getObjectAt(1));
            } else if (d0Var.getObjectAt(1) instanceof g.a.a.m) {
                this.f13175b = g.a.a.m.getInstance(d0Var.getObjectAt(1));
                return;
            }
            this.f13176c = r.getInstance(d0Var.getObjectAt(2));
        }
    }

    public x(g.a.a.w wVar, g.a.a.m mVar, r rVar) {
        this.f13174a = wVar;
        this.f13175b = mVar;
        this.f13176c = rVar;
    }

    public x(byte[] bArr) {
        this(bArr, (g.a.a.m) null, (r) null);
    }

    public x(byte[] bArr, g.a.a.m mVar, r rVar) {
        this.f13174a = new x1(bArr);
        this.f13175b = mVar;
        this.f13176c = rVar;
    }

    public static x getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static x getInstance(Object obj) {
        if (obj instanceof x) {
            return (x) obj;
        }
        if (obj != null) {
            return new x(d0.getInstance(obj));
        }
        return null;
    }

    public g.a.a.m getDate() {
        return this.f13175b;
    }

    public r getOtherKeyAttribute() {
        return this.f13176c;
    }

    public g.a.a.w getSubjectKeyIdentifier() {
        return this.f13174a;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(3);
        hVar.add(this.f13174a);
        g.a.a.m mVar = this.f13175b;
        if (mVar != null) {
            hVar.add(mVar);
        }
        r rVar = this.f13176c;
        if (rVar != null) {
            hVar.add(rVar);
        }
        return new b2(hVar);
    }
}
