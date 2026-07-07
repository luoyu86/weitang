package g.a.a.y3;

import g.a.a.a0;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    public boolean F;
    public g.a.a.w G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g.a.a.v f13522a = new g.a.a.v("2.5.29.9");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g.a.a.v f13523b = new g.a.a.v("2.5.29.14");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g.a.a.v f13524c = new g.a.a.v("2.5.29.15");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g.a.a.v f13525d = new g.a.a.v("2.5.29.16");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g.a.a.v f13526e = new g.a.a.v("2.5.29.17");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g.a.a.v f13527f = new g.a.a.v("2.5.29.18");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g.a.a.v f13528g = new g.a.a.v("2.5.29.19");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final g.a.a.v f13529h = new g.a.a.v("2.5.29.20");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final g.a.a.v f13530i = new g.a.a.v("2.5.29.21");
    public static final g.a.a.v j = new g.a.a.v("2.5.29.23");
    public static final g.a.a.v k = new g.a.a.v("2.5.29.24");
    public static final g.a.a.v l = new g.a.a.v("2.5.29.27");
    public static final g.a.a.v m = new g.a.a.v("2.5.29.28");
    public static final g.a.a.v n = new g.a.a.v("2.5.29.29");
    public static final g.a.a.v o = new g.a.a.v("2.5.29.30");
    public static final g.a.a.v p = new g.a.a.v("2.5.29.31");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final g.a.a.v f13531q = new g.a.a.v("2.5.29.32");
    public static final g.a.a.v r = new g.a.a.v("2.5.29.33");
    public static final g.a.a.v s = new g.a.a.v("2.5.29.35");
    public static final g.a.a.v t = new g.a.a.v("2.5.29.36");
    public static final g.a.a.v u = new g.a.a.v("2.5.29.37");
    public static final g.a.a.v v = new g.a.a.v("2.5.29.46");
    public static final g.a.a.v w = new g.a.a.v("2.5.29.54");
    public static final g.a.a.v x = new g.a.a.v("1.3.6.1.5.5.7.1.1");
    public static final g.a.a.v y = new g.a.a.v("1.3.6.1.5.5.7.1.11");
    public static final g.a.a.v z = new g.a.a.v("1.3.6.1.5.5.7.1.12");
    public static final g.a.a.v A = new g.a.a.v("1.3.6.1.5.5.7.1.2");
    public static final g.a.a.v B = new g.a.a.v("1.3.6.1.5.5.7.1.3");
    public static final g.a.a.v C = new g.a.a.v("1.3.6.1.5.5.7.1.4");
    public static final g.a.a.v D = new g.a.a.v("2.5.29.56");
    public static final g.a.a.v E = new g.a.a.v("2.5.29.55");

    public s(g.a.a.e eVar, g.a.a.w wVar) {
        this.F = eVar.isTrue();
        this.G = wVar;
    }

    public s(boolean z2, g.a.a.w wVar) {
        this.F = z2;
        this.G = wVar;
    }

    public static a0 convertValueToObject(s sVar) throws IllegalArgumentException {
        try {
            return a0.fromByteArray(sVar.getValue().getOctets());
        } catch (IOException e2) {
            throw new IllegalArgumentException("can't convert extension: " + e2);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return sVar.getValue().equals((a0) getValue()) && sVar.isCritical() == isCritical();
    }

    public g.a.a.g getParsedValue() {
        return convertValueToObject(this);
    }

    public g.a.a.w getValue() {
        return this.G;
    }

    public int hashCode() {
        return isCritical() ? getValue().hashCode() : ~getValue().hashCode();
    }

    public boolean isCritical() {
        return this.F;
    }
}
