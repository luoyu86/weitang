package g.a.a.z3;

import g.a.a.v;
import java.util.Enumeration;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static void a(Vector vector, Enumeration enumeration) {
        while (enumeration.hasMoreElements()) {
            vector.addElement(enumeration.nextElement());
        }
    }

    public static e getByName(String str) {
        e byName = b.getByName(str);
        if (byName == null) {
            byName = g.a.a.v3.a.getByName(str);
        }
        if (byName == null) {
            byName = g.a.a.q3.a.getByName(str);
        }
        if (byName == null) {
            byName = g.a.a.w3.a.getByName(str);
        }
        if (byName == null) {
            byName = g.a.a.f3.a.getByName(str);
        }
        if (byName == null) {
            byName = g.a.a.k3.b.getByNameX9(str);
        }
        return byName == null ? g.a.a.n3.a.getByName(str) : byName;
    }

    public static e getByOID(v vVar) {
        e byOID = b.getByOID(vVar);
        if (byOID == null) {
            byOID = g.a.a.v3.a.getByOID(vVar);
        }
        if (byOID == null) {
            byOID = g.a.a.w3.a.getByOID(vVar);
        }
        if (byOID == null) {
            byOID = g.a.a.f3.a.getByOID(vVar);
        }
        if (byOID == null) {
            byOID = g.a.a.k3.b.getByOIDX9(vVar);
        }
        return byOID == null ? g.a.a.n3.a.getByOID(vVar) : byOID;
    }

    public static String getName(v vVar) {
        String name = b.getName(vVar);
        if (name == null) {
            name = g.a.a.v3.a.getName(vVar);
        }
        if (name == null) {
            name = g.a.a.q3.a.getName(vVar);
        }
        if (name == null) {
            name = g.a.a.w3.a.getName(vVar);
        }
        if (name == null) {
            name = g.a.a.f3.a.getName(vVar);
        }
        if (name == null) {
            name = g.a.a.k3.b.getName(vVar);
        }
        if (name == null) {
            name = g.a.a.n3.a.getName(vVar);
        }
        return name == null ? g.a.d.k.a.getName(vVar) : name;
    }

    public static Enumeration getNames() {
        Vector vector = new Vector();
        a(vector, b.getNames());
        a(vector, g.a.a.v3.a.getNames());
        a(vector, g.a.a.q3.a.getNames());
        a(vector, g.a.a.w3.a.getNames());
        a(vector, g.a.a.f3.a.getNames());
        a(vector, g.a.a.k3.b.getNames());
        a(vector, g.a.a.n3.a.getNames());
        return vector.elements();
    }

    public static v getOID(String str) {
        v oid = b.getOID(str);
        if (oid == null) {
            oid = g.a.a.v3.a.getOID(str);
        }
        if (oid == null) {
            oid = g.a.a.q3.a.getOID(str);
        }
        if (oid == null) {
            oid = g.a.a.w3.a.getOID(str);
        }
        if (oid == null) {
            oid = g.a.a.f3.a.getOID(str);
        }
        if (oid == null) {
            oid = g.a.a.k3.b.getOID(str);
        }
        if (oid == null) {
            oid = g.a.a.n3.a.getOID(str);
        }
        return (oid == null && str.equals("curve25519")) ? g.a.a.j3.a.f13190c : oid;
    }
}
