package c.n.a;

import android.view.View;
import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends l {
    public static final Map<String, c.n.b.d> E;
    public Object F;
    public String G;
    public c.n.b.d H;

    static {
        HashMap map = new HashMap();
        E = map;
        map.put("alpha", i.f2892a);
        map.put("pivotX", i.f2893b);
        map.put("pivotY", i.f2894c);
        map.put("translationX", i.f2895d);
        map.put("translationY", i.f2896e);
        map.put("rotation", i.f2897f);
        map.put("rotationX", i.f2898g);
        map.put("rotationY", i.f2899h);
        map.put("scaleX", i.f2900i);
        map.put("scaleY", i.j);
        map.put("scrollX", i.k);
        map.put("scrollY", i.l);
        map.put("x", i.m);
        map.put(OperatorName.CURVE_TO_REPLICATE_FINAL_POINT, i.n);
    }

    public h() {
    }

    public static h ofFloat(Object obj, String str, float... fArr) {
        h hVar = new h(obj, str);
        hVar.setFloatValues(fArr);
        return hVar;
    }

    public static h ofInt(Object obj, String str, int... iArr) {
        h hVar = new h(obj, str);
        hVar.setIntValues(iArr);
        return hVar;
    }

    public static h ofObject(Object obj, String str, k kVar, Object... objArr) {
        h hVar = new h(obj, str);
        hVar.setObjectValues(objArr);
        hVar.setEvaluator(kVar);
        return hVar;
    }

    public static h ofPropertyValuesHolder(Object obj, j... jVarArr) {
        h hVar = new h();
        hVar.F = obj;
        hVar.setValues(jVarArr);
        return hVar;
    }

    public String getPropertyName() {
        return this.G;
    }

    public Object getTarget() {
        return this.F;
    }

    @Override // c.n.a.l
    public void l(float f2) {
        super.l(f2);
        int length = this.C.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.C[i2].f(this.F);
        }
    }

    @Override // c.n.a.l
    public void p() {
        if (this.v) {
            return;
        }
        if (this.H == null && c.n.c.f.a.f2959a && (this.F instanceof View)) {
            Map<String, c.n.b.d> map = E;
            if (map.containsKey(this.G)) {
                setProperty(map.get(this.G));
            }
        }
        int length = this.C.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.C[i2].j(this.F);
        }
        super.p();
    }

    @Override // c.n.a.l
    public void setFloatValues(float... fArr) {
        j[] jVarArr = this.C;
        if (jVarArr != null && jVarArr.length != 0) {
            super.setFloatValues(fArr);
            return;
        }
        c.n.b.d dVar = this.H;
        if (dVar != null) {
            setValues(j.ofFloat((c.n.b.d<?, Float>) dVar, fArr));
        } else {
            setValues(j.ofFloat(this.G, fArr));
        }
    }

    @Override // c.n.a.l
    public void setIntValues(int... iArr) {
        j[] jVarArr = this.C;
        if (jVarArr != null && jVarArr.length != 0) {
            super.setIntValues(iArr);
            return;
        }
        c.n.b.d dVar = this.H;
        if (dVar != null) {
            setValues(j.ofInt((c.n.b.d<?, Integer>) dVar, iArr));
        } else {
            setValues(j.ofInt(this.G, iArr));
        }
    }

    @Override // c.n.a.l
    public void setObjectValues(Object... objArr) {
        j[] jVarArr = this.C;
        if (jVarArr != null && jVarArr.length != 0) {
            super.setObjectValues(objArr);
            return;
        }
        c.n.b.d dVar = this.H;
        if (dVar != null) {
            setValues(j.ofObject(dVar, (k) null, objArr));
        } else {
            setValues(j.ofObject(this.G, (k) null, objArr));
        }
    }

    public void setProperty(c.n.b.d dVar) {
        j[] jVarArr = this.C;
        if (jVarArr != null) {
            j jVar = jVarArr[0];
            String propertyName = jVar.getPropertyName();
            jVar.setProperty(dVar);
            this.D.remove(propertyName);
            this.D.put(this.G, jVar);
        }
        if (this.H != null) {
            this.G = dVar.getName();
        }
        this.H = dVar;
        this.v = false;
    }

    public void setPropertyName(String str) {
        j[] jVarArr = this.C;
        if (jVarArr != null) {
            j jVar = jVarArr[0];
            String propertyName = jVar.getPropertyName();
            jVar.setPropertyName(str);
            this.D.remove(propertyName);
            this.D.put(str, jVar);
        }
        this.G = str;
        this.v = false;
    }

    @Override // c.n.a.a
    public void setTarget(Object obj) {
        Object obj2 = this.F;
        if (obj2 != obj) {
            this.F = obj;
            if (obj2 == null || obj == null || obj2.getClass() != obj.getClass()) {
                this.v = false;
            }
        }
    }

    @Override // c.n.a.a
    public void setupEndValues() {
        p();
        int length = this.C.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.C[i2].g(this.F);
        }
    }

    @Override // c.n.a.a
    public void setupStartValues() {
        p();
        int length = this.C.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.C[i2].l(this.F);
        }
    }

    @Override // c.n.a.l, c.n.a.a
    public void start() {
        super.start();
    }

    @Override // c.n.a.l
    public String toString() {
        String str = "ObjectAnimator@" + Integer.toHexString(hashCode()) + ", target " + this.F;
        if (this.C != null) {
            for (int i2 = 0; i2 < this.C.length; i2++) {
                str = str + "\n    " + this.C[i2].toString();
            }
        }
        return str;
    }

    public h(Object obj, String str) {
        this.F = obj;
        setPropertyName(str);
    }

    public static <T> h ofFloat(T t, c.n.b.d<T, Float> dVar, float... fArr) {
        h hVar = new h(t, dVar);
        hVar.setFloatValues(fArr);
        return hVar;
    }

    public static <T> h ofInt(T t, c.n.b.d<T, Integer> dVar, int... iArr) {
        h hVar = new h(t, dVar);
        hVar.setIntValues(iArr);
        return hVar;
    }

    @Override // c.n.a.l, c.n.a.a
    public h setDuration(long j) {
        super.setDuration(j);
        return this;
    }

    public static <T, V> h ofObject(T t, c.n.b.d<T, V> dVar, k<V> kVar, V... vArr) {
        h hVar = new h(t, dVar);
        hVar.setObjectValues(vArr);
        hVar.setEvaluator(kVar);
        return hVar;
    }

    @Override // c.n.a.l, c.n.a.a
    /* JADX INFO: renamed from: clone */
    public h mo7clone() {
        return (h) super.mo7clone();
    }

    public <T> h(T t, c.n.b.d<T, ?> dVar) {
        this.F = t;
        setProperty(dVar);
    }
}
