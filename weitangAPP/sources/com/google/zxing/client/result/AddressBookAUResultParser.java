package com.google.zxing.client.result;

import com.google.zxing.Result;
import com.intelligoo.sdk.utils.BleLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class AddressBookAUResultParser extends ResultParser {
    private static String[] matchMultipleValuePrefix(String str, int i2, String str2, boolean z) {
        ArrayList arrayList = null;
        for (int i3 = 1; i3 <= i2; i3++) {
            String strMatchSinglePrefixedField = ResultParser.matchSinglePrefixedField(str + i3 + ':', str2, '\r', z);
            if (strMatchSinglePrefixedField == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList(i2);
            }
            arrayList.add(strMatchSinglePrefixedField);
        }
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        String text = result.getText();
        if (!text.contains("MEMORY") || !text.contains(BleLog.LINE_BREAK)) {
            return null;
        }
        String strMatchSinglePrefixedField = ResultParser.matchSinglePrefixedField("NAME1:", text, '\r', true);
        String strMatchSinglePrefixedField2 = ResultParser.matchSinglePrefixedField("NAME2:", text, '\r', true);
        String[] strArrMatchMultipleValuePrefix = matchMultipleValuePrefix("TEL", 3, text, true);
        String[] strArrMatchMultipleValuePrefix2 = matchMultipleValuePrefix("MAIL", 3, text, true);
        String strMatchSinglePrefixedField3 = ResultParser.matchSinglePrefixedField("MEMORY:", text, '\r', false);
        String strMatchSinglePrefixedField4 = ResultParser.matchSinglePrefixedField("ADD:", text, '\r', true);
        return new AddressBookParsedResult(ResultParser.maybeWrap(strMatchSinglePrefixedField), strMatchSinglePrefixedField2, strArrMatchMultipleValuePrefix, null, strArrMatchMultipleValuePrefix2, null, null, strMatchSinglePrefixedField3, strMatchSinglePrefixedField4 != null ? new String[]{strMatchSinglePrefixedField4} : null, null, null, null, null, null);
    }
}
