package d.p0;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class t extends s {
    public static final Appendable appendln(Appendable appendable) throws IOException {
        d.k0.d.t.checkNotNullParameter(appendable, "$this$appendln");
        Appendable appendableAppend = appendable.append(b0.f12895a);
        d.k0.d.t.checkNotNullExpressionValue(appendableAppend, "append(SystemProperties.LINE_SEPARATOR)");
        return appendableAppend;
    }

    public static final StringBuilder clear(StringBuilder sb) {
        d.k0.d.t.checkNotNullParameter(sb, "$this$clear");
        sb.setLength(0);
        return sb;
    }

    public static final StringBuilder appendln(StringBuilder sb) {
        d.k0.d.t.checkNotNullParameter(sb, "$this$appendln");
        sb.append(b0.f12895a);
        d.k0.d.t.checkNotNullExpressionValue(sb, "append(SystemProperties.LINE_SEPARATOR)");
        return sb;
    }
}
