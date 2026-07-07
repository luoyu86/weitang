package d.p0;

/* JADX INFO: loaded from: classes2.dex */
public class u extends t {
    public static final StringBuilder append(StringBuilder sb, String... strArr) {
        d.k0.d.t.checkNotNullParameter(sb, "$this$append");
        d.k0.d.t.checkNotNullParameter(strArr, com.alipay.sdk.m.p0.b.f5579d);
        for (String str : strArr) {
            sb.append(str);
        }
        return sb;
    }

    public static final StringBuilder append(StringBuilder sb, Object... objArr) {
        d.k0.d.t.checkNotNullParameter(sb, "$this$append");
        d.k0.d.t.checkNotNullParameter(objArr, com.alipay.sdk.m.p0.b.f5579d);
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb;
    }
}
