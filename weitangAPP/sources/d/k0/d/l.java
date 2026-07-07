package d.k0.d;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l implements d.n0.a, Serializable {
    public static final Object NO_RECEIVER = a.f12644a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient d.n0.a f12638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Class f12640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12641d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f12642e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12643f;

    public static class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12644a = new a();

        private Object readResolve() throws ObjectStreamException {
            return f12644a;
        }
    }

    public l() {
        this(NO_RECEIVER);
    }

    public abstract d.n0.a a();

    public d.n0.a b() {
        d.n0.a aVarCompute = compute();
        if (aVarCompute != this) {
            return aVarCompute;
        }
        throw new d.k0.b();
    }

    @Override // d.n0.a
    public Object call(Object... objArr) {
        return b().call(objArr);
    }

    @Override // d.n0.a
    public Object callBy(Map map) {
        return b().callBy(map);
    }

    public d.n0.a compute() {
        d.n0.a aVar = this.f12638a;
        if (aVar != null) {
            return aVar;
        }
        d.n0.a aVarA = a();
        this.f12638a = aVarA;
        return aVarA;
    }

    @Override // d.n0.a
    public List<Annotation> getAnnotations() {
        return b().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.f12639b;
    }

    @Override // d.n0.a
    public String getName() {
        return this.f12641d;
    }

    public d.n0.d getOwner() {
        Class cls = this.f12640c;
        if (cls == null) {
            return null;
        }
        return this.f12643f ? f0.getOrCreateKotlinPackage(cls) : f0.getOrCreateKotlinClass(cls);
    }

    @Override // d.n0.a
    public List<d.n0.j> getParameters() {
        return b().getParameters();
    }

    @Override // d.n0.a
    public d.n0.o getReturnType() {
        return b().getReturnType();
    }

    public String getSignature() {
        return this.f12642e;
    }

    @Override // d.n0.a
    public List<d.n0.p> getTypeParameters() {
        return b().getTypeParameters();
    }

    @Override // d.n0.a
    public d.n0.t getVisibility() {
        return b().getVisibility();
    }

    @Override // d.n0.a
    public boolean isAbstract() {
        return b().isAbstract();
    }

    @Override // d.n0.a
    public boolean isFinal() {
        return b().isFinal();
    }

    @Override // d.n0.a
    public boolean isOpen() {
        return b().isOpen();
    }

    @Override // d.n0.a
    public boolean isSuspend() {
        return b().isSuspend();
    }

    public l(Object obj) {
        this(obj, null, null, null, false);
    }

    public l(Object obj, Class cls, String str, String str2, boolean z) {
        this.f12639b = obj;
        this.f12640c = cls;
        this.f12641d = str;
        this.f12642e = str2;
        this.f12643f = z;
    }
}
