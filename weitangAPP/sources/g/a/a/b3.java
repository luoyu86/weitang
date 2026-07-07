package g.a.a;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class b3 extends d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f13047c;

    public b3(byte[] bArr) throws IOException {
        Objects.requireNonNull(bArr, "'encoded' cannot be null");
        this.f13047c = bArr;
    }

    @Override // g.a.a.a0
    public void b(y yVar, boolean z) throws IOException {
        byte[] contents = getContents();
        if (contents != null) {
            yVar.m(z, 48, contents);
        } else {
            super.f().b(yVar, z);
        }
    }

    @Override // g.a.a.a0
    public int d(boolean z) throws IOException {
        byte[] contents = getContents();
        return contents != null ? y.e(z, contents.length) : super.f().d(z);
    }

    @Override // g.a.a.d0, g.a.a.a0
    public a0 e() {
        n();
        return super.e();
    }

    @Override // g.a.a.d0, g.a.a.a0
    public a0 f() {
        n();
        return super.f();
    }

    public final synchronized byte[] getContents() {
        return this.f13047c;
    }

    @Override // g.a.a.d0
    public g getObjectAt(int i2) {
        n();
        return super.getObjectAt(i2);
    }

    @Override // g.a.a.d0
    public Enumeration getObjects() {
        byte[] contents = getContents();
        return contents != null ? new a3(contents) : super.getObjects();
    }

    @Override // g.a.a.d0, g.a.a.a0, g.a.a.t
    public int hashCode() {
        n();
        return super.hashCode();
    }

    @Override // g.a.a.d0
    public c i() {
        return ((d0) f()).i();
    }

    @Override // g.a.a.d0, java.lang.Iterable
    public Iterator<g> iterator() {
        n();
        return super.iterator();
    }

    @Override // g.a.a.d0
    public k j() {
        return ((d0) f()).j();
    }

    @Override // g.a.a.d0
    public w k() {
        return ((d0) f()).k();
    }

    @Override // g.a.a.d0
    public f0 l() {
        return ((d0) f()).l();
    }

    public final synchronized void n() {
        if (this.f13047c != null) {
            p pVar = new p(this.f13047c, true);
            try {
                h hVarL = pVar.l();
                pVar.close();
                this.f13059b = hVarL.e();
                this.f13047c = null;
            } catch (IOException e2) {
                throw new z("malformed ASN.1: " + e2, e2);
            }
        }
    }

    @Override // g.a.a.d0
    public int size() {
        n();
        return super.size();
    }

    @Override // g.a.a.d0
    public g[] toArray() {
        n();
        return super.toArray();
    }
}
