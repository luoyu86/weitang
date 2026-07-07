package d.p0;

import com.tom_roush.pdfbox.pdmodel.interactive.measurement.PDNumberFormatDictionary;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class a<T> extends d.k0.d.u implements d.k0.c.l<T, Boolean> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12933b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(int i2) {
            super(1);
            this.f12933b = i2;
        }

        @Override // d.k0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke((Enum) obj));
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)Z */
        /* JADX WARN: Multi-variable type inference failed */
        public final boolean invoke(Enum r3) {
            g gVar = (g) r3;
            return (this.f12933b & gVar.getMask()) == gVar.getValue();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class b<T> extends d.k0.d.u implements d.k0.c.l<T, Boolean> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f12934b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i2) {
            super(1);
            this.f12934b = i2;
        }

        @Override // d.k0.c.l
        public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
            return Boolean.valueOf(invoke((Enum) obj));
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)Z */
        /* JADX WARN: Multi-variable type inference failed */
        public final boolean invoke(Enum r3) {
            g gVar = (g) r3;
            return (this.f12934b & gVar.getMask()) == gVar.getValue();
        }
    }

    public static final j a(Matcher matcher, int i2, CharSequence charSequence) {
        if (matcher.find(i2)) {
            return new k(matcher, charSequence);
        }
        return null;
    }

    public static final /* synthetic */ <T extends Enum<T> & g> Set<T> b(int i2) {
        d.k0.d.t.reifiedOperationMarker(4, PDNumberFormatDictionary.FRACTIONAL_DISPLAY_TRUNCATE);
        EnumSet enumSetAllOf = EnumSet.allOf(Enum.class);
        d.g0.x.retainAll(enumSetAllOf, new b(i2));
        Set<T> setUnmodifiableSet = Collections.unmodifiableSet(enumSetAllOf);
        d.k0.d.t.checkNotNullExpressionValue(setUnmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        return setUnmodifiableSet;
    }

    public static final j c(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new k(matcher, charSequence);
        }
        return null;
    }

    public static final d.m0.k d(MatchResult matchResult) {
        return d.m0.p.until(matchResult.start(), matchResult.end());
    }

    public static final d.m0.k e(MatchResult matchResult, int i2) {
        return d.m0.p.until(matchResult.start(i2), matchResult.end(i2));
    }

    public static final int f(Iterable<? extends g> iterable) {
        Iterator<? extends g> it = iterable.iterator();
        int value = 0;
        while (it.hasNext()) {
            value |= it.next().getValue();
        }
        return value;
    }
}
