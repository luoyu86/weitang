package d.p0;

/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f12938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f12939b = new o();

    static {
        String str = "[eE][+-]?(\\p{Digit}+)";
        f12938a = new l("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }
}
