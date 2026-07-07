package g.a.a.z3;

import g.a.a.a0;
import g.a.a.b2;
import g.a.a.d0;
import g.a.a.q;
import g.a.a.t;
import g.a.a.v;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes2.dex */
public class i extends t implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f13590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a0 f13591b;

    public i(int i2, int i3) {
        this(i2, i3, 0, 0);
    }

    public i(int i2, int i3, int i4, int i5) {
        this.f13590a = k.X3;
        g.a.a.h hVar = new g.a.a.h(3);
        hVar.add(new q(i2));
        if (i4 == 0) {
            if (i5 != 0) {
                throw new IllegalArgumentException("inconsistent k values");
            }
            hVar.add(k.Z3);
            hVar.add(new q(i3));
        } else {
            if (i4 <= i3 || i5 <= i4) {
                throw new IllegalArgumentException("inconsistent k values");
            }
            hVar.add(k.a4);
            g.a.a.h hVar2 = new g.a.a.h(3);
            hVar2.add(new q(i3));
            hVar2.add(new q(i4));
            hVar2.add(new q(i5));
            hVar.add(new b2(hVar2));
        }
        this.f13591b = new b2(hVar);
    }

    public i(d0 d0Var) {
        this.f13590a = v.getInstance(d0Var.getObjectAt(0));
        this.f13591b = d0Var.getObjectAt(1).toASN1Primitive();
    }

    public i(BigInteger bigInteger) {
        this.f13590a = k.W3;
        this.f13591b = new q(bigInteger);
    }

    public static i getInstance(Object obj) {
        if (obj instanceof i) {
            return (i) obj;
        }
        if (obj != null) {
            return new i(d0.getInstance(obj));
        }
        return null;
    }

    public v getIdentifier() {
        return this.f13590a;
    }

    public a0 getParameters() {
        return this.f13591b;
    }

    @Override // g.a.a.t, g.a.a.g
    public a0 toASN1Primitive() {
        g.a.a.h hVar = new g.a.a.h(2);
        hVar.add(this.f13590a);
        hVar.add(this.f13591b);
        return new b2(hVar);
    }
}
