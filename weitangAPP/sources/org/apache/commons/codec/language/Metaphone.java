package org.apache.commons.codec.language;

import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

/* JADX INFO: loaded from: classes2.dex */
public class Metaphone implements StringEncoder {
    private static final String FRONTV = "EIY";
    private static final String VARSON = "CSPTG";
    private static final String VOWELS = "AEIOU";
    private int maxCodeLen = 4;

    private boolean isLastChar(int i2, int i3) {
        return i3 + 1 == i2;
    }

    private boolean isNextChar(StringBuilder sb, int i2, char c2) {
        return i2 >= 0 && i2 < sb.length() - 1 && sb.charAt(i2 + 1) == c2;
    }

    private boolean isPreviousChar(StringBuilder sb, int i2, char c2) {
        return i2 > 0 && i2 < sb.length() && sb.charAt(i2 - 1) == c2;
    }

    private boolean isVowel(StringBuilder sb, int i2) {
        return VOWELS.indexOf(sb.charAt(i2)) >= 0;
    }

    private boolean regionMatch(StringBuilder sb, int i2, String str) {
        if (i2 < 0 || (str.length() + i2) - 1 >= sb.length()) {
            return false;
        }
        return sb.substring(i2, str.length() + i2).equals(str);
    }

    @Override // org.apache.commons.codec.Encoder
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return metaphone((String) obj);
        }
        throw new EncoderException("Parameter supplied to Metaphone encode is not of type java.lang.String");
    }

    public int getMaxCodeLen() {
        return this.maxCodeLen;
    }

    public boolean isMetaphoneEqual(String str, String str2) {
        return metaphone(str).equals(metaphone(str2));
    }

    /* JADX WARN: Removed duplicated region for block: B:132:0x020d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String metaphone(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 746
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.language.Metaphone.metaphone(java.lang.String):java.lang.String");
    }

    public void setMaxCodeLen(int i2) {
        this.maxCodeLen = i2;
    }

    @Override // org.apache.commons.codec.StringEncoder
    public String encode(String str) {
        return metaphone(str);
    }
}
