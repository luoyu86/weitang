package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class BizcardResultParser extends AbstractDoCoMoResultParser {
    private static String buildName(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        return str + ' ' + str2;
    }

    private static String[] buildPhoneNumbers(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList(3);
        if (str != null) {
            arrayList.add(str);
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (str3 != null) {
            arrayList.add(str3);
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[size]);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        String text = result.getText();
        if (!text.startsWith("BIZCARD:")) {
            return null;
        }
        String strBuildName = buildName(AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("N:", text, true), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("X:", text, true));
        String strMatchSingleDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("T:", text, true);
        String strMatchSingleDoCoMoPrefixedField2 = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("C:", text, true);
        return new AddressBookParsedResult(ResultParser.maybeWrap(strBuildName), null, buildPhoneNumbers(AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("B:", text, true), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("M:", text, true), AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("F:", text, true)), null, ResultParser.maybeWrap(AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("E:", text, true)), null, null, null, AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("A:", text, true), null, strMatchSingleDoCoMoPrefixedField2, null, strMatchSingleDoCoMoPrefixedField, null);
    }
}
