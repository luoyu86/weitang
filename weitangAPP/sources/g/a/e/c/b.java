package g.a.e.c;

import g.a.a.v;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b implements AlgorithmParameterSpec {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f13843a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f13844b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f13845c;

    static {
        HashMap map = new HashMap();
        f13843a = map;
        map.put(g.a.a.k3.a.f13209h, "E-A");
        f13843a.put(g.a.a.k3.a.f13210i, "E-B");
        f13843a.put(g.a.a.k3.a.j, "E-C");
        f13843a.put(g.a.a.k3.a.k, "E-D");
        f13843a.put(g.a.a.u3.a.t, "Param-Z");
    }

    public b(v vVar, byte[] bArr) {
        this(a(vVar));
        this.f13844b = g.a.j.a.clone(bArr);
    }

    public b(String str) {
        this.f13844b = null;
        this.f13845c = null;
        this.f13845c = g.a.d.l.a.getSBox(str);
    }

    public b(String str, byte[] bArr) {
        this(str);
        byte[] bArr2 = new byte[bArr.length];
        this.f13844b = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public b(byte[] bArr) {
        this.f13844b = null;
        this.f13845c = null;
        byte[] bArr2 = new byte[bArr.length];
        this.f13845c = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
    }

    public b(byte[] bArr, byte[] bArr2) {
        this(bArr);
        byte[] bArr3 = new byte[bArr2.length];
        this.f13844b = bArr3;
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
    }

    public static String a(v vVar) {
        String str = (String) f13843a.get(vVar);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("unknown OID: " + vVar);
    }

    public byte[] getSBox() {
        return g.a.j.a.clone(this.f13845c);
    }

    public byte[] getUKM() {
        return g.a.j.a.clone(this.f13844b);
    }
}
