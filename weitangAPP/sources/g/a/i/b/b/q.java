package g.a.i.b.b;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class q extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f14335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a[] f14336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f14337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u f14338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f14339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f14340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final byte[] f14341h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<a, byte[]> f14342i;
    public final int j;
    public final g.a.d.e k;
    public int l;
    public r m;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14343a;

        public a(int i2) {
            this.f14343a = i2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && ((a) obj).f14343a == this.f14343a;
        }

        public int hashCode() {
            return this.f14343a;
        }
    }

    static {
        a aVar = new a(1);
        f14335b = aVar;
        a[] aVarArr = new a[TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA];
        f14336c = aVarArr;
        aVarArr[1] = aVar;
        int i2 = 2;
        while (true) {
            a[] aVarArr2 = f14336c;
            if (i2 >= aVarArr2.length) {
                return;
            }
            aVarArr2[i2] = new a(i2);
            i2++;
        }
    }

    public q(q qVar, int i2, int i3) {
        super(true);
        u uVar = qVar.f14338e;
        this.f14338e = uVar;
        this.f14339f = qVar.f14339f;
        this.l = i2;
        this.f14337d = qVar.f14337d;
        this.f14340g = i3;
        this.f14341h = qVar.f14341h;
        this.j = 1 << uVar.getH();
        this.f14342i = qVar.f14342i;
        this.k = b.a(uVar.getDigestOID());
        this.m = qVar.m;
    }

    public q(u uVar, h hVar, int i2, byte[] bArr, int i3, byte[] bArr2) {
        super(true);
        this.f14338e = uVar;
        this.f14339f = hVar;
        this.l = i2;
        this.f14337d = g.a.j.a.clone(bArr);
        this.f14340g = i3;
        this.f14341h = g.a.j.a.clone(bArr2);
        this.j = 1 << (uVar.getH() + 1);
        this.f14342i = new WeakHashMap();
        this.k = b.a(uVar.getDigestOID());
    }

    public static q getInstance(Object obj) throws Throwable {
        if (obj instanceof q) {
            return (q) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            if (dataInputStream.readInt() != 0) {
                throw new IllegalStateException("expected version 0 lms private key");
            }
            u uVarB = u.b(dataInputStream.readInt());
            h parametersForType = h.getParametersForType(dataInputStream.readInt());
            byte[] bArr = new byte[16];
            dataInputStream.readFully(bArr);
            int i2 = dataInputStream.readInt();
            int i3 = dataInputStream.readInt();
            int i4 = dataInputStream.readInt();
            if (i4 < 0) {
                throw new IllegalStateException("secret length less than zero");
            }
            if (i4 <= dataInputStream.available()) {
                byte[] bArr2 = new byte[i4];
                dataInputStream.readFully(bArr2);
                return new q(uVarB, parametersForType, i2, bArr, i3, bArr2);
            }
            throw new IOException("secret length exceeded " + dataInputStream.available());
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return getInstance(g.a.j.s.b.readAll((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                q qVar = getInstance(dataInputStream3);
                dataInputStream3.close();
                return qVar;
            } catch (Throwable th) {
                th = th;
                dataInputStream2 = dataInputStream3;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static q getInstance(byte[] bArr, byte[] bArr2) throws Throwable {
        q qVar = getInstance(bArr);
        qVar.m = r.getInstance(bArr2);
        return qVar;
    }

    public final byte[] a(int i2) {
        int h2 = 1 << getSigParameters().getH();
        if (i2 >= h2) {
            w.b(getI(), this.k);
            w.e(i2, this.k);
            w.d((short) -32126, this.k);
            w.b(v.a(getOtsParameters(), getI(), i2 - h2, getMasterSecret()), this.k);
            byte[] bArr = new byte[this.k.getDigestSize()];
            this.k.doFinal(bArr, 0);
            return bArr;
        }
        int i3 = i2 * 2;
        byte[] bArrB = b(i3);
        byte[] bArrB2 = b(i3 + 1);
        w.b(getI(), this.k);
        w.e(i2, this.k);
        w.d((short) -31869, this.k);
        w.b(bArrB, this.k);
        w.b(bArrB2, this.k);
        byte[] bArr2 = new byte[this.k.getDigestSize()];
        this.k.doFinal(bArr2, 0);
        return bArr2;
    }

    public byte[] b(int i2) {
        if (i2 >= this.j) {
            return a(i2);
        }
        a[] aVarArr = f14336c;
        return c(i2 < aVarArr.length ? aVarArr[i2] : new a(i2));
    }

    public final byte[] c(a aVar) {
        synchronized (this.f14342i) {
            byte[] bArr = this.f14342i.get(aVar);
            if (bArr != null) {
                return bArr;
            }
            byte[] bArrA = a(aVar.f14343a);
            this.f14342i.put(aVar, bArrA);
            return bArrA;
        }
    }

    public i d() {
        i iVar;
        synchronized (this) {
            int i2 = this.l;
            if (i2 >= this.f14340g) {
                throw new g.a.i.b.a("ots private keys expired");
            }
            iVar = new i(this.f14339f, this.f14337d, i2, this.f14341h);
        }
        return iVar;
    }

    public i e() {
        i iVar;
        synchronized (this) {
            int i2 = this.l;
            if (i2 >= this.f14340g) {
                throw new g.a.i.b.a("ots private key exhausted");
            }
            iVar = new i(this.f14339f, this.f14337d, i2, this.f14341h);
            f();
        }
        return iVar;
    }

    public boolean equals(Object obj) {
        r rVar;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (this.l != qVar.l || this.f14340g != qVar.f14340g || !g.a.j.a.areEqual(this.f14337d, qVar.f14337d)) {
            return false;
        }
        u uVar = this.f14338e;
        if (uVar == null ? qVar.f14338e != null : !uVar.equals(qVar.f14338e)) {
            return false;
        }
        h hVar = this.f14339f;
        if (hVar == null ? qVar.f14339f != null : !hVar.equals(qVar.f14339f)) {
            return false;
        }
        if (!g.a.j.a.areEqual(this.f14341h, qVar.f14341h)) {
            return false;
        }
        r rVar2 = this.m;
        if (rVar2 == null || (rVar = qVar.m) == null) {
            return true;
        }
        return rVar2.equals(rVar);
    }

    public q extractKeyShard(int i2) {
        q qVar;
        synchronized (this) {
            int i3 = this.l;
            if (i3 + i2 >= this.f14340g) {
                throw new IllegalArgumentException("usageCount exceeds usages remaining");
            }
            qVar = new q(this, i3, i3 + i2);
            this.l += i2;
        }
        return qVar;
    }

    public synchronized void f() {
        this.l++;
    }

    public m generateLMSContext() {
        int h2 = getSigParameters().getH();
        int index = getIndex();
        i iVarE = e();
        int i2 = (1 << h2) + index;
        byte[][] bArr = new byte[h2][];
        for (int i3 = 0; i3 < h2; i3++) {
            bArr[i3] = b((i2 / (1 << i3)) ^ 1);
        }
        return iVarE.b(getSigParameters(), bArr);
    }

    public byte[] generateSignature(m mVar) {
        try {
            return l.generateSign(mVar).getEncoded();
        } catch (IOException e2) {
            throw new IllegalStateException("unable to encode signature: " + e2.getMessage(), e2);
        }
    }

    @Override // g.a.i.b.b.o, g.a.j.d
    public byte[] getEncoded() throws IOException {
        return g.a.i.b.b.a.compose().u32str(0).u32str(this.f14338e.getType()).u32str(this.f14339f.getType()).bytes(this.f14337d).u32str(this.l).u32str(this.f14340g).u32str(this.f14341h.length).bytes(this.f14341h).build();
    }

    public byte[] getI() {
        return g.a.j.a.clone(this.f14337d);
    }

    public synchronized int getIndex() {
        return this.l;
    }

    public byte[] getMasterSecret() {
        return g.a.j.a.clone(this.f14341h);
    }

    public h getOtsParameters() {
        return this.f14339f;
    }

    public r getPublicKey() {
        r rVar;
        synchronized (this) {
            if (this.m == null) {
                this.m = new r(this.f14338e, this.f14339f, c(f14335b), this.f14337d);
            }
            rVar = this.m;
        }
        return rVar;
    }

    public u getSigParameters() {
        return this.f14338e;
    }

    public long getUsagesRemaining() {
        return this.f14340g - this.l;
    }

    public int hashCode() {
        int iHashCode = ((this.l * 31) + g.a.j.a.hashCode(this.f14337d)) * 31;
        u uVar = this.f14338e;
        int iHashCode2 = (iHashCode + (uVar != null ? uVar.hashCode() : 0)) * 31;
        h hVar = this.f14339f;
        int iHashCode3 = (((((iHashCode2 + (hVar != null ? hVar.hashCode() : 0)) * 31) + this.f14340g) * 31) + g.a.j.a.hashCode(this.f14341h)) * 31;
        r rVar = this.m;
        return iHashCode3 + (rVar != null ? rVar.hashCode() : 0);
    }
}
