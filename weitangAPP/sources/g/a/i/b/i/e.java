package g.a.i.b.i;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, e> f14456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14458c;

    static {
        HashMap map = new HashMap();
        map.put(a(MessageDigestAlgorithms.SHA_256, 32, 16, 67, 10), new e(1, "XMSS_SHA2_10_256"));
        map.put(a(MessageDigestAlgorithms.SHA_256, 32, 16, 67, 16), new e(2, "XMSS_SHA2_16_256"));
        map.put(a(MessageDigestAlgorithms.SHA_256, 32, 16, 67, 20), new e(3, "XMSS_SHA2_20_256"));
        map.put(a(MessageDigestAlgorithms.SHA_512, 64, 16, 131, 10), new e(4, "XMSS_SHA2_10_512"));
        map.put(a(MessageDigestAlgorithms.SHA_512, 64, 16, 131, 16), new e(5, "XMSS_SHA2_16_512"));
        map.put(a(MessageDigestAlgorithms.SHA_512, 64, 16, 131, 20), new e(6, "XMSS_SHA2_20_512"));
        map.put(a("SHAKE128", 32, 16, 67, 10), new e(7, "XMSS_SHAKE_10_256"));
        map.put(a("SHAKE128", 32, 16, 67, 16), new e(8, "XMSS_SHAKE_16_256"));
        map.put(a("SHAKE128", 32, 16, 67, 20), new e(9, "XMSS_SHAKE_20_256"));
        map.put(a("SHAKE256", 64, 16, 131, 10), new e(10, "XMSS_SHAKE_10_512"));
        map.put(a("SHAKE256", 64, 16, 131, 16), new e(11, "XMSS_SHAKE_16_512"));
        map.put(a("SHAKE256", 64, 16, 131, 20), new e(12, "XMSS_SHAKE_20_512"));
        f14456a = Collections.unmodifiableMap(map);
    }

    public e(int i2, String str) {
        this.f14457b = i2;
        this.f14458c = str;
    }

    public static String a(String str, int i2, int i3, int i4, int i5) {
        Objects.requireNonNull(str, "algorithmName == null");
        return str + "-" + i2 + "-" + i3 + "-" + i4 + "-" + i5;
    }

    public static e lookup(String str, int i2, int i3, int i4, int i5) {
        Objects.requireNonNull(str, "algorithmName == null");
        return f14456a.get(a(str, i2, i3, i4, i5));
    }

    @Override // g.a.i.b.i.w
    public int getOid() {
        return this.f14457b;
    }

    @Override // g.a.i.b.i.w
    public String toString() {
        return this.f14458c;
    }
}
