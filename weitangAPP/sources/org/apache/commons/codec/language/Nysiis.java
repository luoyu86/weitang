package org.apache.commons.codec.language;

import java.util.regex.Pattern;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: loaded from: classes2.dex */
public class Nysiis implements StringEncoder {
    private static final char SPACE = ' ';
    private static final int TRUE_LENGTH = 6;
    private final boolean strict;
    private static final char[] CHARS_A = {'A'};
    private static final char[] CHARS_AF = {'A', 'F'};
    private static final char[] CHARS_C = {'C'};
    private static final char[] CHARS_FF = {'F', 'F'};
    private static final char[] CHARS_G = {'G'};
    private static final char[] CHARS_N = {'N'};
    private static final char[] CHARS_NN = {'N', 'N'};
    private static final char[] CHARS_S = {'S'};
    private static final char[] CHARS_SSS = {'S', 'S', 'S'};
    private static final Pattern PAT_MAC = Pattern.compile("^MAC");
    private static final Pattern PAT_KN = Pattern.compile("^KN");
    private static final Pattern PAT_K = Pattern.compile("^K");
    private static final Pattern PAT_PH_PF = Pattern.compile("^(PH|PF)");
    private static final Pattern PAT_SCH = Pattern.compile("^SCH");
    private static final Pattern PAT_EE_IE = Pattern.compile("(EE|IE)$");
    private static final Pattern PAT_DT_ETC = Pattern.compile("(DT|RT|RD|NT|ND)$");

    public Nysiis() {
        this(true);
    }

    private static boolean isVowel(char c2) {
        return c2 == 'A' || c2 == 'E' || c2 == 'I' || c2 == 'O' || c2 == 'U';
    }

    private static char[] transcodeRemaining(char c2, char c3, char c4, char c5) {
        return (c3 == 'E' && c4 == 'V') ? CHARS_AF : isVowel(c3) ? CHARS_A : c3 == 'Q' ? CHARS_G : c3 == 'Z' ? CHARS_S : c3 == 'M' ? CHARS_N : c3 == 'K' ? c4 == 'N' ? CHARS_NN : CHARS_C : (c3 == 'S' && c4 == 'C' && c5 == 'H') ? CHARS_SSS : (c3 == 'P' && c4 == 'H') ? CHARS_FF : (c3 != 'H' || (isVowel(c2) && isVowel(c4))) ? (c3 == 'W' && isVowel(c2)) ? new char[]{c2} : new char[]{c3} : new char[]{c2};
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return nysiis((String) obj);
        }
        throw new EncoderException("Parameter supplied to Nysiis encode is not of type java.lang.String");
    }

    public boolean isStrict() {
        return this.strict;
    }

    public String nysiis(String str) {
        if (str == null) {
            return null;
        }
        String strClean = SoundexUtils.clean(str);
        if (strClean.length() == 0) {
            return strClean;
        }
        String strReplaceFirst = PAT_DT_ETC.matcher(PAT_EE_IE.matcher(PAT_SCH.matcher(PAT_PH_PF.matcher(PAT_K.matcher(PAT_KN.matcher(PAT_MAC.matcher(strClean).replaceFirst("MCC")).replaceFirst("NN")).replaceFirst("C")).replaceFirst("FF")).replaceFirst("SSS")).replaceFirst("Y")).replaceFirst("D");
        StringBuilder sb = new StringBuilder(strReplaceFirst.length());
        sb.append(strReplaceFirst.charAt(0));
        char[] charArray = strReplaceFirst.toCharArray();
        int length = charArray.length;
        int i2 = 1;
        while (i2 < length) {
            int i3 = length - 1;
            char c2 = SPACE;
            char c3 = i2 < i3 ? charArray[i2 + 1] : SPACE;
            if (i2 < length - 2) {
                c2 = charArray[i2 + 2];
            }
            int i4 = i2 - 1;
            char[] cArrTranscodeRemaining = transcodeRemaining(charArray[i4], charArray[i2], c3, c2);
            System.arraycopy(cArrTranscodeRemaining, 0, charArray, i2, cArrTranscodeRemaining.length);
            if (charArray[i2] != charArray[i4]) {
                sb.append(charArray[i2]);
            }
            i2++;
        }
        if (sb.length() > 1) {
            char cCharAt = sb.charAt(sb.length() - 1);
            if (cCharAt == 'S') {
                sb.deleteCharAt(sb.length() - 1);
                cCharAt = sb.charAt(sb.length() - 1);
            }
            if (sb.length() > 2 && sb.charAt(sb.length() - 2) == 'A' && cCharAt == 'Y') {
                sb.deleteCharAt(sb.length() - 2);
            }
            if (cCharAt == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        String string = sb.toString();
        return isStrict() ? string.substring(0, Math.min(6, string.length())) : string;
    }

    public Nysiis(boolean z) {
        this.strict = z;
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return nysiis(str);
    }
}
