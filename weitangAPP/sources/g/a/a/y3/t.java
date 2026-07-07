package g.a.a.y3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.l0;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public class t extends g.a.a.t {
    public Hashtable F;
    public Vector G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g.a.a.v f13532a = new g.a.a.v("2.5.29.9");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g.a.a.v f13533b = new g.a.a.v("2.5.29.14");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g.a.a.v f13534c = new g.a.a.v("2.5.29.15");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g.a.a.v f13535d = new g.a.a.v("2.5.29.16");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g.a.a.v f13536e = new g.a.a.v("2.5.29.17");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g.a.a.v f13537f = new g.a.a.v("2.5.29.18");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g.a.a.v f13538g = new g.a.a.v("2.5.29.19");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g.a.a.v f13539h = new g.a.a.v("2.5.29.20");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g.a.a.v f13540i = new g.a.a.v("2.5.29.21");
    public static final g.a.a.v j = new g.a.a.v("2.5.29.23");
    public static final g.a.a.v k = new g.a.a.v("2.5.29.24");
    public static final g.a.a.v l = new g.a.a.v("2.5.29.27");
    public static final g.a.a.v m = new g.a.a.v("2.5.29.28");
    public static final g.a.a.v n = new g.a.a.v("2.5.29.29");
    public static final g.a.a.v o = new g.a.a.v("2.5.29.30");
    public static final g.a.a.v p = new g.a.a.v("2.5.29.31");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final g.a.a.v f13541q = new g.a.a.v("2.5.29.32");
    public static final g.a.a.v r = new g.a.a.v("2.5.29.33");
    public static final g.a.a.v s = new g.a.a.v("2.5.29.35");
    public static final g.a.a.v t = new g.a.a.v("2.5.29.36");
    public static final g.a.a.v u = new g.a.a.v("2.5.29.37");
    public static final g.a.a.v v = new g.a.a.v("2.5.29.46");
    public static final g.a.a.v w = new g.a.a.v("2.5.29.54");
    public static final g.a.a.v x = new g.a.a.v("1.3.6.1.5.5.7.1.1");
    public static final g.a.a.v y = new g.a.a.v("1.3.6.1.5.5.7.1.11");
    public static final g.a.a.v z = new g.a.a.v("1.3.6.1.5.5.7.1.12");
    public static final g.a.a.v A = new g.a.a.v("1.3.6.1.5.5.7.1.2");
    public static final g.a.a.v B = new g.a.a.v("1.3.6.1.5.5.7.1.3");
    public static final g.a.a.v C = new g.a.a.v("1.3.6.1.5.5.7.1.4");
    public static final g.a.a.v D = new g.a.a.v("2.5.29.56");
    public static final g.a.a.v E = new g.a.a.v("2.5.29.55");

    public t(d0 d0Var) {
        this.F = new Hashtable();
        this.G = new Vector();
        Enumeration objects = d0Var.getObjects();
        while (objects.hasMoreElements()) {
            d0 d0Var2 = d0.getInstance(objects.nextElement());
            if (d0Var2.size() == 3) {
                this.F.put(d0Var2.getObjectAt(0), new s(g.a.a.e.getInstance(d0Var2.getObjectAt(1)), g.a.a.w.getInstance(d0Var2.getObjectAt(2))));
            } else {
                if (d0Var2.size() != 2) {
                    throw new IllegalArgumentException("Bad sequence size: " + d0Var2.size());
                }
                this.F.put(d0Var2.getObjectAt(0), new s(false, g.a.a.w.getInstance(d0Var2.getObjectAt(1))));
            }
            this.G.addElement(d0Var2.getObjectAt(0));
        }
    }

    public t(Hashtable hashtable) {
        this((Vector) null, hashtable);
    }

    public t(Vector vector, Hashtable hashtable) {
        this.F = new Hashtable();
        this.G = new Vector();
        Enumeration enumerationKeys = vector == null ? hashtable.keys() : vector.elements();
        while (enumerationKeys.hasMoreElements()) {
            this.G.addElement(g.a.a.v.getInstance(enumerationKeys.nextElement()));
        }
        Enumeration enumerationElements = this.G.elements();
        while (enumerationElements.hasMoreElements()) {
            g.a.a.v vVar = g.a.a.v.getInstance(enumerationElements.nextElement());
            this.F.put(vVar, (s) hashtable.get(vVar));
        }
    }

    public t(Vector vector, Vector vector2) {
        this.F = new Hashtable();
        this.G = new Vector();
        Enumeration enumerationElements = vector.elements();
        while (enumerationElements.hasMoreElements()) {
            this.G.addElement(enumerationElements.nextElement());
        }
        int i2 = 0;
        Enumeration enumerationElements2 = this.G.elements();
        while (enumerationElements2.hasMoreElements()) {
            this.F.put((g.a.a.v) enumerationElements2.nextElement(), (s) vector2.elementAt(i2));
            i2++;
        }
    }

    public static t getInstance(l0 l0Var, boolean z2) {
        return getInstance(d0.getInstance(l0Var, z2));
    }

    public static t getInstance(Object obj) {
        if (obj == null || (obj instanceof t)) {
            return (t) obj;
        }
        if (obj instanceof d0) {
            return new t((d0) obj);
        }
        if (obj instanceof f) {
            return new t((d0) ((f) obj).toASN1Primitive());
        }
        if (obj instanceof l0) {
            return getInstance(((l0) obj).getObject());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public final g.a.a.v[] a(boolean z2) {
        Vector vector = new Vector();
        for (int i2 = 0; i2 != this.G.size(); i2++) {
            Object objElementAt = this.G.elementAt(i2);
            if (((s) this.F.get(objElementAt)).isCritical() == z2) {
                vector.addElement(objElementAt);
            }
        }
        return b(vector);
    }

    public final g.a.a.v[] b(Vector vector) {
        int size = vector.size();
        g.a.a.v[] vVarArr = new g.a.a.v[size];
        for (int i2 = 0; i2 != size; i2++) {
            vVarArr[i2] = (g.a.a.v) vector.elementAt(i2);
        }
        return vVarArr;
    }

    public boolean equivalent(t tVar) {
        if (this.F.size() != tVar.F.size()) {
            return false;
        }
        Enumeration enumerationKeys = this.F.keys();
        while (enumerationKeys.hasMoreElements()) {
            Object objNextElement = enumerationKeys.nextElement();
            if (!this.F.get(objNextElement).equals(tVar.F.get(objNextElement))) {
                return false;
            }
        }
        return true;
    }

    public g.a.a.v[] getCriticalExtensionOIDs() {
        return a(true);
    }

    public s getExtension(g.a.a.v vVar) {
        return (s) this.F.get(vVar);
    }

    public g.a.a.v[] getExtensionOIDs() {
        return b(this.G);
    }

    public g.a.a.v[] getNonCriticalExtensionOIDs() {
        return a(false);
    }

    public Enumeration oids() {
        return this.G.elements();
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(this.G.size());
        Enumeration enumerationElements = this.G.elements();
        while (enumerationElements.hasMoreElements()) {
            g.a.a.h hVar2 = new g.a.a.h(3);
            g.a.a.v vVar = (g.a.a.v) enumerationElements.nextElement();
            s sVar = (s) this.F.get(vVar);
            hVar2.add(vVar);
            if (sVar.isCritical()) {
                hVar2.add(g.a.a.e.f13069c);
            }
            hVar2.add(sVar.getValue());
            hVar.add(new b2(hVar2));
        }
        return new b2(hVar);
    }
}
