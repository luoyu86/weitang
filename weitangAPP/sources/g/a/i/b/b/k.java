package g.a.i.b.b;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class k implements g.a.j.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f14322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f14324c;

    public k(h hVar, byte[] bArr, byte[] bArr2) {
        this.f14322a = hVar;
        this.f14323b = bArr;
        this.f14324c = bArr2;
    }

    public static k getInstance(Object obj) throws Throwable {
        DataInputStream dataInputStream;
        if (obj instanceof k) {
            return (k) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream2 = (DataInputStream) obj;
            h parametersForType = h.getParametersForType(dataInputStream2.readInt());
            byte[] bArr = new byte[parametersForType.getN()];
            dataInputStream2.readFully(bArr);
            byte[] bArr2 = new byte[parametersForType.getP() * parametersForType.getN()];
            dataInputStream2.readFully(bArr2);
            return new k(parametersForType, bArr, bArr2);
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
            k kVar = getInstance(dataInputStream);
            dataInputStream.close();
            return kVar;
        } catch (Throwable th2) {
            th = th2;
            dataInputStream3 = dataInputStream;
            if (dataInputStream3 != null) {
                dataInputStream3.close();
            }
            throw th;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        h hVar = this.f14322a;
        if (hVar == null ? kVar.f14322a != null : !hVar.equals(kVar.f14322a)) {
            return false;
        }
        if (Arrays.equals(this.f14323b, kVar.f14323b)) {
            return Arrays.equals(this.f14324c, kVar.f14324c);
        }
        return false;
    }

    public byte[] getC() {
        return this.f14323b;
    }

    @Override // g.a.j.d
    public byte[] getEncoded() throws IOException {
        return a.compose().u32str(this.f14322a.getType()).bytes(this.f14323b).bytes(this.f14324c).build();
    }

    public h getType() {
        return this.f14322a;
    }

    public byte[] getY() {
        return this.f14324c;
    }

    public int hashCode() {
        h hVar = this.f14322a;
        return ((((hVar != null ? hVar.hashCode() : 0) * 31) + Arrays.hashCode(this.f14323b)) * 31) + Arrays.hashCode(this.f14324c);
    }
}
