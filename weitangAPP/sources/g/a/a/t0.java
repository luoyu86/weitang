package g.a.a;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class t0 {
    public static l0 a(l0 l0Var, int i2, int i3) {
        if (l0Var.hasTag(i2, i3)) {
            return l0Var;
        }
        throw new IllegalStateException("Expected " + getTagText(i2, i3) + " tag but found " + getTagText(l0Var));
    }

    public static m0 b(m0 m0Var, int i2, int i3) {
        if (m0Var.hasTag(i2, i3)) {
            return m0Var;
        }
        throw new IllegalStateException("Expected " + getTagText(i2, i3) + " tag but found " + getTagText(m0Var));
    }

    public static a0 getBaseUniversal(l0 l0Var, int i2, int i3, boolean z, int i4) {
        return a(l0Var, i2, i3).getBaseUniversal(z, i4);
    }

    public static a0 getContextBaseUniversal(l0 l0Var, int i2, boolean z, int i3) {
        return getBaseUniversal(l0Var, 128, i2, z, i3);
    }

    public static t getExplicitBaseObject(l0 l0Var, int i2, int i3) {
        return a(l0Var, i2, i3).getExplicitBaseObject();
    }

    public static l0 getExplicitBaseTagged(l0 l0Var, int i2, int i3) {
        return a(l0Var, i2, i3).getExplicitBaseTagged();
    }

    public static t getExplicitContextBaseObject(l0 l0Var, int i2) {
        return getExplicitBaseObject(l0Var, 128, i2);
    }

    public static l0 getExplicitContextBaseTagged(l0 l0Var, int i2) {
        return getExplicitBaseTagged(l0Var, 128, i2);
    }

    public static l0 getImplicitBaseTagged(l0 l0Var, int i2, int i3, int i4, int i5) {
        return a(l0Var, i2, i3).getImplicitBaseTagged(i4, i5);
    }

    public static l0 getImplicitContextBaseTagged(l0 l0Var, int i2, int i3, int i4) {
        return getImplicitBaseTagged(l0Var, 128, i2, i3, i4);
    }

    public static String getTagText(int i2, int i3) {
        StringBuilder sb;
        String str;
        if (i2 == 64) {
            sb = new StringBuilder();
            str = "[APPLICATION ";
        } else if (i2 == 128) {
            sb = new StringBuilder();
            str = "[CONTEXT ";
        } else if (i2 != 192) {
            sb = new StringBuilder();
            str = "[UNIVERSAL ";
        } else {
            sb = new StringBuilder();
            str = "[PRIVATE ";
        }
        sb.append(str);
        sb.append(i3);
        sb.append("]");
        return sb.toString();
    }

    public static String getTagText(l0 l0Var) {
        return getTagText(l0Var.getTagClass(), l0Var.getTagNo());
    }

    public static String getTagText(m0 m0Var) {
        return getTagText(m0Var.getTagClass(), m0Var.getTagNo());
    }

    public static g parseBaseUniversal(m0 m0Var, int i2, int i3, boolean z, int i4) throws IOException {
        return b(m0Var, i2, i3).parseBaseUniversal(z, i4);
    }

    public static g parseContextBaseUniversal(m0 m0Var, int i2, boolean z, int i3) throws IOException {
        return parseBaseUniversal(m0Var, 128, i2, z, i3);
    }

    public static g parseExplicitBaseObject(m0 m0Var, int i2, int i3) throws IOException {
        return b(m0Var, i2, i3).parseExplicitBaseObject();
    }

    public static m0 parseExplicitBaseTagged(m0 m0Var, int i2, int i3) throws IOException {
        return b(m0Var, i2, i3).parseExplicitBaseTagged();
    }

    public static g parseExplicitContextBaseObject(m0 m0Var, int i2) throws IOException {
        return parseExplicitBaseObject(m0Var, 128, i2);
    }

    public static m0 parseExplicitContextBaseTagged(m0 m0Var, int i2) throws IOException {
        return parseExplicitBaseTagged(m0Var, 128, i2);
    }

    public static m0 parseImplicitBaseTagged(m0 m0Var, int i2, int i3, int i4, int i5) throws IOException {
        return b(m0Var, i2, i3).parseImplicitBaseTagged(i4, i5);
    }

    public static m0 parseImplicitContextBaseTagged(m0 m0Var, int i2, int i3, int i4) throws IOException {
        return parseImplicitBaseTagged(m0Var, 128, i2, i3, i4);
    }

    public static a0 tryGetBaseUniversal(l0 l0Var, int i2, int i3, boolean z, int i4) {
        if (l0Var.hasTag(i2, i3)) {
            return l0Var.getBaseUniversal(z, i4);
        }
        return null;
    }

    public static a0 tryGetContextBaseUniversal(l0 l0Var, int i2, boolean z, int i3) {
        return tryGetBaseUniversal(l0Var, 128, i2, z, i3);
    }

    public static t tryGetExplicitBaseObject(l0 l0Var, int i2, int i3) {
        if (l0Var.hasTag(i2, i3)) {
            return l0Var.getExplicitBaseObject();
        }
        return null;
    }

    public static l0 tryGetExplicitBaseTagged(l0 l0Var, int i2, int i3) {
        if (l0Var.hasTag(i2, i3)) {
            return l0Var.getExplicitBaseTagged();
        }
        return null;
    }

    public static t tryGetExplicitContextBaseObject(l0 l0Var, int i2) {
        return tryGetExplicitBaseObject(l0Var, 128, i2);
    }

    public static l0 tryGetExplicitContextBaseTagged(l0 l0Var, int i2) {
        return tryGetExplicitBaseTagged(l0Var, 128, i2);
    }

    public static l0 tryGetImplicitBaseTagged(l0 l0Var, int i2, int i3, int i4, int i5) {
        if (l0Var.hasTag(i2, i3)) {
            return l0Var.getImplicitBaseTagged(i4, i5);
        }
        return null;
    }

    public static l0 tryGetImplicitContextBaseTagged(l0 l0Var, int i2, int i3, int i4) {
        return tryGetImplicitBaseTagged(l0Var, 128, i2, i3, i4);
    }

    public static g tryParseBaseUniversal(m0 m0Var, int i2, int i3, boolean z, int i4) throws IOException {
        if (m0Var.hasTag(i2, i3)) {
            return m0Var.parseBaseUniversal(z, i4);
        }
        return null;
    }

    public static g tryParseContextBaseUniversal(m0 m0Var, int i2, boolean z, int i3) throws IOException {
        return tryParseBaseUniversal(m0Var, 128, i2, z, i3);
    }

    public static g tryParseExplicitBaseObject(m0 m0Var, int i2, int i3) throws IOException {
        if (m0Var.hasTag(i2, i3)) {
            return m0Var.parseExplicitBaseObject();
        }
        return null;
    }

    public static m0 tryParseExplicitBaseTagged(m0 m0Var, int i2, int i3) throws IOException {
        if (m0Var.hasTag(i2, i3)) {
            return m0Var.parseExplicitBaseTagged();
        }
        return null;
    }

    public static g tryParseExplicitContextBaseObject(m0 m0Var, int i2) throws IOException {
        return tryParseExplicitBaseObject(m0Var, 128, i2);
    }

    public static m0 tryParseExplicitContextBaseTagged(m0 m0Var, int i2) throws IOException {
        return tryParseExplicitBaseTagged(m0Var, 128, i2);
    }

    public static m0 tryParseImplicitBaseTagged(m0 m0Var, int i2, int i3, int i4, int i5) throws IOException {
        if (m0Var.hasTag(i2, i3)) {
            return m0Var.parseImplicitBaseTagged(i4, i5);
        }
        return null;
    }

    public static m0 tryParseImplicitContextBaseTagged(m0 m0Var, int i2, int i3, int i4) throws IOException {
        return tryParseImplicitBaseTagged(m0Var, 128, i2, i3, i4);
    }
}
