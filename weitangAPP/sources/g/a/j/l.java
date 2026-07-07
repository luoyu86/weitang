package g.a.j;

import java.math.BigInteger;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Security;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f14659a = new ThreadLocal();

    public static class a implements PrivilegedAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14660a;

        public a(String str) {
            this.f14660a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return Security.getProperty(this.f14660a);
        }
    }

    public static class b implements PrivilegedAction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f14661a;

        public b(String str) {
            this.f14661a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return System.getProperty(this.f14661a);
        }
    }

    public static boolean a(String str) {
        if (str == null || str.length() != 5) {
            return false;
        }
        if (str.charAt(0) != 'f' && str.charAt(0) != 'F') {
            return false;
        }
        if (str.charAt(1) != 'a' && str.charAt(1) != 'A') {
            return false;
        }
        if (str.charAt(2) != 'l' && str.charAt(2) != 'L') {
            return false;
        }
        if (str.charAt(3) == 's' || str.charAt(3) == 'S') {
            return str.charAt(4) == 'e' || str.charAt(4) == 'E';
        }
        return false;
    }

    public static BigInteger asBigInteger(String str) {
        String propertyValue = getPropertyValue(str);
        if (propertyValue != null) {
            return new BigInteger(propertyValue);
        }
        return null;
    }

    public static Set<String> asKeySet(String str) {
        HashSet hashSet = new HashSet();
        String propertyValue = getPropertyValue(str);
        if (propertyValue != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(propertyValue, ",");
            while (stringTokenizer.hasMoreElements()) {
                hashSet.add(q.toLowerCase(stringTokenizer.nextToken()).trim());
            }
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public static boolean b(String str) {
        if (str == null || str.length() != 4) {
            return false;
        }
        if (str.charAt(0) != 't' && str.charAt(0) != 'T') {
            return false;
        }
        if (str.charAt(1) != 'r' && str.charAt(1) != 'R') {
            return false;
        }
        if (str.charAt(2) == 'u' || str.charAt(2) == 'U') {
            return str.charAt(3) == 'e' || str.charAt(3) == 'E';
        }
        return false;
    }

    public static String getPropertyValue(String str) {
        String str2;
        String str3 = (String) AccessController.doPrivileged(new a(str));
        if (str3 != null) {
            return str3;
        }
        Map map = (Map) f14659a.get();
        return (map == null || (str2 = (String) map.get(str)) == null) ? (String) AccessController.doPrivileged(new b(str)) : str2;
    }

    public static boolean isOverrideSet(String str) {
        try {
            return b(getPropertyValue(str));
        } catch (AccessControlException unused) {
            return false;
        }
    }

    public static boolean isOverrideSetTo(String str, boolean z) {
        try {
            String propertyValue = getPropertyValue(str);
            return z ? b(propertyValue) : a(propertyValue);
        } catch (AccessControlException unused) {
            return false;
        }
    }

    public static boolean removeThreadOverride(String str) {
        String str2;
        ThreadLocal threadLocal = f14659a;
        Map map = (Map) threadLocal.get();
        if (map == null || (str2 = (String) map.remove(str)) == null) {
            return false;
        }
        if (map.isEmpty()) {
            threadLocal.remove();
        }
        return "true".equals(q.toLowerCase(str2));
    }

    public static boolean setThreadOverride(String str, boolean z) {
        boolean zIsOverrideSet = isOverrideSet(str);
        ThreadLocal threadLocal = f14659a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
        }
        map.put(str, z ? "true" : "false");
        return zIsOverrideSet;
    }
}
