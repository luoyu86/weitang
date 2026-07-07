package com.tom_roush.pdfbox.pdmodel.encryption;

import java.nio.CharBuffer;
import java.text.Normalizer;

/* JADX INFO: loaded from: classes2.dex */
public class SaslPrep {
    private SaslPrep() {
    }

    private static boolean asciiControl(char c2) {
        return (c2 >= 0 && c2 <= 31) || c2 == 127;
    }

    private static boolean changeDisplayProperties(int i2) {
        return i2 == 832 || i2 == 833 || i2 == 8206 || i2 == 8207 || i2 == 8234 || i2 == 8235 || i2 == 8236 || i2 == 8237 || i2 == 8238 || i2 == 8298 || i2 == 8299 || i2 == 8300 || i2 == 8301 || i2 == 8302 || i2 == 8303;
    }

    private static boolean inappropriateForCanonical(int i2) {
        return 12272 <= i2 && i2 <= 12283;
    }

    private static boolean inappropriateForPlainText(int i2) {
        return i2 == 65529 || i2 == 65530 || i2 == 65531 || i2 == 65532 || i2 == 65533;
    }

    private static boolean mappedToNothing(char c2) {
        return c2 == 173 || c2 == 847 || c2 == 6150 || c2 == 6155 || c2 == 6156 || c2 == 6157 || c2 == 8203 || c2 == 8204 || c2 == 8205 || c2 == 8288 || (65024 <= c2 && c2 <= 65039) || c2 == 65279;
    }

    private static boolean nonAsciiControl(int i2) {
        return (128 <= i2 && i2 <= 159) || i2 == 1757 || i2 == 1807 || i2 == 6158 || i2 == 8204 || i2 == 8205 || i2 == 8232 || i2 == 8233 || i2 == 8288 || i2 == 8289 || i2 == 8290 || i2 == 8291 || (8298 <= i2 && i2 <= 8303) || i2 == 65279 || ((65529 <= i2 && i2 <= 65532) || (119155 <= i2 && i2 <= 119162));
    }

    private static boolean nonAsciiSpace(char c2) {
        return c2 == 160 || c2 == 5760 || (8192 <= c2 && c2 <= 8203) || c2 == 8239 || c2 == 8287 || c2 == 12288;
    }

    private static boolean nonCharacterCodePoint(int i2) {
        return (64976 <= i2 && i2 <= 65007) || (65534 <= i2 && i2 <= 65535) || ((131070 <= i2 && i2 <= 131071) || ((196606 <= i2 && i2 <= 196607) || ((262142 <= i2 && i2 <= 262143) || ((327678 <= i2 && i2 <= 327679) || ((393214 <= i2 && i2 <= 393215) || ((458750 <= i2 && i2 <= 458751) || ((524286 <= i2 && i2 <= 524287) || ((589822 <= i2 && i2 <= 589823) || ((655358 <= i2 && i2 <= 655359) || ((720894 <= i2 && i2 <= 720895) || ((786430 <= i2 && i2 <= 786431) || ((851966 <= i2 && i2 <= 851967) || ((917502 <= i2 && i2 <= 917503) || ((983038 <= i2 && i2 <= 983039) || ((1048574 <= i2 && i2 <= 1048575) || (1114110 <= i2 && i2 <= 1114111))))))))))))))));
    }

    private static boolean privateUse(int i2) {
        return (57344 <= i2 && i2 <= 63743) || (983040 <= i2 && i2 <= 1048573) || (1048576 <= i2 && i2 <= 1114109);
    }

    public static boolean prohibited(int i2) {
        char c2 = (char) i2;
        return nonAsciiSpace(c2) || asciiControl(c2) || nonAsciiControl(i2) || privateUse(i2) || nonCharacterCodePoint(i2) || surrogateCodePoint(i2) || inappropriateForPlainText(i2) || inappropriateForCanonical(i2) || changeDisplayProperties(i2) || tagging(i2);
    }

    private static String saslPrep(String str, boolean z) {
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (nonAsciiSpace(str.charAt(i2))) {
                charArray[i2] = ' ';
            }
        }
        int i3 = 0;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char c2 = charArray[i4];
            if (!mappedToNothing(c2)) {
                charArray[i3] = c2;
                i3++;
            }
        }
        String strNormalize = Normalizer.normalize(CharBuffer.wrap(charArray, 0, i3), Normalizer.Form.NFKC);
        int iCharCount = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        while (iCharCount < strNormalize.length()) {
            int iCodePointAt = strNormalize.codePointAt(iCharCount);
            if (prohibited(iCodePointAt)) {
                throw new IllegalArgumentException("Prohibited character " + iCodePointAt + " at position " + iCharCount);
            }
            byte directionality = Character.getDirectionality(iCodePointAt);
            boolean z5 = directionality == 1 || directionality == 2;
            z2 |= z5;
            z3 |= directionality == 0;
            z4 |= iCharCount == 0 && z5;
            if (!z && !Character.isDefined(iCodePointAt)) {
                throw new IllegalArgumentException("Character at position " + iCharCount + " is unassigned");
            }
            iCharCount += Character.charCount(iCodePointAt);
            if (z4 && iCharCount >= strNormalize.length() && !z5) {
                throw new IllegalArgumentException("First character is RandALCat, but last character is not");
            }
        }
        if (z2 && z3) {
            throw new IllegalArgumentException("Contains both RandALCat characters and LCat characters");
        }
        return strNormalize;
    }

    public static String saslPrepQuery(String str) {
        return saslPrep(str, true);
    }

    public static String saslPrepStored(String str) {
        return saslPrep(str, false);
    }

    private static boolean surrogateCodePoint(int i2) {
        return 55296 <= i2 && i2 <= 57343;
    }

    private static boolean tagging(int i2) {
        return i2 == 917505 || (917536 <= i2 && i2 <= 917631);
    }
}
