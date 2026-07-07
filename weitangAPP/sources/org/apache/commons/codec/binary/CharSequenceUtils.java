package org.apache.commons.codec.binary;

/* JADX INFO: loaded from: classes2.dex */
public class CharSequenceUtils {
    public static boolean regionMatches(CharSequence charSequence, boolean z, int i2, CharSequence charSequence2, int i3, int i4) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z, i2, (String) charSequence2, i3, i4);
        }
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return true;
            }
            int i6 = i2 + 1;
            char cCharAt = charSequence.charAt(i2);
            int i7 = i3 + 1;
            char cCharAt2 = charSequence2.charAt(i3);
            if (cCharAt != cCharAt2) {
                if (!z) {
                    return false;
                }
                if (Character.toUpperCase(cCharAt) != Character.toUpperCase(cCharAt2) && Character.toLowerCase(cCharAt) != Character.toLowerCase(cCharAt2)) {
                    return false;
                }
            }
            i2 = i6;
            i4 = i5;
            i3 = i7;
        }
    }
}
