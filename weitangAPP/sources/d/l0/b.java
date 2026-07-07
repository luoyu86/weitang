package d.l0;

import d.k0.d.t;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends d.l0.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f12663c = new a();

    public static final class a extends ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // d.l0.a
    public Random getImpl() {
        Random random = this.f12663c.get();
        t.checkNotNullExpressionValue(random, "implStorage.get()");
        return random;
    }
}
