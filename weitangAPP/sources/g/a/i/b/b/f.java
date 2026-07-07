package g.a.i.b.b;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public class f extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14300b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r f14301c;

    public f(int i2, r rVar) {
        super(false);
        this.f14300b = i2;
        this.f14301c = rVar;
    }

    public static f getInstance(Object obj) throws Throwable {
        DataInputStream dataInputStream;
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj instanceof DataInputStream) {
            return new f(((DataInputStream) obj).readInt(), r.getInstance(obj));
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return getInstance(g.a.j.s.b.readAll((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            dataInputStream = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
        } catch (Throwable th) {
            th = th;
        }
        try {
            f fVar = getInstance(dataInputStream);
            dataInputStream.close();
            return fVar;
        } catch (Throwable th2) {
            th = th2;
            dataInputStream2 = dataInputStream;
            if (dataInputStream2 != null) {
                dataInputStream2.close();
            }
            throw th;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f14300b != fVar.f14300b) {
            return false;
        }
        return this.f14301c.equals(fVar.f14301c);
    }

    public m generateLMSContext(byte[] bArr) throws Throwable {
        try {
            g gVar = g.getInstance(bArr, getL());
            t[] signedPubKey = gVar.getSignedPubKey();
            return signedPubKey[signedPubKey.length - 1].getPublicKey().a(gVar.getSignature()).g(signedPubKey);
        } catch (IOException e2) {
            throw new IllegalStateException("cannot parse signature: " + e2.getMessage());
        }
    }

    @Override // g.a.i.b.b.o, g.a.j.d
    public byte[] getEncoded() throws IOException {
        return a.compose().u32str(this.f14300b).bytes(this.f14301c.getEncoded()).build();
    }

    public int getL() {
        return this.f14300b;
    }

    public r getLMSPublicKey() {
        return this.f14301c;
    }

    public int hashCode() {
        return (this.f14300b * 31) + this.f14301c.hashCode();
    }

    public boolean verify(m mVar) {
        t[] tVarArrF = mVar.f();
        if (tVarArrF.length != getL() - 1) {
            return false;
        }
        r lMSPublicKey = getLMSPublicKey();
        boolean z = false;
        for (int i2 = 0; i2 < tVarArrF.length; i2++) {
            if (!l.verifySignature(lMSPublicKey, tVarArrF[i2].getSignature(), tVarArrF[i2].getPublicKey().toByteArray())) {
                z = true;
            }
            lMSPublicKey = tVarArrF[i2].getPublicKey();
        }
        return lMSPublicKey.verify(mVar) & (!z);
    }
}
