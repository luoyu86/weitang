package d.p0;

import com.chinavisionary.microtang.comment.vo.ScoresBean;
import d.p0.m;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements Serializable {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<? extends n> f12926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Pattern f12927b;

    public static final class a {
        public a() {
        }

        public final int a(int i2) {
            return (i2 & 2) != 0 ? i2 | 64 : i2;
        }

        public final String escape(String str) {
            d.k0.d.t.checkNotNullParameter(str, "literal");
            String strQuote = Pattern.quote(str);
            d.k0.d.t.checkNotNullExpressionValue(strQuote, "Pattern.quote(literal)");
            return strQuote;
        }

        public final String escapeReplacement(String str) {
            d.k0.d.t.checkNotNullParameter(str, "literal");
            String strQuoteReplacement = Matcher.quoteReplacement(str);
            d.k0.d.t.checkNotNullExpressionValue(strQuoteReplacement, "Matcher.quoteReplacement(literal)");
            return strQuoteReplacement;
        }

        public final l fromLiteral(String str) {
            d.k0.d.t.checkNotNullParameter(str, "literal");
            return new l(str, n.LITERAL);
        }

        public /* synthetic */ a(d.k0.d.p pVar) {
            this();
        }
    }

    public static final class b implements Serializable {
        public static final a Companion = new a(null);
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f12928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f12929b;

        public static final class a {
            public a() {
            }

            public /* synthetic */ a(d.k0.d.p pVar) {
                this();
            }
        }

        public b(String str, int i2) {
            d.k0.d.t.checkNotNullParameter(str, "pattern");
            this.f12928a = str;
            this.f12929b = i2;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.f12928a, this.f12929b);
            d.k0.d.t.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern, flags)");
            return new l(patternCompile);
        }

        public final int getFlags() {
            return this.f12929b;
        }

        public final String getPattern() {
            return this.f12928a;
        }
    }

    public static final class c extends d.k0.d.u implements d.k0.c.a<j> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CharSequence f12931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f12932d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CharSequence charSequence, int i2) {
            super(0);
            this.f12931c = charSequence;
            this.f12932d = i2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // d.k0.c.a
        public final j invoke() {
            return l.this.find(this.f12931c, this.f12932d);
        }
    }

    public static final /* synthetic */ class d extends d.k0.d.s implements d.k0.c.l<j, j> {
        public static final d INSTANCE = new d();

        public d() {
            super(1, j.class, "next", "next()Lkotlin/text/MatchResult;", 0);
        }

        @Override // d.k0.c.l
        public final j invoke(j jVar) {
            d.k0.d.t.checkNotNullParameter(jVar, "p1");
            return jVar.next();
        }
    }

    public l(Pattern pattern) {
        d.k0.d.t.checkNotNullParameter(pattern, "nativePattern");
        this.f12927b = pattern;
    }

    public static /* synthetic */ j find$default(l lVar, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lVar.find(charSequence, i2);
    }

    public static /* synthetic */ d.o0.m findAll$default(l lVar, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lVar.findAll(charSequence, i2);
    }

    public static /* synthetic */ List split$default(l lVar, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return lVar.split(charSequence, i2);
    }

    private final Object writeReplace() {
        String strPattern = this.f12927b.pattern();
        d.k0.d.t.checkNotNullExpressionValue(strPattern, "nativePattern.pattern()");
        return new b(strPattern, this.f12927b.flags());
    }

    public final boolean containsMatchIn(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, ScoresBean.SCORE_TYPE_INPUT);
        return this.f12927b.matcher(charSequence).find();
    }

    public final j find(CharSequence charSequence, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, ScoresBean.SCORE_TYPE_INPUT);
        Matcher matcher = this.f12927b.matcher(charSequence);
        d.k0.d.t.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return m.a(matcher, i2, charSequence);
    }

    public final d.o0.m<j> findAll(CharSequence charSequence, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, ScoresBean.SCORE_TYPE_INPUT);
        if (i2 >= 0 && i2 <= charSequence.length()) {
            return d.o0.r.generateSequence((d.k0.c.a) new c(charSequence, i2), (d.k0.c.l) d.INSTANCE);
        }
        throw new IndexOutOfBoundsException("Start index out of bounds: " + i2 + ", input length: " + charSequence.length());
    }

    public final Set<n> getOptions() {
        Set set = this.f12926a;
        if (set != null) {
            return set;
        }
        int iFlags = this.f12927b.flags();
        EnumSet enumSetAllOf = EnumSet.allOf(n.class);
        d.g0.x.retainAll(enumSetAllOf, new m.a(iFlags));
        Set<n> setUnmodifiableSet = Collections.unmodifiableSet(enumSetAllOf);
        d.k0.d.t.checkNotNullExpressionValue(setUnmodifiableSet, "Collections.unmodifiable…mask == it.value }\n    })");
        this.f12926a = setUnmodifiableSet;
        return setUnmodifiableSet;
    }

    public final String getPattern() {
        String strPattern = this.f12927b.pattern();
        d.k0.d.t.checkNotNullExpressionValue(strPattern, "nativePattern.pattern()");
        return strPattern;
    }

    public final j matchEntire(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, ScoresBean.SCORE_TYPE_INPUT);
        Matcher matcher = this.f12927b.matcher(charSequence);
        d.k0.d.t.checkNotNullExpressionValue(matcher, "nativePattern.matcher(input)");
        return m.c(matcher, charSequence);
    }

    public final boolean matches(CharSequence charSequence) {
        d.k0.d.t.checkNotNullParameter(charSequence, ScoresBean.SCORE_TYPE_INPUT);
        return this.f12927b.matcher(charSequence).matches();
    }

    public final String replace(CharSequence charSequence, String str) {
        d.k0.d.t.checkNotNullParameter(charSequence, ScoresBean.SCORE_TYPE_INPUT);
        d.k0.d.t.checkNotNullParameter(str, "replacement");
        String strReplaceAll = this.f12927b.matcher(charSequence).replaceAll(str);
        d.k0.d.t.checkNotNullExpressionValue(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    public final String replaceFirst(CharSequence charSequence, String str) {
        d.k0.d.t.checkNotNullParameter(charSequence, ScoresBean.SCORE_TYPE_INPUT);
        d.k0.d.t.checkNotNullParameter(str, "replacement");
        String strReplaceFirst = this.f12927b.matcher(charSequence).replaceFirst(str);
        d.k0.d.t.checkNotNullExpressionValue(strReplaceFirst, "nativePattern.matcher(in…replaceFirst(replacement)");
        return strReplaceFirst;
    }

    public final List<String> split(CharSequence charSequence, int i2) {
        d.k0.d.t.checkNotNullParameter(charSequence, ScoresBean.SCORE_TYPE_INPUT);
        int iEnd = 0;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
        }
        Matcher matcher = this.f12927b.matcher(charSequence);
        if (!matcher.find() || i2 == 1) {
            return d.g0.r.listOf(charSequence.toString());
        }
        ArrayList arrayList = new ArrayList(i2 > 0 ? d.m0.p.coerceAtMost(i2, 10) : 10);
        int i3 = i2 - 1;
        do {
            arrayList.add(charSequence.subSequence(iEnd, matcher.start()).toString());
            iEnd = matcher.end();
            if (i3 >= 0 && arrayList.size() == i3) {
                break;
            }
        } while (matcher.find());
        arrayList.add(charSequence.subSequence(iEnd, charSequence.length()).toString());
        return arrayList;
    }

    public final Pattern toPattern() {
        return this.f12927b;
    }

    public String toString() {
        String string = this.f12927b.toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "nativePattern.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public l(String str) {
        d.k0.d.t.checkNotNullParameter(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        d.k0.d.t.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern)");
        this(patternCompile);
    }

    public final String replace(CharSequence charSequence, d.k0.c.l<? super j, ? extends CharSequence> lVar) {
        d.k0.d.t.checkNotNullParameter(charSequence, ScoresBean.SCORE_TYPE_INPUT);
        d.k0.d.t.checkNotNullParameter(lVar, "transform");
        int iIntValue = 0;
        j jVarFind$default = find$default(this, charSequence, 0, 2, null);
        if (jVarFind$default == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            d.k0.d.t.checkNotNull(jVarFind$default);
            sb.append(charSequence, iIntValue, jVarFind$default.getRange().getStart().intValue());
            sb.append(lVar.invoke(jVarFind$default));
            iIntValue = jVarFind$default.getRange().getEndInclusive().intValue() + 1;
            jVarFind$default = jVarFind$default.next();
            if (iIntValue >= length) {
                break;
            }
        } while (jVarFind$default != null);
        if (iIntValue < length) {
            sb.append(charSequence, iIntValue, length);
        }
        String string = sb.toString();
        d.k0.d.t.checkNotNullExpressionValue(string, "sb.toString()");
        return string;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public l(String str, n nVar) {
        d.k0.d.t.checkNotNullParameter(str, "pattern");
        d.k0.d.t.checkNotNullParameter(nVar, "option");
        Pattern patternCompile = Pattern.compile(str, Companion.a(nVar.getValue()));
        d.k0.d.t.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern,…nicodeCase(option.value))");
        this(patternCompile);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public l(String str, Set<? extends n> set) {
        d.k0.d.t.checkNotNullParameter(str, "pattern");
        d.k0.d.t.checkNotNullParameter(set, "options");
        Pattern patternCompile = Pattern.compile(str, Companion.a(m.f(set)));
        d.k0.d.t.checkNotNullExpressionValue(patternCompile, "Pattern.compile(pattern,…odeCase(options.toInt()))");
        this(patternCompile);
    }
}
