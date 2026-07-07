package d.p0;

import d.g0.q0;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public enum a {
    UNASSIGNED(0, "Cn"),
    UPPERCASE_LETTER(1, "Lu"),
    LOWERCASE_LETTER(2, "Ll"),
    TITLECASE_LETTER(3, "Lt"),
    MODIFIER_LETTER(4, "Lm"),
    OTHER_LETTER(5, "Lo"),
    NON_SPACING_MARK(6, "Mn"),
    ENCLOSING_MARK(7, "Me"),
    COMBINING_SPACING_MARK(8, "Mc"),
    DECIMAL_DIGIT_NUMBER(9, "Nd"),
    LETTER_NUMBER(10, "Nl"),
    OTHER_NUMBER(11, "No"),
    SPACE_SEPARATOR(12, "Zs"),
    LINE_SEPARATOR(13, "Zl"),
    PARAGRAPH_SEPARATOR(14, "Zp"),
    CONTROL(15, "Cc"),
    FORMAT(16, "Cf"),
    PRIVATE_USE(18, "Co"),
    SURROGATE(19, "Cs"),
    DASH_PUNCTUATION(20, "Pd"),
    START_PUNCTUATION(21, "Ps"),
    END_PUNCTUATION(22, "Pe"),
    CONNECTOR_PUNCTUATION(23, "Pc"),
    OTHER_PUNCTUATION(24, "Po"),
    MATH_SYMBOL(25, "Sm"),
    CURRENCY_SYMBOL(26, "Sc"),
    MODIFIER_SYMBOL(27, "Sk"),
    OTHER_SYMBOL(28, "So"),
    INITIAL_QUOTE_PUNCTUATION(29, "Pi"),
    FINAL_QUOTE_PUNCTUATION(30, "Pf");


    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12882c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f12883d;
    public static final b Companion = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d.g f12881b = d.i.lazy(C0242a.INSTANCE);

    /* JADX INFO: renamed from: d.p0.a$a, reason: collision with other inner class name */
    public static final class C0242a extends d.k0.d.u implements d.k0.c.a<Map<Integer, ? extends a>> {
        public static final C0242a INSTANCE = new C0242a();

        public C0242a() {
            super(0);
        }

        @Override // d.k0.c.a
        public final Map<Integer, ? extends a> invoke() {
            a[] aVarArrValues = a.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(aVarArrValues.length), 16));
            for (a aVar : aVarArrValues) {
                linkedHashMap.put(Integer.valueOf(aVar.getValue()), aVar);
            }
            return linkedHashMap;
        }
    }

    public static final class b {
        public b() {
        }

        public final Map<Integer, a> a() {
            d.g gVar = a.f12881b;
            b bVar = a.Companion;
            return (Map) gVar.getValue();
        }

        public final a valueOf(int i2) {
            a aVar = a().get(Integer.valueOf(i2));
            if (aVar != null) {
                return aVar;
            }
            throw new IllegalArgumentException("Category #" + i2 + " is not defined.");
        }

        public /* synthetic */ b(d.k0.d.p pVar) {
            this();
        }
    }

    a(int i2, String str) {
        this.f12882c = i2;
        this.f12883d = str;
    }

    public final boolean contains(char c2) {
        return Character.getType(c2) == this.f12882c;
    }

    public final String getCode() {
        return this.f12883d;
    }

    public final int getValue() {
        return this.f12882c;
    }
}
