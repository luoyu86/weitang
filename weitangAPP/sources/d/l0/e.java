package d.l0;

import d.k0.d.t;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final Random asJavaRandom(f fVar) {
        Random impl;
        t.checkNotNullParameter(fVar, "$this$asJavaRandom");
        a aVar = (a) (!(fVar instanceof a) ? null : fVar);
        return (aVar == null || (impl = aVar.getImpl()) == null) ? new c(fVar) : impl;
    }

    public static final f asKotlinRandom(Random random) {
        f impl;
        t.checkNotNullParameter(random, "$this$asKotlinRandom");
        c cVar = (c) (!(random instanceof c) ? null : random);
        return (cVar == null || (impl = cVar.getImpl()) == null) ? new d(random) : impl;
    }

    public static final double doubleFromParts(int i2, int i3) {
        return ((((long) i2) << 27) + ((long) i3)) / 9007199254740992L;
    }
}
