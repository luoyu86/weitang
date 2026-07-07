package d.i0.f.a;

import d.k0.d.t;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    public static final void a(int i2, int i3) {
        if (i3 <= i2) {
            return;
        }
        throw new IllegalStateException(("Debug metadata version mismatch. Expected: " + i2 + ", got " + i3 + ". Please update the Kotlin standard library.").toString());
    }

    public static final f b(a aVar) {
        return (f) aVar.getClass().getAnnotation(f.class);
    }

    public static final int c(a aVar) {
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            t.checkNotNullExpressionValue(declaredField, "field");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(aVar);
            if (!(obj instanceof Integer)) {
                obj = null;
            }
            Integer num = (Integer) obj;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final String[] getSpilledVariableFieldMapping(a aVar) {
        t.checkNotNullParameter(aVar, "$this$getSpilledVariableFieldMapping");
        f fVarB = b(aVar);
        if (fVarB == null) {
            return null;
        }
        a(1, fVarB.v());
        ArrayList arrayList = new ArrayList();
        int iC = c(aVar);
        int[] iArrI = fVarB.i();
        int length = iArrI.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (iArrI[i2] == iC) {
                arrayList.add(fVarB.s()[i2]);
                arrayList.add(fVarB.n()[i2]);
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[]) array;
    }

    public static final StackTraceElement getStackTraceElement(a aVar) {
        String strC;
        t.checkNotNullParameter(aVar, "$this$getStackTraceElementImpl");
        f fVarB = b(aVar);
        if (fVarB == null) {
            return null;
        }
        a(1, fVarB.v());
        int iC = c(aVar);
        int i2 = iC < 0 ? -1 : fVarB.l()[iC];
        String moduleName = i.f12601c.getModuleName(aVar);
        if (moduleName == null) {
            strC = fVarB.c();
        } else {
            strC = moduleName + '/' + fVarB.c();
        }
        return new StackTraceElement(strC, fVarB.m(), fVarB.f(), i2);
    }
}
