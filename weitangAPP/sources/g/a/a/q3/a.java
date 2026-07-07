package g.a.a.q3;

import g.a.a.v;
import g.a.a.z3.e;
import g.a.j.q;
import java.util.Enumeration;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Hashtable f13297a = new Hashtable();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Hashtable f13298b = new Hashtable();

    static {
        a("B-571", g.a.a.v3.b.F);
        a("B-409", g.a.a.v3.b.D);
        a("B-283", g.a.a.v3.b.n);
        a("B-233", g.a.a.v3.b.t);
        a("B-163", g.a.a.v3.b.l);
        a("K-571", g.a.a.v3.b.E);
        a("K-409", g.a.a.v3.b.C);
        a("K-283", g.a.a.v3.b.m);
        a("K-233", g.a.a.v3.b.s);
        a("K-163", g.a.a.v3.b.f13382b);
        a("P-521", g.a.a.v3.b.B);
        a("P-384", g.a.a.v3.b.A);
        a("P-256", g.a.a.v3.b.H);
        a("P-224", g.a.a.v3.b.z);
        a("P-192", g.a.a.v3.b.G);
    }

    public static void a(String str, v vVar) {
        f13297a.put(str, vVar);
        f13298b.put(vVar, str);
    }

    public static e getByName(String str) {
        v vVar = (v) f13297a.get(q.toUpperCase(str));
        if (vVar != null) {
            return getByOID(vVar);
        }
        return null;
    }

    public static e getByOID(v vVar) {
        return g.a.a.v3.a.getByOID(vVar);
    }

    public static String getName(v vVar) {
        return (String) f13298b.get(vVar);
    }

    public static Enumeration getNames() {
        return f13297a.keys();
    }

    public static v getOID(String str) {
        return (v) f13297a.get(q.toUpperCase(str));
    }
}
