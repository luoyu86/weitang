package g.a.a.y3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.l0;
import g.a.a.n1;
import java.io.IOException;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes2.dex */
public class l extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f13485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g.a.a.c f13486b;

    public l(d0 d0Var) {
        if (d0Var.size() == 2) {
            Enumeration objects = d0Var.getObjects();
            this.f13485a = a.getInstance(objects.nextElement());
            this.f13486b = n1.getInstance(objects.nextElement());
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + d0Var.size());
        }
    }

    public l(a aVar, g.a.a.g gVar) throws IOException {
        this.f13486b = new n1(gVar);
        this.f13485a = aVar;
    }

    public l(a aVar, byte[] bArr) {
        this.f13486b = new n1(bArr);
        this.f13485a = aVar;
    }

    public static l getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static l getInstance(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj != null) {
            return new l(d0.getInstance(obj));
        }
        return null;
    }

    public a getAlgorithm() {
        return this.f13485a;
    }

    public a getAlgorithmId() {
        return this.f13485a;
    }

    public a0 getPublicKey() throws IOException {
        return a0.fromByteArray(this.f13486b.getOctets());
    }

    public g.a.a.c getPublicKeyData() {
        return this.f13486b;
    }

    public a0 parsePublicKey() throws IOException {
        return a0.fromByteArray(this.f13486b.getOctets());
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(2);
        hVar.add(this.f13485a);
        hVar.add(this.f13486b);
        return new b2(hVar);
    }
}
