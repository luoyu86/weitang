package g.a.a.i3;

import g.a.a.c2;
import g.a.a.f0;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Hashtable f13123a;

    public b(f0 f0Var) {
        this.f13123a = new Hashtable();
        for (int i2 = 0; i2 != f0Var.size(); i2++) {
            a aVar = a.getInstance(f0Var.getObjectAt(i2));
            a(aVar.getAttrType(), aVar);
        }
    }

    public b(g.a.a.h hVar) {
        this.f13123a = new Hashtable();
        for (int i2 = 0; i2 != hVar.size(); i2++) {
            a aVar = a.getInstance(hVar.get(i2));
            a(aVar.getAttrType(), aVar);
        }
    }

    public b(a aVar) {
        this.f13123a = new Hashtable();
        a(aVar.getAttrType(), aVar);
    }

    public b(c cVar) {
        this(f0.getInstance(cVar.toASN1Primitive()));
    }

    public b(Hashtable hashtable) {
        this.f13123a = new Hashtable();
        this.f13123a = b(hashtable);
    }

    public final void a(g.a.a.v vVar, a aVar) {
        Vector vector;
        Object obj = this.f13123a.get(vVar);
        if (obj == null) {
            this.f13123a.put(vVar, aVar);
            return;
        }
        if (obj instanceof a) {
            vector = new Vector();
            vector.addElement(obj);
        } else {
            vector = (Vector) obj;
        }
        vector.addElement(aVar);
        this.f13123a.put(vVar, vector);
    }

    public b add(g.a.a.v vVar, g.a.a.g gVar) {
        b bVar = new b(this.f13123a);
        bVar.a(vVar, new a(vVar, new c2(gVar)));
        return bVar;
    }

    public final Hashtable b(Hashtable hashtable) {
        Hashtable hashtable2 = new Hashtable();
        Enumeration enumerationKeys = hashtable.keys();
        while (enumerationKeys.hasMoreElements()) {
            Object objNextElement = enumerationKeys.nextElement();
            hashtable2.put(objNextElement, hashtable.get(objNextElement));
        }
        return hashtable2;
    }

    public a get(g.a.a.v vVar) {
        Object obj = this.f13123a.get(vVar);
        return obj instanceof Vector ? (a) ((Vector) obj).elementAt(0) : (a) obj;
    }

    public g.a.a.h getAll(g.a.a.v vVar) {
        g.a.a.h hVar = new g.a.a.h();
        Object obj = this.f13123a.get(vVar);
        if (obj instanceof Vector) {
            Enumeration enumerationElements = ((Vector) obj).elements();
            while (enumerationElements.hasMoreElements()) {
                hVar.add((a) enumerationElements.nextElement());
            }
        } else if (obj != null) {
            hVar.add((a) obj);
        }
        return hVar;
    }

    public b remove(g.a.a.v vVar) {
        b bVar = new b(this.f13123a);
        bVar.f13123a.remove(vVar);
        return bVar;
    }

    public int size() {
        Enumeration enumerationElements = this.f13123a.elements();
        int size = 0;
        while (enumerationElements.hasMoreElements()) {
            Object objNextElement = enumerationElements.nextElement();
            size = objNextElement instanceof Vector ? size + ((Vector) objNextElement).size() : size + 1;
        }
        return size;
    }

    public g.a.a.h toASN1EncodableVector() {
        g.a.a.h hVar = new g.a.a.h();
        Enumeration enumerationElements = this.f13123a.elements();
        while (enumerationElements.hasMoreElements()) {
            Object objNextElement = enumerationElements.nextElement();
            if (objNextElement instanceof Vector) {
                Enumeration enumerationElements2 = ((Vector) objNextElement).elements();
                while (enumerationElements2.hasMoreElements()) {
                    hVar.add(a.getInstance(enumerationElements2.nextElement()));
                }
            } else {
                hVar.add(a.getInstance(objNextElement));
            }
        }
        return hVar;
    }

    public c toASN1Structure() {
        return new c(toASN1EncodableVector());
    }

    public Hashtable toHashtable() {
        return b(this.f13123a);
    }
}
