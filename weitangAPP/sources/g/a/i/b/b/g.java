package g.a.i.b.b;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class g implements g.a.j.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t[] f14303b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f14304c;

    public g(int i2, t[] tVarArr, s sVar) {
        this.f14302a = i2;
        this.f14303b = tVarArr;
        this.f14304c = sVar;
    }

    public static g getInstance(Object obj, int i2) throws Throwable {
        DataInputStream dataInputStream;
        if (obj instanceof g) {
            return (g) obj;
        }
        if (obj instanceof DataInputStream) {
            int i3 = ((DataInputStream) obj).readInt();
            if (i3 != i2 - 1) {
                throw new IllegalStateException("nspk exceeded maxNspk");
            }
            t[] tVarArr = new t[i3];
            if (i3 != 0) {
                for (int i4 = 0; i4 < i3; i4++) {
                    tVarArr[i4] = new t(s.getInstance(obj), r.getInstance(obj));
                }
            }
            return new g(i3, tVarArr, s.getInstance(obj));
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return getInstance(g.a.j.s.b.readAll((InputStream) obj), i2);
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
            g gVar = getInstance(dataInputStream, i2);
            dataInputStream.close();
            return gVar;
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
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f14302a != gVar.f14302a || this.f14303b.length != gVar.f14303b.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            t[] tVarArr = this.f14303b;
            if (i2 >= tVarArr.length) {
                s sVar = this.f14304c;
                s sVar2 = gVar.f14304c;
                return sVar != null ? sVar.equals(sVar2) : sVar2 == null;
            }
            if (!tVarArr[i2].equals(gVar.f14303b[i2])) {
                return false;
            }
            i2++;
        }
    }

    @Override // g.a.j.d
    public byte[] getEncoded() throws IOException {
        a aVarCompose = a.compose();
        aVarCompose.u32str(this.f14302a);
        t[] tVarArr = this.f14303b;
        if (tVarArr != null) {
            for (t tVar : tVarArr) {
                aVarCompose.bytes(tVar);
            }
        }
        aVarCompose.bytes(this.f14304c);
        return aVarCompose.build();
    }

    public s getSignature() {
        return this.f14304c;
    }

    public t[] getSignedPubKey() {
        return this.f14303b;
    }

    public int getlMinus1() {
        return this.f14302a;
    }

    public int hashCode() {
        int iHashCode = ((this.f14302a * 31) + Arrays.hashCode(this.f14303b)) * 31;
        s sVar = this.f14304c;
        return iHashCode + (sVar != null ? sVar.hashCode() : 0);
    }
}
