package g.a.a.x3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.f;
import g.a.a.g;
import g.a.a.l0;
import g.a.a.t;
import g.a.a.v;
import java.util.Enumeration;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class c extends t implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f13423a = g.a.a.x3.f.b.O;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f13424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13425c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f13426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b[] f13427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b2 f13428f;

    public c(d0 d0Var) {
        this(f13423a, d0Var);
    }

    public c(e eVar, d0 d0Var) {
        this.f13426d = eVar;
        this.f13427e = new b[d0Var.size()];
        Enumeration objects = d0Var.getObjects();
        boolean z = true;
        int i2 = 0;
        while (objects.hasMoreElements()) {
            Object objNextElement = objects.nextElement();
            b bVar = b.getInstance(objNextElement);
            z &= bVar == objNextElement;
            this.f13427e[i2] = bVar;
            i2++;
        }
        this.f13428f = z ? b2.convert(d0Var) : new b2(this.f13427e);
    }

    public c(e eVar, c cVar) {
        this.f13426d = eVar;
        this.f13427e = cVar.f13427e;
        this.f13428f = cVar.f13428f;
    }

    public c(e eVar, String str) {
        this(eVar.fromString(str));
        this.f13426d = eVar;
    }

    public c(e eVar, b[] bVarArr) {
        this.f13426d = eVar;
        this.f13427e = (b[]) bVarArr.clone();
        this.f13428f = new b2(this.f13427e);
    }

    public c(String str) {
        this(f13423a, str);
    }

    public c(b[] bVarArr) {
        this(f13423a, bVarArr);
    }

    public static e getDefaultStyle() {
        return f13423a;
    }

    public static c getInstance(l0 l0Var, boolean z) {
        return getInstance(d0.getInstance(l0Var, true));
    }

    public static c getInstance(e eVar, Object obj) {
        if (obj instanceof c) {
            return new c(eVar, (c) obj);
        }
        if (obj != null) {
            return new c(eVar, d0.getInstance(obj));
        }
        return null;
    }

    public static c getInstance(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(d0.getInstance(obj));
        }
        return null;
    }

    public static void setDefaultStyle(e eVar) {
        Objects.requireNonNull(eVar, "cannot set style to null");
        f13423a = eVar;
    }

    @Override // g.a.a.t
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c) && !(obj instanceof d0)) {
            return false;
        }
        if (toASN1Primitive().equals(((g) obj).toASN1Primitive())) {
            return true;
        }
        try {
            return this.f13426d.areEqual(this, new c(d0.getInstance(((g) obj).toASN1Primitive())));
        } catch (Exception unused) {
            return false;
        }
    }

    public v[] getAttributeTypes() {
        int length = this.f13427e.length;
        int size = 0;
        for (int i2 = 0; i2 < length; i2++) {
            size += this.f13427e[i2].size();
        }
        v[] vVarArr = new v[size];
        int iA = 0;
        for (int i3 = 0; i3 < length; i3++) {
            iA += this.f13427e[i3].a(vVarArr, iA);
        }
        return vVarArr;
    }

    public b[] getRDNs() {
        return (b[]) this.f13427e.clone();
    }

    public b[] getRDNs(v vVar) {
        int length = this.f13427e.length;
        b[] bVarArr = new b[length];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            b[] bVarArr2 = this.f13427e;
            if (i2 == bVarArr2.length) {
                break;
            }
            b bVar = bVarArr2[i2];
            if (bVar.b(vVar)) {
                bVarArr[i3] = bVar;
                i3++;
            }
            i2++;
        }
        if (i3 >= length) {
            return bVarArr;
        }
        b[] bVarArr3 = new b[i3];
        System.arraycopy(bVarArr, 0, bVarArr3, 0, i3);
        return bVarArr3;
    }

    @Override // g.a.a.t
    public int hashCode() {
        if (this.f13424b) {
            return this.f13425c;
        }
        this.f13424b = true;
        int iCalculateHashCode = this.f13426d.calculateHashCode(this);
        this.f13425c = iCalculateHashCode;
        return iCalculateHashCode;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return this.f13428f;
    }

    public String toString() {
        return this.f13426d.toString(this);
    }
}
