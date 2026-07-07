package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class EmailAddressResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        String str;
        String text = result.getText();
        String str2 = null;
        if (!text.startsWith("mailto:") && !text.startsWith("MAILTO:")) {
            if (!EmailDoCoMoResultParser.isBasicallyValidEmailAddress(text)) {
                return null;
            }
            return new EmailAddressParsedResult(text, null, null, "mailto:" + text);
        }
        String strSubstring = text.substring(7);
        int iIndexOf = strSubstring.indexOf(63);
        if (iIndexOf >= 0) {
            strSubstring = strSubstring.substring(0, iIndexOf);
        }
        Map<String, String> nameValuePairs = ResultParser.parseNameValuePairs(text);
        if (nameValuePairs != null) {
            if (strSubstring.length() == 0) {
                strSubstring = nameValuePairs.get("to");
            }
            str2 = nameValuePairs.get("subject");
            str = nameValuePairs.get(AgooConstants.MESSAGE_BODY);
        } else {
            str = null;
        }
        return new EmailAddressParsedResult(strSubstring, str2, str, text);
    }
}
