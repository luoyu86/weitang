package g.a.i.b.b;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class j implements g.a.j.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f14318a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14319b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14320c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f14321d;

    public j(h hVar, byte[] bArr, int i2, byte[] bArr2) {
        this.f14318a = hVar;
        this.f14319b = bArr;
        this.f14320c = i2;
        this.f14321d = bArr2;
    }

    public static j getInstance(Object obj) throws Exception {
        DataInputStream dataInputStream;
        if (obj instanceof j) {
            return (j) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream2 = (DataInputStream) obj;
            h parametersForType = h.getParametersForType(dataInputStream2.readInt());
            byte[] bArr = new byte[16];
            dataInputStream2.readFully(bArr);
            int i2 = dataInputStream2.readInt();
            byte[] bArr2 = new byte[parametersForType.getN()];
            dataInputStream2.readFully(bArr2);
            return new j(parametersForType, bArr, i2, bArr2);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return getInstance(g.a.j.s.b.readAll((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream3 = null;
        try {
            dataInputStream = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
        } catch (Throwable th) {
            th = th;
        }
        try {
            j jVar = getInstance(dataInputStream);
            dataInputStream.close();
            return jVar;
        } catch (Throwable th2) {
            th = th2;
            dataInputStream3 = dataInputStream;
            if (dataInputStream3 != null) {
                dataInputStream3.close();
            }
            throw th;
        }
    }

    public m a(k kVar) {
        g.a.d.e eVarA = b.a(this.f14318a.getDigestOID());
        w.b(this.f14319b, eVarA);
        w.e(this.f14320c, eVarA);
        w.d((short) -32383, eVarA);
        w.b(kVar.getC(), eVarA);
        return new m(this, kVar, eVarA);
    }

    public m b(s sVar) {
        g.a.d.e eVarA = b.a(this.f14318a.getDigestOID());
        w.b(this.f14319b, eVarA);
        w.e(this.f14320c, eVarA);
        w.d((short) -32383, eVarA);
        w.b(sVar.getOtsSignature().getC(), eVarA);
        return new m(this, sVar, eVarA);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f14320c != jVar.f14320c) {
            return false;
        }
        h hVar = this.f14318a;
        if (hVar == null ? jVar.f14318a != null : !hVar.equals(jVar.f14318a)) {
            return false;
        }
        if (Arrays.equals(this.f14319b, jVar.f14319b)) {
            return Arrays.equals(this.f14321d, jVar.f14321d);
        }
        return false;
    }

    @Override // g.a.j.d
    public byte[] getEncoded() throws IOException {
        return a.compose().u32str(this.f14318a.getType()).bytes(this.f14319b).u32str(this.f14320c).bytes(this.f14321d).build();
    }

    public byte[] getI() {
        return this.f14319b;
    }

    public byte[] getK() {
        return this.f14321d;
    }

    public h getParameter() {
        return this.f14318a;
    }

    public int getQ() {
        return this.f14320c;
    }

    public int hashCode() {
        h hVar = this.f14318a;
        return ((((((hVar != null ? hVar.hashCode() : 0) * 31) + Arrays.hashCode(this.f14319b)) * 31) + this.f14320c) * 31) + Arrays.hashCode(this.f14321d);
    }
}
