package g.a.i.b.b;

import java.security.SecureRandom;

/* JADX INFO: loaded from: classes3.dex */
public class d extends g.a.d.f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p[] f14292c;

    public d(p[] pVarArr, SecureRandom secureRandom) {
        super(secureRandom, w.c(pVarArr[0]));
        if (pVarArr.length == 0 || pVarArr.length > 8) {
            throw new IllegalArgumentException("lmsParameters length should be between 1 and 8 inclusive");
        }
        this.f14292c = pVarArr;
    }

    public int getDepth() {
        return this.f14292c.length;
    }

    public p[] getLmsParameters() {
        return this.f14292c;
    }
}
