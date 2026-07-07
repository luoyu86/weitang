package g.b.a;

import android.os.Looper;

/* JADX INFO: loaded from: classes3.dex */
public interface h {

    public static class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Looper f14712a;

        public a(Looper looper) {
            this.f14712a = looper;
        }

        @Override // g.b.a.h
        public l createPoster(c cVar) {
            return new f(cVar, this.f14712a, 10);
        }

        @Override // g.b.a.h
        public boolean isMainThread() {
            return this.f14712a == Looper.myLooper();
        }
    }

    l createPoster(c cVar);

    boolean isMainThread();
}
