package g.a.d.n;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class g extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f13815b;

    public g(boolean z, f fVar) {
        super(z);
        Objects.requireNonNull(fVar, "'parameters' cannot be null");
        this.f13815b = fVar;
    }

    public f getParameters() {
        return this.f13815b;
    }
}
