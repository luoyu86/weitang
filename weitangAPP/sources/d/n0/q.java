package d.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f12717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final o f12718d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12716b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f12715a = new q(null, null);

    public static final class a {
        public a() {
        }

        public static /* synthetic */ void getStar$annotations() {
        }

        public final q contravariant(o oVar) {
            d.k0.d.t.checkNotNullParameter(oVar, "type");
            return new q(s.IN, oVar);
        }

        public final q covariant(o oVar) {
            d.k0.d.t.checkNotNullParameter(oVar, "type");
            return new q(s.OUT, oVar);
        }

        public final q getSTAR() {
            return q.f12715a;
        }

        public final q invariant(o oVar) {
            d.k0.d.t.checkNotNullParameter(oVar, "type");
            return new q(s.INVARIANT, oVar);
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public q(s sVar, o oVar) {
        String str;
        this.f12717c = sVar;
        this.f12718d = oVar;
        if ((sVar == null) == (oVar == null)) {
            return;
        }
        if (sVar == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + sVar + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public static final q contravariant(o oVar) {
        return f12716b.contravariant(oVar);
    }

    public static /* synthetic */ q copy$default(q qVar, s sVar, o oVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            sVar = qVar.f12717c;
        }
        if ((i2 & 2) != 0) {
            oVar = qVar.f12718d;
        }
        return qVar.copy(sVar, oVar);
    }

    public static final q covariant(o oVar) {
        return f12716b.covariant(oVar);
    }

    public static final q invariant(o oVar) {
        return f12716b.invariant(oVar);
    }

    public final s component1() {
        return this.f12717c;
    }

    public final o component2() {
        return this.f12718d;
    }

    public final q copy(s sVar, o oVar) {
        return new q(sVar, oVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return d.k0.d.t.areEqual(this.f12717c, qVar.f12717c) && d.k0.d.t.areEqual(this.f12718d, qVar.f12718d);
    }

    public final o getType() {
        return this.f12718d;
    }

    public final s getVariance() {
        return this.f12717c;
    }

    public int hashCode() {
        s sVar = this.f12717c;
        int iHashCode = (sVar != null ? sVar.hashCode() : 0) * 31;
        o oVar = this.f12718d;
        return iHashCode + (oVar != null ? oVar.hashCode() : 0);
    }

    public String toString() {
        s sVar = this.f12717c;
        if (sVar == null) {
            return "*";
        }
        int i2 = r.f12719a[sVar.ordinal()];
        if (i2 == 1) {
            return String.valueOf(this.f12718d);
        }
        if (i2 == 2) {
            return "in " + this.f12718d;
        }
        if (i2 != 3) {
            throw new d.l();
        }
        return "out " + this.f12718d;
    }
}
