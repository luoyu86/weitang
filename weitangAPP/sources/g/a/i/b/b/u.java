package g.a.i.b.b;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f14354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final u f14355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final u f14356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final u f14357d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final u f14358e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Map<Object, u> f14359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f14360g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f14361h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f14362i;
    public final g.a.a.v j;

    public static class a extends HashMap<Object, u> {
        public a() {
            u uVar = u.f14354a;
            put(Integer.valueOf(uVar.f14360g), uVar);
            u uVar2 = u.f14355b;
            put(Integer.valueOf(uVar2.f14360g), uVar2);
            u uVar3 = u.f14356c;
            put(Integer.valueOf(uVar3.f14360g), uVar3);
            u uVar4 = u.f14357d;
            put(Integer.valueOf(uVar4.f14360g), uVar4);
            u uVar5 = u.f14358e;
            put(Integer.valueOf(uVar5.f14360g), uVar5);
        }
    }

    static {
        g.a.a.v vVar = g.a.a.q3.b.f13301c;
        f14354a = new u(5, 32, 5, vVar);
        f14355b = new u(6, 32, 10, vVar);
        f14356c = new u(7, 32, 15, vVar);
        f14357d = new u(8, 32, 20, vVar);
        f14358e = new u(9, 32, 25, vVar);
        f14359f = new a();
    }

    public u(int i2, int i3, int i4, g.a.a.v vVar) {
        this.f14360g = i2;
        this.f14361h = i3;
        this.f14362i = i4;
        this.j = vVar;
    }

    public static u b(int i2) {
        return f14359f.get(Integer.valueOf(i2));
    }

    public g.a.a.v getDigestOID() {
        return this.j;
    }

    public int getH() {
        return this.f14362i;
    }

    public int getM() {
        return this.f14361h;
    }

    public int getType() {
        return this.f14360g;
    }
}
