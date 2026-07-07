package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* JADX INFO: loaded from: classes2.dex */
public final class SMSMMSResultParser extends ResultParser {
    private static void addNumberVia(Collection<String> collection, Collection<String> collection2, String str) {
        int iIndexOf = str.indexOf(59);
        if (iIndexOf < 0) {
            collection.add(str);
            collection2.add(null);
        } else {
            collection.add(str.substring(0, iIndexOf));
            String strSubstring = str.substring(iIndexOf + 1);
            collection2.add(strSubstring.startsWith("via=") ? strSubstring.substring(4) : null);
        }
    }

    @Override // com.google.zxing.client.result.ResultParser
    public SMSParsedResult parse(Result result) {
        String str;
        String text = result.getText();
        String str2 = null;
        if (!text.startsWith("sms:") && !text.startsWith("SMS:") && !text.startsWith("mms:") && !text.startsWith("MMS:")) {
            return null;
        }
        Map<String, String> nameValuePairs = ResultParser.parseNameValuePairs(text);
        boolean z = false;
        if (nameValuePairs == null || nameValuePairs.isEmpty()) {
            str = null;
        } else {
            str2 = nameValuePairs.get("subject");
            str = nameValuePairs.get(AgooConstants.MESSAGE_BODY);
            z = true;
        }
        int iIndexOf = text.indexOf(63, 4);
        String strSubstring = (iIndexOf < 0 || !z) ? text.substring(4) : text.substring(4, iIndexOf);
        int i2 = -1;
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        while (true) {
            int i3 = i2 + 1;
            int iIndexOf2 = strSubstring.indexOf(44, i3);
            if (iIndexOf2 <= i2) {
                addNumberVia(arrayList, arrayList2, strSubstring.substring(i3));
                return new SMSParsedResult((String[]) arrayList.toArray(new String[arrayList.size()]), (String[]) arrayList2.toArray(new String[arrayList2.size()]), str2, str);
            }
            addNumberVia(arrayList, arrayList2, strSubstring.substring(i3, iIndexOf2));
            i2 = iIndexOf2;
        }
    }
}
