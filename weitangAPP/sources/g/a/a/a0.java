package g.a.a;

import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a0 extends t {
    public static a0 fromByteArray(byte[] bArr) throws IOException {
        p pVar = new p(bArr);
        try {
            a0 object = pVar.readObject();
            if (pVar.available() == 0) {
                return object;
            }
            throw new IOException("Extra data detected in stream");
        } catch (ClassCastException unused) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    public abstract boolean a(a0 a0Var);

    public abstract void b(y yVar, boolean z) throws IOException;

    public abstract boolean c();

    public abstract int d(boolean z) throws IOException;

    public a0 e() {
        return this;
    }

    @Override // g.a.a.t
    public void encodeTo(OutputStream outputStream) throws IOException {
        y yVarCreate = y.create(outputStream);
        yVarCreate.s(this, true);
        yVarCreate.a();
    }

    @Override // g.a.a.t
    public void encodeTo(OutputStream outputStream, String str) throws IOException {
        y yVarCreate = y.create(outputStream, str);
        yVarCreate.s(this, true);
        yVarCreate.a();
    }

    public final boolean equals(a0 a0Var) {
        return this == a0Var || a(a0Var);
    }

    public final boolean equals(g gVar) {
        return this == gVar || (gVar != null && a(gVar.toASN1Primitive()));
    }

    @Override // g.a.a.t
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && a(((g) obj).toASN1Primitive());
    }

    public a0 f() {
        return this;
    }

    @Override // g.a.a.t
    public abstract int hashCode();

    @Override // g.a.a.t, g.a.a.g
    public final a0 toASN1Primitive() {
        return this;
    }
}
