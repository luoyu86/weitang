package g.a.f.c;

import g.a.d.c;
import g.a.d.n.d;
import g.a.e.b.b.c;
import java.security.Permission;
import java.security.spec.DSAParameterSpec;
import java.security.spec.ECParameterSpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.crypto.spec.DHParameterSpec;

/* JADX INFO: loaded from: classes2.dex */
public class b implements g.a.e.b.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Permission f13871a = new c(a.PROVIDER_NAME, "threadLocalEcImplicitlyCa");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Permission f13872b = new c(a.PROVIDER_NAME, "ecImplicitlyCa");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Permission f13873c = new c(a.PROVIDER_NAME, "threadLocalDhDefaultParams");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Permission f13874d = new c(a.PROVIDER_NAME, "DhDefaultParams");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Permission f13875e = new c(a.PROVIDER_NAME, "acceptableEcCurves");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Permission f13876f = new c(a.PROVIDER_NAME, "additionalEcParameters");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile g.a.f.d.c f13879i;
    public volatile Object j;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ThreadLocal f13877g = new ThreadLocal();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ThreadLocal f13878h = new ThreadLocal();
    public volatile Set k = new HashSet();
    public volatile Map l = new HashMap();

    public void a(String str, Object obj) {
        ThreadLocal threadLocal;
        SecurityManager securityManager = System.getSecurityManager();
        if (str.equals("threadLocalEcImplicitlyCa")) {
            if (securityManager != null) {
                securityManager.checkPermission(f13871a);
            }
            g.a.f.d.c cVarConvertSpec = ((obj instanceof g.a.f.d.c) || obj == null) ? (g.a.f.d.c) obj : g.a.e.b.a.a.a.convertSpec((ECParameterSpec) obj);
            if (cVarConvertSpec != null) {
                this.f13877g.set(cVarConvertSpec);
                return;
            }
            threadLocal = this.f13877g;
        } else {
            if (str.equals("ecImplicitlyCa")) {
                if (securityManager != null) {
                    securityManager.checkPermission(f13872b);
                }
                if ((obj instanceof g.a.f.d.c) || obj == null) {
                    this.f13879i = (g.a.f.d.c) obj;
                    return;
                } else {
                    this.f13879i = g.a.e.b.a.a.a.convertSpec((ECParameterSpec) obj);
                    return;
                }
            }
            if (!str.equals("threadLocalDhDefaultParams")) {
                if (str.equals("DhDefaultParams")) {
                    if (securityManager != null) {
                        securityManager.checkPermission(f13874d);
                    }
                    if (!(obj instanceof DHParameterSpec) && !(obj instanceof DHParameterSpec[]) && obj != null) {
                        throw new IllegalArgumentException("not a valid DHParameterSpec or DHParameterSpec[]");
                    }
                    this.j = obj;
                    return;
                }
                if (str.equals("acceptableEcCurves")) {
                    if (securityManager != null) {
                        securityManager.checkPermission(f13875e);
                    }
                    this.k = (Set) obj;
                    return;
                } else {
                    if (str.equals("additionalEcParameters")) {
                        if (securityManager != null) {
                            securityManager.checkPermission(f13876f);
                        }
                        this.l = (Map) obj;
                        return;
                    }
                    return;
                }
            }
            if (securityManager != null) {
                securityManager.checkPermission(f13873c);
            }
            if (!(obj instanceof DHParameterSpec) && !(obj instanceof DHParameterSpec[]) && obj != null) {
                throw new IllegalArgumentException("not a valid DHParameterSpec");
            }
            threadLocal = this.f13878h;
            if (obj != null) {
                threadLocal.set(obj);
                return;
            }
        }
        threadLocal.remove();
    }

    @Override // g.a.e.b.b.b
    public Set getAcceptableNamedCurves() {
        return Collections.unmodifiableSet(this.k);
    }

    @Override // g.a.e.b.b.b
    public Map getAdditionalECParameters() {
        return Collections.unmodifiableMap(this.l);
    }

    @Override // g.a.e.b.b.b
    public DHParameterSpec getDHDefaultParameters(int i2) {
        Object obj = this.f13878h.get();
        if (obj == null) {
            obj = this.j;
        }
        if (obj instanceof DHParameterSpec) {
            DHParameterSpec dHParameterSpec = (DHParameterSpec) obj;
            if (dHParameterSpec.getP().bitLength() == i2) {
                return dHParameterSpec;
            }
        } else if (obj instanceof DHParameterSpec[]) {
            DHParameterSpec[] dHParameterSpecArr = (DHParameterSpec[]) obj;
            for (int i3 = 0; i3 != dHParameterSpecArr.length; i3++) {
                if (dHParameterSpecArr[i3].getP().bitLength() == i2) {
                    return dHParameterSpecArr[i3];
                }
            }
        }
        g.a.d.n.b bVar = (g.a.d.n.b) g.a.d.c.getSizedProperty(c.b.f13725b, i2);
        if (bVar != null) {
            return new g.a.e.c.a(bVar);
        }
        return null;
    }

    @Override // g.a.e.b.b.b
    public DSAParameterSpec getDSADefaultParameters(int i2) {
        d dVar = (d) g.a.d.c.getSizedProperty(c.b.f13726c, i2);
        if (dVar != null) {
            return new DSAParameterSpec(dVar.getP(), dVar.getQ(), dVar.getG());
        }
        return null;
    }

    @Override // g.a.e.b.b.b
    public g.a.f.d.c getEcImplicitlyCa() {
        g.a.f.d.c cVar = (g.a.f.d.c) this.f13877g.get();
        return cVar != null ? cVar : this.f13879i;
    }
}
