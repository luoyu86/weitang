package g.a.a.i3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.f0;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class p extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f13158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f0 f13159b;

    public p(d0 d0Var) {
        l0 l0Var;
        int size = d0Var.size();
        if (size != 0) {
            if (size == 1) {
                l0Var = (l0) d0Var.getObjectAt(0);
                int tagNo = l0Var.getTagNo();
                if (tagNo == 0) {
                    this.f13158a = f0.getInstance(l0Var, false);
                    return;
                } else if (tagNo != 1) {
                    throw new IllegalArgumentException("Bad tag in OriginatorInfo: " + l0Var.getTagNo());
                }
            } else {
                if (size != 2) {
                    throw new IllegalArgumentException("OriginatorInfo too big");
                }
                this.f13158a = f0.getInstance((l0) d0Var.getObjectAt(0), false);
                l0Var = (l0) d0Var.getObjectAt(1);
            }
            this.f13159b = f0.getInstance(l0Var, false);
        }
    }

    public p(f0 f0Var, f0 f0Var2) {
        this.f13158a = f0Var;
        this.f13159b = f0Var2;
    }

    public static p getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static p getInstance(Object obj) {
        if (obj instanceof p) {
            return (p) obj;
        }
        if (obj != null) {
            return new p(d0.getInstance(obj));
        }
        return null;
    }

    public f0 getCRLs() {
        return this.f13159b;
    }

    public f0 getCertificates() {
        return this.f13158a;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(2);
        f0 f0Var = this.f13158a;
        if (f0Var != null) {
            hVar.add(new e2(false, 0, (g.a.a.g) f0Var));
        }
        f0 f0Var2 = this.f13159b;
        if (f0Var2 != null) {
            hVar.add(new e2(false, 1, (g.a.a.g) f0Var2));
        }
        return new b2(hVar);
    }
}
