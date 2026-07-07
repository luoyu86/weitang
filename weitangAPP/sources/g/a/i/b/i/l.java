package g.a.i.b.i;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes3.dex */
public final class l implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, l> f14484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14486c;

    static {
        HashMap map = new HashMap();
        map.put(a(MessageDigestAlgorithms.SHA_256, 32, 16, 67), new l(16777217, "WOTSP_SHA2-256_W16"));
        map.put(a(MessageDigestAlgorithms.SHA_512, 64, 16, 131), new l(33554434, "WOTSP_SHA2-512_W16"));
        map.put(a("SHAKE128", 32, 16, 67), new l(50331651, "WOTSP_SHAKE128_W16"));
        map.put(a("SHAKE256", 64, 16, 131), new l(67108868, "WOTSP_SHAKE256_W16"));
        f14484a = Collections.unmodifiableMap(map);
    }

    public l(int i2, String str) {
        this.f14485b = i2;
        this.f14486c = str;
    }

    public static String a(String str, int i2, int i3, int i4) {
        Objects.requireNonNull(str, "algorithmName == null");
        return str + "-" + i2 + "-" + i3 + "-" + i4;
    }

    public static l b(String str, int i2, int i3, int i4) {
        Objects.requireNonNull(str, "algorithmName == null");
        return f14484a.get(a(str, i2, i3, i4));
    }

    @Override // g.a.i.b.i.w
    public int getOid() {
        return this.f14485b;
    }

    @Override // g.a.i.b.i.w
    public String toString() {
        return this.f14486c;
    }
}
