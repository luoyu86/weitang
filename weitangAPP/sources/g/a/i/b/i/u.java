package g.a.i.b.i;

import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f14535b;

    public u(int i2, byte[] bArr) {
        this.f14534a = i2;
        this.f14535b = bArr;
    }

    public int getHeight() {
        return this.f14534a;
    }

    public byte[] getValue() {
        return a0.cloneArray(this.f14535b);
    }
}
