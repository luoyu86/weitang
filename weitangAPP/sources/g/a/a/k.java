package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r0 f13191a = new a(k.class, 8);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v f13192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q f13193c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a0 f13194d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13195e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a0 f13196f;

    public static class a extends r0 {
        public a(Class cls, int i2) {
            super(cls, i2);
        }

        @Override // g.a.a.r0
        public a0 c(d0 d0Var) {
            return d0Var.j();
        }
    }

    public k(d0 d0Var) {
        int i2 = 0;
        a0 a0VarK = k(d0Var, 0);
        if (a0VarK instanceof v) {
            this.f13192b = (v) a0VarK;
            a0VarK = k(d0Var, 1);
            i2 = 1;
        }
        if (a0VarK instanceof q) {
            this.f13193c = (q) a0VarK;
            i2++;
            a0VarK = k(d0Var, i2);
        }
        if (!(a0VarK instanceof l0)) {
            this.f13194d = a0VarK;
            i2++;
            a0VarK = k(d0Var, i2);
        }
        if (d0Var.size() != i2 + 1) {
            throw new IllegalArgumentException("input sequence too large");
        }
        if (!(a0VarK instanceof l0)) {
            throw new IllegalArgumentException("No tagged object found in sequence. Structure doesn't seem to be of type External");
        }
        l0 l0Var = (l0) a0VarK;
        this.f13195e = h(l0Var.getTagNo());
        this.f13196f = j(l0Var);
    }

    public k(v vVar, q qVar, a0 a0Var, int i2, a0 a0Var2) {
        this.f13192b = vVar;
        this.f13193c = qVar;
        this.f13194d = a0Var;
        this.f13195e = h(i2);
        this.f13196f = i(i2, a0Var2);
    }

    public k(v vVar, q qVar, a0 a0Var, e2 e2Var) {
        this.f13192b = vVar;
        this.f13193c = qVar;
        this.f13194d = a0Var;
        this.f13195e = h(e2Var.getTagNo());
        this.f13196f = j(e2Var);
    }

    public static k getInstance(l0 l0Var, boolean z) {
        return (k) f13191a.e(l0Var, z);
    }

    public static k getInstance(Object obj) {
        if (obj == null || (obj instanceof k)) {
            return (k) obj;
        }
        if (obj instanceof g) {
            a0 aSN1Primitive = ((g) obj).toASN1Primitive();
            if (aSN1Primitive instanceof k) {
                return (k) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (k) f13191a.b((byte[]) obj);
            } catch (IOException e2) {
                throw new IllegalArgumentException("failed to construct external from byte[]: " + e2.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static int h(int i2) {
        if (i2 >= 0 && i2 <= 2) {
            return i2;
        }
        throw new IllegalArgumentException("invalid encoding value: " + i2);
    }

    public static a0 i(int i2, a0 a0Var) {
        r0 r0Var;
        if (i2 == 1) {
            r0Var = w.f13391a;
        } else {
            if (i2 != 2) {
                return a0Var;
            }
            r0Var = c.f13048a;
        }
        return r0Var.a(a0Var);
    }

    public static a0 j(l0 l0Var) {
        int tagClass = l0Var.getTagClass();
        int tagNo = l0Var.getTagNo();
        if (128 != tagClass) {
            throw new IllegalArgumentException("invalid tag: " + t0.getTagText(tagClass, tagNo));
        }
        if (tagNo == 0) {
            return l0Var.getExplicitBaseObject().toASN1Primitive();
        }
        if (tagNo == 1) {
            return w.getInstance(l0Var, false);
        }
        if (tagNo == 2) {
            return c.getInstance(l0Var, false);
        }
        throw new IllegalArgumentException("invalid tag: " + t0.getTagText(tagClass, tagNo));
    }

    public static a0 k(d0 d0Var, int i2) {
        if (d0Var.size() > i2) {
            return d0Var.getObjectAt(i2).toASN1Primitive();
        }
        throw new IllegalArgumentException("too few objects in input sequence");
    }

    @Override // g.a.a.a0
    public boolean a(a0 a0Var) {
        if (this == a0Var) {
            return true;
        }
        if (!(a0Var instanceof k)) {
            return false;
        }
        k kVar = (k) a0Var;
        return g.a.j.j.areEqual(this.f13192b, kVar.f13192b) && g.a.j.j.areEqual(this.f13193c, kVar.f13193c) && g.a.j.j.areEqual(this.f13194d, kVar.f13194d) && this.f13195e == kVar.f13195e && this.f13196f.equals(kVar.f13196f);
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        yVar.q(z, 40);
        g().b(yVar, false);
    }

    @Override // g.a.a.a0
    public boolean c() {
        return true;
    }

    @Override // g.a.a.a0
    public int d(boolean z) throws IOException {
        return g().d(z);
    }

    @Override // g.a.a.a0
    public a0 e() {
        return new o1(this.f13192b, this.f13193c, this.f13194d, this.f13195e, this.f13196f);
    }

    @Override // g.a.a.a0
    public a0 f() {
        return new n2(this.f13192b, this.f13193c, this.f13194d, this.f13195e, this.f13196f);
    }

    public abstract d0 g();

    public a0 getDataValueDescriptor() {
        return this.f13194d;
    }

    public v getDirectReference() {
        return this.f13192b;
    }

    public int getEncoding() {
        return this.f13195e;
    }

    public a0 getExternalContent() {
        return this.f13196f;
    }

    public q getIndirectReference() {
        return this.f13193c;
    }

    @Override // g.a.a.a0, g.a.a.t
    public int hashCode() {
        return (((g.a.j.j.hashCode(this.f13192b) ^ g.a.j.j.hashCode(this.f13193c)) ^ g.a.j.j.hashCode(this.f13194d)) ^ this.f13195e) ^ this.f13196f.hashCode();
    }
}
