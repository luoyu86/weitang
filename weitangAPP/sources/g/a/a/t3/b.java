package g.a.a.t3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.e2;
import g.a.a.f0;
import g.a.a.g;
import g.a.a.h;
import g.a.a.l0;
import g.a.a.n1;
import g.a.a.q;
import g.a.a.t;
import g.a.a.w;
import g.a.a.x1;
import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes2.dex */
public class b extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f13331a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.y3.a f13332b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w f13333c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f0 f13334d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g.a.a.c f13335e;

    public b(d0 d0Var) {
        Enumeration objects = d0Var.getObjects();
        q qVar = q.getInstance(objects.nextElement());
        this.f13331a = qVar;
        int iA = a(qVar);
        this.f13332b = g.a.a.y3.a.getInstance(objects.nextElement());
        this.f13333c = w.getInstance(objects.nextElement());
        int i2 = -1;
        while (objects.hasMoreElements()) {
            l0 l0Var = (l0) objects.nextElement();
            int tagNo = l0Var.getTagNo();
            if (tagNo <= i2) {
                throw new IllegalArgumentException("invalid optional field in private key info");
            }
            if (tagNo == 0) {
                this.f13334d = f0.getInstance(l0Var, false);
            } else {
                if (tagNo != 1) {
                    throw new IllegalArgumentException("unknown optional field in private key info");
                }
                if (iA < 1) {
                    throw new IllegalArgumentException("'publicKey' requires version v2(1) or later");
                }
                this.f13335e = n1.getInstance(l0Var, false);
            }
            i2 = tagNo;
        }
    }

    public b(g.a.a.y3.a aVar, g gVar) throws IOException {
        this(aVar, gVar, null, null);
    }

    public b(g.a.a.y3.a aVar, g gVar, f0 f0Var) throws IOException {
        this(aVar, gVar, f0Var, null);
    }

    public b(g.a.a.y3.a aVar, g gVar, f0 f0Var, byte[] bArr) throws IOException {
        this.f13331a = new q(bArr != null ? g.a.j.b.f14651b : g.a.j.b.f14650a);
        this.f13332b = aVar;
        this.f13333c = new x1(gVar);
        this.f13334d = f0Var;
        this.f13335e = bArr == null ? null : new n1(bArr);
    }

    public static int a(q qVar) {
        int iIntValueExact = qVar.intValueExact();
        if (iIntValueExact < 0 || iIntValueExact > 1) {
            throw new IllegalArgumentException("invalid version for private key info");
        }
        return iIntValueExact;
    }

    public static b getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
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

    public f0 getAttributes() {
        return this.f13334d;
    }

    public w getPrivateKey() {
        return new x1(this.f13333c.getOctets());
    }

    public g.a.a.y3.a getPrivateKeyAlgorithm() {
        return this.f13332b;
    }

    public g.a.a.c getPublicKeyData() {
        return this.f13335e;
    }

    public q getVersion() {
        return this.f13331a;
    }

    public boolean hasPublicKey() {
        return this.f13335e != null;
    }

    public g parsePrivateKey() throws IOException {
        return a0.fromByteArray(this.f13333c.getOctets());
    }

    public g parsePublicKey() throws IOException {
        g.a.a.c cVar = this.f13335e;
        if (cVar == null) {
            return null;
        }
        return a0.fromByteArray(cVar.getOctets());
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        h hVar = new h(5);
        hVar.add(this.f13331a);
        hVar.add(this.f13332b);
        hVar.add(this.f13333c);
        f0 f0Var = this.f13334d;
        if (f0Var != null) {
            hVar.add(new e2(false, 0, (g) f0Var));
        }
        g.a.a.c cVar = this.f13335e;
        if (cVar != null) {
            hVar.add(new e2(false, 1, (g) cVar));
        }
        return new b2(hVar);
    }
}
