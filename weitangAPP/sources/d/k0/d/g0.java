package d.k0.d;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g0 {
    public d.n0.b createKotlinClass(Class cls) {
        return new n(cls);
    }

    public d.n0.e function(r rVar) {
        return rVar;
    }

    public d.n0.b getOrCreateKotlinClass(Class cls) {
        return new n(cls);
    }

    public d.n0.d getOrCreateKotlinPackage(Class cls, String str) {
        return new z(cls, str);
    }

    public d.n0.g mutableProperty0(v vVar) {
        return vVar;
    }

    public d.n0.h mutableProperty1(w wVar) {
        return wVar;
    }

    public d.n0.i mutableProperty2(x xVar) {
        return xVar;
    }

    public d.n0.l property0(a0 a0Var) {
        return a0Var;
    }

    public d.n0.m property1(b0 b0Var) {
        return b0Var;
    }

    public d.n0.n property2(c0 c0Var) {
        return c0Var;
    }

    public String renderLambdaToString(u uVar) {
        return renderLambdaToString((q) uVar);
    }

    public void setUpperBounds(d.n0.p pVar, List<d.n0.o> list) {
        ((k0) pVar).setUpperBounds(list);
    }

    public d.n0.o typeOf(d.n0.c cVar, List<d.n0.q> list, boolean z) {
        return new m0(cVar, list, z);
    }

    public d.n0.p typeParameter(Object obj, String str, d.n0.s sVar, boolean z) {
        return new k0(obj, str, sVar, z);
    }

    public d.n0.b createKotlinClass(Class cls, String str) {
        return new n(cls);
    }

    public d.n0.b getOrCreateKotlinClass(Class cls, String str) {
        return new n(cls);
    }

    public String renderLambdaToString(q qVar) {
        String string = qVar.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith("kotlin.jvm.functions.") ? string.substring(21) : string;
    }
}
