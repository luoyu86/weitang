package g.a.j;

/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static char[] f14657a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14658b;

    public e(byte[] bArr) {
        this(bArr, 160);
    }

    public e(byte[] bArr, int i2) {
        this.f14658b = calculateFingerprint(bArr, i2);
    }

    public e(byte[] bArr, boolean z) {
        if (z) {
            this.f14658b = calculateFingerprintSHA512_160(bArr);
        } else {
            this.f14658b = calculateFingerprint(bArr);
        }
    }

    public static byte[] calculateFingerprint(byte[] bArr) {
        return calculateFingerprint(bArr, 160);
    }

    public static byte[] calculateFingerprint(byte[] bArr, int i2) {
        if (i2 % 8 != 0) {
            throw new IllegalArgumentException("bitLength must be a multiple of 8");
        }
        g.a.d.j.l lVar = new g.a.d.j.l(256);
        lVar.update(bArr, 0, bArr.length);
        int i3 = i2 / 8;
        byte[] bArr2 = new byte[i3];
        lVar.doFinal(bArr2, 0, i3);
        return bArr2;
    }

    public static byte[] calculateFingerprintSHA512_160(byte[] bArr) {
        g.a.d.j.k kVar = new g.a.d.j.k(160);
        kVar.update(bArr, 0, bArr.length);
        byte[] bArr2 = new byte[kVar.getDigestSize()];
        kVar.doFinal(bArr2, 0);
        return bArr2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            return a.areEqual(((e) obj).f14658b, this.f14658b);
        }
        return false;
    }

    public byte[] getFingerprint() {
        return a.clone(this.f14658b);
    }

    public int hashCode() {
        return a.hashCode(this.f14658b);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 != this.f14658b.length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(":");
            }
            stringBuffer.append(f14657a[(this.f14658b[i2] >>> 4) & 15]);
            stringBuffer.append(f14657a[this.f14658b[i2] & 15]);
        }
        return stringBuffer.toString();
    }
}
