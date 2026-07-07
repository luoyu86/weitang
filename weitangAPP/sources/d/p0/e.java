package d.p0;

import java.nio.charset.Charset;
import org.apache.commons.codec.CharEncoding;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f12897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f12898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f12899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f12900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Charset f12901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Charset f12902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Charset f12903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Charset f12904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Charset f12905i;
    public static final e j = new e();

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        d.k0.d.t.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-8\")");
        f12897a = charsetForName;
        Charset charsetForName2 = Charset.forName(CharEncoding.UTF_16);
        d.k0.d.t.checkNotNullExpressionValue(charsetForName2, "Charset.forName(\"UTF-16\")");
        f12898b = charsetForName2;
        Charset charsetForName3 = Charset.forName(CharEncoding.UTF_16BE);
        d.k0.d.t.checkNotNullExpressionValue(charsetForName3, "Charset.forName(\"UTF-16BE\")");
        f12899c = charsetForName3;
        Charset charsetForName4 = Charset.forName(CharEncoding.UTF_16LE);
        d.k0.d.t.checkNotNullExpressionValue(charsetForName4, "Charset.forName(\"UTF-16LE\")");
        f12900d = charsetForName4;
        Charset charsetForName5 = Charset.forName(CharEncoding.US_ASCII);
        d.k0.d.t.checkNotNullExpressionValue(charsetForName5, "Charset.forName(\"US-ASCII\")");
        f12901e = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        d.k0.d.t.checkNotNullExpressionValue(charsetForName6, "Charset.forName(\"ISO-8859-1\")");
        f12902f = charsetForName6;
    }

    public final Charset UTF32() {
        Charset charset = f12903g;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32");
        d.k0.d.t.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-32\")");
        f12903g = charsetForName;
        return charsetForName;
    }

    public final Charset UTF32_BE() {
        Charset charset = f12905i;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        d.k0.d.t.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-32BE\")");
        f12905i = charsetForName;
        return charsetForName;
    }

    public final Charset UTF32_LE() {
        Charset charset = f12904h;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        d.k0.d.t.checkNotNullExpressionValue(charsetForName, "Charset.forName(\"UTF-32LE\")");
        f12904h = charsetForName;
        return charsetForName;
    }
}
