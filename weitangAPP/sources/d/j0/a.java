package d.j0;

import d.g0.l;
import d.g0.s;
import d.k0.d.t;
import d.l0.f;
import d.p0.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: d.j0.a$a, reason: collision with other inner class name */
    public static final class C0239a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Method f12607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Method f12608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C0239a f12609c = new C0239a();

        /* JADX WARN: Removed duplicated region for block: B:10:0x0042  */
        static {
            /*
                d.j0.a$a r0 = new d.j0.a$a
                r0.<init>()
                d.j0.a.C0239a.f12609c = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                d.k0.d.t.checkNotNullExpressionValue(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L15:
                java.lang.String r5 = "it"
                r6 = 0
                if (r4 >= r2) goto L49
                r7 = r1[r4]
                d.k0.d.t.checkNotNullExpressionValue(r7, r5)
                java.lang.String r8 = r7.getName()
                java.lang.String r9 = "addSuppressed"
                boolean r8 = d.k0.d.t.areEqual(r8, r9)
                if (r8 == 0) goto L42
                java.lang.Class[] r8 = r7.getParameterTypes()
                java.lang.String r9 = "it.parameterTypes"
                d.k0.d.t.checkNotNullExpressionValue(r8, r9)
                java.lang.Object r8 = d.g0.m.singleOrNull(r8)
                java.lang.Class r8 = (java.lang.Class) r8
                boolean r8 = d.k0.d.t.areEqual(r8, r0)
                if (r8 == 0) goto L42
                r8 = 1
                goto L43
            L42:
                r8 = 0
            L43:
                if (r8 == 0) goto L46
                goto L4a
            L46:
                int r4 = r4 + 1
                goto L15
            L49:
                r7 = r6
            L4a:
                d.j0.a.C0239a.f12607a = r7
                int r0 = r1.length
            L4d:
                if (r3 >= r0) goto L65
                r2 = r1[r3]
                d.k0.d.t.checkNotNullExpressionValue(r2, r5)
                java.lang.String r4 = r2.getName()
                java.lang.String r7 = "getSuppressed"
                boolean r4 = d.k0.d.t.areEqual(r4, r7)
                if (r4 == 0) goto L62
                r6 = r2
                goto L65
            L62:
                int r3 = r3 + 1
                goto L4d
            L65:
                d.j0.a.C0239a.f12608b = r6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: d.j0.a.C0239a.<clinit>():void");
        }
    }

    public void addSuppressed(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        t.checkNotNullParameter(th, "cause");
        t.checkNotNullParameter(th2, "exception");
        Method method = C0239a.f12607a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public f defaultPlatformRandom() {
        return new d.l0.b();
    }

    public h getMatchResultNamedGroup(MatchResult matchResult, String str) {
        t.checkNotNullParameter(matchResult, "matchResult");
        t.checkNotNullParameter(str, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    public List<Throwable> getSuppressed(Throwable th) {
        Object objInvoke;
        List<Throwable> listAsList;
        t.checkNotNullParameter(th, "exception");
        Method method = C0239a.f12608b;
        return (method == null || (objInvoke = method.invoke(th, new Object[0])) == null || (listAsList = l.asList((Throwable[]) objInvoke)) == null) ? s.emptyList() : listAsList;
    }
}
