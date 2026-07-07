package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ResultParser {
    private static final ResultParser[] PARSERS = {new BookmarkDoCoMoResultParser(), new AddressBookDoCoMoResultParser(), new EmailDoCoMoResultParser(), new AddressBookAUResultParser(), new VCardResultParser(), new BizcardResultParser(), new VEventResultParser(), new EmailAddressResultParser(), new SMTPResultParser(), new TelResultParser(), new SMSMMSResultParser(), new SMSTOMMSTOResultParser(), new GeoResultParser(), new WifiResultParser(), new URLTOResultParser(), new URIResultParser(), new ISBNResultParser(), new ProductResultParser(), new ExpandedProductResultParser()};
    private static final Pattern DIGITS = Pattern.compile("\\d*");
    private static final Pattern ALPHANUM = Pattern.compile("[a-zA-Z0-9]*");
    private static final Pattern AMPERSAND = Pattern.compile("&");
    private static final Pattern EQUALS = Pattern.compile("=");

    private static void appendKeyValue(CharSequence charSequence, Map<String, String> map) {
        String[] strArrSplit = EQUALS.split(charSequence, 2);
        if (strArrSplit.length == 2) {
            try {
                map.put(strArrSplit[0], URLDecoder.decode(strArrSplit[1], "UTF-8"));
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public static boolean isStringOfDigits(CharSequence charSequence, int i2) {
        return charSequence != null && i2 == charSequence.length() && DIGITS.matcher(charSequence).matches();
    }

    public static boolean isSubstringOfAlphaNumeric(CharSequence charSequence, int i2, int i3) {
        int i4;
        return charSequence != null && charSequence.length() >= (i4 = i3 + i2) && ALPHANUM.matcher(charSequence.subSequence(i2, i4)).matches();
    }

    public static boolean isSubstringOfDigits(CharSequence charSequence, int i2, int i3) {
        int i4;
        return charSequence != null && charSequence.length() >= (i4 = i3 + i2) && DIGITS.matcher(charSequence.subSequence(i2, i4)).matches();
    }

    public static String[] matchPrefixedField(String str, String str2, char c2, boolean z) {
        int length = str2.length();
        ArrayList arrayList = null;
        int i2 = 0;
        while (i2 < length) {
            int iIndexOf = str2.indexOf(str, i2);
            if (iIndexOf < 0) {
                break;
            }
            int length2 = iIndexOf + str.length();
            ArrayList arrayList2 = arrayList;
            boolean z2 = true;
            int length3 = length2;
            while (z2) {
                int iIndexOf2 = str2.indexOf(c2, length3);
                if (iIndexOf2 < 0) {
                    length3 = str2.length();
                } else if (str2.charAt(iIndexOf2 - 1) == '\\') {
                    length3 = iIndexOf2 + 1;
                } else {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(3);
                    }
                    String strUnescapeBackslash = unescapeBackslash(str2.substring(length2, iIndexOf2));
                    if (z) {
                        strUnescapeBackslash = strUnescapeBackslash.trim();
                    }
                    arrayList2.add(strUnescapeBackslash);
                    length3 = iIndexOf2 + 1;
                }
                z2 = false;
            }
            i2 = length3;
            arrayList = arrayList2;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String matchSinglePrefixedField(String str, String str2, char c2, boolean z) {
        String[] strArrMatchPrefixedField = matchPrefixedField(str, str2, c2, z);
        if (strArrMatchPrefixedField == null) {
            return null;
        }
        return strArrMatchPrefixedField[0];
    }

    public static void maybeAppend(String str, StringBuilder sb) {
        if (str != null) {
            sb.append('\n');
            sb.append(str);
        }
    }

    public static String[] maybeWrap(String str) {
        if (str == null) {
            return null;
        }
        return new String[]{str};
    }

    public static int parseHexDigit(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    public static Map<String, String> parseNameValuePairs(String str) {
        int iIndexOf = str.indexOf(63);
        if (iIndexOf < 0) {
            return null;
        }
        HashMap map = new HashMap(3);
        for (String str2 : AMPERSAND.split(str.substring(iIndexOf + 1))) {
            appendKeyValue(str2, map);
        }
        return map;
    }

    public static ParsedResult parseResult(Result result) {
        for (ResultParser resultParser : PARSERS) {
            ParsedResult parsedResult = resultParser.parse(result);
            if (parsedResult != null) {
                return parsedResult;
            }
        }
        return new TextParsedResult(result.getText(), null);
    }

    public static String unescapeBackslash(String str) {
        int iIndexOf = str.indexOf(92);
        if (iIndexOf < 0) {
            return str;
        }
        int length = str.length();
        StringBuilder sb = new StringBuilder(length - 1);
        sb.append(str.toCharArray(), 0, iIndexOf);
        boolean z = false;
        while (iIndexOf < length) {
            char cCharAt = str.charAt(iIndexOf);
            if (z || cCharAt != '\\') {
                sb.append(cCharAt);
                z = false;
            } else {
                z = true;
            }
            iIndexOf++;
        }
        return sb.toString();
    }

    public abstract ParsedResult parse(Result result);

    public static void maybeAppend(String[] strArr, StringBuilder sb) {
        if (strArr != null) {
            for (String str : strArr) {
                sb.append('\n');
                sb.append(str);
            }
        }
    }
}
