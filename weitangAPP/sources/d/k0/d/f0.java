package d.k0.d;

import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes2.dex */
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f12623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d.n0.b[] f12624b;

    static {
        g0 g0Var = null;
        try {
            g0Var = (g0) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (g0Var == null) {
            g0Var = new g0();
        }
        f12623a = g0Var;
        f12624b = new d.n0.b[0];
    }

    public static d.n0.b createKotlinClass(Class cls) {
        return f12623a.createKotlinClass(cls);
    }

    public static d.n0.e function(r rVar) {
        return f12623a.function(rVar);
    }

    public static d.n0.b getOrCreateKotlinClass(Class cls) {
        return f12623a.getOrCreateKotlinClass(cls);
    }

    public static d.n0.b[] getOrCreateKotlinClasses(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return f12624b;
        }
        d.n0.b[] bVarArr = new d.n0.b[length];
        for (int i2 = 0; i2 < length; i2++) {
            bVarArr[i2] = getOrCreateKotlinClass(clsArr[i2]);
        }
        return bVarArr;
    }

    public static d.n0.d getOrCreateKotlinPackage(Class cls) {
        return f12623a.getOrCreateKotlinPackage(cls, "");
    }

    public static d.n0.g mutableProperty0(v vVar) {
        return f12623a.mutableProperty0(vVar);
    }

    public static d.n0.h mutableProperty1(w wVar) {
        return f12623a.mutableProperty1(wVar);
    }

    public static d.n0.i mutableProperty2(x xVar) {
        return f12623a.mutableProperty2(xVar);
    }

    public static d.n0.o nullableTypeOf(d.n0.c cVar) {
        return f12623a.typeOf(cVar, Collections.emptyList(), true);
    }

    public static d.n0.l property0(a0 a0Var) {
        return f12623a.property0(a0Var);
    }

    public static d.n0.m property1(b0 b0Var) {
        return f12623a.property1(b0Var);
    }

    public static d.n0.n property2(c0 c0Var) {
        return f12623a.property2(c0Var);
    }

    public static String renderLambdaToString(u uVar) {
        return f12623a.renderLambdaToString(uVar);
    }

    public static void setUpperBounds(d.n0.p pVar, d.n0.o oVar) {
        f12623a.setUpperBounds(pVar, Collections.singletonList(oVar));
    }

    public static d.n0.o typeOf(d.n0.c cVar) {
        return f12623a.typeOf(cVar, Collections.emptyList(), false);
    }

    public static d.n0.p typeParameter(Object obj, String str, d.n0.s sVar, boolean z) {
        return f12623a.typeParameter(obj, str, sVar, z);
    }

    public static d.n0.b createKotlinClass(Class cls, String str) {
        return f12623a.createKotlinClass(cls, str);
    }

    public static d.n0.b getOrCreateKotlinClass(Class cls, String str) {
        return f12623a.getOrCreateKotlinClass(cls, str);
    }

    public static d.n0.d getOrCreateKotlinPackage(Class cls, String str) {
        return f12623a.getOrCreateKotlinPackage(cls, str);
    }

    public static d.n0.o nullableTypeOf(Class cls) {
        return f12623a.typeOf(getOrCreateKotlinClass(cls), Collections.emptyList(), true);
    }

    public static String renderLambdaToString(q qVar) {
        return f12623a.renderLambdaToString(qVar);
    }

    public static void setUpperBounds(d.n0.p pVar, d.n0.o... oVarArr) {
        f12623a.setUpperBounds(pVar, d.g0.m.toList(oVarArr));
    }

    public static d.n0.o typeOf(Class cls) {
        return f12623a.typeOf(getOrCreateKotlinClass(cls), Collections.emptyList(), false);
    }

    public static d.n0.o nullableTypeOf(Class cls, d.n0.q qVar) {
        return f12623a.typeOf(getOrCreateKotlinClass(cls), Collections.singletonList(qVar), true);
    }

    public static d.n0.o typeOf(Class cls, d.n0.q qVar) {
        return f12623a.typeOf(getOrCreateKotlinClass(cls), Collections.singletonList(qVar), false);
    }

    public static d.n0.o nullableTypeOf(Class cls, d.n0.q qVar, d.n0.q qVar2) {
        return f12623a.typeOf(getOrCreateKotlinClass(cls), Arrays.asList(qVar, qVar2), true);
    }

    public static d.n0.o typeOf(Class cls, d.n0.q qVar, d.n0.q qVar2) {
        return f12623a.typeOf(getOrCreateKotlinClass(cls), Arrays.asList(qVar, qVar2), false);
    }

    public static d.n0.o nullableTypeOf(Class cls, d.n0.q... qVarArr) {
        return f12623a.typeOf(getOrCreateKotlinClass(cls), d.g0.m.toList(qVarArr), true);
    }

    public static d.n0.o typeOf(Class cls, d.n0.q... qVarArr) {
        return f12623a.typeOf(getOrCreateKotlinClass(cls), d.g0.m.toList(qVarArr), false);
    }
}
