package g.a.g.a.c0;

import com.tom_roush.pdfbox.contentstream.operator.OperatorName;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BigInteger f14083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BigInteger f14084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BigInteger f14085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BigInteger f14086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BigInteger f14087e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final BigInteger f14088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f14089g;

    public g(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2, BigInteger bigInteger, BigInteger bigInteger2, int i2) {
        a(bigIntegerArr, com.alipay.sdk.m.x.c.f5758c);
        a(bigIntegerArr2, com.alipay.sdk.m.x.c.f5759d);
        this.f14083a = bigIntegerArr[0];
        this.f14084b = bigIntegerArr[1];
        this.f14085c = bigIntegerArr2[0];
        this.f14086d = bigIntegerArr2[1];
        this.f14087e = bigInteger;
        this.f14088f = bigInteger2;
        this.f14089g = i2;
    }

    public static void a(BigInteger[] bigIntegerArr, String str) {
        if (bigIntegerArr == null || bigIntegerArr.length != 2 || bigIntegerArr[0] == null || bigIntegerArr[1] == null) {
            throw new IllegalArgumentException(OperatorName.SHOW_TEXT_LINE + str + "' must consist of exactly 2 (non-null) values");
        }
    }

    public int getBits() {
        return this.f14089g;
    }

    public BigInteger getG1() {
        return this.f14087e;
    }

    public BigInteger getG2() {
        return this.f14088f;
    }

    public BigInteger getV1A() {
        return this.f14083a;
    }

    public BigInteger getV1B() {
        return this.f14084b;
    }

    public BigInteger getV2A() {
        return this.f14085c;
    }

    public BigInteger getV2B() {
        return this.f14086d;
    }
}
