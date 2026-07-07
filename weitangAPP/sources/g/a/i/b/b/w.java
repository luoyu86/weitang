package g.a.i.b.b;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class w {
    public static void a(byte[] bArr, int i2, int i3, g.a.d.e eVar) {
        eVar.update(bArr, i2, i3);
    }

    public static void b(byte[] bArr, g.a.d.e eVar) {
        eVar.update(bArr, 0, bArr.length);
    }

    public static int c(p pVar) {
        Objects.requireNonNull(pVar, "lmsParameters cannot be null");
        u lMSigParam = pVar.getLMSigParam();
        return (1 << lMSigParam.getH()) * lMSigParam.getM();
    }

    public static void d(short s, g.a.d.e eVar) {
        eVar.update((byte) (s >>> 8));
        eVar.update((byte) s);
    }

    public static void e(int i2, g.a.d.e eVar) {
        eVar.update((byte) (i2 >>> 24));
        eVar.update((byte) (i2 >>> 16));
        eVar.update((byte) (i2 >>> 8));
        eVar.update((byte) i2);
    }
}
