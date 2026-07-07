package g.a.a.x3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.c2;
import g.a.a.f0;
import g.a.a.g;
import g.a.a.h;
import g.a.a.t;
import g.a.a.v;

/* JADX INFO: loaded from: classes2.dex */
public class b extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f0 f13422a;

    public b(f0 f0Var) {
        this.f13422a = f0Var;
    }

    public b(v vVar, g gVar) {
        h hVar = new h(2);
        hVar.add(vVar);
        hVar.add(gVar);
        this.f13422a = new c2(new b2(hVar));
    }

    public b(a aVar) {
        this.f13422a = new c2(aVar);
    }

    public b(a[] aVarArr) {
        this.f13422a = new c2(aVarArr);
    }

    public static b getInstance(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(f0.getInstance(obj));
        }
        return null;
    }

    public int a(v[] vVarArr, int i2) {
        int size = this.f13422a.size();
        for (int i3 = 0; i3 < size; i3++) {
            vVarArr[i2 + i3] = a.getInstance(this.f13422a.getObjectAt(i3)).getType();
        }
        return size;
    }

    public boolean b(v vVar) {
        int size = this.f13422a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (a.getInstance(this.f13422a.getObjectAt(i2)).getType().equals((a0) vVar)) {
                return true;
            }
        }
        return false;
    }

    public a getFirst() {
        if (this.f13422a.size() == 0) {
            return null;
        }
        return a.getInstance(this.f13422a.getObjectAt(0));
    }

    public a[] getTypesAndValues() {
        int size = this.f13422a.size();
        a[] aVarArr = new a[size];
        for (int i2 = 0; i2 != size; i2++) {
            aVarArr[i2] = a.getInstance(this.f13422a.getObjectAt(i2));
        }
        return aVarArr;
    }

    public boolean isMultiValued() {
        return this.f13422a.size() > 1;
    }

    public int size() {
        return this.f13422a.size();
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        return this.f13422a;
    }
}
