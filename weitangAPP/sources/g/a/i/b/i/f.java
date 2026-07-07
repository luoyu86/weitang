package g.a.i.b.i;

import java.util.HashMap;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes3.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, g.a.a.v> f14459a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<g.a.a.v, String> f14460b = new HashMap();

    static {
        Map<String, g.a.a.v> map = f14459a;
        g.a.a.v vVar = g.a.a.q3.b.f13301c;
        map.put(MessageDigestAlgorithms.SHA_256, vVar);
        Map<String, g.a.a.v> map2 = f14459a;
        g.a.a.v vVar2 = g.a.a.q3.b.f13303e;
        map2.put(MessageDigestAlgorithms.SHA_512, vVar2);
        Map<String, g.a.a.v> map3 = f14459a;
        g.a.a.v vVar3 = g.a.a.q3.b.m;
        map3.put("SHAKE128", vVar3);
        Map<String, g.a.a.v> map4 = f14459a;
        g.a.a.v vVar4 = g.a.a.q3.b.n;
        map4.put("SHAKE256", vVar4);
        f14460b.put(vVar, MessageDigestAlgorithms.SHA_256);
        f14460b.put(vVar2, MessageDigestAlgorithms.SHA_512);
        f14460b.put(vVar3, "SHAKE128");
        f14460b.put(vVar4, "SHAKE256");
    }

    public static g.a.d.e a(g.a.a.v vVar) {
        if (vVar.equals((g.a.a.a0) g.a.a.q3.b.f13301c)) {
            return new g.a.d.j.g();
        }
        if (vVar.equals((g.a.a.a0) g.a.a.q3.b.f13303e)) {
            return new g.a.d.j.j();
        }
        if (vVar.equals((g.a.a.a0) g.a.a.q3.b.m)) {
            return new g.a.d.j.l(128);
        }
        if (vVar.equals((g.a.a.a0) g.a.a.q3.b.n)) {
            return new g.a.d.j.l(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + vVar);
    }

    public static String b(g.a.a.v vVar) {
        String str = f14460b.get(vVar);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("unrecognized digest oid: " + vVar);
    }

    public static g.a.a.v c(String str) {
        g.a.a.v vVar = f14459a.get(str);
        if (vVar != null) {
            return vVar;
        }
        throw new IllegalArgumentException("unrecognized digest name: " + str);
    }

    public static int getDigestSize(g.a.d.e eVar) {
        boolean z = eVar instanceof g.a.d.i;
        int digestSize = eVar.getDigestSize();
        return z ? digestSize * 2 : digestSize;
    }
}
