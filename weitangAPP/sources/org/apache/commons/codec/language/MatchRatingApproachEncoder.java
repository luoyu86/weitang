package org.apache.commons.codec.language;

import com.qq.e.comm.managers.setting.GlobalSetting;
import com.tom_roush.fontbox.afm.AFMParser;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
import com.tom_roush.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: loaded from: classes2.dex */
public class MatchRatingApproachEncoder implements StringEncoder {
    private static final String[] DOUBLE_CONSONANT = {"BB", AFMParser.CC, "DD", "FF", "GG", "HH", "JJ", "KK", "LL", "MM", "NN", "PP", "QQ", "RR", "SS", GlobalSetting.TT_SDK_WRAPPER, AFMParser.CHARMETRICS_VV, "WW", "XX", "YY", "ZZ"};
    private static final int ELEVEN = 11;
    private static final String EMPTY = "";
    private static final int FIVE = 5;
    private static final int FOUR = 4;
    private static final int ONE = 1;
    private static final String PLAIN_ASCII = "AaEeIiOoUuAaEeIiOoUuYyAaEeIiOoUuYyAaOoNnAaEeIiOoUuYyAaCcOoUu";
    private static final int SEVEN = 7;
    private static final int SIX = 6;
    private static final String SPACE = " ";
    private static final int THREE = 3;
    private static final int TWELVE = 12;
    private static final int TWO = 2;
    private static final String UNICODE = "ÀàÈèÌìÒòÙùÁáÉéÍíÓóÚúÝýÂâÊêÎîÔôÛûŶŷÃãÕõÑñÄäËëÏïÖöÜüŸÿÅåÇçŐőŰű";

    public String cleanName(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        String[] strArr = {"\\-", "[&]", "\\'", "\\.", "[\\,]"};
        for (int i2 = 0; i2 < 5; i2++) {
            upperCase = upperCase.replaceAll(strArr[i2], "");
        }
        return removeAccents(upperCase).replaceAll("\\s+", "");
    }

    @Override // org.apache.commons.codec.Encoder
    public final Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return encode((String) obj);
        }
        throw new EncoderException("Parameter supplied to Match Rating Approach encoder is not of type java.lang.String");
    }

    public String getFirst3Last3(String str) {
        int length = str.length();
        if (length <= 6) {
            return str;
        }
        return str.substring(0, 3) + str.substring(length - 3, length);
    }

    public int getMinRating(int i2) {
        if (i2 <= 4) {
            return 5;
        }
        if (i2 <= 7) {
            return 4;
        }
        if (i2 <= 11) {
            return 3;
        }
        return i2 == 12 ? 2 : 1;
    }

    public boolean isEncodeEquals(String str, String str2) {
        if (str == null || "".equalsIgnoreCase(str) || SPACE.equalsIgnoreCase(str) || str2 == null || "".equalsIgnoreCase(str2) || SPACE.equalsIgnoreCase(str2) || str.length() == 1 || str2.length() == 1) {
            return false;
        }
        if (str.equalsIgnoreCase(str2)) {
            return true;
        }
        String strCleanName = cleanName(str);
        String strCleanName2 = cleanName(str2);
        String strRemoveVowels = removeVowels(strCleanName);
        String strRemoveVowels2 = removeVowels(strCleanName2);
        String strRemoveDoubleConsonants = removeDoubleConsonants(strRemoveVowels);
        String strRemoveDoubleConsonants2 = removeDoubleConsonants(strRemoveVowels2);
        String first3Last3 = getFirst3Last3(strRemoveDoubleConsonants);
        String first3Last32 = getFirst3Last3(strRemoveDoubleConsonants2);
        if (Math.abs(first3Last3.length() - first3Last32.length()) >= 3) {
            return false;
        }
        return leftToRightThenRightToLeftProcessing(first3Last3, first3Last32) >= getMinRating(Math.abs(first3Last3.length() + first3Last32.length()));
    }

    public boolean isVowel(String str) {
        return str.equalsIgnoreCase("E") || str.equalsIgnoreCase("A") || str.equalsIgnoreCase(PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE) || str.equalsIgnoreCase("I") || str.equalsIgnoreCase(PDBorderStyleDictionary.STYLE_UNDERLINE);
    }

    public int leftToRightThenRightToLeftProcessing(String str, String str2) {
        char[] charArray = str.toCharArray();
        char[] charArray2 = str2.toCharArray();
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        int i2 = 0;
        while (i2 < charArray.length && i2 <= length2) {
            int i3 = i2 + 1;
            String strSubstring = str.substring(i2, i3);
            int i4 = length - i2;
            String strSubstring2 = str.substring(i4, i4 + 1);
            String strSubstring3 = str2.substring(i2, i3);
            int i5 = length2 - i2;
            String strSubstring4 = str2.substring(i5, i5 + 1);
            if (strSubstring.equals(strSubstring3)) {
                charArray[i2] = ' ';
                charArray2[i2] = ' ';
            }
            if (strSubstring2.equals(strSubstring4)) {
                charArray[i4] = ' ';
                charArray2[i5] = ' ';
            }
            i2 = i3;
        }
        String strReplaceAll = new String(charArray).replaceAll("\\s+", "");
        String strReplaceAll2 = new String(charArray2).replaceAll("\\s+", "");
        return strReplaceAll.length() > strReplaceAll2.length() ? Math.abs(6 - strReplaceAll.length()) : Math.abs(6 - strReplaceAll2.length());
    }

    public String removeAccents(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            int iIndexOf = UNICODE.indexOf(cCharAt);
            if (iIndexOf > -1) {
                sb.append(PLAIN_ASCII.charAt(iIndexOf));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public String removeDoubleConsonants(String str) {
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        for (String str2 : DOUBLE_CONSONANT) {
            if (upperCase.contains(str2)) {
                upperCase = upperCase.replace(str2, str2.substring(0, 1));
            }
        }
        return upperCase;
    }

    public String removeVowels(String str) {
        String strSubstring = str.substring(0, 1);
        String strReplaceAll = str.replaceAll("A", "").replaceAll("E", "").replaceAll("I", "").replaceAll(PDAnnotationLink.HIGHLIGHT_MODE_OUTLINE, "").replaceAll(PDBorderStyleDictionary.STYLE_UNDERLINE, "").replaceAll("\\s{2,}\\b", SPACE);
        if (!isVowel(strSubstring)) {
            return strReplaceAll;
        }
        return strSubstring + strReplaceAll;
    }

    @Override // org.apache.commons.codec.StringEncoder
    public final String encode(String str) {
        return (str == null || "".equalsIgnoreCase(str) || SPACE.equalsIgnoreCase(str) || str.length() == 1) ? "" : getFirst3Last3(removeDoubleConsonants(removeVowels(cleanName(str))));
    }
}
