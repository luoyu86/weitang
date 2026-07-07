package d.k0.d;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 implements d.n0.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12632a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile List<? extends d.n0.o> f12633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12634c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12635d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d.n0.s f12636e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12637f;

    public static final class a {
        public a() {
        }

        public final String toString(d.n0.p pVar) {
            t.checkNotNullParameter(pVar, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int i2 = j0.f12629a[pVar.getVariance().ordinal()];
            if (i2 == 2) {
                sb.append("in ");
            } else if (i2 == 3) {
                sb.append("out ");
            }
            sb.append(pVar.getName());
            String string = sb.toString();
            t.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        public /* synthetic */ a(p pVar) {
            this();
        }
    }

    public k0(Object obj, String str, d.n0.s sVar, boolean z) {
        t.checkNotNullParameter(str, "name");
        t.checkNotNullParameter(sVar, "variance");
        this.f12634c = obj;
        this.f12635d = str;
        this.f12636e = sVar;
        this.f12637f = z;
    }

    public static /* synthetic */ void getUpperBounds$annotations() {
    }

    public boolean equals(Object obj) {
        if (obj instanceof k0) {
            k0 k0Var = (k0) obj;
            if (t.areEqual(this.f12634c, k0Var.f12634c) && t.areEqual(getName(), k0Var.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // d.n0.p
    public String getName() {
        return this.f12635d;
    }

    @Override // d.n0.p
    public List<d.n0.o> getUpperBounds() {
        List list = this.f12633b;
        if (list != null) {
            return list;
        }
        List<d.n0.o> listListOf = d.g0.r.listOf(f0.nullableTypeOf(Object.class));
        this.f12633b = listListOf;
        return listListOf;
    }

    @Override // d.n0.p
    public d.n0.s getVariance() {
        return this.f12636e;
    }

    public int hashCode() {
        Object obj = this.f12634c;
        return ((obj != null ? obj.hashCode() : 0) * 31) + getName().hashCode();
    }

    @Override // d.n0.p
    public boolean isReified() {
        return this.f12637f;
    }

    public final void setUpperBounds(List<? extends d.n0.o> list) {
        t.checkNotNullParameter(list, "upperBounds");
        if (this.f12633b == null) {
            this.f12633b = list;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    public String toString() {
        return f12632a.toString(this);
    }
}
