package g.a.i.b.b;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class s implements g.a.j.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f14349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u f14350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[][] f14351d;

    public s(int i2, k kVar, u uVar, byte[][] bArr) {
        this.f14348a = i2;
        this.f14349b = kVar;
        this.f14350c = uVar;
        this.f14351d = bArr;
    }

    public static s getInstance(Object obj) throws Throwable {
        DataInputStream dataInputStream;
        if (obj instanceof s) {
            return (s) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream2 = (DataInputStream) obj;
            int i2 = dataInputStream2.readInt();
            k kVar = k.getInstance(obj);
            u uVarB = u.b(dataInputStream2.readInt());
            int h2 = uVarB.getH();
            byte[][] bArr = new byte[h2][];
            for (int i3 = 0; i3 < h2; i3++) {
                bArr[i3] = new byte[uVarB.getM()];
                dataInputStream2.readFully(bArr[i3]);
            }
            return new s(i2, kVar, uVarB, bArr);
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
            s sVar = getInstance(dataInputStream);
            dataInputStream.close();
            return sVar;
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
        if (obj == null || s.class != obj.getClass()) {
            return false;
        }
        s sVar = (s) obj;
        if (this.f14348a != sVar.f14348a) {
            return false;
        }
        k kVar = this.f14349b;
        if (kVar == null ? sVar.f14349b != null : !kVar.equals(sVar.f14349b)) {
            return false;
        }
        u uVar = this.f14350c;
        if (uVar == null ? sVar.f14350c == null : uVar.equals(sVar.f14350c)) {
            return Arrays.deepEquals(this.f14351d, sVar.f14351d);
        }
        return false;
    }

    @Override // g.a.j.d
    public byte[] getEncoded() throws IOException {
        return a.compose().u32str(this.f14348a).bytes(this.f14349b.getEncoded()).u32str(this.f14350c.getType()).bytes(this.f14351d).build();
    }

    public k getOtsSignature() {
        return this.f14349b;
    }

    public u getParameter() {
        return this.f14350c;
    }

    public int getQ() {
        return this.f14348a;
    }

    public byte[][] getY() {
        return this.f14351d;
    }

    public int hashCode() {
        int i2 = this.f14348a * 31;
        k kVar = this.f14349b;
        int iHashCode = (i2 + (kVar != null ? kVar.hashCode() : 0)) * 31;
        u uVar = this.f14350c;
        return ((iHashCode + (uVar != null ? uVar.hashCode() : 0)) * 31) + Arrays.deepHashCode(this.f14351d);
    }
}
