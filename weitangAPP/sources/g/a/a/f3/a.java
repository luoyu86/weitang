package g.a.a.f3;

import g.a.a.v;
import g.a.a.z3.e;
import g.a.a.z3.f;
import g.a.a.z3.g;
import g.a.g.a.e;
import g.a.g.a.x;
import g.a.j.q;
import g.a.j.r.c;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static f f13081a = new C0246a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Hashtable f13082b = new Hashtable();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Hashtable f13083c = new Hashtable();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Hashtable f13084d = new Hashtable();

    /* JADX INFO: renamed from: g.a.a.f3.a$a, reason: collision with other inner class name */
    public static class C0246a extends f {
        @Override // g.a.a.z3.f
        public e a() {
            BigInteger bigIntegerG = a.g("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C03");
            BigInteger bigIntegerG2 = a.g("F1FD178C0B3AD58F10126DE8CE42435B3961ADBCABC8CA6DE8FCF353D86E9C00");
            BigInteger bigIntegerG3 = a.g("EE353FCA5428A9300D4ABA754A44C00FDFEC0C9AE4B1A1803075ED967B7BB73F");
            BigInteger bigIntegerG4 = a.g("F1FD178C0B3AD58F10126DE8CE42435B53DC67E140D2BF941FFDD459C6D655E1");
            BigInteger bigIntegerValueOf = BigInteger.valueOf(1L);
            g.a.g.a.e eVarE = a.e(new e.f(bigIntegerG, bigIntegerG2, bigIntegerG3, bigIntegerG4, bigIntegerValueOf));
            return new g.a.a.z3.e(eVarE, a.d(eVarE, "04B6B3D4C356C139EB31183D4749D423958C27D2DCAF98B70164C97A2DD98F5CFF6142E0F7C8B204911F9271F0F3ECEF8C2701C307E8E4C9E183115A1554062CFB"), bigIntegerG4, bigIntegerValueOf, null);
        }
    }

    static {
        f("FRP256v1", b.f13085a, f13081a);
    }

    public static g d(g.a.g.a.e eVar, String str) {
        g gVar = new g(eVar, c.decodeStrict(str));
        x.configureBasepoint(gVar.getPoint());
        return gVar;
    }

    public static g.a.g.a.e e(g.a.g.a.e eVar) {
        return eVar;
    }

    public static void f(String str, v vVar, f fVar) {
        f13082b.put(q.toLowerCase(str), vVar);
        f13084d.put(vVar, str);
        f13083c.put(vVar, fVar);
    }

    public static BigInteger g(String str) {
        return new BigInteger(1, c.decodeStrict(str));
    }

    public static g.a.a.z3.e getByName(String str) {
        v oid = getOID(str);
        if (oid == null) {
            return null;
        }
        return getByOID(oid);
    }

    public static g.a.a.z3.e getByOID(v vVar) {
        f fVar = (f) f13083c.get(vVar);
        if (fVar == null) {
            return null;
        }
        return fVar.getParameters();
    }

    public static String getName(v vVar) {
        return (String) f13084d.get(vVar);
    }

    public static Enumeration getNames() {
        return f13084d.elements();
    }

    public static v getOID(String str) {
        return (v) f13082b.get(q.toLowerCase(str));
    }
}
