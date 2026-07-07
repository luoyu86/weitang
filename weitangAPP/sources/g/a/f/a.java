package g.a.f;

import g.a.a.k3.b;
import g.a.a.v;
import g.a.a.z3.e;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static Enumeration getNames() {
        return b.getNames();
    }

    public static g.a.f.d.a getParameterSpec(String str) {
        e byNameX9 = b.getByNameX9(str);
        if (byNameX9 == null) {
            try {
                byNameX9 = b.getByOIDX9(new v(str));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        if (byNameX9 == null) {
            return null;
        }
        return new g.a.f.d.a(str, byNameX9.getCurve(), byNameX9.getG(), byNameX9.getN(), byNameX9.getH(), byNameX9.getSeed());
    }
}
