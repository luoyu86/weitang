package d.p0;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class p {
    public static final <T extends Appendable> T append(T t, CharSequence... charSequenceArr) throws IOException {
        d.k0.d.t.checkNotNullParameter(t, "$this$append");
        d.k0.d.t.checkNotNullParameter(charSequenceArr, com.alipay.sdk.m.p0.b.f5579d);
        for (CharSequence charSequence : charSequenceArr) {
            t.append(charSequence);
        }
        return t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> void appendElement(Appendable appendable, T t, d.k0.c.l<? super T, ? extends CharSequence> lVar) {
        d.k0.d.t.checkNotNullParameter(appendable, "$this$appendElement");
        if (lVar != null) {
            appendable.append(lVar.invoke(t));
            return;
        }
        if (t != 0 ? t instanceof CharSequence : true) {
            appendable.append((CharSequence) t);
        } else if (t instanceof Character) {
            appendable.append(((Character) t).charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }

    public static final <T extends Appendable> T appendRange(T t, CharSequence charSequence, int i2, int i3) {
        d.k0.d.t.checkNotNullParameter(t, "$this$appendRange");
        d.k0.d.t.checkNotNullParameter(charSequence, com.alipay.sdk.m.p0.b.f5579d);
        T t2 = (T) t.append(charSequence, i2, i3);
        Objects.requireNonNull(t2, "null cannot be cast to non-null type T");
        return t2;
    }
}
