package g.a.d;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class b extends Permission {
    public static final String DEFAULT_RANDOM = "defaultRandomConfig";
    public static final String GLOBAL_CONFIG = "globalConfig";
    public static final String THREAD_LOCAL_CONFIG = "threadLocalConfig";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f13714a;

    public b(String str) {
        super(str);
        HashSet hashSet = new HashSet();
        this.f13714a = hashSet;
        hashSet.add(str);
    }

    public boolean equals(Object obj) {
        return (obj instanceof b) && this.f13714a.equals(((b) obj).f13714a);
    }

    @Override // java.security.Permission
    public String getActions() {
        return this.f13714a.toString();
    }

    public int hashCode() {
        return this.f13714a.hashCode();
    }

    @Override // java.security.Permission
    public boolean implies(Permission permission) {
        if (!(permission instanceof b)) {
            return false;
        }
        b bVar = (b) permission;
        return getName().equals(bVar.getName()) || this.f13714a.containsAll(bVar.f13714a);
    }
}
