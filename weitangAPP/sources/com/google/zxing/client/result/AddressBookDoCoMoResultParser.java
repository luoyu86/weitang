package com.google.zxing.client.result;

import com.google.zxing.Result;

/* JADX INFO: loaded from: classes2.dex */
public final class AddressBookDoCoMoResultParser extends AbstractDoCoMoResultParser {
    private static String parseName(String str) {
        int iIndexOf = str.indexOf(44);
        if (iIndexOf < 0) {
            return str;
        }
        return str.substring(iIndexOf + 1) + ' ' + str.substring(0, iIndexOf);
    }

    @Override // com.google.zxing.client.result.ResultParser
    public AddressBookParsedResult parse(Result result) {
        String[] strArrMatchDoCoMoPrefixedField;
        String text = result.getText();
        if (!text.startsWith("MECARD:") || (strArrMatchDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("N:", text, true)) == null) {
            return null;
        }
        String name = parseName(strArrMatchDoCoMoPrefixedField[0]);
        String strMatchSingleDoCoMoPrefixedField = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("SOUND:", text, true);
        String[] strArrMatchDoCoMoPrefixedField2 = AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("TEL:", text, true);
        String[] strArrMatchDoCoMoPrefixedField3 = AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("EMAIL:", text, true);
        String strMatchSingleDoCoMoPrefixedField2 = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("NOTE:", text, false);
        String[] strArrMatchDoCoMoPrefixedField4 = AbstractDoCoMoResultParser.matchDoCoMoPrefixedField("ADR:", text, true);
        String strMatchSingleDoCoMoPrefixedField3 = AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("BDAY:", text, true);
        return new AddressBookParsedResult(ResultParser.maybeWrap(name), strMatchSingleDoCoMoPrefixedField, strArrMatchDoCoMoPrefixedField2, null, strArrMatchDoCoMoPrefixedField3, null, null, strMatchSingleDoCoMoPrefixedField2, strArrMatchDoCoMoPrefixedField4, null, AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("ORG:", text, true), (strMatchSingleDoCoMoPrefixedField3 == null || ResultParser.isStringOfDigits(strMatchSingleDoCoMoPrefixedField3, 8)) ? strMatchSingleDoCoMoPrefixedField3 : null, null, AbstractDoCoMoResultParser.matchSingleDoCoMoPrefixedField("URL:", text, true));
    }
}
