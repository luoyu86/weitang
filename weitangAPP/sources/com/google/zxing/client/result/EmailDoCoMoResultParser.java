package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class EmailDoCoMoResultParser extends AbstractDoCoMoResultParser {
    private static final Pattern ATEXT_ALPHANUMERIC = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    public static boolean isBasicallyValidEmailAddress(String str) {
        return str != null && ATEXT_ALPHANUMERIC.matcher(str).matches() && str.indexOf(64) >= 0;
    }

    @Override // com.google.zxing.client.result.ResultParser
    public EmailAddressParsedResult parse(Result result) {
        String[] strArrMatchDoCoMoPrefixedField;
        String text = result.getText();
        if (!text.startsWith("MATMSG:") || (strArrMatchDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("TO:", text, true)) == null) {
            return null;
        }
        String str = strArrMatchDoCoMoPrefixedField[0];
        if (!isBasicallyValidEmailAddress(str)) {
            return null;
        }
        return new EmailAddressParsedResult(str, AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("SUB:", text, false), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("BODY:", text, false), "mailto:" + str);
    }
}
