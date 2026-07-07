package d.p0;

import d.g0.q0;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public enum b {
    UNDEFINED(-1),
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1),
    RIGHT_TO_LEFT_ARABIC(2),
    EUROPEAN_NUMBER(3),
    EUROPEAN_NUMBER_SEPARATOR(4),
    EUROPEAN_NUMBER_TERMINATOR(5),
    ARABIC_NUMBER(6),
    COMMON_NUMBER_SEPARATOR(7),
    NONSPACING_MARK(8),
    BOUNDARY_NEUTRAL(9),
    PARAGRAPH_SEPARATOR(10),
    SEGMENT_SEPARATOR(11),
    WHITESPACE(12),
    OTHER_NEUTRALS(13),
    LEFT_TO_RIGHT_EMBEDDING(14),
    LEFT_TO_RIGHT_OVERRIDE(15),
    RIGHT_TO_LEFT_EMBEDDING(16),
    RIGHT_TO_LEFT_OVERRIDE(17),
    POP_DIRECTIONAL_FORMAT(18);


    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12894c;
    public static final C0243b Companion = new C0243b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d.g f12893b = d.i.lazy(a.INSTANCE);

    public static final class a extends d.k0.d.u implements d.k0.c.a<Map<Integer, ? extends b>> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // d.k0.c.a
        public final Map<Integer, ? extends b> invoke() {
            b[] bVarArrValues = b.values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(d.m0.p.coerceAtLeast(q0.mapCapacity(bVarArrValues.length), 16));
            for (b bVar : bVarArrValues) {
                linkedHashMap.put(Integer.valueOf(bVar.getValue()), bVar);
            }
            return linkedHashMap;
        }
    }

    /* JADX INFO: renamed from: d.p0.b$b, reason: collision with other inner class name */
    public static final class C0243b {
        public C0243b() {
        }

        public final Map<Integer, b> a() {
            d.g gVar = b.f12893b;
            C0243b c0243b = b.Companion;
            return (Map) gVar.getValue();
        }

        public final b valueOf(int i2) {
            b bVar = a().get(Integer.valueOf(i2));
            if (bVar != null) {
                return bVar;
            }
            throw new IllegalArgumentException("Directionality #" + i2 + " is not defined.");
        }

        public /* synthetic */ C0243b(d.k0.d.p pVar) {
            this();
        }
    }

    b(int i2) {
        this.f12894c = i2;
    }

    public final int getValue() {
        return this.f12894c;
    }
}
