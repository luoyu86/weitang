package g.a.e.c;

import java.security.spec.AlgorithmParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
public class d implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f13856a;

    public d(byte[] bArr) {
        this.f13856a = g.a.j.a.clone(bArr);
    }

    public byte[] getUserKeyingMaterial() {
        return g.a.j.a.clone(this.f13856a);
    }
}
