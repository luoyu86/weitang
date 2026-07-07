package g.a.a.y3;

import g.a.a.a0;
import g.a.a.d0;
import g.a.a.l0;

/* JADX INFO: loaded from: classes2.dex */
public class o extends g.a.a.t implements x, g.a.a.t3.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f13508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.q f13509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.a.a.q f13510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f13511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g.a.a.x3.c f13512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public p f13513f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p f13514g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public g.a.a.x3.c f13515h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public l f13516i;
    public g.a.a.c j;
    public g.a.a.c k;
    public t l;

    public o(d0 d0Var) {
        int i2;
        this.f13508a = d0Var;
        if (d0Var.getObjectAt(0) instanceof l0) {
            this.f13509b = g.a.a.q.getInstance((l0) d0Var.getObjectAt(0), true);
            i2 = 0;
        } else {
            this.f13509b = new g.a.a.q(0L);
            i2 = -1;
        }
        this.f13510c = g.a.a.q.getInstance(d0Var.getObjectAt(i2 + 1));
        this.f13511d = a.getInstance(d0Var.getObjectAt(i2 + 2));
        this.f13512e = g.a.a.x3.c.getInstance(d0Var.getObjectAt(i2 + 3));
        d0 d0Var2 = (d0) d0Var.getObjectAt(i2 + 4);
        this.f13513f = p.getInstance(d0Var2.getObjectAt(0));
        this.f13514g = p.getInstance(d0Var2.getObjectAt(1));
        this.f13515h = g.a.a.x3.c.getInstance(d0Var.getObjectAt(i2 + 5));
        int i3 = i2 + 6;
        this.f13516i = l.getInstance(d0Var.getObjectAt(i3));
        for (int size = (d0Var.size() - i3) - 1; size > 0; size--) {
            l0 l0Var = l0.getInstance(d0Var.getObjectAt(i3 + size));
            int tagNo = l0Var.getTagNo();
            if (tagNo == 1) {
                this.j = g.a.a.c.getInstance(l0Var, false);
            } else if (tagNo == 2) {
                this.k = g.a.a.c.getInstance(l0Var, false);
            } else if (tagNo == 3) {
                this.l = t.getInstance(l0Var);
            }
        }
    }

    public static o getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static o getInstance(Object obj) {
        if (obj instanceof o) {
            return (o) obj;
        }
        if (obj != null) {
            return new o(d0.getInstance(obj));
        }
        return null;
    }

    public p getEndDate() {
        return this.f13514g;
    }

    public t getExtensions() {
        return this.l;
    }

    public g.a.a.x3.c getIssuer() {
        return this.f13512e;
    }

    public g.a.a.c getIssuerUniqueId() {
        return this.j;
    }

    public g.a.a.q getSerialNumber() {
        return this.f13510c;
    }

    public a getSignature() {
        return this.f13511d;
    }

    public p getStartDate() {
        return this.f13513f;
    }

    public g.a.a.x3.c getSubject() {
        return this.f13515h;
    }

    public l getSubjectPublicKeyInfo() {
        return this.f13516i;
    }

    public g.a.a.c getSubjectUniqueId() {
        return this.k;
    }

    public int getVersion() {
        return this.f13509b.intValueExact() + 1;
    }

    public g.a.a.q getVersionNumber() {
        return this.f13509b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return this.f13508a;
    }
}
