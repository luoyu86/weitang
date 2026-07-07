package g.a.a.x3;

import g.a.a.g;
import g.a.a.v;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f13429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Vector f13430b;

    public d() {
        this(g.a.a.x3.f.b.O);
    }

    public d(e eVar) {
        this.f13430b = new Vector();
        this.f13429a = eVar;
    }

    public d addMultiValuedRDN(v[] vVarArr, g[] gVarArr) {
        a[] aVarArr = new a[vVarArr.length];
        for (int i2 = 0; i2 != vVarArr.length; i2++) {
            aVarArr[i2] = new a(vVarArr[i2], gVarArr[i2]);
        }
        return addMultiValuedRDN(aVarArr);
    }

    public d addMultiValuedRDN(v[] vVarArr, String[] strArr) {
        int length = strArr.length;
        g[] gVarArr = new g[length];
        for (int i2 = 0; i2 != length; i2++) {
            gVarArr[i2] = this.f13429a.stringToValue(vVarArr[i2], strArr[i2]);
        }
        return addMultiValuedRDN(vVarArr, gVarArr);
    }

    public d addMultiValuedRDN(a[] aVarArr) {
        this.f13430b.addElement(new b(aVarArr));
        return this;
    }

    public d addRDN(v vVar, g gVar) {
        this.f13430b.addElement(new b(vVar, gVar));
        return this;
    }

    public d addRDN(v vVar, String str) {
        addRDN(vVar, this.f13429a.stringToValue(vVar, str));
        return this;
    }

    public d addRDN(a aVar) {
        this.f13430b.addElement(new b(aVar));
        return this;
    }

    public c build() {
        int size = this.f13430b.size();
        b[] bVarArr = new b[size];
        for (int i2 = 0; i2 != size; i2++) {
            bVarArr[i2] = (b) this.f13430b.elementAt(i2);
        }
        return new c(this.f13429a, bVarArr);
    }
}
