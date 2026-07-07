package g.a.i.b.i;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[][] f14494a;

    public n(m mVar, byte[][] bArr) {
        Objects.requireNonNull(mVar, "params == null");
        Objects.requireNonNull(bArr, "publicKey == null");
        if (a0.hasNullPointer(bArr)) {
            throw new NullPointerException("publicKey byte array == null");
        }
        if (bArr.length != mVar.a()) {
            throw new IllegalArgumentException("wrong publicKey size");
        }
        for (byte[] bArr2 : bArr) {
            if (bArr2.length != mVar.b()) {
                throw new IllegalArgumentException("wrong publicKey format");
            }
        }
        this.f14494a = a0.cloneArray(bArr);
    }

    public byte[][] a() {
        return a0.cloneArray(this.f14494a);
    }
}
