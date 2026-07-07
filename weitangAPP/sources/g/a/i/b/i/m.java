package g.a.i.b.i;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f14487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14489c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14490d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f14491e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f14492f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final g.a.a.v f14493g;

    public m(g.a.a.v vVar) {
        Objects.requireNonNull(vVar, "treeDigest == null");
        this.f14493g = vVar;
        g.a.d.e eVarA = f.a(vVar);
        int digestSize = a0.getDigestSize(eVarA);
        this.f14488b = digestSize;
        this.f14489c = 16;
        int iCeil = (int) Math.ceil(((double) (digestSize * 8)) / ((double) a0.log2(16)));
        this.f14491e = iCeil;
        int iFloor = ((int) Math.floor(a0.log2((16 - 1) * iCeil) / a0.log2(16))) + 1;
        this.f14492f = iFloor;
        int i2 = iCeil + iFloor;
        this.f14490d = i2;
        l lVarB = l.b(eVarA.getAlgorithmName(), digestSize, 16, i2);
        this.f14487a = lVarB;
        if (lVarB != null) {
            return;
        }
        throw new IllegalArgumentException("cannot find OID for digest algorithm: " + eVarA.getAlgorithmName());
    }

    public int a() {
        return this.f14490d;
    }

    public int b() {
        return this.f14488b;
    }

    public int c() {
        return this.f14489c;
    }

    public g.a.a.v getTreeDigest() {
        return this.f14493g;
    }
}
