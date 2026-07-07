package d.l0;

import d.k0.d.t;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public final class d extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Random f12666c;

    public d(Random random) {
        t.checkNotNullParameter(random, "impl");
        this.f12666c = random;
    }

    @Override // d.l0.a
    public Random getImpl() {
        return this.f12666c;
    }
}
