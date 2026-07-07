package g.a.d;

import java.math.BigInteger;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Permission f13715a = new g.a.d.b(g.a.d.b.GLOBAL_CONFIG);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Permission f13716b = new g.a.d.b(g.a.d.b.THREAD_LOCAL_CONFIG);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Permission f13717c = new g.a.d.b(g.a.d.b.DEFAULT_RANDOM);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<Map<String, Object[]>> f13718d = new ThreadLocal<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Object[]> f13719e = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Object f13720f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static SecureRandom f13721g;

    public static class a implements PrivilegedAction<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SecurityManager f13722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Permission f13723b;

        public a(SecurityManager securityManager, Permission permission) {
            this.f13722a = securityManager;
            this.f13723b = permission;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            this.f13722a.checkPermission(this.f13723b);
            return null;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f13724a = new b("ecImplicitlyCA", g.a.a.z3.e.class);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f13725b = new b("dhDefaultParams", g.a.d.n.b.class);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f13726c = new b("dsaDefaultParams", g.a.d.n.d.class);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f13727d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Class f13728e;

        public b(String str, Class cls) {
            this.f13727d = str;
            this.f13728e = cls;
        }
    }

    static {
        g.a.d.n.d dVar = new g.a.d.n.d(new BigInteger("fca682ce8e12caba26efccf7110e526db078b05edecbcd1eb4a208f3ae1617ae01f35b91a47e6df63413c5e12ed0899bcd132acd50d99151bdc43ee737592e17", 16), new BigInteger("962eddcc369cba8ebb260ee6b6a126d9346e38c5", 16), new BigInteger("678471b27a9cf44ee91a49c5147db1a9aaf244f05a434d6486931d2d14271b9e35030b71fd73da179069b32e2935630e1c2062354d0da20a6c416e50be794ca4", 16), new g.a.d.n.e(g.a.j.r.c.decodeStrict("b869c82b35d70e1b1ff91b28e37a62ecdc34409b"), 123));
        g.a.d.n.d dVar2 = new g.a.d.n.d(new BigInteger("e9e642599d355f37c97ffd3567120b8e25c9cd43e927b3a9670fbec5d890141922d2c3b3ad2480093799869d1e846aab49fab0ad26d2ce6a22219d470bce7d777d4a21fbe9c270b57f607002f3cef8393694cf45ee3688c11a8c56ab127a3daf", 16), new BigInteger("9cdbd84c9f1ac2f38d0f80f42ab952e7338bf511", 16), new BigInteger("30470ad5a005fb14ce2d9dcd87e38bc7d1b1c5facbaecbe95f190aa7a31d23c4dbbcbe06174544401a5b2c020965d8c2bd2171d3668445771f74ba084d2029d83c1c158547f3a9f1a2715be23d51ae4d3e5a1f6a7064f316933a346d3f529252", 16), new g.a.d.n.e(g.a.j.r.c.decodeStrict("77d0f8c4dad15eb8c4f2f8d6726cefd96d5bb399"), 263));
        g.a.d.n.d dVar3 = new g.a.d.n.d(new BigInteger("fd7f53811d75122952df4a9c2eece4e7f611b7523cef4400c31e3f80b6512669455d402251fb593d8d58fabfc5f5ba30f6cb9b556cd7813b801d346ff26660b76b9950a5a49f9fe8047b1022c24fbba9d7feb7c61bf83b57e7c6a8a6150f04fb83f6d3c51ec3023554135a169132f675f3ae2b61d72aeff22203199dd14801c7", 16), new BigInteger("9760508f15230bccb292b982a2eb840bf0581cf5", 16), new BigInteger("f7e1a085d69b3ddecbbcab5c36b857b97994afbbfa3aea82f9574c0b3d0782675159578ebad4594fe67107108180b449167123e84c281613b7cf09328cc8a6e13c167a8b547c8d28e0a3ae1e2bb3a675916ea37f0bfa213562f1fb627a01243bcca4f1bea8519089a883dfe15ae59f06928b665e807b552564014c3bfecf492a", 16), new g.a.d.n.e(g.a.j.r.c.decodeStrict("8d5155894229d5e689ee01e6018a237e2cae64cd"), 92));
        g.a.d.n.d dVar4 = new g.a.d.n.d(new BigInteger("95475cf5d93e596c3fcd1d902add02f427f5f3c7210313bb45fb4d5bb2e5fe1cbd678cd4bbdd84c9836be1f31c0777725aeb6c2fc38b85f48076fa76bcd8146cc89a6fb2f706dd719898c2083dc8d896f84062e2c9c94d137b054a8d8096adb8d51952398eeca852a0af12df83e475aa65d4ec0c38a9560d5661186ff98b9fc9eb60eee8b030376b236bc73be3acdbd74fd61c1d2475fa3077b8f080467881ff7e1ca56fee066d79506ade51edbb5443a563927dbc4ba520086746175c8885925ebc64c6147906773496990cb714ec667304e261faee33b3cbdf008e0c3fa90650d97d3909c9275bf4ac86ffcb3d03e6dfc8ada5934242dd6d3bcca2a406cb0b", 16), new BigInteger("f8183668ba5fc5bb06b5981e6d8b795d30b8978d43ca0ec572e37e09939a9773", 16), new BigInteger("42debb9da5b3d88cc956e08787ec3f3a09bba5f48b889a74aaf53174aa0fbe7e3c5b8fcd7a53bef563b0e98560328960a9517f4014d3325fc7962bf1e049370d76d1314a76137e792f3f0db859d095e4a5b932024f079ecf2ef09c797452b0770e1350782ed57ddf794979dcef23cb96f183061965c4ebc93c9c71c56b925955a75f94cccf1449ac43d586d0beee43251b0b2287349d68de0d144403f13e802f4146d882e057af19b6f6275c6676c8fa0e3ca2713a3257fd1b27d0639f695e347d8d1cf9ac819a26ca9b04cb0eb9b7b035988d15bbac65212a55239cfc7e58fae38d7250ab9991ffbc97134025fe8ce04c4399ad96569be91a546f4978693c7a", 16), new g.a.d.n.e(g.a.j.r.c.decodeStrict("b0b4417601b59cbc9d8ac8f935cadaec4f5fbb2f23785609ae466748d9b5a536"), 497));
        d(b.f13726c, dVar, dVar2, dVar3, dVar4);
        d(b.f13725b, g(dVar), g(dVar2), g(dVar3), g(dVar4));
    }

    public static void a(Permission permission) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            AccessController.doPrivileged(new a(securityManager, permission));
        }
    }

    public static int b(int i2) {
        if (i2 <= 1024) {
            return 160;
        }
        if (i2 <= 2048) {
            return 224;
        }
        if (i2 <= 3072) {
            return 256;
        }
        return i2 <= 7680 ? 384 : 512;
    }

    public static Object[] c(b bVar) {
        ThreadLocal<Map<String, Object[]>> threadLocal = f13718d;
        Map<String, Object[]> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        return map.remove(bVar.f13727d);
    }

    public static <T> T[] clearGlobalProperty(b bVar) {
        a(f13715a);
        c(bVar);
        return (T[]) f13719e.remove(bVar.f13727d);
    }

    public static <T> T[] clearThreadProperty(b bVar) {
        a(f13716b);
        return (T[]) c(bVar);
    }

    public static <T> void d(b bVar, T... tArr) {
        if (!bVar.f13728e.isAssignableFrom(tArr[0].getClass())) {
            throw new IllegalArgumentException("Bad property value passed");
        }
        e(bVar, tArr);
        f13719e.put(bVar.f13727d, tArr);
    }

    public static <T> void e(b bVar, T[] tArr) {
        ThreadLocal<Map<String, Object[]>> threadLocal = f13718d;
        Map<String, Object[]> map = threadLocal.get();
        if (map == null) {
            map = new HashMap<>();
            threadLocal.set(map);
        }
        map.put(bVar.f13727d, tArr);
    }

    public static Object[] f(b bVar) {
        Map<String, Object[]> map = f13718d.get();
        if (map == null || !map.containsKey(bVar.f13727d)) {
            map = f13719e;
        }
        return map.get(bVar.f13727d);
    }

    public static g.a.d.n.b g(g.a.d.n.d dVar) {
        return new g.a.d.n.b(dVar.getP(), dVar.getG(), dVar.getQ(), b(dVar.getP().bitLength()), 0, null, new g.a.d.n.c(dVar.getValidationParameters().getSeed(), dVar.getValidationParameters().getCounter()));
    }

    public static <T> T getProperty(b bVar) {
        Object[] objArrF = f(bVar);
        if (objArrF != null) {
            return (T) objArrF[0];
        }
        return null;
    }

    public static SecureRandom getSecureRandom() {
        SecureRandom secureRandom;
        Object obj = f13720f;
        synchronized (obj) {
            SecureRandom secureRandom2 = f13721g;
            if (secureRandom2 != null) {
                return secureRandom2;
            }
            SecureRandom secureRandom3 = new SecureRandom();
            synchronized (obj) {
                if (f13721g == null) {
                    f13721g = secureRandom3;
                }
                secureRandom = f13721g;
            }
            return secureRandom;
        }
    }

    public static SecureRandom getSecureRandom(SecureRandom secureRandom) {
        return secureRandom == null ? getSecureRandom() : secureRandom;
    }

    /* JADX WARN: Type inference failed for: r4v5, types: [T, g.a.d.n.d] */
    /* JADX WARN: Type inference failed for: r4v8, types: [T, g.a.d.n.b] */
    public static <T> T getSizedProperty(b bVar, int i2) {
        Object[] objArrF = f(bVar);
        if (objArrF == null) {
            return null;
        }
        int i3 = 0;
        if (bVar.f13728e.isAssignableFrom(g.a.d.n.b.class)) {
            while (i3 != objArrF.length) {
                ?? r4 = (T) ((g.a.d.n.b) objArrF[i3]);
                if (r4.getP().bitLength() == i2) {
                    return r4;
                }
                i3++;
            }
        } else if (bVar.f13728e.isAssignableFrom(g.a.d.n.d.class)) {
            while (i3 != objArrF.length) {
                ?? r42 = (T) ((g.a.d.n.d) objArrF[i3]);
                if (r42.getP().bitLength() == i2) {
                    return r42;
                }
                i3++;
            }
        }
        return null;
    }

    public static <T> T[] getSizedProperty(b bVar) {
        Object[] objArrF = f(bVar);
        if (objArrF == null) {
            return null;
        }
        return (T[]) ((Object[]) objArrF.clone());
    }

    public static <T> void setGlobalProperty(b bVar, T... tArr) {
        a(f13715a);
        d(bVar, (Object[]) tArr.clone());
    }

    public static void setSecureRandom(SecureRandom secureRandom) {
        a(f13717c);
        synchronized (f13720f) {
            f13721g = secureRandom;
        }
    }

    public static <T> void setThreadProperty(b bVar, T... tArr) {
        a(f13716b);
        if (!bVar.f13728e.isAssignableFrom(tArr[0].getClass())) {
            throw new IllegalArgumentException("Bad property value passed");
        }
        e(bVar, (Object[]) tArr.clone());
    }
}
