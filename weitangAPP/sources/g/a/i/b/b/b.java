package g.a.i.b.b;

import g.a.a.a0;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, g.a.a.v> f14290a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<g.a.a.v, String> f14291b = new HashMap();

    static {
        Map<String, g.a.a.v> map = f14290a;
        g.a.a.v vVar = g.a.a.q3.b.f13301c;
        map.put(MessageDigestAlgorithms.SHA_256, vVar);
        Map<String, g.a.a.v> map2 = f14290a;
        g.a.a.v vVar2 = g.a.a.q3.b.f13303e;
        map2.put(MessageDigestAlgorithms.SHA_512, vVar2);
        Map<String, g.a.a.v> map3 = f14290a;
        g.a.a.v vVar3 = g.a.a.q3.b.m;
        map3.put("SHAKE128", vVar3);
        Map<String, g.a.a.v> map4 = f14290a;
        g.a.a.v vVar4 = g.a.a.q3.b.n;
        map4.put("SHAKE256", vVar4);
        f14291b.put(vVar, MessageDigestAlgorithms.SHA_256);
        f14291b.put(vVar2, MessageDigestAlgorithms.SHA_512);
        f14291b.put(vVar3, "SHAKE128");
        f14291b.put(vVar4, "SHAKE256");
    }

    public static g.a.d.e a(g.a.a.v vVar) {
        if (vVar.equals((a0) g.a.a.q3.b.f13301c)) {
            return new g.a.d.j.g();
        }
        if (vVar.equals((a0) g.a.a.q3.b.f13303e)) {
            return new g.a.d.j.j();
        }
        if (vVar.equals((a0) g.a.a.q3.b.m)) {
            return new g.a.d.j.l(128);
        }
        if (vVar.equals((a0) g.a.a.q3.b.n)) {
            return new g.a.d.j.l(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + vVar);
    }

    public static int getDigestSize(g.a.d.e eVar) {
        boolean z = eVar instanceof g.a.d.i;
        int digestSize = eVar.getDigestSize();
        return z ? digestSize * 2 : digestSize;
    }
}
