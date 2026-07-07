package d.k0.d;

import com.sun.mail.imap.IMAPStore;
import java.lang.annotation.Annotation;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 implements d.n0.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.n0.c f12646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<d.n0.q> f12647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f12648c;

    public static final class a extends u implements d.k0.c.l<d.n0.q, CharSequence> {
        public a() {
            super(1);
        }

        @Override // d.k0.c.l
        public final CharSequence invoke(d.n0.q qVar) {
            t.checkNotNullParameter(qVar, "it");
            return m0.this.b(qVar);
        }
    }

    public m0(d.n0.c cVar, List<d.n0.q> list, boolean z) {
        t.checkNotNullParameter(cVar, "classifier");
        t.checkNotNullParameter(list, IMAPStore.ID_ARGUMENTS);
        this.f12646a = cVar;
        this.f12647b = list;
        this.f12648c = z;
    }

    public final String a() {
        d.n0.c classifier = getClassifier();
        if (!(classifier instanceof d.n0.b)) {
            classifier = null;
        }
        d.n0.b bVar = (d.n0.b) classifier;
        Class<?> javaClass = bVar != null ? d.k0.a.getJavaClass(bVar) : null;
        return (javaClass == null ? getClassifier().toString() : javaClass.isArray() ? c(javaClass) : javaClass.getName()) + (getArguments().isEmpty() ? "" : d.g0.a0.joinToString$default(getArguments(), ", ", "<", ">", 0, null, new a(), 24, null)) + (isMarkedNullable() ? "?" : "");
    }

    public final String b(d.n0.q qVar) {
        String strValueOf;
        if (qVar.getVariance() == null) {
            return "*";
        }
        d.n0.o type = qVar.getType();
        if (!(type instanceof m0)) {
            type = null;
        }
        m0 m0Var = (m0) type;
        if (m0Var == null || (strValueOf = m0Var.a()) == null) {
            strValueOf = String.valueOf(qVar.getType());
        }
        d.n0.s variance = qVar.getVariance();
        if (variance != null) {
            int i2 = l0.f12645a[variance.ordinal()];
            if (i2 == 1) {
                return strValueOf;
            }
            if (i2 == 2) {
                return "in " + strValueOf;
            }
            if (i2 == 3) {
                return "out " + strValueOf;
            }
        }
        throw new d.l();
    }

    public final String c(Class<?> cls) {
        return t.areEqual(cls, boolean[].class) ? "kotlin.BooleanArray" : t.areEqual(cls, char[].class) ? "kotlin.CharArray" : t.areEqual(cls, byte[].class) ? "kotlin.ByteArray" : t.areEqual(cls, short[].class) ? "kotlin.ShortArray" : t.areEqual(cls, int[].class) ? "kotlin.IntArray" : t.areEqual(cls, float[].class) ? "kotlin.FloatArray" : t.areEqual(cls, long[].class) ? "kotlin.LongArray" : t.areEqual(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    public boolean equals(Object obj) {
        if (obj instanceof m0) {
            m0 m0Var = (m0) obj;
            if (t.areEqual(getClassifier(), m0Var.getClassifier()) && t.areEqual(getArguments(), m0Var.getArguments()) && isMarkedNullable() == m0Var.isMarkedNullable()) {
                return true;
            }
        }
        return false;
    }

    @Override // d.n0.o
    public List<Annotation> getAnnotations() {
        return d.g0.s.emptyList();
    }

    @Override // d.n0.o
    public List<d.n0.q> getArguments() {
        return this.f12647b;
    }

    @Override // d.n0.o
    public d.n0.c getClassifier() {
        return this.f12646a;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + getArguments().hashCode()) * 31) + Boolean.valueOf(isMarkedNullable()).hashCode();
    }

    @Override // d.n0.o
    public boolean isMarkedNullable() {
        return this.f12648c;
    }

    public String toString() {
        return a() + " (Kotlin reflection is not available)";
    }
}
