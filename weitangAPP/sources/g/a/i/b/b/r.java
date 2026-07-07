package g.a.i.b.b;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class r extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f14344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f14345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f14346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f14347e;

    public r(u uVar, h hVar, byte[] bArr, byte[] bArr2) {
        super(false);
        this.f14344b = uVar;
        this.f14345c = hVar;
        this.f14346d = g.a.j.a.clone(bArr2);
        this.f14347e = g.a.j.a.clone(bArr);
    }

    public static r getInstance(Object obj) throws Throwable {
        DataInputStream dataInputStream;
        if (obj instanceof r) {
            return (r) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream2 = (DataInputStream) obj;
            u uVarB = u.b(dataInputStream2.readInt());
            h parametersForType = h.getParametersForType(dataInputStream2.readInt());
            byte[] bArr = new byte[16];
            dataInputStream2.readFully(bArr);
            byte[] bArr2 = new byte[uVarB.getM()];
            dataInputStream2.readFully(bArr2);
            return new r(uVarB, parametersForType, bArr2, bArr);
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
            r rVar = getInstance(dataInputStream);
            dataInputStream.close();
            return rVar;
        } catch (Throwable th2) {
            th = th2;
            dataInputStream3 = dataInputStream;
            if (dataInputStream3 != null) {
                dataInputStream3.close();
            }
            throw th;
        }
    }

    public m a(s sVar) {
        int type = getOtsParameters().getType();
        if (sVar.getOtsSignature().getType().getType() == type) {
            return new j(h.getParametersForType(type), this.f14346d, sVar.getQ(), null).b(sVar);
        }
        throw new IllegalArgumentException("ots type from lsm signature does not match ots signature type from embedded ots signature");
    }

    public boolean b(byte[] bArr) {
        return g.a.j.a.constantTimeAreEqual(this.f14347e, bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || r.class != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f14344b.equals(rVar.f14344b) && this.f14345c.equals(rVar.f14345c) && g.a.j.a.areEqual(this.f14346d, rVar.f14346d)) {
            return g.a.j.a.areEqual(this.f14347e, rVar.f14347e);
        }
        return false;
    }

    public m generateLMSContext(byte[] bArr) {
        try {
            return a(s.getInstance(bArr));
        } catch (IOException e2) {
            throw new IllegalStateException("cannot parse signature: " + e2.getMessage());
        }
    }

    @Override // g.a.i.b.b.o, g.a.j.d
    public byte[] getEncoded() throws IOException {
        return toByteArray();
    }

    public byte[] getI() {
        return g.a.j.a.clone(this.f14346d);
    }

    public p getLMSParameters() {
        return new p(getSigParameters(), getOtsParameters());
    }

    public h getOtsParameters() {
        return this.f14345c;
    }

    public u getSigParameters() {
        return this.f14344b;
    }

    public byte[] getT1() {
        return g.a.j.a.clone(this.f14347e);
    }

    public int hashCode() {
        return (((((this.f14344b.hashCode() * 31) + this.f14345c.hashCode()) * 31) + g.a.j.a.hashCode(this.f14346d)) * 31) + g.a.j.a.hashCode(this.f14347e);
    }

    public byte[] toByteArray() {
        return a.compose().u32str(this.f14344b.getType()).u32str(this.f14345c.getType()).bytes(this.f14346d).bytes(this.f14347e).build();
    }

    public boolean verify(m mVar) {
        return l.verifySignature(this, mVar);
    }
}
