package d.p0;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LITERAL' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes2.dex */
public final class n implements g {
    public static final n CANON_EQ;
    public static final n COMMENTS;
    public static final n DOT_MATCHES_ALL;
    public static final n IGNORE_CASE;
    public static final n LITERAL;
    public static final n MULTILINE;
    public static final n UNIX_LINES;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ n[] f12935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f12937c;

    static {
        n nVar = new n("IGNORE_CASE", 0, 2, 0, 2, null);
        IGNORE_CASE = nVar;
        n nVar2 = new n("MULTILINE", 1, 8, 0, 2, null);
        MULTILINE = nVar2;
        int i2 = 0;
        int i3 = 2;
        d.k0.d.p pVar = null;
        n nVar3 = new n("LITERAL", 2, 16, i2, i3, pVar);
        LITERAL = nVar3;
        n nVar4 = new n("UNIX_LINES", 3, 1, i2, i3, pVar);
        UNIX_LINES = nVar4;
        n nVar5 = new n("COMMENTS", 4, 4, i2, i3, pVar);
        COMMENTS = nVar5;
        n nVar6 = new n("DOT_MATCHES_ALL", 5, 32, i2, i3, pVar);
        DOT_MATCHES_ALL = nVar6;
        n nVar7 = new n("CANON_EQ", 6, 128, i2, i3, pVar);
        CANON_EQ = nVar7;
        f12935a = new n[]{nVar, nVar2, nVar3, nVar4, nVar5, nVar6, nVar7};
    }

    public n(String str, int i2, int i3, int i4) {
        this.f12936b = i3;
        this.f12937c = i4;
    }

    public static n valueOf(String str) {
        return (n) Enum.valueOf(n.class, str);
    }

    public static n[] values() {
        return (n[]) f12935a.clone();
    }

    @Override // d.p0.g
    public int getMask() {
        return this.f12937c;
    }

    @Override // d.p0.g
    public int getValue() {
        return this.f12936b;
    }

    public /* synthetic */ n(String str, int i2, int i3, int i4, int i5, d.k0.d.p pVar) {
        this(str, i2, i3, (i5 & 2) != 0 ? i3 : i4);
    }
}
