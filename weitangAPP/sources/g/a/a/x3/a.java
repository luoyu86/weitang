package g.a.a.x3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.g;
import g.a.a.h;
import g.a.a.t;
import g.a.a.v;

/* JADX INFO: loaded from: classes2.dex */
public class a extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f13420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g f13421b;

    public a(d0 d0Var) {
        this.f13420a = (v) d0Var.getObjectAt(0);
        this.f13421b = d0Var.getObjectAt(1);
    }

    public a(v vVar, g gVar) {
        this.f13420a = vVar;
        this.f13421b = gVar;
    }

    public static a getInstance(Object obj) {
        if (obj instanceof a) {
            return (a) obj;
        }
        if (obj != null) {
            return new a(d0.getInstance(obj));
        }
        throw new IllegalArgumentException("null value in getInstance()");
    }

    public v getType() {
        return this.f13420a;
    }

    public g getValue() {
        return this.f13421b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        h hVar = new h(2);
        hVar.add(this.f13420a);
        hVar.add(this.f13421b);
        return new b2(hVar);
    }
}
