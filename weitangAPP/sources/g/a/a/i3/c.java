package g.a.a.i3;

import g.a.a.a0;
import g.a.a.f0;
import g.a.a.l0;
import g.a.a.s2;

/* JADX INFO: loaded from: classes2.dex */
public class c extends g.a.a.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f13124a;

    public c(f0 f0Var) {
        this.f13124a = f0Var;
    }

    public c(g.a.a.h hVar) {
        this.f13124a = new s2(hVar);
    }

    public static c getInstance(l0 l0Var, boolean z) {
        return getInstance(f0.getInstance(l0Var, z));
    }

    public static c getInstance(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(f0.getInstance(obj));
        }
        return null;
    }

    public a[] getAttributes() {
        int size = this.f13124a.size();
        a[] aVarArr = new a[size];
        for (int i2 = 0; i2 != size; i2++) {
            aVarArr[i2] = a.getInstance(this.f13124a.getObjectAt(i2));
        }
        return aVarArr;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return this.f13124a;
    }
}
