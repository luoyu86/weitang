package g.a.a.n3;

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
    public static f f13254a = new C0247a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static f f13255b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Hashtable f13256c = new Hashtable();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Hashtable f13257d = new Hashtable();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Hashtable f13258e = new Hashtable();

    /* JADX INFO: renamed from: g.a.a.n3.a$a, reason: collision with other inner class name */
    public static class C0247a extends f {
        @Override // g.a.a.z3.f
        public e a() {
            BigInteger bigIntegerG = a.g("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF");
            BigInteger bigIntegerG2 = a.g("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC");
            BigInteger bigIntegerG3 = a.g("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93");
            BigInteger bigIntegerG4 = a.g("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123");
            BigInteger bigIntegerValueOf = BigInteger.valueOf(1L);
            g.a.g.a.e eVarE = a.e(new e.f(bigIntegerG, bigIntegerG2, bigIntegerG3, bigIntegerG4, bigIntegerValueOf));
            return new g.a.a.z3.e(eVarE, a.d(eVarE, "0432C4AE2C1F1981195F9904466A39C9948FE30BBFF2660BE1715A4589334C74C7BC3736A2F4F6779C59BDCEE36B692153D0A9877CC62A474002DF32E52139F0A0"), bigIntegerG4, bigIntegerValueOf, null);
        }
    }

    public static class b extends f {
        @Override // g.a.a.z3.f
        public g.a.a.z3.e a() {
            BigInteger bigIntegerG = a.g("BDB6F4FE3E8B1D9E0DA8C0D46F4C318CEFE4AFE3B6B8551F");
            BigInteger bigIntegerG2 = a.g("BB8E5E8FBC115E139FE6A814FE48AAA6F0ADA1AA5DF91985");
            BigInteger bigIntegerG3 = a.g("1854BEBDC31B21B7AEFC80AB0ECD10D5B1B3308E6DBF11C1");
            BigInteger bigIntegerG4 = a.g("BDB6F4FE3E8B1D9E0DA8C0D40FC962195DFAE76F56564677");
            BigInteger bigIntegerValueOf = BigInteger.valueOf(1L);
            g.a.g.a.e eVarE = a.e(new e.f(bigIntegerG, bigIntegerG2, bigIntegerG3, bigIntegerG4, bigIntegerValueOf));
            return new g.a.a.z3.e(eVarE, a.d(eVarE, "044AD5F7048DE709AD51236DE65E4D4B482C836DC6E410664002BB3A02D4AAADACAE24817A4CA3A1B014B5270432DB27D2"), bigIntegerG4, bigIntegerValueOf, null);
        }
    }

    static {
        f("wapip192v1", g.a.a.n3.b.J, f13255b);
        f("sm2p256v1", g.a.a.n3.b.F, f13254a);
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
        f13256c.put(q.toLowerCase(str), vVar);
        f13258e.put(vVar, str);
        f13257d.put(vVar, fVar);
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
        f fVar = (f) f13257d.get(vVar);
        if (fVar == null) {
            return null;
        }
        return fVar.getParameters();
    }

    public static String getName(v vVar) {
        return (String) f13258e.get(vVar);
    }

    public static Enumeration getNames() {
        return f13258e.elements();
    }

    public static v getOID(String str) {
        return (v) f13256c.get(q.toLowerCase(str));
    }
}
