package g.a.i.b.i;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, d> f14453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f14455c;

    static {
        HashMap map = new HashMap();
        map.put(a(MessageDigestAlgorithms.SHA_256, 32, 16, 67, 20, 2), new d(1, "XMSSMT_SHA2_20/2_256"));
        map.put(a(MessageDigestAlgorithms.SHA_256, 32, 16, 67, 20, 4), new d(2, "XMSSMT_SHA2_20/4_256"));
        map.put(a(MessageDigestAlgorithms.SHA_256, 32, 16, 67, 40, 2), new d(3, "XMSSMT_SHA2_40/2_256"));
        map.put(a(MessageDigestAlgorithms.SHA_256, 32, 16, 67, 40, 2), new d(4, "XMSSMT_SHA2_40/4_256"));
        map.put(a(MessageDigestAlgorithms.SHA_256, 32, 16, 67, 40, 4), new d(5, "XMSSMT_SHA2_40/8_256"));
        map.put(a(MessageDigestAlgorithms.SHA_256, 32, 16, 67, 60, 8), new d(6, "XMSSMT_SHA2_60/3_256"));
        map.put(a(MessageDigestAlgorithms.SHA_256, 32, 16, 67, 60, 6), new d(7, "XMSSMT_SHA2_60/6_256"));
        map.put(a(MessageDigestAlgorithms.SHA_256, 32, 16, 67, 60, 12), new d(8, "XMSSMT_SHA2_60/12_256"));
        map.put(a(MessageDigestAlgorithms.SHA_512, 64, 16, 131, 20, 2), new d(9, "XMSSMT_SHA2_20/2_512"));
        map.put(a(MessageDigestAlgorithms.SHA_512, 64, 16, 131, 20, 4), new d(10, "XMSSMT_SHA2_20/4_512"));
        map.put(a(MessageDigestAlgorithms.SHA_512, 64, 16, 131, 40, 2), new d(11, "XMSSMT_SHA2_40/2_512"));
        map.put(a(MessageDigestAlgorithms.SHA_512, 64, 16, 131, 40, 4), new d(12, "XMSSMT_SHA2_40/4_512"));
        map.put(a(MessageDigestAlgorithms.SHA_512, 64, 16, 131, 40, 8), new d(13, "XMSSMT_SHA2_40/8_512"));
        map.put(a(MessageDigestAlgorithms.SHA_512, 64, 16, 131, 60, 3), new d(14, "XMSSMT_SHA2_60/3_512"));
        map.put(a(MessageDigestAlgorithms.SHA_512, 64, 16, 131, 60, 6), new d(15, "XMSSMT_SHA2_60/6_512"));
        map.put(a(MessageDigestAlgorithms.SHA_512, 64, 16, 131, 60, 12), new d(16, "XMSSMT_SHA2_60/12_512"));
        map.put(a("SHAKE128", 32, 16, 67, 20, 2), new d(17, "XMSSMT_SHAKE_20/2_256"));
        map.put(a("SHAKE128", 32, 16, 67, 20, 4), new d(18, "XMSSMT_SHAKE_20/4_256"));
        map.put(a("SHAKE128", 32, 16, 67, 40, 2), new d(19, "XMSSMT_SHAKE_40/2_256"));
        map.put(a("SHAKE128", 32, 16, 67, 40, 4), new d(20, "XMSSMT_SHAKE_40/4_256"));
        map.put(a("SHAKE128", 32, 16, 67, 40, 8), new d(21, "XMSSMT_SHAKE_40/8_256"));
        map.put(a("SHAKE128", 32, 16, 67, 60, 3), new d(22, "XMSSMT_SHAKE_60/3_256"));
        map.put(a("SHAKE128", 32, 16, 67, 60, 6), new d(23, "XMSSMT_SHAKE_60/6_256"));
        map.put(a("SHAKE128", 32, 16, 67, 60, 12), new d(24, "XMSSMT_SHAKE_60/12_256"));
        map.put(a("SHAKE256", 64, 16, 131, 20, 2), new d(25, "XMSSMT_SHAKE_20/2_512"));
        map.put(a("SHAKE256", 64, 16, 131, 20, 4), new d(26, "XMSSMT_SHAKE_20/4_512"));
        map.put(a("SHAKE256", 64, 16, 131, 40, 2), new d(27, "XMSSMT_SHAKE_40/2_512"));
        map.put(a("SHAKE256", 64, 16, 131, 40, 4), new d(28, "XMSSMT_SHAKE_40/4_512"));
        map.put(a("SHAKE256", 64, 16, 131, 40, 8), new d(29, "XMSSMT_SHAKE_40/8_512"));
        map.put(a("SHAKE256", 64, 16, 131, 60, 3), new d(30, "XMSSMT_SHAKE_60/3_512"));
        map.put(a("SHAKE256", 64, 16, 131, 60, 6), new d(31, "XMSSMT_SHAKE_60/6_512"));
        map.put(a("SHAKE256", 64, 16, 131, 60, 12), new d(32, "XMSSMT_SHAKE_60/12_512"));
        f14453a = Collections.unmodifiableMap(map);
    }

    public d(int i2, String str) {
        this.f14454b = i2;
        this.f14455c = str;
    }

    public static String a(String str, int i2, int i3, int i4, int i5, int i6) {
        Objects.requireNonNull(str, "algorithmName == null");
        return str + "-" + i2 + "-" + i3 + "-" + i4 + "-" + i5 + "-" + i6;
    }

    public static d lookup(String str, int i2, int i3, int i4, int i5, int i6) {
        Objects.requireNonNull(str, "algorithmName == null");
        return f14453a.get(a(str, i2, i3, i4, i5, i6));
    }

    @Override // g.a.i.b.i.w
    public int getOid() {
        return this.f14454b;
    }

    @Override // g.a.i.b.i.w
    public String toString() {
        return this.f14455c;
    }
}
