package d.i0.f.a;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements d.i0.a<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12596a = new c();

    @Override // d.i0.a
    public d.i0.c getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // d.i0.a
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
