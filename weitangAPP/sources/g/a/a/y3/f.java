package g.a.a.y3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.l0;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public class f extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable f13472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Vector f13473b;

    public f(d0 d0Var) {
        this.f13472a = new Hashtable();
        this.f13473b = new Vector();
        Enumeration objects = d0Var.getObjects();
        while (objects.hasMoreElements()) {
            e eVar = e.getInstance(objects.nextElement());
            if (this.f13472a.containsKey(eVar.getExtnId())) {
                throw new IllegalArgumentException("repeated extension found: " + eVar.getExtnId());
            }
            this.f13472a.put(eVar.getExtnId(), eVar);
            this.f13473b.addElement(eVar.getExtnId());
        }
    }

    public f(e eVar) {
        this.f13472a = new Hashtable();
        Vector vector = new Vector();
        this.f13473b = vector;
        vector.addElement(eVar.getExtnId());
        this.f13472a.put(eVar.getExtnId(), eVar);
    }

    public f(e[] eVarArr) {
        this.f13472a = new Hashtable();
        this.f13473b = new Vector();
        for (int i2 = 0; i2 != eVarArr.length; i2++) {
            e eVar = eVarArr[i2];
            this.f13473b.addElement(eVar.getExtnId());
            this.f13472a.put(eVar.getExtnId(), eVar);
        }
    }

    public static e getExtension(f fVar, g.a.a.v vVar) {
        if (fVar == null) {
            return null;
        }
        return fVar.getExtension(vVar);
    }

    public static g.a.a.g getExtensionParsedValue(f fVar, g.a.a.v vVar) {
        if (fVar == null) {
            return null;
        }
        return fVar.getExtensionParsedValue(vVar);
    }

    public static f getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, z));
    }

    public static f getInstance(Object obj) {
        if (obj instanceof f) {
            return (f) obj;
        }
        if (obj != null) {
            return new f(d0.getInstance(obj));
        }
        return null;
    }

    public final g.a.a.v[] a(boolean z) {
        Vector vector = new Vector();
        for (int i2 = 0; i2 != this.f13473b.size(); i2++) {
            Object objElementAt = this.f13473b.elementAt(i2);
            if (((e) this.f13472a.get(objElementAt)).isCritical() == z) {
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

    public boolean equivalent(f fVar) {
        if (this.f13472a.size() != fVar.f13472a.size()) {
            return false;
        }
        Enumeration enumerationKeys = this.f13472a.keys();
        while (enumerationKeys.hasMoreElements()) {
            Object objNextElement = enumerationKeys.nextElement();
            if (!this.f13472a.get(objNextElement).equals(fVar.f13472a.get(objNextElement))) {
                return false;
            }
        }
        return true;
    }

    public g.a.a.v[] getCriticalExtensionOIDs() {
        return a(true);
    }

    public e getExtension(g.a.a.v vVar) {
        return (e) this.f13472a.get(vVar);
    }

    public g.a.a.v[] getExtensionOIDs() {
        return b(this.f13473b);
    }

    public g.a.a.g getExtensionParsedValue(g.a.a.v vVar) {
        e extension = getExtension(vVar);
        if (extension != null) {
            return extension.getParsedValue();
        }
        return null;
    }

    public g.a.a.v[] getNonCriticalExtensionOIDs() {
        return a(false);
    }

    public Enumeration oids() {
        return this.f13473b.elements();
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(this.f13473b.size());
        Enumeration enumerationElements = this.f13473b.elements();
        while (enumerationElements.hasMoreElements()) {
            hVar.add((e) this.f13472a.get((g.a.a.v) enumerationElements.nextElement()));
        }
        return new b2(hVar);
    }
}
