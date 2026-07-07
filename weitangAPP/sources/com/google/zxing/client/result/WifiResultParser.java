package com.google.zxing.client.result;

import com.google.zxing.Result;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiResultParser extends ResultParser {
    @Override // com.google.zxing.client.result.ResultParser
    public WifiParsedResult parse(Result result) {
        String strMatchSinglePrefixedField;
        String text = result.getText();
        if (!text.startsWith("WIFI:") || (strMatchSinglePrefixedField = ResultParser.matchSinglePrefixedField("S:", text, ';', false)) == null || strMatchSinglePrefixedField.length() == 0) {
            return null;
        }
        String strMatchSinglePrefixedField2 = ResultParser.matchSinglePrefixedField("P:", text, ';', false);
        String strMatchSinglePrefixedField3 = ResultParser.matchSinglePrefixedField("T:", text, ';', false);
        if (strMatchSinglePrefixedField3 == null) {
            strMatchSinglePrefixedField3 = "nopass";
        }
        return new WifiParsedResult(strMatchSinglePrefixedField3, strMatchSinglePrefixedField, strMatchSinglePrefixedField2);
    }
}
