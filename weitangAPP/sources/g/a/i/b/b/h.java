package g.a.i.b.b;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f14305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f14306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h f14307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h f14308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<Object, h> f14309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f14310f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f14311g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f14312h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f14313i;
    public final int j;
    public final int k;
    public final g.a.a.v l;

    public static class a extends HashMap<Object, h> {
        public a() {
            h hVar = h.f14305a;
            put(Integer.valueOf(hVar.f14310f), hVar);
            h hVar2 = h.f14306b;
            put(Integer.valueOf(hVar2.f14310f), hVar2);
            h hVar3 = h.f14307c;
            put(Integer.valueOf(hVar3.f14310f), hVar3);
            h hVar4 = h.f14308d;
            put(Integer.valueOf(hVar4.f14310f), hVar4);
        }
    }

    static {
        g.a.a.v vVar = g.a.a.q3.b.f13301c;
        f14305a = new h(1, 32, 1, 265, 7, 8516, vVar);
        f14306b = new h(2, 32, 2, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD, 6, 4292, vVar);
        f14307c = new h(3, 32, 4, 67, 4, 2180, vVar);
        f14308d = new h(4, 32, 8, 34, 0, 1124, vVar);
        f14309e = new a();
    }

    public h(int i2, int i3, int i4, int i5, int i6, int i7, g.a.a.v vVar) {
        this.f14310f = i2;
        this.f14311g = i3;
        this.f14312h = i4;
        this.f14313i = i5;
        this.j = i6;
        this.k = i7;
        this.l = vVar;
    }

    public static h getParametersForType(int i2) {
        return f14309e.get(Integer.valueOf(i2));
    }

    public g.a.a.v getDigestOID() {
        return this.l;
    }

    public int getLs() {
        return this.j;
    }

    public int getN() {
        return this.f14311g;
    }

    public int getP() {
        return this.f14313i;
    }

    public int getSigLen() {
        return this.k;
    }

    public int getType() {
        return this.f14310f;
    }

    public int getW() {
        return this.f14312h;
    }
}
