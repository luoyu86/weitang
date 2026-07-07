package d.j0;

import d.e;
import d.k0.d.t;
import d.p0.y;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12610a;

    /* JADX WARN: Removed duplicated region for block: B:43:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d.j0.b.<clinit>():void");
    }

    public static final int a() {
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        int iIndexOf$default = y.indexOf$default((CharSequence) property, '.', 0, false, 6, (Object) null);
        if (iIndexOf$default < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i2 = iIndexOf$default + 1;
        int iIndexOf$default2 = y.indexOf$default((CharSequence) property, '.', i2, false, 4, (Object) null);
        if (iIndexOf$default2 < 0) {
            iIndexOf$default2 = property.length();
        }
        String strSubstring = property.substring(0, iIndexOf$default);
        t.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strSubstring2 = property.substring(i2, iIndexOf$default2);
        t.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(strSubstring) * 65536) + Integer.parseInt(strSubstring2);
        } catch (NumberFormatException unused2) {
            return 65542;
        }
    }

    public static final boolean apiVersionIsAtLeast(int i2, int i3, int i4) {
        return e.f12422a.isAtLeast(i2, i3, i4);
    }
}
