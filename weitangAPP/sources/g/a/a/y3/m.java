package g.a.a.y3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.l0;
import g.a.a.o0;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public class m extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g.a.a.q f13487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.y3.a f13488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g.a.a.x3.c f13489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public p f13490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p f13491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d0 f13492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f13493g;

    public static class b extends g.a.a.t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public d0 f13494a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public f f13495b;

        public b(d0 d0Var) {
            if (d0Var.size() >= 2 && d0Var.size() <= 3) {
                this.f13494a = d0Var;
                return;
            }
            throw new IllegalArgumentException("Bad sequence size: " + d0Var.size());
        }

        public static b getInstance(Object obj) {
            if (obj instanceof b) {
                return (b) obj;
            }
            if (obj != null) {
                return new b(d0.getInstance(obj));
            }
            return null;
        }

        public f getExtensions() {
            if (this.f13495b == null && this.f13494a.size() == 3) {
                this.f13495b = f.getInstance(this.f13494a.getObjectAt(2));
            }
            return this.f13495b;
        }

        public p getRevocationDate() {
            return p.getInstance(this.f13494a.getObjectAt(1));
        }

        public g.a.a.q getUserCertificate() {
            return g.a.a.q.getInstance(this.f13494a.getObjectAt(0));
        }

        public boolean hasExtensions() {
            return this.f13494a.size() == 3;
        }

        @Override // g.a.a.t, g.a.a.g
        public a0 toASN1Primitive() {
            return this.f13494a;
        }
    }

    public class c implements Enumeration {
        public c() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return false;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            throw new NoSuchElementException("Empty Enumeration");
        }
    }

    public class d implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Enumeration f13497a;

        public d(Enumeration enumeration) {
            this.f13497a = enumeration;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f13497a.hasMoreElements();
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            return b.getInstance(this.f13497a.nextElement());
        }
    }

    public m(d0 d0Var) {
        if (d0Var.size() < 3 || d0Var.size() > 7) {
            throw new IllegalArgumentException("Bad sequence size: " + d0Var.size());
        }
        int i2 = 0;
        if (d0Var.getObjectAt(0) instanceof g.a.a.q) {
            this.f13487a = g.a.a.q.getInstance(d0Var.getObjectAt(0));
            i2 = 1;
        } else {
            this.f13487a = null;
        }
        int i3 = i2 + 1;
        this.f13488b = g.a.a.y3.a.getInstance(d0Var.getObjectAt(i2));
        int i4 = i3 + 1;
        this.f13489c = g.a.a.x3.c.getInstance(d0Var.getObjectAt(i3));
        int i5 = i4 + 1;
        this.f13490d = p.getInstance(d0Var.getObjectAt(i4));
        if (i5 < d0Var.size() && ((d0Var.getObjectAt(i5) instanceof o0) || (d0Var.getObjectAt(i5) instanceof g.a.a.m) || (d0Var.getObjectAt(i5) instanceof p))) {
            this.f13491e = p.getInstance(d0Var.getObjectAt(i5));
            i5++;
        }
        if (i5 < d0Var.size() && !(d0Var.getObjectAt(i5) instanceof l0)) {
            this.f13492f = d0.getInstance(d0Var.getObjectAt(i5));
            i5++;
        }
        if (i5 >= d0Var.size() || !(d0Var.getObjectAt(i5) instanceof l0)) {
            return;
        }
        this.f13493g = f.getInstance(d0.getInstance((l0) d0Var.getObjectAt(i5), true));
    }

    public static m getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static m getInstance(Object obj) {
        if (obj instanceof m) {
            return (m) obj;
        }
        if (obj != null) {
            return new m(d0.getInstance(obj));
        }
        return null;
    }

    public f getExtensions() {
        return this.f13493g;
    }

    public g.a.a.x3.c getIssuer() {
        return this.f13489c;
    }

    public p getNextUpdate() {
        return this.f13491e;
    }

    public Enumeration getRevokedCertificateEnumeration() {
        d0 d0Var = this.f13492f;
        return d0Var == null ? new c() : new d(d0Var.getObjects());
    }

    public b[] getRevokedCertificates() {
        d0 d0Var = this.f13492f;
        if (d0Var == null) {
            return new b[0];
        }
        int size = d0Var.size();
        b[] bVarArr = new b[size];
        for (int i2 = 0; i2 < size; i2++) {
            bVarArr[i2] = b.getInstance(this.f13492f.getObjectAt(i2));
        }
        return bVarArr;
    }

    public g.a.a.y3.a getSignature() {
        return this.f13488b;
    }

    public p getThisUpdate() {
        return this.f13490d;
    }

    public g.a.a.q getVersion() {
        return this.f13487a;
    }

    public int getVersionNumber() {
        g.a.a.q qVar = this.f13487a;
        if (qVar == null) {
            return 1;
        }
        return qVar.intValueExact() + 1;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(7);
        g.a.a.q qVar = this.f13487a;
        if (qVar != null) {
            hVar.add(qVar);
        }
        hVar.add(this.f13488b);
        hVar.add(this.f13489c);
        hVar.add(this.f13490d);
        p pVar = this.f13491e;
        if (pVar != null) {
            hVar.add(pVar);
        }
        d0 d0Var = this.f13492f;
        if (d0Var != null) {
            hVar.add(d0Var);
        }
        f fVar = this.f13493g;
        if (fVar != null) {
            hVar.add(new e2(0, fVar));
        }
        return new b2(hVar);
    }
}
