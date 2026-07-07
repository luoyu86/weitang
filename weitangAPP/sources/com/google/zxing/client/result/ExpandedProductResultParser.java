package com.google.zxing.client.result;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.HashMap;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class ExpandedProductResultParser extends ResultParser {
    private static String findAIvalue(int i2, String str) {
        StringBuilder sb = new StringBuilder();
        if (str.charAt(i2) != '(') {
            return null;
        }
        String strSubstring = str.substring(i2 + 1);
        for (int i3 = 0; i3 < strSubstring.length(); i3++) {
            char cCharAt = strSubstring.charAt(i3);
            if (cCharAt == ')') {
                return sb.toString();
            }
            if (cCharAt < '0' || cCharAt > '9') {
                return null;
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    private static String findValue(int i2, String str) {
        StringBuilder sb = new StringBuilder();
        String strSubstring = str.substring(i2);
        for (int i3 = 0; i3 < strSubstring.length(); i3++) {
            char cCharAt = strSubstring.charAt(i3);
            if (cCharAt != '(') {
                sb.append(cCharAt);
            } else {
                if (findAIvalue(i3, strSubstring) != null) {
                    break;
                }
                sb.append('(');
            }
        }
        return sb.toString();
    }

    @Override // com.google.zxing.client.result.ResultParser
    public ExpandedProductParsedResult parse(Result result) {
        String text;
        int i2;
        if (result.getBarcodeFormat() != BarcodeFormat.RSS_EXPANDED || (text = result.getText()) == null) {
            return null;
        }
        HashMap map = new HashMap();
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        String str7 = null;
        String str8 = null;
        String str9 = null;
        String strSubstring = null;
        String strSubstring2 = null;
        String strSubstring3 = null;
        String strSubstring4 = null;
        int i3 = 0;
        while (i3 < text.length()) {
            String strFindAIvalue = findAIvalue(i3, text);
            if (strFindAIvalue == null) {
                return null;
            }
            int length = i3 + strFindAIvalue.length() + 2;
            String str10 = strSubstring3;
            String strFindValue = findValue(length, text);
            int length2 = length + strFindValue.length();
            String str11 = text;
            if ("00".equals(strFindAIvalue)) {
                i2 = length2;
                str2 = strFindValue;
            } else if ("01".equals(strFindAIvalue)) {
                i2 = length2;
                str = strFindValue;
            } else if (AgooConstants.ACK_REMOVE_PACKAGE.equals(strFindAIvalue)) {
                i2 = length2;
                str3 = strFindValue;
            } else if (AgooConstants.ACK_BODY_NULL.equals(strFindAIvalue)) {
                i2 = length2;
                str4 = strFindValue;
            } else if (AgooConstants.ACK_FLAG_NULL.equals(strFindAIvalue)) {
                i2 = length2;
                str5 = strFindValue;
            } else if (AgooConstants.ACK_PACK_ERROR.equals(strFindAIvalue)) {
                i2 = length2;
                str6 = strFindValue;
            } else if ("17".equals(strFindAIvalue)) {
                i2 = length2;
                str7 = strFindValue;
            } else {
                i2 = length2;
                if ("3100".equals(strFindAIvalue) || "3101".equals(strFindAIvalue) || "3102".equals(strFindAIvalue) || "3103".equals(strFindAIvalue) || "3104".equals(strFindAIvalue) || "3105".equals(strFindAIvalue) || "3106".equals(strFindAIvalue) || "3107".equals(strFindAIvalue) || "3108".equals(strFindAIvalue) || "3109".equals(strFindAIvalue)) {
                    strSubstring = strFindAIvalue.substring(3);
                    str9 = ExpandedProductParsedResult.KILOGRAM;
                } else if ("3200".equals(strFindAIvalue) || "3201".equals(strFindAIvalue) || "3202".equals(strFindAIvalue) || "3203".equals(strFindAIvalue) || "3204".equals(strFindAIvalue) || "3205".equals(strFindAIvalue) || "3206".equals(strFindAIvalue) || "3207".equals(strFindAIvalue) || "3208".equals(strFindAIvalue) || "3209".equals(strFindAIvalue)) {
                    strSubstring = strFindAIvalue.substring(3);
                    str9 = ExpandedProductParsedResult.POUND;
                } else {
                    if ("3920".equals(strFindAIvalue) || "3921".equals(strFindAIvalue) || "3922".equals(strFindAIvalue) || "3923".equals(strFindAIvalue)) {
                        strSubstring2 = strFindValue;
                        strSubstring3 = strFindAIvalue.substring(3);
                    } else if (!"3930".equals(strFindAIvalue) && !"3931".equals(strFindAIvalue) && !"3932".equals(strFindAIvalue) && !"3933".equals(strFindAIvalue)) {
                        map.put(strFindAIvalue, strFindValue);
                    } else {
                        if (strFindValue.length() < 4) {
                            return null;
                        }
                        strSubstring2 = strFindValue.substring(3);
                        strSubstring4 = strFindValue.substring(0, 3);
                        strSubstring3 = strFindAIvalue.substring(3);
                    }
                    text = str11;
                    i3 = i2;
                }
                str8 = strFindValue;
                strSubstring3 = str10;
                text = str11;
                i3 = i2;
            }
            strSubstring3 = str10;
            text = str11;
            i3 = i2;
        }
        return new ExpandedProductParsedResult(str, str2, str3, str4, str5, str6, str7, str8, str9, strSubstring, strSubstring2, strSubstring3, strSubstring4, map);
    }
}
